package com.bitc.board1.mapper;

import com.bitc.board1.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper : mybatis 라이브러리에서 제공하는 어노테이션
//데이터 베이스의 SQL문과 연동하기 위한 인터페이스
//해당 인터페이스의 추상 메소드와 xml 파일의 태그명을 1:1로 연동해주는 어노테이션
@Mapper
public interface BoardMapper {
  List<BoardDto> selectBoardList() throws Exception;
}
