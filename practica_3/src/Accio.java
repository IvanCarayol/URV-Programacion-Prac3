
public class Accio {
    private String codi;
    private String nom;
    private String titol;
    private Associacio[] llistaAssociacio;
    private Membre responsable;
    private Data data;
    private int n_asso;
    private static int num_id = 100;

    // Constructor
    public Accio(String nom, String titol, Membre responsable, int num_Associa, Data date) {
        creacio_codi(nom);
        this.nom = nom;
        this.titol = titol;
        this.llistaAssociacio = new Associacio[num_Associa];
        this.responsable = responsable;
        data = date.copia();
        n_asso = 0;
    }
        
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

    public Associacio[] getLlistaAssociacio() {
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

    public void agregarAssociacio(Associacio associacio) {
        if(n_asso < this.llistaAssociacio.length) {
            this.llistaAssociacio[n_asso] = associacio;
            n_asso++;
        }
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
