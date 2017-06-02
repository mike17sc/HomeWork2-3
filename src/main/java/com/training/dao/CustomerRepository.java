package com.training.dao;
/**
 * Created by Mschneider on 29-05-17.
 */
import com.training.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CustomerRepository extends JpaRepository<Customer, Long> {

}
