package com.example.login.mappper;

import com.example.login.dto.UserDTO;
import com.example.login.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.Mapping;

@Getter
@Setter
@AllArgsConstructor

public class UserMapper { // đây là class để cv từ Object sang ObjectDTO
    public static UserDTO toUserDto(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        userDto.setAvatar(user.getAvatar());

        return userDto;
    }
}
