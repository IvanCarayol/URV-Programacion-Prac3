/**
 * Classe que representa una valoració feta per un membre.
 * Conté el nom del membre i la valoració numèrica.
 */
public class Valoracio {
    private static int VALORACIONMINIMA = 0;
    private static int VALORACIONMAXIMA = 10;
    
    private String membre;
    private int valoracio;

    /**
     * Constructor sense paràmetres
     * Inicialitza el membre amb una cadena buida i una valoracio de 0
     */
    public Valoracio() {
        this.membre = "";
        this.valoracio = 0;
    }

    /**
     * Constructor amb paràmetres.
     * Permet inicialitzar el nom del membre i la valoració numèrica.
     *
     * @param membre    el nom del membre que fa la valoració
     * @param valoracio la valoració numèrica feta pel membre
     */
    public Valoracio(String membre, int valoracio) {
        this.membre = membre;
        this.valoracio = valoracio;
    }

    /**
     * Obté el nom del membre que ha fet la valoració.
     *
     * @return el nom del membre
     */
    public String getMembre() {
        return membre;
    }

    /**
     * Obté la valoració numèrica feta pel membre.
     *
     * @return la valoració numèrica
     */
    public int getValoracio() {
        return valoracio;
    }

    /**
     * Estableix el nom del membre que fa la valoració.
     *
     * @param membre el nou nom del membre
     */
    public void setMembre(String membre) {
        this.membre = membre;
    }

    /**
     * Estableix una nova valoració numèrica feta pel membre.
     * Comprova que la valoració sigui vàlida abans de guardar-la.
     *
     * @param valoracio la nova valoració numèrica
     * @throws IllegalArgumentException si la valoració no és dins el rang permès (Definit per dos statics)
     */
    public void setValoracio(int valoracio) {
        if (valoracioValida(valoracio)) {
            this.valoracio = valoracio;
        } else {
            throw new IllegalArgumentException("La valoració ha de ser entre "+VALORACIONMINIMA+" i "+VALORACIONMAXIMA+".");
        }
    }

    /**
     * Retorna una representació en cadena de la valoració.
     *
     * @return una cadena que descriu la valoració
     */
    @Override
    public String toString() {
        return ("Valoracio del membre "+membre+" es igual a "+valoracio+".");
    }

    /**
     * Verifica si una valoració està dins del rang permès.
     *
     * @param valoracion la valoració a comprovar
     * @return true si la valoració és vàlida (dins el rang permès), false en cas contrari
     */
    public boolean valoracioValida(int valoracion){
        if (valoracion <= VALORACIONMAXIMA && valoracion >= VALORACIONMINIMA){
            return true;
        }
        return false;
    }
}