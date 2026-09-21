package tn.esprit.tpprojet4ds4.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetDetailDTO {
    String description;
    String technologie;
    String dateDebut;
}
