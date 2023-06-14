package com.bitc.board2.dto;

import lombok.Data;

@Data
public class Board2Dto {
  private int boardIdx;
  private String title;
  private String contents;
  private String createId;
  private String createDt;
  private String updateId;
  private String updateDt;
  private int hitCnt;
}
