package com.javaweb.service;

import com.javaweb.model.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public Optional<UserDTO> getUserById(Long id);
    public List<UserDTO> getAllUser();
    public void deleteUser(Long id);
    public UserDTO updateUser(Long id, UserDTO dto);
    public UserDTO addUser(UserDTO dto);
}
