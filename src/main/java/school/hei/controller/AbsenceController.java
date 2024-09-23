package school.hei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.entity.Absence;
import school.hei.service.AbsenceService;

import java.util.List;

@RestController
@RequestMapping("/api/absences")
public class AbsenceController {


    private final AbsenceService absenceService;

    @Autowired
    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }


    @GetMapping
    public List<Absence> getAllAbsences() {
        return absenceService.getAllAbsences();
    }


    @GetMapping("/{id}")
    public Absence getAbsenceById(@PathVariable int id) {
        return absenceService.getAbsenceById(id);
    }


    @PostMapping
    public Absence createAbsence(@RequestBody Absence absence) {
        return absenceService.createAbsence(absence);
    }


    @DeleteMapping("/{id}")
    public void deleteAbsence(@PathVariable int id) {
        absenceService.deleteAbsence(id);
    }
}
