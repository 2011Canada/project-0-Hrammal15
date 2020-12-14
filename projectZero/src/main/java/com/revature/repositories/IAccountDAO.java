package com.revature.repositories;

import com.revature.exceptions.BalanceBelowZeroException;
import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.InvalidInputsExeption;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.User;

public interface IAccountDAO {
	
	public Account newAccount(Customer customer) throws InvalidInputsExeption, InternalErrorException;
	public Account getAccountInformation(String username, String password) throws UserNotFoundException, InternalErrorException;
	public Account setBalance(Account a , double balance ) throws BalanceBelowZeroException, InternalErrorException;
	public Customer changeType(User u) throws BalanceBelowZeroException, InternalErrorException;


}
