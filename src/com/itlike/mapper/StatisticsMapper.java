package com.itlike.mapper;

import com.itlike.domain.Student;

import java.util.List;

public interface StatisticsMapper {
     Integer statisticsNumbers();
     Object statisticsSex();
    Object statisticsIs985_211();
    List<Object> statisticsDep();
    List<Object> statisticsMajor();
    public List<Student> getAllStudents();
}
