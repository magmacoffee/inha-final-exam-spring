package kr.ac.inha.wgcloud.group.service;

import kr.ac.inha.wgcloud.common.ApiErrorCode;
import kr.ac.inha.wgcloud.common.ApiException;
import kr.ac.inha.wgcloud.group.repository.GroupRepository;
import kr.ac.inha.wgcloud.group.vo.GroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<GroupVo> getGroupByEmpId(String empId){
        return groupRepository.selectGroupByEmpId(empId);
    }

    @Override
    public void addNewGroup(String addEmpId, Map<String, Object> param) {
        String name = (String) param.get("name");
        GroupVo exist = groupRepository.selectGroupByName(name);
        if (exist != null) {
            throw new ApiException(ApiErrorCode.GROUP_NAME_DUPLICATE);
        }
        GroupVo group = new GroupVo();
        group.setEmpId(addEmpId);
        group.setName(name);
        groupRepository.insertGroup(group);
        GroupVo added = groupRepository.selectGroupByName(name);
        List<Integer> empList = (List<Integer>) param.get("empList");
        // 자기 자신 추가
        groupRepository.insertGroupMember(added.getGroupId(), addEmpId);
        // 구성원 추가
        for (Integer id : empList) {
            try {
                groupRepository.insertGroupMember(added.getGroupId(), Integer.toString(id));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
