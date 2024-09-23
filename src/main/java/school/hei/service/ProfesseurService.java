package school.hei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.entity.Professeur;
import school.hei.repository.ProfesseurDAO;

import java.util.List;

@Service
public class ProfesseurService {

    private final ProfesseurDAO professeurDAO;

    @Autowired
    public ProfesseurService(ProfesseurDAO professeurDAO) {
        this.professeurDAO = professeurDAO;
    }


    public List<Professeur> getAllProfesseurs() {
        return professeurDAO.findAllProfesseurs();
    }


    public Professeur getProfesseurById(int id) {
        return professeurDAO.findProfesseurById(id);
    }


    public Professeur createProfesseur(Professeur professeur) {
        return professeurDAO.createProfesseur(professeur);
    }


    public void deleteProfesseur(int id) {
        professeurDAO.deleteProfesseur(id);
    }
}
