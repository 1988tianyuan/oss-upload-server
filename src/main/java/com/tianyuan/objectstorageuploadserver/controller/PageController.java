package com.tianyuan.objectstorageuploadserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({"/index", "/"})
    public String index() {
        return "index_page";
    }
}
