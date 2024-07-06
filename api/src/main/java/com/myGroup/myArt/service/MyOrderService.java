package com.myGroup.myArt.service;

import com.myGroup.myArt.dto.OrderDTO;
import com.myGroup.myArt.model.MyCustomer;
import com.myGroup.myArt.model.MyOrder;
import com.myGroup.myArt.repository.MyCustomerRepository;
import com.myGroup.myArt.repository.MyOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyOrderService {

    @Autowired
    private MyOrderRepository repository;
    
    @Autowired
    private MyCustomerRepository customerRepository;

    @Autowired
    private MyOrderRepository orderRepository;

    // 检查客户是否存在，如果不存在则创建
    @Transactional
    public MyCustomer ensureCustomerExists(MyCustomer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer data must not be null");
        }
        return customerRepository.findById(customer.getId())
                .orElseGet(() -> customerRepository.save(customer));
    }

    // 创建新订单
    @Transactional
    public MyOrder createMyOrder(MyOrder order) {
        if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Order must have a customer associated with it");
        }
        return orderRepository.save(order);
    }

//    public MyOrder createMyOrder(MyOrder order) {
//        return repository.save(order);
//    }

    public List<MyOrder> getAllOrders() {
        return repository.findAll();
    }

    public Optional<MyOrder> getOrderById(int id) {
        return repository.findById(id);
    }

    public MyOrder updateOrder(MyOrder order) {
        return repository.save(order);
    }

    public void deleteOrder(int id) {
        repository.deleteById(id);
    }
    
    public List<OrderDTO> getAllOrdersForYou() {
        List<MyOrder> orders = repository.findAll();
        List<OrderDTO> dtos = new ArrayList<>();
        
        for (MyOrder order : orders) {
            OrderDTO dto = new OrderDTO();
            dto.setId(order.getId());
            dto.setName(order.getName());
            dto.setAge(order.getCustomer().getAge());  // 假设每个订单都有对应的客户
            dto.setAddress(order.getAddress());
            dto.setDuedate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getDuedate())); // 格式化日期

            dtos.add(dto);
        }
        
        return dtos;
    }
	
}