package com.company.customerdataservice.controller;


import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.List;

@WebMvcTest({CustomerController.class})
public class CustomerControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CustomerRepository customerRepository;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    //private List<Customer> custList;
    //public CustomerControllerTest(){}

    @BeforeEach
    public void setUp() {
        // Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Autowired
    }

    //A POST route that creates a new customer.
    @Test
    public void shouldReturnNewCustomerOnPostRequest() throws Exception {

        // ARRANGE
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
        customer.setId(2);

        //customer = customerRepository.save(customer);

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(customer);

        // ACT
        mockMvc.perform(
                        post("/customer")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    //A PUT route that updates an existing customer.
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
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
        customer.setId(2);

        String inputJson = mapper.writeValueAsString(customer);
        customer = customerRepository.save(customer);


        mockMvc.perform(
                        put("/customer")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    //A DELETE route that deletes an existing customer.
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/customer/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    //A GET route that returns a specific customer by id.
    @Test
    public void shouldReturnCustomerByID() throws Exception {
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
        customer.setId(2);

        //String id = String.valueOf(customer.getId());
        //customer = customerRepository.save(customer);

        String outputJson = mapper.writeValueAsString(customer);
        mockMvc.perform(get("/customer/2"))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().json(outputJson));
    }

    //A GET route that returns all customers for a specific state.
    @Test
    public void shouldReturnCustomerByState() throws Exception {
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

        //customer.setId(2);
        //customer = customerRepository.save(customer);

        String outputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(get("/customer/state/Illinois"))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().json(outputJson));
    }

}
