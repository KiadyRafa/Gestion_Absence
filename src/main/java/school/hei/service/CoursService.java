package school.hei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.entity.Cours;
import school.hei.repository.CoursDAO;

import java.util.List;

@Service
public class CoursService {

    private final CoursDAO coursDAO;

    // Utilisation de l'injection par constructeur, pratique recommandée
    @Autowired
    public CoursService(CoursDAO coursDAO) {
        this.coursDAO = coursDAO;
    }

    // Récupérer tous les cours
    public List<Cours> getAllCours() {
        return coursDAO.findAllCours();
    }

    // Récupérer un cours par son ID
    public Cours getCoursById(int id) {
        return coursDAO.findCoursById(id);
    }

    // Créer un nouveau cours
    public Cours createCours(Cours cours) {
        return coursDAO.createCours(cours);
    }

    // Supprimer un cours par son ID
    public void deleteCours(int id) {
        coursDAO.deleteCours(id);
    }
}
