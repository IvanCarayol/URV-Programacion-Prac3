package Objectes;
import java.io.Serializable;
import java.lang.reflect.Member;

public class LlistaMembres implements Serializable
{
    // Atributs
    private Membre[] tabla;
    private int numElem;

    /**
     * Constructor de la classe LlistaMembres
     * @param size  Tamany de la taula
     */
    public LlistaMembres(int size) 
    {
        this.tabla = new Membre[size];
        this.numElem = 0;
    }

    /**
     * Estableix el membre a una posició concreta de la taula
     * @param position  Index de la taula LlistaMembres
     * @param membre    Membre a introduir
     */
    public void setMembreAt(int position, Membre membre) 
    {
        if (position >= 0 && position < tabla.length) 
        {
            tabla[position] = membre;
            if (position >= numElem) 
            {
                numElem = position + 1; //Actualitza el número d'elements si es necesari
            }
        } 
    }

    /**
     * Retorna el membre de una posició concreta de la taula
     * @param position  Index de la taula
     *
     * @return  Membre en la posició indicada
     */
    public Membre getMembreAt(int position) 
    {
        if (position >= 0 && position < numElem) 
        {
            return tabla[position];
        } 
        else 
        {
            return null;
        }
    }

    /**
     * Retorna el membre de la taula amb el nom indicat per parametre 
     * @param nom  Nom del membre
     *
     * @return  Membre amb el nom
     */
    public Membre getMembreAmbNom(String nom)
    {
        boolean noTrobat = true;
        Membre membre = null;

        for (int i = 0; i < tabla.length && noTrobat; i++)
        {
            if (tabla[i].getAlias().equals(nom))
            {
                membre = tabla[i];
                noTrobat = false;
            }
        }

        return membre;
    }

    /**
     * Retorna el numero de membres a la taula
     * @return  nombre de membres
     */
    public int getNumelem() 
    {
        return numElem;
    }

    /**
     * Retorna el numero de màxim membres a la taula
     * @return  nombre num màxim membres
     */
    public int getMaxLength()
    {
        return tabla.length;
    }

    /**
     * Elimina el membre en la posició indicada
     * @param position  Index de la posició de la taula
     */
    public void eliminarMembreAt(int position) {
        if (position >= 0 && position < numElem) 
        {  
            //Desplaçar els elements per omplir el buit
            for (int i = position; i < numElem - 1; i++) 
            {
                tabla[i] = tabla[i + 1];    //Moure el segugüent element a la posició actual
            }

            tabla[numElem - 1] = null;  //Buidar la última posició
            numElem--;  //Decrementar el numero d'elements
        } 
    }

    /**
     * Afegeix un membre a la taula
     * @param membre    Membre a afegir
     */
    public void afegirMembre(Membre membre) 
    {
        boolean noExisteix = true;

        for (int i = 0; i < numElem && noExisteix; i++)
        {
            if (membre.getAlias().equals(tabla[i].getAlias()))
            {
                noExisteix = false;
            }
        }

        if (noExisteix)
        {
            if (numElem < tabla.length) 
            {
                tabla[numElem] = membre;
                numElem++;
            }
        }
    }

    // Método toString para mostrar toda la tabla temporal 
    @Override
    public String toString() 
    {
        String text = "Llista de Membres:\n";

        for (int i = 0; i < numElem; i++) 
        {
            text+="Membre "+i+": "+tabla[i].toString()+"\n";
        }
        return text;
    }
}