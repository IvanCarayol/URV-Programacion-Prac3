import java.util.Random;

import javax.swing.GroupLayout.Alignment;

import org.xml.sax.SAXException;

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
        LlistaTitulacions titulacions = new LlistaTitulacions(4);

        titulacions.afegirTitulacio(new Titulacio("GEI"));
        titulacions.afegirTitulacio(new Titulacio("ADE"));
        titulacions.afegirTitulacio(new Titulacio("GEE"));
        titulacions.afegirTitulacio(new Titulacio("FIB"));

        //Prueba Guardado y Cargado de Asociaciones
        LlistaAssociacio llistaAssociacio = new LlistaAssociacio(20);
        LlistaMembres llistaMembres = new LlistaMembres(20);

        LlistaDates datesAlta = new LlistaDates(3);
        LlistaDates datesBaixa = new LlistaDates(3);

        String[] nomsAssociacions = {
            "URBots", "URVoltage", "GreenTeam", "PhysicsSociety", "MathClub",
            "HistoryCircle", "URCulture", "GEIClub", "TechForum", "URBusiness",
            "URLiterature", "URScience", "TechClub", "RoboticsTeam", "LiteratureSociety",
            "BusinessClub", "URMath", "CulturaClub", "UREco", "URPhysics"
        };

        String[] correosAssociacions = {
            "urbots@associacions.urv.cat", "urvoltage@associacions.urv.cat", "greenteam@associacions.urv.cat", 
            "physicssociety@associacions.urv.cat", "mathclub@associacions.urv.cat", "historycircle@associacions.urv.cat", 
            "urculture@associacions.urv.cat", "geiclub@associacions.urv.cat", "techforum@associacions.urv.cat", 
            "urbusiness@associacions.urv.cat", "urliterature@associacions.urv.cat", "urscience@associacions.urv.cat", 
            "techclub@associacions.urv.cat", "roboticsteam@associacions.urv.cat", "literaturesociety@associacions.urv.cat", 
            "businessclub@associacions.urv.cat", "urmath@associacions.urv.cat", "culturaclub@associacions.urv.cat", 
            "ureco@associacions.urv.cat", "urphysics@associacions.urv.cat"
        };
        
        

        // Nombres y apellidos de ejemplo para los miembros
        String[][] nomsMembres = {
            {"Oscar Ruiz", "Ivan Carayol", "Gaizka Alonso"},
            {"Marc Rozas", "Pau Vila", "Clara Serra"},
            {"Anna Puig", "Joan Segarra", "Marta Font"},
            {"Laura Pons", "Jordi Roca", "Sara Esteve"},
            {"Toni Camps", "Maria Llop", "Carla Vidal"}
        };

        String[][] correosAlumnos = {
            {"oscar.ruiz@estudiants.urv.cat", "ivan.carayol@estudiants.urv.cat", "gaizka.alonso@estudiants.urv.cat"},
            {"marc.rozas@estudiants.urv.cat", "pau.vila@estudiants.urv.cat", "clara.serra@estudiants.urv.cat"},
            {"anna.puig@estudiants.urv.cat", "joan.segarra@estudiants.urv.cat", "marta.font@estudiants.urv.cat"},
            {"laura.pons@estudiants.urv.cat", "jordi.roca@estudiants.urv.cat", "sara.esteve@estudiants.urv.cat"},
            {"toni.camps@estudiants.urv.cat", "maria.llop@estudiants.urv.cat", "carla.vidal@estudiants.urv.cat"}
        };

        Random rand = new Random();
        Alumne alumne;
        for (int i = 0; i < 20; i++)
        {
            LlistaMembres llista = new LlistaMembres(3);
            for (int j = 0; j < 3; j++)
            {   
                alumne = new Alumne(nomsMembres[i % 5][j], correosAlumnos[i % 5][j], titulacions.getTitulacioAt(rand.nextInt(4)), rand.nextInt(1) != 0);
                llistaMembres.afegirMembre(alumne);
                llista .afegirMembre(alumne);
            }
            LlistaTitulacions titolsMembres = new LlistaTitulacions(3);
            alumne = (Alumne)llista.getMembreAt(0);
            titolsMembres.afegirTitulacio(alumne.getTitulacio());
            alumne = (Alumne)llista.getMembreAt(1);
            titolsMembres.afegirTitulacio(alumne.getTitulacio());
            alumne = (Alumne)llista.getMembreAt(2);
            titolsMembres.afegirTitulacio(alumne.getTitulacio());
            llistaAssociacio.afegirAsociacio(new Associacio(nomsAssociacions[i], correosAssociacions[i], llista.getMembreAt(0), llista.getMembreAt(1), llista.getMembreAt(2), titolsMembres, llista));
        }

        Dades.guardaAssociacions(llistaAssociacio);

        associacions = Dades.carregaAssociacions();

        for (int i = 0; i < associacions.getNumelem(); i++)
        {
            System.out.println(associacions.getAsociacioAt(i).getNom());
        }

        //Prueba Guardado y Cargado miembros

        membres = new LlistaMembres(0);
        membres = Dades.llegirMembres(associacions, titulacions);
        
        System.out.println(membres);


    }
}
