import javax.swing.*;

public class Finestra extends JFrame
{
    private static final long serialVersionUID= 1L;
    
    public Finestra(String titol, int width, int height)
    {
        super(titol);
        this.setLocation(100, 200);
        this.setSize(width,height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}