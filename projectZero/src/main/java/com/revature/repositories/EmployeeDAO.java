package com.revature.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;

public class EmployeeDAO implements IEmployeeDAO {
	
private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
public Employee findEmployeeByUsernameAndPassword(String username, String password) throws UserNotFoundException, InternalErrorException {
	
		

		Connection conn = cf.getConnection();
		try {
			conn.setAutoCommit(false);
			String sql = "select * from employees where \"username\" = ? and \"password\" = ?;";
			PreparedStatement getEmployee = conn.prepareStatement(sql);
			getEmployee.setString(1, username);
			getEmployee.setString(2, password);
			conn.setAutoCommit(true);
			ResultSet res = getEmployee.executeQuery();
			
			if(res.next()) {
				Employee emp = new Employee();
				emp.setUsername(res.getString("username"));
				emp.setPassword(res.getString("password"));
				emp.setFirstName(res.getString("firstname"));
				emp.setLastName(res.getString("lastname"));
				emp.setType(res.getString("type"));

				return emp;
				
				
				
			}else {
				throw new UserNotFoundException();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException();
			
		}finally {
			cf.releaseConnection(conn);
		
		}		}

		public Employee verifyType(String username, String password, String type) throws UserNotFoundException, InternalErrorException {
				
			Connection conn = cf.getConnection();
			try {
				conn.setAutoCommit(false);
				String sql = "select * from employees where \"employee_id\" = ? and \"password\" = ?;";
				PreparedStatement getEmployee = conn.prepareStatement(sql);
				getEmployee.setString(1, username);
				getEmployee.setString(2, password);
				getEmployee.setString(3, type);
				conn.setAutoCommit(true);
				ResultSet res = getEmployee.executeQuery();
				
				if(res.next()) {
					Employee emp = new Employee();
					emp.setEmployeeId(res.getInt("employee_id"));
					emp.setPassword(res.getString("password"));
					emp.setFirstName(res.getString("firstname"));
					emp.setLastName(res.getString("lastname"));
					emp.setType(res.getString("type"));

					return emp;
					
					
					
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
