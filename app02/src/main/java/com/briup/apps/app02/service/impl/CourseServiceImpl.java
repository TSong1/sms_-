package com.briup.apps.app02.service.impl;

import com.briup.apps.app02.bean.Course;
import com.briup.apps.app02.bean.extend.CourseExtend;
import com.briup.apps.app02.dao.CourseMapper;
import com.briup.apps.app02.dao.extend.CourseExtendMapper;
import com.briup.apps.app02.service.ICourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    @Resource
    private CourseMapper courseMapper;

    @Resource
    private CourseExtendMapper courseExtendMapper;

    @Override
    public List<CourseExtend> findAllWithTeacher(){
        return courseExtendMapper.findAll();
    }


    @Override
    public List<Course> query(Course course) {
        return courseMapper.query(course);
    }

    @Override
    public List<Course> findAll(){
        return courseMapper.findAll();
    }

    @Override
    public Course findById(long id){
        return courseMapper.findById(id);
    }

    @Override
    public void saveOrUpdate(Course course) throws Exception {
        if(course.getId() == null){
            courseMapper.insert(course);
        } else {
            courseMapper.update(course);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Course course = courseMapper.findById(id);
        if(course==null){
            throw new Exception("删除的用户不存在");
        }else{
            courseMapper.deleteById(id);
        }
    }
}
