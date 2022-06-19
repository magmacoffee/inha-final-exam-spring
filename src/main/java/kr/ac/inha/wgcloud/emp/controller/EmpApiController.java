package kr.ac.inha.wgcloud.emp.controller;

import kr.ac.inha.wgcloud.common.ApiErrorCode;
import kr.ac.inha.wgcloud.common.ApiException;
import kr.ac.inha.wgcloud.emp.service.EmpService;
import kr.ac.inha.wgcloud.emp.vo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmp(@PathVariable String id) throws Exception {
        Emp emp = empService.getEmpById(id);
        return ResponseEntity.ok(emp);
    }

}

