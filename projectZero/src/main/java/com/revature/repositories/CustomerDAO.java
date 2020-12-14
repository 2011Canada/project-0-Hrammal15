package com.revature.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.InvalidInputsExeption;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Customer;
import com.revature.util.ConnectionFactory;
public class CustomerDAO implements ICustomerDAO{

	

		
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
		
	public Customer getCustomerInformation(String username, String password) throws UserNotFoundException, InternalErrorException {
		
			

			Connection conn = cf.getConnection();
			try {
				conn.setAutoCommit(false);
				String sql = "select * from users where \"username\" = ? and \"password\" = ?;";
				PreparedStatement getCustomer = conn.prepareStatement(sql);
				getCustomer.setString(1, username);
				getCustomer.setString(2, password);
				conn.setAutoCommit(true);
				ResultSet res = getCustomer.executeQuery();
				
				if(res.next()) {
					Customer cmr = new Customer();
					cmr.setUsername(res.getString("username"));
					cmr.setPassword(res.getString("password"));
					cmr.setFirstname(res.getString("firstname"));
					cmr.setLastname(res.getString("lastname"));
					cmr.setType(res.getString("type"));
					return cmr;
					
					
					
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
	
	public Customer verifyType(String username, String password, String type) throws UserNotFoundException, InternalErrorException {
		
		

		Connection conn = cf.getConnection();
		try {
			conn.setAutoCommit(false);
			String sql = "select * from customers where \"customer_id\" = ? and \"password\" = ?;";
			PreparedStatement getCustomer = conn.prepareStatement(sql);
			getCustomer.setString(1, username);
			getCustomer.setString(2, password);
			conn.setAutoCommit(true);
			ResultSet res = getCustomer.executeQuery();
			
			if(res.next()) {
				Customer cmr = new Customer();
				cmr.setCustomerId(res.getInt("customer_id"));
				cmr.setPassword(res.getString("password"));
				cmr.setFirstname(res.getString("firstname"));
				cmr.setLastname(res.getString("lastname"));
				cmr.setType(res.getString("type"));
				return cmr;
				
				
				
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
	
	
	
		public Customer newAccount(Customer customer) throws InvalidInputsExeption, InternalErrorException {
		
		

		Connection conn = cf.getConnection();
		try {
			conn.setAutoCommit(false);
			String sql = "insert into customers (username, password, firstname, lastname, type) "
					+ "values(?,?,?,?,?);";
			PreparedStatement setCustomer = conn.prepareStatement(sql);
			setCustomer.setString(1, customer.getUsername());
			setCustomer.setString(2, customer.getPassword());
			setCustomer.setString(3, customer.getFirstname());
			setCustomer.setString(4, customer.getLastname());
			setCustomer.setString(5, "customer");
			
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



}
