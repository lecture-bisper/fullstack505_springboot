package com.bitc.board1.mapper;

import com.bitc.board1.dto.BoardDto;
import com.bitc.board1.dto.BoardFileDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper : mybatis 라이브러리에서 제공하는 어노테이션
//데이터 베이스의 SQL문과 연동하기 위한 인터페이스
//해당 인터페이스의 추상 메소드와 xml 파일의 태그명을 1:1로 연동해주는 어노테이션
@Mapper
public interface BoardMapper {
//  게시판 글 목록
  List<BoardDto> selectBoardList() throws Exception;

// 게시판 상세 글 확인
  BoardDto selectBoardDetail(int boardIdx) throws Exception;

//  게시판 글 등록
  void insertBoard(BoardDto board) throws Exception;

//  게시판 글 수정
  void updateBoard(BoardDto board) throws Exception;

//  @Param : 연결된 xml 파일에서 사용할 매개변수명을 새로 지정하는 어노테이션
//  게시판 글 삭제
  void deleteBoard(@Param("idx") int boardIdx) throws Exception;

//  게시물 조회수 업데이트
  void updateHitCount(int boardIdx) throws Exception;

  void insertBoardFileList(List<BoardFileDto> fileList) throws Exception;

  List<BoardFileDto> selectBoardFileList(int boardIdx) throws Exception;

  BoardFileDto selectBoardFileInfo(@Param("idx") int idx, @Param("boardIdx") int boardIdx) throws Exception;
}











