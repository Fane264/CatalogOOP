package models;

// Aceasta clasa reprezinta o adresa simpla cu oras si strada
public class Adresa {
    // Atributele sunt private pentru a proteja datele (Incapsulare)
    private String oras;
    private String strada;

    // Constructorul - este apelat cand cream un obiect nou de tip Adresa (ex: new Adresa("Bucuresti", "Eroilor"))
    public Adresa(String oras, String strada) {
        this.oras = oras;     // 'this.oras' se refera la atributul clasei, iar 'oras' la parametrul primit
        this.strada = strada;
    }

    // Metodele de tip Getter (pentru a citi datele) si Setter (pentru a modifica datele)
    public String getOras() { return oras; }
    public void setOras(String oras) { this.oras = oras; }

    public String getStrada() { return strada; }
    public void setStrada(String strada) { this.strada = strada; }

    // Suprascrierea metodei toString() din clasa parinte Object pentru a afisa adresa frumos in consola
    @Override
    public String toString() {
        return oras + ", str. " + strada;
    }
}