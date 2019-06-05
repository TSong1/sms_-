package com.briup.apps.app02.web.controller;

import com.briup.apps.app02.bean.Course;
import com.briup.apps.app02.bean.extend.CourseExtend;
import com.briup.apps.app02.service.ICourseService;
import com.briup.apps.app02.utils.Message;
import com.briup.apps.app02.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Course course){
        List<Course> list=courseService.query(course);
        return MessageUtil.success("success",list);
    }

    @GetMapping("findAllWithTeacher")
    public Message findAllWithTeacher(){
        List<CourseExtend> list =courseService.findAllWithTeacher();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("查询所有信息")
    @GetMapping("findAll")
    public Message findAll(){
        List<Course> list =courseService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message findById(@ApiParam(value = "主键",required = true) @RequestParam(value = "id") long id){
        Course course =courseService.findById(id);
        return MessageUtil.success("success",course);
    }

    @ApiOperation("保存或更新用户信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Course course){
        try {
            courseService.saveOrUpdate(course);
            return MessageUtil.success("保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error("保存失败！"+e.getMessage());
        }
    }

    @ApiOperation("通过id删除用户")
    @GetMapping("deleteById")
    public Message deleteById(long id){
        try {
            courseService.deleteById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.success(e.getMessage());
        }
    }
}
