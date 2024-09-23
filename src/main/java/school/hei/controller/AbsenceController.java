package school.hei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.entity.Absence;
import school.hei.service.AbsenceService;

import java.util.List;

@RestController
@RequestMapping("/api/absences")
public class AbsenceController {

    // Utilisation de l'injection de dépendances via @Autowired
    private final AbsenceService absenceService;

    @Autowired
    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    // Récupérer toutes les absences
    @GetMapping
    public List<Absence> getAllAbsences() {
        return absenceService.getAllAbsences();
    }

    // Récupérer une absence par ID
    @GetMapping("/{id}")
    public Absence getAbsenceById(@PathVariable int id) {
        return absenceService.getAbsenceById(id);
    }

    // Créer une nouvelle absence
    @PostMapping
    public Absence createAbsence(@RequestBody Absence absence) {
        return absenceService.createAbsence(absence);
    }

    // Supprimer une absence par ID
    @DeleteMapping("/{id}")
    public void deleteAbsence(@PathVariable int id) {
        absenceService.deleteAbsence(id);
    }
}
