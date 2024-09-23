package school.hei.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.hei.entity.Groupe;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupeDAO {

    private static final Logger logger = LoggerFactory.getLogger(GroupeDAO.class);

    // Récupérer tous les groupes
    public List<Groupe> findAllGroupes() {
        List<Groupe> groupes = new ArrayList<>();
        String sql = "SELECT * FROM Groupe";
        try (Statement stmt = DBconnection.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Groupe groupe = new Groupe(
                        rs.getInt("Id_Groupe"),
                        rs.getString("Nom_Groupe")
                );
                groupes.add(groupe);
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la récupération des groupes", e);
        }
        return groupes;
    }

    // Récupérer un groupe par son ID
    public Groupe findGroupeById(int id) {
        Groupe groupe = null;
        String sql = "SELECT * FROM Groupe WHERE Id_Groupe = ?";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                groupe = new Groupe(
                        rs.getInt("Id_Groupe"),
                        rs.getString("Nom_Groupe")
                );
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la récupération du groupe avec l'ID {}", id, e);
        }
        return groupe;
    }

    // Créer un nouveau groupe
    public Groupe createGroupe(Groupe groupe) {
        String sql = "INSERT INTO Groupe (Nom_Groupe) VALUES (?)";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, groupe.getNomGroupe());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("La création du groupe a échoué, aucune ligne affectée.");
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    groupe.setIdGroupe(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            logger.error("Erreur lors de la création d'un groupe", e);
        }
        return groupe;
    }

    // Supprimer un groupe par son ID
    public void deleteGroupe(int id) {
        String sql = "DELETE FROM Groupe WHERE Id_Groupe = ?";
        try (PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Erreur lors de la suppression du groupe avec l'ID {}", id, e);
        }
    }
}
