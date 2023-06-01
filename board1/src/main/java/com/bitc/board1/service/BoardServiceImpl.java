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
}
