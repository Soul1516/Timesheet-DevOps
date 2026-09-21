package tn.esprit.tpprojet4ds4.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpprojet4ds4.Entities.Equipe;
import tn.esprit.tpprojet4ds4.Entities.Projet;
import tn.esprit.tpprojet4ds4.Entities.ProjetDetail;
import tn.esprit.tpprojet4ds4.Entities.ProjetDetailDTO;

import java.util.Set;

public interface ProjetDetailRespository extends JpaRepository<ProjetDetail,Long> {
}
