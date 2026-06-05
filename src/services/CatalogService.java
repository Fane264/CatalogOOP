package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import models.*;

public class CatalogService {
    private Set<Student> studenti = new TreeSet<>();
    private List<Profesor> profesori = new ArrayList<>();
    private List<Materie> materii = new ArrayList<>();

    public void adaugaStudent(Student student) {
        studenti.add(student);
        AuditService.getInstance().scrieInAudit("adaugaStudent");
        // Apelam serviciul dedicat pentru Student
        StudentRepository.getInstance().create(student);
        System.out.println("S-a adaugat studentul: " + student.getNume());
    }

    public void adaugaProfesor(Profesor profesor) {
        profesori.add(profesor);
        AuditService.getInstance().scrieInAudit("adaugaProfesor");
        // Apelam serviciul dedicat pentru Profesor
        ProfesorRepository.getInstance().create(profesor);
        System.out.println("S-a adaugat profesorul: " + profesor.getNume());
    }

    public void adaugaMaterie(Materie materie) {
        materii.add(materie);
        AuditService.getInstance().scrieInAudit("adaugaMaterie");
        // Apelam serviciul dedicat pentru Materie
        MaterieRepository.getInstance().create(materie);
        System.out.println("S-a adaugat materia: " + materie.getDenumire());
    }

    public void adaugaNotaStudent(int idStudent, Nota nota) {
        AuditService.getInstance().scrieInAudit("adaugaNota");
        for (Student s : studenti) {
            if (s.getIdStudent() == idStudent) {
                s.adaugaNota(nota);
                System.out.println("Nota " + nota.getValoare() + " adaugata studentului " + s.getNume());
                return;
            }
        }
    }

    public void afiseazaStudentiSortati() {
        AuditService.getInstance().scrieInAudit("afiseazaStudenti");
        System.out.println("\n--- Lista Studenti (Sortati) ---");
        for (Student s : studenti) {
            System.out.println(s.toString());
        }
    }

    public void afiseazaProfesori() {
        AuditService.getInstance().scrieInAudit("afiseazaProfesori");
        System.out.println("\n--- Lista Profesori ---");
        for (Profesor p : profesori) {
            System.out.println(p.toString());
        }
    }

    public void afiseazaMaterii() {
        AuditService.getInstance().scrieInAudit("afiseazaMaterii");
        System.out.println("\n--- Lista Materii ---");
        for (Materie m : materii) {
            System.out.println(m.toString());
        }
    }

    public void calculeazaMedieStudent(int idStudent) {
        AuditService.getInstance().scrieInAudit("calculeazaMedie");
        for (Student s : studenti) {
            if (s.getIdStudent() == idStudent) {
                if (s.getNote().isEmpty()) return;
                double suma = 0;
                for (Nota n : s.getNote()) suma += n.getValoare();
                System.out.println("Media studentului " + s.getNume() + " este: " + (suma / s.getNote().size()));
                return;
            }
        }
    }

    public void afiseazaCarnetNote(int idStudent) {
        AuditService.getInstance().scrieInAudit("afiseazaCarnet");
        for (Student s : studenti) {
            if (s.getIdStudent() == idStudent) {
                System.out.println("\n--- Carnet note: " + s.getNume() + " ---");
                for (Nota n : s.getNote()) System.out.println(n.toString());
                return;
            }
        }
    }

    public void stergeStudent(int idStudent) {
        AuditService.getInstance().scrieInAudit("stergeStudent");
        Student studentDeSters = null;
        for (Student s : studenti) {
            if (s.getIdStudent() == idStudent) {
                studentDeSters = s;
                break;
            }
        }
        if (studentDeSters != null) {
            studenti.remove(studentDeSters);
            // Folosim clasa specifica de repository pentru stergere
            StudentRepository.getInstance().delete(idStudent);
            System.out.println("Studentul cu ID " + idStudent + " a fost sters.");
        }
    }
}