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

        Membre oscar = new Alumne("Oscar Ruiz", "oscar.ruiz@estudiants.urv.cat", new Titulacio("GEI"), false, new Data(8, 1, 24), associacions.getAsociacioAt(0), null);
        Membre ivan = new Alumne("Ivan Carayol", "ivan.carayol@estudiants.urv.cat", new Titulacio("GEI"), true, new Data(21, 11, 23), associacions.getAsociacioAt(1), new Data(18, 10, 24));
        Membre gaizka = new Membre("Gaizka Alonso", "gaizka.alonso@estudiants.urv.cat");

        LlistaAssociacio associacionsMarc = new LlistaAssociacio(2);
        associacionsMarc.afegirAsociacio(associacions.getAsociacioAt(0));
        associacionsMarc.afegirAsociacio(associacions.getAsociacioAt(3));

        Data[] datesAltaMarc = new Data[2];
        datesAltaMarc[0] = new Data(3, 2, 24);
        datesAltaMarc[1] = new Data(10, 11, 24);

        Data[] datesBaixaMarc = new Data[2];
        datesBaixaMarc[0] = new Data(22, 5, 24);

        Membre marc = new Professor("Marc Rozas", "marc.rozas@estudiants.urv.cat", "Departament de Enginyeria Informatica y Matematiques", 210, datesAltaMarc, associacionsMarc, datesBaixaMarc);

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
