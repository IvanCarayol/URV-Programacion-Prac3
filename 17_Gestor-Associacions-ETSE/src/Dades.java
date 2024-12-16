import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Dades 
{
    private static String ruta = "data/";
    
    public void EscriureMembres(LlistaMembres membres)
    {
        try
        {
            BufferedWriter fitxerOut = new BufferedWriter(new FileWriter(ruta+"membres.txt"));
            String buffer;
            
            for (int i = 0; i < membres.getNumelem(); i++)
            {
                Membre membre = membres.getMembreAt(i);

                if (membre instanceof Professor)
                {
                    buffer = "1;";
                    buffer += escriureNomiCorreu(membre);
                    buffer += ((Professor)membre).getNomDepartament()+";";
                    buffer += ((Professor)membre).getNumeroDespatx()+";";
                    buffer += escriureAssociacions(membre);
                    
                }
                else if (membre instanceof Alumne)
                {
                    buffer = "2;";
                    buffer += escriureNomiCorreu(membre);
                    buffer += ((Alumne)membre).getTitulacio()+";";
                    buffer += ((Alumne)membre).isGraduat() ? "1;" : "0;";
                    buffer += escriureAssociacions(membre);

                }
                else 
                {
                    buffer = "0;";
                    buffer += escriureNomiCorreu(membre);
                    buffer += escriureAssociacions(membre);
                }
                fitxerOut.write(buffer);
                fitxerOut.newLine();
            }
            fitxerOut.close();

        }
        catch (FileNotFoundException e)
        {
            System.out.println("L'arxiu d'entrada no existeix");
        }
        catch (IOException e)
        {
            System.out.println("S'ha produit un error en els arxius");
        }
    }

    private String escriureNomiCorreu(Membre membre)
    {
        String buffer;

        buffer = membre.getAlias()+";";
        buffer += membre.getCorreu()+";";

        return buffer;
        
    }

    private String escriureAssociacions(Membre membre)
    {
        String buffer = "";
        int numAssociacions = membre.getLlistaAssociacions().getNumelem();

        if (numAssociacions != 0)
        {
            for (int i = 0; i < numAssociacions; i++)
            {
                Associacio associacio = membre.getLlistaAssociacions().getAsociacioAt(i);

                buffer += membre.getDataAlta(i).getDia()+"/";
                buffer += membre.getDataAlta(i).getMes()+"/";
                buffer += membre.getDataAlta(i).getAny()+";";
                buffer += associacio.getNom()+";";
                buffer += membre.getDataBaixa(i).getDia()+"/";
                buffer += membre.getDataBaixa(i).getMes()+"/";
                buffer += membre.getDataBaixa(i).getAny()+";";
            }

            return buffer;
        }
        else
        {
            return "";
        }
    }

    public void LlegirMembres()
    {
        try 
        {
            BufferedReader fitxerIn = new BufferedReader(new FileReader(ruta+"membres.txt"));
            
            String linia;
            linia = fitxerIn.readLine();

            

        } 
        catch (Exception e) 
        {
            // TODO: handle exception
        }
    }
}
