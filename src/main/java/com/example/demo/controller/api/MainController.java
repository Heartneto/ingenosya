package com.example.demo.controller.api;

import com.example.demo.controller.BaseController;
import com.example.demo.model.dto.api.ApiResponseDTO;
import com.example.demo.model.dto.commentaire.CommentaireRequestDTO;
import com.example.demo.model.dto.commentaire.CommentaireResponseDTO;
import com.example.demo.model.dto.voiture.VoitureDTO;
import com.example.demo.security.CurrentUser;
import com.example.demo.security.UserPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class MainController extends BaseController {

    @GetMapping(value = "voiture")
    public List<VoitureDTO> getAllVoiture(){
        return appService.getAllVoiture();
    }

    //@Secured({})
    @GetMapping(value = "voiture/{id}")
    public CommentaireResponseDTO getVoitureEtCom(@PathVariable(name = "id") Long id){
        return appService.getVoitureEtCom(id);
    }

    //@Secured({})
    @PostMapping(value = "commentaire")
    public ApiResponseDTO addCom(@CurrentUser UserPrincipal currentUser, @RequestBody CommentaireRequestDTO comreq){
        return appService.addCom(currentUser, comreq);
    }

}
