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

    /**
     * Llista les accions en una franja de temps determinada.
     * 
     * @param inici La data d'inici de la franja.
     * @param fi La data de finalització de la franja.
     * @return Una LlistaAccio amb les xerrades dins de la franja especificada.
     */
    public LlistaAccio llistarEnFranja(Data inici, Data fi) {
        // Array temporal per emmagatzemar les xerrades filtrades
        LlistaAccio validas = new LlistaAccio(contador);

        for (int i = 0; i < contador; i++) {

            if (listaAccions[i] instanceof Xerrades) {
                Data dataXerrada = listaAccions[i].getData();
                Boolean iniciComparacio = Data.compararDatas(dataXerrada, inici);
                Boolean fiComparacio = Data.compararDatas(fi, dataXerrada);
                if (( iniciComparacio == null || iniciComparacio) && (fiComparacio == null || !fiComparacio)) {
                    validas.afegirAccio(listaAccions[i]);
                }
            }
        }

        return validas;
    }

    /**
     * Retorna la xerrada amb millor valoració.
     * 
     * @return La xerrada millor valorada. Retorna null si no hi ha xerrades.
     */
    public Xerrades getXerradaMejorValorada() { 
        if (contador == 0) { 
            return null; // Cas que no hi hagin xerrades
        } 

        double mejorValoracionPromedio = 0;
        Xerrades mejorValorada = null;

        int y = 0;
        while (!(listaAccions[y] instanceof Xerrades) && y < contador){
            y++;
        }

        if (y == contador){
            return null;
        }

        mejorValorada = (Xerrades) listaAccions[y];
        mejorValoracionPromedio = calcularValoracionPromedio(mejorValorada);

        for (int i = y + 1; i < contador; i++) { 
            if (listaAccions[i] instanceof Xerrades){
                Xerrades valorar = (Xerrades) listaAccions[i];
                double valoracionPromedio = calcularValoracionPromedio(valorar);
                if (valoracionPromedio > mejorValoracionPromedio) { 
                    mejorValorada =  valorar; 
                    mejorValoracionPromedio = valoracionPromedio; 
                } else if (valoracionPromedio == mejorValoracionPromedio){
                    if(valorar.getNumValoracions() >  mejorValorada.getNumValoracions()){
                        mejorValorada =  valorar; 
                        mejorValoracionPromedio = valoracionPromedio; 
                    }
                }
            }           
        } 
        return mejorValorada;
    }


    /** 
     * Calcula la valoración promedio de una xerrada. 
     * @param xerrada La xerrada para la que se va a calcular la valoración promedio. 
     * @return La valoración promedio. */ 
    private double calcularValoracionPromedio(Xerrades xerrada) {
        
        double sumaValoraciones = 0;
        int numValoraciones = xerrada.getNumValoracions();  //Numero total de valoracions d'una xerrada
        
        if (numValoraciones == 0){
            return 0;
        }

        for (int i = 0; i < numValoraciones; i++) {
            sumaValoraciones += xerrada.getValoracioIndex(i).getValoracio();
        }

        return sumaValoraciones/numValoraciones;
    } 

    /** 
     * Llista les xerrades amb un nombre específic de membres assistents.
     * 
     * @param num El nombre de membres assistents. 
     * @return Una LlistaAccio amb les xerrades que tenen el nombre especificat de membres assistents. 
     */
    public LlistaAccio xerradesMesAssisten(int num) {
        
        LlistaAccio lxer = new LlistaAccio(contador);

        for(int i = 0; i < contador;i++) {
            if (listaAccions[i] instanceof Xerrades) {
                Xerrades xerrada = (Xerrades)listaAccions[i];
                if (xerrada.getnumMembres() > num) {
                    lxer.afegirAccio(xerrada);
                }
            }

        }

        return lxer;
    }

    public String toStringAmbOpcions(int opcio) {

        String text = "";

        switch (opcio) {
            case 1:
            text = toString();
                break;
        
            case 2:
                
                text = "LlistaXerrades{\n";
                for (int i = 0; i < contador; i++) {
                    if(listaAccions[i] instanceof Xerrades) text += listaAccions[i] + "\n";
                }
                text += "}";

                break;

            case 3:
                text = "LlistaDemostracions{\n";
                for (int i = 0; i < contador; i++) {
                    if(listaAccions[i] instanceof Demostracio) text += listaAccions[i] + "\n";
                }
                text += "}";
                break;
        }

        return text;

    }
    
    /**
     * Retorna un array de demostracions vàlides.
     * 
     * @return Un array de Demostracio amb les demostracions vàlides. 
     */
    public Demostracio[] demostracionsValides(){
        Demostracio[] demostracionsResultants = new Demostracio[contador];
        int y = 0;
        for (int i = 0; i < contador; i++) { 
            if (listaAccions[i] instanceof Demostracio){
                Demostracio comprobar = (Demostracio) listaAccions[i];
                if (comprobar.getValida()){
                    demostracionsResultants[y] = comprobar;
                    y++;
                }
            }           
        }
        return demostracionsResultants;
    } 

    /**
     * Retorna un array de demostracions per a una associació específica.
     * 
     * @param nomAssociacio El nom de l'associació.
     * @param demostracions Un array de demostracions.
     * @return Un array de Demostracio amb les demostracions per a l'associació especificada.
     */
    public Demostracio[] demostracionsPerAssociacio (String nomAssociacio, Demostracio[] demostracions){
        Demostracio[] resultants = new Demostracio[demostracions.length];
        int j = 0;
        for (int i = 0; i < demostracions.length; i++){
            if (demostracions[i] != null){
                LlistaAssociacio associacioNoms = demostracions[i].getLlistaAssociacio();
                if (associacioNoms != null){
                    for (int y = 0; y < associacioNoms.getNumelem(); y++){
                        if(associacioNoms.getAsociacioAt(y).getNom().equals(nomAssociacio)){
                            resultants[j] = demostracions[i];
                            j++;
                            break;
                        }
                    }
                }
            }
            
        }
        return resultants;
    }
}
