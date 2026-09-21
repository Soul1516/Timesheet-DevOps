package tn.esprit.tpprojet4ds4.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpprojet4ds4.Entities.Domaine;
import tn.esprit.tpprojet4ds4.Entities.Equipe;

import java.util.Set;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {
    boolean existsByNomIgnoreCase(String nom);
    Set<Equipe> findByDomaineContainsOrderByEntrepriseNomDesc(Domaine domaine);
}
