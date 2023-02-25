package com.example.login.controller;

import com.example.login.dto.CourseDTO;
import com.example.login.model.Course;
import com.example.login.model.Page;
import com.example.login.resquest.UpsertCourseRequest;
import com.example.login.service.CourseSevice;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/courses")
public class AdminController {
    @Autowired
    private CourseSevice courseSevice;
// Tạo mới khóa Học
    @PostMapping("create")
    public CourseDTO createCourse(@RequestBody UpsertCourseRequest request) {
        return courseSevice.createCousre(request);
    }
    // Lấy chỉ tiết khóa học
    @GetMapping("{id}")
    public List<CourseDTO> getCourseByID(@PathVariable int id){
     return courseSevice.sreachCoursebyID(id);
    }

  //   Cập nhật thông tin khóa học
    @PutMapping("update/{id}")
    public CourseDTO updateCourse(@PathVariable int id,@RequestBody UpsertCourseRequest request){
        return courseSevice.updateCourse(id,request);
    }

    // xóa khóa học
    @DeleteMapping("detele/{id}")
    public void removeCourse(@PathVariable int id){
        courseSevice.removeCourse(id);
    }



    // Phân Trang cho khóa học
    @GetMapping("")
    public ResponseEntity<Page> getCourses(@RequestParam(name = "page", defaultValue = "1") int page,
                                             @RequestParam(name = "pageSize", defaultValue = "1") int pageSize) {
        Page coursePage = courseSevice.getCourses(page, pageSize);
        return ResponseEntity.ok(coursePage);
    }


}
