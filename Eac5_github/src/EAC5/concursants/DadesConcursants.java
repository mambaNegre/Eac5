package EAC5.concursants;

import EAC5.utilitats.*;

/**
 *
 * @author joan
 */
public class DadesConcursants {

    UtilitatsString utilString = new UtilitatsString();
    Validacions validacio = new Validacions();

    /**
     * Mètode per escriure el dni i comprovar-lo
     *
     * @return dni
     */
    public String escriureDni() {
        
        String DNI;
        boolean cert = false;

        //classeUtilitats utilString = new classeUtilitats();
        do {

            DNI = utilString.demanarString("\nEscriu el DNI: ");
            cert = validacio.verificarDNI(DNI);
            
            if (!cert) {
                System.out.println("\n\t¡DNI incorrecte!");
            }
        
        } while (!cert);

        return DNI;
    }

    /**
     * Mètode per escriure nom
     *
     * @return nom
     */
    public String escriureNom() {

        String nom;
        boolean cert = false;
        
        do {

            nom = utilString.demanarString("\nEscriu el NOM: ");
            cert = validacio.verificarNoBuit(nom);
            
            if (!cert) {
                System.out.println("\n\t¡No has escrit cap NOM!");
            }
        
        } while (!cert);

        return nom;

    }

    /**
     * Mètode per escriure cognoms
     *
     * @return cognoms
     */
    public String escriureCognoms() {

        String cognoms;
        boolean cert = false;

        do {

            cognoms = utilString.demanarString("\nEscriu els COGNOMS: ");
            cert = validacio.verificarNoBuit(cognoms);
            
            if (!cert) {
                System.out.println("\n\t¡No has escrit cap COGNOM!");
            }
        
        } while (!cert);

        return cognoms;
    }

    /**
     * Mètode per escriure els telèfon i comprovar-lo
     *
     * @return telefon
     */
    public String escriureTelefon() {

        String telefon;
        boolean cert = false;

        do {

            telefon = utilString.demanarString("\nEscriu el TELÈFON: ");
            cert = validacio.verificarTelefon(telefon);
            
            if (!cert) {
                System.out.println("\n\t¡TELEFON incorrecte!");
            }

        } while (!cert);

        return telefon;

    }

}