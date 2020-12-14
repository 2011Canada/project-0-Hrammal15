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

public class UserDAO implements IUserDAO{

	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	
	
	public User findUserByUsername(String username) throws UserNotFoundException, InternalErrorException{
		
		
		Connection conn = cf.getConnection();
		try {
			String sql = "select * from users where \"username\" = ?;";
			PreparedStatement getUser = conn.prepareStatement(sql);
			getUser.setString(1, username);
			
			ResultSet res = getUser.executeQuery();
			if(res.next()) {
				User u = new User();
				u.setUserId(res.getInt("user_id"));
				u.setUsername(res.getString("username"));
				u.setPassword(res.getString("password"));
				u.setFirstName(res.getString("firstname"));
				u.setLastName(res.getString("lastname"));
				u.setStatus(res.getString("status"));
				u.setBalance(res.getDouble("balance"));
				u.setType(res.getString("type"));
				
				getUser.executeQuery();


				return u;
			
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

	public java.util.List<User> findAll() {
		//TODO
		return null;
	}
	
public User changeType(User u) throws BalanceBelowZeroException, InternalErrorException {
		

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
		return u;		
			}
	
public User setBalance(User u , Double balance ) throws BalanceBelowZeroException, InternalErrorException {
		

		Connection conn = cf.getConnection();
		try {
			conn.setAutoCommit(false);
			String sql = "update users "
					+ "set balance = ? "
					+ "Where username = ? And password = ?";
			System.out.println(balance);
			
			PreparedStatement updateAccount = conn.prepareStatement(sql);
			updateAccount.setDouble(1, u.getBalance());
			updateAccount.setString(2, u.getUsername());
			updateAccount.setString(3, u.getPassword());
			
			updateAccount.executeUpdate();
			conn.commit();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			throw new InternalErrorException();
			
			
		}finally {

			cf.releaseConnection(conn);
		
		}

		return u;		
			}	


public User newAccount(User u) throws InvalidInputsExeption, InternalErrorException {
	
	

	Connection conn = cf.getConnection();
	try {
		conn.setAutoCommit(false);
		String sql = "insert into users (username, password, firstname, lastname, type,status,balance) "
				+ "values(?,?,?,?,?,?,?);";
		PreparedStatement setCustomer = conn.prepareStatement(sql);
		setCustomer.setString(1, u.getUsername());
		setCustomer.setString(2, u.getPassword());
		setCustomer.setString(3, u.getFirstName());
		setCustomer.setString(4, u.getLastName());
		setCustomer.setString(5, "customer");
		setCustomer.setString(6, "PENDING");
		setCustomer.setDouble(7, 0);

		int res = setCustomer.executeUpdate();
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
public User getType(String username) throws UserNotFoundException, InternalErrorException{
	
	
	Connection conn = cf.getConnection();
	try {
		String sql = "select type from users where \"username\" = ?;";
		PreparedStatement getUser = conn.prepareStatement(sql);
		getUser.setString(1, username);
		
		
		ResultSet res = getUser.executeQuery();
		if(res.next()) {
			User u = new User();
		
			u.setUserId(res.getInt("user_id"));
			u.setUsername(res.getString("username"));
			u.setPassword(res.getString("password"));
			u.setFirstName(res.getString("firstname"));
			u.setLastName(res.getString("lastname"));
			u.setStatus(res.getString("status"));
			u.setType(res.getString("type"));

			return u;
		
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




	
	
	
}
