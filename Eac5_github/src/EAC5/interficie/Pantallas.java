
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

    ArrayList<ArrayList<String>> concursants;
    int[][] puntuacions = new int [15][2];
    int zonaEliminats = 0;
    

    /**
     *
     */
    
    public void missatgeBenvinguda() {

        System.out.println("\nBENVINGUT AL PROGRAMA DE GESTIÓ DE CONCURSOS DE RADIO");
        System.out.println(utilitatsString.repetirChar("=", 80));
        System.out.println(utilitatsString.repetirChar("=", 80));
        
    }
    
    /**
     * 
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
     * 
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
     * 
     */
    
    public void llistaLocalConcursants() {
        
        String missatge = "LLISTA DE LOCALITZACIÓ DE CONCURSANTS";        
        llistaConcursants.mostrarLlista(concursants, missatge);        
    }
    
    /**
     * 
     */
    
    public void llistaTwitterConcursants() {
        
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
     * 
     */
    
    public void qualificacionsTwitter() {
        
        qualificacions.llistarQualificacionsTwitter(concursants, puntuacions, zonaEliminats);
    }
}
