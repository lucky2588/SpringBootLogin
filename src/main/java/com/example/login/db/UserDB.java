package com.example.login.db;

import com.example.login.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class UserDB {

    // tạo sẵn 1 trường là listUser của UserDB rồi fake tạm Data
    public static List<User> users = new ArrayList<>(List.of(
            new User(1, "Đức Thắng Nguyễn", "duwcsthang2001@gmail.com", "86666666", "Thành Phố Hà Nội", null, "111"),
            new User(2, "Nguyễn Văn A", "thanggago147@gmail.com", "0123456789", "Tỉnh Nam Định", null, "222"),
            new User(3, "Bùi Văn B", "vanA@techmaster.vn", "0123456789", "Tỉnh Hưng Yên", null, "333")
    ));


}
