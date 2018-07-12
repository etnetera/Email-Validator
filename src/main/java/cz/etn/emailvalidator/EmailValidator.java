package cz.etn.emailvalidator;

import cz.etn.emailvalidator.entity.Email;
import cz.etn.emailvalidator.entity.Message;
import cz.etn.emailvalidator.entity.ValidationResult;
import cz.etn.emailvalidator.enums.EmailPart;
import cz.etn.emailvalidator.enums.Error;
import cz.etn.emailvalidator.enums.MessageSeverity;
import cz.etn.emailvalidator.enums.Warning;
import cz.etn.emailvalidator.lists.RoleAccounts;

import java.util.*;

import static cz.etn.emailvalidator.enums.Warning.*;

public class EmailValidator {
	//The format of email addresses is local-part@domain where the local part may be up to 64 characters long and the domain
	// may have a maximum of 255 characters[2]—but the maximum of 256-character length of a forward or reverse path restricts
	// the entire email address to be no more than 254 characters long.
	private static final int MAX_LOCAL_PART_LENGTH = 64;
	private static final int MAX_DOMAIN_LENGTH = 255;
	private static final int MAX_LENGTH = 254;
	// TODO validate role accounts
	private static final List<String> PROHIBITED_ROLE_ACCOUNT_LOCAL_PARTS = new ArrayList<>(RoleAccounts.ROLE_ACCOUNT_LOCAL_PARTS);

	static {
		PROHIBITED_ROLE_ACCOUNT_LOCAL_PARTS.removeAll(RoleAccounts.ALLOWED_ROLE_ACCOUNT_LOCAL_PARTS);
	}

	private final int smtpPort;
	private final int smtpSllPort;
	private final boolean checkDns;
	private final Map<String, String> domainTypingErrors;
	private final Set<String> gmailSuggestion;
	private final Set<String> ignoredSuggestions;
	private final List<String> disposable;
	private final Set<String> domains;
	private final Set<String> validServersList;
	private final ResourceBundle messageBundle;

	@SuppressWarnings("unused")
	private EmailValidator() {
		this.smtpPort = 0;
		this.smtpSllPort = 0;
		this.checkDns = false;
		this.domainTypingErrors = new HashMap<>();
		this.gmailSuggestion = new HashSet<>();
		this.ignoredSuggestions = new HashSet<>();
		this.disposable = new ArrayList<>();
		this.domains = new HashSet<>();
		this.validServersList = new HashSet<>();
		this.messageBundle = null;
	}

	public EmailValidator(int smtpPort, int smtpSllPort, boolean checkDns, Map<String, String> domainTypingErrors, Set<String> gmailSuggestion,
						  Set<String> ignoredSuggestions, List<String> disposable, Set<String> domains, Set<String> validServersList, ResourceBundle messageBundle) {
		this.smtpPort = smtpPort;
		this.smtpSllPort = smtpSllPort;
		this.checkDns = checkDns;
		this.domainTypingErrors = domainTypingErrors;
		this.gmailSuggestion = gmailSuggestion;
		this.ignoredSuggestions = ignoredSuggestions;
		this.disposable = disposable;
		this.domains = domains;
		this.validServersList = validServersList;
		this.messageBundle = messageBundle;
	}

	public ValidationResult validate(String email) {
		Email e = new Email(email);
		boolean isValid = isValid(e);
		return new ValidationResult(isValid, constructMessages(e), e);
	}

	@SuppressWarnings("ConstantConditions")
	private List<Message> constructMessages(Email email) {
		List<Message> messages = new ArrayList<>();
		email.getErrors().forEach(e -> messages.add(new Message(MessageSeverity.ERROR, I18N.getTranslation("Error." + e.name(), messageBundle))));
		for (Warning w : email.getWarnings()) {
			switch (w) {
				case TYPO: {
					messages.add(new Message(MessageSeverity.WARNING, I18N.getTranslation("Warning." + w.name(), messageBundle, email.getSuggestion())));
					break;
				}
				default: {
					messages.add(new Message(MessageSeverity.WARNING, I18N.getTranslation("Warning." + w.name(), messageBundle)));
				}
			}
		}
		return messages;
	}

	/**
	 * @return
	 */
	private boolean isValidDomain(Email email) {
		if (!email.isParsed()) parse(email);
		if (email.getDomain() == null) {
			return false;
		}
		List<String> ips = DNSLookup.getIPAddresses(email.getDomain());
		return !ips.isEmpty();
	}

