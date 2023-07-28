package com.bitc.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "jpa_titles")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TitlesEntity extends EmpBaseEntity {
//  @Id
//  private int empNo;

  @Id
  private String title;

  @Id
  @CreatedDate
  private LocalDateTime fromDate;

  @Id
  @ManyToOne
  @JoinColumn(name = "emp_no")
  @ToString.Exclude
  private EmployeesEntity employees;
}
