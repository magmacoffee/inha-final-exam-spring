package kr.ac.inha.wgcloud.cloud.repository;

import kr.ac.inha.wgcloud.cloud.vo.UserHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CloudRepository {
    Map<Object, Object> selectFileSummary(int empId);
    Map<Object, Object> selectShareSummary(int empId);
    List<UserHistory> selectUserHistory(int empId);
}
