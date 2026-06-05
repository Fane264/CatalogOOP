package services;

import config.DatabaseConfig;
import models.Adresa;
import java.sql.*;

public class AdresaRepository {
    private static AdresaRepository instance = null;

    private AdresaRepository() {}

    public static AdresaRepository getInstance() {
        if (instance == null) {
            instance = new AdresaRepository();
        }
        return instance;
    }

    public void create(Adresa a) {
        String sql = "INSERT OR IGNORE INTO adresa (oras, strada) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, a.getOras());
            stmt.setString(2, a.getStrada());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void read() {
        String sql = "SELECT * FROM adresa";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Adresa: " + rs.getString("oras") + ", str. " + rs.getString("strada"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateOras(int id, String orasNou) {
        String sql = "UPDATE adresa SET oras = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, orasNou);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void delete(int id) {
        String sql = "DELETE FROM adresa WHERE id = ?";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}