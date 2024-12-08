public class Professor extends Membre {

    // Atributs addicionals per la classe Professor
    private String nomDepartament; // El nom del departament del professor
    private int numeroDespatx; // El número del despatx del professor

    /**
     * Constructor de la classe Professor.
     * 
     * @param nom            El nom del membre.
     * @param dataAlta       La data d'alta del membre.
     * @param correu         El correu electrònic del membre.
     * @param dataBaixa      La data de baixa del membre (pot ser null si encara està actiu).
     * @param associacions   La llista d'associacions del membre.
     * @param nomDepartament El nom del departament del professor.
     * @param numeroDespatx  El número del despatx del professor.
     */
    public Professor(String alias, Data dataAlta, String correu, Data dataBaixa, 
                     LlistaAssociacio associacions, String nomDepartament, int numeroDespatx) {
        super(alias, dataAlta, correu, dataBaixa, associacions);
        this.nomDepartament = nomDepartament;
        this.numeroDespatx = numeroDespatx;
    }

    /**
     * Retorna el nom del departament del professor.
     * 
     * @return El nom del departament.
     */
    public String getNomDepartament() {
        return nomDepartament;
    }

    /**
     * Estableix el nom del departament del professor.
     * 
     * @param nomDepartament El nou nom del departament.
     */
    public void setNomDepartament(String nomDepartament) {
        this.nomDepartament = nomDepartament;
    }

    /**
     * Retorna el número del despatx del professor.
     * 
     * @return El número del despatx.
     */
    public int getNumeroDespatx() {
        return numeroDespatx;
    }

    /**
     * Estableix el número del despatx del professor.
     * 
     * @param numeroDespatx El nou número del despatx.
     */
    public void setNumeroDespatx(int numeroDespatx) {
        this.numeroDespatx = numeroDespatx;
    }

    /**
     * Retorna una representació en forma de cadena de l'objecte Professor.
     * 
     * @return Una cadena amb la informació del professor.
     */
    @Override
    public String toString() {
        String aux;
        aux = super.toString(); // Obté la representació de la classe base
        aux += "\nNom del Departament: " + nomDepartament;
        aux += "\nNúmero del Despatx: " + numeroDespatx;
        return aux;
    }
}
