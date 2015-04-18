package EAC5;

import EAC5.interficie.*;
import java.util.ArrayList;

/**
 *
 * @author Bea, Roberto i Joan
 */
public class classePrincipal {

    public static ArrayList<ArrayList<String>> llista;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //INSTÀNCIES (OBJECTES)
        Pantallas objectePantalla = new Pantallas();
        classeMenus objecteMenu = new classeMenus();
        
        //INVOCACIÓ MÈTODES
        objectePantalla.metodeMisatgeBenvinguda();
        objecteMenu.metodeSeleccioGestio();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
         //Creem llista dels concursants.
         ArrayList<ArrayList<String>> llistaInicial = objecteLlista.metodeEscriureLlista();

         //Comprovar la llista inicial per si hi ha DNIs repetits.
         objecteLlista.metodeSiDniEstaRepetit(llistaInicial);

         //Mostrar la llista inicial.
         objecteLlista.metodeMostrarLlista(llistaInicial, "LLISTA INICIAL DE JUGADORS");

         //Modificar dada/es i guardar els canvis en una nova llista.
         ArrayList<ArrayList<String>> llistaModificada = objecteLlista.metodeModificarLlista(llistaInicial);

         //Ordenar la llista modificada pel DNI i guardar-la dins la llista ordenada
         ArrayList<ArrayList<String>> llistaOrdenada = objecteLlista.metodeOrdenarLlista(llistaModificada);

         //Guardar la llista ordenada dins la llista Final
         llistaFinal = objecteLlista.metodeGuardarLlista(llistaOrdenada);

         //Mostrar la llista final
         objecteLlista.metodeMostrarLlista(llistaFinal, "LLISTA FINAL DE JUGADORS GUARDADA");
         */
    }

}
