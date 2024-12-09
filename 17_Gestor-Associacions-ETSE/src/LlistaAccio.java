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
        
        if (contador < listaAccions.length) {
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

    // Método para mostrar la lista de acciones
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LlistaAccio{\n");
        for (int i = 0; i < contador; i++) {
            sb.append(listaAccions[i].toString()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}