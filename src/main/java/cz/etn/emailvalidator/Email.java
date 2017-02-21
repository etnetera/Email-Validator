package cz.etn.emailvalidator;

import cz.etn.emailvalidator.enums.Error;
import cz.etn.emailvalidator.enums.Warning;
import cz.etn.emailvalidator.lists.Disposable;
import cz.etn.emailvalidator.lists.RoleAccounts;
import cz.etn.emailvalidator.lists.Suggestions;
import cz.etn.emailvalidator.lists.TopLevelDomain;

import javax.naming.NamingException;
import java.util.*;
import java.util.Map.Entry;

//import org.apache.log4j.Logger;

/**
 * http://stackoverflow.com/questions/2049502/what-characters-are-allowed-in-email-address
 * https://cs.wikipedia.org/wiki/Internetov%C3%A1_dom%C3%A9na
 * https://cs.wikipedia.org/wiki/Dom%C3%A9na_nejvy%C5%A1%C5%A1%C3%ADho_%C5%99%C3%A1du
 * <p>
 * <p>
 * <p>
 * The local-part of the email address may use any of these ASCII characters RFC 5322
 * · Uppercase and lowercase English letters (a–z, A–Z) (ASCII: 65-90, 97-122)
 * · Digits 0 to 9 (ASCII: 48-57)
 * · Characters !#$%&'*+-/=?^_`{|}~ (ASCII: 33, 35-39, 42, 43, 45, 47, 61, 63, 94-96, 123-126)
 * · Character . (dot, period, full stop) (ASCII: 46) provided that it is not the first or last character, and provided also that it does not appear two or more times consecutively (e.g. John..Doe@example.com is not allowed.).
 * · Special characters are allowed with restrictions. They are:
 * o Space and "(),:;<>@[] (ASCII: 32, 34, 40, 41, 44, 58, 59, 60, 62, 64, 91-93)
 * The restrictions for special characters are that they must only be used when contained between quotation marks, and that 3 of them (The space, backslash \ and quotation mark " (ASCII: 32, 92, 34)) must also be preceded by a backslash \ (e.g. "\ \\"").
 *
 * @author DDv, TPa
 */
@SuppressWarnings("JavaDoc")
public class Email {
	//=============== ATRIBUTY ==================================================
	//The format of email addresses is local-part@domain where the local part may be up to 64 characters long and the domain
	// may have a maximum of 255 characters[2]—but the maximum of 256-character length of a forward or reverse path restricts
	// the entire email address to be no more than 254 characters long.
	private static final int MAX_LOCAL_PART_LENGTH = 64;
	private static final int MAX_DOMAIN_LENGTH = 255;
	private static final int MAX_LENGTH = 254;
	public static final int SMTP_PORT = 25;
	public static final int SMTP_SSL_PORT = 465;

	private static Set<String> VALID_EMAIL_SERVERS_MAP;

//	private static final List<String> PROHIBITED_LOCAL_PARTS = Arrays.asList("sex");

	private static final List<String> PROHIBITED_ROLE_ACCOUNT_LOCAL_PARTS = new ArrayList<>(RoleAccounts.ROLE_ACCOUNT_LOCAL_PARTS);

	static {
		PROHIBITED_ROLE_ACCOUNT_LOCAL_PARTS.removeAll(RoleAccounts.ALLOWED_ROLE_ACCOUNT_LOCAL_PARTS);
	}


	//TODO zakazane znaky v localPart pro seznam, google atd. https://registrace.seznam.cz/
	//suchy-doprava@gmail.com - DOMAIN_SPECIFIC_SYNTAX_ERROR
	//macejka.martin.@gmail.com - BAD_CHARACTER
	//khun.@centrum.cz - BAD_CHARACTER
	//equi-trek-praha.@email.cz - BAD_CHARACTER
	//zr.@eurest.cz - BAD_CHARACTER
	//petr.cerman.@email.cz - BAD_CHARACTER

	//private static final Logger LOG = Logger.getRootLogger();


	private String email;
	private String domain;
	private List<String> domains;
	private String localPart;
	private Error error;
	private List<Warning> warning = new ArrayList<>();
	private boolean parsed = false;
	private List<Error> errors;
	private List<String> mxServers;
	private String suggestion;

