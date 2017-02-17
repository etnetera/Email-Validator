import cz.etn.emailvalidator.Email;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by TPa on 14.02.17.
 */
public class IsValidTest {

	private static final String[] validEmails = {
			"daniel.dvorak@etnetera.cz",
			"prettyandsimple@example.com",
			"very.common@example.com",
			"disposable.style.email.with+symbol@example.com",
			"other.email-with-dash@example.com",
			"x@example.com",// (one-letter local-part)
			"\"much.more unusual\"@example.com",
			"\"very.unusual.@.unusual.com\"@example.com",
			"\"very.(),:;<>[]\\\".VERY.\\\"very@\\\\ \\\"very\\\".unusual\"@strange.example.com",
			"example-indeed@strange-example.com",
			"admin@mailserver1",// (local domain name with no TLD)
			"#!$%&'*+-/=?^_`{}|~@example.org",
			"\"()<>[]:,;@\\\\\"!#$%&'-/=?^_`{}| ~.a\"@example.org",
			"\" \"@example.org",//(space between the quotes)
			"example@localhost",// (sent from localhost)
			"example@s.solutions",// (see the List of Internet top-level domains)
			"user@localserver",
			"user@tt",//(although ICANN highly discourages dotless email addresses)
			//"user@[IPv6:2001:DB8::1]"
			"abc.\"defghi\".xyz@example.com",
			"\"abcdefghixyz\"@example.com"
	};
	private static final String[] invalidEmails = {
			"nemohotmail.com",
			"@hotmail.com",
			"nemo@",
			"nemo@@hotmail.com",
			"nem[o@hotmail.com",
			//"nemo@aol.com.com",
			"nemo@hotmail.com.",
			"nemo@hotmail.com-",
			"nemo@.hotmail.com",
			"nemo@-hotmail.com",
			".nemo@hotmail.com",
			"test.@seznam.cz",
			"Abc.example.com",//(no @ character)
			"A@b@c@example.com",// (only one @ is allowed outside quotation marks)
			"a\"b(c)d,e:f;g<h>i[j\\k]l@example.com",// (none of the special characters in this local-part are allowed outside quotation marks)
			"just\"not\"right@example.com",//(quoted strings must be dot separated or the only element making up the local-part)
			"this is\"not\\allowed@example.com",//(spaces, quotes, and backslashes may only exist when within quoted strings and preceded by a backslash)
			"this\\ still\\\"not\\\\allowed@example.com",// (even if escaped (preceded by a backslash), spaces, quotes, and backslashes must still be contained by quotes)
			"john..doe@example.com",//(double dot before @)
			"john.doe@example..com",//(double dot after @)
			".test@.test.com.",
			"test@test..com",
//				"test@test",
			"abc\\\"def\\\"ghi@example.com"
	};

	@TestFactory
	Stream<DynamicTest> testValid() {
		return DynamicTest.stream(
				Arrays.asList(validEmails).iterator(),
				email -> "Testing " + email,
				email -> assertNull(new Email(email).getError()));
	}

	@TestFactory
	Stream<DynamicTest> testInValid() {
		return DynamicTest.stream(
				Arrays.asList(invalidEmails).iterator(),
				email -> "Testing " + email,
				email -> assertNotNull(new Email(email).getError()));
	}

	@Test
	void testReal() {
		//String csvFile = "/home/tomaspavel/Plocha/fortuna_data_cz_FORUM_USER.csv";
		//String csvFile = "/home/tomaspavel/Plocha/fortuna_data_sk_FORUM_USER.csv";
		String csvFile = "/home/tomaspavel/Plocha/fortuna_data_pl_FORUM_USER.csv";
		String line;
		String cvsSplitBy = ",";
		List<String> emails = new ArrayList<>();
		int count = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null && count <= 500_000) {
				String[] user = line.split(cvsSplitBy);
				String email = user[2];
				if (email != null && !email.isEmpty()) {
					emails.add(email);
				}
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		int i = 1;
		int bad = 0;
		for (String e : emails) {
			Email val = new Email(e);
			String error = val.getError() != null ? val.getError().toString() : null;
			if (error != null) {
				System.out.println(i  + " " + error + " " + val.getEmail() );
				bad++;
			}
			i++;
		}
		System.err.println("Bad emails: " + bad);

	}
}