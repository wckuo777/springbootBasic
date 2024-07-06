package com.myGroup.myArt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.myGroup.myArt.dto.OrderDTO;
import com.myGroup.myArt.model.MyOrder;
import com.myGroup.myArt.service.MyOrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;

@RestController
@RequestMapping("/orders")
public class MyOrderController {
	@Autowired
    private MyOrderService service;

	@Operation(summary = "Add a new order",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Order to add",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "OrderExample",
                                    value = "{\n" +
                                            "  \"name\": \"Order1\",\n" +
                                            "  \"customer\": {\n" +
                                            "    \"id\": 1\n" +
                                            "  },\n" +
                                            "  \"address\": \"123 Main St\",\n" +
                                            "  \"duedate\": \"2024-07-01 12:00:00\"\n" +
                                            "}"
                            )
                    )
            ))
    @PostMapping
    public MyOrder addOrder(@RequestBody MyOrder order) {
        return service.createMyOrder(order);
    }
    @Operation(summary = "Get all users", description = "Retrieve a list of all users")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                 content = {@Content(mediaType = "application/json")})
    @GetMapping
    public List<MyOrder> MyAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public MyOrder getOrderById(@PathVariable int id) {
        return service.getOrderById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public MyOrder updateOrder(@PathVariable int id, @RequestBody MyOrder order) {
        return service.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        service.deleteOrder(id);
    }
    
    @GetMapping("/with-age")
    public ResponseEntity<List<OrderDTO>> getAllOrdersForYou() {
        List<OrderDTO> dtos = service.getAllOrdersForYou();
        return ResponseEntity.ok(dtos);
    }
}
