package kr.ac.inha.wgcloud.cloud.controller;

import kr.ac.inha.wgcloud.emp.service.EmpService;
import kr.ac.inha.wgcloud.emp.vo.Emp;
import kr.ac.inha.wgcloud.file.service.FileService;
import kr.ac.inha.wgcloud.file.vo.FileVo;
import kr.ac.inha.wgcloud.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cloud")
public class CloudMvcController {

    private EmpService empService;
    private FileService fileService;

    @Autowired
    private CloudMvcController(EmpService empService, FileService fileService) {
    this.empService = empService;
        this.fileService = fileService;
    }

    @GetMapping("/main")
    public ModelAndView main() {
        ModelAndView mv = new ModelAndView("/cloud/main");
        return mv;
    }

    @GetMapping("/private")
    public ModelAndView privatePage() {
        ModelAndView mv = new ModelAndView("/cloud/private");
        mv.addObject("curDir", "");

        try {
            Emp emp = empService.getEmpById(AuthUtil.getLoginUserId());
            mv.addObject("files", fileService.getFileList(emp.getEmpId()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return mv;
    }

    @GetMapping("/group")
    public ModelAndView group() {
        ModelAndView mv = new ModelAndView("/cloud/group");
        return mv;
    }

    @GetMapping("/share")
    public ModelAndView share() {
        ModelAndView mv = new ModelAndView("/cloud/share");
        return mv;
    }

}