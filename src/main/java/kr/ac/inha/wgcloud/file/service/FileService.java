package kr.ac.inha.wgcloud.file.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String save(String rootId, MultipartFile multipartFile) throws Exception;
}
