package com.bitc.board2.service;

import com.bitc.board2.dto.Board2Dto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface Board2Service {
//  게시판 글 목록 보기
  List<Board2Dto> selectBoardList() throws Exception;

//  게시판 글 상세 보기
  Board2Dto selectBoardDetail(int boardIdx) throws Exception;

//  게시판 글 등록
//  업로드된 파일 정보 확인을 위한 MultipartHttpServletRequest 타입의 매개변수 추가
  void insertBoard(Board2Dto board, MultipartHttpServletRequest multipart) throws Exception;

//  게시판 글 수정
  void updateBoard(Board2Dto board) throws Exception;

  //  게시판 글 삭제
  void deleteBoard(int boardIdx) throws Exception;
}
