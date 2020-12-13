package com.revature.repositories;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.InvalidInputsExeption;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Customer;

public interface ICustomerDAO {
	
	public Customer getCustomerInformation(String username , String password) throws UserNotFoundException, InternalErrorException;
	
	public Customer verifyType(String username, String password, String type) throws UserNotFoundException, InternalErrorException;
	
	public Customer newAccount(Customer customer) throws InvalidInputsExeption, InternalErrorException;



}
