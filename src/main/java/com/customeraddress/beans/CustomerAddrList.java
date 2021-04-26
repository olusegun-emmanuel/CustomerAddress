package com.customeraddress.beans;

import java.util.List;

public class CustomerAddrList {
	private List<Customeraddr> customeraddr;

	public List<Customeraddr> getCustomeraddr() {
		return customeraddr;
	}

	public void setCustomeraddr(List<Customeraddr> customeraddr) {
		this.customeraddr = customeraddr;
	}

	@Override
	public String toString() {
		return "CustomerAddrList{" +
				"customeraddr=" + customeraddr.toString() +
				'}';
	}
}
