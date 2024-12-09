public class Membre 
{
    //Atributs
    static int NUM_MAX = 3;
    private String alias;
    private Data[] dataAlta = new Data[NUM_MAX];
    private String correu;
    private Data[] dataBaixa = new Data[NUM_MAX];
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
        associacions = new LlistaAssociacio(NUM_MAX);
    }

    /**
     * Constructor de la classe Membre estant assignat a una associació
     * 
     * @param alias         Alias del membre
     * @param correu        Correu electronic del membre
     * @param dataAlta      Data de alta a la associació
     * @param dataBaixa     Data de baixa a la associació
     * @param associacio    Associació assignada al membre
     */
    public Membre(String alias, String correu, Data dataAlta, Data dataBaixa, Associacio associacio) 
    {
        this.alias = alias;
        this.dataAlta[0] = dataAlta;
        this.correu = correu;
        this.dataBaixa[0] = dataBaixa;
        this.associacions = new LlistaAssociacio(NUM_MAX);
        associacions.setAsociacioAt(0, associacio);
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
     * Retorna la data de alta a la associació indicada 
     * @param i Index llista assiciacions membre
     * 
     * @return data de alta associació
     */
    public Data getDataAlta(int i) 
    {
        return dataAlta[i];
    }

    /**
     * Retorna el correu electronic del membre
     * @return correu electronic membre
     */
    public String getCorreu() 
    {
        return correu;
    }

    /**
     * Retorna la data de baixa a la associacio indicada
     * @param i Index llista assiciacions membre
     * 
     * @return Data baixa associació
     */
    public Data getDataBaixa(int i) 
    {
        return dataBaixa[i];
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
     * Assigna la data de alta del membre a la associació indicada
     * @param data  Data de alta
     * @param i     Index de la llista de associacións del membre
     */
    public void setDataAlta(Data data, int i) 
    {
        dataAlta[i] = data;
    }

    /**
     * Assigna la data de baixa del membre a la associació indicada
     * @param data  Data de baixa
     * @param i     Index de la llista de associacións del membre
     */
    public void setDataBaixa(Data data, int i) 
    {
        dataBaixa[i] = data;
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
     * 
     * @return              Retorna 1 si s'ha assignat
     */
    public void afegirAsociacio(Associacio associacio, Data dataIni) 
    {
        int numAssociacions = associacions.getNumelem();

        if (numAssociacions < 3) 
        {
            associacions.setAsociacioAt(numAssociacions, associacio);
            this.dataAlta[numAssociacions] = dataIni;
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

<<<<<<< HEAD
        for(int i = 0; i < associacions.getNumelem();i++) {
            text += "\nAssociacio: " + associacions.getAsociacioAt(i).getNom();
            text += "\nDataAlta: " + dataAlta[i];
            if (dataBaixa[i] != null) {
                text += "\nDataBaixa: " + dataBaixa[i];
=======
        int numAssociacions = associacions.getNumelem();

        if (numAssociacions != 0) 
        {
            text += "Associacions:\n";
            for (int i = 0; i < numAssociacions; i++) 
            {
                text += i + "). " + associacions.getAsociacioAt(i).getNom();
                text += "Data alta: " + dataAlta[i].getDia() + "/" + dataAlta[i].getMes() + "/" + dataAlta[i].getAny()+ "\n";
                if (dataBaixa[i] != null) 
                {
                    text += "Data baixa: " + dataBaixa[i].getDia() + "/" + dataBaixa[i].getMes() + "/"+ dataBaixa[i].getAny() + "\n";
                }
>>>>>>> 914edaf05d65ac638876829c767e6463225ffb46
            }
        }

        return text;
    }

}
