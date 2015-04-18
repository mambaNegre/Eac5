package EAC5.interficie;

import EAC5.utilitats.*;
import java.util.ArrayList;
import EAC5.concursants.*;

/**
 *
 * @author Bea
 */

public class classeMenus {

    UtilitatsString utilitatsString = new UtilitatsString();
    UtilitatsMenu utilitatsMenu = new UtilitatsMenu();
    classeLlistaConcursants objecteLlista = new classeLlistaConcursants();

    ArrayList<ArrayList<String>> llista;

    /**
     *
     */
    
    public void metodeMisatgeBenvinguda() {

        System.out.println("Benvingut al programa per gestionar concursants"
                + " per al programa de radio 'NOMBRE'");
        System.out.println(utilitatsString.repetirChar("=", 80));
        System.out.println(utilitatsString.repetirChar("=", 80));
        

    }

    /**
     *
     */
    
    public void metodeSeleccioGestio() {

        int opcio;
        
        String titolMenu = "Menu de Selecció de Gestions";

        String[] opcions = new String[] {"\nOpcions de gestió del concurs:"
                + "\n" + utilitatsString.repetirChar("-", 30) 
                + "\n1 - Inscripció i gestió dels concursants",
                "\n2 - Gestió de qualificacions",
                "\n3 - Sortir del Programa"};
        
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
        
        String titolMenu = "Menu de Gestions de Inscripcios";

        String[] opcions = new String[] {"\nOpcions disponibles per a la gestió de concursants:"
                + "\n" + utilitatsString.repetirChar("-", 51)
                + "\n1 - Inscripció de concursants"
                + "\n2 - Modificació de dades dels concursants"
                + "\n3 - Llistes de concursants"
                + "\n4 - Torna al menu anterior"};

        opcio = utilitatsMenu.imprimirMenu(titolMenu, opcions);

        switch (opcio) {

            case 1:
                // Lleva a InsNuevosConcursantes (en proceso)

                //Creem llista dels concursants.
                llista = objecteLlista.metodeEscriureLlista();

                //Comprovar la llista per si hi ha DNIs repetits.
                objecteLlista.metodeSiDniEstaRepetit(llista);

                //Ordenar la llista pel DNI
                llista = objecteLlista.metodeOrdenarLlista(llista);

                metodeSeleccioGestio();
                break;

            case 2:
            // Lleva a ModConcursantes (en proceso)

                //Modificar dada/es i guardar els canvis en una nova llista.
                llista = objecteLlista.metodeModificarLlista(llista);

                //Ordenar la llista pel DNI
                llista = objecteLlista.metodeOrdenarLlista(llista);

                //Guardar la llista ordenada dins la llista Final
                llista = objecteLlista.metodeGuardarLlista(llista);

                metodeSeleccioGestio();
                break;
            
            case 3:
            // Lleva a ListaConcursantes (en proceso)

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
        
        String titolMenu = "Menu de Gestions de Qualificacions";

        String[] opcions = new String[] {"\nOpcions disponibles per a la gestió del concurs y les qualificacions:"
                + "\n" + utilitatsString.repetirChar("-", 69)
                + "\n1 - Iniciar el concurs"
                + "\n2 - Puntuar ronda"
                + "\n3 - Mostrar llista de qualificacions de la ronda"
                + "\n4 - Finalitzar ronda"
                + "\n5 - Mostrar llistas de qualificacions per Twitter"
                + "\n6 - Torna al menu anterior"};

        opcio = utilitatsMenu.imprimirMenu(titolMenu, opcions);

        switch (opcio) {
            case 1:
            // Lleva a IniciarConcurso
            case 2:
            // Lleva a PuntuarRonda
            case 3:
            // Lleva a ListaCualifRonda
            case 4:
            // Lleva a FinalRonda
            case 5:
                metodeLlistaQualifTwitter();
            case 6:
                metodeSeleccioGestio();
        }
    }

    /**
     *
     */
    public void metodeOpcionsModConcursants() {

        int opcio;

        String titolMenu = "Menu de Opcions de Modificacio de Concursants";

        String[] opcions = new String[] {"\nModificació de dades dels concursants:"
                + "\n" + utilitatsString.repetirChar("-", 38)
                + "\n1 - Nom"
                + "\n2 - Cognoms"
                + "\n3 - Telèfon"
                + "\n4 - Tornar a la pantalla anterior"
                + "\n5 - Tornar al menu de gestio de concursants"
                + "\n6 - Tornar al menu d'inici"};

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
            case 6:
                metodeSeleccioGestio();
        }
    }

    /**
     *
     */
    public void metodeLlistaConcursants() {

        int opcio;

        String titolMenu = "Menu de Seleció de Llistes de Concursants";

        String[] opcions = new String[] {"\nTipos de llistes de concursants:"
                + "\n" + utilitatsString.repetirChar("-", 32)
                + "\n1 - Llista de localització"
                + "\n2 - Llista per publicar a Twitter"
                + "\n3 - Tornar al menu anterior"
                + "\n4 - Tornar al menu d'inici"};

        opcio = utilitatsMenu.imprimirMenu(titolMenu, opcions);

        switch (opcio) {
            case 1:
            // Lleva a ListaConcurLoca
            case 2:
            // Lleva a ListaConcurTwitter
            case 3:
                metodeGestioInscripcions();
            case 4:
                metodeSeleccioGestio();
        }
    }

    /**
     *
     */
    public void metodeLlistaQualifTwitter() {

        int opcio;

        String titolMenu = "Menu de Seleció de Llistes de Qualificacions per Twitter";

        String[] opcions = new String[] {"\nTipus de llistas de qualificacions:"
                + "\n" + utilitatsString.repetirChar("-", 35)
                + "\n1 - Llista d'eliminats"
                + "\n2 - Llista de concursants actius"
                + "\n3 - Tornar al menu anterior"
                + "\n4 - Tornar al menu d'inici"};

        opcio = utilitatsMenu.imprimirMenu(titolMenu, opcions);

        switch (opcio) {
            case 1:
            // Lleva a ListaCualifTwElim
            case 2:
            // Lleva a ListaCualifTwActiv
            case 3:
                metodeGestioInscripcions();
            case 4:
                metodeSeleccioGestio();
        }
    }
}
