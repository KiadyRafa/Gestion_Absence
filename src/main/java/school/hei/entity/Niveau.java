package school.hei.entity;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Niveau {
    private int idNiveau;
    private String nomNiveau;
    private List<Groupe> groupes;

    // Constructor with only idNiveau and nomNiveau (ignores groupes)
    public Niveau(int idNiveau, String nomNiveau) {
        this.idNiveau = idNiveau;
        this.nomNiveau = nomNiveau;
    }
}


