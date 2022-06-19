package kr.ac.inha.wgcloud.file.repository;

import kr.ac.inha.wgcloud.file.vo.FileVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileRepository {
    List<FileVo> selectFileList(String dirId, String empId) throws Exception;
    List<FileVo> selectGroupFileList(String groupId, String dirId) throws Exception;
    List<FileVo> selectRootFileList(String empId) throws Exception;
    List<FileVo> selectShareFileList(String empId) throws Exception;
    List<FileVo> selectGroupRootFileList(String groupId) throws Exception;
    List<FileVo> selectFolderContent(String dirId) throws Exception;
    FileVo selectFileById(String dirId) throws Exception;
    void insertFile(FileVo file) throws Exception;
    void updateName(String dirId, String newName) throws Exception;
    void deleteFile(String dirId) throws Exception;
    void updateShareStatus(String targetEmpId, String dirId) throws Exception;
}
