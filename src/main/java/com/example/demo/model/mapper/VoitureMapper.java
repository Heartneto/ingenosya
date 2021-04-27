package com.example.demo.model.mapper;

import com.example.demo.model.dto.voiture.VoitureDTO;
import com.example.demo.model.entity.Voiture;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoitureMapper {

    Voiture toEntity(VoitureDTO dto);

    VoitureDTO toDto(Voiture car);

    List<VoitureDTO> toDtoList(List<Voiture> list);

}
