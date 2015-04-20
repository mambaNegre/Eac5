package EAC5;

import EAC5.interficie.*;
import java.util.ArrayList;

/**
 *
 * @author Bea, Roberto i Joan
 */

public class Concurs {

    public static ArrayList<ArrayList<String>> llista;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //INSTÀNCIES (OBJECTES)
        Pantallas pantalla = new Pantallas();
        Menus menu = new Menus();
        
        //INVOCACIÓ MÈTODES
        pantalla.missatgeBenvinguda();
        menu.seleccioGestio();
        
    }
}
