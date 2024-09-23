package school.hei.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.hei.entity.Cours;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CoursDAO {

    private static final Logger logger = LoggerFactory.getLogger(CoursDAO.class);

    public List<Cours> findAllCours() {
        List<Cours> cours = new ArrayList<>();
        String sql = "SELECT * FROM Cours";
        try (Statement stmt = DBconnection.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cours cour = new Cours(
                        rs.getInt("Id_Cours"),
                        rs.getString("Nom_Cours"),
                        rs.getInt("Credit")
                );
                cours.add(cour);
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la récupération des cours", e);
        }
        return cours;
    }

    public Cours findCoursById(int id) {
        Cours cours = null;
        String sql = "SELECT * FROM Cours WHERE Id_Cours = ?";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cours = new Cours(
                        rs.getInt("Id_Cours"),
                        rs.getString("Nom_Cours"),
                        rs.getInt("Credit")
                );
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la récupération du cours avec l'ID {}", id, e);
        }
        return cours;
    }

    public Cours createCours(Cours cours) {
        String sql = "INSERT INTO Cours (Nom_Cours, Credit) VALUES (?, ?)";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cours.getNomCours());
            ps.setInt(2, cours.getCredit());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("La création du cours a échoué, aucune ligne affectée.");
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cours.setIdCours(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la création d'un cours", e);
        }
        return cours;
    }

    public void deleteCours(int id) {
        String sql = "DELETE FROM Cours WHERE Id_Cours = ?";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Erreur lors de la suppression du cours avec l'ID {}", id, e);
        }
    }
}
