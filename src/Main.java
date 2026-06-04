import models.*;
import services.CatalogService;

public class Main {
    public static void main(String[] args) {
        // Instantiem serviciul care ne ofera toate metodele de gestiune
        CatalogService service = new CatalogService();

        // 1. Creare adrese
        Adresa adresa1 = new Adresa("Bucuresti", "Splaiul Independentei");
        Adresa adresa2 = new Adresa("Cluj-Napoca", "Observatorului");

        // 2. Instantiere obiecte din ierarhie (Studenti)
        Student s1 = new Student(1, "Popescu", "Ion", adresa1);
        Student s2 = new Student(2, "Ionescu", "Andrei", adresa2);
        Student s3 = new Student(3, "Georgescu", "Maria", adresa1);

        // 3. Creare Profesor
        Profesor p1 = new Profesor("Marin", "Vasile", adresa1, "Informatica");

        // 4. Creare Materii folosind Polimorfismul
        // (tipul de referinta este clasa de baza Materie, dar obiectul real este clasa copil Curs sau Laborator)
        Materie c1 = new Curs("Programare Orientata pe Obiecte", 5, true);
        Materie l1 = new Laborator("Laborator POO", 2, true);

        // 5. Testare adaugari in sistem
        System.out.println("--- INIT SISTEM ---");
        service.adaugaStudent(s1);
        service.adaugaStudent(s2);
        service.adaugaStudent(s3);

        service.adaugaProfesor(p1);
        service.adaugaMaterie(c1);
        service.adaugaMaterie(l1);

        // 6. Acordare note
        service.adaugaNotaStudent(1, new Nota(c1, 9.5));
        service.adaugaNotaStudent(1, new Nota(l1, 10));
        service.adaugaNotaStudent(2, new Nota(c1, 8.0));

        // 7. Afisari diverse
        service.afiseazaStudentiSortati();
        service.afiseazaProfesori();
        service.afiseazaMaterii();

        // 8. Calcul medie
        System.out.println("\n--- CALCUL MEDII ---");
        service.calculeazaMedieStudent(1);

        // 9. Afisare carnet
        service.afiseazaCarnetNote(1);

        // 10. Stergere student
        System.out.println("\n--- STERGERE ---");
        service.stergeStudent(2);
        service.afiseazaStudentiSortati(); // Verificam ca s-a sters studentul cu ID-ul 2
    }
}