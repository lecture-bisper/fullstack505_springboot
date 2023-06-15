package com.bitc.board3.controller;

import com.bitc.board3.dto.BoardDto;
import com.bitc.board3.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController : @Controller + @ResponseBody 로 이루어진 어노테이션
// @Controller과 @ResponseBody 를 함께 사용해도 동일한 효과를 가짐
// ajax 통신 시 rest api 방식으로 데이터를 전송하는 컨트롤러를 만들어서 사용하면 편리함
// 리액트 사용 시 프론트엔드 부분과 백엔드 부분이 완전히 분리되어 있기 때문에 데이터를 주고 받기 위해서 ajax 통신이 필요함

//현업 mybatis, jpa
//jpa, 스프링 시큐리티
@RestController
@RequestMapping("/board3/api")
public class BoardApiController {
//  RESTful API : REST 방식과 동일한 형태로 HTTP 프로토콜을 사용하지만, 클라이언트로 전달하는 데이터가 View를 제외한 데이터만 전달하는 방식
//  예전에는 클라이언트가 컴퓨터밖에 없었기 때문에 웹 브라우저가 클라이언트의 기능을 담당했음
//  서버의 기능이 웹 서버의 기능만 주로 사용되었기 때문에 클라이언트로 전달하는 데이터가 View와 데이터 모두 필요한 형태였음
//  현재는 클라이언트가 다양한 디바이스로 동작하기 때문에 View 부분은 웹 브라우저가 반드시 필요한 것은 아니게 되어서 데이터만 전달하는 방식으로 변경되었음

  @Autowired
  private BoardService boardService;

//  rest api 방식으로 게시물 목록 출력
  @RequestMapping(value = "/board", method = RequestMethod.GET)
  public Object boardList() throws Exception {
    List<BoardDto> boardList = boardService.selectBoardList();

    return boardList;
  }

//  rest api 방식으로 게시물 상세 정보 출력
  @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.GET)
  public Object boardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
    BoardDto board = boardService.selectBoardDetail(boardIdx);

    return board;
  }

//  rest api 방식으로 게시물 등록
  @RequestMapping(value = "/board", method = RequestMethod.POST)
  public void boardInsert(@RequestBody BoardDto board) throws Exception {
    boardService.insertBoard(board);
  }

//  rest api 방식으로 게시물 수정
//  rest api 방식을 사용하여 수정 시 매개변수로 받아오는 BoardDto 타입의 boardIdx에 값이 기본값인 0이 설정되어 있음
//  @PathVariable를 사용하여 게시물 번호를 받아온 후 BoardDto 타입의 객체 board에 게시물 번호를 추가로 입력하여 사용해야 함
  @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.PUT)
  public void boardUpdate(@PathVariable("boardIdx") int boardIdx, @RequestBody BoardDto board) throws Exception {
//    매개변수로 받아온 게시물 번호를 BoardDto객체에 추가함
    board.setBoardIdx(boardIdx);
//    BoardService에서 제공하는 updateBoard() 메소드로 DB의 데이터 업데이트
    boardService.updateBoard(board);
  }

//  rest api 방식으로 게시물 삭제
  @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.DELETE)
  public void boardDelete(@PathVariable("boardIdx") int boardIdx) throws Exception {
    boardService.deleteBoard(boardIdx);
  }
}







