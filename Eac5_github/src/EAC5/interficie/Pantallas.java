
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
    classeLlistaConcursants objecteLlista = new classeLlistaConcursants();

    ArrayList<ArrayList<String>> llista;

    /**
     *
     */
    
    public void metodeMisatgeBenvinguda() {

        System.out.println("/nBenvingut al programa per gestionar concursants"
                + " per al programa de radio 'NOMBRE'");
        System.out.println(utilitatsString.repetirChar("=", 80));
        System.out.println(utilitatsString.repetirChar("=", 80));
        
    }
    
    /**
     * 
     */
    
    public void inscripcioConcursants() {
        
        //Creem llista dels concursants.
        llista = objecteLlista.metodeEscriureLlista();

        //Comprovar la llista per si hi ha DNIs repetits.
        objecteLlista.metodeSiDniEstaRepetit(llista);

        //Ordenar la llista pel DNI
        llista = objecteLlista.metodeOrdenarLlista(llista);
    }
    
    /**
     * 
     */
    
    public void modificacioConcursants() {
       
        //Modificar dada/es i guardar els canvis en una nova llista.
        llista = objecteLlista.metodeModificarLlista(llista);

        //Ordenar la llista pel DNI
        llista = objecteLlista.metodeOrdenarLlista(llista);

        //Guardar la llista ordenada dins la llista Final
        llista = objecteLlista.metodeGuardarLlista(llista);
    }
    
    public void llistaLocalConcursants() {
        
    }
    
    /**
     * 
     */
    
    public void llistaTwitterConcursants() {
        
    }
    
    /**
     * 
     */
    
    public void iniciarConcurs() {
        
    }
    
    /**
     * 
     */
    
    public void puntuarRonda() {
        
    }
    
    /**
     * 
     */
    
    public void llistaQualifRonda() {
        
    }
    
    /**
     * 
     */
    
    public void finalitzarRonda() {
        
    }
    
    /**
     * 
     */
    
    public void llistaQualifTwitEliminats() {
        
    }
    
    /**
     * 
     */
    
    public void llistaQualifTwitActius() {
        
    }
}
