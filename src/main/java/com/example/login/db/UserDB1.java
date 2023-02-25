package com.example.login.db;

import com.example.login.model.User1;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class UserDB1 {
    public static List<User1> listUser = new ArrayList<>(List.of(
            new User1(1,"Duc Thang","thang123@gmail.com","0332652238","CatLucky"),
            new User1(2,"Tommy Halland","huong222@gmail.com","0332652238","DogMillo"),
            new User1(3," Land Criused  ","abc456@gmail.com","0332652238","Mouse")
    ));

}
