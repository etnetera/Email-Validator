package cz.etn.emailvalidator;

public class ServerTest {
	public static void main(String[] args) {
		String email = args[0];
		System.out.println("testuji " + email);
		Email e = new Email(email);
		System.out.println("validni: " + e.isValid());
		System.out.println("dns validni: " + e.isValid(true));
		System.out.println("ip list: " + DNSLookup.getIPAddresses(e.getDomain()));
		System.out.println("mx list: " + e.getMXRecord());
	}
}
