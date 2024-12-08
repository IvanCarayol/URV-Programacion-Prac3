import java.nio.channels.MembershipKey;

public class Xerrades extends Accio {

    // Atributos específicos de la clase
    private LlistaMembres lMembres;      
    private LlistaValoracio lValoracions; 

    // Constructor
    public Xerrades(String nom, String titol, Membre responsable, int num_Associa, Data date, int n_elem) {
        // Llama al constructor de Accio con los parámetros requeridos
        super(nom, titol, responsable, num_Associa, date);

        // Inicializa los atributos específicos de Xerrades
        lMembres = new LlistaMembres(n_elem);
        lValoracions = new LlistaValoracio(n_elem);
    }

    public Xerrades(String nom, String titol, Membre responsable, LlistaAssociacio lAssocia, Data date, int n_elem) {
        // Llama al constructor de Accio con los parámetros requeridos
        super(nom, titol, responsable, lAssocia, date);

        // Inicializa los atributos específicos de Xerrades
        lMembres = new LlistaMembres(n_elem);
        lValoracions = new LlistaValoracio(n_elem);
    }

    /**
     * afegir membre amb la seva valoracio
     * @param membre de tipus Membre
     * @param valoracio de tipus Valoracio
     */
    public void afegirMembreValoracio(Membre membre, Valoracio valoracio) {
        
            lMembres.afegirMiembro(membre);
            lValoracions.afegirValoracio(valoracio);
    }


    /**
     * Método para mostrar información de la xerrada
     */
    public String toString() {
        String text = "";

        text += "Xerrada: " + this.getTitol();
        text += " - Codi: " + this.getCodi();
        for(int i = 0; i < lValoracions.getnElem(); i++) {
            Valoracio val = lValoracions.getValo(i);
            text += "\nMembre: " + val.getMembre().getAlias() + " - Valoracio: " + val.getValoracio();
        }
        // que hay que hacer con las valoracione y miembros, tengo en mente un for para imprimir todos los miembros con su valoracion
        return text;
    }

}
