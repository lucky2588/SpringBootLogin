package com.example.login.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Course {
        private int idCousre;
        private String nameCourse;
        private String description;
        private String typeCourse;
        private List<String> topicsCourse;
        private String thumbnail;
        private int userId;

}
