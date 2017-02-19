package cz.etn.emailvalidator.lists;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;


/**
 * http://www.iana.org/domains/root/db
 * http://data.iana.org/TLD/tlds-alpha-by-domain.txt
 * https://en.wikipedia.org/wiki/List_of_Internet_top-level_domains
 * https://publicsuffix.org/list/public_suffix_list.dat
 * https://mawords.com/tld.php
 * http://www.statdns.com/cctlds/
 *
 * @author DDv
 */
public class TopLevelDomain {

	private static final Set<String> domains = new HashSet<>();

	static {
		domains.add("aaa");
		domains.add("aarp");
		domains.add("abarth");
		domains.add("abb");
		domains.add("abbott");
		domains.add("abbvie");
		domains.add("abc");
		domains.add("able");
		domains.add("abogado");
		domains.add("abudhabi");
		domains.add("ac");
		domains.add("academy");
		domains.add("accenture");
		domains.add("accountant");
		domains.add("accountants");
		domains.add("aco");
		domains.add("active");
		domains.add("actor");
		domains.add("ad");
		domains.add("adac");
		domains.add("ads");
		domains.add("adult");
		domains.add("ae");
		domains.add("aeg");
		domains.add("aero");
		domains.add("aetna");
		domains.add("af");
		domains.add("afamilycompany");
		domains.add("afl");
		domains.add("ag");
		domains.add("agakhan");
		domains.add("agency");
		domains.add("ai");
		domains.add("aig");
		domains.add("aigo");
		domains.add("airbus");
		domains.add("airforce");
		domains.add("airtel");
		domains.add("akdn");
		domains.add("al");
		domains.add("alfaromeo");
		domains.add("alibaba");
		domains.add("alipay");
		domains.add("allfinanz");
		domains.add("allstate");
		domains.add("ally");
		domains.add("alsace");
		domains.add("alstom");
		domains.add("am");
		domains.add("americanexpress");
		domains.add("americanfamily");
		domains.add("amex");
		domains.add("amfam");
		domains.add("amica");
		domains.add("amsterdam");
		domains.add("analytics");
		domains.add("android");
		domains.add("anquan");
		domains.add("anz");
		domains.add("ao");
		domains.add("aol");
		domains.add("apartments");
		domains.add("app");
		domains.add("apple");
		domains.add("aq");
		domains.add("aquarelle");
		domains.add("ar");
		domains.add("aramco");
		domains.add("archi");
		domains.add("army");
		domains.add("arpa");
		domains.add("art");
		domains.add("arte");
		domains.add("as");
		domains.add("asda");
		domains.add("asia");
		domains.add("associates");
		domains.add("at");
		domains.add("athleta");
		domains.add("attorney");
		domains.add("au");
		domains.add("auction");
		domains.add("audi");
		domains.add("audible");
		domains.add("audio");
		domains.add("auspost");
		domains.add("author");
		domains.add("auto");
		domains.add("autos");
		domains.add("avianca");
		domains.add("aw");
		domains.add("aws");
		domains.add("ax");
		domains.add("axa");
		domains.add("az");
		domains.add("azure");
		domains.add("ba");
		domains.add("baby");
		domains.add("baidu");
		domains.add("banamex");
		domains.add("bananarepublic");
		domains.add("band");
		domains.add("bank");
		domains.add("bar");
		domains.add("barcelona");
		domains.add("barclaycard");
		domains.add("barclays");
		domains.add("barefoot");
		domains.add("bargains");
		domains.add("baseball");
		domains.add("basketball");
		domains.add("bauhaus");
		domains.add("bayern");
		domains.add("bb");
		domains.add("bbc");
		domains.add("bbt");
		domains.add("bbva");
		domains.add("bcg");
		domains.add("bcn");
		domains.add("bd");
		domains.add("be");
		domains.add("beats");
		domains.add("beauty");
		domains.add("beer");
		domains.add("bentley");
		domains.add("berlin");
		domains.add("best");
		domains.add("bestbuy");
		domains.add("bet");
		domains.add("bf");
		domains.add("bg");
		domains.add("bh");
		domains.add("bharti");
		domains.add("bi");
		domains.add("bible");
		domains.add("bid");
		domains.add("bike");
		domains.add("bing");
		domains.add("bingo");
		domains.add("bio");
		domains.add("biz");
		domains.add("bj");
		domains.add("black");
		domains.add("blackfriday");
		domains.add("blanco");
		domains.add("blockbuster");
		domains.add("blog");
		domains.add("bloomberg");
		domains.add("blue");
		domains.add("bm");
		domains.add("bms");
		domains.add("bmw");
		domains.add("bn");
		domains.add("bnl");
		domains.add("bnpparibas");
		domains.add("bo");
		domains.add("boats");
		domains.add("boehringer");
		domains.add("bofa");
		domains.add("bom");
		domains.add("bond");
		domains.add("boo");
		domains.add("book");
		domains.add("booking");
		domains.add("boots");
		domains.add("bosch");
		domains.add("bostik");
		domains.add("boston");
		domains.add("bot");
		domains.add("boutique");
		domains.add("box");
		domains.add("br");
		domains.add("bradesco");
		domains.add("bridgestone");
		domains.add("broadway");
		domains.add("broker");
		domains.add("brother");
		domains.add("brussels");
		domains.add("bs");
		domains.add("bt");
		domains.add("budapest");
		domains.add("bugatti");
		domains.add("build");
		domains.add("builders");
		domains.add("business");
		domains.add("buy");
		domains.add("buzz");
		domains.add("bv");
		domains.add("bw");
		domains.add("by");
		domains.add("bz");
		domains.add("bzh");
		domains.add("ca");
		domains.add("cab");
		domains.add("cafe");
		domains.add("cal");
		domains.add("call");
		domains.add("calvinklein");
		domains.add("cam");
		domains.add("camera");
		domains.add("camp");
		domains.add("cancerresearch");
		domains.add("canon");
		domains.add("capetown");
		domains.add("capital");
		domains.add("capitalone");
		domains.add("car");
		domains.add("caravan");
		domains.add("cards");
		domains.add("care");
		domains.add("career");
		domains.add("careers");
		domains.add("cars");
		domains.add("cartier");
		domains.add("casa");
		domains.add("case");
		domains.add("caseih");
		domains.add("cash");
		domains.add("casino");
		domains.add("cat");
		domains.add("catering");
		domains.add("catholic");
		domains.add("cba");
		domains.add("cbn");
		domains.add("cbre");
		domains.add("cbs");
		domains.add("cc");
		domains.add("cd");
		domains.add("ceb");
		domains.add("center");
		domains.add("ceo");
		domains.add("cern");
		domains.add("cf");
		domains.add("cfa");
		domains.add("cfd");
		domains.add("cg");
		domains.add("ch");
		domains.add("chanel");
		domains.add("channel");
		domains.add("chase");
		domains.add("chat");
		domains.add("cheap");
		domains.add("chintai");
		domains.add("chloe");
		domains.add("christmas");
		domains.add("chrome");
		domains.add("chrysler");
		domains.add("church");
		domains.add("ci");
		domains.add("cipriani");
		domains.add("circle");
		domains.add("cisco");
		domains.add("citadel");
		domains.add("citi");
		domains.add("citic");
		domains.add("city");
		domains.add("cityeats");
		domains.add("ck");
		domains.add("cl");
		domains.add("claims");
		domains.add("cleaning");
		domains.add("click");
		domains.add("clinic");
		domains.add("clinique");
		domains.add("clothing");
		domains.add("cloud");
		domains.add("club");
		domains.add("clubmed");
		domains.add("cm");
		domains.add("cn");
		domains.add("co");
		domains.add("coach");
		domains.add("codes");
		domains.add("coffee");
		domains.add("college");
		domains.add("cologne");
		domains.add("com");
		domains.add("comcast");
		domains.add("commbank");
		domains.add("community");
		domains.add("company");
		domains.add("compare");
		domains.add("computer");
		domains.add("comsec");
		domains.add("condos");
		domains.add("construction");
		domains.add("consulting");
		domains.add("contact");
		domains.add("contractors");
		domains.add("cooking");
		domains.add("cookingchannel");
		domains.add("cool");
		domains.add("coop");
		domains.add("corsica");
		domains.add("country");
		domains.add("coupon");
		domains.add("coupons");
		domains.add("courses");
		domains.add("cr");
		domains.add("credit");
		domains.add("creditcard");
		domains.add("creditunion");
		domains.add("cricket");
		domains.add("crown");
		domains.add("crs");
		domains.add("cruise");
		domains.add("cruises");
		domains.add("csc");
		domains.add("cu");
		domains.add("cuisinella");
		domains.add("cv");
		domains.add("cw");
		domains.add("cx");
		domains.add("cy");
		domains.add("cymru");
		domains.add("cyou");
		domains.add("cz");
		domains.add("dabur");
		domains.add("dad");
		domains.add("dance");
		domains.add("data");
		domains.add("date");
		domains.add("dating");
		domains.add("datsun");
		domains.add("day");
		domains.add("dclk");
		domains.add("dds");
		domains.add("de");
		domains.add("deal");
		domains.add("dealer");
		domains.add("deals");
		domains.add("degree");
		domains.add("delivery");
		domains.add("dell");
		domains.add("deloitte");
		domains.add("delta");
		domains.add("democrat");
		domains.add("dental");
		domains.add("dentist");
		domains.add("desi");
		domains.add("design");
		domains.add("dev");
		domains.add("dhl");
		domains.add("diamonds");
		domains.add("diet");
		domains.add("digital");
		domains.add("direct");
		domains.add("directory");
		domains.add("discount");
		domains.add("discover");
		domains.add("dish");
		domains.add("diy");
		domains.add("dj");
		domains.add("dk");
		domains.add("dm");
		domains.add("dnp");
		domains.add("do");
		domains.add("docs");
		domains.add("doctor");
		domains.add("dodge");
		domains.add("dog");
		domains.add("doha");
		domains.add("domains");
		domains.add("dot");
		domains.add("download");
		domains.add("drive");
		domains.add("dtv");
		domains.add("dubai");
		domains.add("duck");
		domains.add("dunlop");
		domains.add("duns");
		domains.add("dupont");
		domains.add("durban");
		domains.add("dvag");
		domains.add("dvr");
		domains.add("dz");
		domains.add("earth");
		domains.add("eat");
		domains.add("ec");
		domains.add("eco");
		domains.add("edeka");
		domains.add("edu");
		domains.add("education");
		domains.add("ee");
		domains.add("eg");
		domains.add("email");
		domains.add("emerck");
		domains.add("energy");
		domains.add("engineer");
		domains.add("engineering");
		domains.add("enterprises");
		domains.add("epost");
		domains.add("epson");
		domains.add("equipment");
		domains.add("er");
		domains.add("ericsson");
		domains.add("erni");
		domains.add("es");
		domains.add("esq");
		domains.add("estate");
		domains.add("esurance");
		domains.add("et");
		domains.add("eu");
		domains.add("eurovision");
		domains.add("eus");
		domains.add("events");
		domains.add("everbank");
		domains.add("exchange");
		domains.add("expert");
		domains.add("exposed");
		domains.add("express");
		domains.add("extraspace");
		domains.add("fage");
		domains.add("fail");
		domains.add("fairwinds");
		domains.add("faith");
		domains.add("family");
		domains.add("fan");
		domains.add("fans");
		domains.add("farm");
		domains.add("farmers");
		domains.add("fashion");
		domains.add("fast");
		domains.add("fedex");
		domains.add("feedback");
		domains.add("ferrari");
		domains.add("ferrero");
		domains.add("fi");
		domains.add("fiat");
		domains.add("fidelity");
		domains.add("fido");
		domains.add("film");
		domains.add("final");
		domains.add("finance");
		domains.add("financial");
		domains.add("fire");
		domains.add("firestone");
		domains.add("firmdale");
		domains.add("fish");
		domains.add("fishing");
		domains.add("fit");
		domains.add("fitness");
		domains.add("fj");
		domains.add("fk");
		domains.add("flickr");
		domains.add("flights");
		domains.add("flir");
		domains.add("florist");
		domains.add("flowers");
		domains.add("fly");
		domains.add("fm");
		domains.add("fo");
		domains.add("foo");
		domains.add("food");
		domains.add("foodnetwork");
		domains.add("football");
		domains.add("ford");
		domains.add("forex");
		domains.add("forsale");
		domains.add("forum");
		domains.add("foundation");
		domains.add("fox");
		domains.add("fr");
		domains.add("free");
		domains.add("fresenius");
		domains.add("frl");
		domains.add("frogans");
		domains.add("frontdoor");
		domains.add("frontier");
		domains.add("ftr");
		domains.add("fujitsu");
		domains.add("fujixerox");
		domains.add("fun");
		domains.add("fund");
		domains.add("furniture");
		domains.add("futbol");
		domains.add("fyi");
		domains.add("ga");
		domains.add("gal");
		domains.add("gallery");
		domains.add("gallo");
		domains.add("gallup");
		domains.add("game");
		domains.add("games");
		domains.add("gap");
		domains.add("garden");
		domains.add("gb");
		domains.add("gbiz");
		domains.add("gd");
		domains.add("gdn");
		domains.add("ge");
		domains.add("gea");
		domains.add("gent");
		domains.add("genting");
		domains.add("george");
		domains.add("gf");
		domains.add("gg");
		domains.add("ggee");
		domains.add("gh");
		domains.add("gi");
		domains.add("gift");
		domains.add("gifts");
		domains.add("gives");
		domains.add("giving");
		domains.add("gl");
		domains.add("glade");
		domains.add("glass");
		domains.add("gle");
		domains.add("global");
		domains.add("globo");
		domains.add("gm");
		domains.add("gmail");
		domains.add("gmbh");
		domains.add("gmo");
		domains.add("gmx");
		domains.add("gn");
		domains.add("godaddy");
		domains.add("gold");
		domains.add("goldpoint");
		domains.add("golf");
		domains.add("goo");
		domains.add("goodhands");
		domains.add("goodyear");
		domains.add("goog");
		domains.add("google");
		domains.add("gop");
		domains.add("got");
		domains.add("gov");
		domains.add("gp");
		domains.add("gq");
		domains.add("gr");
		domains.add("grainger");
		domains.add("graphics");
		domains.add("gratis");
		domains.add("green");
		domains.add("gripe");
		domains.add("group");
		domains.add("gs");
		domains.add("gt");
		domains.add("gu");
		domains.add("guardian");
		domains.add("gucci");
		domains.add("guge");
		domains.add("guide");
		domains.add("guitars");
		domains.add("guru");
		domains.add("gw");
		domains.add("gy");
		domains.add("hair");
		domains.add("hamburg");
		domains.add("hangout");
		domains.add("haus");
		domains.add("hbo");
		domains.add("hdfc");
		domains.add("hdfcbank");
		domains.add("health");
		domains.add("healthcare");
		domains.add("help");
		domains.add("helsinki");
		domains.add("here");
		domains.add("hermes");
		domains.add("hgtv");
		domains.add("hiphop");
		domains.add("hisamitsu");
		domains.add("hitachi");
		domains.add("hiv");
		domains.add("hk");
		domains.add("hkt");
		domains.add("hm");
		domains.add("hn");
		domains.add("hockey");
		domains.add("holdings");
		domains.add("holiday");
		domains.add("homedepot");
		domains.add("homegoods");
		domains.add("homes");
		domains.add("homesense");
		domains.add("honda");
		domains.add("honeywell");
		domains.add("horse");
		domains.add("hospital");
		domains.add("host");
		domains.add("hosting");
		domains.add("hot");
		domains.add("hoteles");
		domains.add("hotmail");
		domains.add("house");
		domains.add("how");
		domains.add("hr");
		domains.add("hsbc");
		domains.add("ht");
		domains.add("htc");
		domains.add("hu");
		domains.add("hughes");
		domains.add("hyatt");
		domains.add("hyundai");
		domains.add("ibm");
		domains.add("icbc");
		domains.add("ice");
		domains.add("icu");
		domains.add("id");
		domains.add("ie");
		domains.add("ieee");
		domains.add("ifm");
		domains.add("ikano");
		domains.add("il");
		domains.add("im");
		domains.add("imamat");
		domains.add("imdb");
		domains.add("immo");
		domains.add("immobilien");
		domains.add("in");
		domains.add("industries");
		domains.add("infiniti");
		domains.add("info");
		domains.add("ing");
		domains.add("ink");
		domains.add("institute");
		domains.add("insurance");
		domains.add("insure");
		domains.add("int");
		domains.add("intel");
		domains.add("international");
		domains.add("intuit");
		domains.add("investments");
		domains.add("io");
		domains.add("ipiranga");
		domains.add("iq");
		domains.add("ir");
		domains.add("irish");
		domains.add("is");
		domains.add("iselect");
		domains.add("ismaili");
		domains.add("ist");
		domains.add("istanbul");
		domains.add("it");
		domains.add("itau");
		domains.add("itv");
		domains.add("iveco");
		domains.add("iwc");
		domains.add("jaguar");
		domains.add("java");
		domains.add("jcb");
		domains.add("jcp");
		domains.add("je");
		domains.add("jeep");
		domains.add("jetzt");
		domains.add("jewelry");
		domains.add("jio");
		domains.add("jlc");
		domains.add("jll");
		domains.add("jm");
		domains.add("jmp");
		domains.add("jnj");
		domains.add("jo");
		domains.add("jobs");
		domains.add("joburg");
		domains.add("jot");
		domains.add("joy");
		domains.add("jp");
		domains.add("jpmorgan");
		domains.add("jprs");
		domains.add("juegos");
		domains.add("juniper");
		domains.add("kaufen");
		domains.add("kddi");
		domains.add("ke");
		domains.add("kerryhotels");
		domains.add("kerrylogistics");
		domains.add("kerryproperties");
		domains.add("kfh");
		domains.add("kg");
		domains.add("kh");
		domains.add("ki");
		domains.add("kia");
		domains.add("kim");
		domains.add("kinder");
		domains.add("kindle");
		domains.add("kitchen");
		domains.add("kiwi");
		domains.add("km");
		domains.add("kn");
		domains.add("koeln");
		domains.add("komatsu");
		domains.add("kosher");
		domains.add("kp");
		domains.add("kpmg");
		domains.add("kpn");
		domains.add("kr");
		domains.add("krd");
		domains.add("kred");
		domains.add("kuokgroup");
		domains.add("kw");
		domains.add("ky");
		domains.add("kyoto");
		domains.add("kz");
		domains.add("la");
		domains.add("lacaixa");
		domains.add("ladbrokes");
		domains.add("lamborghini");
		domains.add("lamer");
		domains.add("lancaster");
		domains.add("lancia");
		domains.add("lancome");
		domains.add("land");
		domains.add("landrover");
		domains.add("lanxess");
		domains.add("lasalle");
		domains.add("lat");
		domains.add("latino");
		domains.add("latrobe");
		domains.add("law");
		domains.add("lawyer");
		domains.add("lb");
		domains.add("lc");
		domains.add("lds");
		domains.add("lease");
		domains.add("leclerc");
		domains.add("lefrak");
		domains.add("legal");
		domains.add("lego");
		domains.add("lexus");
		domains.add("lgbt");
		domains.add("li");
		domains.add("liaison");
		domains.add("lidl");
		domains.add("life");
		domains.add("lifeinsurance");
		domains.add("lifestyle");
		domains.add("lighting");
		domains.add("like");
		domains.add("lilly");
		domains.add("limited");
		domains.add("limo");
		domains.add("lincoln");
		domains.add("linde");
		domains.add("link");
		domains.add("lipsy");
		domains.add("live");
		domains.add("living");
		domains.add("lixil");
		domains.add("lk");
		domains.add("loan");
		domains.add("loans");
		domains.add("locker");
		domains.add("locus");
		domains.add("loft");
		domains.add("lol");
		domains.add("london");
		domains.add("lotte");
		domains.add("lotto");
		domains.add("love");
		domains.add("lpl");
		domains.add("lplfinancial");
		domains.add("lr");
		domains.add("ls");
		domains.add("lt");
		domains.add("ltd");
		domains.add("ltda");
		domains.add("lu");
		domains.add("lundbeck");
		domains.add("lupin");
		domains.add("luxe");
		domains.add("luxury");
		domains.add("lv");
		domains.add("ly");
		domains.add("ma");
		domains.add("macys");
		domains.add("madrid");
		domains.add("maif");
		domains.add("maison");
		domains.add("makeup");
		domains.add("man");
		domains.add("management");
		domains.add("mango");
		domains.add("market");
		domains.add("marketing");
		domains.add("markets");
		domains.add("marriott");
		domains.add("marshalls");
		domains.add("maserati");
		domains.add("mattel");
		domains.add("mba");
		domains.add("mc");
		domains.add("mcd");
		domains.add("mcdonalds");
		domains.add("mckinsey");
		domains.add("md");
		domains.add("me");
		domains.add("med");
		domains.add("media");
		domains.add("meet");
		domains.add("melbourne");
		domains.add("meme");
		domains.add("memorial");
		domains.add("men");
		domains.add("menu");
		domains.add("meo");
		domains.add("metlife");
		domains.add("mg");
		domains.add("mh");
		domains.add("miami");
		domains.add("microsoft");
		domains.add("mil");
		domains.add("mini");
		domains.add("mint");
		domains.add("mit");
		domains.add("mitsubishi");
		domains.add("mk");
		domains.add("ml");
		domains.add("mlb");
		domains.add("mls");
		domains.add("mm");
		domains.add("mma");
		domains.add("mn");
		domains.add("mo");
		domains.add("mobi");
		domains.add("mobile");
		domains.add("mobily");
		domains.add("moda");
		domains.add("moe");
		domains.add("moi");
		domains.add("mom");
		domains.add("monash");
		domains.add("money");
		domains.add("monster");
		domains.add("montblanc");
		domains.add("mopar");
		domains.add("mormon");
		domains.add("mortgage");
		domains.add("moscow");
		domains.add("moto");
		domains.add("motorcycles");
		domains.add("mov");
		domains.add("movie");
		domains.add("movistar");
		domains.add("mp");
		domains.add("mq");
		domains.add("mr");
		domains.add("ms");
		domains.add("msd");
		domains.add("mt");
		domains.add("mtn");
		domains.add("mtpc");
		domains.add("mtr");
		domains.add("mu");
		domains.add("museum");
		domains.add("mutual");
		domains.add("mv");
		domains.add("mw");
		domains.add("mx");
		domains.add("my");
		domains.add("mz");
		domains.add("na");
		domains.add("nab");
		domains.add("nadex");
		domains.add("nagoya");
		domains.add("name");
		domains.add("nationwide");
		domains.add("natura");
		domains.add("navy");
		domains.add("nba");
		domains.add("nc");
		domains.add("ne");
		domains.add("nec");
		domains.add("net");
		domains.add("netbank");
		domains.add("netflix");
		domains.add("network");
		domains.add("neustar");
		domains.add("new");
		domains.add("newholland");
		domains.add("news");
		domains.add("next");
		domains.add("nextdirect");
		domains.add("nexus");
		domains.add("nf");
		domains.add("nfl");
		domains.add("ng");
		domains.add("ngo");
		domains.add("nhk");
		domains.add("ni");
		domains.add("nico");
		domains.add("nike");
		domains.add("nikon");
		domains.add("ninja");
		domains.add("nissan");
		domains.add("nissay");
		domains.add("nl");
		domains.add("no");
		domains.add("nokia");
		domains.add("northwesternmutual");
		domains.add("norton");
		domains.add("now");
		domains.add("nowruz");
		domains.add("nowtv");
		domains.add("np");
		domains.add("nr");
		domains.add("nra");
		domains.add("nrw");
		domains.add("ntt");
		domains.add("nu");
		domains.add("nyc");
		domains.add("nz");
		domains.add("obi");
		domains.add("observer");
		domains.add("off");
		domains.add("office");
		domains.add("okinawa");
		domains.add("olayan");
		domains.add("olayangroup");
		domains.add("oldnavy");
		domains.add("ollo");
		domains.add("om");
		domains.add("omega");
		domains.add("one");
		domains.add("ong");
		domains.add("onl");
		domains.add("online");
		domains.add("onyourside");
		domains.add("ooo");
		domains.add("open");
		domains.add("oracle");
		domains.add("orange");
		domains.add("org");
		domains.add("organic");
		domains.add("orientexpress");
		domains.add("origins");
		domains.add("osaka");
		domains.add("otsuka");
		domains.add("ott");
		domains.add("ovh");
		domains.add("pa");
		domains.add("page");
		domains.add("pamperedchef");
		domains.add("panasonic");
		domains.add("panerai");
		domains.add("paris");
		domains.add("pars");
		domains.add("partners");
		domains.add("parts");
		domains.add("party");
		domains.add("passagens");
		domains.add("pay");
		domains.add("pccw");
		domains.add("pe");
		domains.add("pet");
		domains.add("pf");
		domains.add("pfizer");
		domains.add("pg");
		domains.add("ph");
		domains.add("pharmacy");
		domains.add("philips");
		domains.add("phone");
		domains.add("photo");
		domains.add("photography");
		domains.add("photos");
		domains.add("physio");
		domains.add("piaget");
		domains.add("pics");
		domains.add("pictet");
		domains.add("pictures");
		domains.add("pid");
		domains.add("pin");
		domains.add("ping");
		domains.add("pink");
		domains.add("pioneer");
		domains.add("pizza");
		domains.add("pk");
		domains.add("pl");
		domains.add("place");
		domains.add("play");
		domains.add("playstation");
		domains.add("plumbing");
		domains.add("plus");
		domains.add("pm");
		domains.add("pn");
		domains.add("pnc");
		domains.add("pohl");
		domains.add("poker");
		domains.add("politie");
		domains.add("porn");
		domains.add("post");
		domains.add("pr");
		domains.add("pramerica");
		domains.add("praxi");
		domains.add("press");
		domains.add("prime");
		domains.add("pro");
		domains.add("prod");
		domains.add("productions");
		domains.add("prof");
		domains.add("progressive");
		domains.add("promo");
		domains.add("properties");
		domains.add("property");
		domains.add("protection");
		domains.add("pru");
		domains.add("prudential");
		domains.add("ps");
		domains.add("pt");
		domains.add("pub");
		domains.add("pw");
		domains.add("pwc");
		domains.add("py");
		domains.add("qa");
		domains.add("qpon");
		domains.add("quebec");
		domains.add("quest");
		domains.add("qvc");
		domains.add("racing");
		domains.add("radio");
		domains.add("raid");
		domains.add("re");
		domains.add("read");
		domains.add("realestate");
		domains.add("realtor");
		domains.add("realty");
		domains.add("recipes");
		domains.add("red");
		domains.add("redstone");
		domains.add("redumbrella");
		domains.add("rehab");
		domains.add("reise");
		domains.add("reisen");
		domains.add("reit");
		domains.add("reliance");
		domains.add("ren");
		domains.add("rent");
		domains.add("rentals");
		domains.add("repair");
		domains.add("report");
		domains.add("republican");
		domains.add("rest");
		domains.add("restaurant");
		domains.add("review");
		domains.add("reviews");
		domains.add("rexroth");
		domains.add("rich");
		domains.add("richardli");
		domains.add("ricoh");
		domains.add("rightathome");
		domains.add("ril");
		domains.add("rio");
		domains.add("rip");
		domains.add("rmit");
		domains.add("ro");
		domains.add("rocher");
		domains.add("rocks");
		domains.add("rodeo");
		domains.add("rogers");
		domains.add("room");
		domains.add("rs");
		domains.add("rsvp");
		domains.add("ru");
		domains.add("ruhr");
		domains.add("run");
		domains.add("rw");
		domains.add("rwe");
		domains.add("ryukyu");
		domains.add("sa");
		domains.add("saarland");
		domains.add("safe");
		domains.add("safety");
		domains.add("sakura");
		domains.add("sale");
		domains.add("salon");
		domains.add("samsclub");
		domains.add("samsung");
		domains.add("sandvik");
		domains.add("sandvikcoromant");
		domains.add("sanofi");
		domains.add("sap");
		domains.add("sapo");
		domains.add("sarl");
		domains.add("sas");
		domains.add("save");
		domains.add("saxo");
		domains.add("sb");
		domains.add("sbi");
		domains.add("sbs");
		domains.add("sc");
		domains.add("sca");
		domains.add("scb");
		domains.add("schaeffler");
		domains.add("schmidt");
		domains.add("scholarships");
		domains.add("school");
		domains.add("schule");
		domains.add("schwarz");
		domains.add("science");
		domains.add("scjohnson");
		domains.add("scor");
		domains.add("scot");
		domains.add("sd");
		domains.add("se");
		domains.add("seat");
		domains.add("secure");
		domains.add("security");
		domains.add("seek");
		domains.add("select");
		domains.add("sener");
		domains.add("services");
		domains.add("ses");
		domains.add("seven");
		domains.add("sew");
		domains.add("sex");
		domains.add("sexy");
		domains.add("sfr");
		domains.add("sg");
		domains.add("sh");
		domains.add("shangrila");
		domains.add("sharp");
		domains.add("shaw");
		domains.add("shell");
		domains.add("shia");
		domains.add("shiksha");
		domains.add("shoes");
		domains.add("shop");
		domains.add("shopping");
		domains.add("shouji");
		domains.add("show");
		domains.add("showtime");
		domains.add("shriram");
		domains.add("si");
		domains.add("silk");
		domains.add("sina");
		domains.add("singles");
		domains.add("site");
		domains.add("sj");
		domains.add("sk");
		domains.add("ski");
		domains.add("skin");
		domains.add("sky");
		domains.add("skype");
		domains.add("sl");
		domains.add("sling");
		domains.add("sm");
		domains.add("smart");
		domains.add("smile");
		domains.add("sn");
		domains.add("sncf");
		domains.add("so");
		domains.add("soccer");
		domains.add("social");
		domains.add("softbank");
		domains.add("software");
		domains.add("sohu");
		domains.add("solar");
		domains.add("solutions");
		domains.add("song");
		domains.add("sony");
		domains.add("soy");
		domains.add("space");
		domains.add("spiegel");
		domains.add("spot");
		domains.add("spreadbetting");
		domains.add("sr");
		domains.add("srl");
		domains.add("srt");
		domains.add("st");
		domains.add("stada");
		domains.add("staples");
		domains.add("star");
		domains.add("starhub");
		domains.add("statebank");
		domains.add("statefarm");
		domains.add("statoil");
		domains.add("stc");
		domains.add("stcgroup");
		domains.add("stockholm");
		domains.add("storage");
		domains.add("store");
		domains.add("stream");
		domains.add("studio");
		domains.add("study");
		domains.add("style");
		domains.add("su");
		domains.add("sucks");
		domains.add("supplies");
		domains.add("supply");
		domains.add("support");
		domains.add("surf");
		domains.add("surgery");
		domains.add("suzuki");
		domains.add("sv");
		domains.add("swatch");
		domains.add("swiftcover");
		domains.add("swiss");
		domains.add("sx");
		domains.add("sy");
		domains.add("sydney");
		domains.add("symantec");
		domains.add("systems");
		domains.add("sz");
		domains.add("tab");
		domains.add("taipei");
		domains.add("talk");
		domains.add("taobao");
		domains.add("target");
		domains.add("tatamotors");
		domains.add("tatar");
		domains.add("tattoo");
		domains.add("tax");
		domains.add("taxi");
		domains.add("tc");
		domains.add("tci");
		domains.add("td");
		domains.add("tdk");
		domains.add("team");
		domains.add("tech");
		domains.add("technology");
		domains.add("tel");
		domains.add("telecity");
		domains.add("telefonica");
		domains.add("temasek");
		domains.add("tennis");
		domains.add("teva");
		domains.add("tf");
		domains.add("tg");
		domains.add("th");
		domains.add("thd");
		domains.add("theater");
		domains.add("theatre");
		domains.add("tiaa");
		domains.add("tickets");
		domains.add("tienda");
		domains.add("tiffany");
		domains.add("tips");
		domains.add("tires");
		domains.add("tirol");
		domains.add("tj");
		domains.add("tjmaxx");
		domains.add("tjx");
		domains.add("tk");
		domains.add("tkmaxx");
		domains.add("tl");
		domains.add("tm");
		domains.add("tmall");
		domains.add("tn");
		domains.add("to");
		domains.add("today");
		domains.add("tokyo");
		domains.add("tools");
		domains.add("top");
		domains.add("toray");
		domains.add("toshiba");
		domains.add("total");
		domains.add("tours");
		domains.add("town");
		domains.add("toyota");
		domains.add("toys");
		domains.add("tr");
		domains.add("trade");
		domains.add("trading");
		domains.add("training");
		domains.add("travel");
		domains.add("travelchannel");
		domains.add("travelers");
		domains.add("travelersinsurance");
		domains.add("trust");
		domains.add("trv");
		domains.add("tt");
		domains.add("tube");
		domains.add("tui");
		domains.add("tunes");
		domains.add("tushu");
		domains.add("tv");
		domains.add("tvs");
		domains.add("tw");
		domains.add("tz");
		domains.add("ua");
		domains.add("ubank");
		domains.add("ubs");
		domains.add("uconnect");
		domains.add("ug");
		domains.add("uk");
		domains.add("unicom");
		domains.add("university");
		domains.add("uno");
		domains.add("uol");
		domains.add("ups");
		domains.add("us");
		domains.add("uy");
		domains.add("uz");
		domains.add("va");
		domains.add("vacations");
		domains.add("vana");
		domains.add("vanguard");
		domains.add("vc");
		domains.add("ve");
		domains.add("vegas");
		domains.add("ventures");
		domains.add("verisign");
		domains.add("versicherung");
		domains.add("vet");
		domains.add("vg");
		domains.add("vi");
		domains.add("viajes");
		domains.add("video");
		domains.add("vig");
		domains.add("viking");
		domains.add("villas");
		domains.add("vin");
		domains.add("vip");
		domains.add("virgin");
		domains.add("visa");
		domains.add("vision");
		domains.add("vista");
		domains.add("vistaprint");
		domains.add("viva");
		domains.add("vivo");
		domains.add("vlaanderen");
		domains.add("vn");
		domains.add("vodka");
		domains.add("volkswagen");
		domains.add("volvo");
		domains.add("vote");
		domains.add("voting");
		domains.add("voto");
		domains.add("voyage");
		domains.add("vu");
		domains.add("vuelos");
		domains.add("wales");
		domains.add("walmart");
		domains.add("walter");
		domains.add("wang");
		domains.add("wanggou");
		domains.add("warman");
		domains.add("watch");
		domains.add("watches");
		domains.add("weather");
		domains.add("weatherchannel");
		domains.add("webcam");
		domains.add("weber");
		domains.add("website");
		domains.add("wed");
		domains.add("wedding");
		domains.add("weibo");
		domains.add("weir");
		domains.add("wf");
		domains.add("whoswho");
		domains.add("wien");
		domains.add("wiki");
		domains.add("williamhill");
		domains.add("win");
		domains.add("windows");
		domains.add("wine");
		domains.add("winners");
		domains.add("wme");
		domains.add("wolterskluwer");
		domains.add("woodside");
		domains.add("work");
		domains.add("works");
		domains.add("world");
		domains.add("wow");
		domains.add("ws");
		domains.add("wtc");
		domains.add("wtf");
		domains.add("xbox");
		domains.add("xerox");
		domains.add("xfinity");
		domains.add("xihuan");
		domains.add("xin");
		domains.add("xn--11b4c3d");
		domains.add("xn--1ck2e1b");
		domains.add("xn--1qqw23a");
		domains.add("xn--30rr7y");
		domains.add("xn--3bst00m");
		domains.add("xn--3ds443g");
		domains.add("xn--3e0b707e");
		domains.add("xn--3oq18vl8pn36a");
		domains.add("xn--3pxu8k");
		domains.add("xn--42c2d9a");
		domains.add("xn--45brj9c");
		domains.add("xn--45q11c");
		domains.add("xn--4gbrim");
		domains.add("xn--54b7fta0cc");
		domains.add("xn--55qw42g");
		domains.add("xn--55qx5d");
		domains.add("xn--5su34j936bgsg");
		domains.add("xn--5tzm5g");
		domains.add("xn--6frz82g");
		domains.add("xn--6qq986b3xl");
		domains.add("xn--80adxhks");
		domains.add("xn--80ao21a");
		domains.add("xn--80aqecdr1a");
		domains.add("xn--80asehdb");
		domains.add("xn--80aswg");
		domains.add("xn--8y0a063a");
		domains.add("xn--90a3ac");
		domains.add("xn--90ae");
		domains.add("xn--90ais");
		domains.add("xn--9dbq2a");
		domains.add("xn--9et52u");
		domains.add("xn--9krt00a");
		domains.add("xn--b4w605ferd");
		domains.add("xn--bck1b9a5dre4c");
		domains.add("xn--c1avg");
		domains.add("xn--c2br7g");
		domains.add("xn--cck2b3b");
		domains.add("xn--cg4bki");
		domains.add("xn--clchc0ea0b2g2a9gcd");
		domains.add("xn--czr694b");
		domains.add("xn--czrs0t");
		domains.add("xn--czru2d");
		domains.add("xn--d1acj3b");
		domains.add("xn--d1alf");
		domains.add("xn--e1a4c");
		domains.add("xn--eckvdtc9d");
		domains.add("xn--efvy88h");
		domains.add("xn--estv75g");
		domains.add("xn--fct429k");
		domains.add("xn--fhbei");
		domains.add("xn--fiq228c5hs");
		domains.add("xn--fiq64b");
		domains.add("xn--fiqs8s");
		domains.add("xn--fiqz9s");
		domains.add("xn--fjq720a");
		domains.add("xn--flw351e");
		domains.add("xn--fpcrj9c3d");
		domains.add("xn--fzc2c9e2c");
		domains.add("xn--fzys8d69uvgm");
		domains.add("xn--g2xx48c");
		domains.add("xn--gckr3f0f");
		domains.add("xn--gecrj9c");
		domains.add("xn--gk3at1e");
		domains.add("xn--h2brj9c");
		domains.add("xn--hxt814e");
		domains.add("xn--i1b6b1a6a2e");
		domains.add("xn--imr513n");
		domains.add("xn--io0a7i");
		domains.add("xn--j1aef");
		domains.add("xn--j1amh");
		domains.add("xn--j6w193g");
		domains.add("xn--jlq61u9w7b");
		domains.add("xn--jvr189m");
		domains.add("xn--kcrx77d1x4a");
		domains.add("xn--kprw13d");
		domains.add("xn--kpry57d");
		domains.add("xn--kpu716f");
		domains.add("xn--kput3i");
		domains.add("xn--l1acc");
		domains.add("xn--lgbbat1ad8j");
		domains.add("xn--mgb9awbf");
		domains.add("xn--mgba3a3ejt");
		domains.add("xn--mgba3a4f16a");
		domains.add("xn--mgba7c0bbn0a");
		domains.add("xn--mgbaam7a8h");
		domains.add("xn--mgbab2bd");
		domains.add("xn--mgbayh7gpa");
		domains.add("xn--mgbb9fbpob");
		domains.add("xn--mgbbh1a71e");
		domains.add("xn--mgbc0a9azcg");
		domains.add("xn--mgbca7dzdo");
		domains.add("xn--mgberp4a5d4ar");
		domains.add("xn--mgbi4ecexp");
		domains.add("xn--mgbpl2fh");
		domains.add("xn--mgbt3dhd");
		domains.add("xn--mgbtx2b");
		domains.add("xn--mgbx4cd0ab");
		domains.add("xn--mix891f");
		domains.add("xn--mk1bu44c");
		domains.add("xn--mxtq1m");
		domains.add("xn--ngbc5azd");
		domains.add("xn--ngbe9e0a");
		domains.add("xn--node");
		domains.add("xn--nqv7f");
		domains.add("xn--nqv7fs00ema");
		domains.add("xn--nyqy26a");
		domains.add("xn--o3cw4h");
		domains.add("xn--ogbpf8fl");
		domains.add("xn--p1acf");
		domains.add("xn--p1ai");
		domains.add("xn--pbt977c");
		domains.add("xn--pgbs0dh");
		domains.add("xn--pssy2u");
		domains.add("xn--q9jyb4c");
		domains.add("xn--qcka1pmc");
		domains.add("xn--qxam");
		domains.add("xn--rhqv96g");
		domains.add("xn--rovu88b");
		domains.add("xn--s9brj9c");
		domains.add("xn--ses554g");
		domains.add("xn--t60b56a");
		domains.add("xn--tckwe");
		domains.add("xn--tiq49xqyj");
		domains.add("xn--unup4y");
		domains.add("xn--vermgensberater-ctb");
		domains.add("xn--vermgensberatung-pwb");
		domains.add("xn--vhquv");
		domains.add("xn--vuq861b");
		domains.add("xn--w4r85el8fhu5dnra");
		domains.add("xn--w4rs40l");
		domains.add("xn--wgbh1c");
		domains.add("xn--wgbl6a");
		domains.add("xn--xhq521b");
		domains.add("xn--xkc2al3hye2a");
		domains.add("xn--xkc2dl3a5ee0h");
		domains.add("xn--y9a3aq");
		domains.add("xn--yfro4i67o");
		domains.add("xn--ygbi2ammx");
		domains.add("xn--zfr164b");
		domains.add("xperia");
		domains.add("xxx");
		domains.add("xyz");
		domains.add("yachts");
		domains.add("yahoo");
		domains.add("yamaxun");
		domains.add("yandex");
		domains.add("ye");
		domains.add("yodobashi");
		domains.add("yoga");
		domains.add("yokohama");
		domains.add("you");
		domains.add("youtube");
		domains.add("yt");
		domains.add("yun");
		domains.add("za");
		domains.add("zappos");
		domains.add("zara");
		domains.add("zero");
		domains.add("zip");
		domains.add("zippo");
		domains.add("zm");
		domains.add("zone");
		domains.add("zuerich");
		domains.add("zw");
	}

