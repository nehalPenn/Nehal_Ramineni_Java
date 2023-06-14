package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void getBalance() {
        /*
            TEST POSITIVES
         */
        Customer customer = new Customer();
        //Adds 100 Dollar Charge
        AccountRecord ar1 = new AccountRecord();
        ar1.setCharge(100);
        customer.getCharges().add(ar1);
        //Adds another 100 Dollar Charge
        AccountRecord ar2 = new AccountRecord();
        ar2.setCharge(100);
        customer.getCharges().add(ar2);
        //total charge should be 200
        assertEquals(200, customer.getBalance());
        System.out.println(customer.getBalance());


         /*
            TEST NEGATIVES
         */
        Customer customer1 = new Customer();
        //Adds 100 Dollar Charge
        AccountRecord ar3 = new AccountRecord();
        ar3.setCharge(-100);
        customer1.getCharges().add(ar3);
        //Adds another 100 Dollar Charge
        AccountRecord ar4 = new AccountRecord();
        ar4.setCharge(-100);
        customer1.getCharges().add(ar4);
        //total charge should be 200
        assertEquals(-200, customer1.getBalance());
        System.out.println(customer1.getBalance());

        /*
            TEST NEGATIVES and POSITIVES
         */
        Customer customer2 = new Customer();
        //Adds 100 Dollar Charge
        AccountRecord ar5 = new AccountRecord();
        ar5.setCharge(-100);
        customer2.getCharges().add(ar5);
        //Adds another 100 Dollar Charge
        AccountRecord ar6 = new AccountRecord();
        ar6.setCharge(100);
        customer2.getCharges().add(ar6);
        //total charge should be 200
        assertEquals(0, customer2.getBalance());
        System.out.println(customer2.getBalance());
    }

    @Test
    void testToString() {

        //Create test customer for comparison
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Bobby");
        AccountRecord ar1 = new AccountRecord();
        ar1.setCharge(100);
        customer.getCharges().add(ar1);

        //TEST TO STRING IN FORMAT OF CUSTOMER ID, NAME, AND BALANCE.
        String string  = ("ID: " + 1 + " NAME: " + "Bobby" + " BALANCE: " + 100);
        assertEquals(customer.toString(), string);
        //Make sure other formats fail
        String string1  = (1 + "Bobby" + " " + 100);
        assertFalse(customer.toString().equals(string1));

    }
}