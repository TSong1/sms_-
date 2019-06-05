package com.briup.apps.app02.dao;

import com.briup.apps.app02.bean.Course;

import java.util.List;

public interface CourseMapper {

    List<Course> query(Course course);

    List<Course> findAll();
    Course findById(long id);

    void insert(Course course);
    void update(Course course);

    void deleteById(long id);
}
