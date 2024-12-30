package Objectes;

public class LlistaXerrades {
    private Xerrades[] llista; // Array para almacenar las xerrades
    private int nElem; // Número actual de xerrades almacenadas

    private static int MAX = 30;

    /**
     * Constructor que inicializa la llista de xerrades amb un tamany fixe.
     */
    public LlistaXerrades() {
        this.llista = new Xerrades[MAX];
        this.nElem = 0;
    }

    public LlistaXerrades(int num) {
        this.llista = new Xerrades[num];
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

    public void afegirXerrada(Xerrades xer){
        if(nElem < llista.length) {
            llista[nElem] = xer;
            nElem++;
        }
    }

    public boolean afegirXerrada(String nomXerrada, String titolXerrada, Membre responsable, LlistaAssociacio llistaAssociacions, Data dataXerrada){
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

        Xerrades novaXerrada = new Xerrades(nomXerrada, titolXerrada, responsable, llistaAssociacions, dataXerrada, 0);
        llista[posicionInsertar] = novaXerrada;
        nElem++;

        return true;
    }

    public LlistaXerrades xerradesMesAssisten(int num) {
        
        LlistaXerrades xer = new LlistaXerrades(nElem);

        for(int i = 0; i < nElem;i++) {
            if (llista[i].getnumMembres() > num) {
                xer.afegirXerrada(llista[i]);
            }

        }

        return xer;

    }
    
    /** 
     * Devuelve la xerrada mejor valorada. * 
     * 
     * @return La xerrada con la mejor valoración. 
    */

    public Xerrades getXerradaMejorValorada() { 
        if (nElem == 0) { 
            return null; // Cas que no hi hagin xerrades
        } 

        Xerrades mejorValorada = llista[0];     // Inicialitzem la primera xerrada de la llista com la millor valorada
        double mejorValoracionPromedio = calcularValoracionPromedio(mejorValorada); // Calculem la seva valoracio
        
        for (int i = 1; i < nElem; i++) { 
            double valoracionPromedio = calcularValoracionPromedio(llista[i]);
            if (valoracionPromedio > mejorValoracionPromedio) { 
                mejorValorada = llista[i]; 
                mejorValoracionPromedio = valoracionPromedio; 
            } 
        } 
        return mejorValorada;
    }

    /** 
     * Calcula la valoración promedio de una xerrada. 
     * @param xerrada La xerrada para la que se va a calcular la valoración promedio. 
     * @return La valoración promedio. */ 
    private double calcularValoracionPromedio(Xerrades xerrada) {
        
        double sumaValoraciones = 0;
        int numValoraciones = xerrada.getNumValoracions();  //Numero total de valoracions d'una xerrada
        
        if (numValoraciones == 0){
            return 0;
        }

        for (int i = 0; i < numValoraciones; i++) {
            sumaValoraciones += xerrada.getValoracioIndex(i).getValoracio();
        }

        return sumaValoraciones/numValoraciones;
    } 
}
