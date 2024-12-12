public class Timer 
{
    private static javax.swing.Timer timer;
    
    public static void ActualizarAfrecuencia(int frecuencia)
    {
        if (timer != null)
        {
            timer.stop();
        }

        timer = new javax.swing.Timer(frecuencia, e -> MainWindow.ActualitzarFinestra());
        timer.start();
    }
}
