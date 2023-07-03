package com.bitc.xml_json_parser.controller;

import com.bitc.xml_json_parser.dto.DailyBoxOfficeDto;
import com.bitc.xml_json_parser.dto.PharmarcyFullDataItemDto;
import com.bitc.xml_json_parser.service.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/parse")
public class ParserController {

  @Autowired
  private ParserService parserService;

  @Value("${full505.kobis.json.DailyBoxOfficeResultUrl}")
  private String serviceUrl;

  @Value("${full505.kobis.json.key}")
  private String serviceKey;

  @RequestMapping({"/", ""})
  public String index() throws Exception {
    return "index";
  }

  @GetMapping("/pharmacy/fullDataFile")
  public ModelAndView getFullDataFile() throws Exception {
    ModelAndView mv = new ModelAndView("pharmacy/fullDataFile");

    List<PharmarcyFullDataItemDto> itemList = parserService.getItemListFile("C:\\smart505\\pharmarcy.xml");
    mv.addObject("itemList", itemList);

    return mv;
  }

  @GetMapping("/pharmacy/fullDataUrl")
  public String getFullDataUrl() throws Exception {
    return "pharmacy/fullDataUrl";
  }

  @ResponseBody
  @PostMapping("/pharmacy/fullDataUrl")
  public Object getFullDataUrl(@RequestParam("pageNo") String pageNo, @RequestParam("numOfRows") String numOfRows) throws Exception {

//    http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown?serviceKey=MQ8moCpDCqz42c3kxwz2LHfm%2BevXvXYOTYnrZjpLTYgYqArm4QD7hxWxCGM%2F24BBmgODLVMFUM6mAAH4XCFQcg%3D%3D&pageNo=1&numOfRows=10

    String serviceUrl = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown";
    String serviceKey = "?serviceKey=";
    String key = "MQ8moCpDCqz42c3kxwz2LHfm%2BevXvXYOTYnrZjpLTYgYqArm4QD7hxWxCGM%2F24BBmgODLVMFUM6mAAH4XCFQcg%3D%3D";
    String opt1 = "&pageNo=";
    String opt2 = "&numOfRows=";


    List<PharmarcyFullDataItemDto> itemList = parserService.getItemListUrl(serviceUrl + serviceKey + key + opt1 + pageNo + opt2 + numOfRows);

    return itemList;
  }

  // 영화 진흥원 일일 박스오피스 출력 View
  @GetMapping("/kobis/dailyBoxOffice")
  public String dailyBoxOfficeView() throws Exception {
    return "kobis/dailyBoxOffice";
  }

  // 영화 진흥원 일일 박스오피스 데이터 가져오기
  @ResponseBody
  @PostMapping("/kobis/dailyBoxOffice")
  public Object getDailyBoxOfficeProcess(@RequestParam("targetDt") String targetDt) throws Exception {
    String url = serviceUrl + "?key=" + serviceKey + "&targetDt=" + targetDt;

    List<DailyBoxOfficeDto> dailyBoxOfficeDtoList = parserService.getDailyBoxOfficeList(url);

    return dailyBoxOfficeDtoList;
  }
}












