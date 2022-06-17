package kr.ac.inha.wgcloud.file.repository;

import kr.ac.inha.wgcloud.file.vo.FileVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileRepository {
    void insertFile(FileVo file) throws Exception;
}
