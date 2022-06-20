package kr.ac.inha.wgcloud.emp.service;

import kr.ac.inha.wgcloud.common.ApiErrorCode;
import kr.ac.inha.wgcloud.common.ApiException;
import kr.ac.inha.wgcloud.emp.repository.EmpRepository;
import kr.ac.inha.wgcloud.emp.vo.Emp;
import kr.ac.inha.wgcloud.util.AuthUtil;
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

    private void checkEmpData(Emp emp) {
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
                throw new ApiException(ApiErrorCode.HAS_EMPTY_DATA);
            }
        }
        Emp idExist = empRepository.selectEmpById(emp.getId());
        if (idExist != null) {
            throw new ApiException(ApiErrorCode.ID_EXISTS);
        }
        Emp nickExist = empRepository.selectEmpByNick(emp.getNickname());
        if (nickExist != null) {
            throw new ApiException(ApiErrorCode.NICK_EXISTS);
        }
        if (!emp.getPassword().equals(emp.getPasswordCheck())) {
            throw new ApiException(ApiErrorCode.PWD_CHECK_DIFFERENT);
        }
    }

    @Override
    public Emp getLoginEmp() {
        return getEmpById(AuthUtil.getLoginUserId());
    }

    @Override
    public Emp getEmpById(String id) {
        Emp emp = empRepository.selectEmpById(id);
        if (emp == null) { return null; }
        // Password 정보 제거
        emp.setPassword(null);
        return emp;
    }

    @Override
    public void addEmp(Emp emp) {
        checkEmpData(emp);
        empRepository.insertEmp(emp);
    }
}
