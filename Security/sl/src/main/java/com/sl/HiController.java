package com.sl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Web启动时，会生成默认用户的密码
 * Using generated security password: d030192b-87af-4b6e-a605-0bbb07112d41
 * 默认的用户为user
 */
@Controller
public class HiController {

    private final String PREFIX = "pages/";

    @GetMapping("/")
    public String index() {
        return "welcome";
    }

    @GetMapping("/userlogin")
    public String loginPage() {
        return PREFIX + "login";
    }

    @GetMapping("/level1/{path}")
    public String level1(@PathVariable("path") String path) {
        return PREFIX + "level1/" + path;
    }

    @GetMapping("/level2/{path}")
    public String level2(@PathVariable("path") String path) {
        return PREFIX + "level2/" + path;
    }

    @GetMapping("/level3/{path}")
    public String level3(@PathVariable("path") String path) {
        return PREFIX + "level3/" + path;
    }

}
