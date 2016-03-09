package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Customer;

/**
 * Repository for customer whiech extends
 * 
 * @author Yuba Raj Kalathoki
 * @version 0.1.0
 * @since 0.1.0
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
