package com.bitc.jpatest.service;

import com.bitc.jpatest.data.dto.EmployeesDto;
import com.bitc.jpatest.data.entity.EmployeesEntity;

import java.util.List;

public interface EmployeesService {
  EmployeesEntity getEmployeeMemberInfo(int empNo);

  List<EmployeesEntity> getEmployeesMemberInfoList(String firstName);

//  사원 1명의 정보를 사원 번호로 가져옴
  EmployeesDto getMemberInfoEmpNo(int empNo);
//  사원 정보를 사원 이름을 기반으로 해서 모두 가져옴
  List<EmployeesDto> getMemberInfoListEmpName(String empName);

}
