package com.revature.services;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.InvalidInputsExeption;
import com.revature.exceptions.UserNotFoundException;
import com.revature.menus.BankMenu;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.repositories.CustomerDAO;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.ICustomerDAO;
import com.revature.repositories.IEmployeeDAO;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;

public class UserServiceImplementation implements UserService {
	
	IUserDAO userDAO = new UserDAO();	
	ICustomerDAO customerDAO = new CustomerDAO();
	IEmployeeDAO employeeDAO = new EmployeeDAO(); 
	BankMenu bmenu = new BankMenu(null);
	Customer customer = new Customer();
	EmployeeServicesImplementation esiobj = new EmployeeServicesImplementation(); 
	
	User u = new User();
	Customer c = new Customer();
	Employee e = new Employee();
	
	


	public User login(String username, String password, String type) throws UserNotFoundException, InternalErrorException {
		User u = userDAO.findUserByUsername(username);
		Customer c = customerDAO.getCustomerInformation(username, password);
		Employee e = employeeDAO.findEmployeeByUsernameAndPassword(username, password);
		
		
		if(username.equals(u.getUsername()) && password.equals(u.getPassword())) {
			if(type.equals("Customer")){
				if(u.getFirstName().equals(c.getFirstname()) && u.getLastName().equals(c.getLastname())) {
					bmenu.customerDisplay();
					
					
		}}else if(type.equals("Employee")) {
		if(u.getFirstName().equals(e.getFirstName()) && u.getLastName().equals(e.getLastName())) {
					bmenu.employeeDisplay();
					
					
				}}else {
				System.out.println("Invalid Entry");
				bmenu.login();
			}
			System.out.println(u);
			return u;
		}else {
			throw new UserNotFoundException();
		
		}
	}		
			
	public void register(String username, String password, String firstname, String lastname) throws InvalidInputsExeption, InternalErrorException {
		customer.setUsername(username);
		customer.setPassword(password);
		customer.setFirstname(firstname);
		customer.setLastname(lastname);
		customerDAO.newAccount(customer);
	}


}
