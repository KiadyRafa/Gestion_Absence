package school.hei.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.hei.entity.Absence;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AbsenceDAO {

    private static final Logger logger = LoggerFactory.getLogger(AbsenceDAO.class);

    // Méthode pour récupérer toutes les absences
    public List<Absence> findAllAbsences() {
        List<Absence> absences = new ArrayList<>();
        String sql = "SELECT * FROM Absence";
        try (Statement stmt = DBconnection.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Absence absence = new Absence(
                        rs.getInt("Id_Absence"),
                        rs.getDate("Date_Absence"),
                        rs.getBoolean("Motif"),
                        rs.getString("Justification"),
                        rs.getString("Id_Etudiant"),
                        rs.getInt("Id_Cours")
                );
                absences.add(absence);
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la récupération des absences", e);
        }
        return absences;
    }

    // Méthode pour récupérer une absence par son ID
    public Absence findAbsenceById(int id) {
        Absence absence = null;
        String sql = "SELECT * FROM Absence WHERE Id_Absence = ?";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                absence = new Absence(
                        rs.getInt("Id_Absence"),
                        rs.getDate("Date_Absence"),
                        rs.getBoolean("Motif"),
                        rs.getString("Justification"),
                        rs.getString("Id_Etudiant"),
                        rs.getInt("Id_Cours")
                );
            }
        } catch (SQLException e) {

            logger.error("Erreur lors de la récupération de l'absence avec l'ID {}", id, e);
        }
        return absence;
    }

    // Méthode pour créer une nouvelle absence
    public Absence createAbsence(Absence absence) {
        String sql = "INSERT INTO Absence (Date_Absence, Motif, Justification, Id_Etudiant, Id_Cours) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, absence.getDateAbsence());
            ps.setBoolean(2, absence.isMotif());
            ps.setString(3, absence.getJustification());
            ps.setString(4, absence.getIdEtudiant());
            ps.setInt(5, absence.getIdCours());

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("La création de l'absence a échoué, aucune ligne affectée.");
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    absence.setIdAbsence(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la création d'une absence", e);
        }
        return absence;
    }

    // Méthode pour supprimer une absence par son ID
    public void deleteAbsence(int id) {
        String sql = "DELETE FROM Absence WHERE Id_Absence = ?";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Erreur lors de la suppression de l'absence avec l'ID {}", id, e);
        }
    }

}
