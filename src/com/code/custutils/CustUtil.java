package com.code.custutils;

import java.util.ArrayList;
import java.util.List;
import com.exceptions.InvlidInputExceptions;
import java.time.LocalDate;
import static com.code.validations.ValidationRules.checkInputs;

import com.code.Customer;
import com.code.enums.Plan;

public class CustUtil {

	public static Customer getCust(String email, String password, List<Customer> list) throws InvlidInputExceptions {
		int index = list.indexOf(new Customer(email));
		if (index < 0) {
			throw new InvlidInputExceptions("invalid Email");
		}
		Customer c = list.get(index);
		if (!c.getPassword().equals(password)) {
			throw new InvlidInputExceptions("Wrong password");
		}
		return c;
	}
	
	//"fName, lName, email, password,regAmt,dob(yyyy-MM-dd),servicePlan(SILVER|GOLD|DIAMOND|PLATINUM)"
	public static List<Customer> sampleData(){
		List<Customer> list= new ArrayList<>();
		list.add(new Customer("Sarvesh", "Harne", "sarvesh@gmail.com", "password", 1000, LocalDate.parse("2000-09-12"), Plan.SILVER,LocalDate.parse("2023-09-12")));
		list.add(new Customer("ram", "mehta", "ram@gmail.com", "password", 2000, LocalDate.parse("2001-02-01"), Plan.GOLD,LocalDate.parse("2023-07-12")));
		list.add(new Customer("sham", "rathi", "sham@gmail.com", "password", 5000, LocalDate.parse("1997-02-01"), Plan.DIAMOND,LocalDate.parse("2023-08-25")));
		list.add(new Customer("ritu", "bajpai", "ritu@gmail.com", "password", 2000, LocalDate.parse("1998-05-08"), Plan.GOLD,LocalDate.parse("2023-01-12")));
		list.add(new Customer("yashika", "mishra", "yashika@gmail.com", "password", 10000, LocalDate.parse("2000-12-12"), Plan.PLATINUM,LocalDate.parse("2023-10-01")));
		list.add(new Customer("nikhil", "rathod", "nikhil@gmail.com", "password", 1000, LocalDate.parse("2001-02-01"), Plan.SILVER,LocalDate.parse("2022-09-12")));
		list.add(new Customer("jay", "joshi", "jay@gmail.com", "password", 5000, LocalDate.parse("2003-06-15"), Plan.DIAMOND,LocalDate.parse("2023-09-18")));
		
		return list;
	}
}
