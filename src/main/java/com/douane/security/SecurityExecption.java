package com.douane.security;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SecurityExecption extends UsernameNotFoundException {

	public SecurityExecption(String msg, Throwable t) {
		super(msg, t);
		// TODO Auto-generated constructor stub
	}

	public SecurityExecption(String msg, Object extraInformation) {
		super(msg, extraInformation);
		// TODO Auto-generated constructor stub
	}

	public SecurityExecption(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
