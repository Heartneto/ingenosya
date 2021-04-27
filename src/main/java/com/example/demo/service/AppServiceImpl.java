package com.example.demo.service;

import com.example.demo.model.dto.api.ApiResponseDTO;
import com.example.demo.model.dto.commentaire.CommentaireRequestDTO;
import com.example.demo.model.dto.commentaire.CommentaireResponseDTO;
import com.example.demo.model.dto.commentaire.CommentaireWrapperResponseDTO;
import com.example.demo.model.dto.user.UserResponseDTO;
import com.example.demo.model.dto.voiture.VoitureDTO;
import com.example.demo.model.entity.Commentaire;
import com.example.demo.model.entity.User;
import com.example.demo.model.entity.Voiture;
import com.example.demo.model.mapper.VoitureMapper;
import com.example.demo.repository.CommentaireRepository;
import com.example.demo.repository.VoitureRepository;
import com.example.demo.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppServiceImpl implements AppService{

    @Autowired
    VoitureRepository voitureRepository;

    @Autowired
    VoitureMapper voitureMapper;

    @Autowired
    CommentaireRepository commentaireRepository;

    @Override
    public List<VoitureDTO> getAllVoiture(){
        return voitureMapper.toDtoList(voitureRepository.findAll());
    }

    @Override
    public CommentaireResponseDTO getVoitureEtCom(Long voitureId){
        List<Commentaire> commentaireList = commentaireRepository.findByVoiture_IdOrderByCreatedAtDesc(voitureId);
        VoitureDTO voitureDTO = voitureMapper.toDto(commentaireList.get(0).getVoiture());
        CommentaireResponseDTO crd = new CommentaireResponseDTO();
        crd.setVoitureDTO(voitureDTO);
        List<CommentaireWrapperResponseDTO> list = new ArrayList<>();
        for (Commentaire com : commentaireList){
            CommentaireWrapperResponseDTO cwd = new CommentaireWrapperResponseDTO();
            cwd.setCommentaire(com.getMessage());
            UserResponseDTO usd = new UserResponseDTO();
            usd.setId(com.getUser().getId());
            usd.setUsername(com.getUser().getUsername());
            cwd.setUserResponseDTO(usd);
            cwd.setDateCreatedAt(com.getCreatedAt());
            list.add(cwd);
        }
        crd.setListCom(list);
        return crd;
    }

    @Override
    public ApiResponseDTO addCom(UserPrincipal currentUser, CommentaireRequestDTO req){
        Voiture voiture = new Voiture();
        voiture.setId(req.getId_voiture());
        User user = new User();
        user.setId(currentUser.getId());
        Commentaire commentaire = new Commentaire();
        commentaire.setMessage(req.getCommentaire());
        commentaire.setUser(user);
        commentaire.setVoiture(voiture);
        try {
            commentaireRepository.save(commentaire);
            return new ApiResponseDTO(true, "Commentaire ajouté");
        } catch (Exception e){
            return new ApiResponseDTO(false, "Echec ajout commentaire. Error - {} - " + e.getMessage());
        }
    }

}
