public class Associacio {
    
    // Atributos
    private int numero;
    private String titul;
    private String president;
    private String tesorer;
    private String secretari;
    private LlistaTitulacions titulacions;
    private LlistaMembres membres;

    // Constructor
    public Associacio(int numero, String titul, String president, String tesorer, String secretari, LlistaTitulacions titulacions, LlistaMembres membres) {
        this.numero = numero;
        this.titul = titul;
        this.president = president;
        this.tesorer = tesorer;
        this.secretari = secretari;
        this.titulacions = titulacions;
        this.membres = membres;
    }

    // Setters y Getters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitul() {
        return titul;
    }

    public void setTitul(String titul) {
        this.titul = titul;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getTesorer() {
        return tesorer;
    }

    public void setTesorer(String tesorer) {
        this.tesorer = tesorer;
    }

    public String getSecretari() {
        return secretari;
    }

    public void setSecretari(String secretari) {
        this.secretari = secretari;
    }

    public LlistaTitulacions getTitulacions() {
        return titulacions;
    }

    public void setTitulacions(LlistaTitulacions titulacions) {
        this.titulacions = titulacions;
    }

    public LlistaMembres getMembres() {
        return membres;
    }

    public void setMembres(LlistaMembres membres) {
        this.membres = membres;
    }

    // Método toString
    @Override
    public String toString() {
        return "Asociacio{" +
                "numero=" + numero +
                ", titul='" + titul + '\'' +
                ", president='" + president + '\'' +
                ", tesorer='" + tesorer + '\'' +
                ", secretari='" + secretari + '\'' +
                ", titulacions=" + titulacions +
                ", membres=" + membres +
                '}';
    }
}

