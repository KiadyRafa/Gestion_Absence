package school.hei.entity;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Etudiant {
    private String idEtudiant;
    private String nom;
    private String prenom;
    private String email;
    private String genre;
    private Groupe groupe;
    private List<Absence> absences;


    public Etudiant(String idEtudiant, String nom, String prenom, String email) {
        this.idEtudiant = idEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
}
