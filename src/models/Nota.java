package models;

// Clasa de legatura care asociaza o Materie cu valoarea notei primite
public class Nota {
    // Compozitie: Nota contine un obiect de tip Materie (poate fi un Curs sau un Laborator datorita polimorfismului)
    private Materie materie;
    private double valoare;

    public Nota(Materie materie, double valoare) {
        this.materie = materie;
        this.valoare = valoare;
    }

    public Materie getMaterie() { return materie; }
    public void setMaterie(Materie materie) { this.materie = materie; }

    public double getValoare() { return valoare; }
    public void setValoare(double valoare) { this.valoare = valoare; }

    // Returnam numele materiei din obiectul materie, plus nota
    @Override
    public String toString() {
        return materie.getDenumire() + ": " + valoare;
    }
}