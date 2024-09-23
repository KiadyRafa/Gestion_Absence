package school.hei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.entity.Etudiant;
import school.hei.service.EtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    // Récupérer tous les étudiants
    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    // Récupérer un étudiant par son ID
    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable String id) {  // Changement de int à String
        return etudiantService.getEtudiantById(id);
    }

    // Créer un nouvel étudiant
    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.createEtudiant(etudiant);
    }

    // Supprimer un étudiant par son ID
    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable String id) {  // Changement de int à String
        etudiantService.deleteEtudiant(id);
    }
}
