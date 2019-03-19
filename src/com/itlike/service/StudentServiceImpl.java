package com.itlike.service;


import com.itlike.domain.Major;
import com.itlike.domain.Student;
import com.itlike.mapper.StudentMapper;
import com.itlike.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;


    //保存学生
    @Override
    public void saveStudent(Student student,Integer num) {
        String graduated_college = student.getGraduated_college();
        System.out.println(graduated_college);
        Integer collegeis985211 = studentMapper.getCollegeis985211(graduated_college);
        if(collegeis985211!=null&&collegeis985211.equals(0)){
            student.setIs985_211(0);
        }else{
            student.setIs985_211(1);
        }
        studentMapper.insertStudent(student);
        String email = student.getEmail();
        String subject = "欢迎调剂";
        String content;
        if(student.getIs985_211()==1&&num==1){
            //985211回复   工程中心回复
            content=student.getName()+"同学，您好！非常欢迎您报读华中师范大学国家数字化学习工程技术研究中心，" +
                    "原则上达到国家A类分数线，并且符合中心的专业方向，中心就有可能接受您的调剂申请，" +
                    "中心将对调剂申请进行综合评估后确定最后参加复试的人选，有关调剂和复试的具体安排请关注网站" +
                    "（http://nercel.ccnu.edu.cn/）或拨打电话027-67867571，谢谢!";
        }else if(student.getIs985_211()==1&&num==2){
            content=student.getName()+"同学，您好！非常欢迎您报读华中师范大学" +
                    "教育大数据应用技术国家工程实验室，" +
                    "原则上达到国家A类分数线，并且符合工程实验室的专业方向，" +
                    "工程实验室就有可能接受您的调剂申请，" +
                    "工程实验室将对调剂申请进行综合评估后确定最后参加复试的人选，" +
                    "有关调剂和复试的具体安排请关注网站" +
                    "（http://nercel.ccnu.edu.cn/）或拨打电话027-67867571，谢谢!";
        }else {
            //非985211回复
            content=student.getName()+"同学，您好！由于目前申请调剂的学生很多，" +
                    "但指标有限，建议您多关注其他学校的调剂信息，谢谢！";
        }
        MailUtil.sendRichContentMail(email,subject,content);

    }


    //获得专业名称   1  为工程中心
    //              2   为大数据实验室
    @Override
    public List<String> getMajorNameByCode(Integer num) {
        String dep;
        // 1 为工程中心
        if(num!=null&&num==1){
            dep="国家数字化学习工程技术研究中心";
        }else {
            dep="教育大数据应用技术国家工程实验室";
        }
        List<Major> major = studentMapper.getMajorName(dep);
        ArrayList<String> majorName = new ArrayList<>();
        //System.out.println(major);
        for (Major o : major) {
            //System.out.println(o.getMajor_name());
            majorName.add(o.getMajor_name());
        }
        System.out.println(majorName);
        return majorName;
    }













/*
    //统计信息
    @Override
    public Map<String, Object> getInformation() {

        DecimalFormat format = new DecimalFormat("0.00");

        //   1.  获取总人数
        Integer totalStudents = studentMapper.getTotalStudents();
        //   2 . 男学生人数
        Integer studentsByM = studentMapper.getStudentsByM();
        //   3.女学生人数
        Integer studentsByW = studentMapper.getStudentsByW();
        //   4. 985 211 人数
        Integer studentsBy211985 = studentMapper.getStudentsBy211985();
        //   5 .非 985  211 人数
        Integer studentsByNot211985 = studentMapper.getStudentsByNot211985();
        //   6.调剂工程中心人数
        Integer studentsByGongCheng = studentMapper.getStudentsByGongCheng();
        //    7.调剂大数据人数
        Integer studentsByDaShuJu = studentMapper.getStudentsByDaShuJu();
        //    8.工程中心   教育技术学人数
        Integer studentsByGCJiaoYuJiShuXue = studentMapper.getStudentsByGCJiaoYuJiShuXue();
        //    9. 工程中心   计算机科学与技术
        Integer studentsByGCJiSuanJiKeXueYuJiShu = studentMapper.getStudentsByGCJiSuanJiKeXueYuJiShu();
        //    10.工程中心  教育信息技术
        Integer studentsByGCJiaoYuXinXiJiShu = studentMapper.getStudentsByGCJiaoYuXinXiJiShu();
        //    11.工程中心  软件工程
        Integer studentsByGCRuanJianGongCheng = studentMapper.getStudentsByGCRuanJianGongCheng();
        //   12.大数据   计算机科学与技术
        Integer studentsByDSJJiSuanJiKeXueYuJiShu = studentMapper.getStudentsByDSJJiSuanJiKeXueYuJiShu();
        //   13.大数据  软件工程
        Integer studentsByDSJRuanJianGongCheng = studentMapper.getStudentsByDSJRuanJianGongCheng();
        //  14. 男生比重
        //男生比重
        Double wProportion = double(studentsByM)

        HashMap<String, Object> informationMap = new HashMap<>();
        informationMap.put("总人数",totalStudents);
        informationMap.put("男生人数",studentsByM);
        informationMap.put("女生人数",studentsByW);
        informationMap.put("985211人数",studentsBy211985);
        informationMap.put("非985211人数",studentsByNot211985);
        informationMap.put("工程中心人数",studentsByGongCheng);
        informationMap.put("大数据人数",studentsByDaShuJu);
        informationMap.put("工程中心教育技术学人数",studentsByGCJiaoYuJiShuXue);
        informationMap.put("工程中心计算机科学与技术",studentsByGCJiSuanJiKeXueYuJiShu);
        informationMap.put("工程中心教育信息技术",studentsByGCJiaoYuXinXiJiShu);
        informationMap.put("工程中心软件工程",studentsByGCRuanJianGongCheng);
        informationMap.put("大数据计算机科学与技术",studentsByDSJJiSuanJiKeXueYuJiShu);
        informationMap.put("大数据软件工程",studentsByDSJRuanJianGongCheng);
        double a =542.0/6352.0*100;

        System.out.println(format.format(a));
        return informationMap;
    }
*/

}
