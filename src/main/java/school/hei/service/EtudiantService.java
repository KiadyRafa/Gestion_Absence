package school.hei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.entity.Etudiant;
import school.hei.repository.EtudiantDAO;

import java.util.List;

@Service
public class EtudiantService {

    private final EtudiantDAO etudiantDAO;

    @Autowired
    public EtudiantService(EtudiantDAO etudiantDAO) {
        this.etudiantDAO = etudiantDAO;
    }

    // Récupérer tous les étudiants
    public List<Etudiant> getAllEtudiants() {
        return etudiantDAO.findAllEtudiants();
    }

    // Récupérer un étudiant par son ID
    public Etudiant getEtudiantById(int id) {
        return etudiantDAO.findEtudiantById(id);
    }

    // Créer un nouvel étudiant
    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantDAO.createEtudiant(etudiant);
    }

    // Supprimer un étudiant par son ID
    public void deleteEtudiant(int id) {
        etudiantDAO.deleteEtudiant(id);
    }
}
