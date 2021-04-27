package com.example.demo.model.dto.commentaire;

import com.example.demo.model.dto.user.UserResponseDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter @Setter @EqualsAndHashCode
public class CommentaireWrapperResponseDTO {

    private String commentaire;

    private UserResponseDTO userResponseDTO;

    private Instant dateCreatedAt;

}
