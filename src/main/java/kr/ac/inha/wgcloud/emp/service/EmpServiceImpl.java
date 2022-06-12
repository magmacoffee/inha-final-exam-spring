package kr.ac.inha.wgcloud.emp.service;

import kr.ac.inha.wgcloud.emp.repository.EmpRepository;
import kr.ac.inha.wgcloud.emp.vo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;

@Service
public class EmpServiceImpl implements EmpService {

    private EmpRepository empRepository;

    @Autowired
    public EmpServiceImpl(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    private void checkEmpData(Emp emp) throws Exception {
        String[] emptyCheck = new String[] {
                emp.getId(),
                emp.getNickname(),
                emp.getPassword(),
                emp.getPasswordCheck(),
                emp.getPhone(),
                emp.getEmail()
        };
        for (String data : emptyCheck) {
            if (StringUtils.isEmpty(data)) {
                throw new Exception("빈 칸이 존재합니다! 모든 항목을 채워주세요");
            }
        }
        Emp idExist = empRepository.selectEmpById(emp.getId());
        if (idExist != null) {
            throw new Exception("이미 존재하는 아이디 입니다.");
        }
        Emp nickExist = empRepository.selectEmpByNick(emp.getNickname());
        if (nickExist != null) {
            throw new Exception("이미 존재하는 닉네임 입니다.");
        }
        if (!emp.getPassword().equals(emp.getPasswordCheck())) {
            throw new Exception("패스워드와 패스워드 확인이 일치하지 않습니다.");
        }
    }

    @Override
    public Emp getEmpById(String id) throws Exception {
        Emp emp = empRepository.selectEmpById(id);
        // Password 정보 제거
        emp.setPassword(null);
        return emp;
    }

    @Override
    public void addEmp(Emp emp) throws Exception {
        checkEmpData(emp);
        empRepository.insertEmp(emp);
    }
}
