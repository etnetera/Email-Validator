import cz.etn.emailvalidator.I18N;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by TPa on 10.07.18.
 */
public class I18NTest {

	@Test
	void basic() {
		assertEquals("Email musí obsahovat zavináč", I18N.getTranslation("Error.MISSING_AT", Locale.forLanguageTag("cs-CZ")));
		assertEquals("Email musí obsahovať zavináč", I18N.getTranslation("Error.MISSING_AT", Locale.forLanguageTag("sk-SK")));
		assertEquals("Email musi zawierać znak", I18N.getTranslation("Error.MISSING_AT", Locale.forLanguageTag("pl-PL")));
		assertEquals("Email must contain @", I18N.getTranslation("Error.MISSING_AT", Locale.forLanguageTag("en-US")));
	}

	@Test
	void pamametrized() {
		assertEquals("Nemysleli jste {0}?", I18N.getTranslation("Warning.TYPO", Locale.forLanguageTag("cs-CZ"), (Object[]) null));
		assertEquals("Nemysleli jste test@gmail.com?", I18N.getTranslation("Warning.TYPO", Locale.forLanguageTag("cs-CZ"), "test@gmail.com"));
	}

	@Test
	void customBundle() {
		ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.forLanguageTag("cs-CZ"));
		assertEquals("Email musí obsahovat zavináč", I18N.getTranslation("Error.MISSING_AT", bundle));
	}

	@Test
	void defaultValue() {
		assertEquals("DEFAULT_KEY", I18N.getTranslation("DEFAULT_KEY", Locale.forLanguageTag("cs-CZ")));
	}
}
