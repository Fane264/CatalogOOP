package services;

import config.DatabaseConfig;
import models.*;
import java.sql.*;

public class DatabaseRepository {
    private static DatabaseRepository instance = null;

    private DatabaseRepository() {}

    public static DatabaseRepository getInstance() {
        if (instance == null) {
            instance = new DatabaseRepository();
        }
        return instance;
    }

    public void createStudent(Student s) {
        String sql = "INSERT OR IGNORE INTO student (id, nume, prenume) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, s.getIdStudent());
            stmt.setString(2, s.getNume());
            stmt.setString(3, s.getPrenume());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void createMaterie(Materie m) {
        String sql = "INSERT OR IGNORE INTO materie (denumire, credite) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getDenumire());
            stmt.setInt(2, m.getCredite());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void createProfesor(Profesor p) {
        String sql = "INSERT OR IGNORE INTO profesor (nume, prenume, departament) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNume());
            stmt.setString(2, p.getPrenume());
            stmt.setString(3, p.getDepartament());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}