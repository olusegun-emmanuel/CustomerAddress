package com.customeraddress.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customeraddr {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addrid;
	private String id;
	private String address;
	private String email;
	
	public int getAddrid() {
		return addrid;
	}
	public void setAddrid(int addrid) {
		this.addrid = addrid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Customeraddr() {}
	
	public Customeraddr(String id, String address, String email) {
		this.id = id;
		this.address = address;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customeraddr{" +
				"addrid=" + addrid +
				", id='" + id + '\'' +
				", address='" + address + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
