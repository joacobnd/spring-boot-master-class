package com.example.demo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
@Primary
public class CustomerRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers() {
        // TODO connect to real db
        return List.of(
                new Customer(1L, "TODO, Implement real db"),
                new Customer(2L, "Joaquin Grandiccelli")
        );
    }

}
