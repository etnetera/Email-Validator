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

	public EmailValidatorBuilder setSmtpPort(int smtpPort) {
		this.smtpPort = smtpPort;
		return this;
	}

	public EmailValidatorBuilder setSmtpSllPort(int smtpSllPort) {
		this.smtpSllPort = smtpSllPort;
		return this;
	}

	public EmailValidatorBuilder setCheckDns(boolean checkDns) {
		this.checkDns = checkDns;
		return this;
	}

	public EmailValidatorBuilder setDomainTypingErrors(Map<String, String> domainTypingErrors) {
		this.domainTypingErrors = domainTypingErrors;
		return this;
	}

	public EmailValidatorBuilder setGmailSuggestion(Set<String> gmailSuggestion) {
		this.gmailSuggestion = gmailSuggestion;
		return this;
	}

	public EmailValidatorBuilder setIgnoredSuggestions(Set<String> ignoredSuggestions) {
		this.ignoredSuggestions = ignoredSuggestions;
		return this;
	}

	public EmailValidatorBuilder setDisposable(List<String> disposable) {
		this.disposable = disposable;
		return this;
	}

	public EmailValidatorBuilder setDomains(Set<String> domains) {
		this.domains = domains;
		return this;
	}

	public EmailValidatorBuilder setValidServersList(Set<String> validServersList) {
		this.validServersList = validServersList;
		return this;
	}

	public EmailValidatorBuilder setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
		return this;
	}
}
