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

    // Si nécessaire, tu peux personnaliser certains setters
    public void setIdProfesseur(int id) {
        this.id = id;
    }
}
