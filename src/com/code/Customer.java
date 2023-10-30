package com.code;

import java.time.LocalDate;

import com.code.enums.Plan;

public class Customer implements Comparable<Customer> {

	private static int count;
	private int custId;
	private String fName;
	private String lName;
	private String email;
	private String password;
	private double regAmt;
	private LocalDate dob;
	private LocalDate subDate;
	private Plan servicePlan;

	static {
		count = 0;
	}
	
	{
		custId = 1;
	}

	public Customer(String fName, String lName, String email, String password, double regAmt, LocalDate dob,
			Plan servicePlan,LocalDate subDate) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.regAmt = regAmt;
		this.dob = dob;
		this.servicePlan = servicePlan;
		this.subDate=subDate;
		this.custId += count++;
	}

	public Customer(String email) {
		super();
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", regAmt="
				+ regAmt + ", dob=" + dob + ", servicePlan=" + servicePlan + " SubDate="+subDate+"]";
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Customer) {
			return this.email.equals(((Customer) o).email);
		}
		return false;
	}

	@Override
	public int compareTo(Customer o) {

		return this.email.compareTo(o.email);
	}

	public int getCustId() {
		return custId;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public double getRegAmt() {
		return regAmt;
	}

	public LocalDate getDob() {
		return dob;
	}

	public Plan getServicePlan() {
		return servicePlan;
	}

	public LocalDate getSubDate() {
		return subDate;
	}

	public void setSubDate(LocalDate subDate) {
		this.subDate = subDate;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setServicePlan(Plan servicePlan) {
		this.servicePlan = servicePlan;
	}

}
