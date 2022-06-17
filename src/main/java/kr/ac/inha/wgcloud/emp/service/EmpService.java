package kr.ac.inha.wgcloud.emp.service;

import kr.ac.inha.wgcloud.emp.vo.Emp;

public interface EmpService {
    Emp getLoginEmp() throws Exception;
    Emp getEmpById(String id) throws Exception;
    void addEmp(Emp emp) throws Exception;
}
