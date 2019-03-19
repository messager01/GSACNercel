package com.itlike.web;


import com.itlike.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("statisticsNumbers")
    public @ResponseBody
    Map<String,Object> statisticsNumbers() {
        Map<String,Object> map=new HashMap<String,Object>();
        Integer totalStudentNum= statisticsService.statisticsNumbers();
        map.put("totalStudentNum",totalStudentNum);
        return map;
    }
    @RequestMapping("statisticsSex")
    public @ResponseBody Object statisticsSex() {//男女各自占有的人数
        Object obj=statisticsService.statisticsSex();
        return obj;
    }
    @RequestMapping("statisticsIs985_211")
    public @ResponseBody Object statisticsIs985_211() {//985/211学校各自占有的人数
       Object obj=statisticsService.statisticsIs985_211();
        return obj;
    }
    @RequestMapping("statisticsDep")
    public @ResponseBody List<Object> statisticsDep() {//国家工程中心和实验室各自的人数
        return statisticsService.statisticsDep();
    }
    @RequestMapping("statisticsMajor")
    public  @ResponseBody  List<Object> statisticsMajor() {//工程中心实验室各自占有的人数
        return statisticsService.statisticsMajor();
    }

}
