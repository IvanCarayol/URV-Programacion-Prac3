public class Alumne extends Membre {

    // Atributs addicionals per la classe Alumne
    private boolean graduat; // Indica si l'alumne està graduat
    private Titulacio titulacio; // La titulació de l'alumne

    /**
     * Constructor de la classe Alumne.
     * 
     * @param nom          Nom del membre.
     * @param dataAlta     La data d'alta del membre.
     * @param correu       El correu electrònic del membre.
     * @param dataBaixa    La data de baixa del membre (pot ser null si encara està actiu).
     * @param associacions La llista d'associacions del membre.
     * @param graduat      Indica si l'alumne està graduat.
     * @param titulacio    La titulació de l'alumne.
     */
    public Alumne(String nom, Data[] dataAlta, String correu, Data[] dataBaixa, 
                  LlistaAssociacio associacions, boolean graduat, Titulacio titulacio) {
        super(nom, correu, dataAlta, dataBaixa, associacions);
        this.graduat = graduat;
        this.titulacio = titulacio;
    }

    /**
     * Retorna si l'alumne està graduat.
     * 
     * @return true si l'alumne està graduat, false altrament.
     */
    public boolean isGraduat() {
        return graduat;
    }

    /**
     * Estableix si l'alumne està graduat.
     * 
     * @param graduat true si l'alumne està graduat, false altrament.
     */
    public void setGraduat(boolean graduat) {
        this.graduat = graduat;
    }

    /**
     * Retorna la titulació de l'alumne.
     * 
     * @return La titulació de l'alumne.
     */
    public Titulacio getTitulacio() {
        return titulacio;
    }

    /**
     * Estableix la titulació de l'alumne.
     * 
     * @param titulacio La nova titulació de l'alumne.
     */
    public void setTitulacio(Titulacio titulacio) {
        this.titulacio = titulacio;
    }

    /**
     * Retorna una representació en forma de cadena de l'objecte Alumne.
     * 
     * @return Una cadena amb la informació de l'alumne.
     */
    @Override
    public String toString() {
        String aux;
        aux = super.toString(); // Obté la representació de la classe base
        aux += "\nGraduat: " + (graduat ? "Sí" : "No");
        aux += "\nTitulació: " + titulacio;
        return aux;
    }
}

