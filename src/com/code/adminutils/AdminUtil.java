package com.code.adminutils;
import static java.time.Period.*;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.ListIterator;


import com.code.Customer;

public class AdminUtil {
	public static void planExpiry(List<Customer> list) {
		for(Customer c:list) {
			Period p=between(c.getSubDate(),LocalDate.now());
			if(p.getMonths()>=6 || p.getYears()>=1)
				System.out.println("Name : "+c.getfName()+" "+c.getlName());
		}
	}
	
	public static void removeOldCus(List<Customer> list) {
		ListIterator <Customer> l=list.listIterator();
		while(l.hasNext()) {
			Customer c=l.next();
			Period p=between(c.getSubDate(),LocalDate.now());
			if(p.getMonths()>=6 || p.getYears()>=1)
				l.remove();
		}
	}
}
