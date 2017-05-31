package com.training.dao;

import com.training.model.Customer;
import com.training.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Mschneider on 31-05-17.
 */
@Component
public class DatabaseSeeder implements CommandLineRunner {
    private CustomerRepository customerRepository;
    @Autowired
    public DatabaseSeeder(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Customer> customers=new ArrayList<>();
        LocalDate birthday=LocalDate.of(1960, Month.JANUARY,1);
        customers.add(new Customer(1,"Mike","Schneider","mike17sc@hotmail.com","0470104195"));
        customers.add(new Customer(2,"Catherine","Berki","catherine@hotmail.com","0470414754"));
        customers.add(new Customer(3,"Seb","Godart","Seb@hotmail.com","0470104195"));
        customerRepository.save(customers);
    }
}
