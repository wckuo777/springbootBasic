package com.myGroup.myArt.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "my_order")
public class MyOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", nullable = false, length = 10)
	private String name;
	
	@ManyToOne
    @JoinColumn(name = "customer_id", nullable = false) // 引用my_customer表的id
    private MyCustomer customer;


	@Column(name = "address", length = 45)
	private String address;

	@Column(name = "duedate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP) // 指定为时间戳类型
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 设置日期时间格式
	private Date duedate;
}
