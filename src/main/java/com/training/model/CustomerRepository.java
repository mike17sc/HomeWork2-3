package com.training.spring.model;
/**
 * Created by Mschneider on 29-05-17.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CustomerRepository extends JpaRepository<Customer, Long> {

}
