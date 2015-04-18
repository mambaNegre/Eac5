
package EAC5.interficie;

import EAC5.utilitats.*;
import java.util.ArrayList;
import EAC5.concursants.*;

/**
 *
 * @author Bea
 */

public class Pantallas {
    UtilitatsString utilitatsString = new UtilitatsString();
    UtilitatsMenu utilitatsMenu = new UtilitatsMenu();
    classeLlistaConcursants objecteLlista = new classeLlistaConcursants();

    ArrayList<ArrayList<String>> llista;

    /**
     *
     */
    
    public void metodeMisatgeBenvinguda() {

        System.out.println("/nBenvingut al programa per gestionar concursants"
                + " per al programa de radio 'NOMBRE'");
        System.out.println(utilitatsString.repetirChar("=", 80));
        System.out.println(utilitatsString.repetirChar("=", 80));
        
    }
}
