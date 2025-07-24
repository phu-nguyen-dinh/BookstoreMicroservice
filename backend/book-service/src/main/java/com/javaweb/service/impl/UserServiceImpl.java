package com.javaweb.service.impl;

import com.javaweb.entity.UserEntity;
import com.javaweb.mapper.UserMapper;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(userMapper::toDTO);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        if(user==null){
            System.out.println("Id not found");
            return;
        }
        userRepository.delete(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO dto) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);
        if(existingUser==null){
            System.out.println("Id not found");
            return null;
        }
        existingUser.setUserName(dto.getUserName());
        existingUser.setPassWord(dto.getPassWord());
        existingUser.setFirst_name(dto.getFirst_name());
        existingUser.setLast_name(dto.getLast_name());

        UserEntity updateUser = userRepository.save(existingUser);

        return userMapper.toDTO(updateUser);
    }

    @Override
    public UserDTO addUser(UserDTO dto) {
        UserEntity existingUser = userRepository.findByUserName(dto.getUserName());
        if(existingUser!=null){
            System.out.println(dto.getUserName()+" has already existed");
            return null;
        }
        UserEntity userEntity = userMapper.toEntity(dto);
        UserEntity savedUser = userRepository.save(userEntity);

        return userMapper.toDTO(savedUser);
    }
}
