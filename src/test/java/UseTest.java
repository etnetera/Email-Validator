import cz.etn.emailvalidator.EmailValidator;
import cz.etn.emailvalidator.EmailValidatorBuilder;
import cz.etn.emailvalidator.Example;
import cz.etn.emailvalidator.entity.ValidationResult;
import cz.etn.emailvalidator.enums.Error;
import cz.etn.emailvalidator.enums.Warning;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by tomaspavel on 15.2.17.
 */
public class UseTest {
	private final EmailValidator validator = new EmailValidatorBuilder().build();

	@Test
	void okTest() {
		ValidationResult result = validator.validate("karel.javor@etnetera.cz");
		boolean isValid = result.isValid;
		assertTrue(isValid);
		assertTrue(result.messages.isEmpty());
		assertTrue(result.email.hasMXRecord());

		result = validator.validate("karel@gnail.com");
		isValid = result.isValid;
		List<Warning> warnings = result.email.getWarnings();
		assertEquals(Warning.TYPO, warnings.get(0));
		assertTrue(isValid);
		String sugestion = result.email.getSuggestion();
		assertEquals("karel@gmail.com", sugestion);
		assertEquals("Did you mean karel@gmail.com?", result.messages.get(0).text);

		result = validator.validate("marian.@seznam.cz");
		isValid = result.isValid;
		assertFalse(isValid);
	}

	@Test
	void typoTest() {
		ValidationResult result = validator.validate("karel@gnail.com");
		boolean isValid = result.isValid;
		List<Warning> warnings = result.email.getWarnings();
		assertEquals(Warning.TYPO, warnings.get(0));
		assertTrue(isValid);
		String sugestion = result.email.getSuggestion();
		assertEquals("karel@gmail.com", sugestion);

	}

	@Test
	void nokTest() {
		ValidationResult result = validator.validate("marian.@seznam.cz");
		boolean isValid = result.isValid;
		assertFalse(isValid);
		assertEquals(Error.BAD_CHARACTER, result.email.getError());
	}

	/*@Test //TODO
	void missingAtTest() {
		Email email = new Email("karelgmail.com");
		boolean isValid = email.isValid();
		assertEquals(Error.MISSING_AT, email.getError());
		assertFalse(isValid);
		String sugestion = email.getSuggestion();
		assertEquals("karel@gmail.com", sugestion);
	}*/

	@Test
	void nullTest() {
		ValidationResult result = validator.validate(null);
		boolean isValid = result.isValid;
		assertFalse(isValid);
	}

	@Test
	void emptyTest() {
		ValidationResult result = validator.validate("");
		boolean isValid = result.isValid;
		assertFalse(isValid);
	}

	@Test
	void exampleTest() {
		Example.main(new String[]{"test@gnail.com"});
	}

	@Test
	void builderTest() {
		EmailValidatorBuilder builder = new EmailValidatorBuilder()
		.setSmtpPort(20)
		.setSmtpSllPort(444)
		.setBundle(null)
		.setCheckDns(true)
		.setDisposable(null)
		.setDomains(null)
		.setDomainTypingErrors(null)
		.setGmailSuggestion(null)
		.setIgnoredSuggestions(null)
		.setValidServersList(null);
		builder.build();
	}
}
