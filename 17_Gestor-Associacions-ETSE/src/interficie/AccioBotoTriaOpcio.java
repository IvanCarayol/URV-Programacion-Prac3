package interficie;

import java.awt.event.*;
import javax.swing.*;

public class AccioBotoTriaOpcio implements ActionListener{
    private Aplicacio app;

    public AccioBotoTriaOpcio (Aplicacio app){
        this.app = app;
    }

    public void actionPerformered(ActionEvent e){
        if(e.getSource() == botoDA){
            mostrarDemostracionsActives();
        }
    }
}
