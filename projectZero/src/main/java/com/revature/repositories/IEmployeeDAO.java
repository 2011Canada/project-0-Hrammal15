package com.revature.repositories;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.InvalidInputsExeption;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Customer;
import com.revature.models.Employee;

public interface IEmployeeDAO {
	
	public Employee findEmployeeByUsernameAndPassword(String username, String password) throws UserNotFoundException, InternalErrorException;
	
	public Employee verifyType(String username, String password, String type)throws UserNotFoundException, InternalErrorException;

}


