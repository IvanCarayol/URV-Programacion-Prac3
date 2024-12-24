package funcions;
import java.io.Serializable;

public class LlistaDates implements Serializable
{
    Data[] llista;
    int nElem; 
    
    public LlistaDates (int size)
    {
        llista = new Data[size];
        nElem = 0;
    }

    public int getNumelem()
    {
        return this.nElem;
    }

    public int getMaxElemLlista()
    {
        return llista.length;
    }

    public Data getDataInPos(int pos)
    {
        return llista[pos];
    }

    public void afegirData(Data data)
    {
        if (nElem < llista.length)
        {
            llista[nElem] = data;
            nElem++;
        }
    }
}
