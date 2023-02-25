//package com.example.login.service;
//
//import com.example.login.dto.UserDTO;
//import com.example.login.mappper.UserMapper;
//import com.example.login.model.User;
//import com.example.login.repository.UserRepository;
//import com.example.login.resquest.UpdateUserResquest;
//import com.example.login.resquest.UserForgetPassWord;
//import com.example.login.resquest.UserPasswordResquest;
//import com.example.login.resquest.UserRequest;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    // hàm lấy ra list Danh sách
//    public List<UserDTO> getAll() {
//        UserMapper userMapper = new UserMapper();
//        return userRepository.getAll().stream().map(user -> userMapper.toUserDTO(user)).toList();
//    }
//
//    // hàm tìm kiếm bằng ID
//    public UserDTO lookId(int id) {
//        User user = userRepository.sreachUserByID(id);
//        return UserMapper.toUserDTO(user);
//    }
//
//    //Tạo mới user
//    public List<UserDTO> createUser(UserRequest userRequest) {
//        userRepository.createUser(userRequest);
//        return userRepository.getAll().stream().map(user -> UserMapper.toUserDTO(user)).toList();
//    }
//
//    // lấy thông tin User .. Kiểm trả tên theo @Param
//    public List<UserDTO> sreachUserByName(String fullname) {
//        List<User> listUser = userRepository.getUser(fullname);
//        return listUser.stream().map(user -> UserMapper.toUserDTO(user)).toList();
//    }
//
//    // tạo mới 1 User
//    public List<UserDTO> createUsernew(UserRequest userRequest) {
//        List<User> listNew = userRepository.createUser(userRequest);
//        return listNew.stream().map(user -> UserMapper.toUserDTO(user)).toList();
//    }
//
//
//    // Cập nhật thông tin user
//    public UserDTO updateUser(int id, UpdateUserResquest userResquest) {
//        return UserMapper.toUserDTO(userRepository.updateUser(id, userResquest));
//    }
//
//// Remove User
//    public List<UserDTO> removeUser(int id){
//        userRepository.removeUser(id);
//        return userRepository.getAll().stream().map(user -> UserMapper.toUserDTO(user)).toList();
//    }
//
//    // đổi Mật Khẩu
//    public User setPassWordNew(int id , UserPasswordResquest userResquest){
//        return userRepository.setPassWord(id,userResquest);
//    }
//    // Quên Mật Khâu
//    public User forgetPassWord(int id , UserForgetPassWord userResquest){
//        return userRepository.forgetPass(id,userResquest);
//    }
//    //
//
//}
