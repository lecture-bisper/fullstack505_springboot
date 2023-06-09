package com.bitc.board1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

//스프링부트 자동 설정 기능이 있기 때문에 apache commons-fileupload 라이브러리를 사용하면 설정 충돌이 발생함
//exclude = {MultipartAutoConfiguration.class} 를 추가하여 Multipart 데이터에 대해서 자동 설정을 제외함
//WebMvcConfigurer 를 상속받아 사용자 설정을 추가함
@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
public class Board1Application {

  public static void main(String[] args) {
    SpringApplication.run(Board1Application.class, args);
  }

}
