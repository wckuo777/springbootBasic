package com.myGroup.myArt.dto;

import lombok.Data;

@Data
public class OrderDTO {
	private Integer id;
    private String name;
    private Integer age;
    private String address;
    private String duedate;
}
