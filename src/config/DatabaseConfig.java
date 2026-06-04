package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {
    private static Connection connection;
    // Baza de date va fi un fisier local numit catalog.db
    private static final String URL = "jdbc:sqlite:catalog.db";

    private DatabaseConfig() {}

    public static Connection getDatabaseConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL);
                creeazaTabele(); // Creăm tabelele automat
            }
        } catch (SQLException e) {
            System.out.println("Eroare la conectarea cu baza de date SQLite!");
            e.printStackTrace();
        }
        return connection;
    }

    private static void creeazaTabele() {
        String sqlStudent = "CREATE TABLE IF NOT EXISTS student (id INTEGER PRIMARY KEY, nume TEXT, prenume TEXT);";
        String sqlMaterie = "CREATE TABLE IF NOT EXISTS materie (id INTEGER PRIMARY KEY AUTOINCREMENT, denumire TEXT, credite INTEGER);";
        String sqlProfesor = "CREATE TABLE IF NOT EXISTS profesor (id INTEGER PRIMARY KEY AUTOINCREMENT, nume TEXT, prenume TEXT, departament TEXT);";
        String sqlAdresa = "CREATE TABLE IF NOT EXISTS adresa (id INTEGER PRIMARY KEY AUTOINCREMENT, oras TEXT, strada TEXT);";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sqlStudent);
            stmt.execute(sqlMaterie);
            stmt.execute(sqlProfesor);
            stmt.execute(sqlAdresa);
        } catch (SQLException e) {
            System.out.println("Eroare la generarea tabelelor SQLite!");
            e.printStackTrace();
        }
    }
}