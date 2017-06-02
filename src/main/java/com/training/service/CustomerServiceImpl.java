package com.training.service;

import com.training.dao.CustomerRepository;
import com.training.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by Opleiding on 26/05/2017.
 */
@Component
public class CustomerServiceImpl implements CustomerService {


    /**
     * Returns list of customers from dummy database.
     *
     * @return list of customers
     */
    @Autowired
    private com.training.dao.CustomerRepository CustomerRepository;

    public Collection<Customer> list() {
        Collection<Customer> customers = CustomerRepository.findAll();
        return customers;
    }

    /**
     * Return customer object for given id from dummy database. If customer is
     * not found for id, returns null.
     *
     * @param id customer id
     * @return customer object for given id
     */
    public Customer get(Long id) {

        return CustomerRepository.findOne(id);
    }

    /**
     * Create new customer in dummy database. Updates the id and insert new
     * customer in list.
     *
     * @param customer Customer object
     * @return customer object with updated id
     */
    public Customer create(Customer customer) {
        //can't create Customer with specify ID
        if (customer.getId() != null) {
            return null;
        } else {
            return CustomerRepository.save(customer);
        }
    }

    /**
     * Update the customer object for given id in dummy database. If customer
     * not exists, returns null
     *
     * @param id id of object
     * @param customer
     * @return customer object with id
     */
    public Customer update(Customer customer) {
        if (get(customer.getId()) == null) {
            return null;
        }
        return CustomerRepository.save(customer);

    }

    /**
     * Delete the customer object from dummy database. If customer not found for
     * given id, returns null.
     *
     * @param id the customer id
     * @return id of deleted customer object
     */
    public boolean delete(Long id) {

        CustomerRepository.delete(id);

        return true;
    }
}
