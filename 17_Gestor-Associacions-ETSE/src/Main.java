public class Main {
    public static void main(String[] args) {
        LlistaAssociacio associacions;
        LlistaMembres membres;
        LlistaTitulacions titulacions;
        LlistaAccio accions;
        associacions = Dades.carregaAssociacions();
        titulacions = Dades.carregaTitulacions();
        membres = Dades.llegirMembres(associacions, titulacions);
        accions = Dades.llegirAccions(membres, associacions);
        Data d = new Data(25, 11, 2023); // fecha de prueba

        // codi...

        //4. Mostrar les dades de la llista d’accions, afegint filtre o no per tipus d’acció. 
        System.out.println(accions);

        // codi...

        // 10. Afegir una nova demostració. 
        //Demostracio demo = new Demostracio("Prueba4", "Prueba4T", membre1, associacions, false, d, 0, 0);
        //accions.afegirAccio(demo);

        // codi...

    }
}
