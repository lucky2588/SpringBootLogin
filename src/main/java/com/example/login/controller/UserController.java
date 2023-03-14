package com.example.login.controller;


import com.example.login.dto.UserDTO;
import com.example.login.model.respo.FileRes;
import com.example.login.resquest.CreateUserRequest;
import com.example.login.resquest.UpdateAvatarRequest;
import com.example.login.resquest.UpdatePasswordRequest;
import com.example.login.resquest.UpdateUserRequest;
import com.example.login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // Lấy danh sách user
    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        List<UserDTO> userDtos = userService.getUsers();
        return ResponseEntity.ok(userDtos);
    }
    // Tìm kiếm user theo tên
    @GetMapping("/users/search")
    public ResponseEntity<?> searchUser(@RequestParam String name) {
        List<UserDTO> userDtos = userService.searchUser(name);
        return ResponseEntity.ok(userDtos);
    }
    // Lấy chi tiết user theo id
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDTO userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    // Tạo user mới
    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request) {
        UserDTO userDto = userService.createUser(request);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    // Xóa user
    @DeleteMapping("/users/{id}")
    public List<UserDTO> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return userService.deleteUser(id);
    }

    // Cập nhật thông tin user
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id,
                                        @RequestBody UpdateUserRequest request) {
        UserDTO userDto = userService.updateUser(id, request);
        return ResponseEntity.ok(userDto);
    }

    // Cập nhật mật khẩu mới
    @PutMapping("/users/{id}/update-password")
    public ResponseEntity<?> updatePassword(@PathVariable int id,
                                            @RequestBody UpdatePasswordRequest request) {
        userService.updatePassword(id, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Quên mật khẩu
    @PostMapping("/users/{id}/forgot-password")
    public ResponseEntity<?> updatePassword(@PathVariable int id) {
        String password = userService.forgotPassword(id);
        return ResponseEntity.ok(password);
    }

    // Thay đổi avatar của user
    @PutMapping("/users/{id}/update-avatar")
    public ResponseEntity<?> updateAvatar(@PathVariable int id,@ModelAttribute("file") MultipartFile file) {
        FileRes fileRes =  userService.updateAvatar(id, file);
        return ResponseEntity.ok(fileRes); // 204
    }

}
