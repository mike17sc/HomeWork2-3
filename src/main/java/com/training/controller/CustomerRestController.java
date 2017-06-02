package com.training.controller;

/**
 * Created by Opleiding on 26/05/2017.
 */

import java.util.Collection;

import com.training.service.CustomerServiceImpl;
import com.training.model.Customer;
import com.training.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

    CustomerRepository customerRepository;
    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @GetMapping("/customers")
    public Collection<Customer> getCustomers() {

        return customerServiceImpl.list();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") Long id) {

        Customer customer = customerServiceImpl.get(id);
        if (customer == null) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity createCustomer(@RequestBody Customer customer) {

        customerServiceImpl.create(customer);

        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @DeleteMapping("/customers/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {

        if (!customerServiceImpl.delete(id)) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(id, HttpStatus.OK);

    }

    @PutMapping("/customers/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {

        customer = customerServiceImpl.update(customer);

        if (null == customer) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(customer, HttpStatus.OK);
    }
}
