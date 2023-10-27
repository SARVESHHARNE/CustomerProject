package com.code.custutils;

import java.util.List;
import com.exceptions.InvlidInputExceptions;

import com.code.Customer;

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
}
