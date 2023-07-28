package com.bitc.jpatest.service;

import com.bitc.jpatest.data.dto.EmployeesDto;
import com.bitc.jpatest.data.entity.EmployeesEntity;
import com.bitc.jpatest.data.repository.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeesServiceImpl implements EmployeesService{

  private final EmployeesRepository empRepo;

  @Override
  public EmployeesEntity getEmployeeMemberInfo(int empNo) {
    Optional<EmployeesEntity> empInfo = empRepo.findByEmpNo(10001);

    if (empInfo.isPresent()) {
      EmployeesEntity emp = empInfo.get();
      return emp;
    }
    else {
      return null;
    }
  }

  @Override
  public List<EmployeesEntity> getEmployeesMemberInfoList(String firstName) {
    List<EmployeesEntity> empList = empRepo.findAllByFirstName(firstName);
    return empList;
  }

  @Override
  public EmployeesDto getMemberInfoEmpNo(int empNo) {
    Optional<EmployeesEntity> empInfo = empRepo.findByEmpNo(empNo);

    EmployeesDto member = new EmployeesDto();
    member.setEmpNo(empInfo.get().getEmpNo());
    member.setEmpName(empInfo.get().getFirstName() + empInfo.get().getLastName());
    member.setEmpGender(empInfo.get().getGender());

    return member;
  }

  @Override
  public List<EmployeesDto> getMemberInfoListEmpName(String empName) {
    List<EmployeesDto> memberList = new ArrayList<>();

    List<EmployeesEntity> empList = empRepo.findAllByFirstName(empName);

    for (EmployeesEntity item : empList) {
      EmployeesDto member = new EmployeesDto();
      member.setEmpNo(item.getEmpNo());
      member.setEmpName(item.getFirstName() + item.getLastName());
      member.setEmpGender(item.getGender());

      memberList.add(member);
    }

    return memberList;
  }
}
