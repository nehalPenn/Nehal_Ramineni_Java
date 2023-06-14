package com.company;

import java.util.*;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}

    );

    public static void main(String[] args) {

        //create hashSet to store account names for checking
        Set<String> customerID = new HashSet<>();
        Set<Customer> customerObject = new HashSet<>();


        //create unique customer object for each unique ID
        for (String[] customerInfo: customerData) {
            //if customer ID is not present in hashset
            if (!customerID.contains(customerInfo[0])) {
                customerID.add(customerInfo[0]);
                //create new customer object and add name and ID
                Customer customer = new Customer();
                customer.setName(customerInfo[1]);
                customer.setId(Integer.parseInt(customerInfo[0]));
                customerObject.add(customer);
            }
        }

        //update customer objects account records
        for (String[] customerInfo: customerData) {
            for (Customer customer: customerObject) {
                if (customerInfo[1].equals(customer.getName())) {
                    //makes new account object for charge
                    AccountRecord accountRecord = new AccountRecord();
                    //sets charge
                    accountRecord.setCharge(Integer.parseInt(customerInfo[2]));
                    //sets date
                    accountRecord.setChargeDate(customerInfo[3]);
                    //adds to customer arrayList of AccountRecord array list
                    customer.getCharges().add(accountRecord);
                }
            }
        }

        //Positive Accounts
        System.out.println("Positive accounts:");
        for (Customer customer: customerObject) {
            if (customer.getBalance() > 0) {
                System.out.println(customer);
            }
        }

        //Negative Accounts
        System.out.println("Negative accounts:");
        for (Customer customer: customerObject) {
            if (customer.getBalance() < 0) {
                System.out.println(customer);
            }
        }
    }
}
