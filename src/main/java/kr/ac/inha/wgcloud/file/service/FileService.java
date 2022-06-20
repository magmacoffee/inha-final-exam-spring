package kr.ac.inha.wgcloud.file.service;

import kr.ac.inha.wgcloud.file.vo.FileVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface FileService {
    void save(String empId, String rootId, MultipartFile multipartFile);
    void save(String empId, String rootId, String groupId, MultipartFile multipartFile);
    void mkdir(String empId, String rootId, String groupId, String name);
    void mkdir(String empId, String rootId, String name);
    void rename(String empId, String dirId, String newName);
    void remove(String empId, String dirId);
    FileVo getFileById(String dirId);
    List<FileVo> getFileList(String dirId, String empId);
    List<FileVo> getGroupFileList(String groupId, String dirId);
    List<FileVo> getRootFileList(String empId);
    List<FileVo> getGroupRootFileList(String groupId);
    List<FileVo> getShareFileList(String empId);
    List<FileVo> getFolderContent(String dirId);
    void download(String dirId, HttpServletResponse res);
    void updateShareStatus(String empId, String targetEmpId, String dirId);
}
