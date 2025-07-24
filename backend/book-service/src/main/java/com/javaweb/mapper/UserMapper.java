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
        entity.setFirst_name(dto.getFirst_name());
        entity.setLast_name(dto.getLast_name());

        return entity;
    }

    public UserDTO toDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUserName(entity.getUserName());
        dto.setPassWord(entity.getPassWord());
        dto.setFirst_name(entity.getFirst_name());
        dto.setLast_name(entity.getLast_name());

        return dto;
    }
}
