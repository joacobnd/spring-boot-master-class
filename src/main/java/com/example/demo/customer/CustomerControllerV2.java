package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@RequestMapping(path = "api/v2/customers")
@RestController
public class CustomerControllerV2 {

    private final CustomerService customerService;


    @GetMapping
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")    // = propiedad "id" de la clase Customer por medio de  @JsonProperty se le da el nombre customerId
    Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping(path = "{customerId}/exception")    // = propiedad "id" de la clase Customer por medio de  @JsonProperty se le da el nombre customerId
    Customer getCustomerException(@PathVariable("customerId") Long id) {
        throw new ApiRequestException("ApiRequestException for customer " + id);
    }

    @PostMapping
    void createNewCustomer(@Valid @RequestBody  Customer customer) {         //@Valid "activa o valida" los @NotBlank de la clase Customer
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer) {
        System.out.println("UPDATE REQUEST...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer (@PathVariable("customerId") Long id){
        System.out.println("DELET REQUEST FOR CUSTOMER WITH ID " + id);
    }

}
