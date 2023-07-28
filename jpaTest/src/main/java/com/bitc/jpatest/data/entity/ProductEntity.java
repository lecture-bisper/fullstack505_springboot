package com.bitc.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

// callSuper : 부모 클래스의 필드를 해당 클래스에 포함하는 역할을 하는 속성, 롬복에서 제공
@Entity
@Table(name = "jpa_product")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long number; // 상품 번호

  @Column(nullable = false)
  private String name; // 상품 이름

  @Column(nullable = false)
  private Integer price; // 가격

  @Column(nullable = false)
  private Integer stock; // 재고 수량

//  아래의 필드는 부모 클래스인 BaseEntity로 부터 상속받아 사용하기 때문에 삭제함
//  @Column(nullable = false)
//  private LocalDateTime createdAt = LocalDateTime.now(); // 등록 시간
//
//  private LocalDateTime updatedAt; // 최종 수정 시간

//  mappedBy 속성은 @OneToOne 어노테이션 사용 시 양방향 매핑이 아니면 사용하지 않아도 됨
//  @ToString.Exclude : 두 개의 entity를 양방향 관계 설정 시 ToString을 사용하면 순환참조가 발생화기 때문에 순환 참조를 제거하기 위해서 사용함, 양방향 관계 설정이 아니면 사용할 필요 없음
  @OneToOne(mappedBy = "product")
  @ToString.Exclude
  private ProductDetailEntity productDetail;

  @ManyToOne
  @JoinColumn(name = "provider_id")
  @ToString.Exclude
  private ProviderEntity provider;
}










