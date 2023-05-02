package com.shop.dto;

import com.shop.constant.ItemSellStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ItemDto {

    private Long id;
    private String itemNm;
    private int price;
    private int stockNumber;
    private String itemDetail;
    private ItemSellStatus itemSellStatus;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;
}
