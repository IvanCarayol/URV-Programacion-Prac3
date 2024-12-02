public class Titulacio {

    // Atributo
    private String nom;

    // Constructor
    public Titulacio(String nom) {
        this.nom = nom;
    }

    // Getter
    public String getNom() {
        return nom;
    }

    // Setter
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Método toString
    @Override
    public String toString() {
        return "Titulacio{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
