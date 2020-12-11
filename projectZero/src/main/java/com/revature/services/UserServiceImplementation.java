package com.revature.services;

public class UserServiceImplementation implements UserService {

	public void login(String username, String password) {
		System.out.println("username =" + username + "password = " + password);
	}

	public void register(String username, String password, String email) {
		System.out.println("username =" + username + " password = " + password + "email = " + email);

	}

}
