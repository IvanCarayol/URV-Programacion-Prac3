package Objectes;

/**
 * Classe que representa una llista de valoracions
 */
public class LlistaValoracio {
    private static int TAMANY = 500;

    private Valoracio[] valoracions;
    private int nElem;
    private String IDXerrada;

    /**
     * Constructor per defecte.
     * Inicialitza un array buit amb una mida inicial.
     */
    public LlistaValoracio() {
        this.valoracions = new Valoracio[TAMANY]; 
        this.nElem = 0;
    }

    public LlistaValoracio(int n, String IDXerrada) {
        this.valoracions = new Valoracio[n];
        this.nElem = 0;
        this.IDXerrada = IDXerrada;
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
            if (valoracions[i] != null && valoracions[i].equals(valoracio)) {
                moureElements(i);
                nElem--;
                return true;
            }
            i++;
        }
        return false;
    }

    public int getnElem() {
        return nElem;
    } 

    public String getIDXerrada(){
        return IDXerrada;
    }

    public Valoracio getValo(int n) {
        if (n < 0 || n >= nElem) {  
            throw new IndexOutOfBoundsException("Índex fora de rang: " + n);
        }
        return valoracions[n]; 
    }

    /**
     * Realitza una còpia de la llista de valoracions.
     * 
     * @return una nova instància de LlistaValoracio amb els mateixos elements
     */
    public LlistaValoracio copia() {
        LlistaValoracio copiaLlista = new LlistaValoracio(nElem, this.IDXerrada); 
        for (int i = 0; i < nElem; i++) {
            copiaLlista.afegirValoracio(valoracions[i].copia());  
        }
        return copiaLlista;
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
        valoracions[nElem - 1] = null; 
    }

        /**
     * Obté totes les valoracions en forma de cadena.
     * 
     * @return una cadena amb totes les valoracions, separades per salts de línia, 
     *         excepte després de la última valoració.
     */
    public String toString() {
        String aux = "";
    
        for (int i = 0; i < valoracions.length; i++) {
            if (valoracions[i] != null) {  
                aux += valoracions[i].toString();
                aux += " Per la xerrada "+IDXerrada;
            }
    
            if (i < valoracions.length - 1 && valoracions[i] != null) { 
                aux += "\n";
            }
        }
        return aux;
    }
    
}
