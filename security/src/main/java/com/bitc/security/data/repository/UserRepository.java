package com.bitc.security.data.repository;

import com.bitc.security.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//  사용자 email을 가져오는 JPA 쿼리 메소드 생성
  Optional<User> findByEmail(String email);
}
