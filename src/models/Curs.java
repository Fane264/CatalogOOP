package models;

// Extinde Materie pentru a adauga functionalitati specifice unui curs teoretic
public class Curs extends Materie {
    // Proprietate specifica doar cursului
    private boolean areExamenScris;

    public Curs(String denumire, int credite, boolean areExamenScris) {
        // Transmite denumirea si creditele la clasa de baza Materie
        super(denumire, credite);
        this.areExamenScris = areExamenScris;
    }

    public boolean isAreExamenScris() { return areExamenScris; }
    public void setAreExamenScris(boolean areExamenScris) { this.areExamenScris = areExamenScris; }

    @Override
    public String toString() {
        return "Curs: " + denumire + " (Credite: " + credite + ")";
    }
}