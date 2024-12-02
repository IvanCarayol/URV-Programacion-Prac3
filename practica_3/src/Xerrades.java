
public class Xerrades extends Accio {

    // Atributos específicos de la clase
    private Membre[] llistaMembres;      
    private Valoracio[] llistaValoracions; 
    private int nElem;

    // Constructor
    public Xerrades(String nom, String titol, Membre responsable, int num_Associa, int n_elem) {
        // Llama al constructor de Accio con los parámetros requeridos
        super(nom, titol, responsable, num_Associa);

        // Inicializa los atributos específicos de Xerrades
        this.llistaMembres = new Membre[nElem];
        this.llistaValoracions = new Valoracio[nElem];
        nElem = 0;
    }

    // Método para añadir un miembro a la lista
    public void afegirMembre(Membre membre) {
        if(nElem < llistaMembres.length) {
            llistaMembres[nElem] = membre;
            nElem++;
        }
    }

    // Método para añadir una valoración
    public void afegirValoracio(Valoracio valoracio) {
        if(nElem < llistaValoracions.length) {
            llistaValoracions[nElem] = valoracio;
            nElem++;
        }
    }

    // Método para mostrar información de la xerrada
    public String toString() {
        String text = "";

        text += "Xerrada: " + this.getTitol();
        text += "\nCodi: " + this.getCodi();
        text += "\nMembres " + nElem;
        text += "\nValoració " + nElem;
        // que hay que hacer con las valoracione y miembros, tengo en mente un for para imprimir todos los miembros con su valoracion
        return text;
    }
}
