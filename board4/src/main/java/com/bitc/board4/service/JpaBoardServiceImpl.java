package com.bitc.board4.service;

import com.bitc.board4.entity.JpaBoardEntity;
import com.bitc.board4.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @RequiredArgsConstructor : @Autowired 어노테이션 대신 사용
@RequiredArgsConstructor
@Service
public class JpaBoardServiceImpl implements JpaBoardService{
  
//  데이터베이스에 명령어를 전달하는 인터페이스
//  mybatis에서 Mapper 인터페이스 및 xml 파일과 동일한 역할을 함
  private final JpaBoardRepository jpaBoardRepository;

  @Override
  public List<JpaBoardEntity> selectBoardList() throws Exception {
    return jpaBoardRepository.findAllByOrderByBoardIdxDesc();
  }
}
