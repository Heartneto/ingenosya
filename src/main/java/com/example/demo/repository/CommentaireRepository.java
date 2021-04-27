package com.example.demo.repository;

import com.example.demo.model.entity.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

    Optional<Commentaire> findById(Integer id);

    List<Commentaire> findByVoiture_IdOrderByCreatedAtDesc(Long id);

}
