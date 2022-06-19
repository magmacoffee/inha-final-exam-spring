package kr.ac.inha.wgcloud.cloud.controller;

import kr.ac.inha.wgcloud.cloud.service.CloudService;
import kr.ac.inha.wgcloud.emp.service.EmpService;
import kr.ac.inha.wgcloud.emp.vo.Emp;
import kr.ac.inha.wgcloud.file.service.FileService;
import kr.ac.inha.wgcloud.file.vo.FileVo;
import kr.ac.inha.wgcloud.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cloud")
public class CloudMvcController {

    private EmpService empService;
    private FileService fileService;
    private CloudService cloudService;

    @Autowired
    private CloudMvcController(EmpService empService, FileService fileService, CloudService cloudService) {
        this.empService = empService;
        this.fileService = fileService;
        this.cloudService = cloudService;
    }

    @GetMapping("/main")
    public ModelAndView main() throws Exception {
        ModelAndView mv = new ModelAndView("/cloud/main");
        Map<Object, Object> summary = cloudService.getUserSummary(empService.getLoginEmp().getId());
        mv.addObject("fileCount", summary.get("fileCount"));
        mv.addObject("fileTotalSize", summary.get("fileTotalSize"));
        return mv;
    }

    @GetMapping("/private")
    public ModelAndView privatePage() {
        ModelAndView mv = new ModelAndView("/cloud/private");
        mv.addObject("curDir", "");
        try {
            Emp emp = empService.getEmpById(AuthUtil.getLoginUserId());
            mv.addObject("curDir", "/");
            mv.addObject("curDirId", null);
            mv.addObject("rootDirId", null);
            mv.addObject("files", fileService.getRootFileList(Integer.toString(emp.getEmpId())));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mv;
    }

    @GetMapping("/private/{dirId}")
    public ModelAndView privatePage(@PathVariable String dirId) {
        ModelAndView mv = new ModelAndView("/cloud/private");
        try {
            FileVo root = fileService.getFileById(dirId);
            if (root == null) {
                return new ModelAndView("/error/401");
            } else if (!root.getEmpId().equals(Integer.toString(empService.getLoginEmp().getEmpId()))) { // 타인 폴더 접근 방지
                return new ModelAndView("/error/401");
            }
            Emp emp = empService.getEmpById(AuthUtil.getLoginUserId());
            mv.addObject("curDir", root.getFilePath());
            mv.addObject("curDirId", root.getDirId());
            mv.addObject("rootDirId", root.getRootDirId());
            mv.addObject("files", fileService.getFileList(Integer.toString(root.getDirId()), Integer.toString(emp.getEmpId())));
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
        try {
            Emp emp = empService.getLoginEmp();
            List<FileVo> shareFileList = fileService.getShareFileList(Integer.toString(emp.getEmpId()));
            Map<Object, Object> map = cloudService.getShareSummary(empService.getLoginEmp().getEmpId());
            mv.addObject("shareCount", map.get("fileCount"));
            mv.addObject("files", shareFileList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mv;
    }

}