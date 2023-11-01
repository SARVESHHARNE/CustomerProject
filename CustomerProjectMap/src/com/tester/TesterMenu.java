package com.tester;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import static com.code.validations.ValidationRules.*;
import static com.code.adminutils.AdminUtil.*;

import com.code.Customer;
import static com.code.custutils.CustUtil.*;

public class TesterMenu {
	public static void main(String [] args) {
		
		try(Scanner sc=new Scanner(System.in)){
			Map<String,Customer> list = sampleData();
			boolean exit=false;
			while(exit!=true) {
				System.out.println("Options\r\n"
						+ "1. Sign up \r\n"
						+ "2. Sign in\r\n"
						+ "3. Change password\r\n"
						+ "4. Un subscribe customer\r\n"
						+ "5. Display all customers.\r\n"
						+ "6. Sort by Email \r\n"
						+ "7. Sort by date of birth\r\n"
						+ "8. Sort by dob And lname\r\n"
						+ "9. list of not paid for 3 months\r\n"
						+ "10.remove 6 month old\r\n"
						+ "11.Update Subscription\r\n"
						+ "0. Exit ");
				
				try {
					switch(sc.nextInt()) {
					case 1:
						System.out.println("fName, lName, email, password,regAmt,dob(yyyy-MM-dd),servicePlan(SILVER|GOLD|DIAMOND|PLATINUM),subDate");
						Customer c=checkInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),sc.next(),sc.next(),sc.next(),list);
						list.put(c.getEmail(),c);
						break;
					case 2:
						System.out.println("Enter EmailId & password");
						getCust(sc.next(), sc.next(), list);
						System.out.println("***** Login succesfull *****");
						break;
					case 3:
						System.out.println("Enter EmailId & oldPassword ");
						 c=getCust(sc.next(), sc.next(), list);
						System.out.println("enter newPassword");
						String pass=sc.next();
						validatePassword(pass);
						c.setPassword(pass);
						break;
					case 4:
						System.out.println("Enter email");
						String em=sc.next();
						if(list.containsKey(em)) {
							System.out.println("Un-Subscribed");
						}
						else {
							System.out.println("Inavalid email");
						}
						break;
					case 5:
						for(Customer s:list.values()) {
							System.out.println(s);
						}
						break;
					case 6:
						TreeMap<String,Customer> tr=new TreeMap<String, Customer>(list);
						for(Customer s:tr.values()) {
							System.out.println(s);
						}
						
						break;
					case 7:
						List<Customer> tmp=new ArrayList<Customer>(list.values());
						Collections.sort(tmp,new Comparator<Customer>() {

							@Override
							public int compare(Customer o1, Customer o2) {
								return o1.getDob().compareTo(o2.getDob());
							}
						});
						
						for(Customer s:tmp) {
							System.out.println(s);
						}
						
						break;
					case 8:
						tmp=new ArrayList<Customer>(list.values());
						Collections.sort(tmp,new Comparator<Customer>() {

						@Override
						public int compare(Customer o1, Customer o2) {
							int itr=o1.getDob().compareTo(o2.getDob());
							if(itr==0) {
								return o1.getlName().compareTo(o2.getlName());
							}
							return itr;
						}
					});
						for(Customer s:tmp) {
							System.out.println(s);
						}
						break;
					case 9:
						planExpiry(list);
						break;
					case 10:
						removeOldCus(list);
						break;
					case 11:
						System.out.println("Enter Email & Password");
						updateSubscription(sc.next(), sc.next(), list, sc);
						break;
					case 0:
						exit=true;
						break;
					}
					
				}catch(Exception e) {
					if(e instanceof InputMismatchException) {
						sc.nextLine();
						System.out.println("Enter inputs Correctly");
					}
					e.printStackTrace();
				}
				System.out.println("\n----------------------------");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
