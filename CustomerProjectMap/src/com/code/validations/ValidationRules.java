package com.code.validations;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.code.Customer;
import com.code.enums.Plan;
import com.exceptions.InvlidInputExceptions;

public class ValidationRules {
	public static Plan parseAndValidatePlan(String plan) throws IllegalArgumentException, NullPointerException {
		return Plan.valueOf(plan.toUpperCase());
	}

	public static double validateAmt(Plan p, double amt) throws InvlidInputExceptions {
		if (p.getPrice() != amt) {
			throw new InvlidInputExceptions("amount is not as per plan!!!");
		}
		return amt;
	}

	public static void validateEmail(String email) throws InvlidInputExceptions {
		String regex = "[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		if (!email.matches(regex))
			throw new InvlidInputExceptions("invalid Email formate");
	}

	public static void validatePassword(String password) throws InvlidInputExceptions {
		String regex = "(?=.*[0-9])(?=.*[A-Z])(?=.*[#@$*%&]).{6,20}";
		if (!password.matches(regex))
			throw new InvlidInputExceptions(
					"!!!!password must contain (6-20 letter ) containing number,Capital letter,SpecialChar(#@$*%&),");
	}

	public static void checkDuplicate(String email, Map<String,Customer> list) throws InvlidInputExceptions {
		validateEmail(email);
		if (list.containsKey(new Customer(email))) {
			throw new InvlidInputExceptions("Account with email already exists");
		}
	}

	public static Customer checkInputs(String fName, String lName, String email, String password, double regAmt,
			String dob, String servicePlan, String subDate, Map<String,Customer> list)
			throws InvlidInputExceptions, IllegalArgumentException, NullPointerException {
		checkDuplicate(email, list);
		validatePassword(password);
		Plan p = parseAndValidatePlan(servicePlan);
		double amt = validateAmt(p, regAmt);
		Customer c = new Customer(fName, lName, email, password, amt, LocalDate.parse(dob), p,
				LocalDate.parse(subDate));
		return c;
	}

}
