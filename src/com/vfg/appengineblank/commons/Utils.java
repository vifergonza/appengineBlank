package com.vfg.appengineblank.commons;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.i18n.LocaleContextHolder;

public class Utils {
	
	private static final Logger log = Logger.getLogger(Utils.class.getName());

	public static final String getMessage(String key){
		try {
			Locale locale = LocaleContextHolder.getLocale();
			ResourceBundle rb = ResourceBundle.getBundle("com.vfg.appengineblank.commons.messages.mensajes", locale);
			return rb.getString(key);
		} catch (Exception e) {
			log.log(Level.SEVERE, "key exception", e);
			return key;
		}
	}
	
	public static final String getMessage(String key, String[] parameters){
		try {
			return MessageFormat.format(getMessage(key), (Object[])parameters);
		} catch (Exception e) {
			log.log(Level.SEVERE, "key exception", e);
			return key;
		}
	}

}
