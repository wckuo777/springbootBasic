package com.myGroup.myArt.dto;

import lombok.Data;

@Data
public class OrderDTO {
	private Integer id;
    private String name;
    private Long price;
    private String address;
    private String duedate;
}
