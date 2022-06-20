package kr.ac.inha.wgcloud.emp.service;

import kr.ac.inha.wgcloud.emp.vo.Emp;

public interface EmpService {
    Emp getLoginEmp();
    Emp getEmpById(String id);
    void addEmp(Emp emp);
}
