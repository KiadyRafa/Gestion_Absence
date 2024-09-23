package school.hei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.entity.Groupe;
import school.hei.service.GroupeService;

import java.util.List;

@RestController
@RequestMapping("/groupes")
public class GroupeController {

    @Autowired
    private GroupeService groupeService;

    // Récupérer tous les groupes
    @GetMapping
    public List<Groupe> getAllGroupes() {
        return groupeService.getAllGroupes();
    }

    // Récupérer un groupe par son ID
    @GetMapping("/{id}")
    public Groupe getGroupeById(@PathVariable int id) {
        return groupeService.getGroupeById(id);
    }

    // Créer un nouveau groupe
    @PostMapping
    public Groupe createGroupe(@RequestBody Groupe groupe) {
        return groupeService.createGroupe(groupe);
    }

    // Supprimer un groupe par son ID
    @DeleteMapping("/{id}")
    public void deleteGroupe(@PathVariable int id) {
        groupeService.deleteGroupe(id);
    }
}
