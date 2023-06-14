package com.bitc.board1.configuration;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//스프링6 (스프링부트3)에서 CommonsMultipartResolver 더이상 사용하지 않음, StandardServletMultipartResolver로 변경됨
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration : 스프링프레임워크에 해당 파일이 설정 파일임을 알려주는 어노테이션
//WebMvcConfigurer : 스프링프레임워크에서 사용하는 설정 정보가 있는 인터페이스, 사용자 설정이 필요할 경우 해당 인터페이스를 상속받아 수정
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

//  스프링6 (스프링부트3)에서 CommonsMultipartResolver를 사용할 수 없기 때문에 예전 방식으로 설정이 불가능함
//  @Bean
//  public CommonsMultipartResolver multipartResolver() {
////    apache commons-fileupload 설정 객체 생성
//    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
////    사용할 문자셋 설정
//    resolver.setDefaultEncoding("UTF-8");
////    업로드할 파일의 최대 크기 설정(byte 단위),
//    resolver.setMaxUploadSizePerFile(10 * 1024 * 1024);
//    return resolver;
//  }

//  StandardServletMultipartResolver를 사용한 업로드 파일 설정
  @Bean
  public MultipartResolver multipartResolver() {
    return new StandardServletMultipartResolver();
  }

  @Bean
  public MultipartConfigElement multipartConfigElement() {
    MultipartConfigFactory factory = new MultipartConfigFactory();
//    업로드 파일의 크기 설정
    factory.setMaxRequestSize(DataSize.ofBytes(5 * 1024 * 1024));
    factory.setMaxFileSize(DataSize.ofBytes(5 * 1024 * 1024));

    return factory.createMultipartConfig();
  }
}











