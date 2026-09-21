package tn.esprit.tpprojet4ds4.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpprojet4ds4.Entities.*;
import tn.esprit.tpprojet4ds4.Repositories.EntrepriseRepository;
import tn.esprit.tpprojet4ds4.Repositories.EquipeRepository;
import tn.esprit.tpprojet4ds4.Repositories.ProjetDetailRespository;
import tn.esprit.tpprojet4ds4.Repositories.ProjetRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor//pour cette annotation on ajoute final à l'attribut
@Slf4j
public class ProjetServicesImpl implements IProjetServices {
    //Injection par champ --ici on enleve final
    // @Autowired
    private final ProjetRepository projetRepository;
    private final ProjetDetailRespository projetDetailRespository;
    private final EquipeRepository equipeRepository;
    private final EntrepriseRepository entrepriseRepository;
    private final ProjetMapper projetMapper;

    //Injection par constructeur
    /*private ProjetServicesImpl(ProjetRepository PR){
        this.projetRepository=PR;
    }*/
    //injection par setter
   /* @Autowired
    private void setProjetRepository(ProjetRepository PR){
        this.projetRepository=PR;
    }*/
    @Override
    public Projet addProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public void ajouterProjet(String sujet) {
        projetRepository.ajouterProjet(sujet);
    }

    @Override
    public void modifierProjet(String sujet, Long id) {
        projetRepository.modifierProjet(sujet, id);
    }

    @Override
    public void supprimerProjet1(Long id) {
        projetRepository.supprimerProjet(id);
    }

    @Override
    public List<Projet> afficherProjets() {
        return projetRepository.findAll();
    }

    @Override
    public ProjetDTO afficherProjetSelonID(Long idProjet) {
        Projet projet = projetRepository.findById(idProjet).get();
        return projetMapper.convertToDTO(projet);
    }

    @Override
    public Projet modifierProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public void supprimerProjet(Long idProjet) {
        projetRepository.deleteById(idProjet);
    }

    @Override
    public void assignProjetDetailToProjet(Long idProjet, Long idProjetDetail) {
        //Récuperer Projet et projetDetail
        Projet projet = projetRepository.findById(idProjet).get();
        ProjetDetail projetDetail = projetDetailRespository.findById(idProjetDetail).get();
        //Affecter ProjetDetail(fils) à projet(pere)
        projet.setProjetDetail(projetDetail);
        //MAJ de projet
        projetRepository.save(projet);
    }

    @Override
    public void assignProjetToEquipe(Long idProjet, Long idEquipe) {
        //Récuperer Projet et Equipe
        Projet projet = projetRepository.findById(idProjet).get();
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        //Affecter Projet(fils) à Equipe(pere)
        equipe.getProjets().add(projet);
        //MJA Equipe
        equipeRepository.save(equipe);
    }

    @Override
    public Projet addProjetAndAssignProjetDetailToProjet(Projet projet, Long idProjetDetail) {
        //Recuperer ProjetDetail
        ProjetDetail projetDetail = projetDetailRespository.findById(idProjetDetail).get();
        //Affectaion
        projet.setProjetDetail(projetDetail);
        //Save
        return projetRepository.save(projet);
    }

    @Override
    public void unassignProjetDetailToProjet(Long idProjet) {
        Projet projet = projetRepository.findById(idProjet).get();
        projet.setProjetDetail(null);
        projetRepository.save(projet);
    }

    @Override
    public void unassignProjetToEquipe(Long idProjet, Long idEquipe) {
        Projet projet = projetRepository.findById(idProjet).get();
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        equipe.getProjets().remove(projet);
        equipeRepository.save(equipe);
    }

    @Override
    public Entreprise afficherSelonNom(String nom) {
        return entrepriseRepository.readByNom(nom);
    }

    @Override
    public Set<Entreprise> afficherEntrepriseSelonAdresseAsc(String nom) {
        return entrepriseRepository.streamByNomContainsOrderByAdresseAsc(nom);
    }

    @Override
    public boolean verifierNomEquipe(String nom) {
        return equipeRepository.existsByNomIgnoreCase(nom);
    }

    @Override
    public Set<Equipe> afficherEquipesBydomaineByEntrepriseDesc(Domaine domaine) {
        return equipeRepository.findByDomaineContainsOrderByEntrepriseNomDesc(domaine);
    }

    @Override
    public Set<Projet> afficherProjetsByTechnologie(String technologie) {
        return projetRepository.streamByProjetDetailTechnologieLike(technologie);
    }

    @Override
    public Set<Projet> afficherProjetsByCout(Long cout) {
        return projetRepository.streamByProjetDetailCoutGreaterThan(cout);
    }

    @Override
    public Set<Entreprise> afficherEntrepriseSelonAdresse(String adresse) {
        return entrepriseRepository.afficheSelonAdresse(adresse);
    }

    @Override
    public Set<Entreprise> afficherEntrepriseSelonDomaine(Domaine domaine) {
        return entrepriseRepository.afficherSelonDomaine(domaine);
    }

    @Override
    public Set<Projet> afficherProjetSelonCoutEtTechnologie(Long cout, String technologie) {
        return projetRepository.afficherSelonCoutEtTechnologie(cout, technologie);
    }

    @Override
    public Set<Projet> afficheProjetNonCommence() {
        return projetRepository.afficherSelonDateDebut();
    }

    @Override
    public ProjetDetailDTO getDetailsProjet(Long idProjetDetail) {
        ProjetDetail projetDetail = projetDetailRespository.findById(idProjetDetail).get();
        return convertToDTO(projetDetail);
    }

    @Scheduled(fixedRate = 60000)
    @Override
    public void afficherMSG() {
        //System.out.println("Bonjour 4DS4");
        log.info("Bonjour 4DS4");
    }

    ProjetDetailDTO convertToDTO(ProjetDetail projetDetail) {
        ProjetDetailDTO projetDetailDTO = new ProjetDetailDTO();
        projetDetailDTO.setDescription(projetDetail.getDescription());
        projetDetailDTO.setTechnologie(projetDetail.getTechnologie());
        projetDetailDTO .setDateDebut(projetDetail.getDateDebut().toString());
        return projetDetailDTO;
    }

}