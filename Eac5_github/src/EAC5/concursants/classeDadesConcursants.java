package EAC5.concursants;

import EAC5.utilitats.*;

/**
 *
 * @author joan
 */
public class classeDadesConcursants {

    UtilitatsString utilString = new UtilitatsString();
    Validacions validacio = new Validacions();

    /**
     * Mètode per escriure el dni i comprovar-lo
     *
     * @return dni
     */
    public String metodeEscriureDni() {
        
        String DNI;
        boolean cert = false;

        //classeUtilitats utilString = new classeUtilitats();
        do {

            DNI = utilString.demanarString("\nEscriu el DNI: ");
            cert = validacio.verificarDNI(DNI);

        } while (!cert);

        return DNI;
    }

    /**
     * Mètode per escriure nom
     *
     * @return nom
     */
    public String metodeEscriureNom() {

        String nom;
        boolean cert = false;
        
        do {

            nom = utilString.demanarString("\nEscriu el NOM: ");
            cert = validacio.verificarNoBuit(nom);

        } while (!cert);

        return nom;

    }

    /**
     * Mètode per escriure cognoms
     *
     * @return cognoms
     */
    public String metodeEscriureCognoms() {

        String cognoms;
        boolean cert = false;

        do {

            cognoms = utilString.demanarString("\nEscriu els COGNOMS: ");
            cert = validacio.verificarNoBuit(cognoms);

        } while (!cert);

        return cognoms;
    }

    /**
     * Mètode per escriure els telèfon i comprovar-lo
     *
     * @return telefon
     */
    public String metodeEscriureTelefon() {

        String telefon;
        boolean cert = false;

        do {

            telefon = utilString.demanarString("\nEscriu el TELÈFON: ");
            cert = validacio.verificarTelefon(telefon);

        } while (!cert);

        return telefon;

    }

}
