package com.itlike.service;

import com.itlike.domain.Major;
import com.itlike.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentService {
    //保存学生
    public void saveStudent(Student student,Integer num);

    //获得专业名称
   public List<String> getMajorNameByCode(Integer num);

   //获得统计信息
   // public Map<String,Object> getInformation();


}
