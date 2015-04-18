package EAC5.utilitats;

import java.util.Scanner;

public class UtilitatsString {
    
    /**
     * El mètode demanarString demana a l'usuari que introdueixi una cadena de
     * text.
     * @param titol Pregunta que se li fa a l'usuari per dir-li què s'espera que
     * faci.
     * @return La cadena de text introduïda per l'usuari.
     */
    public String demanarString(String titol) {
        String res;
        
        Scanner S = new Scanner(System.in);

        System.out.print(titol);
        res = S.nextLine();
        
        return res;
    }
    
    /**
     * El mètode repetirChar imprimeix tantes vegades com s'indique un caràcter
     * específic.
     * @param str És la cadena de text que s'ha de repetir.
     * @param vegades És el número de vegades que es vol repetir la cadena
     * introduida.
     * @return La cadena de text resultant de repetir el caràcter de entrada les
     * vegades que s'indiqui.
     */
    public static String repetirChar(String str, int vegades) {
        String res = str;
        for (int i=1; i<vegades; i++) {
            res += str;
        }
        return res;
    }
    
    /**
     * El mètode formatCadena permet definir una llargària màxima per a una
     * cadena de text. Si la cadena té més caràcters del màxim, es retallarà
     * perquè es pugui imprimir per pantalla correctament. De la mateixa manera,
     * si es massa curta es pot definir un caràcter de farciment perquè ocupi
     * tota l'amplada esperada.
     * @param str És la cadena de text que caldrà adaptar, retallant-la o
     * afegint-hi caràcters de farciment.
     * @param maxChars És el número màxim de caràcters que ha d'ocupar la cadena
     * de text quan s'imprimeix per pantalla.
     * @param farciment És el caràcter de farciment definit per l'usuari
     * @param costat Un número negatiu indica que el farciment s'aplica a
     * l'esquera de la cadena. Per contra, un número major o igual a 0 aplicarà
     * el farciment a la dreta.
     * @return La cadena de text resultant un cop aplicat el format especificat
     * als paràmetres d'entrada del mètode.
     */
    public static String formatCadena(String str, int maxChars, char farciment, int costat) {
        String res;
        if ( str.length() > maxChars ) {
            res = str.substring(0, maxChars-3) + "...";
        }
        else {
            String farc =  "";
            for (int i=str.length(); i<maxChars; i++) {
                farc += String.valueOf(farciment);
            }
            
            if ( costat < 0 ) {
                res = farc + str;
            }
            else {
                res = str + farc;
            }
        }
        return res;
    }
}