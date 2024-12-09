public class tests {
    public static void main(String[] args) {

        Data datIni = new Data(25, 11, 2023);
        Data dat = new Data(2, 2, 2024);

        
        // Prueba de Membre
        Membre ivan = new Membre("Ivan", datIni, null, null, null);

        // pruebas de accio
        Accio acccio1 = new Accio("Arquitectura", "Para todos", ivan, 0, dat);

        System.out.println(acccio1);
    }
}
