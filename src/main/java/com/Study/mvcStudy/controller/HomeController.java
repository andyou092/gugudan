package com.Study.mvcStudy.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "확인!";
    }

    @RequestMapping(value = "guguDan")
    public String tmpl(Model model, @RequestParam(value="dan")int dan){
        model.addAttribute("list",dan);
        System.out.println("TestController들어왔어");
        return "duduDan";
    }


}
