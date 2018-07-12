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
		assertEquals("Email musí obsahovat zavináč", I18N.getTranslation("Error.MISSING_AT", Locale.forLanguageTag("cs_CZ")));
	}

	@Test
	void pamametrized() {
		assertEquals("Nemysleli jste {0}", I18N.getTranslation("Warning.TYPO", Locale.forLanguageTag("cs_CZ"), (Object[]) null));
		assertEquals("Nemysleli jste test@gmail.com", I18N.getTranslation("Warning.TYPO", Locale.forLanguageTag("cs_CZ"), "test@gmail.com"));
	}

	@Test
	void customBundle() {
		ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.forLanguageTag("cs_CZ"));
		assertEquals("Email musí obsahovat zavináč", I18N.getTranslation("Error.MISSING_AT", bundle));
	}

	@Test
	void defaultValue() {
		assertEquals("DEFAULT_KEY", I18N.getTranslation("DEFAULT_KEY", Locale.forLanguageTag("cs_CZ")));
	}
}
