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


    public List<Groupe> getAllGroupes() {
        return groupeDAO.findAllGroupes();
    }


    public Groupe getGroupeById(int id) {
        return groupeDAO.findGroupeById(id);
    }


    public Groupe createGroupe(Groupe groupe) {
        return groupeDAO.createGroupe(groupe);
    }


    public void deleteGroupe(int id) {
        groupeDAO.deleteGroupe(id);
    }
}
