import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.*;

public class MainWindow
{
    public static void IniciarFinestra()
    {
        Finestra mainWinow = new Finestra("Main", 500, 300);
        mainWinow.setLayout(new FlowLayout());

        mainWinow.add(Imatge("sources/urv_icon.jpg",0.25f));

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