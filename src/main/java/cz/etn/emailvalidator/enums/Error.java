package cz.etn.emailvalidator.enums;

/**
 * @author DDv
 */
public enum Error {
	/**
	 * Email address is missing the "@" sign. For example: "nemohotmail.com"
	 */
	MISSING_AT("missing '@'", "adresa neobsahuje '@'"),
	/**
	 * Email address is missing the handle portion of the address. For example: "@hotmail.com"
	 */
	MISSING_USERNAME("missing username", "adresa neobsahuje jm\u00E9no (\u010D\u00E1st p\u0159ed '@')"),
	/**
	 * Email address is missing the domain portion of the address. For example: "nemo@".
	 */
	MISSING_DOMAIN("missing domain", "adresa neobsahuje dom\u00E9nu (\u010D\u00E1st za '@')"),
	/**
	 * Email address has multiple "@" signs. For example: "nemo@@hotmail.com".
	 */
	MULTIPLE_AT("multiple '@'", "adresa obsahuje '@' v\u00EDcekr\u00E1t"),
	/**
	 * Email address has prohibited characters such as a bracket "["or other unusual characters.
	 */
	BAD_CHARACTER("bad character", "adresa obsahuje zak\u00E1zan\u00E9 znaky"),
	/**
	 * Email address has multiple ‘.com’s at the end of the address. For example: "nemo@aol.com.com"
	 */
	DOUBLE_TLD("double top level domail", "adresa obsahuje v\u00EDcekr\u00E1t dom\u00E9nu prvn\u00EDho \u0159\u00E1du"),
	/**
	 * Email address is missing the top domain, or the top level domain is invalid.
	 */
	BAD_TLD("bad top level domain", "adresa obsahuje chybnou dom\u00E9nu prvn\u00EDho \u0159\u00E1du"),
	/**
	 * Email address has less than 6 characters or over 100 characters.
	 */
	BAD_LENGTH("bad length", "chybn\u00E1 d\u00E9lka adresy"),
	/**
	 * Email address does not meet RFC standards and/or has multiple errors.
	 */
	CONTAINS_MULTIPLE_TYPOS("contains multiple typos", "adresa obsahuje v\u00EDce chyb"),
	/**
	 * Email address ends with a period – For example: "nemo@hotmail.com."
	 */
	ENDS_WITH_PERIOD("ends with period", "adresa kon\u010D\u00ED te\u010Dkou"),
	/**
	 * Email address ends with a hyphen – For example: "nemo@hotmail.com-"
	 */
	ENDS_WITH_HYPHEN("ends with hyphen", "adresa kon\u010D\u00ED spojovn\u00EDkem (-)"),
	/**
	 * Email address has multiple periods in the domain. For example: "nemo@hotmail..com"
	 */
	DOUBLE_PERIOD_IN_DOMAIN("double period in domain", "adresa obsahuje zdvojenou te\u010Dku v dom\u00E9n\u011B"),
	/**
	 * Email address has multiple periods in the local part. For example: "ne..mo@hotmail.com"
	 */
	DOUBLE_PERIOD_IN_LOCAL_PART("double period in local part", "adresa obsahuje zdvojenou te\u010Dku"),
	/**
	 * Email address has a period after the '@' sign. For example: "nemo@.hotmail.com"
	 */
	PERIOD_FOLLOWING_AT("period following '@'", "adresa obsahuje te\u010Dku za '@'"),
	/**
	 * Email address has a hyphen after the '@' sign. For example: "nemo@-hotmail.com"
	 */
	HYPHEN_FOLLOWING_AT("hyphen following '@'", "adresa osahuje '-' za '@'"),
	/**
	 * Email address starts with a period. For example: ".nemo@hotmail.com"
	 */
	STARTS_WITH_A_PERIOD("starts with a period", "adresa za\u010D\u00EDn\u00E1 te\u010Dkou");
	private final String messageEn;
	private final String messageCs;

	Error(String messageEn, String messageCs) {
		this.messageEn = messageEn;
		this.messageCs = messageCs;
	}

	public String getMessageEn() {
		return messageEn;
	}

	public String getMessageCs() {
		return messageCs;
	}
}