	/*private static final Map<String, TopLevelDomain> MAP = Utils.toMap(new Object[][] {
			//GENERIC
			{"com", new TopLevelDomain("com", Type.GENERIC, "commercial")},
			{"org", new TopLevelDomain("org", Type.GENERIC, "organization")},
			{"net", new TopLevelDomain("net", Type.GENERIC, "network")},
			{"int", new TopLevelDomain("int", Type.GENERIC, "international organizations")},
			{"edu", new TopLevelDomain("edu", Type.GENERIC, "education")},
			{"gov", new TopLevelDomain("gov", Type.GENERIC, "U.S. national and state government agencies")},
			{"mil", new TopLevelDomain("mil", Type.GENERIC, "U.S. military")},
			//INFRASTRUCTURE
			{"arpa", new TopLevelDomain("arpa", Type.INFRASTRUCTURE, "Address and Routing Parameter Area")},
			//COUNTRY CODE
			{"ac", new TopLevelDomain("ac", Type.COUNTRY_CODE, "Ascension Island")},
			{"ad", new TopLevelDomain("ad", Type.COUNTRY_CODE, "Andorra")},
			{"ae", new TopLevelDomain("ae", Type.COUNTRY_CODE, "United Arab Emirates")},
			{"af", new TopLevelDomain("af", Type.COUNTRY_CODE, "Afghanistan")},
			{"ag", new TopLevelDomain("ag", Type.COUNTRY_CODE, "Antigua and Barbuda")},
			{"ai", new TopLevelDomain("ai", Type.COUNTRY_CODE, "Anguilla")},
			{"al", new TopLevelDomain("al", Type.COUNTRY_CODE, "Albania")},
			{"am", new TopLevelDomain("am", Type.COUNTRY_CODE,  "Armenia")},
			{"an", new TopLevelDomain("an", Type.COUNTRY_CODE, "Netherlands Antilles")},
			{"ao", new TopLevelDomain("ao", Type.COUNTRY_CODE, "Angola")},
			{"aq", new TopLevelDomain("aq", Type.COUNTRY_CODE, "Antarctique")},
			{"ar", new TopLevelDomain("ar", Type.COUNTRY_CODE, "Argentina")},
			{"as", new TopLevelDomain("as", Type.COUNTRY_CODE, "American Samoa")},
			{"at", new TopLevelDomain("at", Type.COUNTRY_CODE, "Austria")},
			{"au", new TopLevelDomain("au", Type.COUNTRY_CODE, "Australia")},
			{"aw", new TopLevelDomain("aw", Type.COUNTRY_CODE, "Aruba, West Indies")},
			{"ax", new TopLevelDomain("ax", Type.COUNTRY_CODE, "Åland")},
			{"az", new TopLevelDomain("az", Type.COUNTRY_CODE, "Azerbaijan")},

			{"ba", new TopLevelDomain("ba", Type.COUNTRY_CODE, "Bosnia and Herzegovina")},
			{"bb", new TopLevelDomain("bb", Type.COUNTRY_CODE, "Barbados")},
			{"bd", new TopLevelDomain("bd", Type.COUNTRY_CODE, "Bangladesh")},
			{"be", new TopLevelDomain("be", Type.COUNTRY_CODE, "Belgium")},
			{"bf", new TopLevelDomain("bf", Type.COUNTRY_CODE, "Burkina Faso")},
			{"bg", new TopLevelDomain("bg", Type.COUNTRY_CODE, "Bulgaria")},
			{"bh", new TopLevelDomain("bh", Type.COUNTRY_CODE, "Bahrain")},
			{"bi", new TopLevelDomain("bi", Type.COUNTRY_CODE, "Burundi")},
			{"bj", new TopLevelDomain("bj", Type.COUNTRY_CODE, "Benin")},
			{"bm", new TopLevelDomain("bm", Type.COUNTRY_CODE, "Bermuda")},
			{"bn", new TopLevelDomain("bn", Type.COUNTRY_CODE, "Brunei")},
			{"bo", new TopLevelDomain("bo", Type.COUNTRY_CODE, "Bolivia")},
			{"bq", new TopLevelDomain("bq", Type.COUNTRY_CODE, "Bonaire")},
			{"br", new TopLevelDomain("br", Type.COUNTRY_CODE, "Brazil")},
			{"bs", new TopLevelDomain("bs", Type.COUNTRY_CODE, "Bahamas")},
			{"bt", new TopLevelDomain("bt", Type.COUNTRY_CODE, "Bhutan")},
			{"bv", new TopLevelDomain("bv", Type.COUNTRY_CODE, "Bouvet Island")},
			{"by", new TopLevelDomain("by", Type.COUNTRY_CODE, "Belarus")},
			{"bz", new TopLevelDomain("bz", Type.COUNTRY_CODE, "Belize")},

			{"ca", new TopLevelDomain("ca", Type.COUNTRY_CODE, "Canada")},
			{"cc", new TopLevelDomain("cc",Type.COUNTRY_CODE, "Cocos (Keeling) Islands")},
			{"cd", new TopLevelDomain("cd",Type.COUNTRY_CODE, "Democratic Republic of the Congo")},
			{"cf", new TopLevelDomain("cf",Type.COUNTRY_CODE, "Central African Republic")},
			{"cg", new TopLevelDomain("cg",Type.COUNTRY_CODE, "Republic of the Congo")},
			{"ch", new TopLevelDomain("ch",Type.COUNTRY_CODE, "Switzerland")},
			{"ci", new TopLevelDomain("ci",Type.COUNTRY_CODE, "Côte d'Ivoire")},
			{"ck", new TopLevelDomain("ck",Type.COUNTRY_CODE, "Cook Islands")},
			{"cl", new TopLevelDomain("cl",Type.COUNTRY_CODE, "Chile")},
			{"cm", new TopLevelDomain("cm",Type.COUNTRY_CODE, "Cameroon")},
			{"cn", new TopLevelDomain("cn",Type.COUNTRY_CODE, "People's Republic of China")},
			{"co", new TopLevelDomain("co",Type.COUNTRY_CODE, "Colombia")},
			{"cr", new TopLevelDomain("cr",Type.COUNTRY_CODE, "Costa Rica")},
			{"cu", new TopLevelDomain("cu",Type.COUNTRY_CODE, "Cuba")},
			{"cv", new TopLevelDomain("cv",Type.COUNTRY_CODE, "Cape Verde")},
			{"cw", new TopLevelDomain("cw",Type.COUNTRY_CODE, "Curaçao")},
			{"cx", new TopLevelDomain("cx",Type.COUNTRY_CODE, "Christmas Island")},
			{"cy", new TopLevelDomain("cy",Type.COUNTRY_CODE, "Cyprus")},
			{"cz", new TopLevelDomain("cz",Type.COUNTRY_CODE, "Czech Republic")},

			{"de", new TopLevelDomain("de",Type.COUNTRY_CODE, "Germany")},
			{"dj", new TopLevelDomain("dj",Type.COUNTRY_CODE, "Djibouti")},
			{"dk", new TopLevelDomain("dk",Type.COUNTRY_CODE, "Denmark")},
			{"dm", new TopLevelDomain("dm",Type.COUNTRY_CODE, "Dominica")},
			{"do", new TopLevelDomain("do",Type.COUNTRY_CODE, "Dominican Republic")},
			{"dz", new TopLevelDomain("dz",Type.COUNTRY_CODE, "Algeria")},

			{"ec", new TopLevelDomain("ec",Type.COUNTRY_CODE, "Ecuador")},
			{"ee", new TopLevelDomain("ee",Type.COUNTRY_CODE, "Estonia")},
			{"eg", new TopLevelDomain("eg", Type.COUNTRY_CODE,"Egypt")},
			{"eh", new TopLevelDomain("eh",Type.COUNTRY_CODE, "Western Sahara")},
			{"er", new TopLevelDomain("er",Type.COUNTRY_CODE, "Eritrea")},
			{"es", new TopLevelDomain("es",Type.COUNTRY_CODE, "Spain")},
			{"et", new TopLevelDomain("et",Type.COUNTRY_CODE, "Ethiopia")},
			{"eu", new TopLevelDomain("eu",Type.COUNTRY_CODE, "European Union")},

			{"fi", new TopLevelDomain("fi",Type.COUNTRY_CODE, "Finland")},
			{"fj", new TopLevelDomain("fj",Type.COUNTRY_CODE, "Fiji")},
			{"fk", new TopLevelDomain("fk",Type.COUNTRY_CODE, "Falkland Islands")},
			{"fm", new TopLevelDomain("fm",Type.COUNTRY_CODE, "Federated States of Micronesia")},
			{"fo", new TopLevelDomain("fo",Type.COUNTRY_CODE, "Faroe Islands")},
			{"fr", new TopLevelDomain("fr",Type.COUNTRY_CODE, "France")},

			{"ga", new TopLevelDomain("ga",Type.COUNTRY_CODE, "Gabon")},
			{"gb", new TopLevelDomain("gb",Type.COUNTRY_CODE, "United Kingdom")},//Deprecated. The primary ccTLD used for the United Kingdom is .uk.
			{"gd", new TopLevelDomain("gd",Type.COUNTRY_CODE, "Grenada")},
			{"ge", new TopLevelDomain("ge",Type.COUNTRY_CODE, "Georgia")},
			{"gf", new TopLevelDomain("gf",Type.COUNTRY_CODE, "French Guiana")},
			{"gg", new TopLevelDomain("gg",Type.COUNTRY_CODE, "Guernsey")},
			{"gh", new TopLevelDomain("gh",Type.COUNTRY_CODE, "Ghana")},
			{"gi", new TopLevelDomain("gi",Type.COUNTRY_CODE, "Gibraltar")},
			{"gl", new TopLevelDomain("gl",Type.COUNTRY_CODE, "Greenland")},
			{"gm", new TopLevelDomain("gm",Type.COUNTRY_CODE, "The Gambia")},
			{"gn", new TopLevelDomain("gn",Type.COUNTRY_CODE, "Guinea")},
			{"gp", new TopLevelDomain("gp",Type.COUNTRY_CODE, "Guadeloupe")},
			{"gq", new TopLevelDomain("gq",Type.COUNTRY_CODE, "Equatorial Guinea")},
			{"gr", new TopLevelDomain("gr",Type.COUNTRY_CODE, "Greece")},
			{"gs", new TopLevelDomain("gs",Type.COUNTRY_CODE, "South Georgia and the South Sandwich Islands")},
			{"gt", new TopLevelDomain("gt",Type.COUNTRY_CODE, "Guatemala")},
			{"gu", new TopLevelDomain("gu",Type.COUNTRY_CODE, "Guam")},
			{"gw", new TopLevelDomain("gw",Type.COUNTRY_CODE, "Guinea-Bissau")},
			{"gy", new TopLevelDomain("gy",Type.COUNTRY_CODE, "Guyana")},

			{"hk", new TopLevelDomain("hk",Type.COUNTRY_CODE, "Hong Kong")},
			{"hm", new TopLevelDomain("hm",Type.COUNTRY_CODE, "Heard Island and McDonald Islands")},
			{"hn", new TopLevelDomain("hn",Type.COUNTRY_CODE, "Honduras")},
			{"hr", new TopLevelDomain("hr",Type.COUNTRY_CODE, "Croatia")},
			{"ht", new TopLevelDomain("ht",Type.COUNTRY_CODE, "Haiti")},
			{"hu", new TopLevelDomain("hu",Type.COUNTRY_CODE, "Hungary")},

			{"id", new TopLevelDomain("id",Type.COUNTRY_CODE, "Indonesia")},
			{"ie", new TopLevelDomain("ie",Type.COUNTRY_CODE, "Ireland")},
			{"il", new TopLevelDomain("il",Type.COUNTRY_CODE, "Israel")},
			{"im", new TopLevelDomain("im",Type.COUNTRY_CODE, "Isle of Man")},
			{"in", new TopLevelDomain("in",Type.COUNTRY_CODE, "India")},
			{"io", new TopLevelDomain("io",Type.COUNTRY_CODE, "British Indian Ocean Territory")},
			{"iq", new TopLevelDomain("iq",Type.COUNTRY_CODE, "Iraq")},
			{"ir", new TopLevelDomain("ir",Type.COUNTRY_CODE, "Iran")},
			{"is", new TopLevelDomain("is",Type.COUNTRY_CODE, "Iceland")},
			{"it", new TopLevelDomain("it",Type.COUNTRY_CODE, "Italy")},

			{"je", new TopLevelDomain("je",Type.COUNTRY_CODE, "Jersey")},
			{"jm", new TopLevelDomain("jm",Type.COUNTRY_CODE, "Jamaica")},
			{"jo", new TopLevelDomain("jo",Type.COUNTRY_CODE, "Jordan")},
			{"jp", new TopLevelDomain("jp",Type.COUNTRY_CODE, "Japan")},

			{"ke", new TopLevelDomain("ke",Type.COUNTRY_CODE, "Kenya")},
			{"kg", new TopLevelDomain("kg",Type.COUNTRY_CODE, "Kyrgyzstan")},
			{"kh", new TopLevelDomain("kh",Type.COUNTRY_CODE, "Cambodia")},
			{"ki", new TopLevelDomain("ki",Type.COUNTRY_CODE, "Kiribati")},
			{"km", new TopLevelDomain("km",Type.COUNTRY_CODE, "Comoros")},
			{"kn", new TopLevelDomain("kn",Type.COUNTRY_CODE, "Saint Kitts and Nevis")},
			{"kp", new TopLevelDomain("kp",Type.COUNTRY_CODE, "Democratic People's Republic of Korea")},
			{"kr", new TopLevelDomain("kr",Type.COUNTRY_CODE, "Republic of Korea")},
			{"kw", new TopLevelDomain("kw",Type.COUNTRY_CODE, "Kuwait")},
			{"ky", new TopLevelDomain("ky",Type.COUNTRY_CODE, "Cayman Islands")},
			{"kz", new TopLevelDomain("kz",Type.COUNTRY_CODE, "Kazakhstan")},

			{"la", new TopLevelDomain("la",Type.COUNTRY_CODE, "Laos")},
			{"lb", new TopLevelDomain("lb",Type.COUNTRY_CODE, "Lebanon")},
			{"lc", new TopLevelDomain("lc",Type.COUNTRY_CODE, "Saint Lucia")},
			{"li", new TopLevelDomain("li",Type.COUNTRY_CODE, "Liechtenstein")},
			{"lk", new TopLevelDomain("lk",Type.COUNTRY_CODE, "Sri Lanka")},
			{"lr", new TopLevelDomain("lr",Type.COUNTRY_CODE, "Liberia")},
			{"ls", new TopLevelDomain("ls",Type.COUNTRY_CODE, "Lesotho")},
			{"lt", new TopLevelDomain("lt",Type.COUNTRY_CODE, "Lithuania")},
			{"lu", new TopLevelDomain("lu",Type.COUNTRY_CODE, "Luxembourg")},
			{"lv", new TopLevelDomain("lv",Type.COUNTRY_CODE, "Latvia")},
			{"ly", new TopLevelDomain("ly",Type.COUNTRY_CODE, "Libya")},

			{"ma", new TopLevelDomain("ma",Type.COUNTRY_CODE, "Morocco")},
			{"mc", new TopLevelDomain("mc",Type.COUNTRY_CODE, "Monaco")},
			{"md", new TopLevelDomain("md",Type.COUNTRY_CODE, "Moldova")},
			{"me", new TopLevelDomain("me",Type.COUNTRY_CODE, "Montenegro")},
			{"mg", new TopLevelDomain("mg",Type.COUNTRY_CODE, "Madagascar")},
			{"mh", new TopLevelDomain("mh",Type.COUNTRY_CODE, "Marshall Islands")},
			{"mk", new TopLevelDomain("mk",Type.COUNTRY_CODE, "Macedonia")},
			{"ml", new TopLevelDomain("ml",Type.COUNTRY_CODE, "Mali")},
			{"mm", new TopLevelDomain("mm",Type.COUNTRY_CODE, "Myanmar")},
			{"mn", new TopLevelDomain("mn",Type.COUNTRY_CODE, "Mongolia")},
			{"mo", new TopLevelDomain("mo",Type.COUNTRY_CODE, "Macau")},
			{"mp", new TopLevelDomain("mp",Type.COUNTRY_CODE, "Northern Mariana Islands")},
			{"mq", new TopLevelDomain("mq",Type.COUNTRY_CODE, "Martinique")},
			{"mr", new TopLevelDomain("mr", Type.COUNTRY_CODE,"Mauritania")},
			{"ms", new TopLevelDomain("ms",Type.COUNTRY_CODE, "Montserrat")},
			{"mt", new TopLevelDomain("mt",Type.COUNTRY_CODE, "Malta")},
			{"mu", new TopLevelDomain("mu",Type.COUNTRY_CODE, "Mauritius")},
			{"mv", new TopLevelDomain("mv",Type.COUNTRY_CODE, "Maldives")},
			{"mw", new TopLevelDomain("mw",Type.COUNTRY_CODE, "Malawi")},
			{"mx", new TopLevelDomain("mx",Type.COUNTRY_CODE, "Mexico")},
			{"my", new TopLevelDomain("my",Type.COUNTRY_CODE, "Malaysia")},
			{"mz", new TopLevelDomain("mz",Type.COUNTRY_CODE, "Mozambique")},

			{"na", new TopLevelDomain("na",Type.COUNTRY_CODE, "Namibia")},
			{"nc", new TopLevelDomain("nc",Type.COUNTRY_CODE, "New Caledonia")},
			{"ne", new TopLevelDomain("ne",Type.COUNTRY_CODE, "Niger")},
			{"nf", new TopLevelDomain("nf",Type.COUNTRY_CODE, "Norfolk Island")},
			{"ng", new TopLevelDomain("ng",Type.COUNTRY_CODE, "Nigeria")},
			{"ni", new TopLevelDomain("ni",Type.COUNTRY_CODE, "Nicaragua")},
			{"nl", new TopLevelDomain("nl",Type.COUNTRY_CODE, "Netherlands")},
			{"no", new TopLevelDomain("no",Type.COUNTRY_CODE, "Norway")},
			{"np", new TopLevelDomain("np",Type.COUNTRY_CODE, "Nepal")},
			{"nr", new TopLevelDomain("nr",Type.COUNTRY_CODE, "Nauru")},
			{"nu", new TopLevelDomain("nu",Type.COUNTRY_CODE, "Niue")},
			{"nz", new TopLevelDomain("nz",Type.COUNTRY_CODE, "New Zealand")},

			{"om", new TopLevelDomain("om",Type.COUNTRY_CODE, "Oman")},

			{"pa", new TopLevelDomain("pa",Type.COUNTRY_CODE, "Panama")},
			{"pe", new TopLevelDomain("pe",Type.COUNTRY_CODE, "Peru")},
			{"pf", new TopLevelDomain("pf",Type.COUNTRY_CODE, "French Polynesia")},
			{"pg", new TopLevelDomain("pg",Type.COUNTRY_CODE, "Papua New Guinea")},
			{"ph", new TopLevelDomain("ph",Type.COUNTRY_CODE, "Philippines")},
			{"pk", new TopLevelDomain("pk",Type.COUNTRY_CODE, "Pakistan")},
			{"pl", new TopLevelDomain("pl",Type.COUNTRY_CODE, "Poland")},
			{"pm", new TopLevelDomain("pm",Type.COUNTRY_CODE, "Saint-Pierre and Miquelon")},
			{"pn", new TopLevelDomain("pn",Type.COUNTRY_CODE, "Pitcairn Islands")},
			{"pr", new TopLevelDomain("pr",Type.COUNTRY_CODE, "Puerto Rico")},
			{"ps", new TopLevelDomain("ps",Type.COUNTRY_CODE, "Palestine")},
			{"pt", new TopLevelDomain("pt",Type.COUNTRY_CODE, "Portugal")},
			{"pw", new TopLevelDomain("pw",Type.COUNTRY_CODE, "Palau")},
			{"py", new TopLevelDomain("py",Type.COUNTRY_CODE, "Paraguay")},

			{"qa", new TopLevelDomain("qa",Type.COUNTRY_CODE, "Qatar")},

			{"re", new TopLevelDomain("re",Type.COUNTRY_CODE, "Réunion")},
			{"ro", new TopLevelDomain("ro",Type.COUNTRY_CODE, "Romania")},
			{"rs", new TopLevelDomain("rs",Type.COUNTRY_CODE, "Serbia" )},
			{"ru", new TopLevelDomain("ru",Type.COUNTRY_CODE, "Russia")},
			{"rw", new TopLevelDomain("rw",Type.COUNTRY_CODE, "Rwanda")},

			{"sa", new TopLevelDomain("sa",Type.COUNTRY_CODE, "Saudi Arabia")},
			{"sb", new TopLevelDomain("sb",Type.COUNTRY_CODE, "Solomon Islands")},
			{"sc", new TopLevelDomain("sc",Type.COUNTRY_CODE, "Seychelles")},
			{"sd", new TopLevelDomain("sd",Type.COUNTRY_CODE, "Sudan")},
			{"se", new TopLevelDomain("se",Type.COUNTRY_CODE, "Sweden")},
			{"sg", new TopLevelDomain("sg",Type.COUNTRY_CODE, "Singapore")},
			{"sh", new TopLevelDomain("sh",Type.COUNTRY_CODE, "Saint Helena")},
			{"si", new TopLevelDomain("si",Type.COUNTRY_CODE, "Slovenia")},
			{"sj", new TopLevelDomain("sj",Type.COUNTRY_CODE, "Svalbard and Jan Mayen Islands")},
			{"sk", new TopLevelDomain("sk",Type.COUNTRY_CODE, "Slovakia")},
			{"sl", new TopLevelDomain("sl",Type.COUNTRY_CODE, "Sierra Leone")},
			{"sm", new TopLevelDomain("sm",Type.COUNTRY_CODE, "San Marino")},
			{"sn", new TopLevelDomain("sn", Type.COUNTRY_CODE,"Senegal")},
			{"so", new TopLevelDomain("so",Type.COUNTRY_CODE, "Somalia")},
			{"sr", new TopLevelDomain("sr",Type.COUNTRY_CODE, "Suriname")},
			{"ss", new TopLevelDomain("ss",Type.COUNTRY_CODE, "South Sudan")},//Removed from the root DNS zone in April 2013
			{"st", new TopLevelDomain("st",Type.COUNTRY_CODE, "São Tomé and Príncipe")},
			{"su", new TopLevelDomain("su",Type.COUNTRY_CODE, "Soviet Union")},//Still in use.
			{"sv", new TopLevelDomain("sv",Type.COUNTRY_CODE, "El Salvador")},
			{"sx", new TopLevelDomain("sx",Type.COUNTRY_CODE, "Sint Maarten")},
			{"sy", new TopLevelDomain("sy",Type.COUNTRY_CODE, "Syria")},
			{"sz", new TopLevelDomain("sz", Type.COUNTRY_CODE,"Swaziland")},

			{"tc", new TopLevelDomain("tc",Type.COUNTRY_CODE, "Turks and Caicos Islands")},
			{"td", new TopLevelDomain("td",Type.COUNTRY_CODE, "Chad")},
			{"tf", new TopLevelDomain("tf",Type.COUNTRY_CODE, "French Southern and Antarctic Lands")},
			{"tg", new TopLevelDomain("tg",Type.COUNTRY_CODE, "Togo")},
			{"th", new TopLevelDomain("th",Type.COUNTRY_CODE, "Thailand")},
			{"tj", new TopLevelDomain("tj",Type.COUNTRY_CODE, "Tajikistan")},
			{"tk", new TopLevelDomain("tk",Type.COUNTRY_CODE, "Tokelau")},
			{"tl", new TopLevelDomain("tl",Type.COUNTRY_CODE, "East Timor")},
			{"tm", new TopLevelDomain("tm",Type.COUNTRY_CODE, "Turkmenistan")},
			{"tn", new TopLevelDomain("tn",Type.COUNTRY_CODE, "Tunisia")},
			{"to", new TopLevelDomain("to",Type.COUNTRY_CODE, "Tonga")},
			{"tp", new TopLevelDomain("tp",Type.COUNTRY_CODE, "East Timor")},
			{"tr", new TopLevelDomain("tr",Type.COUNTRY_CODE, "Turkey")},
			{"tt", new TopLevelDomain("tt", Type.COUNTRY_CODE,"Trinidad and Tobago")},
			{"tv", new TopLevelDomain("tv",Type.COUNTRY_CODE, "Tuvalu")},
			{"tw", new TopLevelDomain("tw",Type.COUNTRY_CODE, "Taiwan")},
			{"tz", new TopLevelDomain("tz",Type.COUNTRY_CODE, "Tanzania")},

			{"ua", new TopLevelDomain("ua",Type.COUNTRY_CODE, "Ukraine")},
			{"ug", new TopLevelDomain("ug",Type.COUNTRY_CODE, "Uganda")},
			{"uk", new TopLevelDomain("uk",Type.COUNTRY_CODE, "United Kingdom")},
			{"us", new TopLevelDomain("us",Type.COUNTRY_CODE, "United States of America")},
			{"uy", new TopLevelDomain("uy",Type.COUNTRY_CODE, "Uruguay")},
			{"uz", new TopLevelDomain("uz",Type.COUNTRY_CODE, "Uzbekistan")},

			{"va", new TopLevelDomain("va",Type.COUNTRY_CODE, "Vatican City")},
			{"vc", new TopLevelDomain("vc",Type.COUNTRY_CODE, "Saint Vincent and the Grenadines")},
			{"ve", new TopLevelDomain("ve",Type.COUNTRY_CODE, "Venezuela")},
			{"vg", new TopLevelDomain("vg",Type.COUNTRY_CODE, "British Virgin Islands")},
			{"vi", new TopLevelDomain("vi",Type.COUNTRY_CODE, "United States Virgin Islands")},
			{"vn", new TopLevelDomain("vn",Type.COUNTRY_CODE, "Vietnam")},
			{"vu", new TopLevelDomain("vu",Type.COUNTRY_CODE, "Vanuatu")},

			{"wf", new TopLevelDomain("wf",Type.COUNTRY_CODE, "Wallis and Futuna")},
			{"ws", new TopLevelDomain("ws",Type.COUNTRY_CODE, "Samoa")},

			{"ye", new TopLevelDomain("ye",Type.COUNTRY_CODE, "Yemen")},
			{"yt", new TopLevelDomain("yt",Type.COUNTRY_CODE, "Mayotte")},

			{"za", new TopLevelDomain("za", Type.COUNTRY_CODE,"South Africa")},
			{"zm", new TopLevelDomain("zm",Type.COUNTRY_CODE, "Zambia")},
			{"zw", new TopLevelDomain("zw",Type.COUNTRY_CODE, "Zimbabwe")},

			//RESTRICTED GENERIC - ICANN-era generic top-level domains
			{"academy", new TopLevelDomain("academy", Type.GENERIC, "academic institutes")},
			{"accountant", new TopLevelDomain("accountant", Type.GENERIC, "accountants and accounting firms")},
			{"accountants", new TopLevelDomain("accountants", Type.GENERIC, "accountants and accounting firms")},
			{"active", new TopLevelDomain("active",Type.GENERIC,  "general")},
			{"actor", new TopLevelDomain("actor", Type.GENERIC, "actors")},
			{"adult", new TopLevelDomain("adult", Type.GENERIC, "adult entertainment (pornography)")},
			{"aero", new TopLevelDomain("aero", Type.GENERIC, "air-transport industry")},
			{"agency", new TopLevelDomain("agency", Type.GENERIC, "business associations")},
			{"airforce", new TopLevelDomain("airforce", Type.GENERIC, "defense contractors")},
			{"apartments", new TopLevelDomain("apartments", Type.GENERIC, "apartments")},
			{"app", new TopLevelDomain("app",Type.GENERIC,  "Phone apps")},
			{"archi", new TopLevelDomain("archi", Type.GENERIC, "architects and architect firms")},
			{"army", new TopLevelDomain("army", Type.GENERIC, "defense contractors")},
			{"associates", new TopLevelDomain("associates", Type.GENERIC, "business associations")},
			{"attorney", new TopLevelDomain("attorney", Type.GENERIC, "attorneys and legal organizations")},
			{"auction", new TopLevelDomain("auction", Type.GENERIC, "")},
			{"audio", new TopLevelDomain("audio",Type.GENERIC,  "stereo/sound systems, music")},
			{"autos", new TopLevelDomain("autos",Type.GENERIC, "")},
			{"band", new TopLevelDomain("band",Type.GENERIC, "")},
			{"bar", new TopLevelDomain("bar", Type.GENERIC, "Bars and related industry")},
			{"bargains", new TopLevelDomain("bargains",Type.GENERIC,  "coupons and online sellers")},
			{"beer", new TopLevelDomain("beer", Type.GENERIC, "breweries and beer aficionados")},
			{"best", new TopLevelDomain("best",Type.GENERIC, "")},
			{"bid", new TopLevelDomain("bid", Type.GENERIC, "auctions")},
			{"bike", new TopLevelDomain("bike", Type.GENERIC, "bicycles")},
			{"bingo", new TopLevelDomain("bingo", Type.GENERIC, "")},
			{"bio", new TopLevelDomain("bio",Type.GENERIC,  "biodiversity, biographies")},
			{"biz", new TopLevelDomain("biz", Type.GENERIC, "business")},
			{"black", new TopLevelDomain("black", Type.GENERIC, "those who like the color black")},
			{"blackfriday", new TopLevelDomain("blackfriday",Type.GENERIC,  "Black Friday, retail")},
			{"blog", new TopLevelDomain("blog", Type.GENERIC, "Blogs")},
			{"blue", new TopLevelDomain("blue", Type.GENERIC, "those who like the color blue")},
			{"boo", new TopLevelDomain("boo", Type.GENERIC, "ghosts and spooky business")},
			{"boutique", new TopLevelDomain("boutique",Type.GENERIC,  "specialized businesses")},
			{"build", new TopLevelDomain("build",Type.GENERIC,  "construction industry")},
			{"builders", new TopLevelDomain("builders",Type.GENERIC,  "construction workers")},
			{"business", new TopLevelDomain("business",Type.GENERIC,  "businesses")},
			{"buzz", new TopLevelDomain("buzz",Type.GENERIC,  "marketing and social networking")},
			{"cab", new TopLevelDomain("cab",Type.GENERIC,  "cabs and taxi companies")},
			{"camera", new TopLevelDomain("camera", Type.GENERIC, "camera-related businesses")},
			{"camp", new TopLevelDomain("camp", Type.GENERIC, "camps and camping")},
			{"cancerresearch", new TopLevelDomain("cancerresearch",Type.GENERIC,  "Organizations, research institutes and individuals interested in ending cancer through research")},
			{"capital", new TopLevelDomain("capital", Type.GENERIC, "financial firms")},
			{"cards", new TopLevelDomain("cards",Type.GENERIC,  "general")},
			{"care", new TopLevelDomain("care",Type.GENERIC,  "healthcare industry")},
			{"career", new TopLevelDomain("career", Type.GENERIC, "")},
			{"careers", new TopLevelDomain("careers",Type.GENERIC,  "Employment")},
			{"cash", new TopLevelDomain("cash",Type.GENERIC,  "financial")},
			{"casino", new TopLevelDomain("casino", Type.GENERIC, "")},
			{"catering", new TopLevelDomain("catering",Type.GENERIC,  "Food service")},
			{"center", new TopLevelDomain("center",Type.GENERIC,  "general")},
			{"ceo", new TopLevelDomain("ceo", Type.GENERIC, "CEOs")},
			{"channel", new TopLevelDomain("channel", Type.GENERIC, "")},
			{"chat", new TopLevelDomain("chat",Type.GENERIC,  "online chat")},
			{"cheap", new TopLevelDomain("cheap", Type.GENERIC, "Resellers")},
			{"christmas", new TopLevelDomain("christmas",Type.GENERIC,  "Christmas")},
			{"church", new TopLevelDomain("church",Type.GENERIC,  "churches")},
			{"city", new TopLevelDomain("city", Type.GENERIC, "general")},
			{"claims", new TopLevelDomain("claims", Type.GENERIC, "retail, auctions")},
			{"cleaning", new TopLevelDomain("cleaning", Type.GENERIC, "Cleaning services")},
			{"click", new TopLevelDomain("click", Type.GENERIC, "")},
			{"clinic", new TopLevelDomain("clinic",Type.GENERIC,  "healthcare clinics")},
			{"clothing", new TopLevelDomain("clothing",Type.GENERIC,  "Apparel")},
			{"cloud", new TopLevelDomain("cloud", Type.GENERIC, "")},
			{"club", new TopLevelDomain("club", Type.GENERIC, "groups, organizations, assemblies, communities, general")},
			{"coach", new TopLevelDomain("coach", Type.GENERIC, "travel (flights and motor coaches)")},
			{"codes", new TopLevelDomain("codes", Type.GENERIC, "computer and/or encryption code enthusiasts")},
			{"coffee", new TopLevelDomain("coffee",Type.GENERIC,  "cafés and coffee aficionados")},
			{"college", new TopLevelDomain("college", Type.GENERIC, "Educational")},
			{"community", new TopLevelDomain("community",Type.GENERIC, "social groups, neighborhoods")},
			{"company", new TopLevelDomain("company",Type.GENERIC, "business associations")},
			{"computer", new TopLevelDomain("computer",Type.GENERIC, "Technology")},
			{"condos", new TopLevelDomain("condos",Type.GENERIC, "Real estate")},
			{"construction", new TopLevelDomain("construction",Type.GENERIC, "Construction industry")},
			{"consulting", new TopLevelDomain("consulting",Type.GENERIC, "hired advisors")},
			{"contractors", new TopLevelDomain("contractors",Type.GENERIC, "Remodeling and independent businesses")},
			{"cooking", new TopLevelDomain("cooking",Type.GENERIC, "sharing recipes")},
			{"cool", new TopLevelDomain("cool",Type.GENERIC, "General interests")},
			{"coop", new TopLevelDomain("coop",Type.GENERIC, "cooperatives,The .coop TLD is limited to cooperatives as defined by the Rochdale Principles.")},
			{"country", new TopLevelDomain("country",Type.GENERIC, "general")},
			{"coupons", new TopLevelDomain("coupons",Type.GENERIC, "coupons")},
			{"credit", new TopLevelDomain("credit",Type.GENERIC, "Financial institutions")},
			{"creditcard", new TopLevelDomain("creditcard",Type.GENERIC, "Financial institutions")},
			{"cricket", new TopLevelDomain("cricket",Type.GENERIC, "cricket")},
			{"cruises", new TopLevelDomain("cruises",Type.GENERIC, "cruise businesses and travel")},
			{"dad", new TopLevelDomain("dad",Type.GENERIC, "families")},
			{"dance", new TopLevelDomain("dance",Type.GENERIC, "Dance studios and companies")},
			{"date", new TopLevelDomain("date",Type.GENERIC, "online dating")},
			{"dating", new TopLevelDomain("dating",Type.GENERIC, "online dating")},
			{"day", new TopLevelDomain("day",Type.GENERIC, "general")},
			{"deals", new TopLevelDomain("deals",Type.GENERIC, "online shopping and couponing")},
			{"degree", new TopLevelDomain("degree",Type.GENERIC, "general")},
			{"delivery", new TopLevelDomain("delivery",Type.GENERIC, "general")},
			{"democrat", new TopLevelDomain("democrat",Type.GENERIC, "Democratic Party politics")},
			{"dental", new TopLevelDomain("dental",Type.GENERIC, "dentists")},
			{"dentist", new TopLevelDomain("dentist",Type.GENERIC, "dentists")},
			{"design", new TopLevelDomain("design",Type.GENERIC, "graphic art and fashion")},
			{"diamonds", new TopLevelDomain("diamonds",Type.GENERIC, "diamond and jewelry industry")},
			{"diet", new TopLevelDomain("diet",Type.GENERIC)},
			{"digital", new TopLevelDomain("digital",Type.GENERIC,"general")},
			{"direct", new TopLevelDomain("direct",Type.GENERIC,"general")},
			{"directory", new TopLevelDomain("directory",Type.GENERIC,"general directory")},
			{"discount", new TopLevelDomain("discount",Type.GENERIC,"general")},
			{"dog", new TopLevelDomain("dog",Type.GENERIC,"dog stores and owners")},
			{"domains", new TopLevelDomain("domains",Type.GENERIC,"domain registries")},
			{"download", new TopLevelDomain("download",Type.GENERIC,"technology")},
			{"eat", new TopLevelDomain("eat",Type.GENERIC,"restaurants and foodies")},
			{"education", new TopLevelDomain("education",Type.GENERIC,"educational institutes")},
			{"email", new TopLevelDomain("email",Type.GENERIC,"email")},
			{"energy", new TopLevelDomain("energy",Type.GENERIC,"energy industry and marketing")},
			{"engineer", new TopLevelDomain("engineer",Type.GENERIC,"engineers and engineering firms")},
			{"engineering", new TopLevelDomain("engineering",Type.GENERIC,"engineering firms")},
			{"equipment", new TopLevelDomain("equipment",Type.GENERIC,"equipment-related businesses")},
			{"esq", new TopLevelDomain("esq",Type.GENERIC,"lawyers, law firms, legal professionals")},
			{"estate", new TopLevelDomain("estate",Type.GENERIC,"real estate businesses")},
			{"events", new TopLevelDomain("events",Type.GENERIC,"happenings")},
			{"exchange", new TopLevelDomain("exchange",Type.GENERIC,"generic trade")},
			{"expert", new TopLevelDomain("expert",Type.GENERIC,"generic expertise")},
			{"exposed", new TopLevelDomain("exposed",Type.GENERIC,"general interest")},
			{"express", new TopLevelDomain("express",Type.GENERIC,"shipping")},
			{"fail", new TopLevelDomain("fail",Type.GENERIC,"general")},
			{"faith", new TopLevelDomain("faith",Type.GENERIC,"religion and churches")},
			{"family", new TopLevelDomain("family",Type.GENERIC,"families")},
			{"fans", new TopLevelDomain("fans",Type.GENERIC,"general")},
			{"farm", new TopLevelDomain("farm",Type.GENERIC,"farms and agriculture")},
			{"fashion", new TopLevelDomain("fashion",Type.GENERIC,"clothing industry")},
			{"feedback", new TopLevelDomain("feedback", Type.GENERIC)},
			{"finance", new TopLevelDomain("finance",Type.GENERIC,"financial")},
			{"financial", new TopLevelDomain("financial",Type.GENERIC,"financial")},
			{"fish", new TopLevelDomain("fish",Type.GENERIC,"fishing businesses, sports, and interests")},
			{"fishing", new TopLevelDomain("fishing",Type.GENERIC,"fishing businesses, sports, and interests")},
			{"fit", new TopLevelDomain("fit",Type.GENERIC,"Fitness and exercise")},
			{"fitness", new TopLevelDomain("fitness",Type.GENERIC,"Fitness and exercise")},
			{"flights", new TopLevelDomain("flights",Type.GENERIC,"airline businesses and travel")},
			{"florist", new TopLevelDomain("florist",Type.GENERIC,"florists")},
			{"flowers", new TopLevelDomain("flowers",Type.GENERIC,"florists and gardens")},
			{"fly", new TopLevelDomain("fly",Type.GENERIC,"travel")},
			{"foo", new TopLevelDomain("foo",Type.GENERIC,"web development")},
			{"football", new TopLevelDomain("football",Type.GENERIC,"soccer and American football")},
			{"forsale", new TopLevelDomain("forsale",Type.GENERIC,"online retail")},
			{"foundation", new TopLevelDomain("foundation",Type.GENERIC,"charitable organizations")},
			{"fund", new TopLevelDomain("fund",Type.GENERIC,"financial")},
			{"furniture", new TopLevelDomain("furniture",Type.GENERIC,"furniture businesses")},
			{"fyi", new TopLevelDomain("fyi",Type.GENERIC,"\"for your information\"")},
			{"gallery", new TopLevelDomain("gallery",Type.GENERIC,"photo and art galleries")},
			{"garden", new TopLevelDomain("garden",Type.GENERIC,"gardening")},
			{"gift", new TopLevelDomain("gift",Type.GENERIC,"gift-giving")},
			{"gifts", new TopLevelDomain("gifts",Type.GENERIC,"gift-giving")},
			{"gives", new TopLevelDomain("gives",Type.GENERIC,"charities and gift-giving")},
			{"glass", new TopLevelDomain("glass",Type.GENERIC,"window sales and repairs")},
			{"global", new TopLevelDomain("global",Type.GENERIC,"general")},
			{"gold", new TopLevelDomain("gold",Type.GENERIC,"gold and luxury")},
			{"golf", new TopLevelDomain("golf",Type.GENERIC,"golf")},
			{"gop", new TopLevelDomain("gop",Type.GENERIC,"Republican Party politics")},
			{"graphics", new TopLevelDomain("graphics",Type.GENERIC,"graphics")},
			{"green", new TopLevelDomain("green",Type.GENERIC,"the environmentally-focused")},
			{"gripe", new TopLevelDomain("gripe",Type.GENERIC,"opinion sites")},
			{"guide", new TopLevelDomain("guide",Type.GENERIC,"help sites")},
			{"guitars", new TopLevelDomain("guitars",Type.GENERIC,"Guitars")},
			{"guru", new TopLevelDomain("guru",Type.GENERIC,"generic expertise")},
			{"healthcare", new TopLevelDomain("healthcare",Type.GENERIC,"healthcare industry")},
			{"help", new TopLevelDomain("help",Type.GENERIC,"help sites")},
			{"here", new TopLevelDomain("here",Type.GENERIC,"generic geographic")},
			{"hiphop", new TopLevelDomain("hiphop",Type.GENERIC,"Hip hop culture")},
			{"hiv", new TopLevelDomain("hiv",Type.GENERIC,"AIDS and HIV")},
			{"hockey", new TopLevelDomain("hockey",Type.GENERIC,"hockey")},
			{"holdings", new TopLevelDomain("holdings",Type.GENERIC,"real estate or financial business")},
			{"holiday", new TopLevelDomain("holiday",Type.GENERIC,"holiday gift industry")},
			{"homes", new TopLevelDomain("homes",Type.GENERIC,"individuals interested in real estate and home improvement")},
			{"horse", new TopLevelDomain("horse",Type.GENERIC,"horse-related businesses and interest")},
			{"host", new TopLevelDomain("host",Type.GENERIC,"network companies")},
			{"hosting", new TopLevelDomain("hosting", Type.GENERIC)},
			{"house", new TopLevelDomain("house",Type.GENERIC,"real estate and construction businesses")},
			{"how", new TopLevelDomain("how",Type.GENERIC,"how-to guides")},
			{"info", new TopLevelDomain("info",Type.GENERIC,"information")},
			{"ing", new TopLevelDomain("ing",Type.GENERIC,"Verbal suffix: e.g., \"jump.ing\".")},
			{"ink", new TopLevelDomain("ink",Type.GENERIC,"creative printing or tattooing")},
			{"institute", new TopLevelDomain("institute", Type.GENERIC)},
			{"insure", new TopLevelDomain("insure",Type.GENERIC,"Insurance companies")},
			{"international", new TopLevelDomain("international",Type.GENERIC,"international entities")},
			{"investments", new TopLevelDomain("investments",Type.GENERIC,"financial")},
			{"jewelry", new TopLevelDomain("jewelry",Type.GENERIC,"jewelry stores")},
			{"jobs", new TopLevelDomain("jobs",Type.GENERIC,"Employment")},
			{"kim", new TopLevelDomain("kim",Type.GENERIC,"people named Kim Also means \"who\" in Turkish")},
			{"kitchen", new TopLevelDomain("kitchen",Type.GENERIC,"food industry and remodeling")},
			{"land", new TopLevelDomain("land",Type.GENERIC,"real estate")},
			{"lawyer", new TopLevelDomain("lawyer",Type.GENERIC,"lawyers and legal organizations")},
			{"lease", new TopLevelDomain("lease",Type.GENERIC,"financing")},
			{"legal", new TopLevelDomain("legal",Type.GENERIC,"lawyers and legal organizations")},
			{"lgbt", new TopLevelDomain("lgbt",Type.GENERIC,"the lesbian, gay, bisexual and transgender community")},
			{"life", new TopLevelDomain("life",Type.GENERIC,"general")},
			{"lighting", new TopLevelDomain("lighting",Type.GENERIC,"lighting")},
			{"limited", new TopLevelDomain("limited",Type.GENERIC,"general")},
			{"limo", new TopLevelDomain("limo",Type.GENERIC,"limousine businesses")},
			{"link", new TopLevelDomain("link",Type.GENERIC,"connecting to information[65]")},
			{"loan", new TopLevelDomain("loan",Type.GENERIC,"banks and lenders")},
			{"loans", new TopLevelDomain("loans",Type.GENERIC,"banks and lenders")},
			{"lol", new TopLevelDomain("lol",Type.GENERIC,"LOL: laughing out loud")},
			{"lotto", new TopLevelDomain("lotto", Type.GENERIC,)},
			{"love", new TopLevelDomain("love",Type.GENERIC,"dating sites")},
			{"luxe", new TopLevelDomain("luxe", Type.GENERIC,)},
			{"luxury", new TopLevelDomain("luxury",Type.GENERIC,"businesses catering to the wealthy")},
			{"management", new TopLevelDomain("management",Type.GENERIC,"business management")},
			{"market", new TopLevelDomain("market",Type.GENERIC,"marketing services and retailers")},
			{"marketing", new TopLevelDomain("marketing",Type.GENERIC,"marketing services")},
			{"markets", new TopLevelDomain("markets",Type.GENERIC,"financial and stock markets")},
			{"mba", new TopLevelDomain("mba",Type.GENERIC,"Masters in Business Administration")},
			{"media", new TopLevelDomain("media",Type.GENERIC,"general media interests")},
			{"meet", new TopLevelDomain("meet",Type.GENERIC,"social gatherings, meeting new people")},
			{"meme", new TopLevelDomain("meme",Type.GENERIC,"Internet memes")},
			{"memorial", new TopLevelDomain("memorial",Type.GENERIC,"memorial sites")},
			{"men", new TopLevelDomain("men",Type.GENERIC,"men")},
			{"menu", new TopLevelDomain("menu",Type.GENERIC,"restaurants")},
			{"mobi", new TopLevelDomain("mobi","Type.GENERIC,mobile devices")},
			{"moe", new TopLevelDomain("moe",Type.GENERIC,"Japanese otaku culture The word \"moe\" (Japanese: 萌え?, pronounced as \"moh-ay\") is a slang word rooted deep in the Japanese Otaku culture. It has often been used to mean a particular type of \"adorable\" or \"cute\" towards fictional characters, people, animals, etc.")},
			{"money", new TopLevelDomain("money",Type.GENERIC,"financial")},
			{"mortgage", new TopLevelDomain("mortgage",Type.GENERIC,"mortgage lenders")},
			{"motorcycles", new TopLevelDomain("motorcycles",Type.GENERIC,"motorcycles")},
			{"mov", new TopLevelDomain("mov",Type.GENERIC,"Digital video")},
			{"movie", new TopLevelDomain("movie",Type.GENERIC,"movies and cinemas")},
			{"museum", new TopLevelDomain("museum",Type.GENERIC,"museums")},
			{"name", new TopLevelDomain("name",Type.GENERIC,"individuals, by name", "Open TLD; any person or entity is permitted to register; however, registrations may be challenged later if they are not by individuals (or the owners of fictional characters) in accordance with the domain's charter.")},
			{"navy", new TopLevelDomain("navy",Type.GENERIC,"defense contractors")},
			{"network", new TopLevelDomain("network",Type.GENERIC,"general")},
			{"new", new TopLevelDomain("new","general")},
			{"news", new TopLevelDomain("news","news sites")},
			{"ngo", new TopLevelDomain("ngo","Non-governmental organizations. Sold packaged with .ong.","Restricted to validated NGOs, as determined by PIR. See the eligibility requirements.")},
			{"ninja", new TopLevelDomain("ninja","general expertise")},
			{"one", new TopLevelDomain("one","general")},
			{"ong", new TopLevelDomain("ong","Non-governmental organizations. Sold packaged with .ngo.","Restricted to validated NGOs, as determined by PIR. See the eligibility requirements.")},
			{"onl", new TopLevelDomain("onl","short for \"online\"")},
			{"online", new TopLevelDomain("online","generic")},
			{"ooo", new TopLevelDomain("ooo","general")},
			{"organic", new TopLevelDomain("organic","organic gardeners, farmers, foods, etc.","Registrants must be verified as a member of the organic community.")},
			{"partners", new TopLevelDomain("partners","businesses")},
			{"parts", new TopLevelDomain("parts","manufacturing and consumer auto")},
			{"party", new TopLevelDomain("party","nightclubs and social gatherings")},
			{"pharmacy", new TopLevelDomain("pharmacy","pharmacies","\"All registrants within the .pharmacy gTLD are vetted prior to registration to confirm that they meet all applicable regulatory standards, including pharmacy licensure and valid prescription requirements, in the jurisdictions where they are based and where they serve patients.\"")},
			{"photo", new TopLevelDomain("photo","photography and photo-sharing")},
			{"photography", new TopLevelDomain("photography","photography and photo-sharing")},
			{"photos", new TopLevelDomain("photos","photography and photo-sharing")},
			{"physio", new TopLevelDomain("physio","physical therapists", "Must be eligible for membership within an association that is a member of the World Confederation for Physical Therapy, have proper training as a physical therapist outside WCPT's reach, or otherwise supports physical therapy.")},
			{"pics", new TopLevelDomain("pics","photography and photo-sharing")},
			{"pictures", new TopLevelDomain("pictures","photography and photo-sharing")},
			{"pid", new TopLevelDomain("pid")},
			{"pink", new TopLevelDomain("pink","those who like the color pink")},
			{"pizza", new TopLevelDomain("pizza","pizza parlors")},
			{"place", new TopLevelDomain("place","general")},
			{"plumbing", new TopLevelDomain("plumbing","plumbing businesses")},
			{"plus", new TopLevelDomain("plus","generic")},
			{"poker", new TopLevelDomain("poker","Poker players and sites")},
			{"porn", new TopLevelDomain("porn","adult entertainment (pornography)", "For sites providing sexually explicit content, such as pornography.")},
			{"post", new TopLevelDomain("post","postal services", "The .post TLD is restricted to Postal Administrations as defined in the Universal Postal Union constitution, and their large customers who wish to provide \"Trusted Postal Services\".")},
			{"press", new TopLevelDomain("press","publishing and journalism")},
			{"pro", new TopLevelDomain("pro","professions/professionals")},
			{"productions", new TopLevelDomain("productions","studio/art businesses")},
			{"prof", new TopLevelDomain("prof","Professors, teachers and learning")},
			{"properties", new TopLevelDomain("properties","real estate")},
			{"property", new TopLevelDomain("property","real estate")},
			{"qpon", new TopLevelDomain("qpon","coupons")},
			{"racing", new TopLevelDomain("racing","racing")},
			{"recipes", new TopLevelDomain("recipes","recipes and cooking")},
			{"red", new TopLevelDomain("red","those who like the color red Also Spanish variant of .net Also likely to be attractive for domain hacks for words that end with '-red'.")},
			{"rehab", new TopLevelDomain("rehab","Rehab centers and support sites")},
			{"ren", new TopLevelDomain("ren","Renren users Means \"people/person\" in Mandarin Chinese pinyin","Restricted TLD")},
			{"rent", new TopLevelDomain("rent","Real estate professionals and small businesses")},
			{"rentals", new TopLevelDomain("rentals","short-term ownership")},
			{"repair", new TopLevelDomain("repair","general repair/maintenance businesses")},
			{"report", new TopLevelDomain("report","business services")},
			{"republican", new TopLevelDomain("republican","Republican Party politics")},
			{"rest", new TopLevelDomain("rest","Restaurants and related industry")},
			{"review", new TopLevelDomain("review","public reviews")},
			{"reviews", new TopLevelDomain("reviews","public reviews")},
			{"rich", new TopLevelDomain("rich","businesses catering to the wealthy")},
			{"rip", new TopLevelDomain("rip","memorial sites[76]")},
			{"rocks", new TopLevelDomain("rocks","general")},
			{"rodeo", new TopLevelDomain("rodeo","Rodeo interest")},
			{"rsvp", new TopLevelDomain("rsvp","Invitations and replies")},
			{"run", new TopLevelDomain("run","running and jogging")},
			{"sale", new TopLevelDomain("sale","retail")},
			{"school", new TopLevelDomain("school","schools")},
			{"science", new TopLevelDomain("science","science-related sites")},
			{"services", new TopLevelDomain("services","business services")},
			{"sex", new TopLevelDomain("sex","adult entertainment (pornography)", "For sites providing sexually explicit content, such as pornography.")},
			{"sexy", new TopLevelDomain("sexy","adult entertainment")},
			{"shoes", new TopLevelDomain("shoes","shoes")},
			{"show", new TopLevelDomain("show","entertainment and vlogs")},
			{"singles", new TopLevelDomain("singles","online dating")},
			{"site", new TopLevelDomain("site","general")},
			{"soccer", new TopLevelDomain("soccer","soccer")},
			{"social", new TopLevelDomain("social","general interest")},
			{"software", new TopLevelDomain("software","computer software")},
			{"solar", new TopLevelDomain("solar","solar-power")},
			{"solutions", new TopLevelDomain("solutions","business services")},
			{"space", new TopLevelDomain("space","as a creative space")},
			{"studio", new TopLevelDomain("studio","art, fitness, & entertainment")},
			{"style", new TopLevelDomain("style","fashion")},
			{"sucks", new TopLevelDomain("sucks","gripe sites")},
			{"supplies", new TopLevelDomain("supplies","manufacturing industries")},
			{"supply", new TopLevelDomain("supply","manufacturing industries")},
			{"support", new TopLevelDomain("support","help pages")},
			{"surf", new TopLevelDomain("surf","surfing")},
			{"surgery", new TopLevelDomain("surgery","healthcare industry")},
			{"systems", new TopLevelDomain("systems","technology")},
			{"tattoo", new TopLevelDomain("tattoo","tattoo aficionados")},
			{"tax", new TopLevelDomain("tax","financial")},
			{"taxi", new TopLevelDomain("taxi","taxi services")},
			{"team", new TopLevelDomain("team","team sports")},
			{"store", new TopLevelDomain("store","stores")},
			{"tech", new TopLevelDomain("tech","technology")},
			{"technology", new TopLevelDomain("technology","technology")},
			{"tel", new TopLevelDomain("tel","Internet communication services,A contact directory housing all types of contact information directly in the Domain Name System.")},
			{"tennis", new TopLevelDomain("tennis","tennis")},
			{"theater", new TopLevelDomain("theater","theaters and cinemas")},
			{"tips", new TopLevelDomain("tips","general help topics")},
			{"tires", new TopLevelDomain("tires","tire manufacturers")},
			{"today", new TopLevelDomain("today","general")},
			{"tools", new TopLevelDomain("tools","manufacturing industries")},
			{"top", new TopLevelDomain("top","general")},
			{"tours", new TopLevelDomain("tours","tourism")},
			{"town", new TopLevelDomain("town","generic geographic")},
			{"toys", new TopLevelDomain("toys","toy businesses")},
			{"trade", new TopLevelDomain("trade","businesses")},
			{"training", new TopLevelDomain("training","training and how-tos")},
			{"travel", new TopLevelDomain("travel","travel and tourism industry related sites,Must be verified as a legitimate travel-related entity.")},
			{"university", new TopLevelDomain("university","young adults, university life")},
			{"vacations", new TopLevelDomain("vacations","travel")},
			{"vet", new TopLevelDomain("vet","veterans and veterinarians")},
			{"video", new TopLevelDomain("video","video sharing")},
			{"villas", new TopLevelDomain("villas","real estate and/or travel businesses")},
			{"vision", new TopLevelDomain("vision","eye-care businesses")},
			{"vodka", new TopLevelDomain("vodka","Vodka-related businesses and interest")},
			{"vote", new TopLevelDomain("vote","democratic elections and campaign websites", "Must use the domain in connection with a \"clearly identified political/democratic process.\"")},
			{"voting", new TopLevelDomain("voting","polling sites")},
			{"voyage", new TopLevelDomain("voyage","travel")},
			{"wang", new TopLevelDomain("wang","general Wǎng is a Chinese Mandarin pinyin rendering of 网 (\"web\" or \"portal\"). Wang is also a common surname in mainland China.")},
			{"watch", new TopLevelDomain("watch","Watches")},
			{"webcam", new TopLevelDomain("webcam","Web cam shows and video sharing")},
			{"website", new TopLevelDomain("website","general")},
			{"wed", new TopLevelDomain("wed","engaged couples and wedding-oriented businesses", "This TLD is intended primarily for engaged couples on a short-term basis (two years with prohibitive third-year renewal fees for second-level domains). And although the registry is advertising for multiple world languages, all domains appear to need to be in Latin script.")},
			{"wedding", new TopLevelDomain("wedding","wedding-oriented businesses")},
			{"whoswho", new TopLevelDomain("whoswho","general", "An open TLD, any person or entity is permitted to register. Conceived for those cited in one of the Who's Who reference titles published around the world, the registry was opened for use by private individuals, and for-profit and nonprofit entities, including those with social media aspirations. Registry policies allow for rapid takedown of non-compliant domains, for violations including imposturous registration of another's names, and proscribed uses, including pornography or adult services/applications.")},
			{"wiki", new TopLevelDomain("wiki","wikis", "An open TLD for anyone interested in community resource creation")},
			{"win", new TopLevelDomain("win","games, Microsoft Windows")},
			{"wine", new TopLevelDomain("wine","Wine")},
			{"work", new TopLevelDomain("work","general")},
			{"works", new TopLevelDomain("works","general")},
			{"world", new TopLevelDomain("world","general")},
			{"wtf", new TopLevelDomain("wtf","general")},
			{"xxx", new TopLevelDomain("xxx","adult entertainment (pornography)", "For sites providing sexually explicit content, such as pornography.")},
			{"xyz", new TopLevelDomain("xyz","general")},
			{"yoga", new TopLevelDomain("yoga","yoga")},
			{"zone", new TopLevelDomain("zone","general")},
			//French
			{"maison", new TopLevelDomain("maison","\"house\"")},
			//Spanish
			{"abogado", new TopLevelDomain("abogado", "\"lawyer\"","To be restricted to licensed lawyers or law firms")},
			{"gratis", new TopLevelDomain("gratis", "\"free\"")},
			{"futbol", new TopLevelDomain("futbol", "soccer")},
			{"juegos", new TopLevelDomain("juegos", "\"games\"")},
			{"soy", new TopLevelDomain("soy", "\"I am\" Also refers to the soybean and its food derivatives")},
			{"tienda", new TopLevelDomain("tienda", "\"shop\", \"store\"")},
			{"uno", new TopLevelDomain("uno", "\"one\", for websites targeting Spanish speaking consumers")},
			{"viajes", new TopLevelDomain("viajes", "\"travel\"")},
			//German
			{"haus", new TopLevelDomain("haus", "\"house\"")},
			{"immobilien", new TopLevelDomain("immobilien", "\"real estate\"")},
			{"jetzt", new TopLevelDomain("jetzt", "\"now\"")},
			{"kaufen", new TopLevelDomain("kaufen", "\"buy\"")},
			{"reise", new TopLevelDomain("reise", "\"travel\"","Must be an eligible member of the travel business community; also, domain must be used for travel-related purposes.")},
			{"reisen", new TopLevelDomain("reisen", "\"traveling\"")},
			{"schule", new TopLevelDomain("schule", "\"school\"")},
			{"versicherung", new TopLevelDomain("versicherung", "\"insurance\"")},
			//Hindi
			{"desi", new TopLevelDomain("desi", "Hindi for the peoples and cultures of South Asia")},
			{"shiksha", new TopLevelDomain("shiksha", "Hindi for \"education\".")},
			//Italian
			{"casa", new TopLevelDomain("casa", "\"house\"")},
			{"cafe", new TopLevelDomain("cafe", "\"café\", \"coffee shop\", \"coffee\"")},
			{"immo", new TopLevelDomain("immo", "French, German, Dutch, and Italian abbreviation for \"real estate\"")},
			{"moda", new TopLevelDomain("moda", "\"fashion\"")},
			{"voto", new TopLevelDomain("voto", "\"vote\", for election and campaign websites")},
			//Corporate identifiers
			{"bar", new TopLevelDomain("bar",Type.GENERIC, "bars and pubs")},
			{"bank", new TopLevelDomain("bank",Type.GENERIC, "banks", "Restricted to banks and savings associations")},
			{"coop", new TopLevelDomain("coop", Type.GENERIC,"cooperatives", "The .coop TLD is limited to cooperatives as defined by the Rochdale Principles.")},
			{"enterprises", new TopLevelDomain("enterprises", Type.GENERIC,"business associations")},
			{"industries", new TopLevelDomain("industries",Type.GENERIC, "industrial businesses")},
			{"institute", new TopLevelDomain("institute",Type.GENERIC, "established business associations")},
			{"ltda", new TopLevelDomain("ltda", Type.GENERIC,"companies in South America")},
			{"pharmacy", new TopLevelDomain("pharmacy", Type.GENERIC,"pharmacies")},
			{"pub", new TopLevelDomain("pub",Type.GENERIC, "bars and pubs")},
			{"realtor", new TopLevelDomain("realtor", Type.GENERIC,"real estate investment trusts", "Restricted to REITs, as determined by national law.")},
			{"rest", new TopLevelDomain("rest",Type.GENERIC, "restaurants")},
			{"restaurant", new TopLevelDomain("restaurant", "restaurants")},
			{"sarl", new TopLevelDomain("sarl",Type.GENERIC,Type.GENERIC, "Société à responsabilité limitée, Francophone Limited liability company")},
			{"ventures", new TopLevelDomain("ventures",Type.GENERIC, "funding for start-ups")},
			//Internationalized generic top-level domains
			//TODO
			// Geographic top-level domains
			//Africa
			{"capetown", new TopLevelDomain("capetown", "Cape Town, South Africa")},
			{"durban", new TopLevelDomain("durban", "Durban, South Africa")},
			{"joburg", new TopLevelDomain("joburg", "Johannesburg, South Africa")},
			//Asia
			{"asia", new TopLevelDomain("asia", "Asia-Pacific region")},
			{"krd", new TopLevelDomain("krd", "Kurdistan")},
			{"nagoya", new TopLevelDomain("nagoya", "Nagoya, Japan")},
			{"okinawa", new TopLevelDomain("okinawa", "Okinawa, Japan")},
			{"ryukyu", new TopLevelDomain("ryukyu", "Ryukyu Islands, Japan")},
			{"taipei", new TopLevelDomain("taipei", "Taipei, Taiwan")},
			{"tatar", new TopLevelDomain("tatar", "Tatar peoples and places")},
			{"tokyo", new TopLevelDomain("tokyo", "Tokyo, Japan")},
			{"yokohama", new TopLevelDomain("yokohama", "Yokohama, Japan")},
			//Europe
			{"alsace", new TopLevelDomain("alsace", "Alsace, France")},
			{"amsterdam", new TopLevelDomain("amsterdam", "Amsterdam, The Netherlands")},
			{"barcelona", new TopLevelDomain("barcelona", "Barcelona, Spain")},
			{"bayern", new TopLevelDomain("bayern", "Bavaria, Germany")},
			{"berlin", new TopLevelDomain("berlin", "Berlin, Germany")},
			{"brussels", new TopLevelDomain("brussels", "Brussels, Belgium")},
			{"budapest", new TopLevelDomain("budapest", "Budapest, Hungary")},
			{"bzh", new TopLevelDomain("bzh", "Brittany, France")},
			{"cat", new TopLevelDomain("cat", "Catalonia; Catalan language and culture")},
			{"cologne", new TopLevelDomain("cologne", "Cologne, Germany")},
			{"corsica", new TopLevelDomain("corsica", "Corsica, France")},
			{"cymru", new TopLevelDomain("cymru", "Wales")},
			{"eus", new TopLevelDomain("eus", "Basque, Spain and France")},
			{"frl", new TopLevelDomain("frl", "Friesland")},
			{"gal", new TopLevelDomain("gal", "Galiza, Spain")},
			{"gent", new TopLevelDomain("gent", "Ghent, Belgium")},
			{"hamburg", new TopLevelDomain("hamburg", "Hamburg, Germany")},
			{"irish", new TopLevelDomain("irish", "Ireland; global Irish community")},
			{"ist", new TopLevelDomain("ist", "İstanbul, Turkey")},
			{"istanbul", new TopLevelDomain("istanbul", "İstanbul, Turkey")},
			{"koeln", new TopLevelDomain("koeln", "Cologne, Germany")},
			{"london", new TopLevelDomain("london", "London, United Kingdom")},
			{"madrid", new TopLevelDomain("madrid", "Madrid, Spain")},
			{"moscow", new TopLevelDomain("moscow", "Moscow, Russia")},
			{"nrw", new TopLevelDomain("nrw", "North Rhine-Westphalia, Germany")},
			{"paris", new TopLevelDomain("paris", "Paris, France")},
			{"ruhr", new TopLevelDomain("ruhr", "Ruhr, Germany")},
			{"saarland", new TopLevelDomain("saarland", "Saarland, Germany")},
			{"scot", new TopLevelDomain("scot", "Scotland")},
			{"tirol", new TopLevelDomain("tirol", "Tyrol, now split between Austria and Italy")},
			{"vlaanderen", new TopLevelDomain("vlaanderen", "Flanders, Belgium")},
			{"wales", new TopLevelDomain("wales", "Wales")},
			{"wien", new TopLevelDomain("wien", "Vienna, Austria")},
			{"zuerich", new TopLevelDomain("zuerich", "Zurich, Switzerland")},
			//North America
			{"miami", new TopLevelDomain("miami", "Miami, USA")},
			{"nyc", new TopLevelDomain("nyc", "New York City, USA")},
			{"quebec", new TopLevelDomain("quebec", "Québec, Canada")},
			{"vegas", new TopLevelDomain("vegas", "Las Vegas, NV, USA")},
			//Oceania
			{"kiwi", new TopLevelDomain("kiwi", "New Zealanders (a.k.a. kiwis)")},
			{"melbourne", new TopLevelDomain("melbourne", "Melbourne, Australia")},
			{"sydney", new TopLevelDomain("sydney", "Sydney, Australia")},
			//South America
			{"lat", new TopLevelDomain("lat", "Latin America")},
			{"rio", new TopLevelDomain("rio", "Rio de Janeiro, Brazil")},

			{"xn--1qqw23a", new TopLevelDomain("xn--1qqw23a", "Foshan, China")},//佛山
			{"xn--80adxhks", new TopLevelDomain("xn--80adxhks", "Moscow, Russia")},//москва
			// Brand top-level domains
			{"allfinanz", new TopLevelDomain("allfinanz", "Allfinanz Deutsche Vermögensberatung Aktiengesellschaft")},
			{"android", new TopLevelDomain("android", "Google (Android)")},
			{"aquarelle", new TopLevelDomain("aquarelle", "Aquarelle Group")},
			{"axa", new TopLevelDomain("axa", "AXA")},
			{"barclays", new TopLevelDomain("barclays", "Barclays")},
			{"barclaycard", new TopLevelDomain("barclaycard", "Barclays")},
			{"bloomberg", new TopLevelDomain("bloomberg", "Bloomberg IP Holdings LLC")},
			{"bmw", new TopLevelDomain("bmw", "BMW")},
			{"bnl", new TopLevelDomain("bnl", "Banca Nazionale del Lavoro")},
			{"bnpparibas", new TopLevelDomain("bnpparibas", "BNP Paribas")},
			{"cal", new TopLevelDomain("cal", "Google (Google Calendar)")},
			{"caravan", new TopLevelDomain("caravan", "Caravan International, Inc.")},
			{"cern", new TopLevelDomain("cern", "CERN")},
			{"chrome", new TopLevelDomain("chrome", "Google (Google Chrome)")},
			{"citic", new TopLevelDomain("citic", "CITIC Group")},
			{"crs", new TopLevelDomain("crs", "Federated Co-operatives Limited (Co-Operative Retailing System)")},
			{"cuisinella", new TopLevelDomain("cuisinella", "Société Alsacienne de Meubles (Cuisinella)")},
			{"dnp", new TopLevelDomain("dnp", "Dai Nippon Printing Co.")},
			{"dvag", new TopLevelDomain("dvag", "Deutsche Vermögensberatung Aktiengesellschaft")},
			{"emerck", new TopLevelDomain("emerck", "Merck KGaA")},
			{"everbank", new TopLevelDomain("everbank", "EverBank")},
			{"firmdale", new TopLevelDomain("firmdale", "Firmdale Holdings")},
			{"flsmidth", new TopLevelDomain("flsmidth", "FLSmidth A/S")},
			{"frogans", new TopLevelDomain("frogans", "OP3FT")},
			{"gbiz", new TopLevelDomain("gbiz", "Google")},
			{"gle", new TopLevelDomain("gle", "Google")},
			{"globo", new TopLevelDomain("globo", "Grupo Globo")},
			{"gmail", new TopLevelDomain("gmail", "Google (Gmail)")},
			{"gmo", new TopLevelDomain("gmo", "GMO Internet")},
			{"gmx", new TopLevelDomain("gmx", "1&1 Mail & Media (Global Message Exchange)")},
			{"google", new TopLevelDomain("google", "Google")},
			{"hsbc", new TopLevelDomain("hsbc", "HSBC")},
			{"ibm", new TopLevelDomain("ibm", "IBM")},
			{"kred", new TopLevelDomain("kred", "KredTLD")},
			{"lacaixa", new TopLevelDomain("lacaixa", "Caixa d’Estalvis i Pensions de Barcelona")},
			{"latrobe", new TopLevelDomain("latrobe", "La Trobe University")},
			{"lds", new TopLevelDomain("lds", "The Church of Jesus Christ of Latter-day Saints (LDS Church)")},
			{"mango", new TopLevelDomain("mango", "MANGO")},
			{"mini", new TopLevelDomain("mini", "BMW (Mini)")},
			{"monash", new TopLevelDomain("monash", "Monash University")},
			{"mormon", new TopLevelDomain("mormon", "The Church of Jesus Christ of Latter-day Saints (LDS Church)")},
			{"neustar", new TopLevelDomain("neustar", "Neustar")},
			{"nexus", new TopLevelDomain("nexus", "Google (Google Nexus)")},
			{"nhk", new TopLevelDomain("nhk", "NHK")},
			{"nico", new TopLevelDomain("nico", "Dwango Co., Ltd. (Niconico)")},
			{"nra", new TopLevelDomain("nra", "National Rifle Association")},
			{"otsuka", new TopLevelDomain("otsuka", "Otsuka Holdings")},
			{"ovh", new TopLevelDomain("ovh", "OVH")},
			{"piaget", new TopLevelDomain("piaget", "Piaget SA")},
			{"pohl", new TopLevelDomain("pohl", "Deutsche Vermögensberatung Aktiengesellschaft (founder Reinfried Pohl)")},
			{"praxi", new TopLevelDomain("praxi", "Praxi")},
			{"prod", new TopLevelDomain("prod", "Google (products)")},
			{"pwc", new TopLevelDomain("pwc", "PwC")},
			{"sandvikcoromant", new TopLevelDomain("sandvikcoromant", "Sandvik Coromant")},
			{"sca", new TopLevelDomain("sca", "Svenska Cellulosa Aktiebolaget")},
			{"scb", new TopLevelDomain("scb", "Siam Commercial Bank")},
			{"schmidt", new TopLevelDomain("schmidt", "Société Alsacienne de Meubles (Cuisines Schmidt)")},
			{"seek", new TopLevelDomain("seek", "Seek Limited")},
			{"sohu", new TopLevelDomain("sohu", "Sohu")},
			{"spiegel", new TopLevelDomain("spiegel", "Spiegel-Verlag")},
			{"suzuki", new TopLevelDomain("suzuki", "Suzuki Motor Corporation")},
			{"tui", new TopLevelDomain("tui", "TUI AG")},
			{"uol", new TopLevelDomain("uol", "Universo Online")},
			{"williamhill", new TopLevelDomain("williamhill", "William Hill")},
			{"wme", new TopLevelDomain("wme", "William Morris Endeavor Entertainment")},
			{"wtc", new TopLevelDomain("wtc", "World Trade Centers Association")},
			{"yandex", new TopLevelDomain("yandex", "Yandex")},
			{"youtube", new TopLevelDomain("youtube", "Google (YouTube)")},
			//Internationalized brand TLD
			{"xn--fiq64b", new TopLevelDomain("xn--fiq64b", "CITIC Group")},//中信
			{"xn--vermgensberater-ctb", new TopLevelDomain("xn--vermgensberater-ctb", "Deutsche Vermögensberatung Aktiengesellschaft")},//vermögensberater
			{"xn--vermgensberatung-pwb", new TopLevelDomain("xn--vermgensberatung-pwb", "Deutsche Vermögensberatung Aktiengesellschaft")},//vermögensberatung
			{"xn--qcka1pmc", new TopLevelDomain("xn--qcka1pmc", "Google")},//グーグル
			{"xn--flw351e", new TopLevelDomain("xn--flw351e", "Google")},//谷歌
			{"xn--cg4bki", new TopLevelDomain("xn--cg4bki", "Samsung")},//삼성
			//Test TLD
			//TODO
			//Unknown/Unclassified - doplneno z http://data.iana.org/TLD/tlds-alpha-by-domain.txt
			{"aaa", new TopLevelDomain("aaa", Type.UNKNOWN, null)},
			{"aarp", new TopLevelDomain("aarp", Type.UNKNOWN, null)},
			{"abarth", new TopLevelDomain("abarth", Type.UNKNOWN, null)},
			{"abb", new TopLevelDomain("abb", Type.UNKNOWN, null)},
			{"abbott", new TopLevelDomain("abbott", Type.UNKNOWN, null)},
			{"abbvie", new TopLevelDomain("abbvie", Type.UNKNOWN, null)},
			{"abc", new TopLevelDomain("abc", Type.UNKNOWN, null)},
			{"able", new TopLevelDomain("able", Type.UNKNOWN, null)},
			{"abudhabi", new TopLevelDomain("abudhabi", Type.UNKNOWN, null)},
			{"accenture", new TopLevelDomain("accenture", Type.UNKNOWN, null)},
			{"aco", new TopLevelDomain("aco", Type.UNKNOWN, null)},
			{"adac", new TopLevelDomain("adac", Type.UNKNOWN, null)},
			{"ads", new TopLevelDomain("ads", Type.UNKNOWN, null)},
			{"aeg", new TopLevelDomain("aeg", Type.UNKNOWN, null)},
			{"aetna", new TopLevelDomain("aetna", Type.UNKNOWN, null)},
			{"afamilycompany", new TopLevelDomain("afamilycompany", Type.UNKNOWN, null)},
			{"afl", new TopLevelDomain("afl", Type.UNKNOWN, null)},
			{"agakhan", new TopLevelDomain("agakhan", Type.UNKNOWN, null)},
			{"aig", new TopLevelDomain("aig", Type.UNKNOWN, null)},
			{"aigo", new TopLevelDomain("aigo", Type.UNKNOWN, null)},
			{"airbus", new TopLevelDomain("airbus", Type.UNKNOWN, null)},
			{"airtel", new TopLevelDomain("airtel", Type.UNKNOWN, null)},
			{"akdn", new TopLevelDomain("akdn", Type.UNKNOWN, null)},
			{"alfaromeo", new TopLevelDomain("alfaromeo", Type.UNKNOWN, null)},
			{"alibaba", new TopLevelDomain("alibaba", Type.UNKNOWN, null)},
			{"alipay", new TopLevelDomain("alipay", Type.UNKNOWN, null)},
			{"allstate", new TopLevelDomain("allstate", Type.UNKNOWN, null)},
			{"ally", new TopLevelDomain("ally", Type.UNKNOWN, null)},
			{"alstom", new TopLevelDomain("alstom", Type.UNKNOWN, null)},
			{"americanexpress", new TopLevelDomain("americanexpress", Type.UNKNOWN, null)},
			{"americanfamily", new TopLevelDomain("americanfamily", Type.UNKNOWN, null)},
			{"amex", new TopLevelDomain("amex", Type.UNKNOWN, null)},
			{"amfam", new TopLevelDomain("amfam", Type.UNKNOWN, null)},
			{"amica", new TopLevelDomain("amica", Type.UNKNOWN, null)},
			{"analytics", new TopLevelDomain("analytics", Type.UNKNOWN, null)},
			{"anquan", new TopLevelDomain("anquan", Type.UNKNOWN, null)},
			{"anz", new TopLevelDomain("anz", Type.UNKNOWN, null)},
			{"apple", new TopLevelDomain("apple", Type.UNKNOWN, null)},
			{"aramco", new TopLevelDomain("aramco", Type.UNKNOWN, null)},
			{"art", new TopLevelDomain("art", Type.UNKNOWN, null)},
			{"arte", new TopLevelDomain("arte", Type.UNKNOWN, null)},
			{"asda", new TopLevelDomain("asda", Type.UNKNOWN, null)},
			{"athleta", new TopLevelDomain("athleta", Type.UNKNOWN, null)},
			{"audi", new TopLevelDomain("audi", Type.UNKNOWN, null)},
			{"audible", new TopLevelDomain("audible", Type.UNKNOWN, null)},
			{"auspost", new TopLevelDomain("auspost", Type.UNKNOWN, null)},
			{"author", new TopLevelDomain("author", Type.UNKNOWN, null)},
			{"auto", new TopLevelDomain("auto", Type.UNKNOWN, null)},
			{"avianca", new TopLevelDomain("avianca", Type.UNKNOWN, null)},
			{"aws", new TopLevelDomain("aws", Type.UNKNOWN, null)},
			{"azure", new TopLevelDomain("azure", Type.UNKNOWN, null)},
			{"baby", new TopLevelDomain("baby", Type.UNKNOWN, null)},
			{"baidu", new TopLevelDomain("baidu", Type.UNKNOWN, null)},
			{"banamex", new TopLevelDomain("banamex", Type.UNKNOWN, null)},
			{"bananarepublic", new TopLevelDomain("bananarepublic", Type.UNKNOWN, null)},
			{"barefoot", new TopLevelDomain("barefoot", Type.UNKNOWN, null)},
			{"bauhaus", new TopLevelDomain("bauhaus", Type.UNKNOWN, null)},
			{"bbc", new TopLevelDomain("bbc", Type.UNKNOWN, null)},
			{"bbt", new TopLevelDomain("bbt", Type.UNKNOWN, null)},
			{"bbva", new TopLevelDomain("bbva", Type.UNKNOWN, null)},
			{"bcg", new TopLevelDomain("bcg", Type.UNKNOWN, null)},
			{"bcn", new TopLevelDomain("bcn", Type.UNKNOWN, null)},
			{"beats", new TopLevelDomain("beats", Type.UNKNOWN, null)},
			{"beauty", new TopLevelDomain("beauty", Type.UNKNOWN, null)},
			{"bentley", new TopLevelDomain("bentley", Type.UNKNOWN, null)},
			{"bestbuy", new TopLevelDomain("bestbuy", Type.UNKNOWN, null)},
			{"bet", new TopLevelDomain("bet", Type.UNKNOWN, null)},
			{"bharti", new TopLevelDomain("bharti", Type.UNKNOWN, null)},
			{"bible", new TopLevelDomain("bible", Type.UNKNOWN, null)},
			{"bing", new TopLevelDomain("bing", Type.UNKNOWN, null)},
			{"blanco", new TopLevelDomain("blanco", Type.UNKNOWN, null)},
			{"blockbuster", new TopLevelDomain("blockbuster", Type.UNKNOWN, null)},
			{"bms", new TopLevelDomain("bms", Type.UNKNOWN, null)},
			{"boats", new TopLevelDomain("boats", Type.UNKNOWN, null)},
			{"boehringer", new TopLevelDomain("boehringer", Type.UNKNOWN, null)},
			{"bofa", new TopLevelDomain("bofa", Type.UNKNOWN, null)},
			{"bom", new TopLevelDomain("bom", Type.UNKNOWN, null)},
			{"bond", new TopLevelDomain("bond", Type.UNKNOWN, null)},
			{"book", new TopLevelDomain("book", Type.UNKNOWN, null)},
			{"booking", new TopLevelDomain("booking", Type.UNKNOWN, null)},
			{"boots", new TopLevelDomain("boots", Type.UNKNOWN, null)},
			{"bosch", new TopLevelDomain("bosch", Type.UNKNOWN, null)},
			{"bostik", new TopLevelDomain("bostik", Type.UNKNOWN, null)},
			{"bot", new TopLevelDomain("bot", Type.UNKNOWN, null)},
			{"bradesco", new TopLevelDomain("bradesco", Type.UNKNOWN, null)},
			{"bridgestone", new TopLevelDomain("bridgestone", Type.UNKNOWN, null)},
			{"broadway", new TopLevelDomain("broadway", Type.UNKNOWN, null)},
			{"broker", new TopLevelDomain("broker", Type.UNKNOWN, null)},
			{"brother", new TopLevelDomain("brother", Type.UNKNOWN, null)},
			{"bugatti", new TopLevelDomain("bugatti", Type.UNKNOWN, null)},
			{"buy", new TopLevelDomain("buy", Type.UNKNOWN, null)},
			{"bw", new TopLevelDomain("bw", Type.UNKNOWN, null)},
			{"call", new TopLevelDomain("call", Type.UNKNOWN, null)},
			{"calvinklein", new TopLevelDomain("calvinklein", Type.UNKNOWN, null)},
			{"cam", new TopLevelDomain("cam", Type.UNKNOWN, null)},
			{"canon", new TopLevelDomain("canon", Type.UNKNOWN, null)},
			{"capitalone", new TopLevelDomain("capitalone", Type.UNKNOWN, null)},
			{"car", new TopLevelDomain("car", Type.UNKNOWN, null)},
			{"cars", new TopLevelDomain("cars", Type.UNKNOWN, null)},
			{"cartier", new TopLevelDomain("cartier", Type.UNKNOWN, null)},
			{"cba", new TopLevelDomain("cba", Type.UNKNOWN, null)},
			{"cbn", new TopLevelDomain("cbn", Type.UNKNOWN, null)},
			{"cbre", new TopLevelDomain("cbre", Type.UNKNOWN, null)},
			{"cbs", new TopLevelDomain("cbs", Type.UNKNOWN, null)},
			{"ceb", new TopLevelDomain("ceb", Type.UNKNOWN, null)},
			{"cfa", new TopLevelDomain("cfa", Type.UNKNOWN, null)},
			{"cfd", new TopLevelDomain("cfd", Type.UNKNOWN, null)},
			{"chanel", new TopLevelDomain("chanel", Type.UNKNOWN, null)},
			{"chase", new TopLevelDomain("chase", Type.UNKNOWN, null)},
			{"chintai", new TopLevelDomain("chintai", Type.UNKNOWN, null)},
			{"chloe", new TopLevelDomain("chloe", Type.UNKNOWN, null)},
			{"chrysler", new TopLevelDomain("chrysler", Type.UNKNOWN, null)},
			{"cipriani", new TopLevelDomain("cipriani", Type.UNKNOWN, null)},
			{"circle", new TopLevelDomain("circle", Type.UNKNOWN, null)},
			{"cisco", new TopLevelDomain("cisco", Type.UNKNOWN, null)},
			{"citadel", new TopLevelDomain("citadel", Type.UNKNOWN, null)},
			{"citi", new TopLevelDomain("citi", Type.UNKNOWN, null)},
			{"cityeats", new TopLevelDomain("cityeats", Type.UNKNOWN, null)},
			{"clinique", new TopLevelDomain("clinique", Type.UNKNOWN, null)},
			{"clubmed", new TopLevelDomain("clubmed", Type.UNKNOWN, null)},
			{"comcast", new TopLevelDomain("comcast", Type.UNKNOWN, null)},
			{"commbank", new TopLevelDomain("commbank", Type.UNKNOWN, null)},
			{"compare", new TopLevelDomain("compare", Type.UNKNOWN, null)},
			{"comsec", new TopLevelDomain("comsec", Type.UNKNOWN, null)},
			{"contact", new TopLevelDomain("contact", Type.UNKNOWN, null)},
			{"cookingchannel", new TopLevelDomain("cookingchannel", Type.UNKNOWN, null)},
			{"coupon", new TopLevelDomain("coupon", Type.UNKNOWN, null)},
			{"courses", new TopLevelDomain("courses", Type.UNKNOWN, null)},
			{"creditunion", new TopLevelDomain("creditunion", Type.UNKNOWN, null)},
			{"crown", new TopLevelDomain("crown", Type.UNKNOWN, null)},
			{"csc", new TopLevelDomain("csc", Type.UNKNOWN, null)},
			{"cyou", new TopLevelDomain("cyou", Type.UNKNOWN, null)},
			{"dabur", new TopLevelDomain("dabur", Type.UNKNOWN, null)},
			{"datsun", new TopLevelDomain("datsun", Type.UNKNOWN, null)},
			{"dclk", new TopLevelDomain("dclk", Type.UNKNOWN, null)},
			{"dds", new TopLevelDomain("dds", Type.UNKNOWN, null)},
			{"deal", new TopLevelDomain("deal", Type.UNKNOWN, null)},
			{"dealer", new TopLevelDomain("dealer", Type.UNKNOWN, null)},
			{"dell", new TopLevelDomain("dell", Type.UNKNOWN, null)},
			{"deloitte", new TopLevelDomain("deloitte", Type.UNKNOWN, null)},
			{"delta", new TopLevelDomain("delta", Type.UNKNOWN, null)},
			{"dev", new TopLevelDomain("dev", Type.UNKNOWN, null)},
			{"dhl", new TopLevelDomain("dhl", Type.UNKNOWN, null)},
			{"discover", new TopLevelDomain("discover", Type.UNKNOWN, null)},
			{"dish", new TopLevelDomain("dish", Type.UNKNOWN, null)},
			{"diy", new TopLevelDomain("diy", Type.UNKNOWN, null)},
			{"docs", new TopLevelDomain("docs", Type.UNKNOWN, null)},
			{"doctor", new TopLevelDomain("doctor", Type.UNKNOWN, null)},
			{"dodge", new TopLevelDomain("dodge", Type.UNKNOWN, null)},
			{"doha", new TopLevelDomain("doha", Type.UNKNOWN, null)},
			{"dot", new TopLevelDomain("dot", Type.UNKNOWN, null)},
			{"drive", new TopLevelDomain("drive", Type.UNKNOWN, null)},
			{"dtv", new TopLevelDomain("dtv", Type.UNKNOWN, null)},
			{"dubai", new TopLevelDomain("dubai", Type.UNKNOWN, null)},
			{"duck", new TopLevelDomain("duck", Type.UNKNOWN, null)},
			{"dunlop", new TopLevelDomain("dunlop", Type.UNKNOWN, null)},
			{"duns", new TopLevelDomain("duns", Type.UNKNOWN, null)},
			{"dupont", new TopLevelDomain("dupont", Type.UNKNOWN, null)},
			{"earth", new TopLevelDomain("earth", Type.UNKNOWN, null)},
			{"eco", new TopLevelDomain("eco", Type.UNKNOWN, null)},
			{"edeka", new TopLevelDomain("edeka", Type.UNKNOWN, null)},
			{"epost", new TopLevelDomain("epost", Type.UNKNOWN, null)},
			{"epson", new TopLevelDomain("epson", Type.UNKNOWN, null)},
			{"ericsson", new TopLevelDomain("ericsson", Type.UNKNOWN, null)},
			{"erni", new TopLevelDomain("erni", Type.UNKNOWN, null)},
			{"esurance", new TopLevelDomain("esurance", Type.UNKNOWN, null)},
			{"eurovision", new TopLevelDomain("eurovision", Type.UNKNOWN, null)},
			{"extraspace", new TopLevelDomain("extraspace", Type.UNKNOWN, null)},
			{"fage", new TopLevelDomain("fage", Type.UNKNOWN, null)},
			{"fairwinds", new TopLevelDomain("fairwinds", Type.UNKNOWN, null)},
			{"fan", new TopLevelDomain("fan", Type.UNKNOWN, null)},
			{"farmers", new TopLevelDomain("farmers", Type.UNKNOWN, null)},
			{"fast", new TopLevelDomain("fast", Type.UNKNOWN, null)},
			{"fedex", new TopLevelDomain("fedex", Type.UNKNOWN, null)},
			{"ferrari", new TopLevelDomain("ferrari", Type.UNKNOWN, null)},
			{"ferrero", new TopLevelDomain("ferrero", Type.UNKNOWN, null)},
			{"fiat", new TopLevelDomain("fiat", Type.UNKNOWN, null)},
			{"fidelity", new TopLevelDomain("fidelity", Type.UNKNOWN, null)},
			{"fido", new TopLevelDomain("fido", Type.UNKNOWN, null)},
			{"film", new TopLevelDomain("film", Type.UNKNOWN, null)},
			{"final", new TopLevelDomain("final", Type.UNKNOWN, null)},
			{"fire", new TopLevelDomain("fire", Type.UNKNOWN, null)},
			{"firestone", new TopLevelDomain("firestone", Type.UNKNOWN, null)},
			{"flickr", new TopLevelDomain("flickr", Type.UNKNOWN, null)},
			{"flir", new TopLevelDomain("flir", Type.UNKNOWN, null)},
			{"foodnetwork", new TopLevelDomain("foodnetwork", Type.UNKNOWN, null)},
			{"ford", new TopLevelDomain("ford", Type.UNKNOWN, null)},
			{"forex", new TopLevelDomain("forex", Type.UNKNOWN, null)},
			{"forum", new TopLevelDomain("forum", Type.UNKNOWN, null)},
			{"fox", new TopLevelDomain("fox", Type.UNKNOWN, null)},
			{"fresenius", new TopLevelDomain("fresenius", Type.UNKNOWN, null)},
			{"frontdoor", new TopLevelDomain("frontdoor", Type.UNKNOWN, null)},
			{"frontier", new TopLevelDomain("frontier", Type.UNKNOWN, null)},
			{"ftr", new TopLevelDomain("ftr", Type.UNKNOWN, null)},
			{"fujitsu", new TopLevelDomain("fujitsu", Type.UNKNOWN, null)},
			{"fujixerox", new TopLevelDomain("fujixerox", Type.UNKNOWN, null)},
			{"gallo", new TopLevelDomain("gallo", Type.UNKNOWN, null)},
			{"gallup", new TopLevelDomain("gallup", Type.UNKNOWN, null)},
			{"game", new TopLevelDomain("game", Type.UNKNOWN, null)},
			{"games", new TopLevelDomain("games", Type.UNKNOWN, null)},
			{"gap", new TopLevelDomain("gap", Type.UNKNOWN, null)},
			{"gdn", new TopLevelDomain("gdn", Type.UNKNOWN, null)},
			{"gea", new TopLevelDomain("gea", Type.UNKNOWN, null)},
			{"genting", new TopLevelDomain("genting", Type.UNKNOWN, null)},
			{"george", new TopLevelDomain("george", Type.UNKNOWN, null)},
			{"ggee", new TopLevelDomain("ggee", Type.UNKNOWN, null)},
			{"giving", new TopLevelDomain("giving", Type.UNKNOWN, null)},
			{"glade", new TopLevelDomain("glade", Type.UNKNOWN, null)},
			{"gmbh", new TopLevelDomain("gmbh", Type.UNKNOWN, null)},
			{"godaddy", new TopLevelDomain("godaddy", Type.UNKNOWN, null)},
			{"goldpoint", new TopLevelDomain("goldpoint", Type.UNKNOWN, null)},
			{"goo", new TopLevelDomain("goo", Type.UNKNOWN, null)},
			{"goodhands", new TopLevelDomain("goodhands", Type.UNKNOWN, null)},
			{"goodyear", new TopLevelDomain("goodyear", Type.UNKNOWN, null)},
			{"goog", new TopLevelDomain("goog", Type.UNKNOWN, null)},
			{"got", new TopLevelDomain("got", Type.UNKNOWN, null)},
			{"grainger", new TopLevelDomain("grainger", Type.UNKNOWN, null)},
			{"group", new TopLevelDomain("group", Type.UNKNOWN, null)},
			{"guardian", new TopLevelDomain("guardian", Type.UNKNOWN, null)},
			{"gucci", new TopLevelDomain("gucci", Type.UNKNOWN, null)},
			{"guge", new TopLevelDomain("guge", Type.UNKNOWN, null)},
			{"hangout", new TopLevelDomain("hangout", Type.UNKNOWN, null)},
			{"hbo", new TopLevelDomain("hbo", Type.UNKNOWN, null)},
			{"hdfc", new TopLevelDomain("hdfc", Type.UNKNOWN, null)},
			{"hdfcbank", new TopLevelDomain("hdfcbank", Type.UNKNOWN, null)},
			{"health", new TopLevelDomain("health", Type.UNKNOWN, null)},
			{"helsinki", new TopLevelDomain("helsinki", Type.UNKNOWN, null)},
			{"hermes", new TopLevelDomain("hermes", Type.UNKNOWN, null)},
			{"hgtv", new TopLevelDomain("hgtv", Type.UNKNOWN, null)},
			{"hisamitsu", new TopLevelDomain("hisamitsu", Type.UNKNOWN, null)},
			{"hitachi", new TopLevelDomain("hitachi", Type.UNKNOWN, null)},
			{"hkt", new TopLevelDomain("hkt", Type.UNKNOWN, null)},
			{"homedepot", new TopLevelDomain("homedepot", Type.UNKNOWN, null)},
			{"homegoods", new TopLevelDomain("homegoods", Type.UNKNOWN, null)},
			{"homesense", new TopLevelDomain("homesense", Type.UNKNOWN, null)},
			{"honda", new TopLevelDomain("honda", Type.UNKNOWN, null)},
			{"honeywell", new TopLevelDomain("honeywell", Type.UNKNOWN, null)},
			{"hot", new TopLevelDomain("hot", Type.UNKNOWN, null)},
			{"hoteles", new TopLevelDomain("hoteles", Type.UNKNOWN, null)},
			{"hotmail", new TopLevelDomain("hotmail", Type.UNKNOWN, null)},
			{"htc", new TopLevelDomain("htc", Type.UNKNOWN, null)},
			{"hughes", new TopLevelDomain("hughes", Type.UNKNOWN, null)},
			{"hyatt", new TopLevelDomain("hyatt", Type.UNKNOWN, null)},
			{"hyundai", new TopLevelDomain("hyundai", Type.UNKNOWN, null)},
			{"icbc", new TopLevelDomain("icbc", Type.UNKNOWN, null)},
			{"ice", new TopLevelDomain("ice", Type.UNKNOWN, null)},
			{"icu", new TopLevelDomain("icu", Type.UNKNOWN, null)},
			{"ieee", new TopLevelDomain("ieee", Type.UNKNOWN, null)},
			{"ifm", new TopLevelDomain("ifm", Type.UNKNOWN, null)},
			{"iinet", new TopLevelDomain("iinet", Type.UNKNOWN, null)},
			{"ikano", new TopLevelDomain("ikano", Type.UNKNOWN, null)},
			{"imamat", new TopLevelDomain("imamat", Type.UNKNOWN, null)},
			{"imdb", new TopLevelDomain("imdb", Type.UNKNOWN, null)},
			{"infiniti", new TopLevelDomain("infiniti", Type.UNKNOWN, null)},
			{"insurance", new TopLevelDomain("insurance", Type.UNKNOWN, null)},
			{"intel", new TopLevelDomain("intel", Type.UNKNOWN, null)},
			{"intuit", new TopLevelDomain("intuit", Type.UNKNOWN, null)},
			{"ipiranga", new TopLevelDomain("ipiranga", Type.UNKNOWN, null)},
			{"iselect", new TopLevelDomain("iselect", Type.UNKNOWN, null)},
			{"ismaili", new TopLevelDomain("ismaili", Type.UNKNOWN, null)},
			{"itau", new TopLevelDomain("itau", Type.UNKNOWN, null)},
			{"itv", new TopLevelDomain("itv", Type.UNKNOWN, null)},
			{"iwc", new TopLevelDomain("iwc", Type.UNKNOWN, null)},
			{"jaguar", new TopLevelDomain("jaguar", Type.UNKNOWN, null)},
			{"java", new TopLevelDomain("java", Type.UNKNOWN, null)},
			{"jcb", new TopLevelDomain("jcb", Type.UNKNOWN, null)},
			{"jcp", new TopLevelDomain("jcp", Type.UNKNOWN, null)},
			{"jeep", new TopLevelDomain("jeep", Type.UNKNOWN, null)},
			{"jlc", new TopLevelDomain("jlc", Type.UNKNOWN, null)},
			{"jll", new TopLevelDomain("jll", Type.UNKNOWN, null)},
			{"jmp", new TopLevelDomain("jmp", Type.UNKNOWN, null)},
			{"jnj", new TopLevelDomain("jnj", Type.UNKNOWN, null)},
			{"jot", new TopLevelDomain("jot", Type.UNKNOWN, null)},
			{"joy", new TopLevelDomain("joy", Type.UNKNOWN, null)},
			{"jpmorgan", new TopLevelDomain("jpmorgan", Type.UNKNOWN, null)},
			{"jprs", new TopLevelDomain("jprs", Type.UNKNOWN, null)},
			{"juniper", new TopLevelDomain("juniper", Type.UNKNOWN, null)},
			{"kddi", new TopLevelDomain("kddi", Type.UNKNOWN, null)},
			{"kerryhotels", new TopLevelDomain("kerryhotels", Type.UNKNOWN, null)},
			{"kerrylogistics", new TopLevelDomain("kerrylogistics", Type.UNKNOWN, null)},
			{"kerryproperties", new TopLevelDomain("kerryproperties", Type.UNKNOWN, null)},
			{"kfh", new TopLevelDomain("kfh", Type.UNKNOWN, null)},
			{"kia", new TopLevelDomain("kia", Type.UNKNOWN, null)},
			{"kinder", new TopLevelDomain("kinder", Type.UNKNOWN, null)},
			{"kindle", new TopLevelDomain("kindle", Type.UNKNOWN, null)},
			{"komatsu", new TopLevelDomain("komatsu", Type.UNKNOWN, null)},
			{"kosher", new TopLevelDomain("kosher", Type.UNKNOWN, null)},
			{"kpmg", new TopLevelDomain("kpmg", Type.UNKNOWN, null)},
			{"kpn", new TopLevelDomain("kpn", Type.UNKNOWN, null)},
			{"kuokgroup", new TopLevelDomain("kuokgroup", Type.UNKNOWN, null)},
			{"kyoto", new TopLevelDomain("kyoto", Type.UNKNOWN, null)},
			{"ladbrokes", new TopLevelDomain("ladbrokes", Type.UNKNOWN, null)},
			{"lamborghini", new TopLevelDomain("lamborghini", Type.UNKNOWN, null)},
			{"lamer", new TopLevelDomain("lamer", Type.UNKNOWN, null)},
			{"lancaster", new TopLevelDomain("lancaster", Type.UNKNOWN, null)},
			{"lancia", new TopLevelDomain("lancia", Type.UNKNOWN, null)},
			{"lancome", new TopLevelDomain("lancome", Type.UNKNOWN, null)},
			{"landrover", new TopLevelDomain("landrover", Type.UNKNOWN, null)},
			{"lanxess", new TopLevelDomain("lanxess", Type.UNKNOWN, null)},
			{"lasalle", new TopLevelDomain("lasalle", Type.UNKNOWN, null)},
			{"latino", new TopLevelDomain("latino", Type.UNKNOWN, null)},
			{"law", new TopLevelDomain("law", Type.UNKNOWN, null)},
			{"leclerc", new TopLevelDomain("leclerc", Type.UNKNOWN, null)},
			{"lefrak", new TopLevelDomain("lefrak", Type.UNKNOWN, null)},
			{"lego", new TopLevelDomain("lego", Type.UNKNOWN, null)},
			{"lexus", new TopLevelDomain("lexus", Type.UNKNOWN, null)},
			{"liaison", new TopLevelDomain("liaison", Type.UNKNOWN, null)},
			{"lidl", new TopLevelDomain("lidl", Type.UNKNOWN, null)},
			{"lifeinsurance", new TopLevelDomain("lifeinsurance", Type.UNKNOWN, null)},
			{"lifestyle", new TopLevelDomain("lifestyle", Type.UNKNOWN, null)},
			{"like", new TopLevelDomain("like", Type.UNKNOWN, null)},
			{"lilly", new TopLevelDomain("lilly", Type.UNKNOWN, null)},
			{"lincoln", new TopLevelDomain("lincoln", Type.UNKNOWN, null)},
			{"linde", new TopLevelDomain("linde", Type.UNKNOWN, null)},
			{"lipsy", new TopLevelDomain("lipsy", Type.UNKNOWN, null)},
			{"live", new TopLevelDomain("live", Type.UNKNOWN, null)},
			{"living", new TopLevelDomain("living", Type.UNKNOWN, null)},
			{"lixil", new TopLevelDomain("lixil", Type.UNKNOWN, null)},
			{"locker", new TopLevelDomain("locker", Type.UNKNOWN, null)},
			{"locus", new TopLevelDomain("locus", Type.UNKNOWN, null)},
			{"loft", new TopLevelDomain("loft", Type.UNKNOWN, null)},
			{"lotte", new TopLevelDomain("lotte", Type.UNKNOWN, null)},
			{"lpl", new TopLevelDomain("lpl", Type.UNKNOWN, null)},
			{"lplfinancial", new TopLevelDomain("lplfinancial", Type.UNKNOWN, null)},
			{"ltd", new TopLevelDomain("ltd", Type.UNKNOWN, null)},
			{"lundbeck", new TopLevelDomain("lundbeck", Type.UNKNOWN, null)},
			{"lupin", new TopLevelDomain("lupin", Type.UNKNOWN, null)},
			{"macys", new TopLevelDomain("macys", Type.UNKNOWN, null)},
			{"maif", new TopLevelDomain("maif", Type.UNKNOWN, null)},
			{"makeup", new TopLevelDomain("makeup", Type.UNKNOWN, null)},
			{"man", new TopLevelDomain("man", Type.UNKNOWN, null)},
			{"marriott", new TopLevelDomain("marriott", Type.UNKNOWN, null)},
			{"marshalls", new TopLevelDomain("marshalls", Type.UNKNOWN, null)},
			{"maserati", new TopLevelDomain("maserati", Type.UNKNOWN, null)},
			{"mattel", new TopLevelDomain("mattel", Type.UNKNOWN, null)},
			{"mcd", new TopLevelDomain("mcd", Type.UNKNOWN, null)},
			{"mcdonalds", new TopLevelDomain("mcdonalds", Type.UNKNOWN, null)},
			{"mckinsey", new TopLevelDomain("mckinsey", Type.UNKNOWN, null)},
			{"med", new TopLevelDomain("med", Type.UNKNOWN, null)},
			{"meo", new TopLevelDomain("meo", Type.UNKNOWN, null)},
			{"metlife", new TopLevelDomain("metlife", Type.UNKNOWN, null)},
			{"microsoft", new TopLevelDomain("microsoft", Type.UNKNOWN, null)},
			{"mint", new TopLevelDomain("mint", Type.UNKNOWN, null)},
			{"mit", new TopLevelDomain("mit", Type.UNKNOWN, null)},
			{"mitsubishi", new TopLevelDomain("mitsubishi", Type.UNKNOWN, null)},
			{"mlb", new TopLevelDomain("mlb", Type.UNKNOWN, null)},
			{"mls", new TopLevelDomain("mls", Type.UNKNOWN, null)},
			{"mma", new TopLevelDomain("mma", Type.UNKNOWN, null)},
			{"mobily", new TopLevelDomain("mobily", Type.UNKNOWN, null)},
			{"moi", new TopLevelDomain("moi", Type.UNKNOWN, null)},
			{"mom", new TopLevelDomain("mom", Type.UNKNOWN, null)},
			{"monster", new TopLevelDomain("monster", Type.UNKNOWN, null)},
			{"montblanc", new TopLevelDomain("montblanc", Type.UNKNOWN, null)},
			{"mopar", new TopLevelDomain("mopar", Type.UNKNOWN, null)},
			{"movistar", new TopLevelDomain("movistar", Type.UNKNOWN, null)},
			{"msd", new TopLevelDomain("msd", Type.UNKNOWN, null)},
			{"mtn", new TopLevelDomain("mtn", Type.UNKNOWN, null)},
			{"mtpc", new TopLevelDomain("mtpc", Type.UNKNOWN, null)},
			{"mtr", new TopLevelDomain("mtr", Type.UNKNOWN, null)},
			{"mutual", new TopLevelDomain("mutual", Type.UNKNOWN, null)},
			{"mutuelle", new TopLevelDomain("mutuelle", Type.UNKNOWN, null)},
			{"nab", new TopLevelDomain("nab", Type.UNKNOWN, null)},
			{"nadex", new TopLevelDomain("nadex", Type.UNKNOWN, null)},
			{"nationwide", new TopLevelDomain("nationwide", Type.UNKNOWN, null)},
			{"natura", new TopLevelDomain("natura", Type.UNKNOWN, null)},
			{"nba", new TopLevelDomain("nba", Type.UNKNOWN, null)},
			{"nec", new TopLevelDomain("nec", Type.UNKNOWN, null)},
			{"netbank", new TopLevelDomain("netbank", Type.UNKNOWN, null)},
			{"netflix", new TopLevelDomain("netflix", Type.UNKNOWN, null)},
			{"next", new TopLevelDomain("next", Type.UNKNOWN, null)},
			{"nextdirect", new TopLevelDomain("nextdirect", Type.UNKNOWN, null)},
			{"nfl", new TopLevelDomain("nfl", Type.UNKNOWN, null)},
			{"nike", new TopLevelDomain("nike", Type.UNKNOWN, null)},
			{"nikon", new TopLevelDomain("nikon", Type.UNKNOWN, null)},
			{"nissan", new TopLevelDomain("nissan", Type.UNKNOWN, null)},
			{"nissay", new TopLevelDomain("nissay", Type.UNKNOWN, null)},
			{"nokia", new TopLevelDomain("nokia", Type.UNKNOWN, null)},
			{"northwesternmutual", new TopLevelDomain("northwesternmutual", Type.UNKNOWN, null)},
			{"norton", new TopLevelDomain("norton", Type.UNKNOWN, null)},
			{"now", new TopLevelDomain("now", Type.UNKNOWN, null)},
			{"nowruz", new TopLevelDomain("nowruz", Type.UNKNOWN, null)},
			{"nowtv", new TopLevelDomain("nowtv", Type.UNKNOWN, null)},
			{"ntt", new TopLevelDomain("ntt", Type.UNKNOWN, null)},
			{"obi", new TopLevelDomain("obi", Type.UNKNOWN, null)},
			{"observer", new TopLevelDomain("observer", Type.UNKNOWN, null)},
			{"off", new TopLevelDomain("off", Type.UNKNOWN, null)},
			{"office", new TopLevelDomain("office", Type.UNKNOWN, null)},
			{"olayan", new TopLevelDomain("olayan", Type.UNKNOWN, null)},
			{"olayangroup", new TopLevelDomain("olayangroup", Type.UNKNOWN, null)},
			{"oldnavy", new TopLevelDomain("oldnavy", Type.UNKNOWN, null)},
			{"ollo", new TopLevelDomain("ollo", Type.UNKNOWN, null)},
			{"omega", new TopLevelDomain("omega", Type.UNKNOWN, null)},
			{"onyourside", new TopLevelDomain("onyourside", Type.UNKNOWN, null)},
			{"open", new TopLevelDomain("open", Type.UNKNOWN, null)},
			{"oracle", new TopLevelDomain("oracle", Type.UNKNOWN, null)},
			{"orange", new TopLevelDomain("orange", Type.UNKNOWN, null)},
			{"orientexpress", new TopLevelDomain("orientexpress", Type.UNKNOWN, null)},
			{"origins", new TopLevelDomain("origins", Type.UNKNOWN, null)},
			{"osaka", new TopLevelDomain("osaka", Type.UNKNOWN, null)},
			{"ott", new TopLevelDomain("ott", Type.UNKNOWN, null)},
			{"page", new TopLevelDomain("page", Type.UNKNOWN, null)},
			{"pamperedchef", new TopLevelDomain("pamperedchef", Type.UNKNOWN, null)},
			{"panasonic", new TopLevelDomain("panasonic", Type.UNKNOWN, null)},
			{"panerai", new TopLevelDomain("panerai", Type.UNKNOWN, null)},
			{"pars", new TopLevelDomain("pars", Type.UNKNOWN, null)},
			{"passagens", new TopLevelDomain("passagens", Type.UNKNOWN, null)},
			{"pay", new TopLevelDomain("pay", Type.UNKNOWN, null)},
			{"pccw", new TopLevelDomain("pccw", Type.UNKNOWN, null)},
			{"pet", new TopLevelDomain("pet", Type.UNKNOWN, null)},
			{"pfizer", new TopLevelDomain("pfizer", Type.UNKNOWN, null)},
			{"philips", new TopLevelDomain("philips", Type.UNKNOWN, null)},
			{"pictet", new TopLevelDomain("pictet", Type.UNKNOWN, null)},
			{"pin", new TopLevelDomain("pin", Type.UNKNOWN, null)},
			{"ping", new TopLevelDomain("ping", Type.UNKNOWN, null)},
			{"pioneer", new TopLevelDomain("pioneer", Type.UNKNOWN, null)},
			{"play", new TopLevelDomain("play", Type.UNKNOWN, null)},
			{"playstation", new TopLevelDomain("playstation", Type.UNKNOWN, null)},
			{"pnc", new TopLevelDomain("pnc", Type.UNKNOWN, null)},
			{"politie", new TopLevelDomain("politie", Type.UNKNOWN, null)},
			{"pramerica", new TopLevelDomain("pramerica", Type.UNKNOWN, null)},
			{"prime", new TopLevelDomain("prime", Type.UNKNOWN, null)},
			{"progressive", new TopLevelDomain("progressive", Type.UNKNOWN, null)},
			{"promo", new TopLevelDomain("promo", Type.UNKNOWN, null)},
			{"protection", new TopLevelDomain("protection", Type.UNKNOWN, null)},
			{"pru", new TopLevelDomain("pru", Type.UNKNOWN, null)},
			{"prudential", new TopLevelDomain("prudential", Type.UNKNOWN, null)},
			{"quest", new TopLevelDomain("quest", Type.UNKNOWN, null)},
			{"qvc", new TopLevelDomain("qvc", Type.UNKNOWN, null)},
			{"raid", new TopLevelDomain("raid", Type.UNKNOWN, null)},
			{"read", new TopLevelDomain("read", Type.UNKNOWN, null)},
			{"realestate", new TopLevelDomain("realestate", Type.UNKNOWN, null)},
			{"realty", new TopLevelDomain("realty", Type.UNKNOWN, null)},
			{"redstone", new TopLevelDomain("redstone", Type.UNKNOWN, null)},
			{"redumbrella", new TopLevelDomain("redumbrella", Type.UNKNOWN, null)},
			{"reit", new TopLevelDomain("reit", Type.UNKNOWN, null)},
			{"rexroth", new TopLevelDomain("rexroth", Type.UNKNOWN, null)},
			{"richardli", new TopLevelDomain("richardli", Type.UNKNOWN, null)},
			{"ricoh", new TopLevelDomain("ricoh", Type.UNKNOWN, null)},
			{"rightathome", new TopLevelDomain("rightathome", Type.UNKNOWN, null)},
			{"rocher", new TopLevelDomain("rocher", Type.UNKNOWN, null)},
			{"rogers", new TopLevelDomain("rogers", Type.UNKNOWN, null)},
			{"room", new TopLevelDomain("room", Type.UNKNOWN, null)},
			{"rwe", new TopLevelDomain("rwe", Type.UNKNOWN, null)},
			{"safe", new TopLevelDomain("safe", Type.UNKNOWN, null)},
			{"safety", new TopLevelDomain("safety", Type.UNKNOWN, null)},
			{"sakura", new TopLevelDomain("sakura", Type.UNKNOWN, null)},
			{"salon", new TopLevelDomain("salon", Type.UNKNOWN, null)},
			{"samsclub", new TopLevelDomain("samsclub", Type.UNKNOWN, null)},
			{"samsung", new TopLevelDomain("samsung", Type.UNKNOWN, null)},
			{"sandvik", new TopLevelDomain("sandvik", Type.UNKNOWN, null)},
			{"sanofi", new TopLevelDomain("sanofi", Type.UNKNOWN, null)},
			{"sap", new TopLevelDomain("sap", Type.UNKNOWN, null)},
			{"sapo", new TopLevelDomain("sapo", Type.UNKNOWN, null)},
			{"sas", new TopLevelDomain("sas", Type.UNKNOWN, null)},
			{"save", new TopLevelDomain("save", Type.UNKNOWN, null)},
			{"saxo", new TopLevelDomain("saxo", Type.UNKNOWN, null)},
			{"sbi", new TopLevelDomain("sbi", Type.UNKNOWN, null)},
			{"sbs", new TopLevelDomain("sbs", Type.UNKNOWN, null)},
			{"schaeffler", new TopLevelDomain("schaeffler", Type.UNKNOWN, null)},
			{"scholarships", new TopLevelDomain("scholarships", Type.UNKNOWN, null)},
			{"schwarz", new TopLevelDomain("schwarz", Type.UNKNOWN, null)},
			{"scjohnson", new TopLevelDomain("scjohnson", Type.UNKNOWN, null)},
			{"scor", new TopLevelDomain("scor", Type.UNKNOWN, null)},
			{"seat", new TopLevelDomain("seat", Type.UNKNOWN, null)},
			{"secure", new TopLevelDomain("secure", Type.UNKNOWN, null)},
			{"security", new TopLevelDomain("security", Type.UNKNOWN, null)},
			{"select", new TopLevelDomain("select", Type.UNKNOWN, null)},
			{"sener", new TopLevelDomain("sener", Type.UNKNOWN, null)},
			{"ses", new TopLevelDomain("ses", Type.UNKNOWN, null)},
			{"seven", new TopLevelDomain("seven", Type.UNKNOWN, null)},
			{"sew", new TopLevelDomain("sew", Type.UNKNOWN, null)},
			{"sfr", new TopLevelDomain("sfr", Type.UNKNOWN, null)},
			{"shangrila", new TopLevelDomain("shangrila", Type.UNKNOWN, null)},
			{"sharp", new TopLevelDomain("sharp", Type.UNKNOWN, null)},
			{"shaw", new TopLevelDomain("shaw", Type.UNKNOWN, null)},
			{"shell", new TopLevelDomain("shell", Type.UNKNOWN, null)},
			{"shia", new TopLevelDomain("shia", Type.UNKNOWN, null)},
			{"shop", new TopLevelDomain("shop", Type.UNKNOWN, null)},
			{"shopping", new TopLevelDomain("shopping", Type.UNKNOWN, null)},
			{"shouji", new TopLevelDomain("shouji", Type.UNKNOWN, null)},
			{"showtime", new TopLevelDomain("showtime", Type.UNKNOWN, null)},
			{"shriram", new TopLevelDomain("shriram", Type.UNKNOWN, null)},
			{"silk", new TopLevelDomain("silk", Type.UNKNOWN, null)},
			{"sina", new TopLevelDomain("sina", Type.UNKNOWN, null)},
			{"ski", new TopLevelDomain("ski", Type.UNKNOWN, null)},
			{"skin", new TopLevelDomain("skin", Type.UNKNOWN, null)},
			{"sky", new TopLevelDomain("sky", Type.UNKNOWN, null)},
			{"skype", new TopLevelDomain("skype", Type.UNKNOWN, null)},
			{"sling", new TopLevelDomain("sling", Type.UNKNOWN, null)},
			{"smart", new TopLevelDomain("smart", Type.UNKNOWN, null)},
			{"smile", new TopLevelDomain("smile", Type.UNKNOWN, null)},
			{"sncf", new TopLevelDomain("sncf", Type.UNKNOWN, null)},
			{"softbank", new TopLevelDomain("softbank", Type.UNKNOWN, null)},
			{"song", new TopLevelDomain("song", Type.UNKNOWN, null)},
			{"sony", new TopLevelDomain("sony", Type.UNKNOWN, null)},
			{"spot", new TopLevelDomain("spot", Type.UNKNOWN, null)},
			{"spreadbetting", new TopLevelDomain("spreadbetting", Type.UNKNOWN, null)},
			{"srl", new TopLevelDomain("srl", Type.UNKNOWN, null)},
			{"srt", new TopLevelDomain("srt", Type.UNKNOWN, null)},
			{"stada", new TopLevelDomain("stada", Type.UNKNOWN, null)},
			{"staples", new TopLevelDomain("staples", Type.UNKNOWN, null)},
			{"star", new TopLevelDomain("star", Type.UNKNOWN, null)},
			{"starhub", new TopLevelDomain("starhub", Type.UNKNOWN, null)},
			{"statebank", new TopLevelDomain("statebank", Type.UNKNOWN, null)},
			{"statefarm", new TopLevelDomain("statefarm", Type.UNKNOWN, null)},
			{"statoil", new TopLevelDomain("statoil", Type.UNKNOWN, null)},
			{"stc", new TopLevelDomain("stc", Type.UNKNOWN, null)},
			{"stcgroup", new TopLevelDomain("stcgroup", Type.UNKNOWN, null)},
			{"stockholm", new TopLevelDomain("stockholm", Type.UNKNOWN, null)},
			{"storage", new TopLevelDomain("storage", Type.UNKNOWN, null)},
			{"stream", new TopLevelDomain("stream", Type.UNKNOWN, null)},
			{"study", new TopLevelDomain("study", Type.UNKNOWN, null)},
			{"swatch", new TopLevelDomain("swatch", Type.UNKNOWN, null)},
			{"swiftcover", new TopLevelDomain("swiftcover", Type.UNKNOWN, null)},
			{"swiss", new TopLevelDomain("swiss", Type.UNKNOWN, null)},
			{"symantec", new TopLevelDomain("symantec", Type.UNKNOWN, null)},
			{"tab", new TopLevelDomain("tab", Type.UNKNOWN, null)},
			{"talk", new TopLevelDomain("talk", Type.UNKNOWN, null)},
			{"taobao", new TopLevelDomain("taobao", Type.UNKNOWN, null)},
			{"target", new TopLevelDomain("target", Type.UNKNOWN, null)},
			{"tatamotors", new TopLevelDomain("tatamotors", Type.UNKNOWN, null)},
			{"tci", new TopLevelDomain("tci", Type.UNKNOWN, null)},
			{"tdk", new TopLevelDomain("tdk", Type.UNKNOWN, null)},
			{"telecity", new TopLevelDomain("telecity", Type.UNKNOWN, null)},
			{"telefonica", new TopLevelDomain("telefonica", Type.UNKNOWN, null)},
			{"temasek", new TopLevelDomain("temasek", Type.UNKNOWN, null)},
			{"teva", new TopLevelDomain("teva", Type.UNKNOWN, null)},
			{"thd", new TopLevelDomain("thd", Type.UNKNOWN, null)},
			{"theatre", new TopLevelDomain("theatre", Type.UNKNOWN, null)},
			{"tiaa", new TopLevelDomain("tiaa", Type.UNKNOWN, null)},
			{"tickets", new TopLevelDomain("tickets", Type.UNKNOWN, null)},
			{"tiffany", new TopLevelDomain("tiffany", Type.UNKNOWN, null)},
			{"tjmaxx", new TopLevelDomain("tjmaxx", Type.UNKNOWN, null)},
			{"tjx", new TopLevelDomain("tjx", Type.UNKNOWN, null)},
			{"tkmaxx", new TopLevelDomain("tkmaxx", Type.UNKNOWN, null)},
			{"tmall", new TopLevelDomain("tmall", Type.UNKNOWN, null)},
			{"toray", new TopLevelDomain("toray", Type.UNKNOWN, null)},
			{"toshiba", new TopLevelDomain("toshiba", Type.UNKNOWN, null)},
			{"total", new TopLevelDomain("total", Type.UNKNOWN, null)},
			{"toyota", new TopLevelDomain("toyota", Type.UNKNOWN, null)},
			{"trading", new TopLevelDomain("trading", Type.UNKNOWN, null)},
			{"travelchannel", new TopLevelDomain("travelchannel", Type.UNKNOWN, null)},
			{"travelers", new TopLevelDomain("travelers", Type.UNKNOWN, null)},
			{"travelersinsurance", new TopLevelDomain("travelersinsurance", Type.UNKNOWN, null)},
			{"trust", new TopLevelDomain("trust", Type.UNKNOWN, null)},
			{"trv", new TopLevelDomain("trv", Type.UNKNOWN, null)},
			{"tube", new TopLevelDomain("tube", Type.UNKNOWN, null)},
			{"tunes", new TopLevelDomain("tunes", Type.UNKNOWN, null)},
			{"tushu", new TopLevelDomain("tushu", Type.UNKNOWN, null)},
			{"tvs", new TopLevelDomain("tvs", Type.UNKNOWN, null)},
			{"ubank", new TopLevelDomain("ubank", Type.UNKNOWN, null)},
			{"ubs", new TopLevelDomain("ubs", Type.UNKNOWN, null)},
			{"uconnect", new TopLevelDomain("uconnect", Type.UNKNOWN, null)},
			{"unicom", new TopLevelDomain("unicom", Type.UNKNOWN, null)},
			{"ups", new TopLevelDomain("ups", Type.UNKNOWN, null)},
			{"vana", new TopLevelDomain("vana", Type.UNKNOWN, null)},
			{"vanguard", new TopLevelDomain("vanguard", Type.UNKNOWN, null)},
			{"verisign", new TopLevelDomain("verisign", Type.UNKNOWN, null)},
			{"vig", new TopLevelDomain("vig", Type.UNKNOWN, null)},
			{"viking", new TopLevelDomain("viking", Type.UNKNOWN, null)},
			{"vin", new TopLevelDomain("vin", Type.UNKNOWN, null)},
			{"vip", new TopLevelDomain("vip", Type.UNKNOWN, null)},
			{"virgin", new TopLevelDomain("virgin", Type.UNKNOWN, null)},
			{"visa", new TopLevelDomain("visa", Type.UNKNOWN, null)},
			{"vista", new TopLevelDomain("vista", Type.UNKNOWN, null)},
			{"vistaprint", new TopLevelDomain("vistaprint", Type.UNKNOWN, null)},
			{"viva", new TopLevelDomain("viva", Type.UNKNOWN, null)},
			{"vivo", new TopLevelDomain("vivo", Type.UNKNOWN, null)},
			{"volkswagen", new TopLevelDomain("volkswagen", Type.UNKNOWN, null)},
			{"vuelos", new TopLevelDomain("vuelos", Type.UNKNOWN, null)},
			{"walmart", new TopLevelDomain("walmart", Type.UNKNOWN, null)},
			{"walter", new TopLevelDomain("walter", Type.UNKNOWN, null)},
			{"wanggou", new TopLevelDomain("wanggou", Type.UNKNOWN, null)},
			{"warman", new TopLevelDomain("warman", Type.UNKNOWN, null)},
			{"watches", new TopLevelDomain("watches", Type.UNKNOWN, null)},
			{"weather", new TopLevelDomain("weather", Type.UNKNOWN, null)},
			{"weatherchannel", new TopLevelDomain("weatherchannel", Type.UNKNOWN, null)},
			{"weber", new TopLevelDomain("weber", Type.UNKNOWN, null)},
			{"weibo", new TopLevelDomain("weibo", Type.UNKNOWN, null)},
			{"weir", new TopLevelDomain("weir", Type.UNKNOWN, null)},
			{"windows", new TopLevelDomain("windows", Type.UNKNOWN, null)},
			{"winners", new TopLevelDomain("winners", Type.UNKNOWN, null)},
			{"wolterskluwer", new TopLevelDomain("wolterskluwer", Type.UNKNOWN, null)},
			{"woodside", new TopLevelDomain("woodside", Type.UNKNOWN, null)},
			{"wow", new TopLevelDomain("wow", Type.UNKNOWN, null)},
			{"xbox", new TopLevelDomain("xbox", Type.UNKNOWN, null)},
			{"xerox", new TopLevelDomain("xerox", Type.UNKNOWN, null)},
			{"xfinity", new TopLevelDomain("xfinity", Type.UNKNOWN, null)},
			{"xihuan", new TopLevelDomain("xihuan", Type.UNKNOWN, null)},
			{"xin", new TopLevelDomain("xin", Type.UNKNOWN, null)},
			{"xn--11b4c3d", new TopLevelDomain("xn--11b4c3d", Type.UNKNOWN, null)},
			{"xn--1ck2e1b", new TopLevelDomain("xn--1ck2e1b", Type.UNKNOWN, null)},
			{"xn--30rr7y", new TopLevelDomain("xn--30rr7y", Type.UNKNOWN, null)},
			{"xn--3bst00m", new TopLevelDomain("xn--3bst00m", Type.UNKNOWN, null)},
			{"xn--3ds443g", new TopLevelDomain("xn--3ds443g", Type.UNKNOWN, null)},
			{"xn--3e0b707e", new TopLevelDomain("xn--3e0b707e", Type.UNKNOWN, null)},
			{"xn--3oq18vl8pn36a", new TopLevelDomain("xn--3oq18vl8pn36a", Type.UNKNOWN, null)},
			{"xn--3pxu8k", new TopLevelDomain("xn--3pxu8k", Type.UNKNOWN, null)},
			{"xn--42c2d9a", new TopLevelDomain("xn--42c2d9a", Type.UNKNOWN, null)},
			{"xn--45brj9c", new TopLevelDomain("xn--45brj9c", Type.UNKNOWN, null)},
			{"xn--45q11c", new TopLevelDomain("xn--45q11c", Type.UNKNOWN, null)},
			{"xn--4gbrim", new TopLevelDomain("xn--4gbrim", Type.UNKNOWN, null)},
			{"xn--55qw42g", new TopLevelDomain("xn--55qw42g", Type.UNKNOWN, null)},
			{"xn--55qx5d", new TopLevelDomain("xn--55qx5d", Type.UNKNOWN, null)},
			{"xn--5su34j936bgsg", new TopLevelDomain("xn--5su34j936bgsg", Type.UNKNOWN, null)},
			{"xn--5tzm5g", new TopLevelDomain("xn--5tzm5g", Type.UNKNOWN, null)},
			{"xn--6frz82g", new TopLevelDomain("xn--6frz82g", Type.UNKNOWN, null)},
			{"xn--6qq986b3xl", new TopLevelDomain("xn--6qq986b3xl", Type.UNKNOWN, null)},
			{"xn--80ao21a", new TopLevelDomain("xn--80ao21a", Type.UNKNOWN, null)},
			{"xn--80asehdb", new TopLevelDomain("xn--80asehdb", Type.UNKNOWN, null)},
			{"xn--80aswg", new TopLevelDomain("xn--80aswg", Type.UNKNOWN, null)},
			{"xn--8y0a063a", new TopLevelDomain("xn--8y0a063a", Type.UNKNOWN, null)},
			{"xn--90a3ac", new TopLevelDomain("xn--90a3ac", Type.UNKNOWN, null)},
			{"xn--90ae", new TopLevelDomain("xn--90ae", Type.UNKNOWN, null)},
			{"xn--90ais", new TopLevelDomain("xn--90ais", Type.UNKNOWN, null)},
			{"xn--9dbq2a", new TopLevelDomain("xn--9dbq2a", Type.UNKNOWN, null)},
			{"xn--9et52u", new TopLevelDomain("xn--9et52u", Type.UNKNOWN, null)},
			{"xn--9krt00a", new TopLevelDomain("xn--9krt00a", Type.UNKNOWN, null)},
			{"xn--b4w605ferd", new TopLevelDomain("xn--b4w605ferd", Type.UNKNOWN, null)},
			{"xn--bck1b9a5dre4c", new TopLevelDomain("xn--bck1b9a5dre4c", Type.UNKNOWN, null)},
			{"xn--c1avg", new TopLevelDomain("xn--c1avg", Type.UNKNOWN, null)},
			{"xn--c2br7g", new TopLevelDomain("xn--c2br7g", Type.UNKNOWN, null)},
			{"xn--cck2b3b", new TopLevelDomain("xn--cck2b3b", Type.UNKNOWN, null)},
			{"xn--clchc0ea0b2g2a9gcd", new TopLevelDomain("xn--clchc0ea0b2g2a9gcd", Type.UNKNOWN, null)},
			{"xn--czr694b", new TopLevelDomain("xn--czr694b", Type.UNKNOWN, null)},
			{"xn--czrs0t", new TopLevelDomain("xn--czrs0t", Type.UNKNOWN, null)},
			{"xn--czru2d", new TopLevelDomain("xn--czru2d", Type.UNKNOWN, null)},
			{"xn--d1acj3b", new TopLevelDomain("xn--d1acj3b", Type.UNKNOWN, null)},
			{"xn--d1alf", new TopLevelDomain("xn--d1alf", Type.UNKNOWN, null)},
			{"xn--e1a4c", new TopLevelDomain("xn--e1a4c", Type.UNKNOWN, null)},
			{"xn--eckvdtc9d", new TopLevelDomain("xn--eckvdtc9d", Type.UNKNOWN, null)},
			{"xn--efvy88h", new TopLevelDomain("xn--efvy88h", Type.UNKNOWN, null)},
			{"xn--estv75g", new TopLevelDomain("xn--estv75g", Type.UNKNOWN, null)},
			{"xn--fct429k", new TopLevelDomain("xn--fct429k", Type.UNKNOWN, null)},
			{"xn--fhbei", new TopLevelDomain("xn--fhbei", Type.UNKNOWN, null)},
			{"xn--fiq228c5hs", new TopLevelDomain("xn--fiq228c5hs", Type.UNKNOWN, null)},
			{"xn--fiqs8s", new TopLevelDomain("xn--fiqs8s", Type.UNKNOWN, null)},
			{"xn--fiqz9s", new TopLevelDomain("xn--fiqz9s", Type.UNKNOWN, null)},
			{"xn--fjq720a", new TopLevelDomain("xn--fjq720a", Type.UNKNOWN, null)},
			{"xn--fpcrj9c3d", new TopLevelDomain("xn--fpcrj9c3d", Type.UNKNOWN, null)},
			{"xn--fzc2c9e2c", new TopLevelDomain("xn--fzc2c9e2c", Type.UNKNOWN, null)},
			{"xn--fzys8d69uvgm", new TopLevelDomain("xn--fzys8d69uvgm", Type.UNKNOWN, null)},
			{"xn--g2xx48c", new TopLevelDomain("xn--g2xx48c", Type.UNKNOWN, null)},
			{"xn--gckr3f0f", new TopLevelDomain("xn--gckr3f0f", Type.UNKNOWN, null)},
			{"xn--gecrj9c", new TopLevelDomain("xn--gecrj9c", Type.UNKNOWN, null)},
			{"xn--h2brj9c", new TopLevelDomain("xn--h2brj9c", Type.UNKNOWN, null)},
			{"xn--hxt814e", new TopLevelDomain("xn--hxt814e", Type.UNKNOWN, null)},
			{"xn--i1b6b1a6a2e", new TopLevelDomain("xn--i1b6b1a6a2e", Type.UNKNOWN, null)},
			{"xn--imr513n", new TopLevelDomain("xn--imr513n", Type.UNKNOWN, null)},
			{"xn--io0a7i", new TopLevelDomain("xn--io0a7i", Type.UNKNOWN, null)},
			{"xn--j1aef", new TopLevelDomain("xn--j1aef", Type.UNKNOWN, null)},
			{"xn--j1amh", new TopLevelDomain("xn--j1amh", Type.UNKNOWN, null)},
			{"xn--j6w193g", new TopLevelDomain("xn--j6w193g", Type.UNKNOWN, null)},
			{"xn--jlq61u9w7b", new TopLevelDomain("xn--jlq61u9w7b", Type.UNKNOWN, null)},
			{"xn--jvr189m", new TopLevelDomain("xn--jvr189m", Type.UNKNOWN, null)},
			{"xn--kcrx77d1x4a", new TopLevelDomain("xn--kcrx77d1x4a", Type.UNKNOWN, null)},
			{"xn--kprw13d", new TopLevelDomain("xn--kprw13d", Type.UNKNOWN, null)},
			{"xn--kpry57d", new TopLevelDomain("xn--kpry57d", Type.UNKNOWN, null)},
			{"xn--kpu716f", new TopLevelDomain("xn--kpu716f", Type.UNKNOWN, null)},
			{"xn--kput3i", new TopLevelDomain("xn--kput3i", Type.UNKNOWN, null)},
			{"xn--l1acc", new TopLevelDomain("xn--l1acc", Type.UNKNOWN, null)},
			{"xn--lgbbat1ad8j", new TopLevelDomain("xn--lgbbat1ad8j", Type.UNKNOWN, null)},
			{"xn--mgb9awbf", new TopLevelDomain("xn--mgb9awbf", Type.UNKNOWN, null)},
			{"xn--mgba3a3ejt", new TopLevelDomain("xn--mgba3a3ejt", Type.UNKNOWN, null)},
			{"xn--mgba3a4f16a", new TopLevelDomain("xn--mgba3a4f16a", Type.UNKNOWN, null)},
			{"xn--mgba7c0bbn0a", new TopLevelDomain("xn--mgba7c0bbn0a", Type.UNKNOWN, null)},
			{"xn--mgbaam7a8h", new TopLevelDomain("xn--mgbaam7a8h", Type.UNKNOWN, null)},
			{"xn--mgbab2bd", new TopLevelDomain("xn--mgbab2bd", Type.UNKNOWN, null)},
			{"xn--mgbayh7gpa", new TopLevelDomain("xn--mgbayh7gpa", Type.UNKNOWN, null)},
			{"xn--mgbb9fbpob", new TopLevelDomain("xn--mgbb9fbpob", Type.UNKNOWN, null)},
			{"xn--mgbbh1a71e", new TopLevelDomain("xn--mgbbh1a71e", Type.UNKNOWN, null)},
			{"xn--mgbc0a9azcg", new TopLevelDomain("xn--mgbc0a9azcg", Type.UNKNOWN, null)},
			{"xn--mgbca7dzdo", new TopLevelDomain("xn--mgbca7dzdo", Type.UNKNOWN, null)},
			{"xn--mgberp4a5d4ar", new TopLevelDomain("xn--mgberp4a5d4ar", Type.UNKNOWN, null)},
			{"xn--mgbpl2fh", new TopLevelDomain("xn--mgbpl2fh", Type.UNKNOWN, null)},
			{"xn--mgbt3dhd", new TopLevelDomain("xn--mgbt3dhd", Type.UNKNOWN, null)},
			{"xn--mgbtx2b", new TopLevelDomain("xn--mgbtx2b", Type.UNKNOWN, null)},
			{"xn--mgbx4cd0ab", new TopLevelDomain("xn--mgbx4cd0ab", Type.UNKNOWN, null)},
			{"xn--mix891f", new TopLevelDomain("xn--mix891f", Type.UNKNOWN, null)},
			{"xn--mk1bu44c", new TopLevelDomain("xn--mk1bu44c", Type.UNKNOWN, null)},
			{"xn--mxtq1m", new TopLevelDomain("xn--mxtq1m", Type.UNKNOWN, null)},
			{"xn--ngbc5azd", new TopLevelDomain("xn--ngbc5azd", Type.UNKNOWN, null)},
			{"xn--ngbe9e0a", new TopLevelDomain("xn--ngbe9e0a", Type.UNKNOWN, null)},
			{"xn--node", new TopLevelDomain("xn--node", Type.UNKNOWN, null)},
			{"xn--nqv7f", new TopLevelDomain("xn--nqv7f", Type.UNKNOWN, null)},
			{"xn--nqv7fs00ema", new TopLevelDomain("xn--nqv7fs00ema", Type.UNKNOWN, null)},
			{"xn--nyqy26a", new TopLevelDomain("xn--nyqy26a", Type.UNKNOWN, null)},
			{"xn--o3cw4h", new TopLevelDomain("xn--o3cw4h", Type.UNKNOWN, null)},
			{"xn--ogbpf8fl", new TopLevelDomain("xn--ogbpf8fl", Type.UNKNOWN, null)},
			{"xn--p1acf", new TopLevelDomain("xn--p1acf", Type.UNKNOWN, null)},
			{"xn--p1ai", new TopLevelDomain("xn--p1ai", Type.UNKNOWN, null)},
			{"xn--pbt977c", new TopLevelDomain("xn--pbt977c", Type.UNKNOWN, null)},
			{"xn--pgbs0dh", new TopLevelDomain("xn--pgbs0dh", Type.UNKNOWN, null)},
			{"xn--pssy2u", new TopLevelDomain("xn--pssy2u", Type.UNKNOWN, null)},
			{"xn--q9jyb4c", new TopLevelDomain("xn--q9jyb4c", Type.UNKNOWN, null)},
			{"xn--qxam", new TopLevelDomain("xn--qxam", Type.UNKNOWN, null)},
			{"xn--rhqv96g", new TopLevelDomain("xn--rhqv96g", Type.UNKNOWN, null)},
			{"xn--rovu88b", new TopLevelDomain("xn--rovu88b", Type.UNKNOWN, null)},
			{"xn--s9brj9c", new TopLevelDomain("xn--s9brj9c", Type.UNKNOWN, null)},
			{"xn--ses554g", new TopLevelDomain("xn--ses554g", Type.UNKNOWN, null)},
			{"xn--t60b56a", new TopLevelDomain("xn--t60b56a", Type.UNKNOWN, null)},
			{"xn--tckwe", new TopLevelDomain("xn--tckwe", Type.UNKNOWN, null)},
			{"xn--unup4y", new TopLevelDomain("xn--unup4y", Type.UNKNOWN, null)},
			{"xn--vhquv", new TopLevelDomain("xn--vhquv", Type.UNKNOWN, null)},
			{"xn--vuq861b", new TopLevelDomain("xn--vuq861b", Type.UNKNOWN, null)},
			{"xn--w4r85el8fhu5dnra", new TopLevelDomain("xn--w4r85el8fhu5dnra", Type.UNKNOWN, null)},
			{"xn--w4rs40l", new TopLevelDomain("xn--w4rs40l", Type.UNKNOWN, null)},
			{"xn--wgbh1c", new TopLevelDomain("xn--wgbh1c", Type.UNKNOWN, null)},
			{"xn--wgbl6a", new TopLevelDomain("xn--wgbl6a", Type.UNKNOWN, null)},
			{"xn--xhq521b", new TopLevelDomain("xn--xhq521b", Type.UNKNOWN, null)},
			{"xn--xkc2al3hye2a", new TopLevelDomain("xn--xkc2al3hye2a", Type.UNKNOWN, null)},
			{"xn--xkc2dl3a5ee0h", new TopLevelDomain("xn--xkc2dl3a5ee0h", Type.UNKNOWN, null)},
			{"xn--y9a3aq", new TopLevelDomain("xn--y9a3aq", Type.UNKNOWN, null)},
			{"xn--yfro4i67o", new TopLevelDomain("xn--yfro4i67o", Type.UNKNOWN, null)},
			{"xn--ygbi2ammx", new TopLevelDomain("xn--ygbi2ammx", Type.UNKNOWN, null)},
			{"xn--zfr164b", new TopLevelDomain("xn--zfr164b", Type.UNKNOWN, null)},
			{"xperia", new TopLevelDomain("xperia", Type.UNKNOWN, null)},
			{"yachts", new TopLevelDomain("yachts", Type.UNKNOWN, null)},
			{"yahoo", new TopLevelDomain("yahoo", Type.UNKNOWN, null)},
			{"yamaxun", new TopLevelDomain("yamaxun", Type.UNKNOWN, null)},
			{"yodobashi", new TopLevelDomain("yodobashi", Type.UNKNOWN, null)},
			{"you", new TopLevelDomain("you", Type.UNKNOWN, null)},
			{"yun", new TopLevelDomain("yun", Type.UNKNOWN, null)},
			{"zappos", new TopLevelDomain("zappos", Type.UNKNOWN, null)},
			{"zara", new TopLevelDomain("zara", Type.UNKNOWN, null)},
			{"zero", new TopLevelDomain("zero", Type.UNKNOWN, null)},
			{"zip", new TopLevelDomain("zip", Type.UNKNOWN, null)},
			{"zippo", new TopLevelDomain("zippo", Type.UNKNOWN, null)},
	});

	protected String name;
	protected Type type;
	protected String entity;

	//============== KOSTRUKTORY A TOVARNI METODY ===============================
	protected TopLevelDomain(String name, Type type) {
		this.name = name;
		this.type = type;
		this.entity = "";
	}

	protected TopLevelDomain(String name, Type type, String entity) {
		this.name = name;
		this.type = type;
		this.entity = entity;
	}

	public static TopLevelDomain byName(String name) {
		return MAP.get(name.toLowerCase());
	}

	*/

