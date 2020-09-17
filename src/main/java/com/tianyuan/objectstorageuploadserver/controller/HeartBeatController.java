package com.tianyuan.objectstorageuploadserver.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class HeartBeatController {

    @PostMapping("/heartbeat")
    public Map<String, Object> heartbeat(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        System.out.println("token是：" + token);
        Map<String, Object> data = new HashMap<>();
        data.put("status", "normal");
        return data;
    }
}
