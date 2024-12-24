package Objectes;
import java.io.Serializable;

public class Data implements Serializable{
    private int dia;
    private int mes;
    private int any;

    /**
     * Constructor que inicialitza una data amb els valors proporcionats.
     *
     * @param dia El dia de la data.
     * @param mes El mes de la data.
     * @param any L'any de la data.
     */
    public Data(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    /**
     * Obté el dia de la data.
     *
     * @return El dia de la data.
     */
    public int getDia() {
        return dia;
    }

    /**
     * Obté el mes de la data.
     *
     * @return El mes de la data.
     */
    public int getMes() {
        return mes;
    }

    /**
     * Obté l'any de la data.
     *
     * @return L'any de la data.
     */
    public int getAny() {
        return any;
    }

    /**
     * Estableix el dia de la data.
     *
     * @param dia El nou valor del dia.
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Estableix el mes de la data.
     *
     * @param mes El nou valor del mes.
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Estableix l'any de la data.
     *
     * @param any El nou valor de l'any.
     */
    public void setAny(int any) {
        this.any = any;
    }

    /**
     * Crea una còpia de l'objecte Data actual.
     *
     * @return Una nova instància de Data amb els mateixos valors.
     */
    public Data copia() {
        return (new Data(dia, mes, any));
    }

    /**
     * Compara dues dates i determina si la primera és posterior a la segona.
     *
     * @param data1 La primera data.
     * @param data2 La segona data.
     * @return {@code true} si data1 és posterior a data2, {@code false} en cas contrari.
     */
    public boolean compararDatas(Data data1, Data data2) {
        if (data1.getAny() > data2.getAny()) {
            return true;
        } else if (data1.getAny() == data2.getAny()) {
            if (data1.getMes() > data2.getMes()) {
                return true;
            } else if (data1.getMes() == data2.getMes()) {
                if (data1.getDia() > data2.getDia()) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return dia + "/" + mes + "/" + any;
    }
}
