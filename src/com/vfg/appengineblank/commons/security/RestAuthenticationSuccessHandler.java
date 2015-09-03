package com.vfg.appengineblank.commons.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

/**
 * La autenticación basica de spring redirecciona automaticamente la peticion mediante un código 301.
 * Modificamos el manejador de la autenticación correcta para que simplemente retorne un 200 y no realice ninguna redirección.
 * 
 * @author vfernandezg
 *
 */
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RequestCache requestCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if (savedRequest == null) {
			clearAuthenticationAttributes(request);
			return;
		}
		String targetUrlParam = getTargetUrlParameter();
		if (isAlwaysUseDefaultTargetUrl() || (targetUrlParam != null && StringUtils.hasText(request.getParameter(targetUrlParam)))) {
			requestCache.removeRequest(request, response);
			clearAuthenticationAttributes(request);
			return;
		}
		clearAuthenticationAttributes(request);
	}

	public void setRequestCache(RequestCache requestCache) {
		this.requestCache = requestCache;
	}

}
