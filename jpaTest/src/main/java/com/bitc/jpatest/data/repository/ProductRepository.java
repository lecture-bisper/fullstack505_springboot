package com.bitc.jpatest.data.repository;

import com.bitc.jpatest.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


// JpaRepository를 상속받았기 때문에 JpaRepository가 제공하는 기본 메소드와 쿼리 메소드를 생성할 수 있음
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
//  쿼리 메소드 : JpaRepository에서 제공하는 기본 메소드로는 원하는 데이터를 모두 컨트롤하기 힘들기 때문에 JpaRepository에서 제공하는 주제 키워드를 조합하여 원하는 메소드를 생성하여 사용할 수 있음

//  쿼리 메소드 생성 방법
//  리턴타입 + {주제 키워드 + 서술어} 를 조합하여 메소드 생성 ({} 부분은 반복 사용 가능)
//  ex) List<Person> findByLastnameAndEmail(String lastName, String email);

//  쿼리 메소드의 주제 키워드
//  find ... By : select 명령을 수행하는 키워드, read ... By, get ... By, query ... By, search ... By, stream ... By 추가로 존재함
  Optional<ProductEntity> findByNumber(Long number); // entity를 이미 지정했기 때문에 생략 가능
  Optional<ProductEntity> findProductEntityByNumber(Long number); // 기본 방식
  List<ProductEntity> findAllByName(String name); // 이름으로 기준으로 모든 데이터 가져오기
  ProductEntity queryByName(String name); // 다른 키워드로 데이터 가져오기

//  exists ... By : 특정 데이터가 존재하는지 확인하는 키워드, true/false 반환
  boolean existsByNumber(Long number); // 지정한 번호의 데이터가 있는지 조회

//  count ... By : select 명령을 수행한 후 쿼리 결과로 나온 레코드의 수를 출력하는 키워드
  int countByName(String name); // 지정한 이름을 가지고 있는 데이터 수를 출력
  
//  delete ... By, remove ... By : delete 명령을 수행하는 키워드, delete By 는 리턴이 없음, remove By 는 삭제 수를 반환함
  void deleteByNumber(Long number); // 지정한 번호를 기준으로 데이터 삭제, 반환값 없음
  long removeByName(String name); // 지정한 이름으로 데이터 삭제, 삭제된 데이터 수 반환
  
//  First<number>... , Top<number>... : select 명령을 수행한 후 조회된 결과를 제한하는 키워드
//    주제 키워드와 By 사이에 입력
  List<ProductEntity> findFirst5ByName(String name); // 조회된 결과 중 처음 5개만 출력
  List<ProductEntity> findTop5ByNumber(Long number); // 조회된 결과 중 숫자가 큰 것 5개 출력
  
//  Is : 조건자 키워드, 값의 일치 여부를 조건으로 사용, Equals와 동일한 기능을 제공
  ProductEntity findByNumberIs(Long number); // 지정한 번호와 같은 데이터를 조회
  ProductEntity findByNumberEquals(Long number); // 지정한 번호와 같은 데이터를 조회

//  (Is)Not : 값의 불일치를 조건을 사용하는 조건자 키워드, Is를 생략할 수 있음
  ProductEntity findByNumberIsNot(Long number); // 지정한 번호와 같지 않은 데이터를 조회
  ProductEntity findByNumberNot(Long number); // 지정한 번호와 같지 않은 데이터를 조회

//  (Is)Null, (Is)NotNull : 값이 null인지 확인하는 조건자 키워드, Is 생략 가능
//  List<ProductEntity> findByUpdatedAtNull(); // 수정된 데이터가 Null인 겂만 조회
//  List<ProductEntity> findByUpdatedAtIsNull();
//  List<ProductEntity> findByUpdatedAtNotNull(); // 수정된 데이터가 Null이 아닌 것만 조회
//  List<ProductEntity> findByUpdatedAtIsNotNull();

//  (Is)True, (Is)False : BOOLEAN 데이터 타입으로 지정된 컬럼값을 확인하는 키워드
//  List<ProductEntity> findByisActiveTrue();
//  List<ProductEntity> findByisActiveIsTrue();
//  List<ProductEntity> findByisActiveFalse();
//  List<ProductEntity> findByisActiveIsFalse();

//  And, Or : 조건을 추가하는 키워드
  ProductEntity findByNumberAndName(Long number, String name); // and 명령으로 조회 조건을 추가, 지정한 번호와 지정한 이름이 같은 데이터를 조회
  ProductEntity findByNumberOrName(Long number, String name); // or 명령으로 조회 조건을 추가, 지정한 번호나 지정한 이름을 가지고 있는 데이터를 조회

//  (Is)GreaterThan, (Is)LessThan, (Is)Between : 숫자나 datetime 컬럼을 대상으로 비교 연산에 사용할 수 있는 조건자 키워드
//  greaterThan, LessThan은 비교 대상에 대한 초과 및 미만을 비교 연산을 수행
//  경계값을 포함할 경우 Equal 키워드를 추가
  List<ProductEntity> findByPriceIsGreaterThan(Long price); // 지정한 가격 초과 데이터 조회
  List<ProductEntity> findByPriceGreaterThan(Long price);
  List<ProductEntity> findByPriceGreaterThanEqual(Long price); // 지정한 가격 이상의 데이터 조회
  List<ProductEntity> findByPriceIsLessThan(Long price); // 지정한 가격 미만 데이터 조회
  List<ProductEntity> findByPriceLessThan(Long price);
  List<ProductEntity> findByPriceLessThanEqual(Long price); // 지정한 가격 이하의 데이터 조회
  List<ProductEntity> findByPriceIsBetween(Long lowPrice, Long highPrice); // 지정한 낮은 데이터부터 높은 데이터까지의 데이터를 조회
  List<ProductEntity> findByPriceBetween(Long lowPrice, Long highPrice);

