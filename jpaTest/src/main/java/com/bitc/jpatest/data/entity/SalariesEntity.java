package com.bitc.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "jpa_salaries")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SalariesEntity extends EmpBaseEntity {

//  @Id
//  private int empNo;

  @Id
  @CreatedDate
  private LocalDateTime fromDate;

  @Column(nullable = false)
  private int salary;

  @Id
  @ManyToOne
  @JoinColumn(name = "emp_no")
  @ToString.Exclude
  private EmployeesEntity employees;
}
