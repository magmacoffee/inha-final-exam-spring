package kr.ac.inha.wgcloud.file.repository;

import kr.ac.inha.wgcloud.file.vo.FileVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileRepository {
    List<FileVo> selectFileList(String dirId, String empId);
    List<FileVo> selectGroupFileList(String groupId, String dirId);
    List<FileVo> selectRootFileList(String empId);
    List<FileVo> selectShareFileList(String empId);
    List<FileVo> selectGroupRootFileList(String groupId);
    List<FileVo> selectFolderContent(String dirId);
    FileVo selectFileById(String dirId);
    void insertFile(FileVo file);
    void updateName(String dirId, String newName);
    void deleteFile(String dirId);
    void updateShareStatus(String targetEmpId, String dirId);
}
