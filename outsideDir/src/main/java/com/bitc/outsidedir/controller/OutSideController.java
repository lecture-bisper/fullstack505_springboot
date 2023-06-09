package com.bitc.outsidedir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OutSideController {
  @RequestMapping("/")
  public String index() throws Exception {
    return "index";
  }

  @RequestMapping("/imgLoad")
  public String imgLoad() throws Exception {
    return "imgLoad";
  }
}
