package com.bitc.board1.controller;

import com.bitc.board1.dto.BoardDto;
import com.bitc.board1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@Controller : 해당 클래스가 Spring MVC 패턴에서 Controller 로 동작하는 것을 설정하는 어노테이션
// @Controller, @RestController 2가지 타입이 존재함
// @Controller : 일반적인 SOAP 방식의 HTTP 응답 처리를 할 경우 사용함, get/post 2가지를 사용
// @RestController : RESTful 방식의 HTTP 응답 처리를 할 경우 사용함, get/post/put/delete 를 사용하는 방식
@Controller
public class BoardController {

//  @Autowired : 해당 객체를 스프링프레임워크에서 직접 객체를 생성하고 관리하도록 설정하는 어노테이션
//  BoardService 타입의 변수 선언
  @Autowired
  private BoardService boardService;

//  @RequestMapping : 클라이언트 요청을 받는 URL을 설정하는 어노테이션
//  url 주소를 입력이 기본값이므로 value 속성명 생략 가능
//  get/post 와 같은 주소 및 다른 추가 옵션을 url과 함께 사용 시 속성명을 반드시 입력
//  url 주소를 2개 이상 입력하고자 할 경우 {url1, url2, url3, ...} 형태로 입력

//  지정한 메소드의 반환타입을 사용하여 View의 출력 형태를 결정함
//  반환타입이 String일 경우 templates의 html 파일의 이름을 지정함 (대소문자 구분함)
  @RequestMapping({"/", "/index", "/main"})
  public String index() throws Exception {
    return "index";
  }

  //  반환 타입이 ModelAndView 일 경우는 templates의 html 파일에 데이터가 포함되어 있음을 의미함
  @RequestMapping(value="/board/boardList.do", method = RequestMethod.GET)
  public ModelAndView openBoardList() throws Exception {
//    ModelAndView : 데이터와 View Template이 모두 포함된 클래스
//    해당 클래스의 객체 생성 시 매개변수로 html 파일의 경로를 지정
//    html 파일의 경로는 templates 폴더를 기본으로 함
    ModelAndView mv = new ModelAndView("/board/boardList");

//    Service 객체를 통해서 데이터 정보 가져오기
    List<BoardDto> boardList = boardService.selectBoardList();
//    가져온 데이터 정보를 ModelAndView 객체에 저장
//    jsp의 request.setAttribute("이름", 데이터)와 같은 기능
    mv.addObject("boardList", boardList);

    mv.addObject("apple", "아이폰15");
    mv.addObject("samsung", "겔럭시S23");

    return mv;
  }

}










