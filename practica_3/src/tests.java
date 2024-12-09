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

        Membre Lluis = new Membre("Lluis", "lluis28@gmail.com", datIni, null, asso);
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
        
        Membre llusep = new Membre("Llusep", "llusep27@gmail.com");

        for (int i = 0; i < lAsso.getNumelem(); i++)
        {
            llusep.afegirAsociacio(lAsso.getAsociacioAt(i), datas[i]);
            llusep.setDataBaixa(datas2[i], i);
        }

        System.out.println("Utiliztacio del constructor de membre si esta en més associacions");
        System.out.println(llusep);


        System.out.println("\nPROVES CLASSE ACCIO\n");

        Accio accio = new Accio("Nose", "tucro trato", llusep, lAsso, dat);
        Accio accio2 = new Accio("Compas", "tucro trato", llusep, lAsso, dat);

        System.out.println(accio);
        System.out.println(accio2);

        System.out.println("\nPROVES CLASSE DEMOSTRACIO");

        Demostracio demost = new Demostracio("laprueba", "especial", llusep, lAsso, true, dat, 0, 15000);

        System.out.println(demost);

        System.out.println("\nPROVES CLASSE XERRADA");

        Xerrades xerra = new Xerrades("Estopa", "Nuevo album", llusep, lAsso, dat, 20);

        xerra.afegirMembreValoracio(valoracio5);
        xerra.afegirMembreValoracio(valoracio4);

        System.out.println(xerra);

    }
}
