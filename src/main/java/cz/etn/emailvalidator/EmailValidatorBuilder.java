package cz.etn.emailvalidator;

import cz.etn.emailvalidator.lists.Disposable;
import cz.etn.emailvalidator.lists.Suggestions;
import cz.etn.emailvalidator.lists.TopLevelDomain;
import cz.etn.emailvalidator.lists.ValidServers;

import java.util.*;

/**
 * Created by TPa on 10.07.18.
 */
public class EmailValidatorBuilder {
	private int smtpPort = 25;
	private int smtpSllPort = 465;
	private boolean checkDns = false;

	private Map<String, String> domainTypingErrors = Suggestions.DOMAIN_TYPING_ERRORS;
	private Set<String> gmailSuggestion = Suggestions.GMAIL_SUGGESTIONS;
	private Set<String> ignoredSuggestions = Suggestions.IGNORED;
	private List<String> disposable = Disposable.disposableList;
	private Set<String> domains = TopLevelDomain.domains;
	private Set<String> validServersList = ValidServers.validServersList;
	private ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.forLanguageTag("en-US"));

	public EmailValidator build() {
		return new EmailValidator(smtpPort, smtpSllPort, checkDns, domainTypingErrors, gmailSuggestion, ignoredSuggestions, disposable, domains, validServersList, bundle);
	}

	public void setSmtpPort(int smtpPort) {
		this.smtpPort = smtpPort;
	}

	public void setSmtpSllPort(int smtpSllPort) {
		this.smtpSllPort = smtpSllPort;
	}

	public void setCheckDns(boolean checkDns) {
		this.checkDns = checkDns;
	}

	public void setDomainTypingErrors(Map<String, String> domainTypingErrors) {
		this.domainTypingErrors = domainTypingErrors;
	}

	public void setGmailSuggestion(Set<String> gmailSuggestion) {
		this.gmailSuggestion = gmailSuggestion;
	}

	public void setIgnoredSuggestions(Set<String> ignoredSuggestions) {
		this.ignoredSuggestions = ignoredSuggestions;
	}

	public void setDisposable(List<String> disposable) {
		this.disposable = disposable;
	}

	public void setDomains(Set<String> domains) {
		this.domains = domains;
	}

	public void setValidServersList(Set<String> validServersList) {
		this.validServersList = validServersList;
	}

	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}
}
