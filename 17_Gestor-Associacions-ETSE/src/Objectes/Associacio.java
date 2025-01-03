package Objectes;
import java.io.Serializable;

public class Associacio implements Serializable{
    
    // Atributos
    private String nom;
    private String correoContact;
    private Membre president;
    private Membre tesorer;
    private Membre secretari;
    private LlistaTitulacions titulacions;
    private LlistaMembres membres;

    // Constructor
    public Associacio(String nom, String correoContact, Membre president, Membre tesorer, Membre secretari, LlistaTitulacions titulacions, LlistaMembres membres) {
        this.nom = nom;
        this.correoContact = correoContact;
        this.president = president;
        this.tesorer = tesorer;
        this.secretari = secretari;
        this.titulacions = titulacions;
        this.membres = membres;
    }

    // Setters y Getters


    public String getNom() {
        return nom;
    }

    public void setNoml(String nom) {
        this.nom = nom;
    }

    public String getCorreuContact() {
        return correoContact;
    }

    public void setCorreuContact(String correo) {
        correoContact = correo;
    }

    public Membre getPresident() {
        return president;
    }

    public void setPresident(Membre president) {
        this.president = president;
    }

    public Membre getTesorer() {
        return tesorer;
    }

    public void setTesorer(Membre tesorer) {
        this.tesorer = tesorer;
    }

    public Membre getSecretari() {
        return secretari;
    }

    public void setSecretari(Membre secretari) {
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

    public void afegeixMembre(Membre membre) {
        membres.afegirMembre(membre);


        if (membre instanceof Alumne) {
            Titulacio titula = ((Alumne) membre).getTitulacio();

            titulacions.afegirTitulacio(titula);
            
        }
    }

    public void setMembres(LlistaMembres membres)
    {
        this.membres = membres;
    }

    // Método toString
    @Override
    public String toString() {
        return ("Asociacio{" +
                ", nom='" + nom + '\'' +
                ", president='" + president + '\'' +
                ", tesorer='" + tesorer + '\'' +
                ", secretari='" + secretari + '\'' +
                ", titulacions=" + titulacions +
                ", membres=" + membres +
                '}');
    }
}

