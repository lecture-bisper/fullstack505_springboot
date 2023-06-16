package com.bitc.board3.service;

import com.bitc.board3.dto.AddressDto;
import com.bitc.board3.mapper.AddressMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

  @Autowired
  private AddressMapper addressMapper;

  @Override
  public Page<AddressDto> getAddressList(int pageNum) throws Exception {
//    첫번째 매개변수 : 현재 페이지 번호
//    두번째 매개변수 : 현재 페이지에 출력한 게시물 수
//    PageHelper 라이브러리가 mapper를 사용하여 전체 데이터를 불러온 후 자동으로 제어함
//    mapper의 sql문에 limit로 개수 제한을 할 필요가 없음
    PageHelper.startPage(pageNum, 30);
    return addressMapper.getAddressList();
  }
}
