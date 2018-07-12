import cz.etn.emailvalidator.EmailValidator;
import cz.etn.emailvalidator.EmailValidatorBuilder;
import cz.etn.emailvalidator.entity.ValidationResult;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by tomaspavel on 13.4.17.
 */
public class SuggestionTest {

	private static final String PREFIX = "test@";
	private static final List<TestData> testData = new ArrayList<>();
	static {
		testData.add(new TestData("op.pl", null));
		testData.add(new TestData("mail.ru", null));
		testData.add(new TestData("o2.pl", null));
		testData.add(new TestData("gnail.com", PREFIX + "gmail.com"));
		testData.add(new TestData("seznma.cz", PREFIX + "seznam.cz"));
	}

	@TestFactory
	Stream<DynamicTest> suggestionsTest() {
		return DynamicTest.stream(
				testData.iterator(),
				td -> "Testing " + td.input,
				td -> {
					EmailValidator validator = new EmailValidatorBuilder().build();
					ValidationResult validationResult = validator.validate(PREFIX + td.input);
					assertEquals(td.expected, validationResult.email.getSuggestion());
				});
	}

	static class TestData {
		final String input;
		final String expected;

		TestData(String input, String expected) {
			this.input = input;
			this.expected = expected;
		}
	}

}
