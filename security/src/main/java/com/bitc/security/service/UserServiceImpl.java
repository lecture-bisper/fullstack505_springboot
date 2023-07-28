package com.bitc.security.service;

import com.bitc.security.data.dto.AddUserRequest;
import com.bitc.security.data.entity.User;
import com.bitc.security.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public Long save(AddUserRequest dto) {
    return userRepository.save(User.builder()
        .email(dto.getEmail())
        .password(bCryptPasswordEncoder.encode(dto.getPassword()))
        .build()).getId();
  }
}
