package com.bitc.board3.service;

import com.bitc.board3.dto.AddressDto;
import com.github.pagehelper.Page;

public interface AddressService {

  Page<AddressDto> getAddressList(int pageNum) throws Exception;
}
