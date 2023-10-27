package com.code.validations;

import java.time.LocalDate;
import java.util.List;

import com.code.Customer;
import com.code.enums.Plan;
import com.exceptions.InvlidInputExceptions;

public class ValidationRules {
	public static Plan parseAndValidatePlan(String plan)throws IllegalArgumentException,NullPointerException {
		return Plan.valueOf(plan.toUpperCase());
	}
	
	public static double validateAmt(Plan p,double amt)throws InvlidInputExceptions
	{
		if(p.getPrice()!=amt) {
			throw new InvlidInputExceptions("amount is not as per plan!!!");
		}
		return amt;
	}
	
	public static void checkDuplicate(String email,List<Customer> list) throws InvlidInputExceptions {
		if(list.contains(new Customer(email))) {
			throw new InvlidInputExceptions("Account with email already exists");
		}
	}
	
	public static Customer checkInputs(String fName, String lName, String email, String password, double regAmt, String dob,
			String servicePlan,List<Customer> list)
					throws InvlidInputExceptions,IllegalArgumentException,NullPointerException
	{
		checkDuplicate(email, list);
		Plan p=parseAndValidatePlan(servicePlan);
		double amt=validateAmt(p,regAmt);
		Customer c=new Customer(fName, lName, email, password,regAmt,LocalDate.parse(dob), p);
		return c;
	}

}
	

