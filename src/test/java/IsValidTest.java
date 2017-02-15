import cz.etn.emailvalidator.Email;
import org.junit.jupiter.api.Test;

/**
 * Created by TPa on 14.02.17.
 */
public class IsValidTest {

	String[] validEmails = {
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
	String[] invalidEmails = {
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

	@Test
	void testValid() {
		System.out.println("Valid emails:");
		for(String email : validEmails) {
			Email e = new Email(email);
			Email.Error error = e.getError();
			if (error != null) {
				System.err.println(email + "\t\t" + error + "\t\tlocalPart: " + e.getLocalPart() + "\tdomain: " + e.getDomain() + "\t" + e.domains);

			}

		}
	}

	@Test
	void testInvalid() {
		System.out.println("\n\nInvalid emails:");
		for(String email : invalidEmails) {
			Email e = new Email(email);
			Email.Error error = e.getError();
			if(error == null) {
				System.err.println(email + "\t\t" + error + "\t\tlocalPart: " + e.getLocalPart() + "\tdomain: " + e.getDomain() + "\t" + e.domains);
			}
		}
	}
}
