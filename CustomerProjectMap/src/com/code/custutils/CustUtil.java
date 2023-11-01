package com.code.custutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.exceptions.InvlidInputExceptions;
import java.time.LocalDate;

import static com.code.custutils.CustUtil.getCust;
import static com.code.validations.ValidationRules.*;

import com.code.Customer;
import com.code.enums.Plan;

public class CustUtil {

	public static Customer getCust(String email, String password,Map<String,Customer>  list) throws InvlidInputExceptions {
		
		if (!list.containsKey(email)) {
			throw new InvlidInputExceptions("invalid Email");
		}
		Customer c = list.get(email);
		if (!c.getPassword().equals(password)) {
			throw new InvlidInputExceptions("Wrong password");
		}
		return c;
	}
	
	public static void updateSubscription(String email, String password,Map<String,Customer> list,Scanner sc) throws InvlidInputExceptions {
		Customer c =getCust(email, password, list);
		System.out.println("Select plan : SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000)");
		Plan p=Plan.valueOf(sc.next().toUpperCase());
		c.setServicePlan(p);
		System.out.println("Enter amount :");
		validateAmt(p,sc.nextDouble());
		c.setSubDate(LocalDate.now());
		System.out.println(" *** updated *** ");
	}
	
	//"fName, lName, email, password,regAmt,dob(yyyy-MM-dd),servicePlan(SILVER|GOLD|DIAMOND|PLATINUM)"
	public static Map<String,Customer> sampleData(){
		Map<String,Customer> list= new HashMap<>();
		list.put("sarvesh@gmail.com",new Customer("Sarvesh", "Harne", "sarvesh@gmail.com", "password", 1000, LocalDate.parse("2000-09-12"), Plan.SILVER,LocalDate.parse("2023-09-12")));
		list.put("ram@gmail.com",new Customer("ram", "mehta", "ram@gmail.com", "password", 2000, LocalDate.parse("2001-02-01"), Plan.GOLD,LocalDate.parse("2023-07-12")));
		list.put("sham@gmail.com",new Customer("sham", "rathi", "sham@gmail.com", "password", 5000, LocalDate.parse("1997-02-01"), Plan.DIAMOND,LocalDate.parse("2023-08-25")));
		list.put("ritu@gmail.com",new Customer("ritu", "bajpai", "ritu@gmail.com", "password", 2000, LocalDate.parse("1998-05-08"), Plan.GOLD,LocalDate.parse("2023-01-12")));
		list.put("yashika@gmail.com",new Customer("yashika", "mishra", "yashika@gmail.com", "password", 10000, LocalDate.parse("2000-12-12"), Plan.PLATINUM,LocalDate.parse("2023-10-01")));
		list.put("nikhil@gmail.com",new Customer("nikhil", "rathod", "nikhil@gmail.com", "password", 1000, LocalDate.parse("2001-02-01"), Plan.SILVER,LocalDate.parse("2022-09-12")));
		list.put("jay@gmail.com",new Customer("jay", "joshi", "jay@gmail.com", "password", 5000, LocalDate.parse("2003-06-15"), Plan.DIAMOND,LocalDate.parse("2023-09-18")));
		
		return list;
	}
}
