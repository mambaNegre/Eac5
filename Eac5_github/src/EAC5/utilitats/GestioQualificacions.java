package EAC5.utilitats;
import java.util.ArrayList;

/**
 *
 * @author moledov
 */
public class GestioQualificacions {
    
    public final static int DNI = 0;
    public final static int NOM = 1;
    public final static int COGNOMS = 2;
    public final static int TELEFON = 3;
    
    /**
     * El mètode iniciarConcurs inicialitza la puntuació de tots els concursants
     * a 0 i crea l'índex de concursants.
     * @param puntuacions Matriu d'enters de dues columnes; la primera columna
     * conté la puntuació acumulada dels concursants, la segona columna manté
     * l'ordre segons aquesta puntuació.
     * @return Matriu d'enters amb la puntuació i índex dels concursants.
     */
    public int[][] iniciarConcurs(int[][] puntuacions)  {
        // Es fa un recorreguts per tots els concursants
        for (int i=0; i<puntuacions.length; i++) {
            // Inicialitzar a 0 la puntuació de cada concursant
            puntuacions[i][0] = 0;
            // Per defecte, a cada concursant li correspon l'ordre en què va
            // ser creat
            puntuacions[i][1] = i;
        }
        return puntuacions;
    }
    
    /** El mètode ordenarPerPunts permet mantenir els concursants ordenats
     * per la seva puntuació acumulada.
     * @param puntuacions Matriu d'enters de dues columnes; la primera columna
     * conté la puntuació acumulada dels concursants, la segona columna manté
     * l'ordre segons aquesta puntuació.
     * @param pos Enter que indica la posició a partir de la qual volem començar
     * a comprovar l'ordre.
     * @return La matriu de vectors que manté el concursants ordenats per NOM i
     * PUNTS.
     */
    public int[][] ordenarPerPunts(int[][] puntuacions, int pos) {
        // Per defecte es considera que els concursants no estan ordenats
        boolean ordenat = false;
        
        // Mentres els concursants no estiguin ordenats s'executarà el següent
        // bucle
        while (!ordenat) {
            // Es fa un recorregut pel vector que conté la puntuació, des de la
            // posició que volem comprovar fins a l'inici del vector
            for (int i=pos; i>0; i--) {
                // Fem servir dues variables auxiliars per carregar l'index de
                // la posició actual i el que la precedeix
                int posIndex1 = puntuacions[i-1][1];
                int posIndex2 = puntuacions[i][1];

                // Si la puntuació d'un concursant és major que la del següent
                // es considera que el vector està ordenat
                ordenat = puntuacions[posIndex1][0] >= puntuacions[posIndex2][0];
                
                if (!ordenat) {
                    // En cas que les puntuacions no estiguin ordenades,
                    // s'intercanvien els concursants
                    puntuacions[i-1][1] = posIndex2;
                    puntuacions[i][1] = posIndex1;
                }
            }
        }
        return puntuacions;
    }
    
    /**
     * El mètode actualitzarIndex fa un recorregut per tots els concursants per
     * mantenir l'ordre segons la puntuació acumulada.
     * @param puntuacions Matriu d'enters de dues columnes; la primera columna
     * conté la puntuació acumulada dels concursants, la segona columna manté
     * l'ordre segons aquesta puntuació.
     * @return La matriu de vectors que manté el concursants ordenats per NOM i
     * PUNTS.
     */
    public int[][] actualitzarIndex(int[][] puntuacions) {
        for (int i=1; i<puntuacions.length; i++) {
            puntuacions = ordenarPerPunts(puntuacions, i);
        }
        return puntuacions;
    }
    
    /**
     * El mètode puntuarRonda demana a l'usuari que introudeix els punts que
     * ha obtingut cada usuari a la ronda actual.
     * @param concursants Matriu que emmagatzema les dades personals dels
     * participants.
     * @param puntuacions Matriu d'enters de dues columnes; la primera columna
     * conté la puntuació acumulada dels concursants, la segona columna manté
     * l'ordre segons aquesta puntuació.
     * @param zonaEliminats Enter que indica el número de concursants eliminats
     * en rondes prèvies.
     * @return La matriu de vectors que manté el concursants ordenats per NOM i
     * PUNTS.
     */
    public int[][] puntuarRonda(ArrayList<ArrayList<String>> concursants, int[][] puntuacions, int zonaEliminats) {
        int punts;
        //Fer un recorregut per tots el participants que encara no han estat
        //eliminats
        
        for (int i=0; i<concursants.size()-zonaEliminats; i++) {
            String str = "Introdueix puntuació (0-3) per ";
            str += concursants.get(puntuacions[i][1]).get(NOM);
            str += " ";
            str += concursants.get(puntuacions[i][1]).get(COGNOMS);
            str += ": ";
            punts = UtilitatsMenu.triarOpcio(str, 0, 3);
            //Acumular els punts per a cada participant amb el valor aleatori
            puntuacions[i][0] += punts;
        }
        return puntuacions;
    }
    
