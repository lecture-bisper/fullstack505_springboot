package com.bitc.xml_json_parser.service;

import com.bitc.xml_json_parser.dto.DailyBoxOfficeDto;
import com.bitc.xml_json_parser.dto.PharmarcyFullDataItemDto;

import java.util.List;

public interface ParserService {
  List<PharmarcyFullDataItemDto> getItemListFile(String filePath) throws Exception;

  List<PharmarcyFullDataItemDto> getItemListUrl(String url) throws Exception;

  List<DailyBoxOfficeDto> getDailyBoxOfficeList(String url) throws Exception;
}
