package com.bitc.board1.controller;

import com.bitc.board1.dto.BoardDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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

  @RequestMapping("/test2")
  public ModelAndView test2() throws Exception {
    ModelAndView mv = new ModelAndView("/thymeleaf/test2");

    BoardDto board1 = new BoardDto();
    board1.setBoardIdx(10);
    board1.setTitle("테스트 제목");
    board1.setContents("테스트 내용");
    board1.setCreateId("tester1");
    board1.setCreateDt("2023-06-07 09:29:00");
    board1.setHitCnt(10);

    mv.addObject("board", board1);

    mv.addObject("str1", "첫번째");
    mv.addObject("str2", "두번째");
    mv.addObject("str3", null);

    mv.addObject("num1", 100);
    mv.addObject("num2", 3);
    mv.addObject("num3", 11);

    mv.addObject("level", "B");

    String[] strArray = {"첫번째", "두번째", "세번째", "네번째", "다섯번째"};
    List<String> strList = new ArrayList<String>();
    strList.add("첫번째");
    strList.add("두번째");
    strList.add("세번째");
    strList.add("네번째");
    strList.add("다섯번째");

    mv.addObject("itemArray", strArray);
    mv.addObject("itemList", strList);

    BoardDto board2 = new BoardDto();
    board2.setBoardIdx(11);
    board2.setTitle("테스트 제목2");
    board2.setContents("테스트 내용2");
    board2.setCreateId("tester2");
    board2.setCreateDt("2023-06-07 12:07:00");
    board2.setHitCnt(10);

    List<BoardDto> boardList = new ArrayList<BoardDto>();
    boardList.add(board1);
    boardList.add(board2);

    List<BoardDto> boardList2 = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      BoardDto board = new BoardDto();
      board.setBoardIdx(i + 10);
      board.setTitle("제목 " + (i + 10));

      boardList2.add(board);
    }

    mv.addObject("boardList2", boardList2);

    mv.addObject("boardList", boardList);

    mv.addObject("chkVal", true);
    mv.addObject("mulVal", true);
    mv.addObject("selVal", true);

    return mv;
  }

  @RequestMapping("/test3")
  public String test3() throws Exception {
    return "/thymeleaf/test3";
  }

  @RequestMapping("/test4")
  public String test4() throws Exception {
    return "/thymeleaf/test4";
  }
}






