package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByState(String stateName);

    //List<Customer> findById(int customerId);


}
