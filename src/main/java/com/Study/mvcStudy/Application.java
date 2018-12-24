package com.Study.mvcStudy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.Study.mvcStudy.controller")
public class Application  {
    @Autowired


    public static void main(String arg[]){
        System.out.println("들어왔어메인");
        SpringApplication.run(Application.class, arg);
    }


}
