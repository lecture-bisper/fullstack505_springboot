package com.bitc.board4.service;

import com.bitc.board4.entity.JpaBoardEntity;

import java.util.List;

public interface JpaBoardService {

  List<JpaBoardEntity> selectBoardList() throws Exception;

  void saveBoard(JpaBoardEntity board) throws Exception;

  JpaBoardEntity selectBoardDetail(int boardIdx) throws Exception;

  void deleteBoard(int boardIdx) throws Exception;
}
