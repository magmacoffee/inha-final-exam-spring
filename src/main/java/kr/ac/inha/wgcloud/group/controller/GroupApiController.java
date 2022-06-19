package kr.ac.inha.wgcloud.group.controller;

import kr.ac.inha.wgcloud.emp.service.EmpService;
import kr.ac.inha.wgcloud.group.service.GroupService;
import kr.ac.inha.wgcloud.group.vo.GroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/group")
public class GroupApiController {

    private GroupService groupService;
    private EmpService empService;

    @Autowired
    public GroupApiController(
            GroupService groupService,
            EmpService empService
    ) {
        this.groupService = groupService;
        this.empService = empService;
    }

    @PostMapping("/")
    public void addGroup(@RequestBody Map<String, Object> param) throws Exception {
        groupService.addNewGroup(
            Integer.toString(empService.getLoginEmp().getEmpId()),
            param
        );
    }

}
