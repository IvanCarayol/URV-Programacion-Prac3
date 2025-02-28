package Objectes;

public class Accio {
    private String codi;
    private String nom;
    private String titol;
    private LlistaAssociacio llistaAssociacio;
    private Membre responsable;
    private Data data;
    private static int num_id = 100;

    // Constructor
    public Accio(String nom, String titol, Membre responsable, LlistaAssociacio lAssocia, Data date) {
        creacio_codi(nom);
        this.nom = nom;
        this.titol = titol;
        this.llistaAssociacio = lAssocia;
        this.responsable = responsable;
        data = date.copia();
    }
        
    /**
     * Creacio del codi de cada accio
     * @param n tipus String es al titol
     */
    private void creacio_codi(String n) {
        String codeAux = "";
        codeAux+= n.substring(0, 3);
        codeAux+= num_id + "";
        num_id++;
        this.codi = codeAux;
    }
        
            // Getters y Setters
    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public LlistaAssociacio getLlistaAssociacio() {
        return llistaAssociacio;
    }

    public Membre getResponsable() {
        return responsable;
    }

    public void setResponsable(Membre responsable) {
        this.responsable = responsable;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data date) {
        data = date.copia();
    }

    // Método para mostrar la información de la acción
    
    public String toString() {
        
        
        String text = "Accio{" +
                "codi=" + codi +
                ", nom= " + nom +
                ", titol= " + titol +
                ", responsable=" + responsable.getAlias() +
                ", llistaAssociacio: (";

        int num = llistaAssociacio.getNumelem();
        Associacio assocacioAux;
        for(int i = 0; i < num - 1;i++) {
            assocacioAux = llistaAssociacio.getAsociacioAt(i);
            text += assocacioAux.getNom() + ", ";
            
        }
        
        assocacioAux = llistaAssociacio.getAsociacioAt(num-1);
        text += assocacioAux.getNom() + ")}";

        return text;
    }

    /**
     * Mira si hay una associacion en la accion indicada
     * @param as associacion
     * @return  boolean true o false si esta o no esta
     */
    public boolean esAssociacioDeAccio(Associacio as) {

        Associacio asAux = llistaAssociacio.getAssociacioAmbNom(as.getNom());

        if(asAux == null) return false;
        return true;
    }
}
