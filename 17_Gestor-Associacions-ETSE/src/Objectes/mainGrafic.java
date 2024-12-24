package Objectes;
import java.io.File;

import interficie.*;

public class mainGrafic 
{
    public static void main(String[] args)
    {
        LlistaAssociacio llistaAssociacions;
        LlistaMembres llistaMembres;
        LlistaTitulacions llistaTitulacions;

        llistaTitulacions = Dades.carregaTitulacions();
        llistaAssociacions = Dades.carregaAssociacions();
        llistaMembres = Dades.llegirMembres(llistaAssociacions, llistaTitulacions);

        MainWindow.iniciarFinestra();
    }    
}
