public class Demostracio extends Accio {

    private boolean valida;
    private int vegades_oferit;
    private double cost_material;
    
    // Constructort_material = cost;
    public Demostracio(String nom, String titol, Membre responsable, LlistaAssociacio lAssocia, Data data, boolean valida, int oferit, double cost) {
        // Llama al constructor de Accio con los parámetros requeridos
        super(nom, titol, responsable, lAssocia, data);

        this.valida = valida;
        vegades_oferit = oferit;
        cost_material = cost;
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

    @Override
    public String toString() {
        
        String text = super.toString(); 
        
        
        text += ", valida=" + valida +
                ", vegades_oferit=" + vegades_oferit +
                ", cost_material=" + cost_material + "$";
        
        return text;
    }

    
}