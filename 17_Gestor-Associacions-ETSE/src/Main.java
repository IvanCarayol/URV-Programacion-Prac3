import Objectes.*;

public class Main {
    public static void main(String[] args) {
        LlistaAssociacio associacions;
        LlistaMembres membres;
        LlistaTitulacions titulacions;
        LlistaAccio accions;
        LlistaValoracio[] valoracions;
        associacions = Dades.carregaAssociacions();
        
        titulacions = Dades.carregaTitulacions();
        membres = Dades.llegirMembres(associacions, titulacions);
        accions = Dades.llegirAccions(membres, associacions);
        valoracions = Dades.llegirValoracions(membres);
        System.out.println("ALGO"+valoracions[0]);
        Data d = new Data(25, 11, 2023); // fecha de prueba*/

        // codi...

        //4. Mostrar les dades de la llista d’accions, afegint filtre o no per tipus d’acció. 
        System.out.println(accions);

        //5. Obtenir i mostrar la llista d’accions que ofereix una associació concreta. 
        LlistaAccio accioAsso = accions.accioDeUnaAssociacio(associacions.getAsociacioAt(0));

        System.out.println("\nLlistar accions d’ una associació concreta");
        System.out.println(accioAsso);

        // codi...

        // 10. Afegir una nova demostració. 
        LlistaAssociacio lassoaciaAux = new LlistaAssociacio(3);
        lassoaciaAux.afegirAsociacio(associacions.getAsociacioAt(0));
        lassoaciaAux.afegirAsociacio(associacions.getAsociacioAt(4));
        Demostracio demo = new Demostracio("Prueba10", "Prueba10T", membres.getMembreAt(5), lassoaciaAux, d, false, 0, 0);
        accions.afegirAccio(demo);

        System.out.println("\nNova demostració");
        System.out.println(accions);


        // codi...

        //13. Consultar i mostrar les dades de les xerrades que ha tingut més d’un cert nombre indicat 
        //    d’assistents. 
        LlistaAccio lxerrades = accions.xerradesMesAssisten(5);
        System.out.println("\nXerrades amb x membres");
        System.out.println(lxerrades);


        // codi...

    }
}
