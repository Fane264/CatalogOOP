package models;

// Clasa abstracta pentru o materie generica, nu poate fi instantiata direct
public abstract class Materie {
    // Atribute protected pentru a fi vazute in clasele Curs si Laborator care le mostenesc
    protected String denumire;
    protected int credite;

    public Materie(String denumire, int credite) {
        this.denumire = denumire;
        this.credite = credite;
    }

    public String getDenumire() { return denumire; }
    public void setDenumire(String denumire) { this.denumire = denumire; }

    public int getCredite() { return credite; }
    public void setCredite(int credite) { this.credite = credite; }
}