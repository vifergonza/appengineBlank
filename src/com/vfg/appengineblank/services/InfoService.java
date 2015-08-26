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

@Controller
@RequestMapping("/info")
public class InfoService {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody ResponseDto getStatus() {
		ResponseDto respuesta = new ResponseDto();
		respuesta.setMessage(Utils.getMessage("info.test.ok"));
		return respuesta;
	}

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
