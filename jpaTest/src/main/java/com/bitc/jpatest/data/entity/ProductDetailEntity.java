package com.bitc.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jpa_product_detail")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductDetailEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String description;

//  @Column(nullable = false)
//  private LocalDateTime createdAt = LocalDateTime.now(); // 등록 시간
//
//  private LocalDateTime updatedAt; // 최종 수정 시간

//
  @OneToOne
  @JoinColumn(name = "product_name")
  private ProductEntity product;
}












