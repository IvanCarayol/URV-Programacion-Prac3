import java.sql.Time;

public class tests {
    public static void main(String[] args) {

        Membre membre1 = new Membre("Pep", "pep33@gmail.com");
        Membre membre2 = new Membre("Fernando", "fernando32@gmail.com");
        Membre membre3 = new Membre("Joan", "joan31@gmail.com");
        Membre membre4 = new Membre("Josep", "josep30@gmail.com");
        Membre membre5 = new Membre("Pau", "pau29@gmail.com");
        //Probes clase valoracio
        System.out.println("PROVES CLASSE VALORACIONS");

        //Constructor amb parametres
        Valoracio valoracio = new Valoracio(membre1, 7);
        System.out.println("Valoracio (constructor  amb parametres): "+ valoracio);

        //Prova getters
        System.out.println("Membre de valoracio: " + valoracio.getMembre());
        System.out.println("Valoració de valoracio: " + valoracio.getValoracio());

        //Prova dels setters
        valoracio.setMembre(membre2);
        valoracio.setValoracio(9);
        System.out.println("Valoracio despres del setter: "+valoracio);

        // Provar una valoració invàlida
        try {
            valoracio.setValoracio(15); 
        } catch (IllegalArgumentException e) {
            System.out.println("Excepció capturada: " + e.getMessage());
        }

        //Prova de copia
        Valoracio copiaValoracio = valoracio.copia();
        System.out.println("Còpia de valoracio: " + copiaValoracio);

        // Comprovar si la còpia és independent
        copiaValoracio.setValoracio(5);
        System.out.println("Valoracio original (valoracio): " + valoracio);
        System.out.println("Valoracio modificada (còpia): " + copiaValoracio);

        System.out.println("\nPROVES CLASSE LLISTAVALORACIONS");
        LlistaValoracio llista = new LlistaValoracio(5);

        Valoracio valoracio1 = new Valoracio(membre1, 7);
        Valoracio valoracio2 = new Valoracio(membre2, 2);
        Valoracio valoracio3 = new Valoracio(membre3, 0);
        Valoracio valoracio4 = new Valoracio(membre4, 10);
        Valoracio valoracio5 = new Valoracio(membre5, 6);

        //Afegir valoracions
        System.out.println("Test Afegir Valoracions:");
        llista.afegirValoracio(valoracio1);
        System.out.println("Element afegit: " + valoracio1);
        llista.afegirValoracio(valoracio2);
        System.out.println("Element afegit: " + valoracio2);
        System.out.println("Nombre actual d'elements: " + llista.getnElem()+ "\n");

        //Eliminar valoracions
        System.out.println("Test Eliminar Valoracions:");
        boolean eliminat = llista.eliminarValoracio(valoracio1);
        System.out.println("Valoració eliminada? " + eliminat);
        System.out.println("Nombre d'elements després d'eliminar: " + llista.getnElem());

        boolean noEliminat = llista.eliminarValoracio(valoracio1);
        System.out.println("Valoració eliminada (segon intent)? " + noEliminat);
        System.out.println("Nombre d'elements després d'intentar eliminar de nou: " + llista.getnElem() + "\n");

        //Afegir valoració quan la llista està plena
        System.out.println("Test Afegir Valoració quan la llista està plena:");
        llista.afegirValoracio(valoracio1);
        llista.afegirValoracio(valoracio3);
        llista.afegirValoracio(valoracio4);
        llista.afegirValoracio(valoracio5);
        System.out.println("Nombre d'elements: " + llista.getnElem()+ ". Intentem afegir una 6 (fora de rang)");
        try {
            llista.afegirValoracio(new Valoracio(membre1, 7)); // Intenta afegir més de 5 elements
        } catch (IllegalStateException e) {
            System.out.println("Excepció llançada: " + e.getMessage());
        }

        //Comprovar el mètode getValo
        System.out.println("\nTest Obtener Valoració per Índex:");
        Valoracio obtinguda = llista.getValo(0);
        System.out.println("Valoració obtinguda (índex 0): " + obtinguda);
        try {
            Valoracio foraDeLimits = llista.getValo(10);
            System.out.println("Valoració obtinguda (índex fora de límits): " + foraDeLimits);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage()); 
        }

        //Comprovació mètode toString
        System.out.println("\nTest toString:");
        System.out.println("Llista actual de valoracions:\n" + llista.toString() + "\n");

        //Eliminar i moure elements
        System.out.println("Test Eliminar i Mou l'Element:");
        System.out.println("Valoracions abans d'eliminar:\n" + llista.toString());
        llista.eliminarValoracio(valoracio3);
        System.out.println("Valoracions després d'eliminar la valoracio 3 (variable):\n" + llista.toString());

        // Crear una copia de la lista
        System.out.println("Test copia llista:");
        LlistaValoracio copiaLlista = llista.copia();
        System.out.println("Llista original:");
        System.out.println(llista.toString());

        System.out.println("Còpia de la llista:");
        System.out.println(copiaLlista.toString());

        // Comprovar que la còpia és independent
        System.out.println("\nTest copia independent");
        valoracio1.setValoracio(10);
        System.out.println("Després de modificar la valoració de la llista original:");
        System.out.println("Llista original:");
        System.out.println(llista.toString());
        System.out.println("Còpia de la llista:");
        System.out.println(copiaLlista.toString());


        System.out.println("\nPROVES CLASSE MEMBRE");

