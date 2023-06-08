package com.bitc.board1.service;

import com.bitc.board1.dto.AreaDto;

import java.util.List;

public interface AreaService {

  List<AreaDto> getDistrictList(String cityName) throws Exception;
  List<AreaDto> getTownList(String districtName) throws Exception;

}
