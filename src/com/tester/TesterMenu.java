package com.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static com.code.validations.ValidationRules.*;

import com.code.Customer;
import static com.code.custutils.CustUtil.*;

public class TesterMenu {
	public static void main(String [] args) {
		try(Scanner sc=new Scanner(System.in)){
			List<Customer> list = new ArrayList<>();
			boolean exit=false;
			while(exit!=true) {
				System.out.println("Typical  Options\r\n"
						+ "1. Sign up (customer registration)\r\n"
						+ "2. Sign in (login)\r\n"
						+ "i/p : email n password\r\n"
						+ "3. Change password\r\n"
						+ "i/p : email n old password n new password\r\n"
						+ "4. Un subscribe customer\r\n"
						+ "i/p : customer email\r\n"
						+ "5. Display all customers.\r\n"
						+ "and many more.....\r\n"
						+ "0. Exit ");
				
				try {
					switch(sc.nextInt()) {
					case 1:
						System.out.println("fName, lName, email, password,regAmt,dob(yyyy-MM-dd),servicePlan(SILVER|GOLD|DIAMOND|PLATINUM)");
						list.add(checkInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),sc.next(),sc.next(),list));
						break;
					case 2:
						System.out.println("Enter EmailId & password");
						getCust(sc.next(), sc.next(), list);
						System.out.println("***** Login succesfull *****");
						break;
					case 3:
						System.out.println("Enter EmailId & oldPassword ");
						Customer c=getCust(sc.next(), sc.next(), list);
						System.out.println("enter newPassword");
						c.setPassword(sc.next());
						break;
					case 4:
						System.out.println("Enter email");
						if(list.remove(new Customer(sc.next()))) {
							System.out.println("Un-Subscribed");
						}
						else {
							System.out.println("Inavalid email");
						}
						break;
					case 5:
						for(Customer s:list) {
							System.out.println(s);
						}
						break;
					case 0:
						exit=true;
						break;
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("\n----------------------------");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
