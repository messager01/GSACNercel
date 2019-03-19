package com.itlike.service;

import com.itlike.domain.Student;

import java.util.List;

public interface StatisticsService {
    public Integer statisticsNumbers();
    public Object statisticsSex();
    public Object statisticsIs985_211();
    public List<Object> statisticsDep();
    public List<Object> statisticsMajor();
    public List<Student> getAllStudent();
}
