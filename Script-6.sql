create table employees(
	"employee_id" serial primary key,
	"username" text not null,
	"password" text not null,
	"firstname" text not null,
	"lastname"  text not null,
	"type" text not null
);

create table customers(
	"customer_id" serial primary key,
	"username" text not null,
	"firstname" text not null,
	"lastname"  text not null,
	"password" text not null,
	"type" text not null
);

create table customerswithaccount(
	"username" text unique not null,
	"firstname" text not null,
	"lastname"  text not null,
	"password" text not null,
	"status" text not null,
	"balance" numeric not null,
	"type" text not null
);


drop table users;

create table users (
	"user_id" serial primary key,
	"username" text  not null,
	"firstname" text not null,
	"lastname"  text not null,
	"password" text not null,
	"status" text not null,
	"balance" numeric not null,
	"type" text not null
);


	 		 
insert into users("username","firstname", "lastname", "password", "status", "balance", "type")
	values('hrammal15','Hassen','Rammal', 'password', 'ACTIVE' ,0,'employee'),
		  ('employee1','FNEmployee1','LNEmployee1', 'password', 'ACTIVE' ,0,'employee'),
		  ('employee2','FNEmployee2','LNEmployee2', 'password', 'ACTIVE' ,00,'employee'),
		  ('jmaster15','John','McMaster', 'password', 'ACTIVE' ,1231.22,'customerA'),
		  ('customerA1','FNCustomerA1','LNCustomerA1', 'password', 'ACTIVE' ,1000.00,'customerA'),
		  ('customerA2','FNCustomerA2','LNCustomerA2', 'password', 'ACTIVE' ,2000.00,'customerA'),
		  ('nmessina15','Nick','Messina', 'password', 'ACTIVE' ,0,'user'),
		  ('user1','FNUser1','LNUser1', 'password', 'ACTIVE' ,0,'user'),
		  ('user2','FNUser2','LNUser2', 'password', 'ACTIVE' ,0,'user'),
		  ('dlucas15','Derek','Lucas', 'password', 'ACTIVE' ,0,'customer'),
		  ('customer1','FNCustomer1','LNCustomer1', 'password', 'ACTIVE' ,0,'customer'),
		  ('customer2','FNCustomer2','LNCustomer2', 'password', 'ACTIVE' ,0,'customer'),
		  ('transfer','null','null', 'null', 'ACTIVE' ,0,'null');



select * from employees;
select * from customers;
select * from users;
select * from customerswithaccount;

select type from users where username ='Jonnn15';

