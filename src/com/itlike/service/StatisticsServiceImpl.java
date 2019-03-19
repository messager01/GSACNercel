package com.itlike.service;

import com.itlike.domain.Student;
import com.itlike.mapper.StatisticsMapper;
import com.sun.org.glassfish.external.statistics.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("StatisticsService")
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StatisticsMapper StatisticsMapper;

    @Override
    public Integer statisticsNumbers() {//有多少学生登记信息
        return StatisticsMapper.statisticsNumbers();
    }

    @Override
    public Object statisticsSex() {//男女各自占有的人数
        return StatisticsMapper.statisticsSex();
    }

    @Override
    public Object statisticsIs985_211() {//985/211学校各自占有的人数
        return StatisticsMapper.statisticsIs985_211();
    }

    @Override
    public List<Object> statisticsDep() {//国家工程中心和实验室各自的人数
        return StatisticsMapper.statisticsDep();
    }

    @Override
    public List<Object> statisticsMajor() {//工程中心实验室各自占有的人数
        return StatisticsMapper.statisticsMajor();
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = StatisticsMapper.getAllStudents();
        return students;
    }
}
