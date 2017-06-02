package com.training.service;

import com.training.model.Customer;

import java.util.Collection;

/**
 * Created by Opleiding on 2/06/2017.
 */
public interface CustomerService {

    Collection<Customer> list();

    Customer get(Long id);

    Customer create(Customer customer);

    Customer update(Customer customer);

    boolean delete(Long id);

}
