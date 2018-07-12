package cz.etn.emailvalidator.entity;

import cz.etn.emailvalidator.DNSLookup;
import cz.etn.emailvalidator.enums.Error;
import cz.etn.emailvalidator.enums.Warning;

import java.util.ArrayList;
import java.util.List;

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
public class Email {

	//TODO zakazane znaky v localPart pro seznam, google atd. https://registrace.seznam.cz/

	//private static final Logger LOG = Logger.getRootLogger();


	private String email;
	private String domain = "";
	private List<String> domains;
	private String localPart = "";
	private Error error;
	private List<Warning> warning = new ArrayList<>();
	private boolean parsed = false;
	private List<Error> errors = new ArrayList<>();
	private List<String> mxServers;
	private String suggestion;
	private boolean domainInValidMailServersMap = false;

	public Email(String email) {
		this.email = email;
	}


	public boolean isParsed() {
		return parsed;
	}

	public void setParsed(boolean parsed) {
		this.parsed = parsed;
	}

	/**
	 * @return whole email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return part of email before @
	 */
	public String getLocalPart() {
		return this.localPart;

	}

	public void setLocalPart(String localPart) {
		this.localPart = localPart;
	}

	/**
	 * @return domain after @
	 */
	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public List<String> getDomains() {
		return domains;
	}

	public void setDomains(List<String> domains) {
		this.domains = domains;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public List<Warning> getWarnings() {
		return warning;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public boolean isDomainInValidMailServersMap() {
		return domainInValidMailServersMap;
	}

	public void setDomainInValidMailServersMap(boolean domainInValidMailServersMap) {
		this.domainInValidMailServersMap = domainInValidMailServersMap;
	}


	public boolean hasMXRecord() {
		if (domain == null) {
			return false;
		}
		if (this.mxServers == null) {
			this.mxServers = DNSLookup.getMXServers(domain);
		}
		return !this.mxServers.isEmpty();
	}

	/**
	 * @return MX record for domain
	 */
	public List<String> getMXRecord() {
		if (domain == null) {
			return null;
		}
		if (this.mxServers == null) {
			this.mxServers = DNSLookup.getMXServers(domain);
		}
		return this.mxServers;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof Email) {
			return this.email.equals(((Email) obj).getEmail());
		} else {
			return obj instanceof String && this.email.equals(obj);
		}
	}


}
