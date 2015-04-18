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
    public int[] iniciarConcurs(int[] puntsConcursants, int[] indexConcursants)  {
        for (int i=0; i<puntsConcursants.length; i++) {
            puntsConcursants[i] = 0;
            indexConcursants[i] = i;
        }
        return indexConcursants;
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
     * @param limitRondaActual
     * @return 
     */
    public int[] puntuarRonda(ArrayList<ArrayList<String>> concursants, int[] puntsConcursants, int limitRondaActual) {
        String str = "Introduex puntuació (0-3) per ";
        int punts;
        //Fer un recorregut per tots el participants que encara no han estat
        //eliminats
        
        for (int i=0; i<concursants.size()-limitRondaActual; i++) {
            str += concursants.get(puntsConcursants[i]).get(NOM) + concursants.get(i).get(COGNOMS) + ": ";
            punts = UtilitatsMenu.triarOpcio(str, 0, 3);            
            //Acumular els punts per a cada participant amb el valor aleatori
            puntsConcursants[i] += punts;
        }
        return puntsConcursants;
    }
    
    public void llistarQualificacionsRonda() {
        
    }
    
    /**
     *
     * @param puntsConcursants
     * @param indexConcursants
     * @param limitRondaActual
     * @return
     */
    public int finalitzarRonda(int[] puntsConcursants, int[][] indexConcursants, int limitRondaActual) {
        return 0;
    }
    
    public void llistarQualificacionsTwitter(int[] puntsConcursants, int[] indexConcursants, int limitRondaActual) {
        
    }
}
