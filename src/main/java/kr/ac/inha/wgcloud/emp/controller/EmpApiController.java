package kr.ac.inha.wgcloud.emp.controller;

import kr.ac.inha.wgcloud.emp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/emp")
public class EmpApiController {

    private EmpService empService;

    @Autowired
    public EmpApiController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping("/info")
    public ResponseEntity<?> getLoginEmp(Principal principal) throws Exception {
        String id = principal.getName();
        return ResponseEntity.ok(empService.getEmpById(id));
    }

}

