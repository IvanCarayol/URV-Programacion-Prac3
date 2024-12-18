import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.Scanner;

public class Dades 
{
    private static String ruta = "data/";
    
    public static void guardarMembres(LlistaMembres membres)
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

    private static String escriureNomiCorreu(Membre membre)
    {
        String buffer;

        buffer = membre.getAlias();
        buffer += ";"+membre.getCorreu();

        return buffer;
        
    }

    private static String escriureAssociacions(Membre membre)
    {
        String buffer = "";
        int numAssociacions = membre.getLlistaAssociacions().getNumelem();

        if (numAssociacions != 0)
        {
            for (int i = 0; i < numAssociacions; i++)
            {
                Associacio associacio = membre.getLlistaAssociacions().getAsociacioAt(i);

                buffer += ";"+membre.getDataAlta(i).getDia()+"/";
                buffer += membre.getDataAlta(i).getMes()+"/";
                buffer += membre.getDataAlta(i).getAny();
                buffer += ";"+associacio.getNom();
                
                if (membre.getNumDatesBaixa() < i)
                {
                    buffer += ";"+membre.getDataBaixa(i).getDia()+"/";
                    buffer += membre.getDataBaixa(i).getMes()+"/";
                    buffer += membre.getDataBaixa(i).getAny();
                }
            }

            return buffer;
        }
        else
        {
            return "";
        }
    }

    public static LlistaMembres llegirMembres(LlistaAssociacio associacions, LlistaTitulacions titulacions)
    {
        LlistaMembres membres = new LlistaMembres(10);
        int numAssociacions = associacions.getNumelem();
    
        for (int i = 0; i < numAssociacions; i++)
        {
            Associacio associacio = associacions.getAsociacioAt(i);
            int numMembres = associacio.getMembres().getNumelem();
            LlistaMembres membresTemp = associacio.getMembres();

            for (int j = 0; j < numMembres; j++)
            {
                membres = afegirMembre(membres, membresTemp.getMembreAt(j));
            }
        }

        try 
        {
            BufferedReader fitxerIn = new BufferedReader(new FileReader(ruta+"membres.txt"));
            
            String linia;
            linia = fitxerIn.readLine();
            Scanner trossos;
            int opcio, despatx;

            String nom, correu, departament, nomTitulacio;
            Titulacio titulacio = null;
            Data[] dataAlta = new Data[3];
            Data[] dataBaixa = new Data[3];
            boolean isGraduat;
            Membre membre;

            LlistaAssociacio associacionsMembre = new LlistaAssociacio(3);

            while (linia != null)
            {
                trossos = new Scanner(linia);
                trossos.useDelimiter(";");
                trossos.useLocale(Locale.ENGLISH);
                
                opcio = trossos.nextInt();

                if (opcio == 0)
                {
                    nom = trossos.next();
                    correu = trossos.next();
                    llegirAssociacionsMembres(trossos, dataAlta, associacionsMembre, dataBaixa, associacions);
                    membre = new Membre(nom, correu, dataAlta, dataBaixa, associacionsMembre);
                }
                else if (opcio == 1)
                {
                    nom = trossos.next();
                    correu = trossos.next();
                    departament = trossos.next();
                    despatx = trossos.nextInt();
                    llegirAssociacionsMembres(trossos, dataAlta, associacionsMembre, dataBaixa, associacions);
                    membre = new Professor(nom, correu, departament, despatx, dataAlta, associacionsMembre, dataBaixa);
                }
                else
                {
                    nom = trossos.next();
                    correu = trossos.next();
                    nomTitulacio = trossos.next();
                    boolean noTrobat = true;

                    for (int i = 0; i < titulacions.getNumelem() && noTrobat; i++)
                    {
                        if (nomTitulacio.equals(titulacions.getTitulacioAt(i).getNom()))
                        {
                            titulacio = titulacions.getTitulacioAt(i);
                        }
                    }

                    isGraduat = trossos.nextBoolean();
                    llegirAssociacionsMembres(trossos, dataAlta, associacionsMembre, dataBaixa, associacions);
                    membre = new Alumne(nom, correu, dataAlta, dataBaixa, associacionsMembre, titulacio, isGraduat);
                }
                membres.afegirMembre(membre);
            
            }

            fitxerIn.close();
            return membres;
        } 
        catch (Exception e) 
        {
            System.out.println("Error");
        }
        return membres;
    }

    public static LlistaMembres afegirMembre(LlistaMembres membres, Membre membre)
    {
        LlistaMembres temp = membres;

        if (temp.getNumelem() == temp.getMaxLength())
        {
            int newSize = membres.getMaxLength()*2;
            membres = new LlistaMembres(temp.getMaxLength()*2);

            for (int i = 0; i < newSize; i++)
            {
                membres.afegirMembre(temp.getMembreAt(i));
            }
            membres.afegirMembre(membre);
        }
        return membres;
    }

    public static void llegirAssociacionsMembres(Scanner linia, Data[] dataAlta, LlistaAssociacio associacionsMembre, Data[] dataBaixa, LlistaAssociacio associacions)
    {
        int i = 0;
        while (linia.hasNext()) 
        {
            dataAlta[i].setDia(linia.nextInt());
            dataAlta[i].setMes(linia.nextInt());
            dataAlta[i].setAny(linia.nextInt());
            boolean noTrobat = true;

            for (int j = 0; j < associacions.getNumelem() && noTrobat; j++)
            {
                if (linia.next().equals(associacions.getAsociacioAt(j).getNom()))
                {
                    associacionsMembre.afegirAsociacio(associacions.getAsociacioAt(j));
                    noTrobat = false;
                }
            }
            
            if (linia.hasNext())
            {
                dataBaixa[i].setDia(linia.nextInt());
                dataBaixa[i].setMes(linia.nextInt());
                dataBaixa[i].setAny(linia.nextInt());
            }
            i++;
        }
    }

    public static void guardaAssociacions(LlistaAssociacio associacions)
    {
        ObjectOutputStream fitxer;

        try 
        {   
            fitxer = new ObjectOutputStream(new FileOutputStream(ruta+"associacions.ser"));
            fitxer.writeObject(associacions);

            fitxer.close();
            
        }
        catch (IOException e)
        {
            System.out.println("Error en l'arxiu de sortida: "+ruta+"associacions.ser");
        }
        catch (ClassCastException e)
        {
            System.out.println("Hola");
        }
    }

    public static LlistaAssociacio carregaAssociacions()
    {
        ObjectInputStream fitxer;
        LlistaAssociacio associacions = new LlistaAssociacio(0);

        try
        {
            fitxer = new ObjectInputStream(new FileInputStream(ruta+"associacions.ser"));
            associacions = (LlistaAssociacio)fitxer.readObject();
            fitxer.close();
            return associacions;
        }
        catch (IOException e)
        {
            System.out.println("Error en l'arxiu de entrada");
        }
        catch (ClassCastException e)
        {
            System.out.println("Error, el format de l'arxiu no és correcte per la definició actual de la classe LlistaAssociacions."+e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error, el format de l'arxiu no és correcte per la definició actual de la classe LlistaAssociacions."+e);
        }
        return associacions;
    }
}
