package school.hei.entity;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Groupe {
    private int idGroupe;
    private String nomGroupe;
    private Niveau niveau;
    private List<Etudiant> etudiants;


    public Groupe(int idGroupe, String nomGroupe) {
        this.idGroupe = idGroupe;
        this.nomGroupe = nomGroupe;
    }
}


