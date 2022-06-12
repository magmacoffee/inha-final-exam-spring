package kr.ac.inha.wgcloud.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cloud")
public class CloudMvcController {

    @GetMapping("/main")
    public ModelAndView main() {
        ModelAndView mv = new ModelAndView("/cloud/main");
        return mv;
    }

    @GetMapping("/private")
    public ModelAndView privatePage() {
        ModelAndView mv = new ModelAndView("/cloud/private");
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