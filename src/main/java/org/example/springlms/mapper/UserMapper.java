package org.example.springlms.mapper;

import org.example.springlms.dto.UserDTO;
import org.example.springlms.entity.User;
import org.example.springlms.request.UserRequest;
import org.example.springlms.response.UserResponse;

import java.util.List;

public class UserMapper {

    /**
     * Maps a UserRequest to a UserDTO.
     * @param userRequest - The request object containing user data
     * @return UserDTO - The data transfer object
     */
    public UserDTO toDTO(UserRequest userRequest) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(userRequest.getName());
        userDTO.setEmail(userRequest.getEmail());
        return userDTO;
    }

    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    /**
     * Maps a UserDTO to a User entity.
     * @param userDTO - The data transfer object
     * @return User - The entity
     */
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    /**
     * Maps a User entity to a UserResponse.
     * @param user - The entity
     * @return UserResponse - The response object
     */
    public UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }

    public UserResponse toResponse(UserDTO userDTO) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userDTO.getId());
        userResponse.setName(userDTO.getName());
        userResponse.setEmail(userDTO.getEmail());
        return userResponse;
    }

    public List<UserResponse> toResponseList(List<UserDTO> userList) {
        return null;
    }
}
