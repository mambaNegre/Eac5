
package EAC5.interficie;

import EAC5.utilitats.*;
import java.util.ArrayList;
import EAC5.concursants.*;
import EAC5.interficie.Pantallas;

/**
 *
 * @author Bea
 */

public class Menus {

    UtilitatsString utilitatsString = new UtilitatsString();
    UtilitatsMenu utilitatsMenu = new UtilitatsMenu();
    Pantallas pantalla = new Pantallas();
    GestioQualificacions gestionQualif = new GestioQualificacions();
    LlistaConcursants objecteLlista = new LlistaConcursants();
    
    ArrayList<ArrayList<String>> llista;

    /**
     *
     */
    
    public void seleccioGestio() {

        int opcio;
        
        String titolMenu = "\nMENÚ PRINCIPAL"
                + "\n\nSELECCIÓ DE GESTIONS:"
                + "\n" + utilitatsString.repetirChar("-", 30);

        String[] opcions = new String[] {"GESTIÓ D'INSCRIPCIONS",
                "GESTIÓ DE QUALIFICACIONS",
                "SORTIR"};
        
        opcio = utilitatsMenu.imprimirMenu(titolMenu, opcions);

        switch (opcio) {

            case 1:
                
                gestioInscripcions();
                break;
            
            case 2:
                
                gestioQualificacions();
                break;
            
            case 3:
                
                System.out.println("\n\tEL PROGRAMA HA FINALITZAT.");
                break;

        }
    }

    /**
     *
     */
    
    public void gestioInscripcions() {

        int opcio;
        
        String titolMenu = "\nGESTIÓ D'INSCRIPCIONS"
                + "\n\nSELECCIÓ DE GESTIONS:"
                + "\n" + utilitatsString.repetirChar("-", 51);

        String[] opcions = new String[] {"INSCRIPCIÓ DE CONCURSANTS",
            "MODIFICACIÓ DE DADES DELS CONCURSANTS", "LLISTA DE CONCURSANTS",
                "< TORNAR"};

        opcio = utilitatsMenu.imprimirMenu(titolMenu, opcions);

        switch (opcio) {

            case 1:
                
                pantalla.inscripcioConcursants();
                gestioInscripcions();
                break;

            case 2:
            
                pantalla.modificacioConcursants();
                gestioInscripcions();            
                break;
            
            case 3:

                llistaConcursants();
                gestioInscripcions();
                break;
            
            case 4:
                
                seleccioGestio();
                break;
        }
    }

    /**
     *
     */
    public void gestioQualificacions() {

        int opcio;
        
        String titolMenu = "\nGESTIÓ DE QUALIFICACIONS"
                + "\n\nGESTIONS DEL CONCURS I LES QUALIFICACIONS:"
                + "\n" + utilitatsString.repetirChar("-", 69);

        String[] opcions = new String[] {"\nINICIAR CONCURS", "PUNTUAR RONDA",
            "LLISTA DE QUALIFICACIONS DE RONDA","FINALITZAR RONDA",
            "LLISTA DE QUALIFICACIONS PER TWITTER","< TORNAR"};

        opcio = utilitatsMenu.imprimirMenu(titolMenu, opcions);

        switch (opcio) {
            case 1:
            
                pantalla.iniciConcurs();
                System.out.println("Les puntuacions han estat reseteades y tots els concursants estAn actius.");
                gestioQualificacions();
                break;
                
            case 2:
            
                pantalla.puntsRonda();
                gestioQualificacions();
                break;     
                
            case 3:
                pantalla.qualificacionsRonda();
                gestioQualificacions();
                break;
                
            case 4:
            
                pantalla.finalRonda();
                gestioQualificacions();
                break;
                
            case 5:
                
                pantalla.qualificacionsTwitter();
                gestioQualificacions();
                break;
                
            case 6:
                
                seleccioGestio();
                break;
        }
    }

    /**
     *
     */
    public void opcionsModConcursants() {

        int opcio;

        String titolMenu = "\nMenu de Opcions de Modificacio de Concursants"
                + "\nModificació de dades dels concursants:"
                + "\n" + utilitatsString.repetirChar("-", 38);

        String[] opcions = new String[] {"Nom","Cognoms","Telèfon",
            "Tornar a la pantalla anterior","Tornar al menu de gestio de concursants",
            "Tornar al menu d'inici"};

        opcio = utilitatsMenu.imprimirMenu(titolMenu, opcions);

        switch (opcio) {
            case 1:
            // Lleva a ModNombre
            case 2:
            // Lleva a ModApellidos
            case 3:
            // Lleva a ModTelefono
            case 4:
            // Lleva a ModConcursantes
            case 5:
                
                gestioInscripcions();
                
                break;
                
            case 6:
                
                seleccioGestio();
                
                break;
        }
    }

    /**
     *
     */
    public void llistaConcursants() {

        int opcio;

        String titolMenu = "\nLLISTES DE CONCURSANTS"
                + "\n\nTIPUS DE LLISTES:"
                + "\n" + utilitatsString.repetirChar("-", 32);

        String[] opcions = new String[] {"LLISTA DE LOCALITZACIÓ",
            "LLISTA DE TWITTER", "< TORNAR",
            "< MENÚ PRINCIPAL"};

        opcio = utilitatsMenu.imprimirMenu(titolMenu, opcions);

        switch (opcio) {
            case 1:
                
                pantalla.llistaLocalConcursants();
                gestioInscripcions();
                break;
                
            case 2:
            
                pantalla.llistaTwitterConcursants();
                gestioInscripcions();
                break;
                
            case 3:
                
                gestioInscripcions();
                break;
                
            case 4:
                
                seleccioGestio();
                break;
        }
    }
}