	//============== KOSTRUKTORY A TOVARNI METODY ===============================
	public Email(String email) {
		this.email = email;
	}

	//============== VEREJNE METODY INSTANCE ====================================

	/**
	 * @return cely email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return cast emailu pred @
	 */
	public String getLocalPart() {
		if (!this.parsed) parse();
		return this.localPart;

	}

	/**
	 * @return domena za @
	 */
	public String getDomain() {
		if (!this.parsed) parse();
		return this.domain;
	}

	/**
	 * Vraci zda je validni syntax emailu dle RFC.
	 */
	public boolean isValid() {
		return isValid(false);
	}

	/**
	 * Vraci zda je validni syntax emailu dle RFC a zda ma domena IP adresu+MX zaznam. U vybranych domen neni provadeno overeni IP. (readValidDomains())
	 */
	public boolean isValid(boolean checkDNS) {
		if (!this.parsed) parse();
		if (this.error != null)//existuji errory
			return false;

		if (this.domain == null)//nemame domenu
			return false;

		if (suggestion != null) {
			this.warning.add(Warning.TYPO);
		}

		if (isDomainInValidMailServersMap()) { //domena je v seznamu jiz uspesne dorucenych mail serveru
			return true;
		}

		if (checkDNS) {
			if (!isValidDomain()) {//je domena platna(existuje)???
				this.warning.add(Warning.BAD_DOMAIN);
				return false;
			}
			if (!hasMXRecord()) {
				this.warning.add(Warning.BAD_DOMAIN);
				return false;
			}
		}

		if (Disposable.isDisposable(this.domain)) {
			this.warning.add(Warning.DISPOSABLE);
		}

		return true;
	}

	public Error getError() {
		if (!parsed) parse();
		return error;
	}

	public List<Warning> getWarnings() {
		if (!parsed) parse();
		return warning;
	}

	public String getSuggestion() {
		return suggestion;
	}

	/*
	public boolean isDomainInValidMailServersMap(Context ctx) {
		if(!parsed) parse();
		if(VALID_EMAIL_SERVERS_MAP == null) readValidDomains(ctx);
		if(domain == null || !VALID_EMAIL_SERVERS_MAP.contains(domain.toLowerCase()))
			return false;
		else
			return true;
	}*/


	/**
	 * @return
	 */
	public boolean isValidDomain() {
		if (!parsed) parse();
		if (domain == null)
			return false;
		List<String> ips = DNSLookup.getIPAddresses(domain);
		return !ips.isEmpty();
	}

	/**
	 * @return
	 * @throws NamingException
	 */
	public boolean hasMXRecord() {
		if (!parsed) parse();
		if (domain == null)
			return false;
		if (this.mxServers == null)
			this.mxServers = DNSLookup.getMXServers(domain);
		return !this.mxServers.isEmpty();
	}

