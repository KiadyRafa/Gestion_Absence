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


    public List<Etudiant> getAllEtudiants() {
        return etudiantDAO.findAllEtudiants();
    }


    public Etudiant getEtudiantById(String id) {
        return etudiantDAO.findEtudiantById(id);
    }


    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantDAO.createEtudiant(etudiant);
    }


    public void deleteEtudiant(String id) {
        etudiantDAO.deleteEtudiant(id);
    }
}
