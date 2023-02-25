package com.example.login.controller;

import com.example.login.dto.CourseDTO;
import com.example.login.model.Course;
import com.example.login.service.CourseSevice;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("UserAPI")
public class UserAPIController {
    @Autowired
    private CourseSevice courseSevice;

    //  Xem danh sách tất cả khóa học
    @GetMapping("sreachCourse")
    public List<CourseDTO> getAll(@RequestParam(defaultValue = "",required = false) String type, @RequestParam(defaultValue = "",required = false) String name , @RequestParam(defaultValue = "",required = false)String topic){
        return courseSevice.getCourse(name,type,topic);
    };
// Xem thông tin của 1 khóa học cụ thể (thông tin bao gồm thông tin khóa học và nhân viên tư vấn)
    @GetMapping("lookCourse/{id}")
    public List<CourseDTO> sreachCoureByID(@PathVariable int id){
        return courseSevice.sreachCoursebyID(id);
    }


}



