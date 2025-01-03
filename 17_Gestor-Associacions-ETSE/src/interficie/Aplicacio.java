package interficie;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Objectes.*;

public class Aplicacio extends JFrame {
    private JPanel centre, centreM;
    private JTextArea missatges;
    private JButton botoDA, botoDAA;
    private LlistaAccio accions;
    private LlistaAssociacio associacions;
    private JLabel labelAssociacio;

    public Aplicacio(LlistaAccio accions, LlistaAssociacio associacions) {
        super("Associacions i demostracions");
        this.accions = accions;
        this.associacions = associacions;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 700);
        Container meuCont = getContentPane();
        meuCont.setLayout(new BorderLayout());

        centre = new JPanel(new BorderLayout());
        JLabel instruc = new JLabel("Selecciona el boto segons l'opcio");
        centre.add(instruc, BorderLayout.NORTH);

        AccioBotoTriaOpcio accio = new AccioBotoTriaOpcio(this);
        centreM = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        botoDA = new JButton("Demostracions actives");
        botoDA.addActionListener(accio);
        botoDAA = new JButton("Demostracions actives d'una associacio");
        botoDAA.addActionListener(accio);

        centreM.add(botoDA);
        centreM.add(botoDAA);
        centre.add(centreM, BorderLayout.CENTER);

        missatges = new JTextArea(20, 100);
        missatges.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(missatges);
        centre.add(scrollPane, BorderLayout.SOUTH);

        labelAssociacio = new JLabel();
        centre.add(labelAssociacio, BorderLayout.PAGE_END);

        meuCont.add(centre, BorderLayout.CENTER);

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

    private class AccioBotoTriaOpcio implements ActionListener {
        private Aplicacio aplicacio;

        public AccioBotoTriaOpcio(Aplicacio aplicacio) {
            this.aplicacio = aplicacio;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == botoDA) {
                mostrarDemostracionsActives();
            } else if (e.getSource() == botoDAA) {
                mostrarDemostracionsActivesPerAssociacio();
            }
        }
    }

    private void mostrarDemostracionsActives() {
        missatges.setText("");
        Demostracio[] demostracionsActives = accions.demostracionsValides();
        for (int i = 0; i < demostracionsActives.length; i++) {
            missatges.append(demostracionsActives.toString() + "\n");
        }
    }
    
    private void mostrarDemostracionsActivesPerAssociacio() { 
        missatges.setText(""); 
        String nomAssociacio = JOptionPane.showInputDialog(this, "Introdueix el nom de l'associació:"); 
        Demostracio[] demostracionsActives = accions.demostracionsValides();
        for (int i = 0; i < demostracionsActives.length; i++) { 
            if (demostracionsActives[i] != null) { 
                missatges.append(demostracionsActives[i].toString() + "\n"); 
            } 
        } 
        labelAssociacio.setText("Nom de l'associació: " + nomAssociacio); 
    }
}
