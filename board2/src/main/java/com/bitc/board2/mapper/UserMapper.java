package com.bitc.board2.mapper;

import com.bitc.board2.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

  public int isUserInfo(@Param("userId") String userId, @Param("userPw") String userPw) throws Exception;

  public UserDto getUserInfo(@Param("userId") String userId) throws Exception;
}
