package com.bitc.board1.service;

import com.bitc.board1.dto.BoardDto;
import com.bitc.board1.dto.BoardFileDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface BoardService {
//  게시판 글 목록 보기
  List<BoardDto> selectBoardList() throws Exception;

//  게시판 글 상세 보기
  BoardDto selectBoardDetail(int boardIdx) throws Exception;

//  게시판 글 등록
//  업로드된 파일 정보 확인을 위한 MultipartHttpServletRequest 타입의 매개변수 추가
  void insertBoard(BoardDto board, MultipartHttpServletRequest multipart) throws Exception;

//  게시판 글 수정
  void updateBoard(BoardDto board) throws Exception;

  //  게시판 글 삭제
  void deleteBoard(int boardIdx) throws Exception;

//  다운로드할 파일 정보 가져오기
  BoardFileDto selectBoardFileInfo(int idx, int boardIdx) throws Exception;
}
