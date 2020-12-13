package com.revature.services;

import com.revature.models.Customer;

public interface EmployeeServices {
	public Customer acceptOrReject(String username, String password, String firstname, String lastname);

}
