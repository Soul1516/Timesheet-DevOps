package tn.esprit.tpprojet4ds4.Services;

import tn.esprit.tpprojet4ds4.Entities.*;

import java.util.List;
import java.util.Set;

public interface IProjetServices {
    Projet addProjet(Projet projet);

    void ajouterProjet(String sujet);

    void modifierProjet(String sujet, Long id);

    void supprimerProjet1(Long id);

    List<Projet> afficherProjets();

    ProjetDTO afficherProjetSelonID(Long idProjet);

    Projet modifierProjet(Projet projet);

    void supprimerProjet(Long idProjet);

    void assignProjetDetailToProjet(Long idProjet, Long idProjetDetail);

    void assignProjetToEquipe(Long idProjet, Long idEquipe);

    Projet addProjetAndAssignProjetDetailToProjet(Projet projet, Long idProjetDetail);

    void unassignProjetDetailToProjet(Long idProjet);

    void unassignProjetToEquipe(Long idProjet, Long idEquipe);

    Entreprise afficherSelonNom(String nom);

    Set<Entreprise> afficherEntrepriseSelonAdresseAsc(String nom);

    boolean verifierNomEquipe(String nom);

    Set<Equipe> afficherEquipesBydomaineByEntrepriseDesc(Domaine domaine);

    Set<Projet> afficherProjetsByTechnologie(String technologie);

    Set<Projet> afficherProjetsByCout(Long cout);

    Set<Entreprise> afficherEntrepriseSelonAdresse(String adresse);

    Set<Entreprise> afficherEntrepriseSelonDomaine(Domaine domaine);

    Set<Projet> afficherProjetSelonCoutEtTechnologie(Long cout, String technologie);

    Set<Projet> afficheProjetNonCommence();

    ProjetDetailDTO getDetailsProjet(Long idProjetDetail);

    void afficherMSG();
}
