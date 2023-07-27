package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() throws Exception {
        customerRepository.deleteAll();
    }

    //Create a new customer record
    @Test
    public void shouldAddCustomer() {

        //Arrange
        Customer customer = new Customer();
        customer.setFirstName("Jimmy");
        customer.setLastName("Johns");
        customer.setEmail("johns@gmail.com");
        customer.setCompany("sandwich");
        customer.setPhone("123-555-555");
        customer.setAddress1("Central HQ");
        customer.setAddress2("Mid-Central HQ");
        customer.setCity("Chicago");
        customer.setState("Illinois");
        customer.setCountry("USA");

        //Act...
        customer = customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        //Assert...
        assertEquals(customer1.get(), customer);
    }

    //Update an existing customer record
    @Test
    public void shouldUpdateCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Jimmy");
        customer.setLastName("Johns");
        customer.setEmail("johns@gmail.com");
        customer.setCompany("sandwich");
        customer.setPhone("123-555-555");
        customer.setAddress1("Central HQ");
        customer.setAddress2("Mid-Central HQ");
        customer.setCity("Chicago");
        customer.setState("Illinois");
        customer.setCountry("USA");

        customer = customerRepository.save(customer);

        customer.setFirstName("Jameson");

        customerRepository.save(customer);

        //Act...
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        //Assert...
        assertEquals(customer1.get(), customer);
    }

    //Delete an existing customer record.
    @Test
    public void shouldDeleteCustomerById() {

        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Jimmy");
        customer.setLastName("Johns");
        customer.setEmail("johns@gmail.com");
        customer.setCompany("sandwich");
        customer.setPhone("123-555-555");
        customer.setAddress1("Central HQ");
        customer.setAddress2("Mid-Central HQ");
        customer.setCity("Chicago");
        customer.setState("Illinois");
        customer.setCountry("USA");

        customer = customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        assertEquals(customer1.get(), customer);

        //Act...
        customerRepository.deleteById(customer.getId());

        customer1 = customerRepository.findById(customer.getId());

        //Assert...
        assertFalse(customer1.isPresent());
    }

    //Find a customer record by id.
    @Test
    public void shouldGetCustomerById() {

        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Jimmy");
        customer.setLastName("Johns");
        customer.setEmail("johns@gmail.com");
        customer.setCompany("sandwich");
        customer.setPhone("123-555-555");
        customer.setAddress1("Central HQ");
        customer.setAddress2("Mid-Central HQ");
        customer.setCity("Chicago");
        customer.setState("Illinois");
        customer.setCountry("USA");

        customer = customerRepository.save(customer);

        //Act...
        Optional<Customer> foundCustomer = customerRepository.findById(customer.getId());

        //Assert...
        assertEquals(foundCustomer.get(), customer);
    }

    //Find customer records by state
    @Test
    public void shouldGetCustomerByName() {

        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Jimmy");
        customer.setLastName("Johns");
        customer.setEmail("johns@gmail.com");
        customer.setCompany("sandwich");
        customer.setPhone("123-555-555");
        customer.setAddress1("Central HQ");
        customer.setAddress2("Mid-Central HQ");
        customer.setCity("Chicago");
        customer.setState("Illinois");
        customer.setCountry("USA");

        customer = customerRepository.save(customer);

        //Act...
        List<Customer> aList = customerRepository.findByState("Illinois");

        //Assert...
        assertEquals(aList.size(), 1);
    }

}
