package com.bitc.xml_json_parser.dto;

import lombok.Data;

import java.util.List;

@Data
public class BoxOfficeResultDto {
  private String boxofficeType;
  private String showRange;
  private List<DailyBoxOfficeDto> dailyBoxOfficeList = null;
}
