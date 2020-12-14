package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.exceptions.BalanceBelowZeroException;
import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.InvalidInputsExeption;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class AccountDAO implements IAccountDAO {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
public Account newAccount(Customer customer) throws InvalidInputsExeption, InternalErrorException {
		
		

		Connection conn = cf.getConnection();
		try {
			conn.setAutoCommit(false);
			String sql = "insert into customerswithaccount (username, password, firstname, lastname, balance, type, status) "
					+ "values(?,?,?,?,?,?,?);";
			PreparedStatement setCustomerA = conn.prepareStatement(sql);
			setCustomerA.setString(1, customer.getUsername());
			setCustomerA.setString(2, customer.getPassword());
			setCustomerA.setString(3, customer.getFirstname());
			setCustomerA.setString(4, customer.getLastname());
			setCustomerA.setDouble(5, customer.getBalance());
			setCustomerA.setString(6, "CustomerA");
			setCustomerA.setString(7, "PENDING");
			
			int res = setCustomerA.executeUpdate();
			conn.commit();
			System.out.println(res);
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException();
			
		}finally {
			cf.releaseConnection(conn);
		
		}
		return null;		
			}


public Account getAccountInformation(String username, String password) throws UserNotFoundException, InternalErrorException {
	
	

	Connection conn = cf.getConnection();
	try {
		conn.setAutoCommit(false);
		String sql = "select * from customerswithaccount where \"username\" = ? and \"password\" = ?;";
		PreparedStatement getAccount = conn.prepareStatement(sql);
		getAccount.setString(1, username);
		getAccount.setString(2, password);
		conn.setAutoCommit(true);
		ResultSet res = getAccount.executeQuery();
		
		if(res.next()) {
			Account amr = new Account();
			amr.setUsername(res.getString("username"));
			amr.setStatus(res.getString("status"));
			amr.setPassword(res.getString("password"));
			amr.setFirstname(res.getString("firstname"));
			amr.setLastname(res.getString("lastname"));
			amr.setBalance(res.getDouble("balance"));
			amr.setType(res.getString("type"));
			return amr;
			
			
			
		}else {
			throw new UserNotFoundException();
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
		throw new InternalErrorException();
		
	}finally {
		cf.releaseConnection(conn);
	
	}		
		}

public Account setBalance(Account a , double balance ) throws BalanceBelowZeroException, InternalErrorException {
	

	Connection conn = cf.getConnection();
	try {
		conn.setAutoCommit(false);
		String sql = "update customerswithaccount "
				+ "set balance = ? "
				+ "Where username = ? And password = ?";

		
		PreparedStatement updateAccount = conn.prepareStatement(sql);
		updateAccount.setDouble(1, a.getBalance());
		updateAccount.setString(2, a.getUsername());
		updateAccount.setString(3, a.getPassword());
		
		updateAccount.executeUpdate();
	
		
	}catch(SQLException e) {
		
		e.printStackTrace();
		throw new InternalErrorException();
		
		
	}finally {
		try {
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		cf.releaseConnection(conn);
	
	}
	return a;		
		}	

public Customer changeType(User u) throws BalanceBelowZeroException, InternalErrorException {
	

	Connection conn = cf.getConnection();
	try {
		conn.setAutoCommit(false);
		String sql = "update users "
				+ "set type = ? "
				+ "Where username = ? And password = ?";

		
		PreparedStatement updateAccount = conn.prepareStatement(sql);
		updateAccount.setString(1, u.getType());
		updateAccount.setString(2, u.getUsername());
		updateAccount.setString(3, u.getPassword());
		
		updateAccount.executeUpdate();
	
		
	}catch(SQLException e) {
		
		e.printStackTrace();
		throw new InternalErrorException();
		
		
	}finally {
		try {
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		cf.releaseConnection(conn);
	
	}
	return c;		
		}


}
