package school.hei.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.hei.entity.Professeur;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfesseurDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProfesseurDAO.class);

    // Méthode pour récupérer tous les professeurs
    public List<Professeur> findAllProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        String sql = "SELECT Id_Professeur, Nom, Prenom, Email FROM Professeur";
        try (Statement stmt = DBconnection.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Professeur professeur = new Professeur(
                        rs.getInt("Id_Professeur"),
                        rs.getString("Nom"),
                        rs.getString("Prenom"),
                        rs.getString("Email"),
                        null
                );
                professeurs.add(professeur);
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la récupération des professeurs", e);
        }
        return professeurs;
    }

    // Méthode pour récupérer un professeur par son ID
    public Professeur findProfesseurById(int id) {
        Professeur professeur = null;
        String sql = "SELECT Id_Professeur, Nom, Prenom, Email FROM Professeur WHERE Id_Professeur = ?";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                professeur = new Professeur(
                        rs.getInt("Id_Professeur"),
                        rs.getString("Nom"),
                        rs.getString("Prenom"),
                        rs.getString("Email"),
                        null
                );
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la récupération du professeur avec l'ID {}", id, e);
        }
        return professeur;
    }

    // Méthode pour créer un nouveau professeur (sans departement)
    public Professeur createProfesseur(Professeur professeur) {
        String sql = "INSERT INTO Professeur (Nom, Prenom, Email) VALUES (?, ?, ?)";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, professeur.getNom());
            ps.setString(2, professeur.getPrenom());
            ps.setString(3, professeur.getEmail());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("La création du professeur a échoué, aucune ligne affectée.");
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    professeur.setIdProfesseur(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la création d'un professeur", e);
        }
        return professeur;
    }

    // Méthode pour supprimer un professeur par son ID
    public void deleteProfesseur(int id) {
        String sql = "DELETE FROM Professeur WHERE Id_Professeur = ?";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Erreur lors de la suppression du professeur avec l'ID {}", id, e);
        }
    }
}
