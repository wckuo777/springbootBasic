package com.myGroup.myArt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myGroup.myArt.model.MyOrder;

public interface MyOrderRepository extends JpaRepository<MyOrder, Integer> {
   
}
