package com.myGroup.myArt.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
	private Integer id;
    private String name;
    private Long price;
    private Integer age; 
    private String address;
    private String duedate;
}
