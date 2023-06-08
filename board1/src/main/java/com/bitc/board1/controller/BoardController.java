package com.bitc.board1.controller;

import com.bitc.board1.dto.BoardDto;
import com.bitc.board1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@Controller : 해당 클래스가 Spring MVC 패턴에서 Controller 로 동작하는 것을 설정하는 어노테이션
// @Controller, @RestController 2가지 타입이 존재함
// @Controller : 일반적인 SOAP 방식의 HTTP 응답 처리를 할 경우 사용함, get/post 2가지를 사용
// @RestController : RESTful 방식의 HTTP 응답 처리를 할 경우 사용함, get/post/put/delete 를 사용하는 방식
@Controller
@RequestMapping("/board")
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

//  클래스에 @RequestMapping을 사용했을 경우 해당 클래스의 전체 주소를 입력하고, 멤버 메소드에는 상세 주소를 입력하는 형식으로 사용할 수 있음
  @RequestMapping({"/", "/index", "/main"})
  public String index() throws Exception {
    return "index";
  }

  //  반환 타입이 ModelAndView 일 경우는 templates의 html 파일에 데이터가 포함되어 있음을 의미함
//  게시판 전체 리스트 출력
  @RequestMapping(value="/boardList.do", method = RequestMethod.GET)
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

//  @RequestParam : 클라이언트에서 전달된 파라미터값을 지정하는 어노테이션
//  파라미터 하나에 데이터 1개가 전달되는 형식일 때 사용함
//  전달되는 파라미터의 이름과 메소드 매개변수의 이름을 다르게 사용하고자 할 경우 @RequestParam 어노테이션 뒤에 (value = '파라미터명') 을 사용함
//  @RequestParam 어노테이션을 여러개 사용하여 파라미터값을 여러개 받을 수 있음
  
//  지정한 게시글 상세 보기
  @RequestMapping("/openBoardDetail.do")
  public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception {
//    1. 사용자 요청 시 매개변수로 게시물 글 번호 받아오기
//    2. 받아온 글번호를 가지고 서비스를 사용하여 게시물 정보 가져오기
//    3. 조회된 게시글 정보를 화면에 출력

//    데이터와 뷰를 동시에 가지는 ModelAndView 클래스 타입의 객체 생성
//    객체 생성과 동시에 View 파일 지정
    ModelAndView mv = new ModelAndView("/board/openBoardDetail");

//    게시물 정보를 저장할 BoardDto 클래스 타입의 변수 선언
//    서비스를 사용하여 지정한 게시물 정보를 가져옴
    BoardDto board = boardService.selectBoardDetail(boardIdx);

//    가져온 게시물 정보를 ModelAndView 클래스 타입의 객체에 저장
    mv.addObject("board", board);

//    return을 사용하여 ModelAndView 클래스 객체를 클라이언트에 전달
    return mv;
  }

//  게시판 글 쓰기 (form)
  @RequestMapping("/writeBoard.do")
  public String writeBoard() throws Exception {
//    단순 사용자 입력 페이지 출력
    return "/board/writeBoard";
  }

//  게시판 글 쓰기 (db에 insert)
//  클라이언트로부터 전달된 파일 정보를 읽어오기 위해서 MultipartHttpServletRequest 타입의 매개변수를 추가함
  @RequestMapping("/insertBoard.do")
//  public String insertBoard(@RequestParam String boardTitle, @RequestParam String boardContent, @RequestParam String createId) throws Exception {
  public String insertBoard(BoardDto board, MultipartHttpServletRequest multiPart) throws Exception {
//    1. 사용자가 입력한 내용을 전달받음
//    2. 서비스를 이용하여 DB에 insert
//    3. 목록 페이지로 리다이렉트

//    클라이언트에서 전달받은 데이터를 매개변수로 하여 서비스의 insertBoard() 메소드 실행
//    전달받은 파일 정보를 처리하기 위해서 서비스의 insertBoard 메소드에 MultipartHttpServletRequest 타입의 매개변수가 추가됨
    boardService.insertBoard(board, multiPart);

    return "redirect:/board/boardList.do";
  }

//  게시판 글 수정
  @RequestMapping("/updateBoard.do")
  public String updateBoard(BoardDto board) throws Exception {
//    1. 클라이언트에서 수정할 데이터 전달받기
//    2. 서비스를 사용하여 전달받은 데이터로 DB 내용 수정하기
//    3. 목록 페이지로 리다이렉트

//    클라이언트에서 전달받은 데이터를 매개변수로 서비스의 updateBoard()메소드 실행
    boardService.updateBoard(board);
    
//    데이터 업데이트 후 지정한 목록 페이지로 리다이렉트
    return "redirect:/board/boardList.do";
  }

//  게시판 글 삭제
  @RequestMapping("/deleteBoard.do")
  public String deleteBoard(@RequestParam int boardIdx) throws Exception {
//    1. 클라이언트에서 전달한 삭제할 게시물 번호 받아오기
//    2. 서비스를 사용하여 지정한 게시물 번호 DB에서 삭제하기
//    3. 목록 페이지로 리다이렉트
    
//    클라이언트에서 전달받은 게시물 번호를 매개변수로 서비스의 deleteBoard() 메소드 실행
    boardService.deleteBoard(boardIdx);
    
//    게시물 삭제 후 지정한 목록 페이지로 이동
    return "redirect:/board/boardList.do";
  }
}










