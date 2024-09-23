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


    @GetMapping
    public List<Cours> getAllCours() {
        return coursService.getAllCours();
    }


    @GetMapping("/{id}")
    public Cours getCoursById(@PathVariable int id) {
        return coursService.getCoursById(id);
    }


    @PostMapping
    public Cours createCours(@RequestBody Cours cours) {
        return coursService.createCours(cours);
    }


    @DeleteMapping("/{id}")
    public void deleteCours(@PathVariable int id) {
        coursService.deleteCours(id);
    }
}
