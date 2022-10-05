package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfiguration {
    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Value("${info.company.name}")
    private String companyName;

    @Autowired   // Not recommend
    private Environment environment;


    @Bean
    CommandLineRunner commandLineRunner() {
        return args ->{
            System.out.println("Command line runner hooray!");
            System.out.println(companyName);
            System.out.println(environment.getProperty("info.app.name"));
        } ;
    }

    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return new CustomerFakeRepository();
    }
}
