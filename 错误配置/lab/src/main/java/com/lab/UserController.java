package com.lab;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ViewResolver;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @ResponseBody
    @RequestMapping("/getUser")
    public String getUser() {
        String lab = "admin";
        if (lab != "root") {
            throw new UserNotExistException();
        }
        return "user";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("name", username);
            return "redirect:/main.html";
        }
        return "login";
    }

}