    /**
     * El mètode llistarQualificacionsronda permet llistar els punts obtinguts
     * per cada concursant a la ronda actual.
     * @param concursants Matriu que emmagatzema les dades personals dels
     * participants.
     * @param puntuacions Matriu d'enters de dues columnes; la primera columna
     * conté la puntuació acumulada dels concursants, la segona columna manté
     * l'ordre segons aquesta puntuació.
     * @param zonaEliminats Enter que indica el número de concursants eliminats
     * en rondes prèvies.
     */
    public void llistarQualificacionsRonda(ArrayList<ArrayList<String>> concursants, int[][] puntuacions, int zonaEliminats) {
        for (int i=0; i<puntuacions.length-zonaEliminats; i++) {
            String dni = UtilitatsString.formatCadena(concursants.get(i).get(DNI), 10, ' ', 0);
            String nom = UtilitatsString.formatCadena(concursants.get(i).get(NOM), 15, ' ', 0);
            String cognoms = UtilitatsString.formatCadena(concursants.get(i).get(COGNOMS), 20, ' ', 0);
            String telefon = UtilitatsString.formatCadena(concursants.get(i).get(DNI), 15, ' ', 0);
            int index = puntuacions[i][1];
            String punts = UtilitatsString.formatCadena(String.valueOf(puntuacions[index][0]), 5, ' ', -1);
            System.out.println(dni + nom + cognoms + telefon + punts);
        }
    }
    
    /**
     * El mètode finalitzarRonda calcula els concursants eliminats a la ronda
     * actual del concurs.
     * @param puntuacions Matriu d'enters de dues columnes; la primera columna
     * conté la puntuació acumulada dels concursants, la segona columna manté
     * l'ordre segons aquesta puntuació.
     * @param zonaEliminats Enter que indica el número de concursants eliminats
     * en rondes prèvies.
     * @return Un enter que actualitza el número de participants eliminasts
     * al concurs.
     */
    public int finalitzarRonda(int[][] puntuacions, int zonaEliminats) {
        int limit = 0;
        int index = puntuacions[limit][1];
        int max = puntuacions[index][0];
        
        while (zonaEliminats<puntuacions.length && puntuacions[index][0]==max) {
            limit++;
            index = puntuacions[limit][1];
        }
        zonaEliminats = limit;
        return zonaEliminats;
    }
    
    /**
     * 
     * @param concursants
     * @param puntuacions
     * @param zonaEliminats 
     */
    public void llistarQualificacionsTwitter(ArrayList<ArrayList<String>> concursants, int[][] puntuacions, int zonaEliminats) {
        System.out.println("CONCURSANTS ACTIUS");
        for (int i=0; i<zonaEliminats; i++) {
            String nom = UtilitatsString.formatCadena(concursants.get(i).get(NOM), 15, ' ', 1);
            String cognoms = UtilitatsString.formatCadena(concursants.get(i).get(COGNOMS), 25, ' ', 1);
            int index = puntuacions[i][1];
            String punts = UtilitatsString.formatCadena(String.valueOf(puntuacions[index][0]), 5, ' ', -1);
            System.out.println(nom + cognoms + punts);
        }
        System.out.println("CONCURSANTS ELIMINATS");
        for (int i=zonaEliminats; i<puntuacions.length; i++) {
            String nom = UtilitatsString.formatCadena(concursants.get(i).get(NOM), 15, ' ', 1);
            String cognoms = UtilitatsString.formatCadena(concursants.get(i).get(COGNOMS), 25, ' ', 1);
            int index = puntuacions[i][1];
            String punts = UtilitatsString.formatCadena(String.valueOf(puntuacions[index][0]), 5, ' ', -1);
            System.out.println(nom + cognoms + punts);
        }
    }
}
