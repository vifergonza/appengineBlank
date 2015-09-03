package com.vfg.appengineblank.commons.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.vfg.appengineblank.commons.Utils;

/**
 * En una aplicación web normal, el intento de acceso a un recurso protegido por un usuario no autenticado
 * dispara la redirección al formulario de login. Para evitar esto sobrecargamos el entry point y simplemente
 * retornamos error de UNAUTORIZED.
 * 
 * @author vfernandezg
 */

@Component("appEngineEntryPoint")
public class RestEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,	AuthenticationException authException) throws IOException, ServletException {
		response.sendError( HttpServletResponse.SC_UNAUTHORIZED, Utils.getMessage("security.unauthorized") );
	}
}
