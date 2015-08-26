package com.vfg.appengineblank.commons.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase base auxiliar para las peticiones al servidor
 * 
 * @author victor
 */
@XmlRootElement(name="requestDto")
public class RequestDto implements Serializable {

	private static final long serialVersionUID = 5618051116416226820L;
	private String param;

	public String getParam() {
		return param;
	}
	
	@XmlElement
	public void setParam(String param) {
		this.param = param;
	}

}
