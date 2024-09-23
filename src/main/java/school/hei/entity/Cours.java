package school.hei.entity;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cours {
    private int idCours;
    private String nomCours;
    private String description;
    private int credit;
    private Professeur professeur;
    private List<Absence> absences;


    public Cours(int idCours, String nomCours, int credit) {
        this.idCours = idCours;
        this.nomCours = nomCours;
        this.credit = credit;
    }
}
