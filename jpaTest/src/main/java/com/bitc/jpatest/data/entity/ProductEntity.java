package com.bitc.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jpa_product")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long number; // 상품 번호

  @Column(nullable = false)
  private String name; // 상품 이름

  @Column(nullable = false)
  private Integer price; // 가격

  @Column(nullable = false)
  private Integer stock; // 재고 수량


}










