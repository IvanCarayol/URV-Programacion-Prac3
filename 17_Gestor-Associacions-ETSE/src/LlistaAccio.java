public class LlistaAccio {
    private Accio[] listaAccions;  // Array para almacenar objetos de tipo Accio
    private int contador;          // Contador de elementos agregados

    // Constructor
    public LlistaAccio(int tamanio) {
        // Inicializamos el array con el tamaño especificado
        this.listaAccions = new Accio[tamanio];
        this.contador = 0;  // Al principio, no hay elementos agregados
    }

    // Método para agregar una acción a la lista
    public void afegirAccio(Accio accio) {
        
        // sera escalable ya que no se puede decir en un inicio cuantas habran
        if (contador < listaAccions.length) {
            listaAccions[contador] = accio;  
            contador++;
        } else {
            actualizarArray();
            listaAccions[contador] = accio;  
            contador++;
        }
    }

    // Método para obtener el contador de elementos
    public int getContador() {
        return contador;
    }

    public Accio getAccio(int index) {
        if (index >= 0 && index < contador) { // Verifica si el índice es válido
            return listaAccions[index];
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }
    }

    // Método para obtener el array completo de acciones
    public Accio[] getListaAccions() {
        return listaAccions;
    }

    public Accio getNAccions(int num) {
        return listaAccions[num];
    }

    // Método para mostrar la lista de acciones
    @Override
    public String toString() {
        String txt = "LlistaAccio{\n";
        for (int i = 0; i < contador; i++) {
            txt += listaAccions[i] + "\n";
        }
        txt += "}";
        return txt;
    }

    public LlistaAccio accioDeUnaAssociacio(Associacio asso) {

        LlistaAccio lacc = new LlistaAccio(contador);
        String nomAsso = asso.getNom();

        for(int i = 0; i < contador;i++) {
            
            LlistaAssociacio lassoc = listaAccions[i].getLlistaAssociacio();
            int h = lassoc.getNumelem();
            for(int j = 0; j < h;j++) {
                System.out.println("wdawdawdawda\n");
                if(lassoc.getAsociacioAt(j).getNom().equals(nomAsso)) {
                    lacc.afegirAccio(listaAccions[i]);
                }
            }
        }

        return lacc;
    }

    private void actualizarArray() {
        Accio[] lisAux = new Accio[contador+1];

        for(int i = 0; i < contador;i++) {
            lisAux[i] = listaAccions[i];
        }
        listaAccions = lisAux;
    }
}