package com.myGroup.myArt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myGroup.myArt.model.MyCustomer;

public interface MyCustomerRepository extends JpaRepository<MyCustomer, Integer> {
	   
}
