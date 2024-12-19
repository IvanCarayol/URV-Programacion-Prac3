import java.io.Serializable;

public class LlistaTitulacions implements Serializable{

    // Atributos
    private Titulacio[] tabla;
    private int numelem;

    // Constructor para inicializar la tabla
    public LlistaTitulacions(int size) {
        this.tabla = new Titulacio[size];
        this.numelem = 0;  // Al principio, no hay elementos en la tabla
    }

    // Setter para una posición concreta de la tabla
    public void setTitulacioAt(int position, Titulacio titulacio) {
        if (position >= 0 && position < tabla.length) {
            tabla[position] = titulacio;
            if (position >= numelem) {
                numelem = position + 1;  // Actualiza el número de elementos si es necesario
            }
        } else {
            System.out.println("Posición fuera de los límites.");
        }
    }

    // Getter para una posición concreta de la tabla
    public Titulacio getTitulacioAt(int position) {
        if (position >= 0 && position < numelem) {
            return tabla[position];
        } else {
            System.out.println("Posición fuera de los límites.");
            return null;
        }
    }

    // Método toString para mostrar toda la tabla temporal
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Titulaciones:\n");
        for (int i = 0; i < numelem; i++) {
            sb.append("Titulacio ").append(i + 1).append(": ").append(tabla[i].toString()).append("\n");
        }
        return sb.toString();
    }

    // Getter para el número de elementos (numelem)
    public int getNumelem() {
        return numelem;
    }

    // Función para eliminar un elemento en una posición específica
    public void eliminarTitulacioAt(int position) {
        if (position >= 0 && position < numelem) {
            // Desplazar los elementos para cubrir el hueco
            for (int i = position; i < numelem - 1; i++) {
                tabla[i] = tabla[i + 1]; // Mover el siguiente elemento a la posición actual
            }
            tabla[numelem - 1] = null; // Limpiar la última posición
            numelem--; // Reducir el número de elementos
        } else {
            System.out.println("Posición fuera de los límites.");
        }
    }

    // Función para añadir un elemento en la siguiente posición libre
    public void afegirTitulacio(Titulacio titulacio) {
        if (numelem < tabla.length) {
            tabla[numelem] = titulacio;
            numelem++;
        } else {
            System.out.println("No hay espacio disponible en la tabla.");
        }
    }

    public boolean estaTitulacio(String tit) {

        for (int i = 0; i < numelem; i++) {
            
            if(tit.equals(tabla[i].getNom())) {
                return true;
            }

        }
        return false;
    }
}

