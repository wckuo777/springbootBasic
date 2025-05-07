package com.myGroup.myArt.dto;

import com.myGroup.myArt.enums.PriceQueryType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceQueryDTO {

    @Schema(description = "查詢方式，可為 GREATER, LESS, EQUAL, BETWEEN", example = "GREATER", required = true)
    private PriceQueryType type;

    @Schema(description = "價格值，例如 100", example = "100", required = true)
    private Long price;

    @Schema(description = "最大價格（僅在 type=BETWEEN 時使用）", example = "200")
    private Long maxPrice;
   
    
}