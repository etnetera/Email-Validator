package cz.etn.emailvalidator;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Created by TPa on 10.07.18.
 */
public class I18N {
	private static final Logger LOG = Logger.getLogger(I18N.class.getName());

	public static String getTranslation(String key, Locale locale) {
		return getTranslation(key, locale, (Object[]) null);
	}

	public static String getTranslation(String key, Locale locale, Object... params) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
		return getTranslation(key, bundle, params);
	}

	public static String getTranslation(String key, ResourceBundle bundle, Object... params) {
		if (bundle.containsKey(key)) {
			return MessageFormat.format(bundle.getString(key), params);
		} else {
			LOG.warning("key " + key + " not found in messages bundle");
			return key;
		}
	}
}
