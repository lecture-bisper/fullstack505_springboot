package com.bitc.board1.service;

import com.bitc.board1.dto.BoardDto;

import java.util.List;

public interface BoardService {
//  게시판 글 목록 보기
  List<BoardDto> selectBoardList() throws Exception;

//  게시판 글 상세 보기
  BoardDto selectBoardDetail(int boardIdx) throws Exception;

//  게시판 글 등록
  void insertBoard(BoardDto board) throws Exception;

//  게시판 글 수정
  void updateBoard(BoardDto board) throws Exception;

  //  게시판 글 삭제
  void deleteBoard(int boardIdx) throws Exception;

}
