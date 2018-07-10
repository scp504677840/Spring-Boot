package com.lab;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统返回的错误JSON
 * {
 * "timestamp": "2018-07-10T11:27:51.576+0000",
 * "status": 404,
 * "error": "Not Found",
 * "message": "No message available",
 * "path": "/aaa"
 * }
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 自定义错误返回信息
     * 浏览器和客户端都返回json
     *
     * @param e Exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler
    public Map<String, Object> handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 500);
        map.put("error", "user not exist");
        map.put("path", request.getServletPath());
        map.put("message", e.getMessage());
        return map;
    }

}
