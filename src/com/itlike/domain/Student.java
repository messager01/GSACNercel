package com.itlike.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class Student {
    private Integer id;
    private String name;    //学生姓名
    private String sex;      //学生性别
    private String nationality;     //名族
    private String number;          //考生号
    private String id_card;         //身份证号
    private String graduated_college;     //本科毕业院校
    private String graduated_major;       //本科毕业专业
    private String telnumber;               //联系电话
    private String email;                 //邮箱
    private String first_applicant_name;         //第一志愿报考单位
    private String first_major_code;             //第一志愿报考专业代码
    private String first_major_name;             //第一志愿报考专业名称

    private String total_score;                  //总成绩
    private String political_score;             //政治
    private String english_score;                 //英语


    private String major_1_name;                    //专业课1名称

    private String major_1_score;                  //专业课1成绩

    private String major_2_name;                    //专业课2名称

    private String major_2_score;                  //专业课2成绩

    private String adjustment_dep;                  //调剂院系
    private String adjustment_major;               //调剂专业
    private String access_information="无";             //获得信息渠道
    private Integer is985_211;                      //本科是否为985或211

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getGraduated_college() {
        return graduated_college;
    }

    public void setGraduated_college(String graduated_college) {
        this.graduated_college = graduated_college;
    }

    public String getGraduated_major() {
        return graduated_major;
    }

    public void setGraduated_major(String graduated_major) {
        this.graduated_major = graduated_major;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_applicant_name() {
        return first_applicant_name;
    }

    public void setFirst_applicant_name(String first_applicant_name) {
        this.first_applicant_name = first_applicant_name;
    }

    public String getFirst_major_code() {
        return first_major_code;
    }

    public void setFirst_major_code(String first_major_code) {
        this.first_major_code = first_major_code;
    }

    public String getFirst_major_name() {
        return first_major_name;
    }

    public void setFirst_major_name(String first_major_name) {
        this.first_major_name = first_major_name;
    }

    public String getTotal_score() {
        return total_score;
    }

    public void setTotal_score(String total_score) {
        this.total_score = total_score;
    }

    public String getPolitical_score() {
        return political_score;
    }

    public void setPolitical_score(String political_score) {
        this.political_score = political_score;
    }

    public String getEnglish_score() {
        return english_score;
    }

    public void setEnglish_score(String english_score) {
        this.english_score = english_score;
    }

    public String getMajor_1_name() {
        return major_1_name;
    }

    public void setMajor_1_name(String major_1_name) {
        this.major_1_name = major_1_name;
    }

    public String getMajor_1_score() {
        return major_1_score;
    }

    public void setMajor_1_score(String major_1_score) {
        this.major_1_score = major_1_score;
    }

    public String getMajor_2_name() {
        return major_2_name;
    }

    public void setMajor_2_name(String major_2_name) {
        this.major_2_name = major_2_name;
    }

    public String getMajor_2_score() {
        return major_2_score;
    }

    public void setMajor_2_score(String major_2_score) {
        this.major_2_score = major_2_score;
    }

    public String getAdjustment_dep() {
        return adjustment_dep;
    }

    public void setAdjustment_dep(String adjustment_dep) {
        this.adjustment_dep = adjustment_dep;
    }

    public String getAdjustment_major() {
        return adjustment_major;
    }

    public void setAdjustment_major(String adjustment_major) {
        this.adjustment_major = adjustment_major;
    }

    public String getAccess_information() {
        return access_information;
    }

    public void setAccess_information(String access_information) {
        this.access_information = access_information;
    }

    public Integer getIs985_211() {
        return is985_211;
    }

    public void setIs985_211(Integer is985_211) {
        this.is985_211 = is985_211;
    }
}
