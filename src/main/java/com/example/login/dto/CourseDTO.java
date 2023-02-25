package com.example.login.dto;
import com.example.login.model.User1;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private int idCousre;
    private String nameCourse;
    private String description;
    private String typeCourse;
    private List<String> topicsCourse;
    private String thumbnail;
    private User1 user;

}
