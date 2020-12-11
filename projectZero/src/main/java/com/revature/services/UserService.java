package com.revature.services;

public interface UserService {

	public void login(String username, String password);
	public void register(String username, String password, String email);

}
