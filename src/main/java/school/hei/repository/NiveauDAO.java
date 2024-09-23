package school.hei.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.hei.entity.Niveau;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NiveauDAO {

    private static final Logger logger = LoggerFactory.getLogger(NiveauDAO.class);


    public List<Niveau> findAllNiveaux() {
        List<Niveau> niveaux = new ArrayList<>();
        String sql = "SELECT * FROM Niveau";
        try (Statement stmt = DBconnection.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Niveau niveau = new Niveau(
                        rs.getInt("Id_Niveau"),
                        rs.getString("Nom_Niveau")
                );
                niveaux.add(niveau);
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la récupération des niveaux", e);
        }
        return niveaux;
    }


    public Niveau findNiveauById(int id) {
        Niveau niveau = null;
        String sql = "SELECT * FROM Niveau WHERE Id_Niveau = ?";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                niveau = new Niveau(
                        rs.getInt("Id_Niveau"),
                        rs.getString("Nom_Niveau")
                );
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la récupération du niveau avec l'ID {}", id, e);
        }
        return niveau;
    }


    public Niveau createNiveau(Niveau niveau) {
        String sql = "INSERT INTO Niveau (Nom_Niveau) VALUES (?)";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, niveau.getNomNiveau());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("La création du niveau a échoué, aucune ligne affectée.");
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    niveau.setIdNiveau(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la création d'un niveau", e);
        }
        return niveau;
    }


    public void deleteNiveau(int id) {
        String sql = "DELETE FROM Niveau WHERE Id_Niveau = ?";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Erreur lors de la suppression du niveau avec l'ID {}", id, e);
        }
    }
}
