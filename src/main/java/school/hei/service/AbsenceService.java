package school.hei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.entity.Absence;
import school.hei.repository.AbsenceDAO;


import java.util.List;

@Service
public class AbsenceService {


    private final AbsenceDAO absenceDAO;

    @Autowired
    public AbsenceService(AbsenceDAO absenceDAO) {
        this.absenceDAO = absenceDAO;
    }

    public List<Absence> getAllAbsences() {
        return absenceDAO.findAllAbsences();
    }

    public Absence getAbsenceById(int id) {
        return absenceDAO.findAbsenceById(id);
    }

    public Absence createAbsence(Absence absence) {
        return absenceDAO.createAbsence(absence);
    }

    public void deleteAbsence(int id) {
        absenceDAO.deleteAbsence(id);
    }
}
