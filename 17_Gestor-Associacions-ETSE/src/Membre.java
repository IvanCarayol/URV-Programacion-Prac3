import java.io.Serializable;

public abstract class Membre implements Serializable
{
    static int NUM_MAX = 3;
    private String alias;
    private LlistaDates datesAlta;
    private String correu;
    private LlistaDates datesBaixa;
    private LlistaAssociacio associacions;

    /**
     * Constructor de la classe Membre sense estar assginat a una associació
     * 
     * @param alias     Nom del membre
     * @param correu    Correu electronic del membre
     */
    public Membre(String alias, String correu) 
    {
        this.alias = alias;
        this.correu = correu;
        datesAlta = new LlistaDates(NUM_MAX);
        datesBaixa = new LlistaDates(NUM_MAX);
        associacions = new LlistaAssociacio(NUM_MAX);
    }

    /**
     * Constructor de la classe Membre estant assignat a varies associacions
     * 
     * @param alias         Alias del membre
     * @param correu        Correu electronic del membre
     * @param dataAlta      Llista dates de alta a la associació
     * @param dataBaixa     Llista dates de baixa a la associació
     * @param associacio    LLista associacions assignada al membre
     */
    public Membre(String alias, String correu, LlistaDates datesAlta, LlistaAssociacio associacions, LlistaDates datesBaixa)
    {
        this.alias = alias;
        this.correu = correu;
        this.datesAlta = datesAlta;
        if (datesBaixa != null) { this.datesBaixa = datesBaixa; }else { datesBaixa = new LlistaDates(NUM_MAX); }
        this.datesBaixa = datesBaixa;
        this.associacions = associacions;
    }

    /**
     * Retorna el alias del membre
     * 
     * @return Alias del membre
     */
    public String getAlias() 
    {
        return this.alias;
    }

      /**
     * Retorna el correu electronic del membre
     * 
     * @return Correu electronic del membre
     */
    public String getCorreu() 
    {
        return this.correu;
    }

    /**
     * Retorna la llista de dates de alta de les associacions del membre 
     * @return Llista de dates de alta
     */
    public LlistaDates getLlistaDatesAlta()
    {
        return datesAlta;
    }

    /**
     * Retorna la llista de dates de Baixa de les associacions del membre 
     * @return Llista de dates de Baixa
     */
    public LlistaDates getLlistaDatesBaixa()
    {
        return datesBaixa;
    }

    /**
     * Retorna la llista de associacions del membre
     * @return llista associacions membre
     */
    public LlistaAssociacio getLlistaAssociacions() 
    {
        return associacions;
    }

    /**
     * Assigna un nou alias al membre
     * @param alias Nou alias
     */
    public void setAlias(String alias) 
    {
        this.alias = alias;
    }

    /**
     * Assigna un nou correu electronic al membre
     * @param correu    Nou correu electronica
     */
    public void setCorreu(String correu) 
    {
        this.correu = correu;
    }

    /**
     * Assigna una nova llista de associacions al membre
     * @param associacions  Llista associacions
     */
    public void setLlistaAssociacion(LlistaAssociacio associacions) 
    {
        this.associacions = associacions;
    }

    /**
     * Afegeix una associació al membre
     * @param associacio    Associació a assignar
     * @param dataIni       Data de assignació
     */
    public void afegiraAsociacio(Associacio associacio, Data dataIni) 
    {
        int numAssociacions = associacions.getNumelem();

        if (numAssociacions < 3) 
        {
            associacions.afegirAsociacio(associacio);
            this.datesAlta.afegirData(dataIni);
        } 
        else 
        {
            System.out.println("ERROR: Ja està inscrit a 3 associacions");
        }
    }

    public String toString() 
    {
        String text;

        text = "Alias: " + alias + "\n";
        text += "Correu:" + correu + "\n";

        int numAssociacions = associacions.getNumelem();

        if (numAssociacions != 0) 
        {
            text += "Associacions:\n";
            for (int i = 0; i < numAssociacions; i++) 
            {
                text += i + "). " + associacions.getAsociacioAt(i).getNom();
                text += "Data alta: " + datesAlta.getDataInPos(i);
                if (i < datesBaixa.getNumelem()) 
                {
                    text += "Data baixa: " + datesBaixa.getDataInPos(i);
                }
            }
        }

        return text;
    }

}
