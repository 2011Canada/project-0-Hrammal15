package com.revature.models;

public class User {
	
		String firstName;
		String usetName;
		String email;
		
		
		public User(String firstName, String lastName, String email){
			this.firstName = firstName;
			this.usetName = lastName;
			this.email = email;			
		}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getUsetName() {
			return usetName;
		}


		public void setUsetName(String usetName) {
			this.usetName = usetName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}
		
		

}
