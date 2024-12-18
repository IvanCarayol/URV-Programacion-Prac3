import java.io.File;

public class mainP {
    public static void main(String[] args) {
        // 2.1 Llistar associacions
        /*File fitAssociacions = new File("sources/associacions.txt");
        LlistaAssociacio lAssocicions = new LlistaAssociacio(100);

        // 2.3. Llistar membres actius de cualsevol associacio
        File fitMembres = new File("sources/membres.txt");
        LlistaMembres lMembresActius = new LlistaMembres(100);
        
        // 2.4. Llistar accions 
        LlistaAccio lAccio = new LlistaAccio(4);
        //lAccio.afegirAccio(null);

        // 2.5. Llistar accions d’ una associació concreta
        //LlistaAccio acc2 =  lAccio.accioDeUnaAssociacio(associacio1);

        // 2.10. Afegir una nova demostració*/

        LlistaAssociacio associacions;
        LlistaMembres membres;
        LlistaTitulacions titulacions = new LlistaTitulacions(1);

        titulacions.afegirTitulacio(new Titulacio("GEI"));

        //Prueba Guardado y Cargado de Asociaciones
        LlistaAssociacio llistaAssociacio = new LlistaAssociacio(10);
        LlistaMembres llistaMembres = new LlistaMembres(3);

        for (int i = 0; i < llistaMembres.getMaxLength(); i++)
        {
            Membre membre1 = new Membre("Hola"+i+"", "hola"+i+"@estudiants.urv.cat");
            llistaMembres.afegirMembre(membre1);
        }
        for (int i = 0; i < 10; i++)
        {
            
            Associacio associacio = new Associacio("Hola"+i+"", "Hola", llistaMembres.getMembreAt(0), llistaMembres.getMembreAt(2), llistaMembres.getMembreAt(1), null, llistaMembres);
            llistaAssociacio.afegirAsociacio(associacio);
        }

        Dades.guardaAssociacions(llistaAssociacio);

        associacions = Dades.carregaAssociacions();

        /*for (int i = 0; i < associacions.getNumelem(); i++)
        {
            System.out.println(associacions.getAsociacioAt(i).getNom());
        }*/

        //Prueba Guardado y Cargado miembros

        membres  = new LlistaMembres(10);

        LlistaDates datesAlta = new LlistaDates(3);
        LlistaDates datesBaixa = new LlistaDates(3);
        LlistaAssociacio associacionsM = new LlistaAssociacio(3);
        associacionsM.afegirAsociacio(associacions.getAsociacioAt(0));
        datesAlta.afegirData(new Data(8, 1, 24));

        Membre oscar = new Alumne("Oscar Ruiz", "oscar.ruiz@estudiants.urv.cat", new Titulacio("GEI"), false, datesAlta, associacionsM, datesBaixa);

        datesAlta = new LlistaDates(3);
        datesBaixa = new LlistaDates(3);
        associacionsM = new LlistaAssociacio(3);

        datesAlta.afegirData(new Data(21, 11, 23));
        datesBaixa.afegirData(new Data(18, 10, 24));

        Membre ivan = new Alumne("Ivan Carayol", "ivan.carayol@estudiants.urv.cat", new Titulacio("GEI"), true, datesAlta, associacionsM, datesBaixa);
        Membre gaizka = new Membre("Gaizka Alonso", "gaizka.alonso@estudiants.urv.cat");

        associacionsM = new LlistaAssociacio(3);
        associacionsM.afegirAsociacio(associacions.getAsociacioAt(0));
        associacionsM.afegirAsociacio(associacions.getAsociacioAt(3));
        
        datesAlta = new LlistaDates(3);
        datesAlta.afegirData(new Data(3, 2, 24));
        datesAlta.afegirData(new Data(10, 11, 24));

        datesBaixa = new LlistaDates(3);
        datesBaixa.afegirData(new Data(22, 5, 24));

        Membre marc = new Professor("Marc Rozas", "marc.rozas@estudiants.urv.cat", "Departament de Enginyeria Informatica y Matematiques", 210, datesAlta, associacionsM, datesBaixa);

        llistaMembres = new LlistaMembres(4);
        llistaMembres.afegirMembre(oscar);
        llistaMembres.afegirMembre(ivan);
        llistaMembres.afegirMembre(gaizka);
        llistaMembres.afegirMembre(marc);

        Dades.guardarMembres(llistaMembres);

        membres = new LlistaMembres(0);
        membres = Dades.llegirMembres(associacions, titulacions);
        
        System.out.println(membres);
    }
}