	/**
	 * @return
	 */
	public List<String> getMXRecord() {
		if (!parsed) parse();
		if (domain == null)
			return null;
		if (this.mxServers == null)
			this.mxServers = DNSLookup.getMXServers(domain);
		return this.mxServers;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj instanceof Email)
			return this.email.equals(((Email) obj).getEmail());
		else
			return obj instanceof String && this.email.equals(obj);
	}


	/**
	 * Metoda se pokusi najit a opravit mozne preklepy v emailu.
	 *
	 * @return opraveny email
	 */
	private String createSuggestion() {
		String localPartSuggestion = localPart;
		String domainSuggestion = domain;

		if (this.errors != null && !this.errors.isEmpty()) {//jsou chyby, pokusime se opravit
			for (Error e : errors) {
				switch (e) {
					case DOUBLE_PERIOD_IN_LOCAL_PART: {
						if (localPartSuggestion != null)
							localPartSuggestion = localPartSuggestion.replaceAll("\\.{2,}", ".");
						break;
					}
					case STARTS_WITH_A_PERIOD: {
						if (localPartSuggestion != null)
							localPartSuggestion = localPartSuggestion.replaceFirst("^\\.+", "");
						break;
					}
					case BAD_CHARACTER: {
						//TODO
						break;
					}
					case DOUBLE_PERIOD_IN_DOMAIN: {
						if (domainSuggestion != null)
							domainSuggestion = domainSuggestion.replaceAll("\\.{2,}", ".");
						break;
					}
					case ENDS_WITH_HYPHEN: {
						if (domainSuggestion != null)
							domainSuggestion = domainSuggestion.replaceFirst("-+$", "");
						break;
					}
					case ENDS_WITH_PERIOD: {
						if (domainSuggestion != null)
							domainSuggestion = domainSuggestion.replaceFirst("\\.+$", "");
						break;
					}
					case HYPHEN_FOLLOWING_AT: {
						if (domainSuggestion != null)
							domainSuggestion = domainSuggestion.replaceFirst("^-+", "");
						break;
					}
					case PERIOD_FOLLOWING_AT: {
						if (domainSuggestion != null)
							domainSuggestion = domainSuggestion.replaceFirst("^\\.+", "");
						break;
					}
					default:
						//zatim nic
				}
			}
		}
		if (domainSuggestion != null && !domainSuggestion.equals(domain))//upravili jsme domenu, zvalidujeme
			domainSuggestion = getDomainSuggestion(domainSuggestion);
		else
			domainSuggestion = getDomainSuggestion();

		if (domainSuggestion != null && !domainSuggestion.equals(domain)) {
			String result = localPartSuggestion + "@" + domainSuggestion;
			if (!this.email.equals(result))
				this.suggestion = result;
			return result;
		}

		return null;
	}


	private String getDomainSuggestion(String domain) {
		if (!parsed) parse();
		if (domain == null || domain.length() == 0)
			return null;

		if (Suggestions.DOMAIN_TYPING_ERRORS.containsKey(domain))
			return Suggestions.DOMAIN_TYPING_ERRORS.get(domain);

		if (Suggestions.GMAIL_SUGGESTIONS.contains(domain))
			return "gmail.com";

		if (VALID_EMAIL_SERVERS_MAP == null) readValidDomains();
		Map<String, Integer> map = new HashMap<>();
		for (String validDomain : VALID_EMAIL_SERVERS_MAP) {
			map.put(validDomain, Utils.levenshteinDistance(validDomain, domain));
		}

		if (map.isEmpty())
			return null;

		map = sortByValue(map);

		Entry<String, Integer> entry = map.entrySet().iterator().next();
		if (entry.getValue() < 4)
			return entry.getKey();
		else
			return null;
	}

	private String getDomainSuggestion() {
		return getDomainSuggestion(this.domain);
	}

	/*public static String checkDomain(String domain) {
		try {
			List<String> mx = DNSLookup.getMXServers(domain);
			List<String> ip = DNSLookup.getIPAddresses(domain);
			List<String> host = new ArrayList<>();
			try {
				for (String i : ip) {
					host.add(DNSLookup.getRevName(i));
				}
			} catch (CommunicationException | NameNotFoundException ignore) {
			}
			if (!Suggestions.DOMAIN_TYPING_ERRORS.containsKey(domain))
				return "{\"" + domain + "\",\"\"},//\tMX: " + mx + "\t\tIP: " + ip + "\t\tHOST: " + host + "\nAdd to DOMAIN_TYPING_ERRORS!!!";
			else
				return "Already in DOMAIN_TYPING_ERRORS";
		} catch (Exception e) {
			//Logger.getRootLogger().error("unable to check domain " + domain, e);
		}
		return null;
	}

	public static String checkMailSever(String mailserver) {
		StringBuilder sb = new StringBuilder();
		try {
			InetAddress ia = InetAddress.getByName(mailserver);
			sb.append("checking ").append(ia).append("\n");
			Socket socket = new Socket(ia, SMTP_PORT);
			Properties mailProps = new Properties();
			mailProps.put("mail.smtp.host", mailserver);
			mailProps.put("mail.host", mailserver);
			mailProps.put("mail.smtp.port", String.valueOf(SMTP_PORT));
			SMTPTransport smtp = new SMTPTransport(Session.getInstance(mailProps), new URLName(mailserver));
			smtp.connect(socket);
			sb.append(smtp.getLastReturnCode());//http://www.serversmtp.com/en/smtp-error
			sb.append(smtp.getLastServerResponse());
		} catch (Exception e) {
			sb.append(Utils.exceptionToString(e)).append("\n");
		}
		return sb.toString();
	}*/

	/**
	 * @return true pokud je domena emailu v seznamu overenych emailu
	 */
	public boolean isDomainInValidMailServersMap() {
		if (!this.parsed) parse();
		if (VALID_EMAIL_SERVERS_MAP == null) {
			readValidDomains();
		}
		return VALID_EMAIL_SERVERS_MAP.contains(this.domain);
	}

	/**
	 * Metoda vytvori seznam overenych domen, u kterych predpokladame uspesne doruceni emailu
	 */
	public static void readValidDomains() {
		VALID_EMAIL_SERVERS_MAP = new HashSet<>();
		VALID_EMAIL_SERVERS_MAP.add("seznam.cz");
		VALID_EMAIL_SERVERS_MAP.add("gmail.com");
		VALID_EMAIL_SERVERS_MAP.add("email.cz");
		VALID_EMAIL_SERVERS_MAP.add("me.com");
		VALID_EMAIL_SERVERS_MAP.add("azet.sk");
		VALID_EMAIL_SERVERS_MAP.add("zoznam.sk");
		VALID_EMAIL_SERVERS_MAP.add("wp.pl");
		VALID_EMAIL_SERVERS_MAP.add("interia.pl");
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


	private void parse() {
		this.parsed = true;
		StringBuilder sb = new StringBuilder();
		StringBuilder domainStr = new StringBuilder();
		this.domains = new ArrayList<>();
		EmailPart part = EmailPart.LOCAL_PART;
		char lastChar = 0;
		for (char ch : this.email.toCharArray()) {

			if (Utils.isAsciiDigit(ch) || Utils.isNumber(ch)) {//[a-zA-Z0-9]
				sb.append(ch);
				if (part == EmailPart.DOMAIN)
					domainStr.append(ch);
			} else if (Utils.isAt(ch)) {//@
				if (part == EmailPart.DOMAIN) {
					sb.append(ch);
					addError(Error.MULTIPLE_AT);
					domainStr.append(ch);
				} else if (part == EmailPart.LOCAL_PART_IN_DOUBLE_QUOTES) {//jsme v uvozovkach
					sb.append(ch);
				} else if (part == EmailPart.LOCAL_PART) {//konec local part
					this.localPart = sb.toString();
					sb = new StringBuilder();
					part = EmailPart.DOMAIN;
				}
			} else if (Utils.isDot(ch)) {//tecka
				sb.append(ch);
				if (sb.length() == 1) {//ani local part ani domain nemuze zacinat teckou
					if (part == EmailPart.DOMAIN)
						addError(Error.PERIOD_FOLLOWING_AT);
					else
						addError(Error.STARTS_WITH_A_PERIOD);
				} else if (Utils.isDot(lastChar)) {//posledni znak byla taky tecka
					sb.append(ch);
					//nemuzou byt dve tecky v domene ani v local partu
					if (part == EmailPart.DOMAIN)
						addError(Error.DOUBLE_PERIOD_IN_DOMAIN);
					else if (part == EmailPart.LOCAL_PART)
						addError(Error.DOUBLE_PERIOD_IN_LOCAL_PART);
				}
				if (part == EmailPart.DOMAIN) {//v domene pridame dalsi cast domeny
					if (domainStr.length() > 0) {
						domains.add(domainStr.toString());
						domainStr = new StringBuilder();
					}
				}
			} else if (Utils.isHyphen(ch)) {//spojovnik/minus
				sb.append(ch);
				if (part == EmailPart.DOMAIN && sb.length() == 1)//spojovnik nemuze byt na zacatku domeny
					addError(Error.HYPHEN_FOLLOWING_AT);
				if (part == EmailPart.DOMAIN)
					domainStr.append(ch);
			} else if (Utils.isDoubleQuote(ch)) {//dvojite uvozovky
				sb.append(ch);
				if (part == EmailPart.DOMAIN) {//nepovoleno v domene
					addError(Error.BAD_CHARACTER);
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
						if (part == EmailPart.LOCAL_PART)
							addError(Error.BAD_CHARACTER);
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
				if (part == EmailPart.DOMAIN)
					domainStr.append(ch);
				if (part == EmailPart.DOMAIN || part == EmailPart.LOCAL_PART)//mezera je povolena pouze v uvozovkach
					addError(Error.BAD_CHARACTER);
			} else if (Utils.isNameSpecialCharacter(ch)) {
				sb.append(ch);
				if (part == EmailPart.DOMAIN)
					domainStr.append(ch);
				if (part == EmailPart.DOMAIN)
					addError(Error.BAD_CHARACTER);
			} else if (Utils.isNameQuotedSpecialCharacter(ch)) {
				sb.append(ch);
				if (part == EmailPart.DOMAIN)
					domainStr.append(ch);
				if (part != EmailPart.LOCAL_PART_IN_DOUBLE_QUOTES)
					addError(Error.BAD_CHARACTER);
			} else {//jiny znak
				addError(Error.BAD_CHARACTER);
				sb.append(ch);
				if (part == EmailPart.DOMAIN)
					domainStr.append(ch);
			}

			lastChar = ch;
		}

		if (part == EmailPart.DOMAIN) {
			this.domain = sb.toString();
			if (domainStr.length() > 0) {
				domains.add(domainStr.toString());
			}

		} else {
			this.localPart = sb.toString();
		}

		if (this.domain == null)
			addError(Error.MISSING_AT);

		if (this.localPart.isEmpty())
			addError(Error.MISSING_USERNAME);

		//kontrola na posledni znak
		if (this.domain != null) {
			if (this.domain.isEmpty())
				addError(Error.MISSING_DOMAIN);
			if (this.domain.endsWith("."))
				addError(Error.ENDS_WITH_PERIOD);
			if (this.domain.endsWith("-"))
				addError(Error.ENDS_WITH_HYPHEN);
		}
		if (this.localPart != null) {
			if (this.localPart.endsWith("."))
				addError(Error.BAD_CHARACTER);
		}

		if (this.error == null) {
			// kontrola na delky casti
			if (this.localPart.length() > MAX_LOCAL_PART_LENGTH)
				addError(Error.BAD_LENGTH);
			if (this.domain.length() > MAX_DOMAIN_LENGTH)
				addError(Error.BAD_LENGTH);
			if (this.domain.length() + this.localPart.length() > MAX_LENGTH)
				addError(Error.BAD_LENGTH);
		}

		if (this.error == null) {
			if (this.domains != null && !this.domains.isEmpty()) {
				//kontrola na delky domen
				for (String domainPart : this.domains) {
					if (domainPart.length() > 63) {
						addError(Error.BAD_LENGTH);
					}
				}

				if (this.domains.size() == 1) {
					addError(Error.BAD_TLD);
				}

				//kontrola na TLD
				if (this.error == null) {
					String tldName = this.domains.get(this.domains.size() - 1);
					boolean tld = TopLevelDomain.domainExists(tldName);
					if (!tld) {
//						LOG.error("unable to find TLD for: " + tldName + " in email " + this.email);
						addError(Error.BAD_TLD);
					}
				}
			}
		}
		this.suggestion = createSuggestion();
	}

	private void addError(Error error) {
		if (error == null)
			return;

		if (this.errors == null)
			this.errors = new ArrayList<>();

		this.errors.add(error);

		if (error.equals(this.error))//stejne chyby nebudeme prevadet na Error.CONTAINS_MULTIPLE_TYPOS
			return;

		if (this.error != null)
			this.error = Error.CONTAINS_MULTIPLE_TYPOS;
		else
			this.error = error;
	}


	//============== VNORENE A VNITRNI TRIDY ====================================

	/**
	 * @author DDv
	 */
	private enum EmailPart {
		LOCAL_PART,
		DOMAIN,
		LOCAL_PART_IN_DOUBLE_QUOTES
	}

}
