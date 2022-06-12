package kr.ac.inha.wgcloud.cloud.service;

import java.util.Map;

public interface CloudService {
    Map<Object, Object> getUserSummary(String loginId) throws Exception;
}
