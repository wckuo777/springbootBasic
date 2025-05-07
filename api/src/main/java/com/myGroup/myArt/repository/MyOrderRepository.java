package com.myGroup.myArt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myGroup.myArt.model.MyOrder;


public interface MyOrderRepository extends JpaRepository<MyOrder, Integer> {
	List<MyOrder> findByPriceGreaterThan(Long price);

    List<MyOrder> findByPriceLessThan(Long price);

    List<MyOrder> findByPrice(Long price);

    List<MyOrder> findByPriceBetween(Long min, Long max);
}
