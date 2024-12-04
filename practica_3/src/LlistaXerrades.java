public class LlistaXerrades {
    private Xerrades[] llista; // Array para almacenar las xerrades
    private int nElem; // Número actual de xerrades almacenadas

    private static int MAX = 500;

    /**
     * Constructor que inicializa la llista de xerrades amb un tamany fixe.
     */
    public LlistaXerrades() {
        this.llista = new Xerrades[MAX];
        this.nElem = 0;
    }

    /**
     * Llista les xerrades que es troben dintre d'una franja de dates indicades.
     *
     * @param inici Data d'inici de la franja.
     * @param fi Data de fi de la franja.
     * @return Array amb les xerrades que es troben dintre de la franja.
     */
    public Xerrades[] llistarEnFranja(Data inici, Data fi) {
        // Array temporal para almacenar las xerrades filtradas
        Xerrades[] validas = new Xerrades[nElem];
        int pos = 0;

        for (int i = 0; i < nElem; i++) {
            Data dataXerrada = llista[i].getData();
            if (inici.compararDatas(dataXerrada, inici) && dataXerrada.compararDatas(fi, dataXerrada)){
                validas[pos] = llista[i];
                pos++;
            }
        }

        return validas;
    }

    public boolean afegirXerrada(String nomXerrada, String titolXerrada, Membre responsable, int numeroAssociacions, Data dataXerrada){
        if(nElem >= llista.length){
            return false;
        }

        int posicionInsertar = 0;
        boolean trobat = false;
        
        while(posicionInsertar < nElem && !trobat){
            Data data1 = llista[posicionInsertar].getData();
            Data data2 = llista[posicionInsertar + 1].getData();
            if (dataXerrada.compararDatas(dataXerrada, data1)){
                if(dataXerrada.compararDatas(data2, dataXerrada)){
                    trobat = true;
                }
            }
            posicionInsertar++;
        }

        if (posicionInsertar < nElem) {
            for (int i = nElem; i > posicionInsertar; i--) {
                llista[i] = llista[i - 1];
            }
        }

        Xerrades novaXerrada = new Xerrades(nomXerrada, titolXerrada, responsable, numeroAssociacions, dataXerrada, 0);
        llista[posicionInsertar] = novaXerrada;
        nElem++;

        return true;
    }
}

