package Objectes;
public class Xerrades extends Accio {

    private LlistaMembres lMembres;      
    private LlistaValoracio lValoracions; 
    private int nElem;
    private int nElemMAX;

    // Constructor
    public Xerrades(String nom, String titol, Membre responsable, LlistaAssociacio lAssocia, Data date, int n_max) {
        
        super(nom, titol, responsable, lAssocia, date);

        lMembres = new LlistaMembres(n_max);
        lValoracions = new LlistaValoracio(n_max, nom);
        nElemMAX = n_max;
        nElem = 0;
    }

    public int numAssisten() {
        return lMembres.getNumelem();
    }

    public int getNumValoracions(){
        return lValoracions.getnElem();
    }

    public Valoracio getValoracioIndex(int index) { 
        return lValoracions.getValo(index); 
    }

    /**
     * afegir membre amb la seva valoracio
     * @param membre de tipus Membre
     * @param valoracio de tipus Valoracio
     */
    public void afegirMembreValoracio(Valoracio valoracio) {
        if(nElem < nElemMAX) {
            lMembres.afegirMembre(valoracio.getMembre());
            lValoracions.afegirValoracio(valoracio);
            nElem++;
        }
    }

    /**
     * Añade una valoración para la xerrada.
     * @param valoracio La valoración a añadir. 
    */ 
    public void valorarXerrada(Valoracio valoracio) {
        if (valoracio != null && valoracio.valoracioValida(valoracio.getValoracio())){ 
            lValoracions.afegirValoracio(valoracio); 
        } else { 
            throw new IllegalArgumentException("La valoración no es válida."); 
        } 
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
