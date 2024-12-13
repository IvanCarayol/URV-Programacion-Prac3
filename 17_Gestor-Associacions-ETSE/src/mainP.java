import java.io.File;

public class mainP {
    public static void main(String[] args) {
        // 2.1 Llistar associacions
        File document = new File("informacion.txt");
        LlistaAssociacio lAssocicions = new LlistaAssociacio(100);

        // 2.3. Llistar membres actius de cualsevol associacio
        LlistaMembres lMembresActius = new LlistaMembres(100);
        
        // 2.4. Llistar accions 
        LlistaAccio lAccio = new LlistaAccio(4);
        //lAccio.afegirAccio(null);

        // 2.5. Llistar accions d’ una associació concreta
        //LlistaAccio acc2 =  lAccio.accioDeUnaAssociacio(associacio1);

        // 2.10. Afegir una nova demostració

    }
}
