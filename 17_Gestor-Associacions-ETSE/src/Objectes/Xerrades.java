package Objectes;
public class Xerrades extends Accio {

    private LlistaMembres lMembres;      
    private LlistaValoracio lValoracions; 
    private int nMem;
    private int nValo;
    private int nElemMAX;

    // Constructor
    public Xerrades(String nom, String titol, Membre responsable, LlistaAssociacio lAssocia, Data date, int n_max) {
        
        super(nom, titol, responsable, lAssocia, date);

        lMembres = new LlistaMembres(n_max);
        lValoracions = new LlistaValoracio(n_max, nom);
        nElemMAX = n_max;
        nMem = 0;
        nValo = 0;
    }

    public int getnumMembres() {
        return nMem;
    }

    public void setLlistaValoracions(LlistaValoracio valoracions){
        lValoracions = valoracions;
    }

    public int getNumValoracions(){
        return nValo;
    }

    public Valoracio getValoracioIndex(int index) { 
        return lValoracions.getValo(index); 
    }

    /**
     * Afegir membre amb la seva valoracio
     * @param membre de tipus Membre
     * @param valoracio de tipus Valoracio
     */
    public void afegirMembreValoracio(Valoracio valoracio) {
        if(nValo < nElemMAX && nMem < nElemMAX) {
            lMembres.afegirMembre(valoracio.getMembre());
            lValoracions.afegirValoracio(valoracio);
            nValo++;
            nMem++;
        }
    }

    /**
     * Añade una valoración para la xerrada.
     * @param valoracio La valoración a añadir. 
    */ 
    public void valorarXerrada(Valoracio valoracio) {
        if(nValo < nElemMAX) {
            if (valoracio != null && valoracio.valoracioValida(valoracio.getValoracio())){ 
                lValoracions.afegirValoracio(valoracio); 
                nValo++;
            } else { 
                throw new IllegalArgumentException("La valoración no es válida."); 
            } 
        }
    }

    public void afegirMembre(Membre membre) {
        if(nValo < nElemMAX) {
            lMembres.afegirMembre(membre);
            nMem++;
        }
    }

    public int getNumMax() {
        return nElemMAX;
    }

    @Override
    public String toString() {
        
        String text = super.toString(); 
        
        for(int i = 0; i < lValoracions.getnElem(); i++) {
            Valoracio val = lValoracions.getValo(i);
            text += "(Membre: " + val.getMembre().getAlias() + " - Valoracio: " + val.getValoracio() + ")";
        }
        return text;
    }

}
