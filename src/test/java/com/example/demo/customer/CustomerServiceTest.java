package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class CustomerServiceTest {



    private CustomerRepository customerRepository;

    private CustomerService underTest;



    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }


    @Test
    void getCustomers() {
        Customer jamila = new Customer(
                1L,
                "jamila",
                "hello",
                "jamila@gmail.com"
        );
        Customer ali = new Customer(
                2L,
                "ali",
                "hello",
                "ali@gmail.com"
        );

        customerRepository.saveAll(Arrays.asList(jamila, ali));

        List<Customer> customers = underTest.getCustomers();




    }


    @Test
    void getCustomer() {
        Customer jamila = new Customer(
                1L,
                "jamila",
                "hello",
                "jamila@gmail.com"
        );

        customerRepository.save(jamila);

        underTest.getCustomer(1L);


    }
}