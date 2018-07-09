package com.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1.将注解@ResponseBody加在类上：对该类中所有方法都有效
 * 2.注解@RestController是一个复合注解，其中包含@ResponseBody和@Controller注解。
 */
//@ResponseBody
//@Controller
@RestController
public class UserController {

    /**
     * 将注解@ResponseBody加在方法上：只对该方法有效
     *
     * @return
     */
    //@ResponseBody
    @RequestMapping("/hi")
    public String hi() {
        return "hi";
    }

}
