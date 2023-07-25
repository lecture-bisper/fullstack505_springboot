package com.bitc.board4.entity;

// 스프링6(스프링부트3) 부터 javax -> jakarta로 변경됨
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Entity : JPA에서 해당 클래스가 데이터 베이스 테이블이라는 것을 알려주는 어노테이션
// 클래스명이 테이블명으로 사용됨
// DB의 테이블명을 변경하고자 할 경우 @Table 어노테이션을 사용해야 함
// Mybatis 사용 시의 DTO 클래스의 역할도 함께 하고 있음

// @Table : 지정한 엔티티와 실제 데이터 베이스의 테이블을 연동
// name 속성을 사용하여 테이블명을 지정할 수 있음

// @NoArgsConstructor : 매개변수가 없는 기본 생성자를 자동으로 생성하는 어노테이션
// @AllArgsConstructor : 모든 필드에 대한 매개변수가 있는 생성자를 자동으로 생성하는 어노테이션
// @Data : getter, setter, toString을 자동으로 생성하는 어노테이션
@Entity
@Table(name = "t_member")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {

//  @Id : 해당 필드가 데이터베이스의 기본키임을 지정하는 어노테이션
//  @GeneratedValue : 데이터가 추가될 경우 값을 자동 증가할지 여부를 지정하는 어노테이션
//  옵션이 4가지가 존재함
//  AUTO : 선택한 데이터 베이스에 따라 자동으로 선택
//  IDENTITY : 기본 키 생성을 데이터베이스에 위임 (데이터베이스 설정에 따름)
//  SEQUENCE : 데이터 베이스 시퀀스를 사용하여 기본 키를 설정 (oracle에서 사용함)
//  TABLE : 키 생성 테이블을 사용함
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long idx;

//  @Column : 지정한 필드를 데이터베이스의 컬럼과 연동시키는 어노테이션
//  해당 어노테이션을 사용하지 않아도 기본적으로 컬럼으로 인식함
//  컬럼이 가지고 있는 특성을 적용하고자 할 경우 사용
//  기본적으로 자바 클래스에서 카멜명명법 사용 시 데이터 베이스에서 스네이크 명명법으로 적용
//  unique : 컬럼의 유니크 여부 설정
//  nullable : 컬럼의 null 허용 여부 설정
//  updatable : 컬럼의 수정 가능 여부 설정
//  length : 컬럼에 저장될 데이터의 크기 설정
//  name : 실제 데이터 테이블의 컬럼명 설정
//  precision : BigDecimal, BigInteger 타입 사용 시 소수점 포함 전체 자리 수 설정
//  scale : BigDecimal, BigInteger 타입 사용 시 소수점의 자리 수 설정
  @Column(nullable = false)
  private String userId;

  @Column(nullable = false)
  private String userPw;

  @Column(nullable = false)
  private String userName;

  private String userEmail;
}









