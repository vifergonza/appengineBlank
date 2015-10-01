package com.vfg.appengineblank.commons.security;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;

public class RestcacheSecurityContextRepository implements SecurityContextRepository {

	public static final String HEADER_TOKEN ="AUTH-TOKEN";
	
	private static Map<String, SecurityContext> contextMap = new HashMap<String, SecurityContext>(); 
	
	/**
	 * @inheritDoc
	 */
	@Override
	public boolean containsContext(HttpServletRequest request) {
		return StringUtils.isNoneEmpty(getTokenHeader(request));
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public SecurityContext loadContext(HttpRequestResponseHolder responseHolder) {
		if (containsContext(responseHolder.getRequest())) {
			String token = getTokenHeader(responseHolder.getRequest());
			return contextMap.get(token);
		} else {
			return SecurityContextHolder.createEmptyContext();
		}
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = context.getAuthentication();
		if (null!=authentication) {
			String authenticationDetail = (String) authentication.getDetails();
			if (null!=authenticationDetail) {
				contextMap.put(authenticationDetail, context);
			}
		}
	}

	private String getTokenHeader(HttpServletRequest request) {
		return request.getHeader(HEADER_TOKEN);
	}
}
