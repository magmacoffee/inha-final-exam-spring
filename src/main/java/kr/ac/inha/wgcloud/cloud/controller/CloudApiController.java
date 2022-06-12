package kr.ac.inha.wgcloud.cloud.controller;

import kr.ac.inha.wgcloud.cloud.service.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/cloud")
public class CloudApiController {

    private CloudService cloudService;

    @Autowired
    private CloudApiController(CloudService cloudService) {
        this.cloudService = cloudService;
    }

    // 둘 다 폴더id, 파일 id 필요
    @PostMapping("/folder")
    public void createNewFolder(String folderName) throws Exception {
    }

    @PostMapping("/rename")
    public void rename(String newName) throws Exception {

    }

    @GetMapping("/summary")
    public ResponseEntity<?> getSummary(Principal principal) throws Exception {
        String id = principal.getName();
        return ResponseEntity.ok(cloudService.getUserSummary(id));
    }

}
