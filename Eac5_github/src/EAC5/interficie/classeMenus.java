package EAC5.interficie;

import EAC5.utilitats.*;
import java.util.ArrayList;
import EAC5.concursants.*;
import EAC5.classePrincipal;

/**
 *
 * @author Bea
 */
public class classeMenus {

    classeUtilitats objecteUtilitats = new classeUtilitats();
    classeLlistaConcursants objecteLlista = new classeLlistaConcursants();

    ArrayList<ArrayList<String>> llista;

    /**
     *
     */
    public void metodeMisatgeBenvinguda() {

        System.out.println("Benvingut al programa per gestionar concursants"
                + " del programa de radio 'NOMBRE'");
        System.out.println(objecteUtilitats.metodeRepetirChar("=", 80));
        System.out.println(objecteUtilitats.metodeRepetirChar("=", 80));
        

    }

    /**
     *
     */
    public void metodeSeleccioGestio() {

        int opcio;

        System.out.println("\nOpcions de gestió del concurs:"
                + "\n" + objecteUtilitats.metodeRepetirChar("-", 30)
                + "\n1 - Inscripció i gestió dels concursants"
                + "\n2 - Gestió de qualificacions"
                + "\n3 - Sortir del Programa");

        opcio = objecteUtilitats.metodeTriarOpcio("\nSeleccioneu l'opció desitjada: ", 1, 3);

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

        System.out.println("\nOpcions disponibles per a la gestió de concursants:"
                + "\n" + objecteUtilitats.metodeRepetirChar("-", 51)
                + "\n1 - Inscripció de concursants"
                + "\n2 - Modificació de dades dels concursants"
                + "\n3 - Llistes de concursants"
                + "\n4 - Torna al menu anterior");

        opcio = objecteUtilitats.metodeTriarOpcio("\nSeleccioneu l'opció desitjada: ", 1, 4);

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

        System.out.println("\nOpcions disponibles per a la gestió del concurs y les qualificacions:"
                + "\n" + objecteUtilitats.metodeRepetirChar("-", 69)
                + "\n1 - Iniciar el concurs"
                + "\n2 - Puntuar ronda"
                + "\n3 - Mostrar llista de qualificacions de la ronda"
                + "\n4 - Finalitzar ronda"
                + "\n5 - Mostrar llistas de qualificacions per Twitter"
                + "\n6 - Torna al menu anterior");

        opcio = objecteUtilitats.metodeTriarOpcio("\nSeleccioneu l'opció desitjada: ", 1, 6);

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

        System.out.println("\nModificació de dades dels concursants:"
                + "\n" + objecteUtilitats.metodeRepetirChar("-", 38)
                + "\n1 - Nom"
                + "\n2 - Cognoms"
                + "\n3 - Telèfon"
                + "\n4 - Tornar a la pantalla anterior"
                + "\n5 - Tornar al menu de gestio de concursants"
                + "\n6 - Tornar al menu d'inici");

        opcio = objecteUtilitats.metodeTriarOpcio("\nSeleccioneu l'opció desitjada: ", 1, 6);

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

        System.out.println("\nTipos de llistes de concursants:"
                + "\n" + objecteUtilitats.metodeRepetirChar("-", 32)
                + "\n1 - Llista de localització"
                + "\n2 - Llista per publicar a Twitter"
                + "\n3 - Tornar al menu anterior"
                + "\n4 - Tornar al menu d'inici");

        opcio = objecteUtilitats.metodeTriarOpcio("\nSeleccioneu la llista a mostrar: ", 1, 4);

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

        System.out.println("\nTipus de llistas de qualificacions:"
                + "\n" + objecteUtilitats.metodeRepetirChar("-", 35)
                + "\n1 - Llista d'eliminats"
                + "\n2 - Llista de concursants actius"
                + "\n3 - Tornar al menu anterior"
                + "\n4 - Tornar al menu d'inici");

        opcio = objecteUtilitats.metodeTriarOpcio("\nSeleccioneu la opció desitjada: ", 1, 4);

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