        Data datIni = new Data(25, 11, 2023);
        Data dat = new Data(2, 2, 2024);
        Membre ivan = new Membre("Ivan", "Ivan@urv.es");

        Titulacio titP = new Titulacio("Gei");
        LlistaTitulacions titulacions =new LlistaTitulacions(4);
        titulacions.afegirTitulacio(titP);
        LlistaMembres membres =new LlistaMembres(5);
        // Prueba de Associacion
        Associacio asso = new Associacio("InfGei", "infGei@urv.es", ivan, ivan, ivan, titulacions, membres);
        ivan.afegirAsociacio(asso, datIni);

        Membre Lluis = new Membre("Lluis", "lluis28@gmail.com", datIni, asso, null);
        // pruebas de accio
        //Accio acccio1 = new Accio("Arquitectura", "Para todos", ivan, 0, dat);

        System.out.println("toString de membres");
        System.out.println(Lluis + "\n");
        System.out.println(ivan);

        LlistaAssociacio lAsso = new LlistaAssociacio(3);
        lAsso.afegirAsociacio(asso);

        Associacio asso2 = new Associacio("Astronomia", "infGei@urv.es", ivan, ivan, ivan, titulacions, membres);
        lAsso.afegirAsociacio(asso2);
        Data datas[] = new Data[2];
        datas[0] = new Data(1, 1, 2024);
        datas[1] = new Data(5, 6, 2024);
        Data datas2[] = new Data[2];
        
        Membre llusep = new Membre("Llusep", "llusep27@gmail.com", datas, datas2, lAsso);

        System.out.println("Utiliztacio del constructor de membre si esta en més associacions");
        System.out.println(llusep);


        System.out.println("\nPROVES CLASSE ACCIO\n");

        Accio accio = new Accio("Nose", "tucro trato", llusep, lAsso, dat);
        Accio accio2 = new Accio("Compas", "tucro trato", llusep, lAsso, dat);

        System.out.println(accio);
        System.out.println(accio2);

        System.out.println("\nPROVES CLASSE LLISTAACCIO\n");

        LlistaAccio laccio = new LlistaAccio(4);
        laccio.afegirAccio(accio);
        laccio.afegirAccio(accio2);

        System.out.println(laccio);

        System.out.println("\nPROVES CLASSE DEMOSTRACIO");

        Demostracio demost = new Demostracio("laprueba", "especial", llusep, lAsso, true, dat, 0, 15000);

        System.out.println(demost);

        System.out.println("\nPROVES CLASSE XERRADA");

        Xerrades xerra = new Xerrades("Estopa", "Nuevo album", llusep, lAsso, dat, 20);

        xerra.afegirMembreValoracio(valoracio5);
        xerra.afegirMembreValoracio(valoracio4);

        System.out.println(xerra);

        System.out.println("\nPROVES CLASSE PROFESSOR");
        //Creamos algunas fechas de alta y baja
        Data dataAlta1 = new Data(10, 1, 2020);
        Data dataBaixa1 = new Data(15, 12, 2021);

        //Creamos els membres provisionals
        LlistaMembres llistaMembresAsociacio = new LlistaMembres(4);
        llistaMembresAsociacio.afegirMembre(membre1);
        llistaMembresAsociacio.afegirMembre(membre2);
        llistaMembresAsociacio.afegirMembre(membre3);
        llistaMembresAsociacio.afegirMembre(membre4);

        //Creamos algunas asociaciones
        Associacio associacio1 = new Associacio("CodeURV", "codeURV@gmail.com", membre1, membre2, membre3, titulacions, llistaMembresAsociacio );

        // Crear una lista de asociaciones
        LlistaAssociacio lista = new LlistaAssociacio(3);
        lista.afegirAsociacio(associacio1);

        //Crear un objeto Professor
        Professor professor1 = new Professor("Profesor1", "profesor1@universidad.com", "Matemáticas", 101, new Data[]{dataAlta1}, lista, new Data[]{dataBaixa1});
        
        //Imprimir información del Profesor 1
        System.out.println("Profesor 1:");
        System.out.println(professor1);

        // Modificar el número de despacho y departamento del profesor1
        professor1.setNumeroDespatx(103);
        professor1.setNomDepartament("Química");
 
        // Imprimir información del Profesor 1 después de la modificación
        System.out.println("\nProfesor 1 después de cambios:");
        System.out.println(professor1);
        
        System.out.println("\nPROVES CLASSE ALUMNE");

        // Crear un objeto Alumne
        Alumne alumne1 = new Alumne("Alumno1", "alumno1@universidad.com", new Data[] {dataAlta1}, new Data[] {dataBaixa1}, lista, titP, true);

        // Imprimir información del Alumne 1
        System.out.println("Alumno 1:");
        System.out.println(alumne1);
                
        // Modificar el estado de graduado y titulacion del Alumne 1
        alumne1.setGraduat(false);
        alumne1.setTitulacio(new Titulacio("Matemáticas"));

        // Imprimir información del Alumne 1 después de la modificación
        System.out.println("\nAlumno 1 después de cambios:");
        System.out.println(alumne1);

        // Comprobar el estado de graduado para Alumne 2
        System.out.println("\n¿El Alumne 1 está graduado?");
        System.out.println(alumne1.isGraduat() ? "Sí" : "No");

        MainWindow.iniciarFinestra();

    }
}
