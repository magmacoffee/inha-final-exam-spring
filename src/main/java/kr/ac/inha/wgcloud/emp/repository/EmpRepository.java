package kr.ac.inha.wgcloud.emp.repository;

import kr.ac.inha.wgcloud.emp.vo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface EmpRepository {
    Emp selectEmpById(String id) throws Exception;
    Emp selectEmpByNick(String nick) throws Exception;
    void insertEmp(Emp emp) throws Exception;
}
