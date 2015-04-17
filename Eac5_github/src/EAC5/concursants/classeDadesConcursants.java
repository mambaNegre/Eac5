package EAC5.concursants;

import EAC5.utilitats.*;

/**
 *
 * @author joan
 */
public class classeDadesConcursants {

    classeUtilitats objecte = new classeUtilitats();

    /**
     * Mètode per escriure el dni i comprovar-lo
     *
     * @return dni
     */
    public String metodeEscriureDni() {
        String DNI;
        boolean cert = false;

        //classeUtilitats objecte = new classeUtilitats();
        do {

            DNI = objecte.metodeEscriureString("\nEscriu el DNI: ");
            cert = objecte.metodeVerificarDNI(DNI);

        } while (!cert);

        return DNI;
    }

    /**
     * Mètode per escriure nom
     *
     * @return nom
     */
    public String metodeEscriureNom() {
        boolean cert = false;
        String nom;

        do {

            nom = objecte.metodeEscriureString("\nEscriu el NOM: ");
            cert = objecte.metodeVerificarNoBuit(nom);

        } while (!cert);

        return nom;

    }

    /**
     * Mètode per escriure cognoms
     *
     * @return cognoms
     */
    public String metodeEscriureCognoms() {
        boolean cert = false;
        String cognoms;

        do {

            cognoms = objecte.metodeEscriureString("\nEscriu els COGNOMS: ");
            cert = objecte.metodeVerificarNoBuit(cognoms);

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

            telefon = objecte.metodeEscriureString("\nEscriu el TELÈFON: ");
            cert = objecte.metodeVerificarTelefon(telefon);

        } while (!cert);

        return telefon;

    }

}
