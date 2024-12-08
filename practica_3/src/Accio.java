
public class Accio {
    private String codi;
    private String nom;
    private String titol;
    private LlistaAssociacio llistaAssociacio;
    private Membre responsable;
    private Data data;
    private static int num_id = 100;

    // Constructor
    public Accio(String nom, String titol, Membre responsable, int num_Associa, Data date) {
        creacio_codi(nom);
        this.nom = nom;
        this.titol = titol;
        this.llistaAssociacio = new LlistaAssociacio(num_Associa);
        this.responsable = responsable;
        data = date.copia();
    }

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
     * @param tit tipus String es al titol
     */
    private void creacio_codi(String tit) {
        String codeAux = "";
        codeAux+= tit.substring(0, 3);
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
    @Override
    public String toString() {
        return "Accio{" +
                "codi=" + codi +
                ", nom= " + nom +
                ", titol= " + titol +
                ", llistaAssociacio=" + llistaAssociacio +
                ", responsable=" + responsable +
                '}';
    }
}
