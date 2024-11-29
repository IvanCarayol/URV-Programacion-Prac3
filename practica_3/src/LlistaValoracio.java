/**
 * Classe que representa una llista de valoracions
 */
public class LlistaValoracio {
    private static int TAMANY = 500;

    private Valoracio[] valoracions;
    private int nElem; // Nombre actual d'elements emmagatzemats

    /**
     * Constructor per defecte.
     * Inicialitza un array buit amb una mida inicial.
     */
    public LlistaValoracio() {
        this.valoracions = new Valoracio[TAMANY]; // Capacitat inicial
        this.nElem = 0;
    }

    /**
     * Afegeix una nova valoració a la llista si aquesta no esta plena.
     *
     * @param valoracio la valoració a afegir
     * @throws IllegalStateException si l'array està ple
     */
    public void afegirValoracio(Valoracio valoracio) {
        if (nElem == valoracions.length) {
            throw new IllegalStateException("L'array està ple. No es poden afegir més valoracions.");
        }
        valoracions[nElem] = valoracio;
        nElem++;
    }

    /**
     * Elimina una valoració de la llista.
     *
     * @param valoracio la valoració a eliminar
     * @return true si s'ha eliminat correctament, false si no s'ha trobat
     */
    public boolean eliminarValoracio(Valoracio valoracio) {
        int i = 0;

        while (i < valoracions.length) {
            if (valoracions[i].equals(valoracio)) {
                moureElements(i);
                nElem--;
                return true;
            }
            i++;
        }
        return false;
    }

    /**
     * Obté totes les valoracions en forma de cadena.
     * 
     * @return una cadena amb totes les valoracions, separades per salts de línia, 
     *         excepte després de la última valoració.
     */
    public String toString() {
        String aux = "";

        for (int i = 0; i < valoracions.length; i++){
            aux += valoracions[i].toString();

            if(i < valoracions.length - 1){                 //salt de linia entre valoracions menys al final
                aux += "\n";
            }
        }
        return aux;
    }

    /**
     * Desplaça els elements de l'array cap a l'esquerra per omplir un espai buit.
     *
     * @param index l'índex a partir del qual cal desplaçar
     */
    private void moureElements(int pos) {
        for (int i = pos; i < valoracions.length - 1; i++) {
            valoracions[i] = valoracions[i + 1];
        }
        valoracions[nElem - 1] = null; // Hem d'eliminar l'últim element
    }
}
