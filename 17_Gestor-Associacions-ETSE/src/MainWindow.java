import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.*;

public class MainWindow
{
    private static JPanel columnaEsquerra;
    private static JPanel columnaDreta;
    private static JPanel columnaCentral;
    private static Finestra mainWindow;
    
    private static int numElem;

    public static void IniciarFinestra()
    {
        mainWindow = new Finestra("Main", 500, 300);
        mainWindow.setLayout(null);
        mainWindow.setVisible(true);
        numElem = 0;
    }

    public static void ActualitzarFinestra()
    {
        numElem = 0;
        mainWindow.getContentPane().removeAll();
        columnaEsquerra = new JPanel();
        columnaDreta = new JPanel();
        columnaCentral = new JPanel();

        columnaEsquerra.setLayout(new BorderLayout());
        columnaCentral.setLayout(null);
        columnaDreta.setLayout(new BorderLayout());

        AfegirElementFinestra(columnaEsquerra);
        AfegirElementFinestra(columnaCentral);
        AfegirElementFinestra(columnaDreta);

        columnaCentral.setBounds((mainWindow.getWidth()/numElem),0,mainWindow.getWidth()/numElem, mainWindow.getHeight());

        JLabel dimensions = new JLabel("Widht: "+mainWindow.getWidth()+" Heigh: "+mainWindow.getHeight());
        columnaCentral.add(dimensions);
        dimensions.setBounds((columnaCentral.getWidth()/2)-100,0,200,50);
        
        mainWindow.revalidate();
        mainWindow.repaint();
    }

    private static void AfegirElementFinestra(JLabel element)
    {
        mainWindow.add(element);
        numElem ++;
    }

    private static void AfegirElementFinestra(JPanel element)
    {
        mainWindow.add(element);
        numElem ++;
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