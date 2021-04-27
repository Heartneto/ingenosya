package com.example.demo.model.dto.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@EqualsAndHashCode @ToString
public class UserResponseDTO {

    private Long id;

    private String username;

}
