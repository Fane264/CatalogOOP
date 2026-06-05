package services;

import config.DatabaseConfig;
import models.Materie;
import java.sql.*;

public class MaterieRepository {
    private static MaterieRepository instance = null;

    private MaterieRepository() {}

    public static MaterieRepository getInstance() {
        if (instance == null) {
            instance = new MaterieRepository();
        }
        return instance;
    }

    public void create(Materie m) {
        String sql = "INSERT OR IGNORE INTO materie (denumire, credite) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getDenumire());
            stmt.setInt(2, m.getCredite());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void read() {
        String sql = "SELECT * FROM materie";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Materie: " + rs.getString("denumire") + " | Credite: " + rs.getInt("credite"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateCredite(int id, int crediteNoi) {
        String sql = "UPDATE materie SET credite = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, crediteNoi);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void delete(int id) {
        String sql = "DELETE FROM materie WHERE id = ?";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}