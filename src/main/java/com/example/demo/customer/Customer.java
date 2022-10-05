package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {

    @Id
    private Long id;
    @NotBlank(message = "name must be not empty")    //Evita que quede en blanco
    private String name;
    @NotBlank(message = "password must be not empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @NotBlank(message = "email must be not empty")
    @Email
    private String email;

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

    public String getEmail() {
        return email;
    }

}
