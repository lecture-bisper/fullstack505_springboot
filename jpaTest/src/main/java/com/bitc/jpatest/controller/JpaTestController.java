package com.bitc.jpatest.controller;

import com.bitc.jpatest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class JpaTestController {

  private final ProductService productService;

  @RequestMapping("/")
  public String index() throws Exception {
    productService.finds();
    productService.exists();
    productService.count();
    productService.and();


    return "success";
  }

  @RequestMapping("/query")
  public String query() throws Exception {
    productService.querySelectAll();
    productService.querySelectName();


    return "query success";
  }
}
