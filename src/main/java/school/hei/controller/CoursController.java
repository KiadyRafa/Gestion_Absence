package school.hei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.entity.Cours;
import school.hei.service.CoursService;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    // Récupérer tous les cours
    @GetMapping
    public List<Cours> getAllCours() {
        return coursService.getAllCours();
    }

    // Récupérer un cours par son ID
    @GetMapping("/{id}")
    public Cours getCoursById(@PathVariable int id) {
        return coursService.getCoursById(id);
    }

    // Créer un nouveau cours
    @PostMapping
    public Cours createCours(@RequestBody Cours cours) {
        return coursService.createCours(cours);
    }

    // Supprimer un cours par son ID
    @DeleteMapping("/{id}")
    public void deleteCours(@PathVariable int id) {
        coursService.deleteCours(id);
    }
}
