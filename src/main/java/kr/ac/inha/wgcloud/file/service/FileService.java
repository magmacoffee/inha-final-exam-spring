package kr.ac.inha.wgcloud.file.service;

import kr.ac.inha.wgcloud.file.vo.FileVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    void save(String empId, String rootId, MultipartFile multipartFile) throws Exception;
    void save(String empId, String rootId, String groupId, MultipartFile multipartFile) throws Exception;
    List<FileVo> getFileList(int empId) throws Exception;
}
