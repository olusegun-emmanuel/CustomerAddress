package com.customeraddress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.customeraddress.beans.Customeraddr;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerAddressRepository extends JpaRepository<Customeraddr, Integer> {

}
