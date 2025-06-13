package com.opentext.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService1 {
	
	ArrayList<Customer1> allCustomers;
	
	public CustomerService1() {
		System.out.println("CustomerService constructor: CustomerService object created");
		Customer1 c1=new Customer1(1,"Rohit","Singh",9876543210L,"rohit@gmail.com");
		Customer1 c2=new Customer1(2,"Pradeep","Repaka",567890L,"pradeep@gmail.com");
		Customer1 c3=new Customer1(3,"Sathya","Lakhsmi",6789067L,"sl@gmail.com");
		Customer1 c4=new Customer1(4,"Megha","Shivaprasad",78905678L,"megha@gmail.com");
		Customer1 c5=new Customer1(5,"Guru","Murthy",9731801675L,"guru@gmail.com");
		Customer1 c6=new Customer1(6,"Sachin","Tendulkar",67890L,"saching@yahoo.com");
		allCustomers=new ArrayList<Customer1>(Arrays.asList(c1,c2,c3,c4,c5,c6));
		
	}
	
	public List<Customer1> getAllCustomers() {
		
		return allCustomers;
	}
	
	
	public Customer1 getCustomerById(int custId) {
        System.out.println("CustomerService: getCustomerById: custId: "+custId);
		for (Customer1 c:allCustomers) {
			if (c.getCustomerId() == custId) {
				return c;
			}
		}
		return null; // no matching customer id found
	}
	
	
	public ResponseEntity<Object> deleteCustomerById(int custId) {
        System.out.println("CustomerService Delete: getCustomerById: custId: "+custId);
        int indx=-1;
		for (int i=0;i<allCustomers.size();i++) {
			if (allCustomers.get(i).getCustomerId() == custId) {
				indx = i;
				break;
			}
		}
		
		if (indx != -1) {
			allCustomers.remove(indx);
			return ResponseEntity.ok("Successfully deleted the customer with id "+custId);
		}
        
		return ResponseEntity.status(404).body("Customer not found for the id "+custId);
		
	}
	
	public ResponseEntity<String> addACustomer(Customer1 cust) {
		allCustomers.add(cust);
        return ResponseEntity.ok("Successfully added the customer with id "+cust.getCustomerId());
	}
}
