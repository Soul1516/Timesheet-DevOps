package tn.esprit.tpprojet4ds4.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "projetDetail") // Stop la récursivité ici aussi
//@RequiredArgsConstructor
//@Table(name="TableProjet")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Projet{
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long idProject;

    //@NonNull
    private String nomProject;
    //association
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    ProjetDetail projetDetail;
    @ManyToMany(mappedBy = "projets")
    @JsonIgnore
    Set<Equipe> equipes=new HashSet<>();
}