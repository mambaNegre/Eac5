package EAC5;

import EAC5.interficie.*;
import java.util.ArrayList;

/**
 *
 * @author Bea, Roberto i Joan
 */

public class classePrincipal {

    public static ArrayList<ArrayList<String>> llista;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //INSTÀNCIES (OBJECTES)
        Pantallas objectePantalla = new Pantallas();
        classeMenus objecteMenu = new classeMenus();
        
        //INVOCACIÓ MÈTODES
        objectePantalla.metodeMisatgeBenvinguda();
        objecteMenu.metodeSeleccioGestio();
        
    }
}
