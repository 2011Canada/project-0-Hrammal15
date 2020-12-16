package com.revature.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.launcher.ProjectZeroLauncher;
import com.revature.models.User;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.UserDAO;

public class EmployeeServicesImplementation implements EmployeeServices{
	Scanner sc = new Scanner(System.in);
	IUserDAO userDAO = new UserDAO();
	public static Logger project0loggerTransactions = LogManager.getLogger("com.revature.project0HassenELTransactions");
	
	public void employeeDisplay() {
		System.out.println("======================");

		System.out.println("Please press\n" + "1 - View Pending Accounts\n" + "2 - View Customer Account\n"
				+ "3 - View All Transactions\n");
		System.out.println("======================");

		int input = sc.nextInt();

		if (input == 1) {
			acceptOrReject();
		} else if (input == 2) {
			viewBankAccount();
		} else if (input == 3) {
			readTransactions();
		} else if(input == 4){
			
		}else {
			System.out.println("invalid input");
		}
	}



	public User acceptOrReject() {
		String username,password;
		User u2 = null;
		User u = null;

		System.out.println("For security reasons, please sign in again as an employee" );
		System.out.println("Username");
		username = sc.next();
		System.out.println("Password");
		password = sc.next();
	
		try {
			u = userDAO.findUserByUsernameAndPassword(username,password);
		} catch (UserNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			acceptOrReject();
		} catch (InternalErrorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		System.out.println("Enter the username to view the account you would like to accept/reject");
		username = sc.next();
		try {
			u2 = userDAO.findUserByUsername(username);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			acceptOrReject();
		} catch (InternalErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println( u2 + "\n" + u);
		
		System.out.println("Please type\nACCEPT -> to accept the account\nREJECT to reject the account");
		String decision = sc.next();
		
		
		if(decision.equals("ACCEPT")) {
		ProjectZeroLauncher.project0logger.debug(u.getUsername() + " Made  " + u2.getUsername() + " ACTIVE" );
		project0loggerTransactions.debug(u.getUsername() + " Made  " + u2.getUsername() + " ACTIVE" );


			u2.setStatus("ACTIVE");
			try {
				userDAO.changeStatusActive(u2);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				acceptOrReject();
			} catch (InternalErrorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(decision.equals("REJECT")){
			u2.setStatus("DENIED");
			ProjectZeroLauncher.project0logger.debug(u.getUsername() + " DENIED account " + u2.getUsername());
			project0loggerTransactions.debug(u.getUsername() + " DENIED account " + u2.getUsername());


			try {
				userDAO.changeStatusDenied(u2);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InternalErrorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else {
			System.out.println("Invalid entry");
		}


		return null;
	}
	
	public void viewBankAccount() {
		
		System.out.println("Enter the username to view the account you would like view");
		String username = sc.next();
		
		User u = null;
		try {
			u = userDAO.findUserByUsername(username);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InternalErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProjectZeroLauncher.project0logger.debug(u.getUsername() + "Account was just viewed from the database" );
		project0loggerTransactions.debug(u.getUsername() + "Account was just viewed from the database" );

		System.out.println(u);
	}
	
	public void readTransactions() {
		
		{  
			try  
			{  
			File file=new File("transactions.log");    //creates a new file instance  
			FileReader fr=new FileReader(file);   //reads the file  
			BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
			StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
			String line;  
			while((line=br.readLine())!=null)  
			{  
			sb.append(line);      //appends line to string buffer  
			sb.append("\n");     //line feed   
			}  
			fr.close();    //closes the stream and release the resources  
			System.out.println("Contents of File: ");  
			System.out.println(sb.toString());   //returns a string that textually represents the object  
			}  
			catch(IOException e)  
			{  
			e.printStackTrace();  
			}  
			}  
			}  
	

}
