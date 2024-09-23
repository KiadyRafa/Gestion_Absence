package school.hei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.entity.Professeur;
import school.hei.service.ProfesseurService;

import java.util.List;

@RestController
@RequestMapping("/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;


    @GetMapping
    public List<Professeur> getAllProfesseurs() {
        return professeurService.getAllProfesseurs();
    }


    @GetMapping("/{id}")
    public Professeur getProfesseurById(@PathVariable int id) {
        return professeurService.getProfesseurById(id);
    }


    @PostMapping
    public Professeur createProfesseur(@RequestBody Professeur professeur) {
        return professeurService.createProfesseur(professeur);
    }


    @DeleteMapping("/{id}")
    public void deleteProfesseur(@PathVariable int id) {
        professeurService.deleteProfesseur(id);
    }
}
