package kr.ac.inha.wgcloud.cloud.service;

import kr.ac.inha.wgcloud.cloud.repository.CloudRepository;
import kr.ac.inha.wgcloud.cloud.vo.UserHistory;
import kr.ac.inha.wgcloud.emp.repository.EmpRepository;
import kr.ac.inha.wgcloud.emp.vo.Emp;
import kr.ac.inha.wgcloud.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class CloudServiceImpl implements CloudService {

    private CloudRepository cloudRepository;
    private EmpRepository empRepository;
    private FileService fileService;

    @Autowired
    public CloudServiceImpl(CloudRepository cloudRepository, EmpRepository empRepository, FileService fileService) {
        this.cloudRepository = cloudRepository;
        this.empRepository = empRepository;
        this.fileService = fileService;
    }

    @Override
    public Map<Object, Object> getUserSummary(int empId) {
        return cloudRepository.selectFileSummary(empId);
    }

    @Override
    public Map<Object, Object> getShareSummary(int empId) {
        return cloudRepository.selectShareSummary(empId);
    }

    @Override
    public List<UserHistory> getUserHistories(int empId) {
        return cloudRepository.selectUserHistory(empId);
    }

}
