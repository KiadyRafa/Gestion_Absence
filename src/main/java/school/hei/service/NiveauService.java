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


    public List<Niveau> getAllNiveaux() {
        return niveauDAO.findAllNiveaux();
    }


    public Niveau getNiveauById(int id) {
        return niveauDAO.findNiveauById(id);
    }


    public Niveau createNiveau(Niveau niveau) {
        return niveauDAO.createNiveau(niveau);
    }


    public void deleteNiveau(int id) {
        niveauDAO.deleteNiveau(id);
    }
}
