package com.bitc.board1.service;

import com.bitc.board1.dto.BoardDto;
import com.bitc.board1.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service : 해당 클래스가 상속받은 interface 이름으로 동작하도록 설정하는 어노테이션
@Service
public class BoardServiceImpl implements BoardService{

//  BoardMapper 인터페이스 타입의 변수 선언
  @Autowired
  private BoardMapper boardMapper;

//  부모인 BoardService에서 상속받은 메소드를 구현
  @Override
  public List<BoardDto> selectBoardList() throws Exception {
//    BoardMapper 인터페이스에서 제공하는 메소드를 실행
    return boardMapper.selectBoardList();
  }

//  게시판 상세 글 보기
  @Override
  public BoardDto selectBoardDetail(int boardIdx) throws Exception {
//    1. 컨트롤러에서 전달된 게시물 번호 가져오기
//    2. mapper를 사용하여 DB에서 지정한 게시물의 조회수 업데이트
//    3. mapper를 사용하여 DB에서 지정한 게시물 정보 가져오기
//    4. 가져온 게시물 정보를 컨트롤러로 리턴

//    전달받은 게시물 번호를 사용하여 mybatis mapper의 updateHitCount() 메소드 실행
    boardMapper.updateHitCount(boardIdx);
//    전달받은 게시물 번호를 사용하여 mybatis mapper의 selectBoardDetail() 메소드 실행
//    조회된 정보를 BoardDto 클래스 타입의 변수에 대입
    BoardDto board = boardMapper.selectBoardDetail(boardIdx);

//    저장된 정보를 컨트롤러로 리턴
    return board;
  }

  //  게시판 글 등록 구현
  @Override
  public void insertBoard(BoardDto board) throws Exception {
//    1. 컨트롤러에서 전달된 데이터 가져오기
//    2. mapper 를 사용하여 DB에 데이터 등록

//    전달받은 데이터를 매개변수로 사용하여 mybatis mapper의 insertBoard() 메소드 실행
    boardMapper.insertBoard(board);
  }

  // 게시판 글 수정
  @Override
  public void updateBoard(BoardDto board) throws Exception {
//    1. 컨트롤러에서 전달된 데이터 가져오기
//    2. mapper를 사용하여 DB의 데이터 수정하기

//    전달받은 데이터를 매개변수로 사용하여 mybatis mapper의 updateBoard() 메소드를 실행
    boardMapper.updateBoard(board);
  }

  @Override
  public void deleteBoard(int boardIdx) throws Exception {
//    1. 컨트롤러에서 전달된 게시물 번호 가져오기
//    2. mapper 를 사용하여 DB의 게시물 삭제
    
//    전달받은 게시물 번호를 매개변수로 사용하여 mybatis mapper의 deleteBoard() 메소드 실행
    boardMapper.deleteBoard(boardIdx);
  }
}
