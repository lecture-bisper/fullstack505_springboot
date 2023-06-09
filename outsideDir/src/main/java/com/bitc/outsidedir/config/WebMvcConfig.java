package com.bitc.outsidedir.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  @Value("${resource.img.location1}")
  private String imgLocation1;

  @Value("${resource.img.location2}")
  private String imgLocation2;

//  외부 폴더를 스프링프레임워크 내부 리소스 폴더로 등록
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    addResourceHandler() : 스프링프레임워크 내부 리소스 폴더명 지정, 여러개를 사용하여 여러개의 경로명을 추가할 수 있음
//    ** : 모든 하위 폴더 및 모든 파일이라는 의미
//    addResourceLocations() : 실제 물리적 폴더 경로를 설정
//    여러개의 폴더를 등록하고자 할 경우 ','로 구분하여 경로 입력
//    윈도우와 리눅스 및 맥OS의 경로 입력 방식이 다름
//    윈도우는 file:///경로명
//    리눅스, 맥OS 는 file://경로명
//    application.properties 설정 파일에 경로명을 입력하고 Config 파일에서 경로 값을 불러와서 사용하는 방식이 존재함
//    @Value : application.properties 설정 파일에 존재하는 내용을 가져와서 변수에 저장하여 사용하게 해주는 어노테이션

//    기본 방식
//    registry.addResourceHandler("/images/**").addResourceLocations("file:///C:/smart505/images/");

//    경로 2개 이상 사용 방식
    registry.addResourceHandler("/images/**").addResourceLocations("file:///C:/smart505/images/img1/", "file:///C:/smart505/images/img2/");

//    application.properties 파일 설정값을 사용 방식
    String path1 = "file:///" + imgLocation1;
    String path2 = "file:///" + imgLocation2;
    registry.addResourceHandler("/img2/**").addResourceLocations(path1, path2);
  }
}
