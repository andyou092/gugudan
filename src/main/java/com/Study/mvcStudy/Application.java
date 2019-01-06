package com.Study.mvcStudy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@MapperScan("com.Study.mvcStudy.controller")
public class Application  {
    @Autowired
    public static void main(String arg[]){
        System.out.println("들어왔어메인");
        SpringApplication.run(Application.class , arg);
    }

  /* @RequestMapping(value = "/guDan")
    public String guDasn(Model model, @RequestParam(value="dan")int dan){
        model.addAttribute("list",dan);
        System.out.println("TestController들어왔어");
        return "guDan";
    }*/




}
