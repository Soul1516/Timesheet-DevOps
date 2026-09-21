package tn.esprit.tpprojet4ds4.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tpprojet4ds4.Entities.Domaine;
import tn.esprit.tpprojet4ds4.Entities.Entreprise;
import tn.esprit.tpprojet4ds4.Entities.Equipe;

import java.util.Set;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {
    Entreprise readByNom(String nom);
    Set<Entreprise> streamByNomContainsOrderByAdresseAsc(String nom);

    @Query("select e from Entreprise e where e.adresse=:adresseE")
    Set<Entreprise> afficheSelonAdresse(@Param("adresseE")String adresse);

    @Query("select e from Entreprise e where e.adresse=?1 and e.nom=?2")
    Set<Entreprise> afficheSelonAdresse2(String adresse,String nom);

    @Query(value="select * from entreprise e where e.adress=:adress",nativeQuery = true)
    Set<Entreprise> afficherSelonAdresse3(@Param("adress") String adresse);

    @Query("select e from Entreprise e join e.equipes eq where eq.domaine=:domaineE")
    Set<Entreprise> afficherSelonDomaine(@Param("domaineE") Domaine domaine);
}