	/**
	 * Method tries to correct typos in email
	 *
	 * @return fixed email
	 */
	private String createSuggestion(Email email) {
		String localPartSuggestion = email.getLocalPart();
		String domainSuggestion = email.getDomain();

		if (email.getErrors() != null && !email.getErrors().isEmpty()) {//jsou chyby, pokusime se opravit
			for (Error e : email.getErrors()) {
				switch (e) {
					case DOUBLE_PERIOD_IN_LOCAL_PART: {
						if (localPartSuggestion != null) {
							localPartSuggestion = localPartSuggestion.replaceAll("\\.{2,}", ".");
						}
						break;
					}
					case STARTS_WITH_A_PERIOD: {
						if (localPartSuggestion != null) {
							localPartSuggestion = localPartSuggestion.replaceFirst("^\\.+", "");
						}
						break;
					}
					case BAD_CHARACTER: {
						//TODO
						break;
					}
					case DOUBLE_PERIOD_IN_DOMAIN: {
						if (domainSuggestion != null) {
							domainSuggestion = domainSuggestion.replaceAll("\\.{2,}", ".");
						}
						break;
					}
					case ENDS_WITH_HYPHEN: {
						if (domainSuggestion != null) {
							domainSuggestion = domainSuggestion.replaceFirst("-+$", "");
						}
						break;
					}
					case ENDS_WITH_PERIOD: {
						if (domainSuggestion != null) {
							domainSuggestion = domainSuggestion.replaceFirst("\\.+$", "");
						}
						break;
					}
					case HYPHEN_FOLLOWING_AT: {
						if (domainSuggestion != null) {
							domainSuggestion = domainSuggestion.replaceFirst("^-+", "");
						}
						break;
					}
					case PERIOD_FOLLOWING_AT: {
						if (domainSuggestion != null) {
							domainSuggestion = domainSuggestion.replaceFirst("^\\.+", "");
						}
						break;
					}
					default:
						//zatim nic
				}
			}
		}
		if (domainSuggestion != null && !domainSuggestion.equals(email.getDomain()))//upravili jsme domenu, zvalidujeme
		{
			domainSuggestion = getDomainSuggestion(domainSuggestion);
		} else {
			domainSuggestion = getDomainSuggestion(email.getDomain());
		}

		if (domainSuggestion != null && !domainSuggestion.equals(email.getDomain())) {
			String result = localPartSuggestion + "@" + domainSuggestion;
			if (!email.getEmail().equals(result)) {
				email.setSuggestion(result);
			}
			return result;
		}

		return null;
	}

	private String getDomainSuggestion(String domain) {
		if (domain == null || domain.isEmpty()) {
			return null;
		}

		if (ignoredSuggestions.contains(domain)) {
			return null;
		}

		if (domainTypingErrors.containsKey(domain)) {
			return domainTypingErrors.get(domain);
		}

		if (gmailSuggestion.contains(domain)) {
			return "gmail.com";
		}

		Map<String, Integer> map = new HashMap<>();
		for (String validDomain : validServersList) {
			map.put(validDomain, Utils.levenshteinDistance(validDomain, domain));
		}

		if (map.isEmpty()) {
			return null;
		}

		map = sortByValue(map);

		Map.Entry<String, Integer> entry = map.entrySet().iterator().next();
		if (entry.getValue() < 4) {
			return entry.getKey();
		} else {
			return null;
		}
	}

	/**
	 * @return true pokud je domena emailu v seznamu overenych emailu
	 */
	private boolean isDomainInValidMailServersMap(Email email) {
		if (!email.isParsed()) parse(email);

		boolean isValid = validServersList.contains(email.getDomain());
		email.setDomainInValidMailServersMap(isValid);
		return isValid;
	}

