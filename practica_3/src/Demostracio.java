public class Demostracio extends Accio {

    private int[] data_diseny = new int[3];
    private boolean valida;
    private int vegades_oferit;
    private double cost_material;
    
    // Constructor
    public Demostracio(String nom, String titol, Membre responsable, int num_Associa, int n_elem, boolean valida, int[] data, int oferit, double cost) {
        // Llama al constructor de Accio con los parámetros requeridos
        super(nom, titol, responsable, num_Associa);

        data_diseny = data;
        this.valida = valida;
        vegades_oferit = oferit;
        cost_material = cost;
    }

    public int[] getData_diseny() {
        return data_diseny;
    }

    public void setData_diseny(int[] data_diseny) {
        this.data_diseny = data_diseny;
    }

    public boolean isValida() {
        return valida;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }

    public int getVegades_oferit() {
        return vegades_oferit;
    }

    public void setVegades_oferit(int vegades_oferit) {
        this.vegades_oferit = vegades_oferit;
    }

    public double getCost_material() {
        return cost_material;
    }

    public void setCost_material(double cost_material) {
        this.cost_material = cost_material;
    }

    
}