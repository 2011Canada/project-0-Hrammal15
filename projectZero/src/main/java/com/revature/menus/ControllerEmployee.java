package com.revature.menus;
import java.util.*;



public class ControllerEmployee {
	
	static Scanner sc = new Scanner(System.in);
	private static int employeeID;
	private static String employeePass;
	private static boolean validateEmployeeStatus = false;
	static HashMap<Integer, String> userMap = new HashMap<Integer, String>();

	void controllerEmployee(){
	userMap.put(22,"Hello");
	userMap.put(23,"bye");

	}
	public static void loginEmployee() {
		System.out.println("To confirm that you are an employee, Please enter the following\n");
		System.out.println("Employee ID and Employee Password (ID, ENTER, then password)\n");
		userMap.put(employeeID = sc.nextInt(), employeePass= sc.next());		
	
		
	}
	
	public static void checkValidation() {
		
		
		for(int val : userMap.keySet()) {
			if(employeeID == val && employeePass.equals(userMap.get(val))){
				validateEmployeeStatus = true;
				System.out.println("Validation Success! \nKey= " + val + " Values= " + userMap.get(val));
			}else {
				System.out.println("Wrong userName and password. Try again");
				loginEmployee();
			}
		}
	
	
}}