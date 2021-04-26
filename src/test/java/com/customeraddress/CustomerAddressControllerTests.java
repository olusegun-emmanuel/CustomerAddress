package com.customeraddress;


import com.customeraddress.beans.CustomerAddrList;
import com.customeraddress.beans.Customeraddr;
import com.customeraddress.controller.CustomerAddressController;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class CustomerAddressControllerTests {


    @Autowired
    private CustomerAddressController customerAddressController;
    private CustomerAddrList customerAddrList;


    @Test
    @Order(1)
    public  void getCustomerAddressTest_Success(){
        customerAddrList =  customerAddressController.getCustomerAddress();
        List<Customeraddr> customerAddrListReturned = customerAddrList.getCustomeraddr();
        assertNotNull(customerAddrList.getCustomeraddr());
        assertEquals(3, customerAddrListReturned.size());
    }

    @Test
    @Order(2)
    public  void getAddressIdTest_Success(){
        Integer addressId = 1;
        Optional<Customeraddr> customerAddr =  customerAddressController.getAddressId(addressId);
        assertNotNull(customerAddr);
        assertEquals(1, customerAddr.get().getAddrid());
        assertEquals("bangalore@gmail.com", customerAddr.get().getEmail());
        assertEquals("D1", customerAddr.get().getId());
    }

    @Test
    @Order(3)
    public  void getAddressIdTest_Failure(){
        Integer addressId = 8;
        Optional<Customeraddr> customerAddr =  customerAddressController.getAddressId(addressId);
        Assertions.assertSame(Optional.empty(), customerAddr);
    }


    @Test
    @Order(4)
    public  void addAddress_Success() throws JSONException {
        Customeraddr customerAddress = new Customeraddr();
        customerAddress.setAddrid(3);;
        customerAddress.setId("ID3");
        customerAddress.setEmail("homa@mee.com");
        customerAddress.setAddress("Johannessburg");
        String customerAddr =  customerAddressController.addAddress(customerAddress);
        assertNotNull(customerAddr);
        Assertions.assertSame("Created successfully", customerAddr);
    }


    @Test
    @Order(5)
    public  void addAddress_AutoIdGeneratedSuccess() {
        Customeraddr customerAddress = new Customeraddr();
        customerAddress.setId("ID3");
        customerAddress.setEmail("homa@mee.com");
        customerAddress.setAddress("Johannessburg");
        String customerAddr =  customerAddressController.addAddress(customerAddress);
        assertNotNull(customerAddr);
    }


    @Test
    @Order(6)
    public  void updateCustomerAddress_Success() throws JSONException {
        Customeraddr customerAddress = new Customeraddr();
        customerAddress.setAddrid(3);;
        customerAddress.setId("ID3");
        customerAddress.setEmail("mynewemail@meez.com");
        customerAddress.setAddress("Randburg Johannessburg");
        String customerAddr =  customerAddressController.updateCustomerAddress(customerAddress);
        assertNotNull(customerAddr);
        Assertions.assertSame("CustomerAddress is updated successfully", customerAddr);
    }

    @Test
    @Order(7)
    public  void deleteCustomerAddres_Success() throws JSONException {
        Customeraddr customerAddress = new Customeraddr();
        Integer addressId = 4;
        String customerDeleted =  customerAddressController.deleteCustomerAddres(addressId);
        Assertions.assertSame("CustomerAddress is deleted successfully", customerDeleted);
    }



}