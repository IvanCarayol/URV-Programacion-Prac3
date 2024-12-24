package Objectes;
import java.io.Serializable;

public class LlistaAssociacio implements Serializable{

    // Atributos
    private Associacio[] tabla;
    private int numelem;

    // Constructor para inicializar la tabla
    public LlistaAssociacio(int size) {
        this.tabla = new Associacio[size];
        this.numelem = 0;  // Al principio, no hay elementos en la tabla
    }

    // Setter para una posición concreta de la tabla
    public void setAsociacioAt(int position, Associacio asociacio) {
        if (position >= 0 && position < tabla.length) {
            tabla[position] = asociacio;
            if (position >= numelem) {
                numelem++;  // Actualiza el número de elementos si es necesario
            }
        } else {
            System.out.println("Posición fuera de los límites.");
        }
    }

    // Getter para una posición concreta de la tabla
    public Associacio getAsociacioAt(int position) {
        if (position >= 0 && position < numelem) {
            return tabla[position];
        } else {
            System.out.println("Posición fuera de los límites.");
            return null;
        }
    }

    public Associacio getAssociacioAmbNom(String nom)
    {
        boolean noTrobat = true;
        Associacio associacio = null;

        for (int  i = 0; i < numelem && noTrobat; i++)
        {
            if(tabla[i].getNom().equals(nom))
            {
                associacio = tabla[i];
                noTrobat = false;
            }
        }
        return associacio;
    }

    // Función para eliminar un elemento en una posición específica
    public void eliminarAsociacioAt(int position) {
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
    public void afegirAsociacio(Associacio asociacio) {
        if (numelem < tabla.length) {
            tabla[numelem] = asociacio;
            numelem++;
        } else {
            System.out.println("No hay espacio disponible en la tabla.");
        }
    }

    // Método toString para mostrar toda la tabla temporal
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Asociaciones:\n");
        for (int i = 0; i < numelem; i++) {
            sb.append("Asociacio ").append(i + 1).append(": ").append(tabla[i].toString()).append("\n");
        }
        return sb.toString();
    }

    // Getter para el número de elementos (numelem)
    public int getNumelem() {
        return numelem;
    }
}

