package com.bitc.board2.mapper;

import com.bitc.board2.dto.Board2Dto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Board2Mapper {
  List<Board2Dto> selectBoardList() throws Exception;

  Board2Dto selectBoardDetail(int boardIdx) throws Exception;

  void insertBoard(Board2Dto board) throws Exception;

  void updateBoard(Board2Dto board) throws Exception;

  void deleteBoard(@Param("idx") int boardIdx) throws Exception;

  void updateHitCount(int boardIdx) throws Exception;
}











