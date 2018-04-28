package cz.etn.emailvalidator;

public class Example {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Enter email for validation");
			System.exit(1);
		}
		String email = args[0];
		System.out.println("testing " + email);
		Email e = new Email(email);
		System.out.println("valid: " + e.isValid());
		System.out.println("dns valid: " + e.isValid(true));
		System.out.println("ip list: " + DNSLookup.getIPAddresses(e.getDomain()));
		System.out.println("mx list: " + e.getMXRecord());
	}
}
