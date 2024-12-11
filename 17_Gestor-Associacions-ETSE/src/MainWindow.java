import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.*;

public class MainWindow
{
    public static void IniciarFinestra()
    {
        Finestra mainWinow = new Finestra("Main", 500, 300);
        mainWinow.setLayout(new GridLayout(1, 3, 0, 0));

        
        JPanel columnaEsquerra = new JPanel();
        JPanel columnaDreta = new JPanel();
        JPanel columnaCentral = new JPanel();

        columnaEsquerra.setLayout(new BorderLayout());
        columnaCentral.setLayout(new BorderLayout());
        columnaDreta.setLayout(new BorderLayout());

        mainWinow.add(columnaEsquerra);
        mainWinow.add(columnaCentral);
        mainWinow.add(columnaDreta);

        columnaEsquerra.add(Imatge("sources/urv_icon.jpg",0.15f), BorderLayout.NORTH);
        columnaEsquerra.add(Imatge("sources/urv_icon.jpg",0.25f), BorderLayout.EAST);
        columnaCentral.add(Imatge("sources/urv_icon.jpg", 0.25f), BorderLayout.NORTH);
        columnaDreta.add(Imatge("sources/urv_icon.jpg",0.25f), BorderLayout.WEST);

        mainWinow.setVisible(true);
    }

    public static JLabel Imatge(String rutaImg, float scale)
    {
        ImageIcon icone = new ImageIcon(rutaImg);

        if (icone.getIconWidth() == -1)
        {
            System.out.println("No se ha trobat la imatge en la ruta: "+rutaImg);
            return new JLabel("Imatge no trobada");
        }
        else
        {
            if (scale == 0)
            {
                return new JLabel(icone);
            }
            else
            {
                Image imatgeReescalada = icone.getImage().getScaledInstance(Math.round(icone.getIconWidth()*scale), Math.round(icone.getIconHeight()*scale), Image.SCALE_SMOOTH);
                icone = new ImageIcon(imatgeReescalada);
                return new JLabel(icone);
            }
        }
    }
}