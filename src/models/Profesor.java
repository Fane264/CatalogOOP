package models;

// O alta clasa care extinde sablonul abstract Persoana.
public class Profesor extends Persoana {
    // Specific profesorului este departamentul (ex: "Matematica", "Informatica").
    private String departament;

    // Constructorul profesorului.
    public Profesor(String nume, String prenume, Adresa adresa, String departament) {
        // Trimitem datele de baza catre constructorul din clasa parinte (Persoana).
        super(nume, prenume, adresa);
        this.departament = departament;
    }

    public String getDepartament() { return departament; }
    public void setDepartament(String departament) { this.departament = departament; }

    // Reprezentarea sub forma de text a profesorului.
    @Override
    public String toString() {
        return "Profesor: " + nume + " " + prenume + " (" + departament + ")";
    }
}