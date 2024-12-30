import Objectes.*;
import interficie.*;
public class tests {
    public static void main(String[] args) {

        Membre membre1 = new Alumne("Pep", "pep33@gmail.com", null, false);
        Membre membre2 = new Alumne("Fernando", "fernando32@gmail.com", null, false);
        Membre membre3 = new Alumne("Joan", "joan31@gmail.com", null, false);
        Membre membre4 = new Alumne("Josep", "josep30@gmail.com", null, false);
        Membre membre5 = new Alumne("Pau", "pau29@gmail.com", null, false);
        //Probes clase valoracio
        System.out.println("PROVES CLASSE VALORACIONS");

        //Constructor amb parametres
        Valoracio valoracio = new Valoracio(membre1, 7);
        System.out.println(valoracio);

        //Prova getters
        System.out.println("Membre de valoracio:\n" + valoracio.getMembre());
        System.out.println("Valoració donada: " + valoracio.getValoracio());

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
        LlistaValoracio llista = new LlistaValoracio(5,"");

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

        LlistaDates datIni = new LlistaDates(3);
        datIni.afegirData(new Data(25, 11, 2023));

        LlistaDates dat = new LlistaDates(3);
        Membre ivan = new Alumne("Ivan", "Ivan@urv.es", new Titulacio("ADE"), false);

        Titulacio titP = new Titulacio("Gei");
        LlistaTitulacions titulacions =new LlistaTitulacions(4);
        titulacions.afegirTitulacio(titP);
        LlistaMembres membres =new LlistaMembres(5);
        // Prueba de Associacion
        
        Associacio asso = new Associacio("InfGei", "infGei@urv.es", ivan, ivan, ivan, titulacions, membres);
        ivan.afegiraAsociacio(asso, datIni.getDataInPos(0));

        LlistaAssociacio associacions = new LlistaAssociacio(3);
        associacions.afegirAsociacio(asso);
        Membre Lluis = new Alumne("Lluis", "lluis28@gmail.com",null, false, datIni, associacions, null);
        // pruebas de accio
        //Accio acccio1 = new Accio("Arquitectura", "Para todos", ivan, 0, dat);

        System.out.println("toString de membres");
        System.out.println(Lluis + "\n");
        System.out.println(ivan);

        LlistaAssociacio lAsso = new LlistaAssociacio(3);
        LlistaAssociacio lAsso2 = new LlistaAssociacio(3);
        lAsso.afegirAsociacio(asso);
        
        Associacio asso2 = new Associacio("Astronomia", "infGei@urv.es", ivan, ivan, ivan, titulacions, membres);
        lAsso.afegirAsociacio(asso2);
        lAsso2.afegirAsociacio(asso2);

        
        
        LlistaDates datas = new LlistaDates(3);
        datas.afegirData(new Data(1, 1, 2024));
        datas.afegirData(new Data(5, 6, 2024));
        LlistaDates datas2 = new LlistaDates(3);
        
        Membre llusep = new Alumne("Llusep", "llusep27@gmail.com", new Titulacio("GEI"), false, datas, lAsso, datas2);

        System.out.println("Utiliztacio del constructor de membre si esta en més associacions");
        System.out.println(llusep);


        System.out.println("\nPROVES CLASSE ACCIO\n");
        dat.afegirData(new Data(1, 3, 2023));
        Accio accio = new Accio("Nose", "tucro trato", llusep, lAsso, dat.getDataInPos(0));
        Accio accio2 = new Accio("Compas", "Al ritmo", llusep, lAsso, dat.getDataInPos(0));
        Accio accio3 = new Accio("Tercer", "Prueba", llusep, lAsso2, dat.getDataInPos(0));

        System.out.println(accio.getCodi());
        System.out.println(accio.getNom());
        System.out.println(accio.getTitol());

        accio.setTitol("cambioTit");
        System.out.println(accio.getTitol());

        LlistaAssociacio associacioAux = accio.getLlistaAssociacio();
        System.out.println(associacioAux);

        System.out.println(accio.getResponsable());

        accio.setResponsable(Lluis);

        System.out.println(accio.getData());
        Data dts = new Data(10, 1, 2020);
        accio.setData(dts);

        System.out.println(accio.getData());
        if(accio.esAssociacioDeAccio(asso)) System.out.println("Esta");

        System.out.println(accio);
        System.out.println(accio2);

        System.out.println("\nPROVES CLASSE LLISTAACCIO\n");

        LlistaAccio laccio = new LlistaAccio(4);
        
        laccio.afegirAccio(accio);

        System.out.println(laccio.getContador());
        System.out.println(laccio.getAccio(0));
        Accio[] accions = laccio.getListaAccions();
        System.out.println("longitut: " + accions.length);

        laccio.afegirAccio(accio2);
        laccio.afegirAccio(accio3);

        System.out.println("Accions de una associacio");
        System.out.println(laccio.accioDeUnaAssociacio(asso));

        System.out.println("Prueba toString");
        System.out.println(laccio);

        Xerrades xerra2 = new Xerrades("Estopa", "Nuevo album", llusep, lAsso, dat.getDataInPos(0), 20);
        laccio.afegirAccio(xerra2);

        System.out.println("\nPROVES CLASSE DEMOSTRACIO");

        Demostracio demost = new Demostracio("laprueba", "especial", llusep, lAsso, dat.getDataInPos(0), true, 1, 15000);

        if(demost.getValida()) {
            System.out.println("Demostració valida");
        } else {
            System.out.println("Demostració no es valida");
        }

        demost.setValida(false);
        if(demost.getValida()) {
            System.out.println("Demostració valida");
        } else {
            System.out.println("Demostració no es valida");
        }

        System.out.println("vegades oferit: " + demost.getVegades_oferit());
        demost.setVegades_oferit(2);
        System.out.println("Cost material: " + demost.getCost_material());
        demost.setCost_material(5432);
        System.out.println("Cost material: " + demost.getCost_material());
        System.out.println(demost);

        System.out.println("\nPROVES CLASSE XERRADA");

        Xerrades xerra = new Xerrades("Estopa", "Nuevo album", llusep, lAsso, dat.getDataInPos(0), 20);

        xerra.afegirMembreValoracio(valoracio5);
        xerra.afegirMembreValoracio(valoracio4);

        System.out.println("Num Mem Xerrada: " + xerra.getnumMembres());
        System.out.println("Num Mem Xerrada: " + xerra.getNumValoracions());
        System.out.println("Valoracio x: " + xerra.getValoracioIndex(0));
        xerra.afegirMembre(membre5);

        System.out.println(xerra);

        System.out.println("Nombre de valoracions afegides: " + xerra.getNumValoracions());

        Valoracio valoracioInvalida = new Valoracio(membre1, 15);

        // Afegir valoracio a la xerrada 
        try { 
            xerra.valorarXerrada(valoracio1); 
            System.out.println("Valoració 1 afegida amb èxit."); 
        } catch (IllegalArgumentException e) { 
            System.out.println("Error afegint valoració 1: " + e.getMessage()); 
        }

        // Afegir valoracio invalida a la xerrada 
        try { 
            xerra.valorarXerrada(valoracioInvalida); 
            System.out.println("Valoració invalida afegida amb èxit."); 
        } catch (IllegalArgumentException e) { 
            System.out.println("Error afegint valoració invalida: " + e.getMessage()); 
        }

        System.out.println("Nombre de valoracions afegides: " + xerra.getNumValoracions());

        System.out.println("\nPROVES CLASSE PROFESSOR");
        //Creamos algunas fechas de alta y baja
        Data dataAlta1 = new Data(10, 1, 2020);
        Data dataBaixa1 = new Data(15, 12, 2021);
        LlistaDates datesAlta1 = new LlistaDates(3);
        LlistaDates datesBaixa1 = new LlistaDates(3);
        datesAlta1.afegirData(dataAlta1);
        datesBaixa1.afegirData(dataBaixa1);

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
        Professor professor1 = new Professor("Profesor1", "profesor1@universidad.com", "Matemáticas", 101, datesAlta1, lista, datesBaixa1);
        
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
        Alumne alumne1 = new Alumne("Alumno1", "alumno1@universidad.com", titP, true, datesAlta1, lista, datesBaixa1);

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

        System.out.println("\nPROVES CLASSE DATA");

        Data data = new Data(15, 5, 2023);
        System.out.println("Data creada: "+data);

        // Probar getters 
        if (data.getDia() == 15 && data.getMes() == 5 && data.getAny() == 2023) { 
            System.out.println("Test getters PASSAT"); 
        } else { 
            System.out.println("Test getters FALLAT"); 
        } 

        // Proba setters
        data.setDia(20);
        data.setMes(6);
        data.setAny(2024);

        if (data.getDia() == 20 && data.getMes() == 6 && data.getAny() == 2024) { 
            System.out.println("Test setters PASSAT"); 
        } else { 
            System.out.println("Test setters FALLAT"); 
        } 

        // Probar copia 
        Data copiaData = data.copia(); 
        if (copiaData != data && copiaData.getDia() == data.getDia() && copiaData.getMes() == data.getMes() && copiaData.getAny() == data.getAny()) { 
            System.out.println("Test copia PASSAT"); 
        } else { 
            System.out.println("Test copia FALLAT"); 
        }
        
        // Probar comparar
        Data data1 = new Data(15, 5, 2023); 
        Data data2 = new Data(10, 5, 2023); 
        Data data3 = new Data(5, 5, 2023); 
        Data data4 = new Data(15, 6, 2023);

        if(data.compararDatas(data1, data2)){
            System.out.println("Test primera posterior PASSAT"); 
        } else { 
            System.out.println("Test primera posterior FALLAT"); 
        }

        if(!data.compararDatas(data3, data4)){
            System.out.println("Test segona posterior PASSAT"); 
        } else { 
            System.out.println("Test segona posterior FALLAT"); 
        }

        //MainWindow.iniciarFinestra();

    }
}
