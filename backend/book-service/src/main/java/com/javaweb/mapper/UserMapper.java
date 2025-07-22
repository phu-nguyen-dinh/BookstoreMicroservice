package com.javaweb.mapper;

import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toEntity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setUserName(dto.getUserName());
        entity.setPassWord(dto.getPassWord());

        return entity;
    }

    public UserDTO toDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUserName(entity.getUserName());
        dto.setPassWord(entity.getPassWord());

        return dto;
    }
}
