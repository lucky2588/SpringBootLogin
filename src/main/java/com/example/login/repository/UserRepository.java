//package com.example.login.repository;
//import com.example.login.db.UserDB;
//import com.example.login.exception.BadRequestException;
//import com.example.login.model.User;
//import com.example.login.resquest.UpdateUserResquest;
//import com.example.login.resquest.UserForgetPassWord;
//import com.example.login.resquest.UserPasswordResquest;
//import com.example.login.resquest.UserRequest;
//import lombok.Builder;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
////Lấy danh sách user
////Tìm kiếm user
////Tạo mới user
////Lấy thông tin user
////Cập nhật thông tin user
////Xóa user
////Đổi mật khẩu
////Quên mật khẩu
//
//@Repository
//@Builder
//public class UserRepository { // tạo ra class để tương tác với DataBase
//
//    //Lấy danh sách user
//    public List<User> getAll(){
//        return UserDB.listUser;
//    }
//
//    //Tìm kiếm user
//    public User sreachUserByID(int id){
//       Optional<User> userOptional =  UserDB.listUser.stream().filter(user -> user.getId() == id).findFirst(); // la mot Option<> doi tuong
//       if(userOptional.isPresent()){ // check xem userOption co trong hay ko
//           return userOptional.get();
//       }
//        throw new BadRequestException("Không tìm thấy User nào có Id là "+id);
//    }
//
//
//    // //Tạo mới user
//public List<User> createUser(UserRequest userRequest){
//        User user = new User();
//        user.setId(userRequest.getId());
//        user.setUsername(userRequest.getUsername() );
//        user.setEmail(userRequest.getEmail());
//        user.setAddress(userRequest.getAddress());
//        user.setPassword(userRequest.getPassword());
//        user.setPhone(userRequest.getPhone());
//        UserDB.listUser.add(user);
//        return UserDB.listUser;
//}
//
//
//// lấy thông tin User .. Kiểm trả tên theo @Param
//    public List<User> getUser(String fullname){
//       List<User> listNew = new ArrayList<>();
//       for(int i = 0 ; i <= UserDB.listUser.size()-1; i++  ){
//           if(UserDB.listUser.get(i).getUsername().equalsIgnoreCase(fullname)){
//               listNew.add(UserDB.listUser.get(i) );
//           }
//       }
//       if(listNew.isEmpty()){
//           throw new BadRequestException("Ko thấy User nào có tên thế");
//       }
//       return listNew;
//    }
//
//    // Cập nhật thông tin user
//    public User updateUser(int id , UpdateUserResquest userRequest){
//        sreachUserByID(id).setUsername(userRequest.getUsername());
//        sreachUserByID(id).setAddress(userRequest.getAddress());
//        sreachUserByID(id).setPhone(userRequest.getPhone());
//        return sreachUserByID(id);
//    }
//
//    //Xóa user
//    public List<User> removeUser(int id){
//        if(UserDB.listUser.contains(sreachUserByID(id))){
//            UserDB.listUser.remove(sreachUserByID(id));
//            return UserDB.listUser;
//        }
//        throw new BadRequestException("Không tìm thấy ID "+id);
//    }
//
//    // Đổi mật khẩu
//    public User setPassWord(int id , UserPasswordResquest userRequest){
//        if(UserDB.listUser.contains(sreachUserByID(id))  &&    sreachUserByID(id).getPassword().equalsIgnoreCase(userRequest.getOldPass())){
//            sreachUserByID(id).setPassword(userRequest.getNewPass());
//        }
//        throw new BadRequestException("password ko đúng =)) or ID ko tìm thấy  ");
//    }
//
//    // Quên Mật Khẩu (Tạm thời xử lí bằng cách cho trùng Email )
//    public User forgetPass(int id, UserForgetPassWord userRequest){
//        if( sreachUserByID(id).getId() == id && sreachUserByID(id).getEmail().equalsIgnoreCase(userRequest.getEmail())){
//            sreachUserByID(id).setPassword(userRequest.getPasswordNew());
//        }
//        throw new BadRequestException("Sai Id or Email @@ ");
//    }
//
//
//
//
//
//
//
//
//}