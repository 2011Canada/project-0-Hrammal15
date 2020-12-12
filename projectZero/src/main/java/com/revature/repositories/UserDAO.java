package com.revature.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDAO implements IUserDAO{

	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	
	
	public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException, InternalErrorException{
		
		
		Connection conn = cf.getConnection();
		try {
			
			String sql = "select * from users where \"username\" = ? and \"password\" = ?;";
			PreparedStatement getUser = conn.prepareStatement(sql);
			getUser.setString(1, username);
			getUser.setString(2, password);
			
			ResultSet res = getUser.executeQuery();
			
			if(res.next()) {
				User u = new User();
				u.setUserId(res.getInt("user_id"));
				u.setUsername(res.getString("username"));
				u.setPassword(res.getString("password"));
				u.setFirstName(res.getString("firstname"));
				u.setLastName(res.getString("lastname"));
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
	
	
	
}
