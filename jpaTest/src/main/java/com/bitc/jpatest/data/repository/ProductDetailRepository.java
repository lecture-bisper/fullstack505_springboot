package com.bitc.jpatest.data.repository;

import com.bitc.jpatest.data.entity.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long> {
}

//문제 1) employees 데이터베이스의 employees, salaries, titles 테이블에 대한 각각의 entity 를 생성하고 관계 설정 및 사용 repository를 생성하세요
// 현재 데이터 베이스(testdb)에서 생성
// employees 테이블이 메인 테이블, salaries, titles 테이블은 서브 테이블
// 참조키 이름은 'emp_no'로 설정
