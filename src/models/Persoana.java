package models;

// Clasa abstracta - defineste un sablon de baza. Nu putem face "new Persoana()".
public abstract class Persoana {
    // Folosim 'protected' in loc de 'private' ca aceste variabile sa poata fi accesatein clasele copil (Student si Profesor)
    protected String nume;
    protected String prenume;
    protected Adresa adresa;

    // Constructorul clasei de baza care va fi apelat de clasele copil folosind cuvantul "super".
    public Persoana(String nume, String prenume, Adresa adresa) {
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
    }

    // Getteri si Setteri pentru datele personale.
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getPrenume() { return prenume; }
    public void setPrenume(String prenume) { this.prenume = prenume; }

    public Adresa getAdresa() { return adresa; }
    public void setAdresa(Adresa adresa) { this.adresa = adresa; }
}