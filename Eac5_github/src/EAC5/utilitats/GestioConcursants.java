package EAC5.utilitats;

import java.util.ArrayList;
import EAC5.concursants.DadesConcursants;

import static EAC5.utilitats.GestioQualificacions.DNI;
import static EAC5.utilitats.GestioQualificacions.NOM;
import static EAC5.utilitats.GestioQualificacions.COGNOMS;
import static EAC5.utilitats.GestioQualificacions.TELEFON;

public class GestioConcursants {
    
    DadesConcursants llista = new DadesConcursants();
    Validacions validacions = new Validacions();
    UtilitatsString utilitatsString = new UtilitatsString();
    
    /**
     * 
     * @param concursants Matriu que conté les dades personals dels
     * participants.
     * @param pos Índex que indica la posició del concursant.
     * @return String amb el DNI del concursant.
     */
    public String obtenirDNI(ArrayList<ArrayList<String>> concursants, int pos) {
        return concursants.get(pos).get(DNI);
    }
    
    /**
     * 
     * @param concursants Matriu que conté les dades personals dels
     * participants.
     * @param pos Índex que indica la posició del concursant.
     * @return String amb el nom del concursant.
     */
    public String obtenirNom(ArrayList<ArrayList<String>> concursants, int pos) {
        return concursants.get(pos).get(NOM);
    }
    
    /**
     * 
     * @param concursants Matriu que conté les dades personals dels
     * participants.
     * @param pos Índex que indica la posició del concursant.
     * @return String amb el cognoms del concursant.
     */
    public String obtenirCognoms(ArrayList<ArrayList<String>> concursants, int pos) {
        return concursants.get(pos).get(COGNOMS);
    }
    
    /**
     * 
     * @param concursants Matriu que conté les dades personals dels
     * participants.
     * @param i Índex que indica la posició del concursant.
     * @return String amb el telèfon del concursant.
     */
    public String obtenirTelefon(ArrayList<ArrayList<String>> concursants, int i) {
        return concursants.get(i).get(TELEFON);
    }
    
    /**
     * El mètode trobarDNI permet
     * @param concursants Matriu que conté les dades personals dels
     * participants.
     * @param dni Cadena que indentifica el concursant pel seu DNI.
     * @return Enter amb la posició del concursant a la matriu. Retorna -1 si
     * si el DNI no pertany a cap concursant.
     */
    public int trobarDNI(ArrayList<ArrayList<String>> concursants, String dni) {
        for (int i=0; i<concursants.size(); i++) {
            if (obtenirDNI(concursants, i).equals(dni)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * 
     * @param concursants
     * @param pos
     * @return 
     */
    public ArrayList<ArrayList<String>> modificarNom(ArrayList<ArrayList<String>> concursants, int pos) {
        String nomAbans = obtenirNom(concursants, pos);
        String nom = llista.escriureNom();
        String missatge = String.format("Vols confirmar l'acció? (S/N) [%s substitueix %s]: ", nom, nomAbans);
        String confirmacio = utilitatsString.demanarString(missatge);
        if (confirmacio.equalsIgnoreCase("s")) {
            concursants.get(pos).set(NOM, nom);
        }
        return concursants;
    }
    
    /**
     * 
     * @param concursants
     * @param pos
     * @return 
     */
    public ArrayList<ArrayList<String>> modificarCognoms(ArrayList<ArrayList<String>> concursants, int pos) {
        String cognomsAbans = obtenirCognoms(concursants, pos);
        String cognoms = llista.escriureCognoms();
        
        String missatge = String.format("Vols confirmar l'acció? (S/N) [%s substitueix %s]: ", cognoms, cognomsAbans);
        String confirmacio = utilitatsString.demanarString(missatge);
        if (confirmacio.equalsIgnoreCase("s")) {
            concursants.get(pos).set(COGNOMS, cognoms);
        }
        
        return concursants;
    }
    
    /**
     * 
     * @param concursants
     * @param pos
     * @return 
     */
    public ArrayList<ArrayList<String>> modificarTelefon(ArrayList<ArrayList<String>> concursants, int pos) {
        String telefonAbans = obtenirTelefon(concursants, pos);
        String telefon = llista.escriureTelefon();
        
        String missatge = String.format("Vols confirmar l'acció? (S/N) [%s substitueix %s]: ", telefon, telefonAbans);
        String confirmacio = utilitatsString.demanarString(missatge);
        if (confirmacio.equalsIgnoreCase("s")) {
            concursants.get(pos).set(TELEFON, telefon);
        }
        
        return concursants;
    }
}