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


    @GetMapping
    public List<Groupe> getAllGroupes() {
        return groupeService.getAllGroupes();
    }


    @GetMapping("/{id}")
    public Groupe getGroupeById(@PathVariable int id) {
        return groupeService.getGroupeById(id);
    }


    @PostMapping
    public Groupe createGroupe(@RequestBody Groupe groupe) {
        return groupeService.createGroupe(groupe);
    }


    @DeleteMapping("/{id}")
    public void deleteGroupe(@PathVariable int id) {
        groupeService.deleteGroupe(id);
    }
}
