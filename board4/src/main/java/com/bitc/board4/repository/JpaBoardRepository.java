package com.bitc.board4.repository;

import com.bitc.board4.entity.JpaBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repository : jpa에서 데이터 베이스에 명령어를 전달하는 인터페이스
// mybatis의 mapper와 xml 파일의 역할을 하고 있음

// Repository -> CrudRepository -> PagingAndSortingRepository -> JpaRepository 의 상속관계를 가지고 있음
// JpaRepository를 상속받아 사용함
// JpaRepository 상속 시 컬렉션 타입으로 첫번째 매개변수에 사용하고자 하는 entity 클래스명, 두번재 매개변수에 해당 entity 클래스에서 @Id로 설정한 필드의 데이터 타입을 입력

// JpaRepository에서 기본 명령어를 제공해줌
// count() : sql의 count() 명령과 동일한 기능
// save() : sql의 insert, update 명령과 동일한 기능
// saveAll() : 여러개의 데이터를 동시에 save() 하는 기능
// findById() : sql의 select 명령과 동일한 기능, pk를 통해서 조회
// findAll() : sql의 select 명령과 동일, 모든 데이터 가져오기
// deleteById() : sql의 delete 명령과 동일한 기능, pk를 통해서 삭제
// deleteAll() : sql의 delete 명령과 동일, 전체 삭제

public interface JpaBoardRepository extends JpaRepository<JpaBoardEntity, Integer> {
//  쿼리 메소드 : CrudRepository에서 지원하는 기본 쿼리 메소드를 가지고 원하는 모든 기능을 사용할 수 없기 때문에 특정 키워드를 사용하여 사용자 정의 메소드를 생성하는 방식의 메소드
//  쿼리 메소드를 사용하여 필요한 명령를 전달함
  List<JpaBoardEntity> findAllByOrderByBoardIdxDesc();
  
//  @Query : JpaRepository에서 제공하는 기본 명령어 및 메소드 쿼리로 만들기 힘든 복잡한 쿼리문의 경우 JPQL 문법을 통해서 SQL 쿼리문을 직접 생성하여 실행할 수 있도록 해주는 어노테이션
}




