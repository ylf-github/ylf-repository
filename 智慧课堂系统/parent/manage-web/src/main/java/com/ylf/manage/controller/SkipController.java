package com.ylf.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SkipController {
    @RequestMapping("/{from}")
    public String skip(@PathVariable String from){   //动态跳转页面
        return from;
    }
}
