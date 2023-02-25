package com.example.login.service;

import com.example.login.db.CousreDB;
import com.example.login.dto.CourseDTO;
import com.example.login.exception.BadRequestException;
import com.example.login.mappper.CourseMapper;
import com.example.login.model.Course;
//import com.example.login.repository.CourseResponsitory;
import com.example.login.model.Page;
import com.example.login.repository.CourseResponsitory;
import com.example.login.resquest.UpsertCourseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class CourseSevice {
    @Autowired
    public CourseResponsitory courseResponsitory;

    //
// Lấy ra Course theo yêu cầu ^^
    public List<CourseDTO> getCourse(String fullname, String type, String topic) {
        List<CourseDTO> listCourseDTO = courseResponsitory.getCourse(fullname, type, topic).stream().map(user -> CourseMapper.toCourseDTO(user)).toList();
        if (listCourseDTO.isEmpty()) {
            throw new BadRequestException("Không tìm thấy Khóa học phù hợp ");
        }
        return listCourseDTO;
    }
    // tìm kiếm Course Theo ID
    public List<CourseDTO> sreachCoursebyID(int id){
        List<Course> listCourseDTO = courseResponsitory.sreachCourseByID(id);
        if(listCourseDTO.isEmpty()){
            throw new BadRequestException("Không tìm thấy khóa học với Id "+id);
        }
        return listCourseDTO.stream().map(user->CourseMapper.toCourseDTO(user)).toList();
    }

     // tạo 1 khóa học
    public CourseDTO createCousre(UpsertCourseRequest request){
        return  CourseMapper.toCourseDTO(courseResponsitory.createCourse(request));
    }

    // Cập nhật khóa học
    public CourseDTO updateCourse(int id , UpsertCourseRequest request){
        return CourseMapper.toCourseDTO(courseResponsitory.updateCourse(id,request));
    }
    // Xóa Khóa học
    public void removeCourse(int id){
        courseResponsitory.removeCourse(id);
    }
    // Phân Trang
    public Page<Course> getCourses(int page, int pageSize) {
        List<Course> courses = CousreDB.listCourse; // Tạo danh sách đối tượng Course với dữ liệu mẫu
        int totalItems = courses.size(); // Tính tổng số item

        // Tính vị trí bắt đầu và kết thúc của phần dữ liệu tương ứng với trang
        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalItems);
        // Duyệt danh sách đối tượng Course và trả về phần tương ứng với trang
        ListIterator<Course> iterator = courses.listIterator(startIndex);
        List<Course> pageCourses = new ArrayList<>();
        while (iterator.hasNext() && iterator.nextIndex() < endIndex) {
            pageCourses.add(iterator.next());
        }
        // Tính tổng số trang
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);
        // Trả về kết quả
        return new Page<Course>(page, pageSize, totalPages, totalItems, pageCourses);
    }

}
