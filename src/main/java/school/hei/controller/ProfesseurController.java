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

    // Récupérer tous les professeurs
    @GetMapping
    public List<Professeur> getAllProfesseurs() {
        return professeurService.getAllProfesseurs();
    }

    // Récupérer un professeur par son ID
    @GetMapping("/{id}")
    public Professeur getProfesseurById(@PathVariable int id) {
        return professeurService.getProfesseurById(id);
    }

    // Créer un nouveau professeur
    @PostMapping
    public Professeur createProfesseur(@RequestBody Professeur professeur) {
        return professeurService.createProfesseur(professeur);
    }

    // Supprimer un professeur par son ID
    @DeleteMapping("/{id}")
    public void deleteProfesseur(@PathVariable int id) {
        professeurService.deleteProfesseur(id);
    }
}
