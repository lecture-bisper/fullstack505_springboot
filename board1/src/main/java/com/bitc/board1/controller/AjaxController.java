package com.bitc.board1.controller;

import com.bitc.board1.dto.AreaDto;
import com.bitc.board1.dto.CalculatorDto;
import com.bitc.board1.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class AjaxController {

  @Autowired
  private AreaService areaService;

  // ajax를 사용하지 않는 계산 페이지
  @RequestMapping(value = "/ajax/nonAjaxCalView", method = RequestMethod.GET)
  public String nonAjaxCalView() throws Exception {
    return "ajax/nonAjaxCalView";
  }

//  ajax를 사용하지 않는 계산 결과 페이지
  @RequestMapping(value = "/ajax/nonAjaxCalResult", method = RequestMethod.GET)
  public ModelAndView nonAjaxCalResult(@RequestParam("num1") int num1, @RequestParam int num2) throws Exception {
    ModelAndView mv = new ModelAndView("ajax/nonAjaxCalResult");

    int result = num1 + num2;

    mv.addObject("num1", num1);
    mv.addObject("num2", num2);
    mv.addObject("result", result);

    return mv;
  }

//  ajax를 사용하는 계산 페이지
  @RequestMapping(value = "/ajax/ajaxCalView", method = RequestMethod.GET)
  public String ajaxCalView() throws Exception {
    return "ajax/ajaxCalView";
  }
  
//  ajax를 사용하는 계산 프로세스
  @ResponseBody
  @RequestMapping(value = "/ajax/ajaxCalResult", method = RequestMethod.POST)
  public Object ajaxCalResult(@RequestParam("num1") int num1, @RequestParam("num2") int num2) throws Exception {
    int result = num1 + num2;

    HashMap<String, String> mapResult = new HashMap<String, String>();
    mapResult.put("result", "success");
    mapResult.put("value", String.valueOf(result));

    return mapResult;
  }

  @RequestMapping(value = "/ajax/selectBox", method = RequestMethod.GET)
  public String selectBox() throws Exception {
    return "ajax/selectBox";
  }

//  @ResponseBody : 사용자 요청을 서버에서 받은 후 클라이언트로 응답할 때 View를 제외하고 데이터만 전송하도록 하는 어노테이션, ajax 통신 시 반드시 해당 메소드 위에 추가해야 함
  @ResponseBody
  @RequestMapping(value = "/ajax/selectBox1", method = RequestMethod.POST)
  public Object selectBox1(@RequestParam("areaName") String areaName) throws Exception {

    List<AreaDto> areaList = new ArrayList<>();

    if (areaName.equals("서울")) {
      AreaDto se1 = new AreaDto();
      AreaDto se2 = new AreaDto();
      AreaDto se3 = new AreaDto();
      AreaDto se4 = new AreaDto();

      se1.setAreaName("강북구");
      se2.setAreaName("강남구");
      se3.setAreaName("강서구");
      se4.setAreaName("강동구");

      areaList.add(se1);
      areaList.add(se2);
      areaList.add(se3);
      areaList.add(se4);
    }
    else if (areaName.equals("대전")) {
      AreaDto dj1 = new AreaDto();
      AreaDto dj2 = new AreaDto();
      AreaDto dj3 = new AreaDto();
      AreaDto dj4 = new AreaDto();

      dj1.setAreaName("동구");
      dj2.setAreaName("중구");
      dj3.setAreaName("서구");
      dj4.setAreaName("유성구");

      areaList.add(dj1);
      areaList.add(dj2);
      areaList.add(dj3);
      areaList.add(dj4);
    }
    else if (areaName.equals("대구")) {
      AreaDto dg1 = new AreaDto();
      AreaDto dg2 = new AreaDto();
      AreaDto dg3 = new AreaDto();
      AreaDto dg4 = new AreaDto();

      dg1.setAreaName("달서구");
      dg2.setAreaName("달서군");
      dg3.setAreaName("수성구");
      dg4.setAreaName("중구");

      areaList.add(dg1);
      areaList.add(dg2);
      areaList.add(dg3);
      areaList.add(dg4);
    }
    else if (areaName.equals("부산")) {
      AreaDto bs1 = new AreaDto();
      AreaDto bs2 = new AreaDto();
      AreaDto bs3 = new AreaDto();
      AreaDto bs4 = new AreaDto();

      bs1.setAreaName("부산진구");
      bs2.setAreaName("해운대구");
      bs3.setAreaName("동래구");
      bs4.setAreaName("영도구");

      areaList.add(bs1);
      areaList.add(bs2);
      areaList.add(bs3);
      areaList.add(bs4);
    }

    return areaList;
  }

  @RequestMapping(value = "/ajax/quiz1", method = RequestMethod.GET)
  public String quiz1() throws Exception {
    return "ajax/quiz1";
  }

  @ResponseBody
  @RequestMapping(value = "/ajax/quiz1Result", method = RequestMethod.POST)
  public Object quiz1Result(@RequestParam("num1") int num1, @RequestParam("num2") int num2, @RequestParam("op") String op) throws Exception {
    CalculatorDto cal = new CalculatorDto();
    cal.setNum1(num1);
    cal.setNum2(num2);
    cal.setOperation(op);

    switch (op) {
      case "+":
        cal.setResult(cal.getNum1() + cal.getNum2());
        break;

      case "-":
        cal.setResult(cal.getNum1() - cal.getNum2());
        break;

      case "*":
        cal.setResult(cal.getNum1() * cal.getNum2());
        break;

      case "/":
        cal.setResult(cal.getNum1() / cal.getNum2());
        break;
    }

    return cal;
  }

  @RequestMapping(value = "/ajax/quiz2", method = RequestMethod.GET)
  public String quiz2() throws Exception {
    return "ajax/quiz2";
  }

  @ResponseBody
  @RequestMapping(value = "/ajax/quiz2Result", method = RequestMethod.POST)
  public Object quiz2Result(@RequestParam("areaName") String areaName) throws Exception {
    List<AreaDto> areaList = areaService.getDistrictList(areaName);

    return areaList;
  }

  @ResponseBody
  @RequestMapping(value = "/ajax/quiz2Result2", method = RequestMethod.POST)
  public Object quiz2Result2(@RequestParam("areaName") String areaName) throws Exception {
    List<AreaDto> areaList = areaService.getTownList(areaName);

    return areaList;
  }
}











