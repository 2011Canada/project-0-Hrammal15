package com.revature.services;

import com.revature.models.Customer;

public class EmployeeServicesImplementation implements EmployeeServices{

	public Customer acceptOrReject(String username, String password, String firstname, String lastname) {
		System.out.println("Please type\nACCEPT -> to accept the account\nREJECT to reject the account");
		System.out.println(username + " " + password + " " + firstname + " " + lastname);
		return null;
	}

}
