package school.hei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.entity.Groupe;
import school.hei.repository.GroupeDAO;

import java.util.List;

@Service
public class GroupeService {

    private final GroupeDAO groupeDAO;

    @Autowired
    public GroupeService(GroupeDAO groupeDAO) {
        this.groupeDAO = groupeDAO;
    }

    // Récupérer tous les groupes
    public List<Groupe> getAllGroupes() {
        return groupeDAO.findAllGroupes();
    }

    // Récupérer un groupe par son ID
    public Groupe getGroupeById(int id) {
        return groupeDAO.findGroupeById(id);
    }

    // Créer un nouveau groupe
    public Groupe createGroupe(Groupe groupe) {
        return groupeDAO.createGroupe(groupe);
    }

    // Supprimer un groupe par son ID
    public void deleteGroupe(int id) {
        groupeDAO.deleteGroupe(id);
    }
}
