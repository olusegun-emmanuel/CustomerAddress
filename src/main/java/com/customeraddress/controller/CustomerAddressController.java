package com.customeraddress.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.customeraddress.beans.CustomerAddrList;
import com.customeraddress.beans.Customeraddr;
import com.customeraddress.repository.CustomerAddressRepository;


@RestController
@RequestMapping("/custaddr")
public class CustomerAddressController {

	@Autowired
	private CustomerAddressRepository customerAddressRepository;
	List<Customeraddr> addrlist;
	CustomerAddrList customerAddrList;
	
	@RequestMapping("/address")
	//This method gets the customer address from back end
	public CustomerAddrList getCustomerAddress(){
		addrlist = customerAddressRepository.findAll();
		customerAddrList = new CustomerAddrList();
		customerAddrList.setCustomeraddr(addrlist);
		return customerAddrList;
	}
	
	@RequestMapping("/address/{id}")
	//This method gets the customer address based on the id
	public Optional<Customeraddr> getAddressId(@PathVariable("id") int id)	{
		Optional<Customeraddr> cusadd = customerAddressRepository.findById(id);
		return cusadd;
	}
	
	@PostMapping("/address")
	//This method adds the customer address
	public String addAddress(@RequestBody Customeraddr customerAddress){
		customerAddressRepository.save(customerAddress);
		return "Created successfully";
	}
	

	@DeleteMapping("/address/{id}")
	//This method deletes the customer address
	public String deleteCustomerAddres(@PathVariable("id") int id){
		Customeraddr d= customerAddressRepository.getOne(id);
		customerAddressRepository.delete(d);
		return "CustomerAddress is deleted successfully";
	}
	
	
	@PutMapping(path="/address/{id}", consumes = {"application/json"})
	//This method updates the customer address
	public String updateCustomerAddress(@RequestBody Customeraddr customeraddr)	{
		customerAddressRepository.save(customeraddr);
		return "CustomerAddress is updated successfully";
	}
	
}
