package kr.ac.inha.wgcloud.file.service;

import kr.ac.inha.wgcloud.file.vo.FileVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface FileService {
    void save(String empId, String rootId, MultipartFile multipartFile) throws Exception;
    void save(String empId, String rootId, String groupId, MultipartFile multipartFile) throws Exception;
    void mkdir(String empId, String rootId, String groupId, String name) throws Exception;
    void mkdir(String empId, String rootId, String name) throws Exception;
    void rename(String empId, String dirId, String newName) throws Exception;
    void remove(String empId, String dirId) throws Exception;
    FileVo getFileById(String dirId) throws Exception;
    List<FileVo> getFileList(String dirId, String empId) throws Exception;
    List<FileVo> getRootFileList(String empId) throws Exception;
    List<FileVo> getShareFileList(String empId) throws Exception;
    List<FileVo> getFolderContent(String dirId) throws Exception;
    void download(String dirId, HttpServletResponse res) throws Exception;
    void updateShareStatus(String empId, String targetEmpId, String dirId) throws Exception;
}
