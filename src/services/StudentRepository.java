package services;

import config.DatabaseConfig;
import models.Student;
import java.sql.*;

public class StudentRepository {
    private static StudentRepository instance = null;

    private StudentRepository() {}

    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    public void create(Student s) {
        String sql = "INSERT OR IGNORE INTO student (id, nume, prenume) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, s.getIdStudent());
            stmt.setString(2, s.getNume());
            stmt.setString(3, s.getPrenume());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void read() {
        String sql = "SELECT * FROM student";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("--- Studenti din Baza de Date ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Nume: " + rs.getString("nume") + " " + rs.getString("prenume"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateNume(int id, String numeNou) {
        String sql = "UPDATE student SET nume = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, numeNou);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void delete(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        try (Connection conn = DatabaseConfig.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}