package com.example.demo.controller;


import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class HomeController {

    @RequestMapping("/")
    public Map<String,Object> home(){
        Map<String,Object> map=new HashMap<>();
        map.put("msg", "欢迎使用Visual Studio Code!");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        System.out.println("执行成功1");
        return map;
    }

    @RequestMapping("/test")
    public String test(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp+" 测试方法";
    }
}
