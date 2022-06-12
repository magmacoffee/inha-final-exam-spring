package kr.ac.inha.wgcloud.cloud.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface CloudRepository {
    Map<Object, Object> selectFileSummary(int empId) throws Exception;
}
