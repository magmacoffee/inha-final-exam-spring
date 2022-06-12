package kr.ac.inha.wgcloud.cloud.service;

import kr.ac.inha.wgcloud.cloud.repository.CloudRepository;
import kr.ac.inha.wgcloud.emp.repository.EmpRepository;
import kr.ac.inha.wgcloud.emp.vo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CloudServiceImpl implements CloudService {

    private CloudRepository cloudRepository;
    private EmpRepository empRepository;

    @Autowired
    public CloudServiceImpl(CloudRepository cloudRepository, EmpRepository empRepository) {
        this.cloudRepository = cloudRepository;
        this.empRepository = empRepository;
    }

    @Override
    public Map<Object, Object> getUserSummary(String loginId) throws Exception {
        Emp emp = empRepository.selectEmpById(loginId);
        return cloudRepository.selectFileSummary(emp.getEmpId());
    }
}
