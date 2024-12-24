package interficie;
import javax.swing.*;

import Objectes.*;

public class Finestra extends JFrame
{
    private static final long serialVersionUID= 1L;
    private JTable table;
    private JTextArea detailsArea;
    private Demostracio[] demostracions;
    private LlistaAccio accions;
    private LlistaMembres membre;
    private LlistaAssociacio associacio;

    
    public Finestra(String titol, int width, int height)
    {
        super(titol);
        this.setLocation(100, 200);
        this.setSize(width,height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        carregarDemostracions();
        accions = Dades.llegirAccions(membre, associacio);

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

        table = new JTable(data, nombreDeLesColumnes);
        detailsArea = new JTextArea();
        detailsArea.setEditable(false);

        JButton detailsButton = new JButton("Mostrat detalls");
        detailsButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if(selectedRow != -1){
                Demostracio demostracio = demostracions[selectedRow];
                mostrarDetalls(demostracio);
            }
        });

        // Afegir components al JFrame 
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); 
        this.add(new JScrollPane(table)); 
        this.add(detailsButton); 
        this.add(new JScrollPane(detailsArea)); 
        this.setVisible(true);
    }
    
    private void mostrarDetalls(Demostracio demostracio) { 
        detailsArea.setText(demostracio.toString()); 
    }

    private void carregarDemostracions(){
        int y = 0;

        for (int i = 0; i < accions.getContador(); i++){
            if (accions.getAccio(i) instanceof Demostracio){
                demostracions[y] = (Demostracio) accions.getAccio(i);
                y++;
            }
        }
    }
    public static void main(String[] args) { 
        SwingUtilities.invokeLater(() -> new Finestra("Informació de Demostracions", 200, 200)); }
}