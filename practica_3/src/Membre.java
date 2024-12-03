public class Membre {
    
String alias;
Data dataAlta;
String correu;
Data dataBaixa;
LlistaAssociacio associacions;

public Membre (String alias, Data dataAlta, String correu, Data dataBaixa, LlistaAssociacio associacions)
{
    this.alias = alias;
    this.dataAlta = dataAlta;
    this.correu = correu;
    this.dataBaixa = dataBaixa;
    this.associacions = associacions;
}

public String getAlias()
{
    return alias;
}

public Data getDataAlta()
{
    return dataAlta;
}

public String getCorreu()
{
    return correu;
}

public Data getDataBaixa()
{
    return dataBaixa;
}

public LlistaAssociacio geLlistaAssociacions()
{
    return associacions;
}

public void setAlias(String alias)
{
    this.alias = alias;
}

public void setDataAlta(Data data)
{
    dataAlta = data;
}

public void setCorreu(String correu)
{
    this.correu = correu;
}

public void setLlistaAssociacion(LlistaAssociacio associacions)
{
    this.associacions = associacions;
}

}
