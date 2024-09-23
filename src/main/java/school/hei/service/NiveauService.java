package school.hei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.entity.Niveau;
import school.hei.repository.NiveauDAO;

import java.util.List;

@Service
public class NiveauService {

    private final NiveauDAO niveauDAO;

    @Autowired
    public NiveauService(NiveauDAO niveauDAO) {
        this.niveauDAO = niveauDAO;
    }

    // Récupérer tous les niveaux
    public List<Niveau> getAllNiveaux() {
        return niveauDAO.findAllNiveaux();
    }

    // Récupérer un niveau par son ID
    public Niveau getNiveauById(int id) {
        return niveauDAO.findNiveauById(id);
    }

    // Créer un nouveau niveau
    public Niveau createNiveau(Niveau niveau) {
        return niveauDAO.createNiveau(niveau);
    }

    // Supprimer un niveau par son ID
    public void deleteNiveau(int id) {
        niveauDAO.deleteNiveau(id);
    }
}
