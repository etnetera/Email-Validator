package cz.etn.emailvalidator.enums;

/**
 * @author DDv
 */
public enum Warning {
	/**
	 * Email address failed FreshAddress’s deliverability check. Our proprietary algorithm utilizes our knowledgebase of confirmed undeliverable email addresses and email specific activity to determine if the email address is valid and available to accept email.
	 */
	INVALID_EMAIL_ACCOUNT("invalid email account", "invalid email account", EmailState.INVALID_EMAIL_ACCOUNT),//TODO
	/**
	 * Email address is associated with a domain with inactive mail servers.
	 */
	BAD_DOMAIN("bad domain", "bad domain", EmailState.BAD_DOMAIN),//TODO
	/**
	 * Email address with a restricted handle and/or domain which is a likely suspect for being a fake or undesirable entry.
	 */
	BOGUS("bogus", "bogus", EmailState.BOGUS),//TODO
	/**
	 * Email address matches an entry on client provided suppression.
	 */
	CLIENT_RESTRICTED("client restricted", "client restricted", EmailState.CLIENT_RESTRICTED),//TODO
	/**
	 * Email address originates from a website that provides temporary email addresses.
	 */
	DISPOSABLE("disposable", "disposable", EmailState.DISPOSABLE),
	/**
	 * Email addresses belonging to DMA’s "Do Not Email List" (Electronic Mail Preference Service). Those who have registered have requested to be removed from national marketing lists.
	 */
	EMPS_SUPPRESSION("EMPS suppression", "EMPS suppression", EmailState.EMPS_SUPPRESSION),//TODO
	/**
	 * Email address owner is known to submit spam/abuse complaints.
	 */
	FREQUENT_COMPLAINER("frequent complainer", "frequent complainer", EmailState.FREQUENT_COMPLAINER),//TODO
	/**
	 * Email address failed a domain specific rule, e.g. gmail.com does not allow underscores in the address handle.
	 */
	DOMAIN_SPECIFIC_SYNTAX_ERROR("domain specific syntax error", "domain specific syntax error", EmailState.DOMAIN_SPECIFIC_SYNTAX_ERROR),//TODO
	/**
	 * Email address contains derogatory words.
	 */
	LANGUAGE("language", "language", EmailState.LANGUAGE),//TODO
	/**
	 * Email address is considered as problematic – includes spamtraps and potentially toxic addresses.
	 */
	PROBLEMATIC("problematic", "problematic", EmailState.PROBLEMATIC),//TODO
	/**
	 * Email addresses such as sales@, info@ and webmaster@.
	 */
	ROLE_ACCOUNT("role account", "role account", EmailState.ROLE_ACCOUNT),//TODO
	/**
	 * Email address originates from an FCC wireless domain.
	 */
	FFC_WIRELESS("FCC wireless", "FCC wireless", EmailState.FFC_WIRELESS),//TODO

	TYPO("typo", "typo", EmailState.TYPO);

	private final String messageEn;
	private final String messageCs;
	private final EmailState emailState;

	Warning(String messageEn, String messageCs, EmailState emailState) {
		this.messageEn = messageEn;
		this.messageCs = messageCs;
		this.emailState = emailState;
	}

	public String getMessageEn() {
		return messageEn;
	}

	public String getMessageCs() {
		return messageCs;
	}

	public EmailState getEmailState() {
		return emailState;
	}
}
