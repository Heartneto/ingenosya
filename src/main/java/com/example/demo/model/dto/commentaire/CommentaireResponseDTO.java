package com.example.demo.model.dto.commentaire;

import com.example.demo.model.dto.voiture.VoitureDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter @EqualsAndHashCode
public class CommentaireResponseDTO {

    private VoitureDTO voitureDTO;

    private List<CommentaireWrapperResponseDTO> listCom;

}
