package school.hei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.entity.Niveau;
import school.hei.service.NiveauService;

import java.util.List;

@RestController
@RequestMapping("/niveaux")
public class NiveauController {

    @Autowired
    private NiveauService niveauService;

    // Récupérer tous les niveaux
    @GetMapping
    public List<Niveau> getAllNiveaux() {
        return niveauService.getAllNiveaux();
    }

    // Récupérer un niveau par son ID
    @GetMapping("/{id}")
    public Niveau getNiveauById(@PathVariable int id) {
        return niveauService.getNiveauById(id);
    }

    // Créer un nouveau niveau
    @PostMapping
    public Niveau createNiveau(@RequestBody Niveau niveau) {
        return niveauService.createNiveau(niveau);
    }

    // Supprimer un niveau par son ID
    @DeleteMapping("/{id}")
    public void deleteNiveau(@PathVariable int id) {
        niveauService.deleteNiveau(id);
    }
}
