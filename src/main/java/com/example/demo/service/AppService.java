package com.example.demo.service;

import com.example.demo.model.dto.api.ApiResponseDTO;
import com.example.demo.model.dto.commentaire.CommentaireRequestDTO;
import com.example.demo.model.dto.commentaire.CommentaireResponseDTO;
import com.example.demo.model.dto.voiture.VoitureDTO;
import com.example.demo.security.UserPrincipal;

import java.util.List;

public interface AppService {
    List<VoitureDTO> getAllVoiture();

    CommentaireResponseDTO getVoitureEtCom(Long voitureId);

    ApiResponseDTO addCom(UserPrincipal currentUser, CommentaireRequestDTO req);
}
