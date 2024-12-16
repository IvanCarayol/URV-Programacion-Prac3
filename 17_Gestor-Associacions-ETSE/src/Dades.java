import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Dades 
{
    private static String ruta = "data/";
    DataOutputStream fitxer;
    
    public void EscriureMembres(LlistaMembres membres)
    {
        try
        {
            fitxer = new DataOutputStream(new FileOutputStream(ruta+"membres.dat"));

            for (int i = 0; i < membres.getNumelem(); i++)
            {
                Membre membre = membres.getMembreAt(i);
                if (membre.getClass().getName() == "Membre")
                {
                    fitxer.writeInt(0);
                    escriureNomiCorreu(fitxer, membre);
                    
                }
            }

        }
        catch (IOException e)
        {

        }
    }

    private void escriureNomiCorreu(DataOutputStream fitxer ,Membre membre)
    {
        try
        {
            fitxer.writeUTF(membre.getAlias());
            fitxer.writeUTF(membre.getCorreu());
        } 
        catch (Exception e) 
        {

        }
        
    }

    private void escriureAssociacions(DataOutputStream fitxer, Membre membre)
    {
        try
        {
            int numAssociacions = membre.getLlistaAssociacions().getNumelem();

            if (numAssociacions != 0)
            {
                for (int i = 0; i < numAssociacions; i++)
                {
                    Associacio associacio = membre.getLlistaAssociacions().getAsociacioAt(i);
                    fitxer.writeInt(membre.getDataAlta(i).getDia());
                    fitxer.writeInt(membre.getDataAlta(i).getMes());
                    fitxer.writeInt(membre.getDataAlta(i).getAny());
                    fitxer.writeUTF(associacio.getNom());
                    fitxer.writeInt(membre.getDataBaixa(i).getDia());
                    fitxer.writeInt(membre.getDataBaixa(i).getMes());
                    fitxer.writeInt(membre.getDataBaixa(i).getAny());
                }
            }
        }
        catch (Exception e)
        {

        }
    }
}
