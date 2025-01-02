package Objectes;

public class LlistaAccio {
    private Accio[] listaAccions;  // Array para almacenar objetos de tipo Accio
    private int contador;          // Contador de elementos agregados

    // Constructor
    public LlistaAccio(int tamanio) {
        // Inicializamos el array con el tamaño especificado
        this.listaAccions = new Accio[tamanio];
        this.contador = 0;  // Al principio, no hay elementos agregados
    }

    /**
     * Método para agregar una acción a la lista
     * @param accio
     */
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

    /**
     * Retorna una llista d'accions que contenen una associacio concreta
     * @param asso
     * @return LlistaAccio
     */
    public LlistaAccio accioDeUnaAssociacio(Associacio asso) {

        LlistaAccio lacc = new LlistaAccio(contador);
        String nomAsso = asso.getNom();

        for(int i = 0; i < contador;i++) {
            
            LlistaAssociacio lassoc = listaAccions[i].getLlistaAssociacio();
            Associacio asA = lassoc.getAssociacioAmbNom(nomAsso);
                
            if(asA != null) {
                lacc.afegirAccio(listaAccions[i]);
            }
            
        }

        return lacc;
    }

    /**
     * Aumenta la llista
     */
    private void actualizarArray() {
        Accio[] lisAux = new Accio[contador+1];

        for(int i = 0; i < contador;i++) {
            lisAux[i] = listaAccions[i];
        }
        listaAccions = lisAux;
    }

    public LlistaAccio llistarEnFranja(Data inici, Data fi) {
        // Array temporal para almacenar las xerrades filtradas
        LlistaAccio validas = new LlistaAccio(contador);

        for (int i = 0; i < contador; i++) {

            if (listaAccions[i] instanceof Xerrades) {

                Data dataXerrada = listaAccions[i].getData();
                if (inici.compararDatas(dataXerrada, inici) && dataXerrada.compararDatas(fi, dataXerrada)){
                    validas.afegirAccio(listaAccions[i]);
                }
            }
        }

        return validas;
    }

    public LlistaAccio xerradesMesAssisten(int num) {
        
        LlistaAccio lxer = new LlistaAccio(contador);

        for(int i = 0; i < contador;i++) {
            if (listaAccions[i] instanceof Xerrades) {
                Xerrades xerrada = (Xerrades)listaAccions[i];
                if (xerrada.getnumMembres() == num) {
                    lxer.afegirAccio(xerrada);
                }
            }

        }

        return lxer;

    }
}