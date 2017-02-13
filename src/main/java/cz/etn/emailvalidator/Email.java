package cz.etn.emailvalidator;

import javax.naming.CommunicationException;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.*;
import java.util.Map.Entry;

//import org.apache.log4j.Logger;

//import com.etnetera.projects.ami.helpers.Utils;

/**
 * http://stackoverflow.com/questions/2049502/what-characters-are-allowed-in-email-address
 * https://cs.wikipedia.org/wiki/Internetov%C3%A1_dom%C3%A9na
 * https://cs.wikipedia.org/wiki/Dom%C3%A9na_nejvy%C5%A1%C5%A1%C3%ADho_%C5%99%C3%A1du
 * <p>
 * <p>
 * <p>
 * The local-part of the email address may use any of these ASCII characters RFC 5322
 * · Uppercase and lowercase English letters (a–z, A–Z) (ASCII: 65-90, 97-122)
 * · Digits 0 to 9 (ASCII: 48-57)
 * · Characters !#$%&'*+-/=?^_`{|}~ (ASCII: 33, 35-39, 42, 43, 45, 47, 61, 63, 94-96, 123-126)
 * · Character . (dot, period, full stop) (ASCII: 46) provided that it is not the first or last character, and provided also that it does not appear two or more times consecutively (e.g. John..Doe@example.com is not allowed.).
 * · Special characters are allowed with restrictions. They are:
 * o Space and "(),:;<>@[] (ASCII: 32, 34, 40, 41, 44, 58, 59, 60, 62, 64, 91-93)
 * The restrictions for special characters are that they must only be used when contained between quotation marks, and that 3 of them (The space, backslash \ and quotation mark " (ASCII: 32, 92, 34)) must also be preceded by a backslash \ (e.g. "\ \\"").
 *
 * @author dvorak
 */
@SuppressWarnings("JavaDoc")
public class Email {
	//=============== ATRIBUTY ==================================================
	//The format of email addresses is local-part@domain where the local part may be up to 64 characters long and the domain may have a maximum of 255 characters[2]—but the maximum of 256-character length of a forward or reverse path restricts the entire email address to be no more than 254 characters long.
	private static final int MAX_LOCAL_PART_LENGTH = 64;
	private static final int MAX_DOMAIN_LENGTH = 255;
	private static final int MAX_LENGTH = 254;
	public static final int SMTP_PORT = 25;
	public static final int SMTP_SSL_PORT = 465;

