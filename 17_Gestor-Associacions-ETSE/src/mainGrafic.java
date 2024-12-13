import java.io.File;

public class mainGrafic 
{
    public static void main(String[] args)
    {
        File fitAssociacions = new File("sources/associacions.txt");
        File fitMembres = new File("sources/membres.txt");

        MainWindow.iniciarFinestra();
    }    
}
