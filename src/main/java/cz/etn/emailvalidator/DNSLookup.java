package cz.etn.emailvalidator;

import com.sun.mail.smtp.SMTPTransport;
import org.jetbrains.annotations.Nullable;

import javax.mail.Session;
import javax.mail.URLName;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//import org.apache.log4j.Logger;

/**
 * http://docs.oracle.com/javase/1.5.0/docs/guide/jndi/jndi-dns.html
 * https://www.captechconsulting.com/blogs/accessing-the-dusty-corners-of-dns-with-java
 * https://cs.wikipedia.org/wiki/Domain_Name_System
 * https://en.wikipedia.org/wiki/List_of_DNS_record_types
 *
 * @author DDv
 */
public class DNSLookup {
	private static final String MX_ATTRIB = "MX";
	private static final String ADDR_ATTRIB_IPV4 = "A";
	private static final String ADDR_ATTRIB_IPV6 = "AAAA";
	private static final String PTR_ATTRIB = "PTR";
	private static final String CNAME_ATTRIB = "CNAME";
	private static String[] MX_ATTRIBS = {MX_ATTRIB};
	private static String[] ADDR_ATTRIBS = {ADDR_ATTRIB_IPV4, ADDR_ATTRIB_IPV6};
	//private static String[] PTR_ATTRIBS = {PTR_ATTRIB};
	private static String[] CNAME_ATTRIBS = {CNAME_ATTRIB};

	//private static final Logger LOG = Logger.getRootLogger();

	private static final Properties env = new Properties();

	static {
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.dns.DnsContextFactory");
	}

	//============== VEREJNE METODY INSTANCE ====================================
	public static String getCName(String domain) {
		StringBuilder sb = new StringBuilder();
		try {
			InitialDirContext idc = new InitialDirContext(env);
			Attributes attrs = idc.getAttributes(domain, CNAME_ATTRIBS);
			Attribute attr = attrs.get(CNAME_ATTRIB);
			if (attr != null) {
				for (int i = 0; i < attr.size(); i++) {
					String cnameAttr = (String) attr.get(i);
					sb.append(cnameAttr).append("\n");
				}
			}
		} catch (NamingException e) {
			//LOG.warn("unable to get CNAME for " + domain, e);
		}
		return sb.toString();
	}

	/**
	 * @return list of mx records for domain
	 */
	public static List<String> getMXServers(String domain) {
		List<String> servers = new ArrayList<>();
		try {
			InitialDirContext idc = new InitialDirContext(env);
			Attributes attrs = idc.getAttributes(domain, MX_ATTRIBS);
			Attribute attr = attrs.get(MX_ATTRIB);

			if (attr != null) {
				for (int i = 0; i < attr.size(); i++) {
					String mxAttr = (String) attr.get(i);
					String[] parts = mxAttr.split(" ");

					// Split off the priority, and take the last field
					String part = parts[parts.length - 1];
					part = part.replaceFirst("\\.$", "");
					servers.add(part);
				}
			}
		} catch (NamingException e) {
			//	LOG.warn("unable to get MX record for " + domain, e);
		}
		return servers;
	}


	/**
	 * @return list of IP adresses for domain
	 */
	public static List<String> getIPAddresses(String hostname) {
		List<String> ipAddresses = new ArrayList<>();
		try {
			InitialDirContext idc = new InitialDirContext(env);
			Attributes attrs = idc.getAttributes(hostname, ADDR_ATTRIBS);
			Attribute ipv4 = attrs.get(ADDR_ATTRIB_IPV4);
			Attribute ipv6 = attrs.get(ADDR_ATTRIB_IPV6);


			if (ipv4 != null) {
				for (int i = 0; i < ipv4.size(); i++) {
					ipAddresses.add((String) ipv4.get(i));
				}
			}

			if (ipv6 != null) {
				for (int i = 0; i < ipv6.size(); i++) {
					ipAddresses.add((String) ipv6.get(i));
				}
			}
		} catch (NamingException e) {
			//	LOG.warn("unable to get IP for " + hostname, e);
		}
		return ipAddresses;
	}


/*
	public static String getRevName(String ipAddr) throws NamingException {

		String revName = null;
		String[] quads = ipAddr.split("\\.");

		//StringBuilder would be better, I know.
		ipAddr = "";

		for (int i = quads.length - 1; i >= 0; i--) {
			ipAddr += quads[i] + ".";
		}

		ipAddr += "in-addr.arpa.";
		Attributes attrs = idc.getAttributes(ipAddr, PTR_ATTRIBS);
		Attribute attr = attrs.get(PTR_ATTRIB);

		if (attr != null) {
			revName = (String) attr.get(0);
		}

		return revName;
	}*/

	/**
	 * http://www.serversmtp.com/en/smtp-error
	 *
	 * @param mx adresa mx serveru, na ktery se pokusime pripojit
	 * @return smtp code po navazani spojeni jinak null
	 */
	@Nullable
	private static Integer getMxServerStatus(String mx, int port) {
		try {
			Properties mailProps = new Properties();
			mailProps.put("mail.smtp.host", mx);
			mailProps.put("mail.host", mx);
			mailProps.put("mail.smtp.port", String.valueOf(port));
			SMTPTransport smtp = new SMTPTransport(Session.getInstance(mailProps), new URLName(mx));
			Socket socket = new Socket(InetAddress.getByName(mx), port);
			smtp.connect(socket);
			return smtp.getLastReturnCode();
		} catch (Exception e) {
			//LOG.error("unable to check mx server", e);
		}
		return null;
	}
}
