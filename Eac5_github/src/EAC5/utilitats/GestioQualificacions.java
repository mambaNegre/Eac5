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
     * a 0.
     * @param puntsConcursants És l'array d'enters en què es desen les
     * puntuacions de cada concursant.
     * @param indexConcursants És l'array d'enters que mantindrà ordenats els
     * concursants tant per NOM (primera columna) com per PUNTS (segona columna).
     * @return L'array d'enters que manté els concursants ordenats.
     */
    public int[][] iniciarConcurs(int[][] puntsConcursants)  {
        for (int i=0; i<puntsConcursants.length; i++) {
            puntsConcursants[i][0] = 0;
            puntsConcursants[i][1] = 1;
        }
        return puntsConcursants;
    }
    
    /**
     * El mètode ordenarPerPunts permet mantenir els concursants ordenats per
     * la seva puntuació acumulada.
     * @param puntsConcursants Array d'enters que emmagatzema la puntuació
     * acumulada de cada concursant.
     * @param indexConcursants Array d'enters amb dues columnes, la segona
     * columna manté els concursants ordenats per PUNTS.
     * @param pos Enter que indica la posició a partir de la qual volem començar
     * a comprovar l'ordre.
     * @return La matriu de vectors que manté el concursants ordenats per NOM i
     * PUNTS.
     */
    public int[] ordenarPerPunts(int[] puntsConcursants, int[] indexConcursants, int pos) {
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
                int posIndex1 = indexConcursants[i-1];
                int posIndex2 = indexConcursants[i];

                // Si la puntuació d'un concursant és major que la del següent
                // es considera que el vector està ordenat
                ordenat = puntsConcursants[posIndex1] >= puntsConcursants[posIndex2];
                
                if (!ordenat) {
                    // En cas que les puntuacions no estiguin ordenades,
                    // s'intercanvien els concursants
                    indexConcursants[i-1] = posIndex2;
                    indexConcursants[i] = posIndex1;
                }
            }
        }
        return indexConcursants;
    }
    
    /**
     * 
     * @param concursants
     * @param puntsConcursants
     * @param zonaEliminats
     * @return 
     */
    public int[][] puntuarRonda(ArrayList<ArrayList<String>> concursants, int[][] puntuacions, int zonaEliminats) {
        int punts;
        //Fer un recorregut per tots el participants que encara no han estat
        //eliminats
        
        for (int i=0; i<concursants.size()-zonaEliminats; i++) {
            System.out.println(concursants.size());
            String str = "Introduex puntuació (0-3) per ";
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
    
    public void llistarQualificacionsRonda(ArrayList<ArrayList<String>> concursants, int[][] puntuacions, int zonaEliminats) {
        for (int i=0; i<puntuacions.length-zonaEliminats; i++) {
            String dni = UtilitatsString.formatCadena(concursants.get(i).get(DNI), 10, ' ', 0);
            String nom = UtilitatsString.formatCadena(concursants.get(i).get(NOM), 15, ' ', 0);
            String cognoms = UtilitatsString.formatCadena(concursants.get(i).get(COGNOMS), 20, ' ', 0);
            String telefon = UtilitatsString.formatCadena(concursants.get(i).get(DNI), 15, ' ', 0);
            String punts = UtilitatsString.formatCadena(String.valueOf(puntuacions[i][1]), 5, ' ', -1);
            System.out.println(dni + nom + cognoms + telefon + punts);
        }
    }
    
    /**
     * El mètode finalitzarRonda calcula els concursants eliminats a la ronda
     * actual del concurs.
     * @param puntsConcursants Vector d'enters que conté la puntuació acumulada
     * de cada condursant.
     * @param indexConcursants Vector d'enters que maté els concursants ordenats
     * per la seva puntuació.
     * @param zonaEliminats Enter que indica a on comença la zona de concursants
     * eliminats.
     * @return Un enter que identifica on comença la zona d'eliminats després
     * d'haver completat la ronda.
     */
    public int finalitzarRonda(int[][] puntuacions, int zonaEliminats) {
        int limit = 0;
        int max = puntuacions[limit][1];
        
        while (limit<zonaEliminats && puntuacions[limit][1]==max) {
            limit++;
        }
        zonaEliminats = limit;
        return zonaEliminats;
    }
    
    public void llistarQualificacionsTwitter(ArrayList<ArrayList<String>> concursants, int[][] puntuacions, int zonaEliminats) {
        for (int i=0; i<puntuacions.length-zonaEliminats; i++) {
            String nom = UtilitatsString.formatCadena(concursants.get(i).get(NOM), 15, ' ', 1);
            String cognoms = UtilitatsString.formatCadena(concursants.get(i).get(COGNOMS), 25, ' ', 1);
            String punts = UtilitatsString.formatCadena(String.valueOf(puntuacions[i][1]), 5, ' ', -1);
            System.out.println(nom + cognoms + punts);
        }
    }
}
