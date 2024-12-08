public class Membre {
        
    private String alias;
    private Data dataAlta;
    private String correu;
    private Data dataBaixa;
    private LlistaAssociacio associacions;

    public Membre (String alias, Data dataAlta, String correu, Data dataBaixa, LlistaAssociacio associacions) {
        this.alias = alias;
        this.dataAlta = dataAlta;
        this.correu = correu;
        this.dataBaixa = dataBaixa;
        this.associacions = associacions;
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
