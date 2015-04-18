package EAC5.utilitats;

import EAC5.utilitats.UtilitatsString;
import java.util.Scanner;
/**
 *
 * @author moledov
 */
public class UtilitatsMenu {
    
    /**
     * La funció triarOpcio permet demanar un enter a l'usuari i retornar
     * l'elecció que hagi fet aquest.
     * @param str És el text que es vol mostrar perquè l'usuari entri dades.
     * @param min És el valor mínim permés.
     * @param max És el valor màxim permés.
     * @return El valor enter que hagi introduït l'usuari.
     */
    public static int triarOpcio(String str, int min, int max) {
        Scanner sc = new Scanner(System.in);
        boolean demanarOpcio = true;
        int res = 0;
        
        while ( demanarOpcio ) {
            System.out.println(str);
            if ( sc.hasNextInt() ) {
                res = sc.nextInt();
                
                if ( res >= min && res <= max ) {
                    demanarOpcio = false;
                }
            }
            sc.nextLine();
        }
        return res;
    }
    
    /**
     * La funció imprimirMenu permet definir el títol del menú al qual es troba
     * l'usuari, així com mostrar les diferents opcions disponibles. Finalment
     * es crida el mètode triarOpcio perquè l'usuari seleccioni l'acció adient.
     * @param titol Mostra a l'usuari en què menú es troba.
     * @param opcions És un array que conté les opcions disponibles del menú.
     * @return El valor enter corresponent a l'opció triada per l'usuari.
     */
    public static int imprimirMenu(String titol, String[] opcions) {
        UtilitatsString.repetirChar("#", 25);
        System.out.println(titol);
        UtilitatsString.repetirChar("#", 25);
        for (int i=0; i<opcions.length; i++) {
            System.out.println((i+1) + ") " + opcions[i]);
        }
        int opcio = triarOpcio("Tria una opció: ", 1, opcions.length);
        return opcio;
    }
}