package school.hei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.entity.Cours;
import school.hei.repository.CoursDAO;

import java.util.List;

@Service
public class CoursService {

    private final CoursDAO coursDAO;


    @Autowired
    public CoursService(CoursDAO coursDAO) {
        this.coursDAO = coursDAO;
    }


    public List<Cours> getAllCours() {
        return coursDAO.findAllCours();
    }


    public Cours getCoursById(int id) {
        return coursDAO.findCoursById(id);
    }


    public Cours createCours(Cours cours) {
        return coursDAO.createCours(cours);
    }


    public void deleteCours(int id) {
        coursDAO.deleteCours(id);
    }
}
