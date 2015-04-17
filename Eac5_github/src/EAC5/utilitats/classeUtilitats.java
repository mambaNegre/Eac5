package EAC5.utilitats;

import java.util.Scanner;

public class classeUtilitats {

    /**
     *
     * @param cadena
     * @return
     */
    public String metodeEscriureString(String cadena) {
        String valor;

        Scanner S = new Scanner(System.in);

        System.out.print(cadena);
        valor = S.nextLine();

        return valor;
    }

    
    /**
     * La funció verificarNoBuit permet comprovar que l'usuari no hagi introduït
     * una cadena de text buida, sense dades.
     *
     * @param cadena És el text que es vol validar.
     * @return True si la cadena passada és vàlida (no buida) o false si no és
     * vàlida.
     */
    public boolean metodeVerificarNoBuit(String cadena) {
        boolean valor;
        // Eliminem els espais en blanc de la cadena
        cadena = cadena.trim();

        // Si la cadena, sense espais, té una llargària de 0, no és vàlida
        if (cadena.length() == 0) {
            valor = false;
            return valor;

        } // Si la cadena no és buida, la considerem vàlida
        else {
            valor = true;
            return true;
        }
    }

    
    /**
     * La funció verificarDNI permet comprovar la validesa del DNI introduït per
     * l'usuari.
     *
     * @param dni Cadena de text amb el valor del DNI a validar.
     * @return True si el DNI és correcte o false si no ho és.
     */
    public boolean metodeVerificarDNI(String dni) {
        boolean valor = false;

        String LLETRES_VALIDES_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

        //Aquesta variable contindrà el valor numèric del DNI
        String valorNumeric = "";

        // Si el DNI té 9 caràcters és possible que sigui vàlid
        // però s'han de fer les comprovacions neccessàries
        if (dni.length() == 9) {
            //Es fa un recorregut pels 8 primers caràcters per comprovar que són números
            for (int i = 0; i < 8; i++) {
                // Si als primers 8 caràcters no hi ha un número, no és un DNI vàlid
                if (dni.charAt(i) < '0' || dni.charAt(i) > '9') {
                    System.out.print("El DNI no és vàlid. ");
                    valor = false;
                    return valor;
                } // Si el caràcter comprovat és un número, es desa a la variable valorNumeric
                else {
                    valorNumeric += dni.charAt(i);
                }
            }
            // Es converteix la part numèrica a int
            int numero = Integer.parseInt(valorNumeric);
            // S'obté la lletra del DNI comprovat, convertint-la a majúscula
            char lletra = Character.toUpperCase(dni.charAt(8));

            // Si tant el número com la lletra introduïts són correctes, retornar true
            if (LLETRES_VALIDES_DNI.charAt(numero % 23) == lletra) {
                System.out.print("\n\tEl DNI és vàlid");
                valor = true;
                return valor;
            }

        } else {
            // Si el DNI no té 9 caràcters no és vàlid
            System.out.print("El DNI ha de tenir 9 caràcters. ");
            valor = false;
            return valor;
        }
        return valor;
    }

    
    /**
     * La funció verificarTelefon comprova que la validesa del número de telèfon
     * introduït per l'usuari.
     *
     * @param telefon Cadena de text amb el valor del número de telèfon a
     * validar.
     * @return True si el telèfon és vàlid o false si no ho és.
     */
    public boolean metodeVerificarTelefon(String telefon) {

        String VALORS_VALIDS_TELEFON = "0123456789-. ";
        boolean valor;

        //La variable acum contarà quants números té el telèfon a comprovar
        int acum = 0;

        //Es fa un recorregut per tots el caràcters que composen el número de telèfon
        for (int i = 0; i < telefon.length(); i++) {
            char digit = telefon.charAt(i);

            //Es comprova que es tracta d'un caràcter vàlid (és un número o un separador admés)
            if (VALORS_VALIDS_TELEFON.indexOf(digit) != -1) {
                //Si el caràcter és un número, s'incrementa la variable acum
                if (digit >= '0' && digit <= '9') {
                    acum++;
                }
            } //Si el caràcter no és vàlid, el telèfon tampoc ho serà
            else {
                valor = false;
                return valor;
            }
        }
        //Si el telèfon consta de 9 xifres, serà vàlid
        if (acum == 9) {
            valor = true;
            return valor;

        } else {
            valor = false;
            return valor;
        }
    }
    
    /**
     * La funció triarOpcio permet demanar un enter a l'usuari i retornar
     * l'elecció que hagi fet aquest.
     * @param str És el text que es vol mostrar perquè l'usuari entri dades.
     * @param min És el valor mínim permés.
     * @param max És el valor màxim permés.
     * @return El valor enter que hagi introduït l'usuari.
     */
    public int metodeTriarOpcio(String str, int min, int max) {
        Scanner sc = new Scanner(System.in);
        boolean demanarOpcio = true;
        int res = 0;
        
        while ( demanarOpcio ) {
            System.out.print(str);
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
     * El mètode repetirChar imprimeix tantes vegades com s'indique un caràcter
     * específic.
     * @param str És la cadena de text que s'ha de repetir.
     * @param vegades És el número de vegades que es vol repetir la cadena
     * introduida.
     * @return La cadena de text resultant de repetir el caràcter de entrada les
     * vegades que s'indiqui.
     */
    public String metodeRepetirChar(String str, int vegades) {
        String res = str;
        for (int i=1; i<vegades; i++) {
            res += str;
        }
        return res;
    }

}
