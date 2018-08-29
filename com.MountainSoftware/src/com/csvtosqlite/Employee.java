package com.csvtosqlite;

// Employee class
public class Employee {

	private int employeeId;
	private String firstname;
	private String lastname;
	private String address;
	private int age;
	private int salary;
	private String phone;
	private String country;

	public Employee(int employeeId,String firstname,String lastname,
	 String address,int age,int salary,String phone,
	 String country) {

		super();
		this.employeeId= employeeId;
		this.firstname=firstname;
		this.lastname=lastname;
		this.address=address;
		this.age=age;
		this.salary=salary;
		this.phone=phone;
		this.country=country;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}



}
