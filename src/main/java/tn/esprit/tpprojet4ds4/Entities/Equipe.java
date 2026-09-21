package tn.esprit.tpprojet4ds4.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "entreprise") // Stop la récursivité ici aussi
//@RequiredArgsConstructor
//@Table(name="TableProjet")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Equipe {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    Long id;
    @Column(unique = true,nullable = false)
    @NonNull
    String nom;
    @Enumerated(EnumType.STRING)
    Domaine domaine;
    @ManyToOne(cascade = CascadeType.ALL)
    Entreprise entreprise;
    @ManyToMany(cascade = CascadeType.ALL)
    Set<Projet> projets;
}
