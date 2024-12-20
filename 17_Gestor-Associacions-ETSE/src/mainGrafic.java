import java.io.File;
import interficie.*;

public class mainGrafic 
{
    public static void main(String[] args)
    {
        File fitAssociacions = new File("sources/associacions.txt");
        File fitMembres = new File("sources/membres.txt");

        MainWindow.iniciarFinestra();

        Titulacio gei = new Titulacio("GEI");

        Membre profe = new Professor("oscar", "oscar.ruiz@estudiants.urv.cat", "Departament de Enginyeria Informatica y Matematiques", 201);
        Membre alumne = new Alumne("Pol", "pol.hernandez@estudiants.urv.cat", gei, false);
        Membre membre = new Alumne("Manuel", "manuel.gonzalez@estudiants.urv.cat", gei, true);
        LlistaMembres llistaMembres = new LlistaMembres(3);
    }    
}
