package com.revature.exceptions;

public class BalanceBelowZeroException extends Exception {
	public BalanceBelowZeroException() {
		super("Please enter balance over 0");
	}

}
