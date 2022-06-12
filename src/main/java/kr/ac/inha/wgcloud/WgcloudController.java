package kr.ac.inha.wgcloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WgcloudController {

    @GetMapping("/")
    public String index() {
        return "redirect:cloud/main";
    }

}
