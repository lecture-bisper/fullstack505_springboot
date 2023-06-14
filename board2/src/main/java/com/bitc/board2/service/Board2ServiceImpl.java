package com.bitc.board2.service;

import com.bitc.board2.dto.Board2Dto;
import com.bitc.board2.mapper.Board2Mapper;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class Board2ServiceImpl implements Board2Service {

  @Autowired
  private Board2Mapper board2Mapper;

  @Override
  public List<Board2Dto> selectBoardList() throws Exception {
    return board2Mapper.selectBoardList();
  }

  @Override
  public Board2Dto selectBoardDetail(int boardIdx) throws Exception {
    board2Mapper.updateHitCount(boardIdx);
    Board2Dto board = board2Mapper.selectBoardDetail(boardIdx);

    return board;
  }

  @Override
  public void insertBoard(Board2Dto board, MultipartHttpServletRequest uploadFiles) throws Exception {
    board2Mapper.insertBoard(board);
  }

  @Override
  public void updateBoard(Board2Dto board) throws Exception {
    board2Mapper.updateBoard(board);
  }

  @Override
  public void deleteBoard(int boardIdx) throws Exception {
    board2Mapper.deleteBoard(boardIdx);
  }
}





