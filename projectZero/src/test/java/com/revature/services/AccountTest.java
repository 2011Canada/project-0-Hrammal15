package com.revature.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;


public class AccountTest {
	
	private UserDAO userDAO;
	private CustomerServiceImplementation usi;
	private User u;

	
	@BeforeEach
	public void setupTest() {
		this.userDAO = mock(UserDAO.class);
		this.usi =  new CustomerServiceImplementation();
		this.u = new User(1, "hrammal15", "password", "Hassen", "Rammal", "ACTIVE", "Employee", 500.00);	}
	
	
	@Test
	public void getBalanceTest() {
		
		
		double expectedValue = 500.00;
		try {
			when(userDAO.findUserByUsername("hrammal15")).thenReturn(u);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InternalErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(expectedValue, u.getBalance());

}
	}