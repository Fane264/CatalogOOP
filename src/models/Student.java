package models;

import java.util.ArrayList;
import java.util.List;

// Extinde Persoana si implementeaza Comparable pentru sortare.
public class Student extends Persoana implements Comparable<Student> {
    private int idStudent;
    // O lista care va tine evidenta notelor primite de student.
    private List<Nota> note;

    // Constructorul care primeste datele studentului.
    public Student(int idStudent, String nume, String prenume, Adresa adresa) {
        // 'super' apeleaza automat constructorul clasei de baza (Persoana) pentru a seta numele si adresa.
        super(nume, prenume, adresa);
        this.idStudent = idStudent;
        // Initializam lista ca un ArrayList gol ca sa putem adauga note ulterior, evitand NullPointerException.
        this.note = new ArrayList<>();
    }

    public int getIdStudent() { return idStudent; }
    public void setIdStudent(int idStudent) { this.idStudent = idStudent; }
    public List<Nota> getNote() { return note; }

    // Metoda custom pentru adaugarea unei note in catalogul studentului.
    public void adaugaNota(Nota nota) {
        this.note.add(nota);
    }

    // Aceasta metoda vine din interfata Comparable. O suprascriem pentru a defini logica de sortare a studentilor.
    @Override
    public int compareTo(Student altStudent) {
        // Prima data comparam dupa numele de familie.
        int numeCompare = this.nume.compareTo(altStudent.getNume());
        if (numeCompare != 0) {
            return numeCompare; // Daca numele de familie sunt diferite, sortam dupa ele.
        }
        // Daca numele de familie sunt identice (Popescu = Popescu), departajarea se face dupa prenume.
        return this.prenume.compareTo(altStudent.getPrenume());
    }

    // Ofera un format usor de citit cand incercam sa afisam un obiect Student.
    @Override
    public String toString() {
        return "Student ID " + idStudent + ": " + nume + " " + prenume;
    }
}