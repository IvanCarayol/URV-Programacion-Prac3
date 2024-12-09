public class Membre {
        
    private String alias;
    private Data dataAlta[] = new Data[3];
    private String correu;
    private Data dataBaixa[] = new Data[3];
    private LlistaAssociacio associacions;

    public Membre (String alias, String correu) {
        this.alias = alias;
        this.correu = correu;
        associacions = new LlistaAssociacio(3);
    }

    public Membre (String alias, String correu, Data dataAlta, Data dataBaixa, Associacio associacio) {
        this.alias = alias;
        this.dataAlta[0] = dataAlta;
        this.correu = correu;
        this.dataBaixa[0] = dataBaixa;
        associacions = new LlistaAssociacio(3);
        associacions.afegirAsociacio(associacio);
    }

    public Membre (String alias, String correu, Data dataAlta[], Data dataBaixa[], LlistaAssociacio associacions) {
        this.alias = alias;
        setDataConst(dataAlta, dataBaixa);
        this.correu = correu;
        this.associacions = associacions;
    }

    public void setDataConst(Data dataAlta[], Data dataBaixa[]) {
        for(int i = 0; i < dataAlta.length; i++) {
            if (dataAlta[i] != null) {
                this.dataAlta[i] = dataAlta[i].copia();
            }
        }

        for(int i = 0; i < dataBaixa.length; i++) {
            if (dataBaixa[i] != null) {
                this.dataBaixa[i] = dataBaixa[i].copia();
            }
        }
    }

    public String getAlias() {
        return alias;
    }

    public String getCorreu() {
        return correu;
    }

    public LlistaAssociacio geLlistaAssociacions() {
        return associacions;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setDataBaixa(Data data, int num) {
        dataBaixa[num] = data;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public void afegirAsociacio(Associacio associacio, Data alta) {
        int num = associacions.getNumelem();
        if (num < 3) {
            associacions.afegirAsociacio(associacio);
            dataAlta[num] = alta.copia();
        }
    }

    public String toString() {

        String text = "Alias: " + alias + "\nCorreu: " + correu;

        for(int i = 0; i < associacions.getNumelem();i++) {
            text += "\nAssociacio: " + associacions.getAsociacioAt(i).getNom();
            text += "\nDataAlta: " + dataAlta[i];
            if (dataBaixa[i] != null) {
                text += "\nDataBaixa: " + dataBaixa;
            }
        }

        return text;
    }

}
