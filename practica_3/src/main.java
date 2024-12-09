public class main {
    public static void main(String[] args) {

        Data datIni = new Data(25, 11, 2023);


        // Prueba de Membre
        Membre ivan = new Membre("Ivan", datIni, null, null, null);

        // pruebas de accio
        Accio acccio1 = new Accio("Arquitectura", "Para todos", null, 0, null);

        System.out.println(acccio1);
    }
}
