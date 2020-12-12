package com.meritamerica.pair6.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BalanceErrorException extends Exception {
	public BalanceErrorException(String msg){
		super(msg);
	}
}
