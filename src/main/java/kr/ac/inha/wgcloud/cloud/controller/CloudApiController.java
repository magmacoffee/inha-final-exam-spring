package kr.ac.inha.wgcloud.cloud.controller;

import kr.ac.inha.wgcloud.cloud.service.CloudService;
import kr.ac.inha.wgcloud.emp.service.EmpService;
import kr.ac.inha.wgcloud.emp.vo.Emp;
import kr.ac.inha.wgcloud.file.service.FileService;
import kr.ac.inha.wgcloud.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

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

    // 둘 다 폴더id, 파일 id 필요
    @PostMapping("/folder")
    public void createNewFolder(String folderName) throws Exception {
    }

    @PostMapping("/rename")
    public void rename(String newName) throws Exception {

    }

    @PostMapping("/upload/{rootId}")
    public ResponseEntity<?> upload(@PathVariable String rootId, MultipartFile file) throws Exception {
        Emp emp = empService.getEmpById(AuthUtil.getLoginUserId());
        rootId = rootId.equals("root") ? null : rootId;
        fileService.save(Integer.toString(emp.getEmpId()), rootId, file);
        return ResponseEntity.ok(null);
    }


    @GetMapping("/summary")
    public ResponseEntity<?> getSummary(Principal principal) throws Exception {
        String id = principal.getName();
        return ResponseEntity.ok(cloudService.getUserSummary(id));
    }

}
