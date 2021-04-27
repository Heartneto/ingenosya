package com.example.demo.model.dto.login;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtAuthenticationResponseDTO {

    private String accessToken;

    private String tokenType = "Bearer";

    public JwtAuthenticationResponseDTO(String accessToken){
        this.accessToken = accessToken;
    }

}
