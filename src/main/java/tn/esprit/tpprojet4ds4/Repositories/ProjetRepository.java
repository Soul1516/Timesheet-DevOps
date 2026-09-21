package tn.esprit.tpprojet4ds4.Repositories;

import jakarta.transaction.Transactional;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpprojet4ds4.Entities.Projet;

import java.util.Date;
import java.util.Set;

@Repository
public interface ProjetRepository extends JpaRepository<Projet,Long> {
    Set<Projet> streamByProjetDetailTechnologieLike(String technologie);
    Set<Projet> streamByProjetDetailCoutGreaterThan(Long cout);

    @Query("select p from Projet p join p.projetDetail pd where pd.cout>:cost and pd.technologie=:techno")
    Set<Projet> afficherSelonCoutEtTechnologie(@Param("cost") Long cout,@Param("techno") String technologie);

    @Query("select p from Projet p join p.projetDetail pd where pd.dateDebut> current_date")
    Set<Projet> afficherSelonDateDebut();

    @Modifying
    @Transactional
    @Query(value="insert into projet(nomp) values(:nomp)",nativeQuery = true)
    void ajouterProjet(@Param("nomp") String sujet);

    @Modifying
    @Transactional
    @Query(value = "update projet p set p.nomp=:nom where p.id_projet=:id",nativeQuery = true)
    void modifierProjet(@Param("nom") String sujet, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value="delete from projet p where p.id_projet=:id",nativeQuery = true)
    void supprimerProjet(@Param("id") Long id);
}
