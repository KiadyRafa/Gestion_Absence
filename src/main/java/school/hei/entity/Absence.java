package school.hei.entity;

import lombok.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Absence {
    private int idAbsence;
    private Date dateAbsence;
    private boolean motif;
    private String justification;
    private String idEtudiant;
    private int idCours;
}