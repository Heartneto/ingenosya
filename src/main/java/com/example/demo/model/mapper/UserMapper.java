package com.example.demo.model.mapper;

import com.example.demo.model.dto.user.UserResponseDTO;
import com.example.demo.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserResponseDTO dto);

    UserResponseDTO toDto(User user);

}
