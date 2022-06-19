package kr.ac.inha.wgcloud.cloud.service;

import kr.ac.inha.wgcloud.cloud.vo.UserHistory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface CloudService {
    Map<Object, Object> getUserSummary(int empId) throws Exception;
    Map<Object, Object> getShareSummary(int empId) throws Exception;
    List<UserHistory> getUserHistories(int empId) throws Exception;
}
