package com.ylf.manage.controller;

import com.ylf.manage.entity.Score;
import com.ylf.manage.iservice.Score_iserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ScoreController {
    @Autowired
    private Score_iserv service;

    @RequestMapping("/score/list")
    @ResponseBody
    @CrossOrigin
    public List<Score> getCourseScore(String c_id){        //返回某课程全部经验值对象
        return service.findCourseScore(c_id);
    }
}
