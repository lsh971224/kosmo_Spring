package com.shop.entity;


import com.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item {
    @Id //primaray key 값이 됨
    @Column(name="item_id") //DB상에서는 얘가 item_id라는 컬렴명이됨
    @GeneratedValue(strategy = GenerationType.AUTO) //자동으로 키값을 생성해서 넣어줌
    private Long id;//상품 코드
    
    @Column(nullable = false, length = 50)  // notnull과 길이를 설정
    private String itemNm; //상품명
    @Column(name="price", nullable = false) // 테이블 속성이름과 NOT NULL조건
    private int price; //가격
    @Column(nullable = false) //NOT NULL
    private int stockNumber; //재고수량

    @Lob
    @Column(nullable = false) //columnDefinition 컬럼 속성 값을 지정해주는거임
    private String itemDetail; //상품 시세설명;
    
    @Enumerated(EnumType.STRING) //ENUM클래스에 지정한거랑 매핑 시킨다는 뜻
    private ItemSellStatus itemSellStatus; //상품 판매 상태


    private LocalDateTime regTime; //등록 시간
    //@creationTimestamp
    private LocalDateTime updateTime; //수정 시간
    //@UpdateTimestamp
    //위에 저 타임스탬프를 달면 자동 시간 설정을 해줌


}
