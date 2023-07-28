package com.bitc.security.service;

import com.bitc.security.data.entity.User;
import com.bitc.security.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

// UserDetailsService : 스프링 시큐리티에서 제공하는 인터페이스로 사용자 정보를 가져옴

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

  private final UserRepository userRepository;

//  UserDetailsService 인터페이스에서 제공하는 사용자 정보를 가져오는 추상 메소드
//  UserRepository를 통해서 데이터 베이스에 있는 사용자 정보를 가져옴
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//    정상적으로 데이터를 가져올 경우 해당 데이터 출력
//    없으면 예외처리
    Optional<User> userInfo = userRepository.findByEmail(email);

    return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException(email));
  }
}
