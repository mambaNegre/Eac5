package EAC5.interficie;

import EAC5.utilitats.*;
import java.util.ArrayList;

/**
 *
 * @author Bea
 */

public class Missatges {
    
    UtilitatsString utilitatsString = new UtilitatsString();
    GestioConcursants gestioConcursants = new GestioConcursants();
    
    ArrayList<ArrayList<String>> concursants;
    
    /**
     *
     * @return String amb el missatge a mostrar en iniciar el programa.
     */
    public String missatgeBenvinguda() {
        
        String missatge = "\nBENVINGUT AL PROGRAMA DE GESTIÓ DE CONCURSOS DE RADIO";
        
        return missatge;
    }
    
    /**
     * 
     * @return String amb el titol del Menú de Gestions.
     */
    public String getTitolMenuGestions() {
    
        String titol = "\nMENÚ PRINCIPAL"
                + "\n\nSELECCIÓ DE GESTIONS:"
                + "\n" + utilitatsString.repetirChar("-", 30);
        
        return titol;
    }
    
    /**
     * 
     * @return Array amb les opcions del Menú de Gestions.
     */
    public String[] getOpcionsMenuGestions() {
        
        String[] opcions = new String[] {"GESTIÓ D'INSCRIPCIONS",
                "GESTIÓ DE QUALIFICACIONS",
                "SORTIR"};
        
        return opcions;
    }
    
    /**
     * 
     * @return String amb el titol del Menú d'Inscripcions. 
     */
    public String getTitolInscripcions() {
        
        String titol = "\nGESTIÓ D'INSCRIPCIONS"
                + "\n\nSELECCIÓ DE GESTIONS:"
                + "\n" + utilitatsString.repetirChar("-", 51);
        
        return titol;
    }
    /**
     * 
     * @return Array amb les opcions del Menú d'Inscripcions. 
     */
    public String[] getOpcionsInscripcions() {
        
        String[] opcions = new String[] {"INSCRIPCIÓ DE CONCURSANTS",
            "MODIFICACIÓ DE DADES DELS CONCURSANTS", "LLISTA DE CONCURSANTS",
                "< TORNAR"};
        
        return opcions;
    }
    /**
     * 
     * @return String amb el titol del Menú de Qualificacions. 
     */
    public String getTitolQualificacions() {
        
        String titol = "\nGESTIÓ DE QUALIFICACIONS"
                + "\n\nGESTIONS DEL CONCURS I LES QUALIFICACIONS:"
                + "\n" + utilitatsString.repetirChar("-", 69);
        
        return titol;
    }
    
    /**
     * 
     * @return Array de Strings amb les opcions del Menú de Qualificacions. 
     */
    public String[] getOpcionsQualificacions() {
        
        String[] opcions = new String[] {"INICIAR CONCURS", "PUNTUAR RONDA",
            "LLISTA DE QUALIFICACIONS DE RONDA","FINALITZAR RONDA",
            "LLISTA DE QUALIFICACIONS PER TWITTER","< TORNAR"};
        
        return opcions;
    }
    
    /**
     * 
     * @return String amb el titol del Menú de Modificació de Concursants. 
     */
    public String getTitolModificacioDades() {
        
        String titol = "\nOPCIONS DE MODIFICACIÓ DE CONCURSANTS"
                + "\n" + utilitatsString.repetirChar("-", 38);
        
        return titol;
    }
    
    /**
     * 
     * @return Array de Strings amb les opcions del menú de Modificació de Concursants. 
     */
    public String[] getOpcionsModificacioDades() {
        
        String[] opcions = new String[] {"NOM","COGNOM","TELEFON","< TORNAR",
            "< MENÚ PRINCIPAL"};
        
        return opcions;
    }
    
    /**
     * 
     * @return String amb el titol del menú de Llistes de Concursants. 
     */
    public String getTitolLlistesConcursants() {
        
        String titol = "\nLLISTES DE CONCURSANTS"
                + "\n\nTIPUS DE LLISTES:"
                + "\n" + utilitatsString.repetirChar("-", 32);
        
        return titol;
    }
    
    /**
     * 
     * @return Array de Strings amb les opcions del menú Llistes de Concursants. 
     */
    public String[] getOpcionsLlistesConcursants() {
        
        String[] opcions = new String[] {"LLISTA DE LOCALITZACIÓ",
            "LLISTA DE TWITTER", "< TORNAR",
            "< MENÚ PRINCIPAL"};
        
        return opcions;
    }
    
    /**
     * 
     * @return String amb el titol per l'impresió de la Llista Local de Concursants. 
     */
    public String titolLlistaLocal() {
        
        String titol = "LLISTA DE LOCALITZACIÓ DE CONCURSANTS";
        
        return titol;
    }
    
    /**
     * 
     * @return String amb el titol per l'impresió de la Llista concursants per Twitter.
     */
    public String titolLlistaTwitter() {
        String titol = "LLISTA DE TWITTER DE CONCURSANTS";
        
        return titol;
    }
}
