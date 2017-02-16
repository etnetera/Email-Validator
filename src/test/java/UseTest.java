import cz.etn.emailvalidator.Email;
import cz.etn.emailvalidator.enums.Error;
import cz.etn.emailvalidator.enums.Warning;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by tomaspavel on 15.2.17.
 */
public class UseTest {

	@Test
	void okTest() {
		Email email = new Email("karel.javor@etnetera.cz");
		boolean isValid = email.isValid();
		assertTrue(isValid);
		assertTrue(email.getWarnings().isEmpty());
		assertTrue(email.hasMXRecord());

		email = new Email("karel@gnail.com");
		isValid = email.isValid();
		List<Warning> warnings = email.getWarnings();
		assertEquals(Warning.TYPO, warnings.get(0));
		assertTrue(isValid);
		String sugestion = email.getSuggestion();
		assertEquals("karel@gmail.com", sugestion);

		email = new Email("marian.@seznam.cz");
		isValid = email.isValid();
		assertFalse(isValid);
	}

	@Test
	void typoTest() {
		Email email = new Email("karel@gnail.com");
		boolean isValid = email.isValid();
		List<Warning> warnings = email.getWarnings();
		assertEquals(Warning.TYPO, warnings.get(0));
		assertTrue(isValid);
		String sugestion = email.getSuggestion();
		assertEquals("karel@gmail.com", sugestion);

	}

	@Test
	void nokTest() {
		Email email = new Email("marian.@seznam.cz");
		boolean isValid = email.isValid();
		assertFalse(isValid);
		assertEquals(Error.BAD_CHARACTER, email.getError());
	}
}
