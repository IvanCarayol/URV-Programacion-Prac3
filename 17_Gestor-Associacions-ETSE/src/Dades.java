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
    private static String ruta = "../data/";
    
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
                    buffer += escriureNomiCorreu(membre)+";";
                    buffer += ((Professor)membre).getNomDepartament()+";";
                    buffer += ((Professor)membre).getNumeroDespatx()+"";
                    buffer += escriureAssociacions(membre);
                    
                }
                else
                {
                    buffer = "0;";
                    buffer += escriureNomiCorreu(membre)+";";
                    buffer += ((Alumne)membre).getTitulacio()+";";
                    buffer += ((Alumne)membre).isGraduat() ? "1" : "0";
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
                buffer += ";"+associacio.getNom();

                buffer += ";"+membre.getLlistaDatesAlta().getDataInPos(i).getDia();
                buffer += ";"+membre.getLlistaDatesAlta().getDataInPos(i).getMes();
                buffer += ";"+membre.getLlistaDatesAlta().getDataInPos(i).getAny();
                
                if (i < membre.getLlistaDatesBaixa().getNumelem())
                {
                    buffer += ";"+membre.getLlistaDatesBaixa().getDataInPos(i).getDia();
                    buffer += ";"+membre.getLlistaDatesBaixa().getDataInPos(i).getMes();
                    buffer += ";"+membre.getLlistaDatesBaixa().getDataInPos(i).getAny();
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
        String arxiu = ruta+"membres.txt";

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
            BufferedReader fitxerIn = new BufferedReader(new FileReader(arxiu));
            
            String linia;
            Scanner trossos;
            int despatx;

            String nom, correu, departament, nomTitulacio;
            Titulacio titulacio = null;
            boolean isGraduat, opcio;
            Membre membre;

            LlistaAssociacio associacionsMembre;

            linia = fitxerIn.readLine();
            
            while (linia != null) 
            {
                LlistaDates dataAlta = new LlistaDates(3);
                LlistaDates dataBaixa = new LlistaDates(3);
                trossos = new Scanner(linia);
                trossos.useDelimiter(";");
                trossos.useLocale(Locale.ENGLISH);
    
                opcio = trossos.nextInt() != 0;

                associacionsMembre = new LlistaAssociacio(3);

                if (opcio)
                {
                    nom = trossos.next();
                    correu = trossos.next();
                    departament = trossos.next();
                    despatx = trossos.nextInt();
                    llegirAssociacionsMembres(trossos, dataAlta, associacionsMembre, dataBaixa, associacions);
                    membre = new Professor (nom, correu, departament, despatx, dataAlta, associacionsMembre, dataBaixa);
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
                            noTrobat = false;
                        }
                    }

                    isGraduat = trossos.nextInt() != 0;
                    llegirAssociacionsMembres(trossos, dataAlta, associacionsMembre, dataBaixa, associacions);
                    membre = new Alumne(nom, correu, titulacio, isGraduat, dataAlta, associacionsMembre, dataBaixa);
                }
                membres = afegirMembre(membres, membre);
                linia = fitxerIn.readLine();
            }
            fitxerIn.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("No s'ha trobat el fitxer: "+arxiu);
        }
        catch (IOException e)
        {
            System.out.println("S'ha produit un error en l'arxiu: "+arxiu);
        }
        return membres;
    }

    public static LlistaMembres afegirMembre(LlistaMembres membres, Membre membre)
    {
        LlistaMembres temp;

        if (membres.getNumelem() == membres.getMaxLength())
        {
            int newSize = membres.getMaxLength()*2;
            System.out.println(newSize);
            temp = new LlistaMembres(newSize);

            for (int i = 0; i < membres.getNumelem(); i++)
            {
                temp.afegirMembre(membres.getMembreAt(i));
            }
        }
        else
        {
            temp = membres;
        }
        temp.afegirMembre(membre);
        return temp;
    }

    public static void llegirAssociacionsMembres(Scanner linia, LlistaDates dataAlta, LlistaAssociacio associacionsMembre, LlistaDates dataBaixa, LlistaAssociacio associacions)
    {
        int dia, mes, any;
        while (linia.hasNext()) 
        {
            boolean noTrobat = true;
            String nom = linia.next();

            for (int j = 0; j < associacions.getNumelem() && noTrobat; j++)
            {
                if (nom.equals(associacions.getAsociacioAt(j).getNom()))
                {
                    associacionsMembre.afegirAsociacio(associacions.getAsociacioAt(j));
                    noTrobat = false;
                }
            }

            dia = linia.nextInt();
            mes = linia.nextInt();
            any = linia.nextInt();
            dataAlta.afegirData(new Data(dia, mes, any));
            
            if (linia.hasNextInt())
            {
                dia = linia.nextInt();
                mes = linia.nextInt();
                any = linia.nextInt();
                dataBaixa.afegirData(new Data(dia, mes, any));
            }
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

    public static void guardaTitulacions(LlistaTitulacions titulacions)
    {
        try
        {
            BufferedWriter fitxer = new BufferedWriter(new FileWriter(ruta+"titulacions.txt"));
            int numTitulacions = titulacions.getNumelem();

            for (int i = 0; i < numTitulacions; i++)
            {
                fitxer.write(titulacions.getTitulacioAt(i).getNom());
                fitxer.newLine();
            }
            fitxer.close();
        }
        catch (IOException e)
        {
            System.out.println("Hi ha hagut un error amb el fitxer");
        }
    }

    public static LlistaTitulacions carregaTitulacions()
    {
        LlistaTitulacions titulacions = new LlistaTitulacions(1);
        try
        {
            BufferedReader fitxer = new BufferedReader(new FileReader(ruta+"titulacions.txt"));

            String linia ="";
            linia = fitxer.readLine();

            while (linia != null) 
            {
                if (titulacions.getNumelem() == titulacions.getMaxElem())
                {
                    LlistaTitulacions temp = titulacions;
                    titulacions = new LlistaTitulacions(temp.getMaxElem()*2);

                    for (int i = 0; i < temp.getNumelem(); i++)
                    {
                        titulacions.afegirTitulacio(temp.getTitulacioAt(i));
                    }
                }
                titulacions.afegirTitulacio(new Titulacio(linia));
                linia = fitxer.readLine();
            }
            fitxer.close();
        }
        catch (IOException e)
        {
            System.out.println("Hi ha hagut un error amb el fitxer");
        }
        return titulacions;
    }

    public static LlistaAccio llegirAccions(LlistaMembres membres, LlistaAssociacio asso) {
        String arxiu = ruta + "accions.txt";
        try {
            Scanner fit = new Scanner(new FileReader(arxiu));
            
            // Leer el primer número del archivo
            int numA = fit.nextInt();
            LlistaAccio accions = new LlistaAccio(numA);
            String linia = fit.nextLine();
            linia = fit.nextLine();
            linia = fit.nextLine();
            linia = fit.nextLine();
            
            // Leer el resto de líneas del archivo
            while(fit.hasNext()) {
                linia = fit.nextLine();
                
                String[] inf = linia.split(";");
                    
                Membre responsable = membres.getMembreAmbNom(inf[3]);
                    
                // Crear instancia de Data
                String[] dateParts = inf[4].split("/");
                int dia = Integer.parseInt(dateParts[0]);
                int mes = Integer.parseInt(dateParts[1]);
                int any = Integer.parseInt(dateParts[2]);
                Data data = new Data(dia, mes, any);
                
                int numAss = inf.length - 4;
                LlistaAssociacio ass = new LlistaAssociacio(numAss);
                
                for(int i = 0; i < numAss;i++) {
                    
                    ass.afegirAsociacio(asso.getAssociacioAmbNom(inf[i+4]));
                }
                
                int op = Integer.parseInt(inf[0]);
                
                switch (op) {
                    case 0:
                        // Crear una nueva instancia de `Accio`
                        Accio accio = new Accio(inf[0], inf[1], responsable, ass, data);
                        break;
                
                    default:
                        break;
                        
                }

                
                
            }
            
            fit.close();
            return accions;
            
        } catch (FileNotFoundException e) {
            System.out.println("No s'ha trobat el fitxer: " + arxiu);
        }
        
        return null;
    }
    
    
}
