package kr.ac.inha.wgcloud.cloud.controller;

import kr.ac.inha.wgcloud.cloud.service.CloudService;
import kr.ac.inha.wgcloud.common.ApiException;
import kr.ac.inha.wgcloud.common.ApiErrorCode;
import kr.ac.inha.wgcloud.emp.service.EmpService;
import kr.ac.inha.wgcloud.emp.vo.Emp;
import kr.ac.inha.wgcloud.file.service.FileService;
import kr.ac.inha.wgcloud.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/api/cloud")
public class CloudApiController {

    private CloudService cloudService;
    private FileService fileService;
    private EmpService empService;

    @Autowired
    private CloudApiController(CloudService cloudService, FileService fileService, EmpService empService) {
        this.cloudService = cloudService;
        this.fileService = fileService;
        this.empService = empService;
    }

    @PostMapping("/folder")
    public void createNewFolder(@RequestBody Map<String, Object> param) throws Exception {
        fileService.mkdir(
            Integer.toString(empService.getLoginEmp().getEmpId()),
            (String) param.get("rootId"),
            (String) param.get("folderName")
        );
    }

    @PostMapping("/group/folder")
    public void createGroupFolder(@RequestBody Map<String, Object> param) throws Exception {
        fileService.mkdir(
            Integer.toString(empService.getLoginEmp().getEmpId()),
            (String) param.get("rootId"),
            (String) param.get("groupId"),
            (String) param.get("folderName")
        );
    }


    @PostMapping("/rename")
    public void rename(@RequestBody Map<String, Object> param) throws Exception {
        fileService.rename(
            Integer.toString(empService.getLoginEmp().getEmpId()),
            (String) param.get("dirId"),
            (String) param.get("newName")
        );
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(MultipartFile file) throws Exception {
        return upload(null, file);
    }

    @PostMapping("/upload/{rootId}")
    public ResponseEntity<?> upload(@PathVariable String rootId, MultipartFile file) throws Exception {
        Emp emp = empService.getEmpById(AuthUtil.getLoginUserId());
        fileService.save(Integer.toString(emp.getEmpId()), rootId, file);
        return ResponseEntity.ok(null);
    }


    @PostMapping("/group/upload/{groupId}")
    public ResponseEntity<?> uploadToGroup(@PathVariable String groupId, MultipartFile file) throws Exception {
        return uploadToGroup(groupId, null, file);
    }

    @PostMapping("/group/upload/{groupId}/{rootId}")
    public ResponseEntity<?> uploadToGroup(@PathVariable String groupId, @PathVariable String rootId, MultipartFile file) throws Exception {
        Emp emp = empService.getEmpById(AuthUtil.getLoginUserId());
        fileService.save(Integer.toString(emp.getEmpId()), rootId, groupId, file);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/summary")
    public ResponseEntity<?> getSummary(Principal principal) throws Exception {
        return ResponseEntity.ok(cloudService.getUserSummary(empService.getLoginEmp().getEmpId()));
    }

    @DeleteMapping("/file")
    public void deleteFile(@RequestParam String dirId) throws Exception {
        fileService.remove(
            Integer.toString(empService.getLoginEmp().getEmpId()),
            dirId
        );
    }

    @GetMapping("/download/{dirId}")
    public void download(HttpServletResponse res, @PathVariable String dirId) throws Exception {
        try {
            fileService.download(dirId, res);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @GetMapping("/folder/{dirId}")
    public ResponseEntity<?> getFolderContent(@PathVariable String dirId) throws Exception {
        return ResponseEntity.ok(fileService.getFolderContent(dirId));
    }

    @PostMapping("/share/{dirId}")
    public void share(@PathVariable String dirId, @RequestBody Map<String, Object> param) throws Exception {
        String targetEmpId = (String) param.get("empId");
        Emp emp = empService.getEmpById(targetEmpId);
        if (emp == null) {
            throw new ApiException(ApiErrorCode.EMP_NOT_EXISTS);
        }
        fileService.updateShareStatus(
            Integer.toString(empService.getLoginEmp().getEmpId()),
            Integer.toString(emp.getEmpId()),
            dirId
        );
    }

}
