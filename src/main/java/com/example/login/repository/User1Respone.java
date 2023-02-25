package com.example.login.repository;

import com.example.login.db.UserDB1;
import com.example.login.model.User1;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User1Respone {
    public List<User1> getAll(){
        return UserDB1.listUser;
    }


}
