package EAC5.utilitats;
import java.util.ArrayList;

/**
 *
 * @author moledov
 */
public class Validacions {
    public final static String LLETRES_VALIDES_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
    public final static String VALORS_VALIDS_TELEFON = "0123456789-. ";
    
    public final static int DNI = 0;
    public final static int NOM = 1;
    public final static int COGNOMS = 2;
    public final static int TELEFON = 3;

    
    /**
     * La funció verificarDNI permet comprovar la validesa del DNI introduït
     * per l'usuari.
     * @param dni Cadena de text amb el valor del DNI a validar.
     * @return True si el DNI és correcte o false si no ho és.
     */
    public boolean verificarDNI(String dni) {
        //Aquesta variable contindrà el valor numèric del DNI
        String valorNumeric = "";
        
        // Si el DNI té 9 caràcters és possible que sigui vàlid
        // però s'han de fer les comprovacions neccessàries
        if ( dni.length() == 9 ) {
            //Es fa un recorregut pels 8 primers caràcters per comprovar que són números
            for (int i = 0; i<8; i++) {
                // Si als primers 8 caràcters no hi ha un número, no és un DNI vàlid
                if ( dni.charAt(i) < '0' || dni.charAt(i) > '9') {
                    return false;
                }
                // Si el caràcter comprovat és un número, es desa a la variable valorNumeric
                else {
                    valorNumeric += dni.charAt(i);
                }
            }
            // Es converteix la part numèrica a int
            int numero = Integer.parseInt(valorNumeric);
            // S'obté la lletra del DNI comprovat, convertint-la a majúscula
            char lletra = Character.toUpperCase(dni.charAt(8));
            
            // Si tant el número com la lletra introduïts són correctes, retornar true
            if ( LLETRES_VALIDES_DNI.charAt(numero%23) == lletra ) {
                return true;
            }
        }
        // Si el DNI no té 9 caràcters no és vàlid
        return false;
    }
    
    /**
     * La funció DNIEsUnic comprova que el DNI d'un concursant no està assignat
     * a cap altre concursant que s'hagi donat d'alta.
     * @param concursants La matriu de concursants que participen al concurs.
     * @param dni El DNI que volem comprovar com a únic.     
     * @return True si el DNI és únic, false si el DNI ja ha estat assignat a
     * altre concursant.
     */
    public boolean DNIEsUnic(ArrayList<ArrayList<String>> concursants, String dni) {
        // Es fa un recorregut per tots els concursants
        for ( int i=0; i<concursants.size(); i++) {
            // Si el dni comprovat és igual al d'algun altre concursant, es
            // retorna false
            if ( dni.equals(concursants.get(i).get(DNI)) ) {
                return false;
            }
        }
        // Si s'acaba el bucle for és perquè tots els DNIs són únics, es
        // retorna true
        return true;
    }
    
    /**
     * La funció verificarTelefon comprova que la validesa del número de telèfon
     * introduït per l'usuari.
     * @param telefon Cadena de text amb el valor del número de telèfon a
     * validar.
     * @return True si el telèfon és vàlid o false si no ho és.
     */
    public boolean verificarTelefon(String telefon) {
        //La variable acum contarà quants números té el telèfon a comprovar
        int acum = 0;
        
        //Es fa un recorregut per tots el caràcters que composen el número de telèfon
        for (int i = 0; i<telefon.length(); i++ ) {
            char digit = telefon.charAt(i);
            
            //Es comprova que es tracta d'un caràcter vàlid (és un número o un separador admés)
            if ( VALORS_VALIDS_TELEFON.indexOf(digit) != -1 ) {
                //Si el caràcter és un número, s'incrementa la variable acum
                if ( digit >= '0' && digit <= '9' ) {
                    acum++;
                }
            }
            //Si el caràcter no és vàlid, el telèfon tampoc ho serà
            else {
                return false;
            }
        }
        //Si el telèfon consta de 9 xifres, serà vàlid
        if ( acum == 9 ) {
            return true;
        }
        return false;
    }
    
    /**
     * La funció verificarNoBuit permet comprovar que l'usuari no hagi introduït
     * una cadena de text buida, sense dades.
     * @param cadena És el text que es vol validar.
     * @return True si la cadena passada és vàlida (no buida) o false si no és
     * vàlida.
     */
    public boolean verificarNoBuit(String cadena) {
        // Eliminem els espais en blanc de la cadena
        cadena = cadena.trim();
        
        // Si la cadena, sense espais, té una llargària de 0, no és vàlida
        if ( cadena.length() == 0 ) {
            return false;
        }
        // Si la cadena no és buida, la considerem vàlida
        else {
            return true;
        }
    }
}