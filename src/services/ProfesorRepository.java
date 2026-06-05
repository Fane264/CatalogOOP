package services;

import config.DatabaseConfig;
import models.Profesor;
import java.sql.*;

public class ProfesorRepository {
    private static ProfesorRepository instance = null;

    private ProfesorRepository() {}

    public static ProfesorRepository getInstance() {
        if (instance == null) {
            instance = new ProfesorRepository();
        }
        return instance;
    }

    public void create(Profesor p) {
        String sql = "INSERT OR IGNORE INTO profesor (nume, prenume, departament) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNume());
            stmt.setString(2, p.getPrenume());
            stmt.setString(3, p.getDepartament());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void read() {
        String sql = "SELECT * FROM profesor";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Profesor: " + rs.getString("nume") + " " + rs.getString("prenume") + " - " + rs.getString("departament"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateDepartament(int id, String departamentNou) {
        String sql = "UPDATE profesor SET departament = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, departamentNou);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void delete(int id) {
        String sql = "DELETE FROM profesor WHERE id = ?";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}