	private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
		list.sort(Comparator.comparing(o -> (o.getValue())));

		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	private void parse(Email email) {
		email.setParsed(true);
		if (email.getEmail() == null || email.getEmail().isEmpty()) {
			addError(email, Error.CONTAINS_MULTIPLE_TYPOS);
			return;
		}
		StringBuilder sb = new StringBuilder();
		StringBuilder domainStr = new StringBuilder();
		email.setDomains(new ArrayList<>());
		EmailPart part = EmailPart.LOCAL_PART;
		char lastChar = 0;
		for (char ch : email.getEmail().toCharArray()) {

			if (Utils.isAsciiDigit(ch) || Utils.isNumber(ch)) {//[a-zA-Z0-9]
				sb.append(ch);
				if (part == EmailPart.DOMAIN) {
					domainStr.append(ch);
				}
			} else if (Utils.isAt(ch)) {//@
				if (part == EmailPart.DOMAIN) {
					sb.append(ch);
					addError(email, Error.MULTIPLE_AT);
					domainStr.append(ch);
				} else if (part == EmailPart.LOCAL_PART_IN_DOUBLE_QUOTES) {//jsme v uvozovkach
					sb.append(ch);
				} else if (part == EmailPart.LOCAL_PART) {//konec local part
					email.setLocalPart(sb.toString());
					sb = new StringBuilder();
					part = EmailPart.DOMAIN;
				}
			} else if (Utils.isDot(ch)) {//tecka
				sb.append(ch);
				if (sb.length() == 1) {//ani local part ani domain nemuze zacinat teckou
					if (part == EmailPart.DOMAIN) {
						addError(email, Error.PERIOD_FOLLOWING_AT);
					} else {
						addError(email, Error.STARTS_WITH_A_PERIOD);
					}
				} else if (Utils.isDot(lastChar)) {//posledni znak byla taky tecka
					sb.append(ch);
					//nemuzou byt dve tecky v domene ani v local partu
					if (part == EmailPart.DOMAIN) {
						addError(email, Error.DOUBLE_PERIOD_IN_DOMAIN);
					} else if (part == EmailPart.LOCAL_PART) {
						addError(email, Error.DOUBLE_PERIOD_IN_LOCAL_PART);
					}
				}
				if (part == EmailPart.DOMAIN) {//v domene pridame dalsi cast domeny
					if (domainStr.length() > 0) {
						email.getDomains().add(domainStr.toString());
						domainStr = new StringBuilder();
					}
				}
			} else if (Utils.isHyphen(ch)) {//spojovnik/minus
				sb.append(ch);
				if (part == EmailPart.DOMAIN && sb.length() == 1)//spojovnik nemuze byt na zacatku domeny
				{
					addError(email, Error.HYPHEN_FOLLOWING_AT);
				}
				if (part == EmailPart.DOMAIN) {
					domainStr.append(ch);
				}
			} else if (Utils.isDoubleQuote(ch)) {//dvojite uvozovky
				sb.append(ch);
				if (part == EmailPart.DOMAIN) {//nepovoleno v domene
					addError(email, Error.BAD_CHARACTER);
					domainStr.append(ch);
				} else {//v local partu povoleno
					/*
					 * A quoted string may exist as a dot separated entity within the local-part,
					 * or it may exist when the outermost quotes are the outermost characters
					 * of the local-part (e.g., abc."defghi".xyz@example.com or "abcdefghixyz"@example.com
					 * are allowed.[citation needed] Conversely, abc"defghi"xyz@example.com is not;
					 * neither is abc\"def\"ghi@example.com).
					 */
					//TODO
					if (Utils.isBackSlash(lastChar)) {//oescapovane uvozovky
						if (part == EmailPart.LOCAL_PART) {
							addError(email, Error.BAD_CHARACTER);
						}
					} else {
						if (part == EmailPart.LOCAL_PART_IN_DOUBLE_QUOTES) {
							part = EmailPart.LOCAL_PART;
						} else {
							part = EmailPart.LOCAL_PART_IN_DOUBLE_QUOTES;
						}
					}
				}
			} else if (Utils.isSpace(ch)) {//mezera
				sb.append(ch);
				if (part == EmailPart.DOMAIN) {
					domainStr.append(ch);
				}
				if (part == EmailPart.DOMAIN || part == EmailPart.LOCAL_PART)//mezera je povolena pouze v uvozovkach
				{
					addError(email, Error.BAD_CHARACTER);
				}
			} else if (Utils.isNameSpecialCharacter(ch)) {
				sb.append(ch);
				if (part == EmailPart.DOMAIN) {
					domainStr.append(ch);
				}
				if (part == EmailPart.DOMAIN) {
					addError(email, Error.BAD_CHARACTER);
				}
			} else if (Utils.isNameQuotedSpecialCharacter(ch)) {
				sb.append(ch);
				if (part == EmailPart.DOMAIN) {
					domainStr.append(ch);
				}
				if (part != EmailPart.LOCAL_PART_IN_DOUBLE_QUOTES) {
					addError(email, Error.BAD_CHARACTER);
				}
			} else {//jiny znak
				addError(email, Error.BAD_CHARACTER);
				sb.append(ch);
				if (part == EmailPart.DOMAIN) {
					domainStr.append(ch);
				}
			}

			lastChar = ch;
		}

		if (part == EmailPart.DOMAIN) {
			email.setDomain(sb.toString());
			if (domainStr.length() > 0) {
				email.getDomains().add(domainStr.toString());
			}

		} else {
			email.setLocalPart(sb.toString());
		}

		if (email.getDomain() == null) {
			addError(email, Error.MISSING_AT);
		}

		if (email.getLocalPart().isEmpty()) {
			addError(email, Error.MISSING_USERNAME);
		}

		//kontrola na posledni znak
		if (email.getDomain() != null) {
			if (email.getDomain().isEmpty()) {
				addError(email, Error.MISSING_DOMAIN);
			}
			if (email.getDomain().endsWith(".")) {
				addError(email, Error.ENDS_WITH_PERIOD);
			}
			if (email.getDomain().endsWith("-")) {
				addError(email, Error.ENDS_WITH_HYPHEN);
			}
		}
		if (email.getLocalPart() != null) {
			if (email.getLocalPart().endsWith(".")) {
				addError(email, Error.BAD_CHARACTER);
			}
		}

		if (email.getError() == null) {
			// kontrola na delky casti
			if (email.getLocalPart().length() > MAX_LOCAL_PART_LENGTH) {
				addError(email, Error.BAD_LENGTH);
			}
			if (email.getDomain().length() > MAX_DOMAIN_LENGTH) {
				addError(email, Error.BAD_LENGTH);
			}
			if (email.getDomain().length() + email.getLocalPart().length() > MAX_LENGTH) {
				addError(email, Error.BAD_LENGTH);
			}
		}

		if (email.getError() == null) {
			if (email.getDomains() != null && !email.getDomains().isEmpty()) {
				//kontrola na delky domen
				for (String domainPart : email.getDomains()) {
					if (domainPart.length() > 63) {
						addError(email, Error.BAD_LENGTH);
					}
				}

				if (email.getDomains().size() == 1) {
					addError(email, Error.BAD_TLD);
				}

				//kontrola na TLD
				if (email.getError() == null) {
					String tldName = email.getDomains().get(email.getDomains().size() - 1);
					boolean tld = domainExists(tldName);
					if (!tld) {
//						LOG.error("unable to find TLD for: " + tldName + " in email " + this.email);
						addError(email, Error.BAD_TLD);
					}
				}
			}
		}
		email.setSuggestion(createSuggestion(email));
	}

