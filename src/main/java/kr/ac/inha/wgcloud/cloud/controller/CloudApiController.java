package kr.ac.inha.wgcloud.cloud.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cloud")
public class CloudApiController {

    // 둘 다 폴더id, 파일 id 필요

    @PostMapping("/folder")
    public void createNewFolder(String folderName) throws Exception {
    }

    @PostMapping("/rename")
    public void rename(String newName) throws Exception {

    }

}
