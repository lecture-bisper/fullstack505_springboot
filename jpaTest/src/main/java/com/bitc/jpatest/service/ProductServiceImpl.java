package com.bitc.jpatest.service;

import com.bitc.jpatest.data.entity.ProductEntity;
import com.bitc.jpatest.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public void finds() throws Exception {
    System.out.println("\n ----- findBy() 쿼리 메소드 실행 ----- \n");

    Optional<ProductEntity> prod1 = productRepository.findByNumber((long)1);
    Optional<ProductEntity> prod2 = productRepository.findProductEntityByNumber((long)2);
    List<ProductEntity> prod3 = productRepository.findAllByName("볼펜");
    ProductEntity prod4 = productRepository.queryByName("볼펜");

    System.out.println("\n ----- findBy() 쿼리 메소드 실행 완료 ----- \n");
  }

  @Override
  public void exists() throws Exception {
    System.out.println("\n ----- existsBy() 쿼리 메소드 실행 ----- \n");
    boolean isProductNumber = productRepository.existsByNumber((long)200);

    System.out.println("\n ----- existsBy() 쿼리 메소드 실행 완료 ----- \n");
  }

  @Override
  public void count() throws Exception {
    System.out.println("\n ----- countBy() 쿼리 메소드 실행 ----- \n");
    int count = productRepository.countByName("만년필");

    System.out.println("\n ----- countBy() 쿼리 메소드 실행 완료 ----- \n");
  }

  @Override
  public void delete() throws Exception {

  }

  @Override
  public void limit() throws Exception {

  }

  @Override
  public void equals() throws Exception {

  }

  @Override
  public void isNot() throws Exception {

  }

  @Override
  public void isNull() throws Exception {

  }

  @Override
  public void isNotNull() throws Exception {

  }

  @Override
  public void and() throws Exception {
    System.out.println("\n ----- And() 쿼리 메소드 실행 ----- \n");
    ProductEntity prod1 = productRepository.findByNumberAndName((long)5, "만년필");
    ProductEntity prod2 = productRepository.findByNumberAndName((long)9, "만년필");
    System.out.println("\n ----- And() 쿼리 메소드 실행 완료 ----- \n");
  }

  @Override
  public void or() throws Exception {

  }

  @Override
  public void between() throws Exception {

  }

  @Override
  public void like() throws Exception {

  }

  @Override
  public void orderBy() throws Exception {

  }

  @Override
  public void querySelectAll() {
    System.out.println("\n ----- @Query 사용, querySelectAll() 실행 -----\n");
    List<ProductEntity> prod1 = productRepository.querySelectAll();
    System.out.println("\n ----- @Query 사용, querySelectAll() 실행 완료 -----\n");
  }

  @Override
  public void querySelectName() {
    System.out.println("\n ----- @Query 사용, querySelectName() 실행 -----\n");
    ProductEntity prod1 = productRepository.querySelectName();
    ProductEntity prod2 = productRepository.querySelectName("사인펜");
    ProductEntity prod3 = productRepository.querySelectNamePrice("샤프", 2000);
    System.out.println("\n ----- @Query 사용, querySelectName() 실행 완료 -----\n");
  }
}
