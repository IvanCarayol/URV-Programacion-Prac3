package interficie;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Objectes.*;

/**
 * La classe Aplicacio extén JFrame i gestiona la interfície gràfica d'usuari
 * per a l'aplicació de demostracions i associacions.
 */
public class Aplicacio extends JFrame {
    private JPanel nord, centre, centreM, centreText;
    private JTextArea missatges;
    private JTextField textAssociacio;
    private JButton botoDA, botoDAA;
    private LlistaAccio accions;
    private LlistaAssociacio associacions;

    /**
     * Constructor de la classe Aplicacio.
     * 
     * @param accions Llista d'accions.
     * @param associacions Llista d'associacions.
     */
    public Aplicacio(LlistaAccio accions, LlistaAssociacio associacions) {
        super("Associacions i demostracions");
        this.accions = accions;
        this.associacions = associacions;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 700);
        Container meuCont = getContentPane();
        meuCont.setLayout(new BorderLayout());

        nord = new JPanel(new BorderLayout());
        JLabel instruc = new JLabel("Selecciona el botó desitjat. La informacio la trobaras a la part inferior de la finestra");
        instruc.setHorizontalAlignment(JLabel.CENTER);
        nord.add(instruc, BorderLayout.NORTH);

        centre = new JPanel(new BorderLayout());
        AccioBotoTriaOpcio accio = new AccioBotoTriaOpcio(this);
        centreM = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        botoDA = new JButton("Demostracions actives");
        botoDA.addActionListener(accio);
        botoDAA = new JButton("Demostracions actives d'una associació");
        botoDAA.addActionListener(accio);

        centreM.add(botoDA);
        centreM.add(botoDAA);

        // Nou panell per a l'etiqueta i el camp de text
        centreText = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        centreText.add(new JLabel("Nom de l'associació:"));
        textAssociacio = new JTextField(20);
        centreText.add(textAssociacio);

        centre.add(centreM, BorderLayout.NORTH);  // Moure el centreM al nord perquè el centreText estigui visible
        centre.add(centreText, BorderLayout.CENTER);  // Afegir el nou panell al centre

        missatges = new JTextArea(20, 100);
        missatges.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(missatges);
        centre.add(scrollPane, BorderLayout.SOUTH);

        meuCont.add(nord, BorderLayout.NORTH);
        meuCont.add(centre, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Mètode principal que carrega les dades i crea una instància d'Aplicacio.
     * 
     * @param args Arguments de línia de comandament.
     */
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

    /**
     * Classe interna que gestiona les accions dels botons.
     */
    private class AccioBotoTriaOpcio implements ActionListener {
        private Aplicacio aplicacio;

        /**
         * Constructor de la classe AccioBotoTriaOpcio.
         * 
         * @param aplicacio Instància d'Aplicacio.
         */
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

    /**
     * Mostra les demostracions actives a l'àrea de missatges.
     */
    private void mostrarDemostracionsActives() {
        missatges.setText("");
        Demostracio[] demostracionsActives = accions.demostracionsValides();
        missatges.append("\t\t\t\t\t\tDEMOSTRACIONS ACTIVES\n");
        if (demostracionsActives != null){
            for (int i = 0; i < demostracionsActives.length; i++) {
                if(demostracionsActives[i] != null){
                    missatges.append(demostracionsActives[i].toString() + "\n");
                }
            }
        } else {
            missatges.append("No hi ha demostracions actives.\n");
        }
        
    }

    private void mostrarDemostracionsActivesPerAssociacio() { 
        missatges.setText(""); 
        String nomAssociacio = textAssociacio.getText(); // Obtenir el nom de l'associació del camp de text 
        missatges.append("\t\t\t\t\t\tDEMOSTRACIONS ACTIVES DE "+nomAssociacio+"\n");

        if (nomAssociacio != null && !nomAssociacio.trim().isEmpty()) { 
            Demostracio[] demostracionsActives = accions.demostracionsPerAssociacio(nomAssociacio, accions.demostracionsValides());  
            if (demostracionsActives != null && demostracionsActives.length > 0) { 
                boolean trobat = false; 
                for (int i = 0; i < demostracionsActives.length; i++) { 
                    if (demostracionsActives[i] != null) { 
                        missatges.append(demostracionsActives[i].toString() + "\n"); 
                        trobat = true; 
                    } 
                } if (!trobat) { 
                            missatges.append("L'associació " + nomAssociacio + " no te cap demostracio activa o no existeix.\n"); 
                } 
            } else { 
                missatges.append("L'associació " + nomAssociacio + " no te cap demostracio activa o no existeix.\n"); 
            }
            
        } else { 
            missatges.append("Associació no trobada o nom no introduït.\n"); 
        } 
    }
}
