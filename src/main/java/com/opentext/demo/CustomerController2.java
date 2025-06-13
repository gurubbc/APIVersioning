package com.opentext.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")	
public class CustomerController2 {
	
	@Autowired
	CustomerService2 cs;

	@RequestMapping(value="/v2/customers", method=RequestMethod.GET)
	public List<Customer2> getAllCustomers() {
		
		return cs.getAllCustomers();
		
	}
	
	// This is the path parameter, we can't read this path parameter from the method 
	// directly
	@RequestMapping(value="/v2/customers/id/{customerId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getCustomerById(@PathVariable("customerId") int custId) {
		System.out.println("The custid received is "+custId);
		Customer2 c=cs.getCustomerById(custId);
		if (c == null) {
			return ResponseEntity.status(404).body("Customer not found for the id "+custId);
			// response with status 404 and the message
		}
		return ResponseEntity.status(200).body(c); // response with status 200 and the customer object
	}
	
	// This is the path parameter, we can't read this path parameter from the method 
		// directly
		@RequestMapping(value="/customers/id/{customerId}", method=RequestMethod.DELETE)
		public ResponseEntity<Object> deleteCustomerById(@PathVariable("customerId") int custId) {
			System.out.println("Delete: The custid received is "+custId);
			return cs.deleteCustomerById(custId);
		}
		
		@RequestMapping(value="/customers", method=RequestMethod.POST)
		public ResponseEntity<String> addCustomer(@RequestBody Customer2 newCustomer) {
			return cs.addACustomer(newCustomer);
		}
}
