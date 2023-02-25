//package com.example.login.controller;
//
//import com.example.login.dto.UserDTO;
//import com.example.login.model.User;
//import com.example.login.resquest.*;
//import com.example.login.service.UserService;
//import jakarta.validation.Valid;
//import lombok.Getter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@Controller
//@RequestMapping("User")
//public class UserController {
//    @Autowired
//    private UserService userService;
//    @GetMapping("getAll") // render ra danh sách
//    public ResponseEntity<List<UserDTO>> getUser(){
//        List<UserDTO> userDTOList = userService.getAll();
//        return ResponseEntity.ok(userDTOList);
//    }
//    // tìm User theo Id
//    @GetMapping("sreachUser/{id}")
//    public UserDTO sreachIDbyUser(@PathVariable int id){
//        return userService.lookId(id);
//    }
//
//    // Tạo mới 1 User
//    @PostMapping("createUser")
//    public List<UserDTO> createUser(@RequestBody UserRequest userRequest){
//        return userService.createUser(userRequest);
//    }
//
//    // tìm User theo tên sử dụng Param
//    @PostMapping("sreachUser")
//    public List<UserDTO> sreachUser(@RequestParam String fullname){
//        return userService.sreachUserByName(fullname);
//    }
//
//    // câp nhật User
//    @PostMapping("updateUser/{id}")
//    public UserDTO updateUser(@PathVariable int id, @RequestBody UpdateUserResquest userResquest){
//        return userService.updateUser(id,userResquest);
//    }
//
//    // Xóa User
//    @DeleteMapping("removeUser/{id}")
//    public List<UserDTO> removeUser(@PathVariable int id){
//        return userService.removeUser(id);
//    }
//    // Đổi mật khẩu
//    @PostMapping("setPassword/{id}")
//    public User setPassWord(@PathVariable int id,@Valid @RequestBody UserPasswordResquest userResquest){
//        return userService.setPassWordNew(id,userResquest);
//    }
//
//    // Quên Mk
//    @PostMapping("forgetPassword/{id}")
//    public User forgetPassWord(@PathVariable int id, @RequestBody UserForgetPassWord userResquest){
//        return userService.forgetPassWord(id,userResquest);
//    }
//
//    @PostMapping("TestUser")
//    public String testUser(@Valid @RequestBody UserResquestTest user){
//        return "1";
//    }
//
//
//
//
//
//
//}
