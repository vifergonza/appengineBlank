package com.vfg.appengineblank.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vfg.appengineblank.commons.Utils;
import com.vfg.appengineblank.commons.dto.RequestDto;
import com.vfg.appengineblank.commons.dto.ResponseDto;

/**
 * Servicio de prueba.
 * 
 * @author victor
 */

@Controller
@RequestMapping("/info")
public class InfoService {

	/**
	 * Retorna un mensaje de OK en el formato especificado en la cabecera Accept
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody ResponseDto getStatus() {
		ResponseDto respuesta = new ResponseDto();
		respuesta.setMessage(Utils.getMessage("info.test.ok"));
		return respuesta;
	}

	/**
	 * Retorna la cadena recibida como valor de peticion.param invertida.
	 * Es capaz de entender datos en varios formatos segun la cabecera Content-type y retorna
	 * en el formato especificado en la cabecera Accept
	 * @param peticion
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public @ResponseBody ResponseDto getReversedString(@RequestBody RequestDto peticion) {
		ResponseDto respuesta = new ResponseDto();
		if (StringUtils.isEmpty(peticion.getParam())) {
			respuesta.setError(Boolean.TRUE);
			respuesta.setMessage(Utils.getMessage("info.test.ok"));
		} else {
			respuesta.setMessage(StringUtils.reverse(peticion.getParam()));
		}
		return respuesta;
	}

}
