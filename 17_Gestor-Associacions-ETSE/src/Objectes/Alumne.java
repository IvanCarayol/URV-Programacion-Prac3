package Objectes;
public class Alumne extends Membre
{
    private boolean graduat = false;
    private Titulacio titulacio;

    /**
     * Constructor de la clase Alumne sense estar assignat a una associació
     * 
     * @param alias     Nom del alumne
     * @param correu    Correu electronic del alumne
     * @param titulacio Titulació del alumne
     * @param graduat   Graduat?
     */
    public Alumne(String alias, String correu, Titulacio titulacio, boolean graduat)
    {
        super(alias, correu);

        this.titulacio = titulacio;
        this.graduat = graduat;
    }

    /**
     * Constructor de la classe alumnse estant assignat a varies associacions
     * 
     * @param alias         Nom del alumne
     * @param correu        Correu electronic del alumne
     * @param titulacio     Titulacio del alumne
     * @param graduat       Graduat?
     * @param dataAlta      Llista dates de alta del alumne a la associació
     * @param associacio    Llista associacion assignades al alumne
     * @param dataBaixa     Llista date de baixa del alumne a la associació
     */
    public Alumne(String alias, String correu, Titulacio titulacio, boolean graduat, LlistaDates datesAlta, LlistaAssociacio associacions, LlistaDates datesBaixa)
    {
        super(alias, correu, datesAlta, associacions, datesBaixa);

        this.titulacio = titulacio;
        this.graduat = graduat;
    }

    /**
     * Retorna la titulació del alumne
     * @return Titulació del alumne
     */
    public Titulacio getTitulacio() 
    {
        return titulacio;
    }

    /**
     * Retorna TRUE si graduat FALSE si no
     * @return graduat?
     */
    public boolean isGraduat()
    {
        return graduat;
    }

    /**
     * Estableix la titulació del alumne
     * @param titulacio Titulació del alumne
     */
    public void setTitulacio (Titulacio titulacio)
    {
        this.titulacio = titulacio;
    }

    /**
     * Estableix si el alumne esta graduat o no
     * @param graduat   Graduat?
     */
    public void setGraduat (boolean graduat)
    {
        this.graduat = graduat;
    }

    @Override
    public String toString()
    {
        String text;
        text = super.toString();

        text += "Titulacio: "+titulacio.getNom()+"\n";
        if (graduat) {text += "Graduat: Si\n";} 
            else { text += "Graduat: No\n"; }
        return text;
    }
        
}