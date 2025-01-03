package interficie;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Objectes.*;


public class Aplicacio extends JFrame {
    private JPanel nord, centre, centreM, centreS;
    private JTextField dni;
    private static String dniUser="";
    private JTextArea missatges;
    private static String textMissatges="Informació sobre la votació realitzada:";
    private JButton botoDA, botoDAA;
    private LlistaAccio accions; 
    private LlistaAssociacio associacions;

    public Aplicacio(LlistaAccio accions, LlistaAssociacio associacions){
        super("Associacions i demostracions");
        this.accions = accions;
        this.associacions = associacions;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 300);
        Container meuCont = getContentPane();
        meuCont.setLayout(new BorderLayaout());

        centre =new JPanel(new BorderLayout());
        JLabel instruc = new JLabel ("Selecciona el boto segons l'opcio");
        centre.add(instruc, BorderLayout.NORTH);

        AccioBotoTriaOpcio accio = new AccioBotoTriaOpcio(this);
        centreM = new JPanel(new FlowLayout());
        botoDA = new JButton("Demostracions actives");
        botoDA.addActionListener(accio);
        botoDAA = new JButton("Demostracions actives d'una associacio");
        botoDAA.addActionListener(accio);
        
        centreM.add(botoDA);
        centreM.add(botoDAA);
        centre.add(centreM, BorderLayout.CENTER);

        missatges = new JTextArea(10, 80);
        missatges.setEditable(false);
        JScrollPane scr = new JScrollPane(missatges);
        centre.add(scr, BorderLayout.SOUTH);

        meuCont.add(centre, BorderLayaout.CENTER);

        setVisible(true);
    }
    public static void main(String[] args) {
        LlistaAssociacio associacions;
        LlistaMembres membres;
        LlistaTitulacions titulacions;
        LlistaAccio accions;
        LlistaValoracio[] valoracions;

        
        associacions = Dades.carregaAssociacions();
        titulacions = Dades.carregaTitulacions();
        membres = Dades.llegirMembres(associacions, titulacions);
        accions = Dades.llegirAccions(membres, associacions);
        valoracions = Dades.llegirValoracions(membres);
        Dades.organizarValoraciones(valoracions, accions);

        new Aplicacio(accions, associacions);
    }
}
