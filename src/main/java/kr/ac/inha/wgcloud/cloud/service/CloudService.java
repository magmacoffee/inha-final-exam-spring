package kr.ac.inha.wgcloud.cloud.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudService {
    Map<Object, Object> getUserSummary(String loginId) throws Exception;
    Map<Object, Object> getShareSummary(int empId) throws Exception;
}
