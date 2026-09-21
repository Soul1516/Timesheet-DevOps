package tn.esprit.tpprojet4ds4.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "equipes") // Stop la récursivité ici aussi
//@RequiredArgsConstructor
//@Table(name="TableProjet")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    @Column(name="adress")
    String adresse;

    //association
    @OneToMany(mappedBy = "entreprise")
    Set<Equipe> equipes;
}
