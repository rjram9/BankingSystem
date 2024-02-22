package com.banking.exceptions;

public class NoSuchUserException extends Exception{
	public NoSuchUserException(String msg) {
		super(msg);
	}
}
