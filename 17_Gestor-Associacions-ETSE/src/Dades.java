import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Dades 
{
    private static String ruta = "data/";
    ObjectOutputStream fitxer;
    
    public void EscriureMembres(LlistaMembres membres)
    {
        try
        {
            fitxer = new ObjectOutputStream(new FileOutputStream(ruta+"membres.dat"));
            fitxer.writeObject(membres);

        }
        catch (IOException e)
        {
            System.out.println("Error en l'arxiu de sortida.");
        }
    }

}
