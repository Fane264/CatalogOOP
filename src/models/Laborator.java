package models;

// Extinde Materie pentru a adauga functionalitati specifice unui laborator practic.
public class Laborator extends Materie {
    // Proprietate specifica doar laboratorului.
    private boolean prezentaObligatorie;

    public Laborator(String denumire, int credite, boolean prezentaObligatorie) {
        super(denumire, credite);
        this.prezentaObligatorie = prezentaObligatorie;
    }

    public boolean isPrezentaObligatorie() { return prezentaObligatorie; }
    public void setPrezentaObligatorie(boolean prezentaObligatorie) { this.prezentaObligatorie = prezentaObligatorie; }

    @Override
    public String toString() {
        return "Laborator: " + denumire + " (Credite: " + credite + ")";
    }
}