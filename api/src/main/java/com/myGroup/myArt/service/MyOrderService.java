package com.myGroup.myArt.service;

import com.myGroup.myArt.dto.OrderDTO;
import com.myGroup.myArt.dto.PriceQueryDTO;
import com.myGroup.myArt.enums.PriceQueryType;
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
import java.util.stream.Collectors;

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
    
    public List<OrderDTO> queryOrdersByPrice(PriceQueryDTO dto) {
        PriceQueryType type = dto.getType();
        Long price = dto.getPrice();
        Long maxPrice = dto.getMaxPrice();

        List<MyOrder> orders;

        switch (type) {
            case GREATER:
                orders = repository.findByPriceGreaterThan(price);
                break;
            case LESS:
                orders = repository.findByPriceLessThan(price);
                break;
            case EQUAL:
                orders = repository.findByPrice(price);
                break;
            case BETWEEN:
                if (price != null && maxPrice != null) {
                    orders = repository.findByPriceBetween(price, maxPrice);
                    break;
                }
                throw new IllegalArgumentException("BETWEEN 查詢需要 price 和 maxPrice");
            default:
                throw new IllegalArgumentException("未知查詢類型: " + type);
        }

        return orders.stream()
                     .map(this::toDto)
                     .collect(Collectors.toList());
    }

    private OrderDTO toDto(MyOrder order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setName(order.getName());
        dto.setAge(order.getCustomer().getAge());
        dto.setAddress(order.getAddress());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dto.setDuedate(sdf.format(order.getDuedate()));

        return dto;
    }

	
}