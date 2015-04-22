
package EAC5.interficie;

import EAC5.utilitats.*;
import java.util.ArrayList;
import EAC5.concursants.*;

/**
 *
 * @author Bea
 */

public class Pantallas {
    
    UtilitatsString utilitatsString = new UtilitatsString();
    UtilitatsMenu utilitatsMenu = new UtilitatsMenu();
    LlistaConcursants llistaConcursants = new LlistaConcursants();
    GestioQualificacions qualificacions = new GestioQualificacions();
    Missatges missatge = new Missatges();

    ArrayList<ArrayList<String>> concursants;
    int[][] puntuacions = new int [15][2];
    int zonaEliminats = 0;
    

    /**
     * Missatge d'inici del programa
     */
    public void missatgeInici() {

        System.out.println(missatge.missatgeBenvinguda());
        System.out.println(utilitatsString.repetirChar("=", 80));
        System.out.println(utilitatsString.repetirChar("=", 80));
        
    }
    
    /**
     * Inscripció de Concursants
     */
    public void inscripcioConcursants() {
        
        //Creació dels concursants.
        concursants = llistaConcursants.escriureLlista();

        //Comprovar si hi ha DNIs repetits.
        llistaConcursants.siDniEstaRepetit(concursants);

        //Ordenar pel DNI.
        concursants = llistaConcursants.ordenarLlista(concursants);
    }
    
    /**
     * Modificació de Concursants
     */
    public void modificacioConcursants() {
       
        //Modificar dades.
        concursants = llistaConcursants.modificarLlista(concursants);

        //Ordenar pel DNI.
        concursants = llistaConcursants.ordenarLlista(concursants);

        //Guardar la llista ordenada.
        concursants = llistaConcursants.guardarLlista(concursants);
    }
    
    /**
     * Mostra la Llista de localització de Concursants
     */
    public void llistaLocalConcursants() {
                
        llistaConcursants.mostrarLlista(concursants, missatge.titolLlistaLocal());        
    }
    
    /**
     * Mostra la Llista de Concursants per Twitter
     */
    public void llistaTwitterConcursants() {
        llistaConcursants.mostrarLlistaTwitter(concursants, missatge.titolLlistaTwitter());
    }
    
    /**
     * 
     */
    public void iniciConcurs() {
        
        puntuacions = new int[concursants.size()][2];
        
        puntuacions = qualificacions.iniciarConcurs(puntuacions);
        
        zonaEliminats = concursants.size();
        
    }
    
    /**
     * 
     */
    public void puntsRonda() {
        
        puntuacions = qualificacions.puntuarRonda(concursants, puntuacions, zonaEliminats);
        
        puntuacions = qualificacions.actualitzarIndex(puntuacions);
    }
    
    /**
     * 
     */
    public void qualificacionsRonda() {
        
        qualificacions.llistarQualificacionsRonda(concursants, puntuacions, zonaEliminats);
        
    }
    
    /**
     * 
     */
    public void finalRonda() {
        
        zonaEliminats = qualificacions.finalitzarRonda(puntuacions, zonaEliminats);
        System.out.println("Concursants actius: " + zonaEliminats);
    }
    
    /**
     * Mostra dues llistes de qualificacions per Twitter, una amb els 
     * concursants actius i l'altre amb els eliminats.
     */
    public void qualificacionsTwitter() {
        
        qualificacions.llistarQualificacionsTwitter(concursants, puntuacions, zonaEliminats);
    }
}
