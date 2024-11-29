
public class Accio {
    private int codi;
    private String titol;
    private Associacio[] llistaAssociacio;
    private Membre responsable;
    private int[] data = new int[3]; // Array de 3 enteros [día, mes, año]
    private boolean valida;
    private float[] llistaCostos;
    private int n_asso;
    private int n_costo;

    // Constructor
    public Accio(int codi, String titol, Membre responsable, int[] data, boolean valida, int num_Associa, int n_costos) {
        this.codi = codi;
        this.titol = titol;
        this.llistaAssociacio = new Associacio[num_Associa];
        this.responsable = responsable;
        this.data = data;
        this.valida = valida;
        this.llistaCostos = new float[n_costos];
        n_asso = 0;
        n_costo = 0;
    }

    // Getters y Setters
    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
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

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        if (data.length == 3) { // Validamos que tenga 3 elementos (día, mes, año)
            this.data = data;
        } else {
            throw new IllegalArgumentException("La fecha debe contener exactamente 3 valores: día, mes y año.");
        }
    }

    public boolean isValida() {
        return valida;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }

    public float[] getLlistaCostos() {
        return llistaCostos;
    }

    public void agregarLlistaAssociacio(Associacio associacio) {
        if(n_asso < this.llistaAssociacio.length) {
            this.llistaAssociacio[n_asso] = associacio;
            n_asso++;
        }
    }

    // Método para agregar un costo a la lista de costos
    public void agregarCosto(float costo) {
        if(n_costo < this.llistaAssociacio.length) {
            this.llistaCostos[n_costo] = costo;
            n_costo++;
        }
    }

    // Método para mostrar la información de la acción
    @Override
    public String toString() {
        return "Accio{" +
                "codi=" + codi +
                ", titol='" + titol + '\'' +
                ", llistaAssociacio=" + llistaAssociacio +
                ", responsable=" + responsable +
                ", data=" + data[0] + "/" + data[1] + "/" + data[2] +
                ", valida=" + valida +
                ", llistaCostos=" + llistaCostos +
                '}';
    }
}
