package com.bitc.board4.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_board")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JpaBoardEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int boardIdx;

  @Column(name = "title", length = 100, nullable = false)
  private String title;

  @Column(length = 500, nullable = false)
  private String contents;

  @Column(nullable = false)
  private String createId;

  @Column(nullable = false)
  private LocalDateTime createDt = LocalDateTime.now();

//  기본값으로 다 사용 시 @Column 어노테이션을 사용하지 않아도 됨
  private String updateId;

  private LocalDateTime updateDt;

  @Column(nullable = false)
  private int hitCnt;
}
