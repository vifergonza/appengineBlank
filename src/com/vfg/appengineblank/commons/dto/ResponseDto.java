package com.vfg.appengineblank.commons.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase generica para la respuesta al cliente.
 * 
 * @author vfernandezg
 */
@XmlRootElement(name="responseDto")
public class ResponseDto implements Serializable {

	private static final long serialVersionUID = 6405445088950774079L;

	private boolean error = false;
	private String message;

	public boolean isError() {
		return error;
	}

	@XmlElement
	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	@XmlElement
	public void setMessage(String message) {
		this.message = message;
	}

}
