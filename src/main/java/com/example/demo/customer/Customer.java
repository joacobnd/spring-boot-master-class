package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    private final Long id;
    private final String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private final String password;

    Customer(
            Long id,
            String name,
            String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @JsonProperty("customerId")    //Cambia el nombre de la propiedad
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore   //No envia la info al cliente
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
