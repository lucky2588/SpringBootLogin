package com.example.login.repository;
//import com.example.login.db.CouseDB1;

import com.example.login.db.CousreDB;
import com.example.login.dto.CourseDTO;
import com.example.login.exception.BadRequestException;
import com.example.login.model.Course;
import com.example.login.resquest.UpsertCourseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class CourseResponsitory {
    // get All
    public List<Course> getCourse(String fullname, String type, String topicValue) {
        if (fullname.equals("") && type.equals("") && topicValue.equals("")) {
            return CousreDB.listCourse;
        }
        List<Course> newList = new ArrayList<>();
        for (int i = 0; i <= CousreDB.listCourse.size() - 1; i++) {
            if (CousreDB.listCourse.get(i).getNameCourse().equalsIgnoreCase(fullname) || CousreDB.listCourse.get(i).getTypeCourse().equals(type) || CousreDB.listCourse.get(i).getTopicsCourse().equals(topicValue)) {
                newList.add(CousreDB.listCourse.get(i));
            }
        }
        return newList;
    }

    // sreach ID look Course
    public List<Course> sreachCourseByID(int id) {
        return CousreDB.listCourse.stream().filter(user -> user.getUserId() == id).toList();
    }

    //tạo method tìm kiếm 1 khóa học
    public Course xCourse(int id) {
     return  CousreDB.listCourse.stream().filter(user->user.getIdCousre() == id).findFirst().get();
    }



    // Create Course
    public Course createCourse(UpsertCourseRequest request){
        Course course = new Course();
        course.setIdCousre(request.getIdCourse());
        course.setNameCourse(request.getName());
        course.setTypeCourse(request.getType());
        course.setDescription(request.getDescription());
        course.setTopicsCourse(request.getTopics());
        course.setThumbnail(request.getThumbnail());
        course.setUserId(3);
        return course;
    }

    public Course updateCourse(int id , UpsertCourseRequest request){
        if(xCourse(id) == null){
            throw new BadRequestException("Không có Course với ID "+id);
        }
        xCourse(id).setNameCourse(request.getName());
        xCourse(id).setTypeCourse(request.getType());
        xCourse(id).setTopicsCourse(request.getTopics());
        xCourse(id).setDescription(request.getDescription());
        xCourse(id).setThumbnail(request.getThumbnail());
        xCourse(id).setUserId(request.getUserId());
        return xCourse(id);
    }

    public void removeCourse(int id){
        if(xCourse(id) == null){
            throw new BadRequestException("Không có ID  "+id);
        }
        CousreDB.listCourse.remove(xCourse(id));
    }


    // lấy khóa học


}
