package com.example.login.db;

import com.example.login.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CousreDB {

    public static List<Course> listCourse = new ArrayList<>(List.of(
            new Course(1, "Java FullStack Spring Boot", "Là khóa học về ngôn ngữ Java rồi tiếp là Spring Boot ",
                    "onlab",List.of("Database","CTDL"), "Java J2EE", 1),
            new Course(2, "Javaspcirt Developer Web", "Là khóa học về ngôn ngữ Js và Reacts để làm dự án Web ",
                    "onlab",List.of("Web Tĩnh","Js Core","React"), "Js HoW to Lean", 2),
            new Course(3, ".Net Back-end", "Là khóa học về ngôn ngữ .Net  ",
                    "online",List.of("C++","DevOps"), ".NET Docker", 3)
    ));
}
