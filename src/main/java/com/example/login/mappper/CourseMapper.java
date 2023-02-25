package com.example.login.mappper;

import com.example.login.db.UserDB1;
import com.example.login.dto.CourseDTO;
import com.example.login.model.Course;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CourseMapper {
    public static CourseDTO toCourseDTO(Course course){
        CourseDTO user = new CourseDTO();
        user.setNameCourse(course.getNameCourse());
        user.setIdCousre(course.getIdCousre());
        user.setTypeCourse(course.getTypeCourse());
        user.setDescription(course.getDescription());
        user.setTopicsCourse(course.getTopicsCourse());
        user.setThumbnail(course.getThumbnail());
        user.setUser(UserDB1.listUser.stream().filter(user1 -> user1.getId() == course.getUserId()).findFirst().get());
        return user;
    }
}
