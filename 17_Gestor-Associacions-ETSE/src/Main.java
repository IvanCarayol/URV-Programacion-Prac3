import java.util.Scanner;

import Objectes.*;

public class Main {
    private final int SORTIR = 18;

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
        Dades.organizarValoraciones(valoracions, accions);
  
        Data d = new Data(25, 11, 2023); // fecha de prueba*/

        mostrarMenu();
        System.out.println("Quina opcio vols:");
        Scanner scanner = new Scanner(System.in);
        opcio = scanner.nextInt();
        while (!sortir){
            System.out.println("Quina opcio vols:");
            opcio = scanner.nextInt();
            switch (opcio) {
                case 1:
                    
                    break;
            
                case 2:
                    break;
    
                case 3:
                    break;
    
                case 4:
                    System.out.println(accions);
                    break;
                    
                case 5:
                    LlistaAccio accioAsso = accions.accioDeUnaAssociacio(associacions.getAsociacioAt(0));
                    System.out.println("\nLlistar accions d’ una associació concreta");
                    System.out.println(accioAsso);
                    break;

                case 6:
                    System.out.println("Indica la data d'inici separada per '/': (dd/m/yyyy)");
                    scanner.nextLine();
                    String[] data = scanner.nextLine().split("/");
                    Data dataInici = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                    System.out.println("Indica la data de fi separada per '/': (dd/m/yyyy)");
                    data = scanner.nextLine().split("/");
                    Data dataFinal = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                    
                    LlistaAccio xerradesEnFranja = accions.llistarEnFranja(dataInici, dataFinal); 
                    System.out.println("\nXerrades en franja:"); 
                    System.out.println(xerradesEnFranja);
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
                    break;

                case 10:
                    LlistaAssociacio lassoaciaAux = new LlistaAssociacio(3);
                    lassoaciaAux.afegirAsociacio(associacions.getAsociacioAt(0));
                    lassoaciaAux.afegirAsociacio(associacions.getAsociacioAt(4));
                    Demostracio demo = new Demostracio("Prueba10", "Prueba10T", membres.getMembreAt(5), lassoaciaAux, d, false, 0, 0);
                    accions.afegirAccio(demo);
            
                    System.out.println("\nNova demostració");
                    System.out.println(accions);
                    break;

                case 11:
                    break;

                case 12:
                    break;

                case 13:
                    LlistaAccio lxerrades = accions.xerradesMesAssisten(5);
                    System.out.println("\nXerrades amb x membres");
                    System.out.println(lxerrades);
                    break;

                case 14:
                    int[] indexXerrada = new int[1];
                    scanner.nextLine();
                    System.out.println("Introdueix el nom de la xerrada");
                    String nomXerrada = scanner.nextLine();
                    boolean trobat = valoracions[0].trobarXerrada(nomXerrada, valoracions, indexXerrada);
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
                            valoracions[indexXerrada[0]].afegirValoracio(valoracioAfegir);
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
                    break;

                case 17:
                    break;

                case 18:

                    System.out.println("Vols sobrescriure?(Si:1/No:0)");
                    opcio = scanner.nextInt();
                    if(opcio == 1) {
                        Dades.escriureAccions(accions);
                        Dades.escriureValoracions(valoracions);
                    }
                    scanner.close();
                    sortir = true;
            }
        }
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
}
