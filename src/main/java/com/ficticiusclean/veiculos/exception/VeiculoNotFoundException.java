package com.ficticiusclean.veiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VeiculoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VeiculoNotFoundException() {
		super();
	}

	public VeiculoNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VeiculoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public VeiculoNotFoundException(String message) {
		super(message);
	}

	public VeiculoNotFoundException(Throwable cause) {
		super(cause);
	}

}
