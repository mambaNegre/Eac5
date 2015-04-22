
package EAC5.interficie;

import EAC5.utilitats.*;
import java.util.ArrayList;
import EAC5.concursants.*;

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
    Missatges missatge = new Missatges();
    
    ArrayList<ArrayList<String>> llista;

    /**
     * Menú de Selecció de Gestións del Concurs. Primer menú del programa.
     */
    public void seleccioGestio() {

        int opcio;
        
        opcio = utilitatsMenu.imprimirMenu(missatge.getTitolMenuGestions(), missatge.getOpcionsMenuGestions());

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
     * Menú de Gestió d'Inscripcions.
     */
    public void gestioInscripcions() {

        int opcio;

        opcio = utilitatsMenu.imprimirMenu(missatge.getTitolInscripcions(), missatge.getOpcionsInscripcions());

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
     * Menú de Gestió de Qualificacions
     */
    public void gestioQualificacions() {

        int opcio;

        opcio = utilitatsMenu.imprimirMenu(missatge.getTitolQualificacions(), missatge.getOpcionsQualificacions());

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
     * Menú d'opcions de Modificació de Dades de Concursants.
     */
    public void opcionsModConcursants() {

        int opcio;

        opcio = utilitatsMenu.imprimirMenu(missatge.getTitolModificacioDades(), missatge.getOpcionsModificacioDades());

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
     * Menú de Llistes de Concursants.
     */
    public void llistaConcursants() {

        int opcio;

        opcio = utilitatsMenu.imprimirMenu(missatge.getTitolLlistesConcursants(), missatge.getOpcionsLlistesConcursants());

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
