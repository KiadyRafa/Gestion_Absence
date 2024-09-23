package school.hei.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.hei.entity.Etudiant;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EtudiantDAO {

    private static final Logger logger = LoggerFactory.getLogger(EtudiantDAO.class);

    // Récupérer tous les étudiants
    public List<Etudiant> findAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        String sql = "SELECT * FROM Etudiant";
        try (Statement stmt = DBconnection.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Etudiant etudiant = new Etudiant(
                        rs.getString("Id_Etudiant"),
                        rs.getString("Nom"),
                        rs.getString("Prenom"),
                        rs.getString("Email")
                );
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la récupération des étudiants", e);
        }
        return etudiants;
    }

    // Récupérer un étudiant par son ID
    public Etudiant findEtudiantById(String id) {
        Etudiant etudiant = null;
        String sql = "SELECT * FROM Etudiant WHERE Id_Etudiant = ?";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, id);  // Changed to setString
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                etudiant = new Etudiant(
                        rs.getString("Id_Etudiant"),
                        rs.getString("Nom"),
                        rs.getString("Prenom"),
                        rs.getString("Email")
                );
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la récupération de l'étudiant avec l'ID {}", id, e);
        }
        return etudiant;
    }

    // Créer un nouvel étudiant
    public Etudiant createEtudiant(Etudiant etudiant) {
        String sql = "INSERT INTO Etudiant (Nom, Prenom, Email) VALUES (?, ?, ?)";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setString(3, etudiant.getEmail());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("La création de l'étudiant a échoué, aucune ligne affectée.");
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    etudiant.setIdEtudiant(String.valueOf(generatedKeys.getInt(1)));
                }
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la création d'un étudiant", e);
        }
        return etudiant;
    }

    // Supprimer un étudiant par son ID
    public void deleteEtudiant(String id) {
        String sql = "DELETE FROM Etudiant WHERE Id_Etudiant = ?";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, id);  // Changed to setString
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Erreur lors de la suppression de l'étudiant avec l'ID {}", id, e);
        }
    }
}
