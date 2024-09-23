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


    @GetMapping
    public List<Niveau> getAllNiveaux() {
        return niveauService.getAllNiveaux();
    }


    @GetMapping("/{id}")
    public Niveau getNiveauById(@PathVariable int id) {
        return niveauService.getNiveauById(id);
    }


    @PostMapping
    public Niveau createNiveau(@RequestBody Niveau niveau) {
        return niveauService.createNiveau(niveau);
    }


    @DeleteMapping("/{id}")
    public void deleteNiveau(@PathVariable int id) {
        niveauService.deleteNiveau(id);
    }
}
