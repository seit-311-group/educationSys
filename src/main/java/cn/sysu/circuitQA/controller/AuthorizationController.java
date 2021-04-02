package cn.sysu.circuitQA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizationController {

    @GetMapping("/callback")
    public String callback(){
        return "main";
    }
}
