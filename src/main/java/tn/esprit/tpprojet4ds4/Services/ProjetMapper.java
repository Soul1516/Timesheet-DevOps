package tn.esprit.tpprojet4ds4.Services;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import tn.esprit.tpprojet4ds4.Entities.Projet;
import tn.esprit.tpprojet4ds4.Entities.ProjetDTO;

@Mapper(componentModel = "spring")
public interface ProjetMapper {
    @Mapping(target="libelle",source="nomProject")
    ProjetDTO convertToDTO(Projet projet);
}
