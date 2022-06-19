package kr.ac.inha.wgcloud.group.repository;

import kr.ac.inha.wgcloud.group.vo.GroupVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupRepository {
    List<GroupVo> selectGroupByEmpId(String empId);
    GroupVo selectGroupByName(String name);
    void insertGroup(GroupVo groupVo);
    void insertGroupMember(String groupId, String empId);
}
