package com.bitc.board2.dto;

import lombok.Data;

//  데이터 베이스의 User 테이블의 데이터를 주고 받기 위한 Dto 클래스
@Data
public class UserDto {
  private String userId;
  private String userPw;
  private String userName;
  private String userEmail;
}
