package com.bitc.security.data.dto;

import lombok.Getter;
import lombok.Setter;

// 클라이언트와 통신 시 사용할 DTO 클래스
@Getter
@Setter
public class AddUserRequest {
//  로그인 id로 사용할 email
  private String email;
  private String password;
}
