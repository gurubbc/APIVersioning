package com.opentext.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService2 {
	
	ArrayList<Customer2> allCustomers;
	
	public CustomerService2() {
		System.out.println("CustomerService constructor: CustomerService object created");
		Customer2 c1=new Customer2(1,"Rohit","Singh",9876543210L,"rohit@gmail.com","India");
		Customer2 c2=new Customer2(2,"Pradeep","Repaka",567890L,"pradeep@gmail.com","Dubai");
		Customer2 c3=new Customer2(3,"Sathya","Lakhsmi",6789067L,"sl@gmail.com","USA");
		Customer2 c4=new Customer2(4,"Megha","Shivaprasad",78905678L,"megha@gmail.com","India");
		Customer2 c5=new Customer2(5,"Guru","Murthy",9731801675L,"guru@gmail.com","Dubai");
		Customer2 c6=new Customer2(6,"Sachin","Tendulkar",67890L,"saching@yahoo.com","USA");
		allCustomers=new ArrayList<Customer2>(Arrays.asList(c1,c2,c3,c4,c5,c6));
		
	}
	
	public List<Customer2> getAllCustomers() {
		
		return allCustomers;
	}
	
	
	public Customer2 getCustomerById(int custId) {
        System.out.println("CustomerService: getCustomerById: custId: "+custId);
		for (Customer2 c:allCustomers) {
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
	
	public ResponseEntity<String> addACustomer(Customer2 cust) {
		allCustomers.add(cust);
        return ResponseEntity.ok("Successfully added the customer with id "+cust.getCustomerId());
	}
}
