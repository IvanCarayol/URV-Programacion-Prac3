package interficie;
import funcions.*;
import javax.swing.*;

public class Finestra extends JFrame
{
    private static final long serialVersionUID= 1L;
    private JTable table;
    private JTextArea detailsArea;
    private Demostracio[] demostracions;

    
    public Finestra(String titol, int width, int height)
    {
        super(titol);
        this.setLocation(100, 200);
        this.setSize(width,height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        demostracions = carregarDemostracions();

        // Crear la taula amb les dades de demostracions 
        String[] nombreDeLesColumnes = {"Codi", "Nom", "Títol", "Responsable", "Data", "Vàlida", "Vegades Ofert", "Cost Material"};
        String[][] data = new String[demostracions.length][nombreDeLesColumnes.length]; 
        for (int i = 0; i < demostracions.length; i++) { 
            Demostracio demo = demostracions[i]; 
            data[i][0] = demo.getCodi(); 
            data[i][1] = demo.getNom(); 
            data[i][2] = demo.getTitol(); 
            data[i][3] = demo.getResponsable().getAlias(); 
            data[i][4] = demo.getData().toString();
            data[i][5] = String.valueOf(demo.isValida()); 
            data[i][6] = String.valueOf(demo.getVegades_oferit()); 
            data[i][7] = String.valueOf(demo.getCost_material());
        }
    }
    
}