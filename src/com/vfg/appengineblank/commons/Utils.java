package com.vfg.appengineblank.commons;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.i18n.LocaleContextHolder;

public class Utils {
	
	/**
	 * Ruta a los properties de internacionalización
	 */
	private static final String I18N_MENSAJES = "com.vfg.appengineblank.commons.messages.mensajes";
	
	private static final Logger log = Logger.getLogger(Utils.class.getName());

	/**
	 * Retorna el valor internacionalizado de la key recibida como parametro.
	 * Si no se encuentra, retorna el valor de la propia key.
	 * 
	 * @param key
	 * @return String
	 */
	public static final String getMessage(String key){
		try {
			Locale locale = LocaleContextHolder.getLocale();
			ResourceBundle rb = ResourceBundle.getBundle(I18N_MENSAJES, locale);
			return rb.getString(key);
		} catch (Exception e) {
			log.log(Level.SEVERE, "key exception", e);
			return key;
		}
	}
	
	/**
	 * Retorna el valor internacionalizado de la key recibida como parametro.
	 * Si no se encuentra, retorna el valor de la propia key.
	 *  
	 * @param key
	 * @param parameters
	 * @return
	 */
	public static final String getMessage(String key, String[] parameters){
		try {
			return MessageFormat.format(getMessage(key), (Object[])parameters);
		} catch (Exception e) {
			log.log(Level.SEVERE, "key exception", e);
			return key;
		}
	}

}
