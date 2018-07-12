package cz.etn.emailvalidator.lists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by TPa on 10.07.18.
 */
public class ValidServers {
	public static final Set<String> validServersList = new HashSet<>(Arrays.asList(
			"seznam.cz",
			"gmail.com",
			"email.cz",
			"me.com",
			"azet.sk",
			"zoznam.sk",
			"wp.pl",
			"interia.pl"
	));
}
