package com.bitc.board1.service;

import com.bitc.board1.dto.BoardDto;

import java.util.List;

public interface BoardService {
  List<BoardDto> selectBoardList() throws Exception;

}
