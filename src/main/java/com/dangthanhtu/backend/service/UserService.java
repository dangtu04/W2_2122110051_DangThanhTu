package com.dangthanhtu.backend.service;

import com.dangthanhtu.backend.payloads.UserDTO;
import com.dangthanhtu.backend.payloads.UserResponse;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);

    UserResponse getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    UserDTO getUserById(Long userId);

    UserDTO updateUser(Long userId, UserDTO userDTO);

    String deleteUser(Long userId);

    UserDTO getUserByEmail(String email);

    UserDTO changeUserRole(Long userId, Long roleId);
}