//  (Is)Like, (Is)Containing, (Is)StartingWith, (Is)EndingWith : 데이터가 일부 일치 여부를 확인하는 조건자 키워드
//  Like : 키워드가 포함되어 있을 경우
  List<ProductEntity> findByNameLike(String name); // 지정한 문자열이 포함되어 있는 이름 조회
  List<ProductEntity> findByNameIsLike(String name);
//  Containing : 키워드가 문자열의 양 끝에 있을 경우
  List<ProductEntity> findByNameContains(String name);
  List<ProductEntity> findByNameContaining(String name); // 지정한 문자열이 양끝에 포함되어 있는 이름을 조회
  List<ProductEntity> findByNameIsContaining(String name);
//  StartingWith : 키워드가 시작 문자열일 경우
  List<ProductEntity> findByNameStartsWith(String name); // 지정한 문자열로 시작하는 이름 조회
  List<ProductEntity> findByNameStartingWith(String name);
  List<ProductEntity> findByNameIsStartingWith(String name);
//  EndingWith : 키워드가 끝 문자열일 경우
  List<ProductEntity> findByNameEndsWith(String name); // 지정한 문자열로 끝나는 이름 조회
  List<ProductEntity> findByNameEndingWith(String name);
  List<ProductEntity> findByNameIsEndingWith(String name);

//  OrderBy ... Asc|Desc ... Asc|Desc : 쿼리문의 결과를 지정한 컬럼으로 정렬하는 키워드
  List<ProductEntity> findByNameOrderByNumberAsc(String name); // 지정한 이름으로 데이터를 조회 후 번호 기준으로 오름차순 정렬
  List<ProductEntity> findByNameOrderByNumberDesc(String name); // 지정한 이름으로 데이터를 조회 후 번호를 기준으로 내림차순 정렬
  List<ProductEntity> findByNameOrderByPriceAscStockDesc(String name); // 지정한 이름으로 데이터를 조회 후 가격을 기준으로 오름차순 정렬을 먼저하고, 재고수량을 기준으로 내림차순 정렬

//  정렬 사용 시 Sort객체를 사용하여 정렬하는 것이 가능함
//  쿼리 메소드 생성 후 매개변수에 Sort 객체를 추가하여 정렬
//  List<ProductEntity> findByName(String name); 와 같이 쿼리 메소드를 생성 후 실행 시에 Sort 객체를 추가하여 실행
//  productRepository.findByName("볼펜", Sort.by(Order.asc("price")));
//  productRepository.findByName("볼펜", Sort.by(Order.asc("price"), Order.desc("stock")));


//  @Query : 복잡한 쿼리문은 쿼리 메소드로 만들기 힘들기 때문에 @Query 라는 어노테이션을 제공함
//  JPQL(JPA SQL) 문법을 사용하여 SQL 쿼리를 생성하여 복잡한 쿼리문을 실행할 수 있도록 도와줌
//  검색 조건에 '?순번' 형태로 데이터를 사용함
//  사용법
//  @Query("select entity객체명 from entity클래스명 where 검색 조건1, 검색 조건2, ... ")
//  반환타입 메소드명(매개변수1, 매개변수2, ...);
//
//  @Query("SELECT p FROM ProductEntiry AS p")
//  List<ProductEntiry> selectAll();

  @Query("SELECT p FROM ProductEntity AS p ")
  List<ProductEntity> querySelectAll();

//  FROM 다음에 entity 클래스 명을 사용
//  AS 명령 사용하여 클래스의 별명을 입력
//  SELECT 절에 클래스의 별명.컬럼명으로 출력하고자하는 컬러만 입력
//  전체 컬럼을 출력 시 클래스의 별명만 입력 (* 아님)
//  WHERE 절에는 클래스 별명.컬럼명 형태로 사용함
  @Query("SELECT p FROM ProductEntity AS p WHERE p.name = '만년필' ")
  ProductEntity querySelectName();

//  메소드의 매개변수를 쿼리문에 적용할 경우 ?순번 형식으로 입력하여 데이터를 매칭함
//  순번은 1번부터 시작하고, 매개변수의 순서대로 매칭이 됨
  @Query("SELECT p FROM ProductEntity AS p WHERE p.name = ?1 ")
  ProductEntity querySelectName(String name);

//  메소드의 매개변수를 쿼리문에 적용할 경우 :매개변수명 형식으로 입력하는 방식도 있음
//  :매개변수 방식은 메소드의 매개변수 앞에 @Param("컬럼명") 을 반드시 사용해야 함
//  :매개변수 방식은 메소드의 매개변수 순서와 상관이 없음
  @Query("SELECT p FROM ProductEntity AS p WHERE p.name = :name AND p.price = :price ")
  ProductEntity querySelectNamePrice(@Param("name") String name, @Param("price") int price);

}

//문제 1) employees 데이터 베이스를 자신의 mysql server에 import 하고 해당 데이터 베이스의 본인 계정에 사용 권한을 설정한 후 entity 및 repository를 작성하고 데이터를 검색하는 프로그램을 작성하세요
// 1. root 계정으로 employees DB를 생성하고 DB 내용을 import하여 복구
// 2. 일반 계정에 employees DB에 대한 사용 권한 설정ㅇ
// 3. employees 테이블에 대한 entity 클래스 구현
// 4. repository 인터페이스 생성 (쿼리 메소드 생성, @Query 어노테이션 사용 2가지 방식)














