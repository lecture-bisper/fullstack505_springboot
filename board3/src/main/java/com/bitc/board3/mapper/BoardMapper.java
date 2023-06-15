package com.bitc.board3.mapper;

import com.bitc.board3.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
  // 게시물 전체 목록 출력
  List<BoardDto> selectBoardList() throws Exception;

  //  게시물 상세 내용 출력
  BoardDto selectBoardDetail(@Param("boardIdx")int boardIdx) throws Exception;

  //  게시물 등록
  void insertBoard(BoardDto board) throws Exception;

  //  게시물 수정
  void updateBoard(BoardDto board) throws Exception;

  //  게시물 삭제
  void deleteBoard(int boardIdx) throws Exception;

  //  게시물 조회수 카운트
  void updateHitCount(int boardIdx) throws Exception;
}






