package com.Study.mvcStudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @RequestMapping(value = "guguDan")
    public String tmpl(Model model, @RequestParam(value="dan")int dan){
        model.addAttribute("list",dan);
        System.out.println("TestController들어왔어");
        return "test1";
    }
}
