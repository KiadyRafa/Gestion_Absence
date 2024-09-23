package school.hei.entity;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Professeur {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private List<Cours> cours;


    public void setIdProfesseur(int id) {
        this.id = id;
    }
}
