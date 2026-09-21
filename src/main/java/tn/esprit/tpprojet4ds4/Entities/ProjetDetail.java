package tn.esprit.tpprojet4ds4.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "projet") // Stop la récursivité ici aussi
//@RequiredArgsConstructor
//@Table(name="TableProjet")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class ProjetDetail {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    Long id;
    String description;
    String technologie;
    Long cout;
    Date dateDebut;
    @OneToOne(mappedBy = "projetDetail")
    Projet projet;
}
