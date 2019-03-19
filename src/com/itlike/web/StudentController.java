package com.itlike.web;

import com.itlike.domain.Student;
import com.itlike.mapper.StudentMapper;
import com.itlike.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    //添加学生
    @RequestMapping(value = "saveStudent",method = RequestMethod.POST)
    //num 为 学院代码   1  为工程中心   2为  大数据实验室
    public @ResponseBody
    String saveStudent(Student student,Integer num){
        if(num!=null&&num==1){
            student.setAdjustment_dep("国家数字化学习工程技术研究中心");
        }else{
            student.setAdjustment_dep("教育大数据应用技术国家工程实验室");
        }
        String code="0";
        try {
            studentService.saveStudent(student,num);
        }catch (Exception e){
            System.out.println(e.toString());
            code="1";
        }
        return code;
    }

    //获取专业名称
    @RequestMapping("getmajorByCode")
    public @ResponseBody List<String>  getmajorByCode(Integer num){
        List<String> majorNameByCode = studentService.getMajorNameByCode(num);
        //model.addAttribute("majorNameByCode",majorNameByCode);
        return majorNameByCode;
    }





/*
    //获取统计信息
    @RequestMapping("statisticsInformation")
    public String statisticsInformation(Model model){
        Map<String, Object> information = studentService.getInformation();
        model.addAttribute(information);
        for (Map.Entry<String, Object> stringStringEntry : information.entrySet()) {
            System.out.println(stringStringEntry);
        }
        return "result";
    }*/
}
