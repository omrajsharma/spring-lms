package org.example.springlms.manager;

import org.example.springlms.dto.UserDTO;
import org.example.springlms.entity.User;
import org.example.springlms.mapper.UserMapper;
import org.example.springlms.repository.UserRepository;
import org.example.springlms.request.UserRequest;
import org.example.springlms.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserManager {

    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper;

    /**
     * Retrieves all users from the repository.
     * @return List of UserResponse
     */
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a user by their ID.
     * @param id - the ID of the user
     * @return UserResponse or null if not found
     */
    public UserDTO getUserById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(user -> userMapper.toDTO(user)).orElse(null);
    }

    /**
     * Creates a new user.
     * @param UserDTO - the request containing user data
     * @return UserResponse
     */
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        userRepository.save(user);
        return userDTO;
    }

    /**
     * Updates an existing user.
     * @param id - the ID of the user to update
     * @param userRequest - the request containing updated user data
     * @return UserResponse or null if not found
     */
    public UserDTO updateUser(int id, UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) return null;
        User user = userOptional.get();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
        return userMapper.toDTO(user);
    }

    /**
     * Deletes a user by their ID.
     * @param id - the ID of the user to delete
     * @return boolean indicating success or failure
     */
    public boolean deleteUser(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) return false;
        User user = userOptional.get();
        userRepository.delete(user);
        return true;
    }
}