	public boolean domainExists(String domain) {
		Objects.requireNonNull(domain);
		return domains.contains(domain.toLowerCase());
	}

	private static void addError(Email email, Error error) {
		if (error == null) {
			return;
		}
		if (email.getErrors() == null) {
			email.setErrors(new ArrayList<>());
		}

		email.getErrors().add(error);
		if (error.equals(email.getError())) {//stejne chyby nebudeme prevadet na Error.CONTAINS_MULTIPLE_TYPOS
			return;
		}

		if (email.getError() != null) {
			email.setError(Error.CONTAINS_MULTIPLE_TYPOS);
		} else {
			email.setError(error);
		}
	}

	/**
	 * @return true if the emeil is valid according to RFC 5322 and also check IP adress and MX record
	 */
	private boolean isValid(Email email) {
		if (!email.isParsed()) parse(email);
		if (email.getError() != null) {
			return false;
		}

		if (email.getDomain() == null) {
			return false;
		}

		if (email.getSuggestion() != null) {
			email.getWarnings().add(TYPO);
		}

		if (isDomainInValidMailServersMap(email)) { //domena je v seznamu jiz uspesne dorucenych mail serveru
			return true;
		}

		if (checkDns) {
			if (!isValidDomain(email)) {//je domena platna(existuje)???
				email.getWarnings().add(BAD_DOMAIN);
				return false;
			}
			if (!email.hasMXRecord()) {
				email.getWarnings().add(BAD_DOMAIN);
				return false;
			}
		}

		if (disposable.contains(email.getDomain())) {
			email.getWarnings().add(DISPOSABLE);
		}

		return true;
	}
}
