package com.customeraddress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.customeraddress.beans.Customeraddr;

public interface CustomerAddressRepository extends JpaRepository<Customeraddr, Integer>{

}
