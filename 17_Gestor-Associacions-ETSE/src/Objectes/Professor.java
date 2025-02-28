package Objectes;
public class Professor extends Membre 
{
    private String nomDepartament; 
    private int numeroDespatx;

    /**
     * Constructor de la classe Professor.
     * 
     * @param nom            El nom del professor.
     * @param correu         El correu electrònic del professor.
     * @param nomDepartament El nom del departament del professor.
     * @param numeroDespatx  El número del despatx del professor.
     */

    public Professor(String alias, String correu, String nomDepartament, int numeroDespatx)
    {
        super(alias, correu);

        this.nomDepartament = nomDepartament;
        this.numeroDespatx = numeroDespatx;
    }

    /**
     * Constructor de la classe Professor estant assignat a varies associacions.
     * 
     * @param nom            El nom del professor.
     * @param correu         El correu electrònic del professor.
     * @param nomDepartament El nom del departament del professor.
     * @param numeroDespatx  El número del despatx del professor.
     * @param dataAlta       Llista dates de alta de associacions
     * @param associacions   La llista d'associacions del professor.
     * @param dataBaixa      Llista dates de baixa de associacions
     */
    public Professor (String alias, String correu, String nomDepartament, int numeroDespatx, LlistaDates datesAlta, LlistaAssociacio associacions, LlistaDates datesBaixa)
    {
        super(alias, correu, datesAlta, associacions, datesBaixa);

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
     * @param nomDepartament El nou nom del departament.
     */
    public void setNomDepartament(String nomDepartament) {
        this.nomDepartament = nomDepartament;
    }

    /**
     * Retorna el número del despatx del professor.
     * @return El número del despatx.
     */
    public int getNumeroDespatx() {
        return numeroDespatx;
    }

    /**
     * Estableix el número del despatx del professor.
     * @param numeroDespatx El nou número del despatx.
     */
    public void setNumeroDespatx(int numeroDespatx) {
        this.numeroDespatx = numeroDespatx;
    }

    /**
     * Retorna una representació en forma de cadena de l'objecte Professor.
     * @return Una cadena amb la informació del professor.
     */
    @Override
    public String toString() 
    {
        String text;
        text = super.toString(); // Obté la representació de la classe base

        text += "\nNom del Departament: " + nomDepartament;
        text += "\nNúmero del Despatx: " + numeroDespatx;
        return text;
    }
}