	/**
	 * domeny, ktere maji svou IP ale nemaji MX zaznam a jsou na prilakani navstevnosti
	 */
	public static final Map<String, String> DOMAIN_TYPING_ERRORS = Utils.toMap(new Object[][]{
			//yahoo.com
			{"yahooh.com", "yahoo.com"},//	MX: []		IP: []		HOST: []
			//hotmail.com
			{"hotmail.co", "hotmail.com"},//		MX: []		IP: [65.55.39.12, 64.4.6.233]		HOST: [windonws.com.br., windowsxp.com.tp.]
			{"hotmaill.com", "hotmail.com"},//	MX: []		IP: [65.55.5.14]		HOST: [wwwhotmail.com.]
			//gmail.com
			{"gemiel.com", "gmail.com"},//	MX: [mx.yandex.net.]		IP: [31.31.204.161]		HOST: []
			{"dmail.com", "gmail.com"},//	MX: []		IP: [23.23.174.132]		HOST: [ec2-23-23-174-132.compute-1.amazonaws.com.]
			{"gmeil.com", "gmail.com"},//	MX: []		IP: [158.69.143.102]		HOST: []
			{"gnail.com", "gmail.com"},//		MX: [mail.gnail.com.]	IP: [58.215.64.224] 	HOST: []
			{"gemail.cz", "gmail.com"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"gmeil.cz", "gmail.com"},//		MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"gaimil.com", "gmail.com"},//	MX: []		IP: [103.224.212.222]		HOST: [lb-212-222.above.com.]
			{"googl.com", "gmail.com"},//	MX: []		IP: [216.58.201.68, 2a00:1450:4014:800::2004]		HOST: [prg03s01-in-f4.1e100.net.]
			{"gimel.cz", "gmail.com"},//		MX: [mxavas.forpsi.com]		IP: []		HOST: []
			{"gmsil.com", "gmail.com"},//	MX: [gmsil.com.2.0001.arsmtp.com, gmsil.com.1.0001.arsmtp.com]		IP: [50.56.72.35]		HOST: [50-56-72-35.static.cloud-ips.com.]
			{"gmail.co", "gmail.com"},//		MX: []		IP: []		HOST: []
			{"gmyil.com", "gmail.com"},//	MX: []		IP: [103.224.182.207]		HOST: [lb-182-207.above.com.]
			//email.cz
			{"emai.cz", "email.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"emial.cz", "email.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"emil.cz", "email.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"cmail.cz", "email.cz"},//	MX: [ccx.spamfree.cz, cax.virusfree.cz, cdx.spamfree.cz, cbx.virusfree.cz]		IP: [46.255.231.48, 2a00:da80:f::48]		HOST: [centrum.cz.]
			//seznam.cz
			{"seznasm.cz", "seznam.cz"},//	MX: []		IP: [46.149.114.131]		HOST: []
			{"seznan.cz", "seznam.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"seznbam.cz", "seznam.cz"},//	MX: []		IP: [46.149.115.38]		HOST: []
			{"sezham.cz", "seznam.cz"},//	MX: []		IP: [5.39.99.52]		HOST: []
			{"sezmam.cz", "seznam.cz"},//	MX: []		IP: [217.198.113.104, 2a00:19a0:3:71:0:d9c6:7168:1]		HOST: [chimera.zarea.net.]
			{"sezna.cz", "seznam.cz"},//		MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"zeznam.cz", "seznam.cz"},//	MX: []		IP: [81.95.96.29]		HOST: [default.domeny.cz.]
			{"sesnam.cz", "seznam.cz"},//	MX: []		IP: [81.95.96.29]		HOST: [default.domeny.cz.]
			{"senznam.cz", "seznam.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"sewznam.cz", "seznam.cz"},//	MX: []		IP: []		HOST: []
			{"seznaqm.cz", "seznam.cz"},//	MX: []		IP: []		HOST: []
			{"seznam.cs", "seznam.cz"},//	MX: []		IP: []		HOST: []
			{"seznsam.cz", "seznam.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"seznmam.cz", "seznam.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"setnam.cz", "seznam.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"seznam.cc", "seznam.cz"},//	MX: []		IP: [77.75.79.53]		HOST: [www.seznam.cz.]
			{"senzam.cz", "seznam.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"deznam.cz", "seznam.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"aseznam.cz", "seznam.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"ssznam.cz", "seznam.cz"},//	MX: []		IP: [81.31.34.55]		HOST: [81-31-34-55.static.masterinter.net.]
			{"sezan.cz", "seznam.cz"},//		MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"seznma.cz", "seznam.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"seunam.cz", "seznam.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"sezbnam.cz", "seznam.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"sznam.cz", "seznam.cz"},//		MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"sezn.cz", "seznam.cz"},//		MX: []		IP: [46.28.105.3, 2a02:2b88:1:4::17]		HOST: [miniweb.wedos.net.]
			{"sezma.cz", "seznam.cz"},//		MX: []		IP: [185.53.177.29]		HOST: []
			{"seznam.sk", "seznam.cz"},//	MX: []		IP: [77.75.77.120, 2a02:598:a::79:120]		HOST: [search.seznam.cz.]
			{"seynam.cy", "seznam.cz"},//	MX: []		IP: []		HOST: []
			{"seznam.ch", "seznam.cz"},//	MX: [no.mx.example.org.]		IP: [78.129.180.203, 84.200.228.115]		HOST: [mail.k4e1.com.]
			{"sehnam.cz", "seznam.cz"},//	MX: []		IP: [46.28.105.3, 2a02:2b88:1:4::17]		HOST: [miniweb.wedos.net.]
			{"eznam.cz", "seznam.cz"},//		MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"sseznam.cz", "seznam.cz"},//	MX: []		IP: [208.73.211.250, 208.73.210.200, 208.73.211.194, 208.73.210.209]		HOST: [null, null, null, null]
			{"sezam.cz", "seznam.cz"},//		MX: [mail.sezam.cz.]		IP: []		HOST: []
			{"sezbam.cz", "seznam.cz"},//	MX: [mail.h-email.net.]		IP: []		HOST: []
			{"seuznam.cz", "seznam.cz"},//	MX: [mx.seuznam.cz]			IP: [178.217.244.35]		HOST: [frontend-1.sworp.com.]
			{"saznam.cz", "seznam.cz"},//	MX: []		IP: [103.224.182.253]		HOST: [lb-182-253.above.com.]
			//centrum.cz
			{"centum.cz", "centrum.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"entrum.cz", "centrum.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"centtrum.cz", "centrum.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"centrun.cz", "centrum.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"centurm.cz", "centrum.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"sentrum.cz", "centrum.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"scentrum.cz", "centrum.cz"},//	MX: []		IP: [217.198.116.188]		HOST: [czechiavps.zarea.net.]
			{"cemtrum.cz", "centrum.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"centru.cz", "centrum.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"entrum.cz", "centrum.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"cenrtum.cz", "centrum.cz"},//	MX: []		IP: [46.28.105.2, 2a02:2b88:1:4::16]		HOST: [default.wedos.net.]
			{"crntrum.cz", "centrum.cz"},//	MX: []		IP: [103.224.182.241]		HOST: [lb-182-241.above.com.]
			{"centzrum.cz", "centrum.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			//annonce.cz
			{"anonce.cz", "annonce.cz"},//	MX: []		IP: [213.29.194.4]		HOST: [lb.annonce.cz.]
			//tiscali.cz
			{"iscali.cz", "tiscali.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			//volny.cz
			{"olny.cz", "volny.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
			{"vplny.cz", "volny.cz"},//	MX: []		IP: [77.78.104.3]		HOST: [yurika.gransy.com.]
//			{"",""},
	});

	private static Set<String> GMAIL_SUGGESTIONS = new HashSet<>(Arrays.asList(
			"mail.com",//	MX: [mx01.mail.com., mx00.mail.com.]			IP: []
			"qmail.com",//	MX: [mx2.qq.com., mx3.qq.com., mx1.qq.com.]		IP: []
			"gmai.com",//	MX: [mail.flip-mail.com.]						IP: []
			"gmajl.com",//	MX: [mail.post-host.net.]						IP: []
			"ymail.com",//	MX: [mta5.am0.yahoodns.net., mta7.am0.yahoodns.net., mta6.am0.yahoodns.net.]		IP: [74.6.50.150, 188.125.73.108, 77.238.184.150, 98.137.236.150]
			"email.com",//	MX: [mx00.mail.com., mx01.mail.com.]			IP: []
			"gmaul.com",//	MX: [mail.b-io.co.]								IP: []
			"bmail.com",//	MX: [custmx.cscdns.net.]						IP: [165.160.13.20, 165.160.15.20]
			"gmil.com",//	MX: [mail.yaxmail.net.]							IP: [208.64.137.62]
			"gma.com",//	MX: [p.webcom.ctmail.com.]						IP: []
			"gmial.com",//	MX: [MAIL.B-IO.CO.]								IP: []
			"cmail.cz",//	MX: [cax.virusfree.cz., ccx.spamfree.cz., cbx.virusfree.cz., cdx.spamfree.cz.]		IP: []
			"qmail.cz",//	MX: [smail2.qmail.cz., smail.qmail.cz.]			IP: []
			"gaimil.com"//	MX: [mail.post-host.net.]						IP: []
	));

//	private static final List<String> PROHIBITED_LOCAL_PARTS = Arrays.asList("sex");

	private static final List<String> ROLE_ACCOUNT_LOCAL_PARTS = Arrays.asList(
			"abuse",
			"admin",
			"administracion",
			"administration",
			"advisor",
			"all",
			"billing",
			"bursar",
			"busdev",
			"casting",//povolit
			"ceo",
			"co-op",
			"community",
			"compete",
			"compliance",
			"consultant",
			"contact",
			"contacto",
			"compete",
			"crew",
			"customercare",
			"customerservice",
			"data",
			"database",
			"design",
			"devnull",
			"digsitesvalue",
			"director",
			"directors",
			"directory",
			"dns",
			"download",
			"editor",
			"editorial",
			"editors",
			"email",
			"eng",
			"enquire",
			"enquiries",
			"enquiry",
			"everyone",
			"exec",
			"executive",
			"executives",
			"expert",
			"experts",
			"export",
			"fbl",
			"ftp",
			"head.office",
			"head",
			"headoffice",
			"headteacher",
			"hostmaster",
			"hotel",
			"hr",//povolit
			"info",//povolit
			"information",
			"informativo",
			"investorrelations",
			"inoc",
			"ispfeedback",
			"ispsupport",
			"jobs",//povolit
			"kontakt",
			"list-request",
			"list",
			"mail",
			"maildaemon",
			"manager",
			"marketing",
			"master",
			"media",
			"noc",
			"no-reply",
			"noreply",
			"null",
			"office",
			"officeadmin",
			"operations",
			"phish",
			"phishing",
			"post",
			"postbox",
			"postmaster",
			"prime",
			"principal",
			"privacy",
			"reception",
			"recruit",
			"recruiting",
			"registrar",
			"remove",
			"request",
			"root",
			"sales",
			"security",
			"secretary",
			"school",
			"schooloffice",
			"shopping",
			"spam",
			"support",
			"sysadmin",
			"subscribe",
			"tech",
			"theoffice",
			"undisclosed-recipients",
			"unsubscribe",
			"usenet",
			"users",
			"uucp",
			"webmaster",
			"welcome",
			"www",
			"internet"
	);

	static final List<String> ALLOWED_ROLE_ACCOUNT_LOCAL_PARTS = Arrays.asList(
			"email",
			"mail",
			"info",
			"jobs",
			"hr",
			"manager",
			"director",
			"office",
			"sales",
			"shopping",
			"casting",
			"hotel",
			"kontakt",
			"contact"
	);

	private static final List<String> PROHIBITED_ROLE_ACCOUNT_LOCAL_PARTS = new ArrayList<>(ROLE_ACCOUNT_LOCAL_PARTS);

	static {
		PROHIBITED_ROLE_ACCOUNT_LOCAL_PARTS.removeAll(ALLOWED_ROLE_ACCOUNT_LOCAL_PARTS);
	}

	public static List<String> DISPOSABLE_MAIL_SERVERS = Arrays.asList(
			"mailinator.com",
			"mvrht.com",
			"wegwerfemail.de"
	);

	//TODO zakazane znaky v localPart pro seznam, google atd. https://registrace.seznam.cz/
	//suchy-doprava@gmail.com - DOMAIN_SPECIFIC_SYNTAX_ERROR
	//macejka.martin.@gmail.com - BAD_CHARACTER
	//khun.@centrum.cz - BAD_CHARACTER
	//equi-trek-praha.@email.cz - BAD_CHARACTER
	//zr.@eurest.cz - BAD_CHARACTER
	//petr.cerman.@email.cz - BAD_CHARACTER

	//private static final Logger LOG = Logger.getRootLogger();

	private static Set<String> VALID_EMAIL_SERVERS_MAP;

	private String email;
	private String domain;
	private List<String> domains;
	private String localPart;
	private Error error;
	private Warning warning;
	private boolean parsed = false;
	private List<Error> errors;
	private List<String> mxServers;

	//============== KOSTRUKTORY A TOVARNI METODY ===============================
	public Email(String email) {
		this.email = email;
	}

	//============== VEREJNE METODY INSTANCE ====================================

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return
	 */
	public String getLocalPart() {
		if (!this.parsed) parse();
		return this.localPart;

	}

	/**
	 * @return
	 */
	public String getDomain() {
		if (!this.parsed) parse();
		return this.domain;
	}

	/**
	 * @return
	 */
	public boolean isValid() {
		if (!this.parsed) parse();
		if (this.error != null)//existuji errory
			return false;

		if (this.domain == null)//nemame domenu
			return false;

		/*if(isDomainInValidMailServersMap(ctx))//domena je v seznamu jiz uspesne dorucenych mail serveru
			return true;*/

		if (!isValidDomain()) {//je domena platna(existuje)???
			this.warning = Warning.BAD_DOMAIN;
			return false;
		}

		return true;
	}

	/**
	 * @return
	 */
	public Error getError() {
		if (!parsed) parse();
		return error;
	}

	/**
	 * @return
	 */
	public Warning getWarning() {
		if (!parsed) parse();
		return warning;
	}


	/**
	 *
	 * @return
	 *//*
	public boolean isDomainInValidMailServersMap(Context ctx) {
		if(!parsed) parse();
		if(VALID_EMAIL_SERVERS_MAP == null) readValidDomains(ctx);
		if(domain == null || !VALID_EMAIL_SERVERS_MAP.contains(domain.toLowerCase()))
			return false;
		else
			return true;
	}*/


	/**
	 * @return
	 */
	public boolean isValidDomain() {
		if (!parsed) parse();
		if (domain == null)
			return false;
		List<String> ips = DNSLookup.getIPAddresses(domain);
		return !ips.isEmpty();
	}

	/**
	 * @return
	 * @throws NamingException
	 */
	public boolean hasMXRecord() {
		if (!parsed) parse();
		if (domain == null)
			return false;
		if (this.mxServers == null)
			this.mxServers = DNSLookup.getMXServers(domain);
		return !this.mxServers.isEmpty();
	}

	/**
	 * @return
	 */
	public List<String> getMXRecord() {
		if (!parsed) parse();
		if (domain == null)
			return null;
		if (this.mxServers == null)
			this.mxServers = DNSLookup.getMXServers(domain);
		return this.mxServers;
	}

	/**
	 *
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj instanceof Email)
			return this.email.equals(((Email) obj).getEmail());
		else if (obj instanceof String)
			return this.email.equals(obj);
		else
			return false;
	}


	/**
	 * @return
	 */
	public String getSuggestion() {
		String localPartSuggestion = localPart;
		String domainSuggestion = domain;

		if (this.errors != null && !this.errors.isEmpty()) {//jsou chyby, pokusime se opravit
			for (Error error : errors) {
				switch (error) {
					case DOUBLE_PERIOD_IN_LOCAL_PART: {
						if (localPartSuggestion != null)
							localPartSuggestion = localPartSuggestion.replaceAll("\\.{2,}", ".");
						break;
					}
					case STARTS_WITH_A_PERIOD: {
						if (localPartSuggestion != null)
							localPartSuggestion = localPartSuggestion.replaceFirst("^\\.+", "");
						break;
					}
					case BAD_CHARACTER: {
						//TODO
						break;
					}
					case DOUBLE_PERIOD_IN_DOMAIN: {
						if (domainSuggestion != null)
							domainSuggestion = domainSuggestion.replaceAll("\\.{2,}", ".");
						break;
					}
					case ENDS_WITH_HYPHEN: {
						if (domainSuggestion != null)
							domainSuggestion = domainSuggestion.replaceFirst("-+$", "");
						break;
					}
					case ENDS_WITH_PERIOD: {
						if (domainSuggestion != null)
							domainSuggestion = domainSuggestion.replaceFirst("\\.+$", "");
						break;
					}
					case HYPHEN_FOLLOWING_AT: {
						if (domainSuggestion != null)
							domainSuggestion = domainSuggestion.replaceFirst("^-+", "");
						break;
					}
					case PERIOD_FOLLOWING_AT: {
						if (domainSuggestion != null)
							domainSuggestion = domainSuggestion.replaceFirst("^\\.+", "");
						break;
					}
					default:
						//zatim nic
				}
			}
		}
		if (domainSuggestion != null && !domainSuggestion.equals(domain))//upravili jsme domenu, zvalidujeme
			domainSuggestion = getDomainSuggestion(domainSuggestion);
		else
			domainSuggestion = getDomainSuggestion();

		if (domainSuggestion != null && !domainSuggestion.equals(domain)) {
			String result = localPartSuggestion + "@" + domainSuggestion;
			if (!this.email.equals(result))
				return result;
		}

		return null;
	}


	/**
	 * @return
	 */
	private String getDomainSuggestion(String domain) {
		if (!parsed) parse();
		if (domain == null || domain.length() == 0)
			return null;

		if (DOMAIN_TYPING_ERRORS.containsKey(domain))
			return DOMAIN_TYPING_ERRORS.get(domain);

		if (GMAIL_SUGGESTIONS.contains(domain))
			return "gmail.com";

		if (VALID_EMAIL_SERVERS_MAP == null) readValidDomains();
		Map<String, Integer> map = new HashMap<>();
		for (String validDomain : VALID_EMAIL_SERVERS_MAP) {
			map.put(validDomain, levenshteinDistance(validDomain, domain));
		}

		if (map.isEmpty())
			return null;

		map = sortByValue(map);
//		return Misc.prettyMapPrint(map);

		Entry<String, Integer> entry = map.entrySet().iterator().next();
		if (entry.getValue() < 4)
			return entry.getKey();
		else
			return null;
	}

	public String getDomainSuggestion() {
		return getDomainSuggestion(this.domain);
	}

	//TODO toString

	/**
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 */
	public static String testDomains(int start, int end) throws Exception {
		if (VALID_EMAIL_SERVERS_MAP == null) readValidDomains();
		StringBuilder sb = new StringBuilder();
		sb.append("VALID_EMAIL_SERVERS_MAP size: ").append(VALID_EMAIL_SERVERS_MAP.size()).append("\n");
		List<String> domains = new ArrayList<>(VALID_EMAIL_SERVERS_MAP);
		for (String d : domains.subList(start, end)) {
			List<String> mx = DNSLookup.getMXServers(d);
			List<String> ips = DNSLookup.getIPAddresses(d);
			if (mx.isEmpty() && ips.isEmpty()) {
				sb.append(d).append("\t\t");
				sb.append(mx).append("\t\t");
				sb.append(ips).append("\n");
			}
		}
		return sb.toString();
	}

	public static String checkDomain(String domain) {
		try {
			List<String> mx = DNSLookup.getMXServers(domain);
			List<String> ip = DNSLookup.getIPAddresses(domain);
			List<String> host = new ArrayList<>();
			try {
				for (String i : ip) {
					host.add(DNSLookup.getRevName(i));
				}
			} catch (CommunicationException | NameNotFoundException ignore) {
			}
			if (!DOMAIN_TYPING_ERRORS.containsKey(domain))
				return "{\"" + domain + "\",\"\"},//\tMX: " + mx + "\t\tIP: " + ip + "\t\tHOST: " + host + "\nAdd to DOMAIN_TYPING_ERRORS!!!";
			else
				return "Already in DOMAIN_TYPING_ERRORS";
		} catch (Exception e) {
			//Logger.getRootLogger().error("unable to check domain " + domain, e);
		}
		return null;
	}

	public static String checkDomainWithMX(String domain) {
		StringBuilder sb = new StringBuilder();
		try {
			List<String> mx = DNSLookup.getMXServers(domain);
			List<String> ip = DNSLookup.getIPAddresses(domain);
			List<String> host = new ArrayList<>();
			try {
				for (String i : ip) {
					host.add(DNSLookup.getRevName(i));
				}
			} catch (CommunicationException | NameNotFoundException ignore) {
			}
			sb.append("{\"").append(domain).append("\",\"\"},//\tMX: ").append(mx).append("\t\tIP: ").append(ip).append("\t\tHOST: ").append(host).append("\n");
			if (!DOMAIN_TYPING_ERRORS.containsKey(domain))
				sb.append("Add to DOMAIN_TYPING_ERRORS!!!\n");

			if (mx.isEmpty())
				sb.append(checkMailSever(domain)).append("\n\n");

			for (String mailserver : mx) {
				sb.append(checkMailSever(mailserver)).append("\n\n");
			}
		} catch (Exception e) {
			sb.append(Utils.exceptionToString(e)).append("\n");
		}
		return sb.toString();
	}

	public static String checkMailSever(String mailserver) {
		StringBuilder sb = new StringBuilder();
		try {
			InetAddress ia = InetAddress.getByName(mailserver);
			sb.append("checking ").append(ia).append("\n");
			Socket socket = new Socket(ia, SMTP_PORT);
			Properties mailProps = new Properties();
			mailProps.put("mail.smtp.host", mailserver);
			mailProps.put("mail.host", mailserver);
			mailProps.put("mail.smtp.port", String.valueOf(SMTP_PORT));
			//TODO
			/*SMTPTransport smtp = new SMTPTransport(Session.getInstance(mailProps), new URLName(mailserver));
			smtp.connect(socket);
			sb.append(smtp.getLastReturnCode());//http://www.serversmtp.com/en/smtp-error
			sb.append(smtp.getLastServerResponse());*/
		} catch (Exception e) {
			sb.append(Utils.exceptionToString(e)).append("\n");
		}
		return sb.toString();
	}

	//============== SOUKROME METODY INSTANCE ===================================
	private static void readValidDomains() {
		// TODO
		/*try {
			VALID_EMAIL_SERVERS_MAP = new HashSet<>(Ami.getDbHelper().executeQuery(Ami.getROConnection(ctx), new FirstColumn<String>(), "SELECT DISTINCT(SUBSTRING_INDEX(LOWER(email),'@',-1)) FROM email WHERE state = 'VALID'"));
		} catch (Exception e) {
			//LOG.error("unable to read valid domains from db", e);
		}*/
	}

	private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
		list.sort(Comparator.comparing(o -> (o.getValue())));

		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}


	/**
	 *
	 */
	private void parse() {
		this.parsed = true;
		StringBuilder sb = new StringBuilder();
		StringBuilder domainStr = new StringBuilder();
		this.domains = new ArrayList<>();
		EmailPart part = EmailPart.LOCAL_PART;
		char lastChar = 0;
		for (char ch : this.email.toCharArray()) {

			if (isAsciiDigit(ch) || isNumber(ch)) {//[a-zA-Z0-9]
				sb.append(ch);
				if (part == EmailPart.DOMAIN)
					domainStr.append(ch);
			} else if (isAt(ch)) {//@
				if (part == EmailPart.DOMAIN) {
					sb.append(ch);
					addError(Error.MULTIPLE_AT);
					if (part == EmailPart.DOMAIN)
						domainStr.append(ch);
				} else if (part == EmailPart.LOCAL_PART_IN_DOUBLE_QUOTES) {//jsme v uvozovkach
					sb.append(ch);
				} else if (part == EmailPart.LOCAL_PART) {//konec local part
					this.localPart = sb.toString();
					sb = new StringBuilder();
					part = EmailPart.DOMAIN;
				}
			} else if (isDot(ch)) {//tecka
				sb.append(ch);
				if (sb.length() == 1) {//ani local part ani domain nemuze zacinat teckou
					if (part == EmailPart.DOMAIN)
						addError(Error.PERIOD_FOLLOWING_AT);
					else
						addError(Error.STARTS_WITH_A_PERIOD);
				} else if (isDot(lastChar)) {//posledni znak byla taky tecka
					sb.append(ch);
					//nemuzou byt dve tecky v domene ani v local partu
					if (part == EmailPart.DOMAIN)
						addError(Error.DOUBLE_PERIOD_IN_DOMAIN);
					else if (part == EmailPart.LOCAL_PART)
						addError(Error.DOUBLE_PERIOD_IN_LOCAL_PART);
				}
				if (part == EmailPart.DOMAIN) {//v domene pridame dalsi cast domeny
					if (domainStr.length() > 0) {
						domains.add(domainStr.toString());
						domainStr = new StringBuilder();
					}
				}
			} else if (isHyphen(ch)) {//spojovnik/minus
				sb.append(ch);
				if (part == EmailPart.DOMAIN && sb.length() == 1)//spojovnik nemuze byt na zacatku domeny
					addError(Error.HYPHEN_FOLLOWING_AT);
				if (part == EmailPart.DOMAIN)
					domainStr.append(ch);
			} else if (isDoubleQuote(ch)) {//dvojite uvozovky
				sb.append(ch);
				if (part == EmailPart.DOMAIN) {//nepovoleno v domene
					addError(Error.BAD_CHARACTER);
					if (part == EmailPart.DOMAIN)
						domainStr.append(ch);
				} else {//v local partu povoleno
					/*
					 * A quoted string may exist as a dot separated entity within the local-part,
					 * or it may exist when the outermost quotes are the outermost characters
					 * of the local-part (e.g., abc."defghi".xyz@example.com or "abcdefghixyz"@example.com
					 * are allowed.[citation needed] Conversely, abc"defghi"xyz@example.com is not;
					 * neither is abc\"def\"ghi@example.com).
					 */
					//TODO
					if (isBackSlash(lastChar)) {//oescapovane uvozovky
						if (part == EmailPart.LOCAL_PART)
							addError(Error.BAD_CHARACTER);
					} else {
						if (part == EmailPart.LOCAL_PART_IN_DOUBLE_QUOTES) {
							part = EmailPart.LOCAL_PART;
						} else {
							part = EmailPart.LOCAL_PART_IN_DOUBLE_QUOTES;
						}
					}
				}
			} else if (isSpace(ch)) {//mezera
				sb.append(ch);
				if (part == EmailPart.DOMAIN)
					domainStr.append(ch);
				if (part == EmailPart.DOMAIN || part == EmailPart.LOCAL_PART)//mezera je povolena pouze v uvozovkach
					addError(Error.BAD_CHARACTER);
			} else if (isNameSpecialCharacter(ch)) {
				sb.append(ch);
				if (part == EmailPart.DOMAIN)
					domainStr.append(ch);
				if (part == EmailPart.DOMAIN)
					addError(Error.BAD_CHARACTER);
			} else if (isNameQuotedSpecialCharacter(ch)) {
				sb.append(ch);
				if (part == EmailPart.DOMAIN)
					domainStr.append(ch);
				if (part != EmailPart.LOCAL_PART_IN_DOUBLE_QUOTES)
					addError(Error.BAD_CHARACTER);
			} else {//jiny znak
				addError(Error.BAD_CHARACTER);
				sb.append(ch);
				if (part == EmailPart.DOMAIN)
					domainStr.append(ch);
			}

			lastChar = ch;
		}

		if (part == EmailPart.DOMAIN) {
			this.domain = sb.toString();
			if (domainStr.length() > 0) {
				domains.add(domainStr.toString());
				domainStr = new StringBuilder();
			}

		} else {
			this.localPart = sb.toString();
		}

		if (this.domain == null)
			addError(Error.MISSING_AT);

		if (this.localPart.isEmpty())
			addError(Error.MISSING_USERNAME);

		//kontrola na posledni znak
		if (this.domain != null) {
			if (this.domain.isEmpty())
				addError(Error.MISSING_DOMAIN);
			if (this.domain.endsWith("."))
				addError(Error.ENDS_WITH_PERIOD);
			if (this.domain.endsWith("-"))
				addError(Error.ENDS_WITH_HYPHEN);
		}

		if (this.error == null) {
			// kontrola na delky casti
			if (this.localPart.length() > MAX_LOCAL_PART_LENGTH)
				addError(Error.BAD_LENGTH);
			if (this.domain.length() > MAX_DOMAIN_LENGTH)
				addError(Error.BAD_LENGTH);
			if (this.domain.length() + this.localPart.length() > MAX_LENGTH)
				addError(Error.BAD_LENGTH);
		}

		if (this.error == null) {
			if (this.domains != null && !this.domains.isEmpty()) {
				//kontrola na delky domen
				for (String domainPart : this.domains) {
					if (domainPart.length() > 63) {
						addError(Error.BAD_LENGTH);
					}
				}

				if (this.domains.size() == 1) {
					addError(Error.BAD_TLD);
				}

				//kontrola na TLD
				if (this.error == null) {
					String tldName = this.domains.get(this.domains.size() - 1);
					boolean tld = TopLevelDomain.domainExists(tldName);
					if (!tld) {
//						LOG.error("unable to find TLD for: " + tldName + " in email " + this.email);
						addError(Error.BAD_TLD);
					}
				}
			}
		}
	}

	/**
	 * @param error
	 */
	private void addError(Error error) {
		if (error == null)
			return;

		if (this.errors == null)
			this.errors = new ArrayList<>();

		this.errors.add(error);

		if (error.equals(this.error))//stejne chyby nebudeme prevadet na Error.CONTAINS_MULTIPLE_TYPOS
			return;

		if (this.error != null)
			this.error = Error.CONTAINS_MULTIPLE_TYPOS;
		else
			this.error = error;
	}

	/**
	 * Vraci smtp code po navazani spojeni jinak null
	 * http://www.serversmtp.com/en/smtp-error
	 *
	 * @param mx
	 * @return
	 */
	private static Integer getMxServerStatus(String mx, int port) {
		try {
			Properties mailProps = new Properties();
			mailProps.put("mail.smtp.host", mx);
			mailProps.put("mail.host", mx);
			mailProps.put("mail.smtp.port", String.valueOf(port));
			// TODO fix
			/*SMTPTransport smtp = new SMTPTransport(Session.getInstance(mailProps), new URLName(mx));
			Socket socket = new Socket(InetAddress.getByName(mx), port);
			smtp.connect(socket);
			return Integer.valueOf(smtp.getLastReturnCode());*/
		} catch (Exception e) {
			//LOG.error("unable to check mx server", e);
		}
		return null;
	}

	/**
	 * @param lhs
	 * @param rhs
	 * @return
	 */
	private static int levenshteinDistance(CharSequence lhs, CharSequence rhs) {
		int len0 = lhs.length() + 1;
		int len1 = rhs.length() + 1;

		// the array of distances
		int[] cost = new int[len0];
		int[] newcost = new int[len0];

		// initial cost of skipping prefix in String s0
		for (int i = 0; i < len0; i++) cost[i] = i;

		// dynamically computing the array of distances

		// transformation cost for each letter in s1
		for (int j = 1; j < len1; j++) {
			// initial cost of skipping prefix in String s1
			newcost[0] = j;

			// transformation cost for each letter in s0
			for (int i = 1; i < len0; i++) {
				// matching current letters in both strings
				int match = (lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1;

				// computing cost for each transformation
				int cost_replace = cost[i - 1] + match;
				int cost_insert = cost[i] + 1;
				int cost_delete = newcost[i - 1] + 1;

				// keep minimum cost
				newcost[i] = Math.min(Math.min(cost_insert, cost_delete), cost_replace);
			}

			// swap cost/newcost arrays
			int[] swap = cost;
			cost = newcost;
			newcost = swap;
		}

		// the distance is the cost for transforming all letters in both strings
		return cost[len0 - 1];
	}

	//*******************************************************************************************/
	//*** detekce znaku **** http://www.ascii.cl/htmlcodes.htm **********************************/
	//*******************************************************************************************/

	/**
	 * mezera/space
	 *
	 * @param ch
	 * @return
	 */
	private boolean isSpace(char ch) {
		return ch == 32;
	}

	/**
	 * ! vykricnik ASCII 33
	 *
	 * @param ch
	 * @return
	 */
	private boolean isExclamationPoint(char ch) {
		return ch == 33;
	}

	/**
	 * "
	 *
	 * @param ch
	 * @return
	 */
	private boolean isDoubleQuote(char ch) {
		return ch == 34;
	}

	/**
	 * #
	 *
	 * @param ch
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean isNumberSign(char ch) {
		return ch == 35;
	}

	@SuppressWarnings("unused")
	private boolean isDollarSign(char ch) {
		return ch == 36;
	}

	@SuppressWarnings("unused")
	private boolean isPercentSign(char ch) {
		return ch == 37;
	}

	@SuppressWarnings("unused")
	private boolean isAmpersand(char ch) {
		return ch == 38;
	}

	/**
	 * (
	 *
	 * @param ch
	 * @return
	 */
	private boolean isOpeningParenthesis(char ch) {
		return ch == 40;
	}

	/**
	 * )
	 *
	 * @param ch
	 * @return
	 */
	private boolean isClosingParenthesis(char ch) {
		return ch == 41;
	}

	private boolean isAsterisk(char ch) {
		return ch == 42;
	}

	private boolean isPlusSign(char ch) {
		return ch == 43;
	}

	/**
	 * ,
	 *
	 * @param ch
	 * @return
	 */
	private boolean isComma(char ch) {
		return ch == 44;
	}

	/**
	 * Character - (minus, hyphen, spojovnik) (ASCII: 45)
	 *
	 * @param ch
	 * @return
	 */
	private boolean isHyphen(char ch) {
		return ch == 45;
	}

	/**
	 * Character . (dot, period, full stop, tecka) (ASCII: 46)
	 *
	 * @param ch
	 * @return
	 */
	private boolean isDot(char ch) {
		return ch == 46;
	}

	private boolean isSlash(char ch) {
		return ch == 47;
	}

	/**
	 * Digits 0 to 9 (ASCII: 48-57)
	 *
	 * @param ch
	 * @return
	 */
	private boolean isNumber(char ch) {
		return ch >= 48 && ch <= 57;
	}

	private boolean isColon(char ch) {
		return ch == 58;
	}

	private boolean isSemicolon(char ch) {
		return ch == 59;
	}

	private boolean isLessThanSign(char ch) {
		return ch == 60;
	}

	private boolean isEqualSign(char ch) {
		return ch == 61;
	}

	private boolean isGreaterThanSign(char ch) {
		return ch == 62;
	}

	private boolean isQuestionMark(char ch) {
		return ch == 63;
	}

	private boolean isAt(char ch) {
		return ch == 64;
	}

	/**
	 * (a-z) (ASCII: 65-90)
	 *
	 * @param ch
	 * @return
	 */
	private boolean isAsciiLowerCaseDigit(char ch) {
		return ch >= 65 && ch <= 90;
	}

	private boolean isOpeningBracket(char ch) {
		return ch == 91;
	}

	private boolean isBackSlash(char ch) {
		return ch == 92;
	}

	private boolean isClosingBracket(char ch) {
		return ch == 93;
	}

	/**
	 * (A-Z) (ASCII: 97-122)
	 *
	 * @param ch
	 * @return
	 */
	private boolean isAsciiUpperCaseDigit(char ch) {
		return ch >= 97 && ch <= 122;
	}

	@SuppressWarnings("unused")
	private boolean isDomainAllowedCharacter(char ch) {
		return isAsciiDigit(ch) || isNumber(ch) || isDot(ch) || isHyphen(ch);
	}

	/**
	 * (a–z, A–Z) (ASCII: 65-90, 97-122)
	 *
	 * @param ch
	 * @return
	 */
	private boolean isAsciiDigit(char ch) {
		return isAsciiLowerCaseDigit(ch) || isAsciiUpperCaseDigit(ch);
	}


	/**
	 * Characters !#$%&'*+-/=?^_`{|}~ (ASCII: 33, 35-39, 42, 43, 45, 47, 61, 63, 94-96, 123-126)
	 *
	 * @param ch
	 * @return
	 */
	private boolean isNameSpecialCharacter(char ch) {
		return isHyphen(ch)//'-'
				|| isExclamationPoint(ch)//'!'
				|| (ch >= 35 && ch <= 39)//#$%&' 35-39
				|| isAsterisk(ch)//'*'
				|| isPlusSign(ch)//'+'
				|| isSlash(ch)//'/'
				|| isEqualSign(ch)//'='
				|| isQuestionMark(ch)//'?'
				|| (ch >= 94 && ch <= 96)//^_` 94-96
				|| (ch >= 123 && ch <= 126);//{|}~ 123-126
	}

	/**
	 * space and "(),:;<>@[\]  (ASCII: 34, 40-41, 44, 58-59, 60, 62, 64, 91-93)
	 *
	 * @param ch
	 * @return
	 */
	private boolean isNameQuotedSpecialCharacter(char ch) {
		return isSpace(ch)
				|| isOpeningParenthesis(ch)
				|| isClosingParenthesis(ch)
				|| isComma(ch)
				|| isColon(ch)
				|| isSemicolon(ch)
				|| isLessThanSign(ch)
				|| isGreaterThanSign(ch)
				|| isAt(ch)
				|| isOpeningBracket(ch)
				|| isBackSlash(ch)
				|| isClosingBracket(ch);
	}


	//============== VNORENE A VNITRNI TRIDY ====================================

	/**
	 * @author DDv
	 */
	private enum EmailPart {
		LOCAL_PART,
		DOMAIN,
		LOCAL_PART_IN_DOUBLE_QUOTES;
	}

	/**
	 * @author DDv
	 */
	public enum Error {
		/**
		 * Email address is missing the "@" sign. For example: "nemohotmail.com"
		 */
		MISSING_AT("missing '@'", "adresa neobsahuje '@'"),
		/**
		 * Email address is missing the handle portion of the address. For example: "@hotmail.com"
		 */
		MISSING_USERNAME("missing username", "adresa neobsahuje jm\u00E9no (\u010D\u00E1st p\u0159ed '@')"),
		/**
		 * Email address is missing the domain portion of the address. For example: "nemo@".
		 */
		MISSING_DOMAIN("missing domain", "adresa neobsahuje dom\u00E9nu (\u010D\u00E1st za '@')"),
		/**
		 * Email address has multiple "@" signs. For example: "nemo@@hotmail.com".
		 */
		MULTIPLE_AT("multiple '@'", "adresa obsahuje '@' v\u00EDcekr\u00E1t"),
		/**
		 * Email address has prohibited characters such as a bracket "["or other unusual characters.
		 */
		BAD_CHARACTER("bad character", "adresa obsahuje zak\u00E1zan\u00E9 znaky"),
		/**
		 * Email address has multiple ‘.com’s at the end of the address. For example: "nemo@aol.com.com"
		 */
		DOUBLE_TLD("double top level domail", "adresa obsahuje v\u00EDcekr\u00E1t dom\u00E9nu prvn\u00EDho \u0159\u00E1du"),
		/**
		 * Email address is missing the top domain, or the top level domain is invalid.
		 */
		BAD_TLD("bad top level domain", "adresa obsahuje chybnou dom\u00E9nu prvn\u00EDho \u0159\u00E1du"),
		/**
		 * Email address has less than 6 characters or over 100 characters.
		 */
		BAD_LENGTH("bad length", "chybn\u00E1 d\u00E9lka adresy"),
		/**
		 * Email address does not meet RFC standards and/or has multiple errors.
		 */
		CONTAINS_MULTIPLE_TYPOS("contains multiple typos", "adresa obsahuje v\u00EDce chyb"),
		/**
		 * Email address ends with a period – For example: "nemo@hotmail.com."
		 */
		ENDS_WITH_PERIOD("ends with period", "adresa kon\u010D\u00ED te\u010Dkou"),
		/**
		 * Email address ends with a hyphen – For example: "nemo@hotmail.com-"
		 */
		ENDS_WITH_HYPHEN("ends with hyphen", "adresa kon\u010D\u00ED spojovn\u00EDkem (-)"),
		/**
		 * Email address has multiple periods in the domain. For example: "nemo@hotmail..com"
		 */
		DOUBLE_PERIOD_IN_DOMAIN("double period in domain", "adresa obsahuje zdvojenou te\u010Dku v dom\u00E9n\u011B"),
		/**
		 * Email address has multiple periods in the local part. For example: "ne..mo@hotmail.com"
		 */
		DOUBLE_PERIOD_IN_LOCAL_PART("double period in local part", "adresa obsahuje zdvojenou te\u010Dku"),
		/**
		 * Email address has a period after the '@' sign. For example: "nemo@.hotmail.com"
		 */
		PERIOD_FOLLOWING_AT("period following '@'", "adresa obsahuje te\u010Dku za '@'"),
		/**
		 * Email address has a hyphen after the '@' sign. For example: "nemo@-hotmail.com"
		 */
		HYPHEN_FOLLOWING_AT("hyphen following '@'", "adresa osahuje '-' za '@'"),
		/**
		 * Email address starts with a period. For example: ".nemo@hotmail.com"
		 */
		STARTS_WITH_A_PERIOD("starts with a period", "adresa za\u010D\u00EDn\u00E1 te\u010Dkou");
		private final String messageEn;
		private final String messageCs;

		Error(String messageEn, String messageCs) {
			this.messageEn = messageEn;
			this.messageCs = messageCs;
		}

		public String getMessageEn() {
			return messageEn;
		}

		public String getMessageCs() {
			return messageCs;
		}
	}

	/**
	 * @author DDv
	 */
	public enum Warning {
		/**
		 * Email address failed FreshAddress’s deliverability check. Our proprietary algorithm utilizes our knowledgebase of confirmed undeliverable email addresses and email specific activity to determine if the email address is valid and available to accept email.
		 */
		INVALID_EMAIL_ACCOUNT("invalid email account", "invalid email account", EmailState.INVALID_EMAIL_ACCOUNT),//TODO
		/**
		 * Email address is associated with a domain with inactive mail servers.
		 */
		BAD_DOMAIN("bad domain", "bad domain", EmailState.BAD_DOMAIN),//TODO
		/**
		 * Email address with a restricted handle and/or domain which is a likely suspect for being a fake or undesirable entry.
		 */
		BOGUS("bogus", "bogus", EmailState.BOGUS),//TODO
		/**
		 * Email address matches an entry on client provided suppression.
		 */
		CLIENT_RESTRICTED("client restricted", "client restricted", EmailState.CLIENT_RESTRICTED),//TODO
		/**
		 * Email address originates from a website that provides temporary email addresses.
		 */
		DISPOSABLE("disposable", "disposable", EmailState.DISPOSABLE),//TODO
		/**
		 * Email addresses belonging to DMA’s "Do Not Email List" (Electronic Mail Preference Service). Those who have registered have requested to be removed from national marketing lists.
		 */
		EMPS_SUPPRESSION("EMPS suppression", "EMPS suppression", EmailState.EMPS_SUPPRESSION),//TODO
		/**
		 * Email address owner is known to submit spam/abuse complaints.
		 */
		FREQUENT_COMPLAINER("frequent complainer", "frequent complainer", EmailState.FREQUENT_COMPLAINER),//TODO
		/**
		 * Email address failed a domain specific rule, e.g. gmail.com does not allow underscores in the address handle.
		 */
		DOMAIN_SPECIFIC_SYNTAX_ERROR("domain specific syntax error", "domain specific syntax error", EmailState.DOMAIN_SPECIFIC_SYNTAX_ERROR),//TODO
		/**
		 * Email address contains derogatory words.
		 */
		LANGUAGE("language", "language", EmailState.LANGUAGE),//TODO
		/**
		 * Email address is considered as problematic – includes spamtraps and potentially toxic addresses.
		 */
		PROBLEMATIC("problematic", "problematic", EmailState.PROBLEMATIC),//TODO
		/**
		 * Email addresses such as sales@, info@ and webmaster@.
		 */
		ROLE_ACCOUNT("role account", "role account", EmailState.ROLE_ACCOUNT),//TODO
		/**
		 * Email address originates from an FCC wireless domain.
		 */
		FFC_WIRELESS("FCC wireless", "FCC wireless", EmailState.FFC_WIRELESS)//TODO
		;
		private final String messageEn;
		private final String messageCs;
		private final EmailState emailState;

		private Warning(String messageEn, String messageCs, EmailState emailState) {
			this.messageEn = messageEn;
			this.messageCs = messageCs;
			this.emailState = emailState;
		}

		public String getMessageEn() {
			return messageEn;
		}

		public String getMessageCs() {
			return messageCs;
		}

		public EmailState getEmailState() {
			return emailState;
		}
	}

	//============== OSTATNÍ (MAIN A AUTOMATICKY GENEROVANE METODY) =============
	public static void main(String[] args) throws Exception {
/*
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

		Error last = null;
		System.out.println("Valid emails:");
		for(String email : validEmails) {
			Email e = new Email(email);
			Error error = e.getError();
			last = error;
			if(error == null) {
				if(last != null) System.out.println();
				System.out.println(email + "\t\tlocalPart: " + e.getLocalPart() + "\tdomain: " + e.getDomain() + "\t" + e.domains);
			} else {
				if(last == null) System.err.println();
				System.err.println(email + "\t\t" + error + "\t\tlocalPart: " + e.getLocalPart() + "\tdomain: " + e.getDomain() + "\t" + e.domains);
			}
		}

		System.out.println("\n\nInvalid emails:");
		for(String email : invalidEmails) {
			Email e = new Email(email);
			Error error = e.getError();
			last = error;
			if(error == null) {
				if(last != null) System.err.println();
				System.err.println(email + "\t\t" + error + "\t\tlocalPart: " + e.getLocalPart() + "\tdomain: " + e.getDomain() + "\t" + e.domains);
			} else {
				if(last == null) System.out.println();
				System.out.println(email + "\t\t" + error + "\t\tlocalPart: " + e.getLocalPart() + "\tdomain: " + e.getDomain() + "\t" + e.domains);
			}
		}

		System.out.println("\n\n********************************************************************\n");
*/

		String domain = "saznam.cz";
//		System.out.println(checkDomainWithMX(domain));
		System.out.println(checkDomain(domain));
	}
}