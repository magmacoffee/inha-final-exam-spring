package kr.ac.inha.wgcloud.group.service;

import kr.ac.inha.wgcloud.group.vo.GroupVo;

import java.util.List;
import java.util.Map;

public interface GroupService {
    List<GroupVo> getGroupByEmpId(String empId) throws Exception;
    void addNewGroup(String addEmpId, Map<String, Object> param);
}
