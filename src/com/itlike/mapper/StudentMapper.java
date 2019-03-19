package com.itlike.mapper;

import com.itlike.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    //保存学生
    public void insertStudent(Student student);
        //判断是否为985/211
    public Integer getCollegeis985211(@Param("graduatedcollege") String graduatedcollege);

    //获得专业名称
    public List getMajorName(@Param("dep") String dep);

    //有多少学生登记信息
    public Integer getTotalStudents();

    //男学生
    public Integer getStudentsByM();

    //女学生
    public Integer getStudentsByW();

    //211985人数
    public Integer getStudentsBy211985();

    //非985  211 人数
    public Integer getStudentsByNot211985();

    //调剂工程中心人数
    public Integer getStudentsByGongCheng();

    //调剂大数据总人数
    public Integer  getStudentsByDaShuJu();

    //工程中心  教育技术学  人数
    public Integer getStudentsByGCJiaoYuJiShuXue();

    //工程中心  计算机科学与技术  人数
    public Integer getStudentsByGCJiSuanJiKeXueYuJiShu();

    //工程中心  教育信息技术  人数
    public Integer getStudentsByGCJiaoYuXinXiJiShu();

    //工程中心  软件工程人数
    public Integer getStudentsByGCRuanJianGongCheng();

    //大数据  计算机科学与技术人数
    public Integer getStudentsByDSJJiSuanJiKeXueYuJiShu();

    //大数据软件工程  人数
    public Integer getStudentsByDSJRuanJianGongCheng();

}
