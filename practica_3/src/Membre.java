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
        for(int i = 0; i < 3; i++) {
            if (dataAlta[i] != null) {
                this.dataAlta[i] = dataAlta[i].copia();
            }
            if (dataBaixa[i] != null) {
                this.dataBaixa[i] = dataBaixa[i].copia();
            }
        }
    }

    public String getAlias() {
        return alias;
    }

    public Data getDataAlta() {
        return dataAlta;
    }

    public String getCorreu() {
        return correu;
    }

    public Data getDataBaixa() {
        return dataBaixa;
    }

    public LlistaAssociacio geLlistaAssociacions() {
        return associacions;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setDataAlta(Data data) {
        dataAlta = data;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public void setLlistaAssociacion(LlistaAssociacio associacions) {
        this.associacions = associacions;
    }

    public String toString() {

        String text = "Alias: " + alias + "\nCorreu: " + correu + "\nDataAlta: " + dataAlta + "\nDataBaixa: " + dataBaixa;

        for(int i = 0; i < associacions.getNumelem();i++) {
            text += "\nAssociacio numero " + i + ":";
            text += associacions.getAsociacioAt(i).toString();
        }

        return text;
    }

}
