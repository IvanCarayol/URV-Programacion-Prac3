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
     * Constructor de la classe Professor estant assignat a una associació.
     * 
     * @param nom            El nom del professor.
     * @param correu         El correu electrònic del professor.
     * @param dataAlta       La data d'alta del professor.
     * @param dataBaixa      La data de baixa del professor
     * @param associacions   La llista d'associacions del professor.
     * @param nomDepartament El nom del departament del professor.
     * @param numeroDespatx  El número del despatx del professor.
     */

    public Professor (String alias, String correu, Data dataAlta, Data dataBaixa, Associacio associacio, String nomDepartament, int numeroDespatx)
    {
        super(alias, correu, dataAlta, dataBaixa, associacio);

        this.nomDepartament = nomDepartament;
        this.numeroDespatx = numeroDespatx;
    }

    /**
     * Constructor de la classe Professor estant assignat a varies associacions.
     * 
     * @param nom            El nom del professor.
     * @param correu         El correu electrònic del professor.
     * @param dataAlta       Llista dates de alta de associacions
     * @param dataBaixa      Llista dates de baixa de associacions
     * @param associacions   La llista d'associacions del professor.
     * @param nomDepartament El nom del departament del professor.
     * @param numeroDespatx  El número del despatx del professor.
     */
    public Professor (String alias, String correu, Data[] dataAlta, Data[] dataBaixa, LlistaAssociacio associacions, String nomDepartament, int numeroDespatx)
    {
        super(alias, correu, dataAlta, dataBaixa, associacions);

        this.nomDepartament = nomDepartament;
        this.numeroDespatx = numeroDespatx;
    }

    /**
     * Retorna el nom del departament del professor.
     * 
     * @return El nom del departament.
     */
    public String getNomDepartament() 
    {
        return nomDepartament;
    }

    /**
     * Estableix el nom del departament del professor.
     * @param nomDepartament El nou nom del departament.
     */
    public void setNomDepartament(String nomDepartament) 
    {
        this.nomDepartament = nomDepartament;
    }

    /**
     * Retorna el número del despatx del professor.
     * @return El número del despatx.
     */
    public int getNumeroDespatx() 
    {
        return numeroDespatx;
    }

    /**
     * Estableix el número del despatx del professor.
     * @param numeroDespatx El nou número del despatx.
     */
    public void setNumeroDespatx(int numeroDespatx) 
    {
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
