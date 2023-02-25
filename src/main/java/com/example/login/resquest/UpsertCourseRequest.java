package com.example.login.resquest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpsertCourseRequest{
  private int idCourse;
  private    String name;
  private   String description;
  private   String type;
  private List<String> topics;
  private   String  thumbnail;
  private   Integer userId;
}
