
package EAC5.interficie;

import EAC5.utilitats.*;
import java.util.ArrayList;
import EAC5.concursants.*;
import EAC5.interficie.Pantallas;

/**
 *
 * @author Bea
 */

public class classeMenus {

    UtilitatsString utilitatsString = new UtilitatsString();
    UtilitatsMenu utilitatsMenu = new UtilitatsMenu();
    Pantallas pantalla = new Pantallas();
    GestioQualificacions gestionQualif = new GestioQualificacions();
    classeLlistaConcursants objecteLlista = new classeLlistaConcursants();
    
    ArrayList<ArrayList<String>> llista;

    /**
     *
     */
    
    public void metodeSeleccioGestio() {

        int opcio;
        
        String titolMenu = "\nMenu de Selecció de Gestions "
                + "\nOpcions de gestió del concurs:"
                + "\n" + utilitatsString.repetirChar("-", 30);

        String[] opcions = new String[] {"Inscripció i gestió dels concursants",
                "Gestió de qualificacions",
                "Sortir del Programa"};
        
        opcio = utilitatsMenu.imprimirMenu(titolMenu, opcions);

        switch (opcio) {

            case 1:
                metodeGestioInscripcions();
                break;
            
            case 2:
                metodeGestioQualificacions();
                break;
            
            case 3:
                System.out.println("\n\tHAS FINALITZAT EL PROGRAMA.");
                break;

        }
    }

    /**
     *
     */
    
    public void metodeGestioInscripcions() {

        int opcio;
        
        String titolMenu = "\nMenu de Gestions de Inscripcios"
                + "\nOpcions disponibles per a la gestió de concursants:"
                + "\n" + utilitatsString.repetirChar("-", 51);

        String[] opcions = new String[] {"Inscripció de concursants",
            "Modificació de dades dels concursants", "Llistes de concursants",
                "Torna al menu anterior"};

        opcio = utilitatsMenu.imprimirMenu(titolMenu, opcions);

        switch (opcio) {

            case 1:
                
                pantalla.inscripcioConcursants();
                
                metodeSeleccioGestio();
                
                break;

            case 2:
            
                pantalla.modificacioConcursants();

                metodeSeleccioGestio();
                
                break;
            
            case 3:

                //Mostrar la llista.
                objecteLlista.metodeMostrarLlista(llista, "LLISTA DE CONCURSANTS");

                metodeSeleccioGestio();
                
                break;
            
            case 4:
                metodeSeleccioGestio();
                
                break;
        }
    }

    /**
     *
     */
    public void metodeGestioQualificacions() {

        int opcio;
        
        String titolMenu = "\nMenu de Gestions de Qualificacions"
                + "\nOpcions disponibles per a la gestió del concurs y les qualificacions:"
                + "\n" + utilitatsString.repetirChar("-", 69);

        String[] opcions = new String[] {"\nIniciar el concurs", "Puntuar ronda",
            "Mostrar llista de qualificacions de la ronda","Finalitzar ronda",
            "Mostrar llistas de qualificacions per Twitter","Torna al menu anterior"};

        opcio = utilitatsMenu.imprimirMenu(titolMenu, opcions);

        switch (opcio) {
            case 1:
            // Lleva a iniciarConcurso
            case 2:
            // Lleva a PuntuarRonda
            case 3:
            // Lleva a ListaCualifRonda
            case 4:
            // Lleva a FinalRonda
            case 5:
                
                metodeLlistaQualifTwitter();
                
                break;
            case 6:
                
                metodeSeleccioGestio();
                
                break;
        }
    }

    /**
     *
     */
    public void metodeOpcionsModConcursants() {

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
                
                metodeGestioInscripcions();
                
                break;
                
            case 6:
                
                metodeSeleccioGestio();
                
                break;
        }
    }

    /**
     *
     */
    public void metodeLlistaConcursants() {

        int opcio;

        String titolMenu = "\nMenu de Seleció de Llistes de Concursants"
                + "\nTipos de llistes de concursants:"
                + "\n" + utilitatsString.repetirChar("-", 32);

        String[] opcions = new String[] {"Llista de localització",
            "Llista per publicar a Twitter", "Tornar al menu anterior",
            "Tornar al menu d'inici"};

        opcio = utilitatsMenu.imprimirMenu(titolMenu, opcions);

        switch (opcio) {
            case 1:
            // Lleva a ListaConcurLoca
            case 2:
            // Lleva a ListaConcurTwitter
            case 3:
                
                metodeGestioInscripcions();
                
                break;
                
            case 4:
                
                metodeSeleccioGestio();
                
                break;
        }
    }

    /**
     *
     */
    public void metodeLlistaQualifTwitter() {

        int opcio;

        String titolMenu = "\nMenu de Seleció de Llistes de Qualificacions per Twitter"
                + "\nTipus de llistas de qualificacions:"
                + "\n" + utilitatsString.repetirChar("-", 35);

        String[] opcions = new String[] {"Llista d'eliminats", 
            "Llista de concursants actius", "Tornar al menu anterior",
            "Tornar al menu d'inici"};

        opcio = utilitatsMenu.imprimirMenu(titolMenu, opcions);

        switch (opcio) {
            case 1:
            // Lleva a ListaCualifTwElim
            case 2:
            // Lleva a ListaCualifTwActiv
            case 3:
                
                metodeGestioInscripcions();
                
                break;
                
            case 4:
                
                metodeSeleccioGestio();
                
                break;
        }
    }
}
