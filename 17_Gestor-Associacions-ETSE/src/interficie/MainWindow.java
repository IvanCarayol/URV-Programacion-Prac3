package interficie;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;

public class MainWindow
{
    private static Finestra mainWindow;
    private static JPanel barraSuperior;

    private static int[] numFila = new int[20];

    public static void iniciarFinestra()
    {
        mainWindow = new Finestra("Main", 500, 300);
        mainWindow.setLayout(null);
        mainWindow.setVisible(true);

        reiniciarNelementsContenidors();

        mainWindow.addComponentListener(new ComponentAdapter() 
        {
            public void componentResized(ComponentEvent e)
            {
                actualitzarFinestra();
            }  
        });
    }

    public static void actualitzarFinestra()
    {
        reiniciarNelementsContenidors();
        mainWindow.getContentPane().removeAll();
        finestraPrincipal();
        mainWindow.getContentPane().setBackground(Color.WHITE);
        mainWindow.revalidate();
        mainWindow.repaint();
    }

    private static void finestraPrincipal()
    {
        mainWindow.setMinimumSize(new Dimension(500, 198));
        mostrarBarraSuperior();

        JPanel body = new JPanel();
        body.setLayout(null);
        body.setBounds(0,barraSuperior.getHeight(), mainWindow.getWidth(), mainWindow.getHeight()-barraSuperior.getHeight());
        afegirElementFinestra(body, 1);


        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (int i = 0; i < 50; i++)
        {
            listModel.addElement("Elemento "+i);
        }

        JList<String> list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        body.add(scrollPane);
        scrollPane.setBounds(body.getWidth()/2, 30, 150, body.getHeight()-100);
    }

    private static void mostrarBarraSuperior()
    {
        barraSuperior = new JPanel();
        barraSuperior.setLayout(null);

        afegirElementFinestra(barraSuperior, 0);

        JLabel logo = imatge("sources/urv_icon.png", 0.25f, mainWindow.getWidth(), mainWindow.getHeight());
        barraSuperior.setBounds(0,0,mainWindow.getWidth()/numFila[0], (int)logo.getPreferredSize().getHeight());
        barraSuperior.setBackground(Color.WHITE);
        barraSuperior.add(logo);
        logo.setBounds(0,0,(int)logo.getPreferredSize().getWidth(), (int)logo.getPreferredSize().getHeight());
    }

    private static void afegirElementFinestra(JLabel element, int numContenidor)
    {
        mainWindow.add(element);
        numFila[numContenidor] ++;
    }

    private static void afegirElementFinestra(JPanel element, int numContenidor)
    {
        mainWindow.add(element);
        numFila[numContenidor] ++;
    }

    private static void reiniciarNelementsContenidors()
    {
        for (int i = 0; i < numFila.length; i++)
        {
            numFila[i] = 0;
        }
    }

    public static JLabel imatge(String rutaImg, float scale, int maxWidth, int maxHeight)
    {
        ImageIcon icone = new ImageIcon(rutaImg);

        if (icone.getIconWidth() == -1)
        {
            System.out.println("No se ha trobat la imatge en la ruta: "+rutaImg);
            return new JLabel("Imatge no trobada");
        }
        else
        {
            float aReescalarWidth = (float) maxWidth/icone.getIconWidth();
            float aReescalarHeight = (float) maxHeight/icone.getIconHeight();

            if (scale > aReescalarHeight) { scale = aReescalarHeight; } else if (scale > aReescalarWidth) { scale = aReescalarWidth; }

            Image imatgeReescalada = icone.getImage().getScaledInstance(Math.round(icone.getIconWidth()*scale), Math.round(icone.getIconHeight()*scale), Image.SCALE_SMOOTH);

            icone = new ImageIcon(imatgeReescalada);
            return new JLabel(icone);
        }
    }
}