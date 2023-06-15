package com.bitc.board3.controller;

import com.bitc.board3.dto.BoardDto;
import com.bitc.board3.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/board3")
public class BoardController {
//  RESTful이란 : 자원의 이름으로 구분하여 해당 자원의 정보를 주고 받는 것
//  HTTP URI를 통해 자원을 명시하고 HTTP Method(GET, POST, PUT, DELETE)를 통해 자원에 대한 CRUD 명령을 적용하는 것

//  URI : Uniform Resource Identifier 의 줄임말, 자원 식별자
//  URL : Uniform Resource Locator 의 줄임말, 자원의 위치
//  현재는 거의 같은 의미로 사용함
  
//  RESTfull 방식은 데이터를 전송하는 방법을 지정함
//  HttpMethod를 사용하여 GET(조회), POST(입력), PUT(수정), DELETE(삭제)로 구분하여 사용함
//  @RequestMapping 어노테이션 사용 시 URI 를 value 속성을 사용하여 설정하고, method 속성을 사용하여 GET, POST, PUT, DELETE를 설정
//  @GetMapping, @PostMapping, @PutMapping, @DeleteMapping 를 사용하여 구분해도 됨

//  전체 URL 생성 방법 :
//  서버URL:포트번호/기본 주소/추가주소or게시물번호/게시물번호

  @Autowired
  private BoardService boardService;

  // 게시물 전체 목록 출력
  @RequestMapping(value = "/board3/", method = RequestMethod.GET)
  public ModelAndView boardList() throws Exception {
    ModelAndView mv = new ModelAndView("board3/boardList");

    List<BoardDto> boardList = boardService.selectBoardList();
    mv.addObject("boardList", boardList);

    return mv;
  }

//  게시물 상세 내용 보기
//  {boardIdx} : 게시물 번호, 해당 게시물 번호에 대한 자원에 접근, 데이터를 의미
//  @PathVariable : 지정한 자원의 이름과 Controller가 가지고 있는 메소드의 매개변수명을 매칭시켜주는 어노테이션, 해당 자원의 데이터를 가져와서 메소드의 매개변수에 저장함
  @RequestMapping(value = "/board3/{boardIdx}", method = RequestMethod.GET)
  public ModelAndView boardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
    ModelAndView mv = new ModelAndView("board3/boardDetail");

    BoardDto board = boardService.selectBoardDetail(boardIdx);
    mv.addObject("board", board);

    return mv;
  }

//  게시물 등록, 사용자 입력 페이지
  @RequestMapping(value = "/board3/insert", method = RequestMethod.GET)
  public String boardInsertView() throws Exception {
    return "board3/boardWrite";
  }

//  게시물 등록, 내부 프로세스
  @RequestMapping(value = "/board3/insert", method = RequestMethod.POST)
  public String boardInsertProcess(BoardDto board) throws Exception {
    boardService.insertBoard(board);

    return "redirect:/board3/";
  }

//  게시물 수정
  @RequestMapping(value = "/board3/{boardIdx}", method = RequestMethod.PUT)
  public String boardUpdate(BoardDto board) throws Exception {
    boardService.updateBoard(board);

    return "redirect:/board3/";
  }

//  게시물 삭제
  @RequestMapping(value = "/board3/{boardIdx}", method = RequestMethod.DELETE)
  public String boardDelete(@PathVariable("boardIdx") int boardIdx) throws Exception {
    boardService.deleteBoard(boardIdx);

    return "redirect:/board3/";
  }
}


