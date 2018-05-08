import cz.etn.emailvalidator.DNSLookup;
import cz.etn.emailvalidator.Email;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by tomaspavel on 16.2.17.
 */
public class LookupTest {

	@Test
	@Disabled
	void ipLookupTest() {
		List<String> ips = DNSLookup.getIPAddresses("seznam.cz");
		assertFalse(ips.isEmpty());

		ips = DNSLookup.getIPAddresses("alza.cz");
		assertFalse(ips.isEmpty());

		ips = DNSLookup.getIPAddresses("www.alza.cz");
		assertFalse(ips.isEmpty());

		ips = DNSLookup.getIPAddresses("neexistujicidomena.cz");
		assertTrue(ips.isEmpty());
	}

	@Test
	@Disabled
	void mxLookupTest() {
		Email email = new Email("karel@seznam.cz");
		assertTrue(email.hasMXRecord());

		email = new Email("karel@alza.cz");
		assertTrue(email.hasMXRecord());

		email = new Email("karel@neexistujicidomena.cz");
		assertFalse(email.hasMXRecord());

		email = new Email("karel@etnetera.cz");
		assertTrue(email.hasMXRecord());

		email = new Email("karel@site.cz");
		assertFalse(email.hasMXRecord());
	}

	@Test
	void validTest() {
		Email email = new Email("test@gmail.com");
		assertTrue(email.isDomainInValidMailServersMap());
	}
}
