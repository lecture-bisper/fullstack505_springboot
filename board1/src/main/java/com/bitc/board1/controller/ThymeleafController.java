package com.bitc.board1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

  @RequestMapping("/")
  public String index() throws Exception {
    return "/thymeleaf/index";
  }

  @RequestMapping("/test1")
  public ModelAndView test1() throws Exception {
    ModelAndView mv = new ModelAndView("/thymeleaf/test1");

//    템플릿에서 사용할 이름과 데이터를 지정
    mv.addObject("value1", "서버에서 전달한 문자열");
    mv.addObject("value2", 100);
    mv.addObject("utext", "문자열과 <strong>html 태그</strong>가 혼합된 문자열");
    return mv;
  }

}