	public static boolean domainExists(String domain) {
		Objects.requireNonNull(domain);
		return domains.contains(domain.toLowerCase());
	}

	/*
	//============== VEREJNE METODY INSTANCE ====================================
	public String getName() {
		return name;
	}
	public Type getType() {
		return type;
	}
	public String getEntity() {
		return entity;
	}*/
	//============== SOUKROME METODY INSTANCE ===================================

	//============== VNORENE A VNITRNI TRIDY ====================================
	public static enum Type {
		GENERIC,
		COUNTRY_CODE,
		INFRASTRUCTURE,
		RESTRICTED_GENERIC,
		SPONSORED,
		GEOGRAPHIC,
		BRAND,
		TEST,
		UNKNOWN;
	}


	//============== OSTATNI (MAIN A AUTOMATICKY GENEROVANE METODY) =============
	private static void check() throws Exception {
		URL url = new URL("http://data.iana.org/TLD/tlds-alpha-by-domain.txt");
		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();  // ** WRONG: should use "con.getContentType()" instead but it returns something like "text/html; charset=UTF-8" so this value must be parsed to extract the actual encoding
		encoding = encoding == null ? "UTF-8" : encoding;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[8192];
		int len = 0;
		while ((len = in.read(buf)) != -1) {
			baos.write(buf, 0, len);
		}
		String body = new String(baos.toByteArray(), encoding);

		int missingCnt = 0;
		Scanner scanner = new Scanner(body);
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			if (!line.startsWith("#")) {
				//if(!MAP.containsKey(line.toLowerCase())) {
				if (!domains.contains(line.toLowerCase())) {
					//System.out.println("{\"" + line.toLowerCase() + "\", new TopLevelDomain(\"" + line.toLowerCase() + "\", Type.UNKNOWN, null)},");
					System.out.println("domains.add(\"" + line.toLowerCase() + "\");");
					missingCnt++;
				}
			}
		}
		scanner.close();
		System.out.println("Missing " + missingCnt + " TLDs");
	}

	public static void main(String[] args) throws Exception {
		check();
	}
}
