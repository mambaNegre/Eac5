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
        String nom = llista.escriureNom();
        
        concursants.get(pos).set(NOM, nom);
        
        return concursants;
    }
    
    /**
     * 
     * @param concursants
     * @param pos
     * @return 
     */
    public ArrayList<ArrayList<String>> modificarCognoms(ArrayList<ArrayList<String>> concursants, int pos) {
        String cognoms = llista.escriureCognoms();
        
        concursants.get(pos).set(COGNOMS, cognoms);
        
        return concursants;
    }
    
    /**
     * 
     * @param concursants
     * @param pos
     * @return 
     */
    public ArrayList<ArrayList<String>> modificarTelefon(ArrayList<ArrayList<String>> concursants, int pos) {
        String telefon = llista.escriureTelefon();
        
        concursants.get(pos).set(TELEFON, telefon);
        
        return concursants;
    }
}
