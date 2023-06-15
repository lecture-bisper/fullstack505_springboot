package com.bitc.board3.service;

import com.bitc.board3.dto.BoardDto;
import com.bitc.board3.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardMapper boardMapper;

  @Override
  public List<BoardDto> selectBoardList() throws Exception {
    return boardMapper.selectBoardList();
  }

  @Override
  public BoardDto selectBoardDetail(int boardIdx) throws Exception {
    boardMapper.updateHitCount(boardIdx);
    return boardMapper.selectBoardDetail(boardIdx);
  }

  @Override
  public void insertBoard(BoardDto board) throws Exception {
    boardMapper.insertBoard(board);
  }

  @Override
  public void updateBoard(BoardDto board) throws Exception {
    boardMapper.updateBoard(board);
  }

  @Override
  public void deleteBoard(int boardIdx) throws Exception {
    boardMapper.deleteBoard(boardIdx);
  }
}
