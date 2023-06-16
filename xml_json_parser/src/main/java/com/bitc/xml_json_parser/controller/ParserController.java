package com.bitc.xml_json_parser.controller;

import com.bitc.xml_json_parser.dto.PharmarcyFullDataItemDto;
import com.bitc.xml_json_parser.service.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/parse")
public class ParserController {

  @Autowired
  private ParserService parserService;

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
}












