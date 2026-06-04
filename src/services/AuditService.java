package services;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService {
    // Instanța unica (Singleton)
    private static AuditService instance = null;
    private final String filepath = "audit.csv";

    private AuditService() {}

    public static AuditService getInstance() {
        if (instance == null) {
            instance = new AuditService();
        }
        return instance;
    }

    public void scrieInAudit(String numeActiune) {
        // Scriem cu "true" pentru modul append
        try (PrintWriter writer = new PrintWriter(new FileWriter(filepath, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.println(numeActiune + "," + timestamp);
        } catch (IOException e) {
            System.out.println("Eroare la scrierea in fisierul de audit: " + e.getMessage());
        }
    }
}