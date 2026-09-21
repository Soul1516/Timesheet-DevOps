package tn.esprit.tpprojet4ds4.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpprojet4ds4.Entities.*;
import tn.esprit.tpprojet4ds4.Services.IProjetServices;

import java.util.List;
import java.util.Set;
//JPQL(jakarta persistance query language):Requete orientée objet, qui sert à interroger une entité dans une BD via JPA
@AllArgsConstructor
@RestController
@RequestMapping("Projet")
@Tag(name="Gestion des projest",description = "API pour gérer les projets")
public class ProjetRestController {
    private final IProjetServices projetServices;

    @PostMapping("/ajouterProjet")
    @Operation(summary = "Ajouter un projet", description = "Permet d'ajouter un nouveau projet")
    Projet ajouterProjet(@RequestBody Projet projet) {
        return projetServices.addProjet(projet);
    }

    @PostMapping("addProjet/{sujet}")
    void addProjet(@PathVariable("sujet") String nom) {
        projetServices.ajouterProjet(nom);
    }

    @PostMapping("/ajouterProjetEtAffceterPDetail/{idPdetail}")
    Projet ajouterProjetEtAffceterPDetail(@RequestBody Projet projet, @PathVariable("idPdetail") long idPDetail) {
        return projetServices.addProjetAndAssignProjetDetailToProjet(projet, idPDetail);
    }

    @GetMapping("/getProjets")
    List<Projet> getProjets() {
        return projetServices.afficherProjets();
    }

    @GetMapping("/getProjetById/{idP}")
    ProjetDTO getProjetById(@PathVariable("idP") Long idProjet) {
        return projetServices.afficherProjetSelonID(idProjet);
    }

    @GetMapping("/getEntrepriseByNom/{nom}")
    Entreprise getEntrepriseByNom(@PathVariable("nom") String nom) {
        return projetServices.afficherSelonNom(nom);
    }

    @GetMapping("getEntrepriseByAdresseCroissant/{nom}")
    Set<Entreprise> getEntrepriseByAdresseCroissant(@PathVariable("nom") String nom) {
        return projetServices.afficherEntrepriseSelonAdresseAsc(nom);
    }

    @GetMapping("verifierEquipesByNom/{nomE}")
    boolean verifierEquipesByNom(@PathVariable("nomE") String nom) {
        return projetServices.verifierNomEquipe(nom);
    }

    @GetMapping("getEquipesBydomaine/{domaine}")
    Set<Equipe> getEquipesBydomaine(@PathVariable("domaine") Domaine domaine) {
        return projetServices.afficherEquipesBydomaineByEntrepriseDesc(domaine);
    }

    @GetMapping("getProjetsbyTechnologie/{tech}")
    Set<Projet> getProjetsbyTechnologie(@PathVariable("tech") String technologie) {
        return projetServices.afficherProjetsByTechnologie(technologie);
    }

    @GetMapping("getProjetsByCoutSup/{cost}")
    Set<Projet> getProjetsByCoutSup(@PathVariable("cost") Long cout) {
        return projetServices.afficherProjetsByCout(cout);
    }

    @GetMapping("getEntrepriseByAdress/{adress}")
    Set<Entreprise> getEntrepriseByAdress(@PathVariable("adress") String adresse) {
        return projetServices.afficherEntrepriseSelonAdresse(adresse);
    }

    @GetMapping("getEntrepriseByDomaine/{domain}")
    Set<Entreprise> getEntrepriseByDomaine(@PathVariable("domain") Domaine domaine) {
        return projetServices.afficherEntrepriseSelonDomaine(domaine);
    }

    @GetMapping("getProjetByCostAndTechnologie/{cost}/{techno}")
    Set<Projet> getProjetByCostAndTechnologie(@PathVariable("cost") Long cout, @PathVariable("techno") String technologie) {
        return projetServices.afficherProjetSelonCoutEtTechnologie(cout, technologie);
    }

    @GetMapping("/getProjetDetail/{idPD}")
    ProjetDetailDTO getProjetDetail(@PathVariable("idPD") Long idDetail) {
        return projetServices.getDetailsProjet(idDetail);
    }

    @PutMapping("/updateProjet")
    Projet updateProjet(@RequestBody Projet projet) {
        return projetServices.modifierProjet(projet);
    }

    @PutMapping("/affecterProjetDetailAProjet/{idP}/{idPD}")
    void affecterProjetDetailAProjet(@PathVariable("idP") long idProjet, @PathVariable("idPD") long idPDetail) {
        projetServices.assignProjetDetailToProjet(idProjet, idPDetail);
    }

    @PutMapping("/affecterProjetAEquipe/{idP}/{idEq}")
    void affecterProjetAEquipe(@PathVariable("idP") long idProjet, @PathVariable("idEq") long idEquipe) {
        projetServices.assignProjetToEquipe(idProjet, idEquipe);
    }

    @PutMapping("/desaffecterProjetDetailAProjet/{idP}")
    void desaffecterProjetDetailAProjet(@PathVariable("idP") long idProjet) {
        projetServices.unassignProjetDetailToProjet(idProjet);
    }

    @PutMapping("/desaffecterProjetAEquipe/{idP}/{idEq}")
    void desaffecterProjetAEquipe(@PathVariable("idP") long idProjet, @PathVariable("idEq") long idEquipe) {
        projetServices.unassignProjetToEquipe(idProjet, idEquipe);
    }

    @DeleteMapping("/deleteProjet/{idP}")
    void deleteProjet(@PathVariable("idP") long idProjet) {
        projetServices.supprimerProjet(idProjet);
    }
}