package com.code.adminutils;
import static java.time.Period.*;


import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.code.Customer;

public class AdminUtil {
	public static void planExpiry(Map<String,Customer> list) {
		for(Customer c:list.values()) {
			Period p=between(c.getSubDate(),LocalDate.now());
			if(p.getMonths()>=3 || p.getYears()>=1)
				System.out.println("Name : "+c.getfName()+" "+c.getlName());
		}
	}
	
	public static void removeOldCus(Map<String,Customer> list) {
		Iterator <Customer> l=list.values().iterator();
		while(l.hasNext()) {
			Customer c=l.next();
			System.out.println(c);
			Period p=between(c.getSubDate(),LocalDate.now());
			if(p.getMonths()>=6 || p.getYears()>=1)
			{
				l.remove();
			}
			
		}
	}
}
