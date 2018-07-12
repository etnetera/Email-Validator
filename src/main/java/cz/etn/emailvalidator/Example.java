package cz.etn.emailvalidator;

import cz.etn.emailvalidator.entity.ValidationResult;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class Example {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Enter email for validation");
			System.exit(1);
		}
		String email = args[0];
		System.out.println("testing " + email);

		EmailValidator validator = new EmailValidatorBuilder().build();
		ValidationResult result = validator.validate(email);

		System.out.println("valid: " + result.isValid);
		System.out.println("suggestion: " + result.email.getSuggestion());
		System.out.println("ip list: " + DNSLookup.getIPAddresses(result.email.getDomain()));
		System.out.println("mx list: " + result.email.getMXRecord());
	}
}
