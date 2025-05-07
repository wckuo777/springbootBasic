package com.myGroup.myArt.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "my_order")
@Schema(description = "訂單資料模型")
public class MyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "訂單 ID，自動產生", example = "101")
    private Integer id;

    @Column(name = "name", nullable = false, length = 10)
    @Schema(description = "訂單名稱或商品名稱", example = "耳機")
    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @Schema(description = "對應的顧客實體")
    private MyCustomer customer;

    @Column(name = "address", length = 45)
    @Schema(description = "配送地址", example = "台北市中山區民生東路100號")
    private String address;

    @Column(name = "duedate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "預定到期時間", example = "2025-06-30 18:00:00")
    private Date duedate;

    @Column(name = "price", nullable = false)
    @Schema(description = "價格，以整數單位存儲，例如元或分", example = "150000")
    private Long price;
}
