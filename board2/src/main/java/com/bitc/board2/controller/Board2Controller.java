package com.bitc.board2.controller;

import com.bitc.board2.dto.Board2Dto;
import com.bitc.board2.dto.UserDto;
import com.bitc.board2.service.Board2Service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/board2")
public class Board2Controller {

  @Autowired
  private Board2Service board2Service;

  @GetMapping("/")
  public String index() throws Exception {
    return "index";
  }

  @RequestMapping("/board2List.do")
  public ModelAndView board2List() throws Exception {
    ModelAndView mv = new ModelAndView("board2/board2List");

    List<Board2Dto> boardList = board2Service.selectBoardList();

    mv.addObject("boardList", boardList);

    return mv;
  }
  
  // 게시물 상세 확인 페이지
  @RequestMapping("/openBoard2Detail.do")
  public ModelAndView openBoard2Detail(@RequestParam int boardIdx, HttpServletRequest req) throws Exception {
    ModelAndView mv = new ModelAndView("board2/openBoard2Detail");

////  세션에 로그인 정보가 없을 경우 디테일 페이지를 확인할 수 없도록 수정
////    세션 정보 가져옴
//    HttpSession session = req.getSession();
//
////    가져온 정보를 사용하여 UserDto 클래스 타입의 객체를 생성
//    String userName = (String)session.getAttribute("userName");
//
////    생성한 UserDto 클래스 타입의 객체의 내용이 비었으면 View 파일을 변경
//    if (userName == null || userName.equals("")) {
////      ModelAndView 클래스 타입의 객체에 View 파일을 변경함
//      mv.setViewName("login/login");
//    }
//    else {
//      DB에 연결하여 게시물 상세 정보를 가져옴
      Board2Dto board = board2Service.selectBoardDetail(boardIdx);
      mv.addObject("board", board);
//    }

    return mv;
  }
}











