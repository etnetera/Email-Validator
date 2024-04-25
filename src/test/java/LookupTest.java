import cz.etn.emailvalidator.DNSLookup;
import cz.etn.emailvalidator.EmailValidatorBuilder;
import cz.etn.emailvalidator.EmailValidator;
import cz.etn.emailvalidator.entity.ValidationResult;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by tomaspavel on 16.2.17.
 */
public class LookupTest {
	private final EmailValidator validator = new EmailValidatorBuilder().build();

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
		ValidationResult result = validator.validate("karel@seznam.cz");
		assertTrue(result.email.hasMXRecord());

		result = validator.validate("karel@alza.cz");
		assertTrue(result.email.hasMXRecord());

		result = validator.validate("karel@neexistujicidomena.cz");
		assertFalse(result.email.hasMXRecord());

		result = validator.validate("karel@etnetera.cz");
		assertTrue(result.email.hasMXRecord());

		result = validator.validate("karel@site.cz");
		assertFalse(result.email.hasMXRecord());

		result = validator.validate("wjj633@126.com");
		assertTrue(result.email.hasMXRecord());

		result = validator.validate("13472668581@163.com");
		assertTrue(result.email.hasMXRecord());

		result = validator.validate("144969292@qq.cm");
		assertTrue(result.email.hasMXRecord());

		result = validator.validate("xiaokang9506@sina.com");
		assertTrue(result.email.hasMXRecord());
	}

	@Test
	void validTest() {
		EmailValidator validator = new EmailValidatorBuilder().build();
		ValidationResult result = validator.validate("test@gmail.com");
		assertTrue(result.email.isDomainInValidMailServersMap());
	}
}
