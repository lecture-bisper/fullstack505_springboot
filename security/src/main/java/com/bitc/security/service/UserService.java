package com.bitc.security.service;

import com.bitc.security.data.dto.AddUserRequest;

public interface UserService {

  public Long save(AddUserRequest dto);
}
