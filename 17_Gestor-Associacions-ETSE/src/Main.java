import java.util.InputMismatchException;
import java.util.Scanner;

import Objectes.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        LlistaAssociacio associacions;
        LlistaMembres membres;
        LlistaTitulacions titulacions;
        LlistaAccio accions;
        LlistaValoracio[] valoracions;
        int opcio;
        boolean sortir = false;
        
        associacions = Dades.carregaAssociacions();
        titulacions = Dades.carregaTitulacions();
        membres = Dades.llegirMembres(associacions, titulacions);
        accions = Dades.llegirAccions(membres, associacions);
        valoracions = Dades.llegirValoracions(membres);

        LlistaValoracio[] novaArrayValoracions = new LlistaValoracio[100]; 
        for (int i = 0; i < valoracions.length; i++) { 
            if (valoracions[i] != null){
                LlistaValoracio.afegirValoracioLlista(novaArrayValoracions, valoracions[i]);
            } else {
            System.out.println("valoracions[" + i + "] es null.");
            }
        }

        Dades.organizarValoraciones(valoracions, accions);



        mostrarMenu();
        System.out.println("Quina opcio vols:");
        opcio = demanarOpcio();
        //scanner.nextLine();
        while (!sortir){
            switch (opcio) {
                case 1:
                    System.out.println(associacions);
                    break;
            
                case 2:
                    llistarMembresAssociacio(associacions);
                    break;
    
                case 3:
                    System.out.println("Filtre de membres, escull l'opció que vulguis:");
                    System.out.println("    1. Tots");
                    System.out.println("    2. Alumnes");
                    System.out.println("    3. Profesors");
                    int nummem = scanner.nextInt();
                    System.out.println(membres.toStringAmbOpcions(nummem));
                    break;
    
                case 4:
                    System.out.println("Filtre d'accions, escull l'opció que vulguis:");
                    System.out.println("    1. Tot");
                    System.out.println("    2. Xerrades");
                    System.out.println("    3. Demostracions");
                    int num = scanner.nextInt();
                    System.out.println(accions.toStringAmbOpcions(num));
                    break;
                    
                case 5:
                    System.out.println("Introduex nom d'associacio");
                    String nomAssociacio = scanner.next();
                    Associacio buscaAssociacio = associacions.getAssociacioAmbNom(nomAssociacio);
                    if(buscaAssociacio != null) {
                        LlistaAccio accioAsso = accions.accioDeUnaAssociacio(buscaAssociacio);
                        System.out.println("\nLlistar accions d’ una associació concreta");
                        System.out.println(accioAsso);
                    } else {
                        System.out.println("Associacio inexistent");
                    }
                    
                    break;

                case 6:
                    Data dataInici = null;
                    Data dataFinal = null;
                    String[] data;
                    System.out.println("Indica la data d'inici separada per '/': (dd/m/yyyy)");
                    
                    while (dataInici == null)
                    try {
                        data = scanner.nextLine().split("/");
                        if (data.length == 3){
                            dataInici = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                        } else {
                            throw new IllegalArgumentException("Format incorrecte");
                        }    
                    } catch (Exception e) {
                        System.out.println("Data d'inici no vàlida. Torna a intentar-ho.");
                        dataInici = null;
                    }

                    System.out.println("Indica la data de fi separada per '/': (dd/m/yyyy)");
                    while (dataFinal == null){
                        data = scanner.nextLine().split("/");
                            try {
                                if (data.length == 3){
                                    dataFinal = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                                } else {
                                    throw new IllegalArgumentException("Format incorrecte");
                                }
                            } catch (Exception e) {
                                System.out.println("Data de fi no vàlida. Torna a intentar-ho.");
                                dataFinal = null;
                            }
                        
                    }
                    LlistaAccio xerradesEnFranja = accions.llistarEnFranja(dataInici, dataFinal); 
                    System.out.println("\nXerrades en franja:"); 
                    if(xerradesEnFranja.getContador() >= 1){
                        System.out.println(xerradesEnFranja);
                    } else {
                        System.out.println("No hi ha xerrades en aquesta franja");
                    }
                    break;

                case 7:
                    System.out.println("\nIndica el nom de la associacio:");
                    String nom = scanner.nextLine();
                    System.out.println("\nIndica el correu de la associacio:");
                    String correu = scanner.nextLine();
                    System.out.println("\nIndica el president de la associacio:");
                    Membre president = membres.getMembreAmbNom(scanner.nextLine());
                    System.out.println("\nIndica el tesorer de la associacio:");
                    Membre tesorer = membres.getMembreAmbNom(scanner.nextLine());
                    System.out.println("\nIndica el secretari de la associacio:");
                    Membre secretari = membres.getMembreAmbNom(scanner.nextLine());
                    Associacio a = new Associacio(nom, correu, president, tesorer, secretari, new LlistaTitulacions(10), new LlistaMembres(100));
                    associacions.afegirAsociacio(a);
                    a.afegeixMembre(secretari);
                    a.afegeixMembre(tesorer);
                    a.afegeixMembre(president);
                    break;

                case 8:
                    altaMembreAassociacio(associacions, membres);
                    break;

                case 9:
                    String nomXerradaAfegir = null;
                    while (nomXerradaAfegir == null){
                        System.out.println("Indica nom de la xerrada:");
                        nomXerradaAfegir = scanner.nextLine();
                        if (nomXerradaAfegir.length() < 3) { 
                            System.out.println("El nom de la xerrada ha de tenir almenys 3 caràcters."); 
                            nomXerradaAfegir = null; 
                        }
                    }
                    
                    System.out.println("Indica titol xerrada:");
                    String titolXerrada = scanner.nextLine();

                    boolean valida = false;
                    LlistaAssociacio associacionsParticipants = null;
                    while (!valida){
                        try{
                            System.out.println("Quantes associacions participen");
                            int numeroAssociacions = Integer.parseInt(scanner.nextLine());
                            if (numeroAssociacions < 0) { 
                                throw new IllegalArgumentException("El número de associacions no pot ser negatiu."); 
                            
                            }
                            valida = true;
                            associacionsParticipants = new LlistaAssociacio(numeroAssociacions);
                            for (int i = 0; i < numeroAssociacions; i++){
                                valida = false;
                                while (!valida){
                                    try {
                                        System.out.println("Escriu una associacio");
                                        String associacioAfegir = scanner.nextLine();
                                        Associacio associacioAAfegir = associacions.getAssociacioAmbNom(associacioAfegir);
                                        if (associacioAAfegir != null){
                                            associacionsParticipants.afegirAsociacio(associacioAAfegir);
                                            valida = true;
                                        } else {
                                            System.out.println("Associacio no existent");
                                        }
                                    } catch (Exception e){
                                        System.out.println("S'ha produït un error: " + e.getMessage());
                                    }
                                    
                                }
                            }


                        } catch (NumberFormatException e){
                            System.out.println("Introduce un entero");
                        } catch (IllegalArgumentException e) { 
                            System.out.println(e.getMessage());
                        }
                    }

                    valida = false;
                    Membre membreXerrada = null;
                        while (!valida){
                            try{
                                System.out.println("Indica nom del membre representant xerrada:");
                                String nomMemebre = scanner.nextLine();
                                membreXerrada = membres.getMembreAmbNom(nomMemebre);
                                if (membreXerrada != null){
                                    valida = true;
                                } else{
                                    System.out.println("Membre no existent");
                                }

                            } catch (Exception e){
                                System.out.println("Membre no existent");
                            }
                        }
                    String[] dataXerrada;
                    Data dataFinalXerrada = null;
                    System.out.println("Indica la data d'inici separada per '/': (dd/m/yyyy)");
                        
                    while (dataFinalXerrada == null){
                        try {
                            dataXerrada = scanner.nextLine().split("/");
                            if (dataXerrada.length == 3){
                                dataFinalXerrada = new Data(Integer.parseInt(dataXerrada[0]), Integer.parseInt(dataXerrada[1]), Integer.parseInt(dataXerrada[2]));
                            } else {
                                throw new IllegalArgumentException("Format incorrecte");
                            }    
                        } catch (Exception e) {
                            System.out.println("Data d'inici no vàlida. Torna a intentar-ho.");
                            dataXerrada = null;
                        }
                    }
                    Xerrades xerradaAfegir = new Xerrades(nomXerradaAfegir, titolXerrada, membreXerrada, associacionsParticipants, dataFinalXerrada, 100);
                    accions.afegirAccio(xerradaAfegir);
                    LlistaValoracio valoracionsxerrada = new LlistaValoracio(1000, nomXerradaAfegir); 
                    LlistaValoracio.afegirValoracioLlista(novaArrayValoracions, valoracionsxerrada);
                    Dades.organizarValoraciones(novaArrayValoracions, accions);
                    break;
                    
                case 10:
                    LlistaAssociacio lassoaciaAux = new LlistaAssociacio(3);
                    lassoaciaAux.afegirAsociacio(associacions.getAsociacioAt(0));
                    lassoaciaAux.afegirAsociacio(associacions.getAsociacioAt(4));

                    System.out.println("Indica la data de creacio separada per '/': (dd/m/yyyy)");
                    String[] dataDemostracioAux = scanner.nextLine().split("/");
                    Data dataDemostracio = null;
                    try {
                        if (dataDemostracioAux.length == 3){
                            dataDemostracio = new Data(Integer.parseInt(dataDemostracioAux[0]), Integer.parseInt(dataDemostracioAux[1]), Integer.parseInt(dataDemostracioAux[2]));
                            
                            System.out.println("Indica nom demostracio:");
                            String nomDemostracio = scanner.nextLine();

                            System.out.println("Indica titol demostracio:");
                            String titolDemostracio = scanner.nextLine();

                            System.out.println("Indica nom del membre demostracio:");
                            String nomMemebre = scanner.nextLine();
                            Membre membreDemostracio = membres.getMembreAmbNom(nomMemebre);
                            
                            if(membreDemostracio != null) {

                                System.out.println("Indica vegades oferit demostracio:");
                                int oferitDemostracio = scanner.nextInt();

                                System.out.println("Indica cost demostracio:");
                                int costDemostracio = scanner.nextInt();

                                System.out.println("Indica validesa demostracio(si:1/no:0):");
                                int validDemostracio = scanner.nextInt();

                                Demostracio demo = new Demostracio(nomDemostracio, titolDemostracio, membreDemostracio, lassoaciaAux, dataDemostracio, (validDemostracio==1)? true:false, oferitDemostracio, costDemostracio);
                                accions.afegirAccio(demo);
                        
                                System.out.println("\nNova demostració");
                                System.out.println(accions);
                            } else {
                                System.out.println("Membre no trobat");
                            }
                        
                        } else {
                            throw new IllegalArgumentException("Format incorrecte");
                        }
                    } catch (Exception e) {
                        System.out.println("Data de fi no vàlida. Torna a intentar-ho.");
                        dataDemostracio = null;
                    }
                    break;

                case 11:
                    Demostracio[] demostra = accions.demostracionsInValides();
                    System.out.println("Llista Demostracions");
                    double cost = 0;
                    int longitud;
                    for (longitud = 0; longitud < demostra.length; longitud++){
                        if (demostra[longitud] != null){
                            System.out.println(demostra[longitud]);
                            cost += demostra[longitud].getCost_material();
                        }
                    }
                    System.out.println("Cost de les Demostracions "+cost+ " euros");
                    break;

                case 12:
                    System.out.println(membres.retornaMembreMesActiu());
                    break;

                case 13:
                    LlistaAccio lxerrades = accions.xerradesMesAssisten(5);
                    System.out.println("\nXerrades amb x membres");
                    System.out.println(lxerrades);
                    break;

                case 14:
                    int[] indexXerrada = new int[1];
                    System.out.println("Introdueix el nom de la xerrada");
                    String nomXerrada = scanner.nextLine();
                    boolean trobat = valoracions[0].trobarXerrada(nomXerrada, novaArrayValoracions, indexXerrada);
                    if (trobat){
                        System.out.println("Introdueix la valoració (0-10):"); 
                        int valor = Integer.parseInt(scanner.nextLine()); 
                        System.out.println("Introdueix l'alias del membre:"); 
                        String aliasMembre = scanner.nextLine();
                        Membre membreValorant = membres.getMembreAmbNom(aliasMembre);
                        if (membreValorant == null){
                            System.out.println("Membre inexistent");
                        } else {
                            System.out.println("");
                            Valoracio valoracioAfegir = new Valoracio(membreValorant, valor);
                            System.out.println(novaArrayValoracions[indexXerrada[0]].getnElem());
                            novaArrayValoracions[indexXerrada[0]].afegirValoracio(valoracioAfegir);
                            System.out.println(novaArrayValoracions[indexXerrada[0]].getnElem());
                        }
                    } else{
                        System.out.println("Xerrada no existent");
                    }
                    break;

                case 15:
                    System.out.println("La xerrada milor valorada es:");
                    Xerrades xerradamillorValorada = accions.getXerradaMejorValorada();
                    System.out.println(xerradamillorValorada);
                    break;

                case 16:
                    mostrarXerradesFuturesMembre(accions);
                    break;

                case 17:
                    System.out.println("Indica la data d'inici separada per '/': (dd/m/yyyy)");
                    String[] datastring = scanner.nextLine().split("/");
                    Data data1 = new Data(Integer.parseInt(datastring[0]), Integer.parseInt(datastring[1]), Integer.parseInt(datastring[2]));
                    Demostracio[] demostracio = accions.demostracionsInValides();
                    for (longitud = 0; longitud < demostracio.length; longitud++){
                        if (demostracio[longitud] != null){
                            accions.eliminaAccioData(demostracio[longitud], data1);
                        }
                    }
                    System.out.println("Demostracions eliminades");
                    break;

                case 18:

                    System.out.println("Vols sobrescriure?(Si:1/No:0)");
                    opcio = scanner.nextInt();
                    if(opcio == 1) {
                        Dades.guardaAssociacions(associacions);
                        Dades.guardarMembres(membres);
                        Dades.escriureAccions(accions);
                        Dades.escriureValoracions(novaArrayValoracions);
                    }
                    sortir = true;
                    break;
            }
            mostrarMenu();
            System.out.println("Quina opcio vols:");
            opcio = demanarOpcio();
            //scanner.nextLine();
        }
        scanner.close();
    }

    public static void mostrarMenu(){
        System.out.println("\t\tMENU\n1.- Associacions\n2.- Membres d'una associacio (filtre professor alumne opcional)");
        System.out.println("3.- Membres actius (filtre profesor alumne opcional)\n4.- Accions segons el seu tipus o no");
        System.out.println("5.- Accions d'una associacio\n6.- Xerrades en franja");
        System.out.println("7.- Nova associacio\n8.- Alta membre associació");
        System.out.println("9.- Nova xerrada\n10.- Nova demostracio");
        System.out.println("11.- Demostracions no actives (cost econòmic de totes en conjunt)\n12.- Persona mes activa");
        System.out.println("13.- Xerrades amb mes d'un cert nombre d'assistents\n14.- Valorar xerrada");
        System.out.println("15.- Xerrada millor valorada\n16.- Xerrades d'una persona");
        System.out.println("17.- Donar de baixa demostracions no actives i dissenyades abans d'una data\n18.- Sortir");
    }

    private static void llistarMembresAssociacio(LlistaAssociacio associacions)
    {
        String nom;
        int tipusMembre;
        System.out.println("Introdueix el nom de la associacio: ");
        nom = scanner.nextLine();

        Associacio associacio = associacions.getAssociacioAmbNom(nom);

        if (associacio != null)
        {
            System.out.println("Introdueix tipus de membre (1: Professor, 2: Alumne, 3: Tots):");
            tipusMembre = scanner.nextInt();
    
            LlistaMembres membres = associacio.getMembres();
            LlistaMembres membresFiltrat;

            switch (tipusMembre) {
                case 1:
                    membresFiltrat = membres.retornaProfessors();
                    break;
                case 2:
                    membresFiltrat = membres.retornaAlumnes();
                default:
                    membresFiltrat = membres;
                    break;
            }
            System.out.println(membresFiltrat);
        }
        else
        {
            System.out.println("La associacion introducida no existe");
        }
    }

    private static void altaMembreAassociacio(LlistaAssociacio associacions, LlistaMembres membres)
    {
        String nomMembre;
        String nomAssociacio;
        int dia, mes, any;

        System.out.print("Introdueix el nom del membre: ");
        nomMembre = scanner.nextLine();

        Membre membre = membres.getMembreAmbNom(nomMembre);

        if (membre == null)
        {
            System.out.println("El membre que estas buscant no existeix");
        }
        else
        {
            System.out.print("\nIntrodueix el nom de la associacio:");
            nomAssociacio = scanner.nextLine();
            
            if (associacions.getAssociacioAmbNom(nomAssociacio) == null)
            {
                System.out.println("La associacio no existeix");
            }
            else if (membre.getLlistaAssociacions().getAssociacioAmbNom(nomAssociacio) != null)
            {
                System.out.println("El membre ja esta inscrit a aquesta associacio");
            }
            else
            {
                System.out.print("\nIntrodueix la data de alta del membre a la associacio:\nDia: ");
                dia = scanner.nextInt();
                System.out.print("\nMes: ");
                mes = scanner.nextInt();
                System.out.print("\nAny: ");
                any = scanner.nextInt();

                Associacio associacio = associacions.getAssociacioAmbNom(nomAssociacio);
                membre.afegiraAsociacio(associacio, new Data(dia, mes, any));
            }
        }
    }

    private static void mostrarXerradesFuturesMembre(LlistaAccio accions)
    {
        int dia, mes, any;
        System.out.println("Introdueix el membre del que vols consultar les xerrades:");
        String nomMembre = scanner.nextLine();
        System.out.print("\nIntrodueix la data de avui:\nDia: ");
        dia = scanner.nextInt();
        System.out.print("\nMes: ");
        mes = scanner.nextInt();
        System.out.print("\nAny: ");
        any = scanner.nextInt();
        Data data = new Data(dia, mes, any);
        LlistaAccio xerrades =accions.retornaXerradesFuturesMembre(nomMembre, data);

        System.out.println(xerrades);
    }

    private static int demanarOpcio()
    {
        int opcio = 0;
        
        do
        {
            try
            {
                opcio = scanner.nextInt();

                if (opcio < 1 || opcio > 18)
                {
                    System.out.println("Error: Has de introduir un numero enter del 1 al 18");
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Error: Has de introduir un numero enter del 1 al 18");
            }
            scanner.nextLine();
        } while (opcio < 1 || opcio > 18);
        
        return opcio;
    }
}
