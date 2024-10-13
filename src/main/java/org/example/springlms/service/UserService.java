package org.example.springlms.service;

import org.example.springlms.dto.UserDTO;
import org.example.springlms.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserManager userManager;

    public UserDTO createUser(UserDTO userDTO) {
        return userManager.createUser(userDTO);
    }

    public List<UserDTO> getAllUsers() {
        return userManager.getAllUsers();
    }

    public UserDTO getUserById(int id) {
        return userManager.getUserById(id);
    }

    public UserDTO updateUser(int id, UserDTO userDTO) {
        return userManager.updateUser(id, userDTO);
    }

    public boolean deleteUser(int id) {
        return userManager.deleteUser(id);
    }
}
