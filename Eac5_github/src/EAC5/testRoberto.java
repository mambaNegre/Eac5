package EAC5;

import EAC5.concursants.*;
import EAC5.interficie.*;
import EAC5.utilitats.*;
import java.util.ArrayList;

public class testRoberto {
    public final static String[] MENU_PRINCIPAL = {"GESTIÓ D'INSCRIPCIONS", "GESTIÓ DE QUALIFICACIONS", "SORTIR"};
    public final static String[] MENU_INSCRIPCIONS = {"INSCRIURE CONCURSANT", "MODIFICAR DADES CONCURSANT", "LLISTAR CONCURSANTS", "< TORNAR"};
    public final static String[] MENU_QUALIFICACIONS = {"INICIAR CONCURS", "PUNTUAR RONDA", "LLISTAR QUALIFICACIONS RONDA", "FINALITZAR RONDA", "LLISTAR QUALIFICACIONS TWITTER", "< TORNAR"};
    public final static int PUNTS = 0;
    public final static int INDEX_PUNTS = 1;
    
    public static void main(String args[]) {
        testRoberto programa = new testRoberto();
        programa.inici();
    }
    
    public void inici() {
        int opcio = 0;
        int op_ins;
        int op_qual;
        classeLlistaConcursants llistaConcursants = new classeLlistaConcursants();
        ArrayList<ArrayList<String>> concursants = null;
        GestioQualificacions qualificacions = new GestioQualificacions();
        int[][] puntuacions = new int[15][2];
        int zonaEliminats = 0;
        
        do {
            if (opcio == 0) {
                opcio = UtilitatsMenu.imprimirMenu("MENÚ PRINCIPAL", MENU_PRINCIPAL);
            }
            switch (opcio) {
                case 1:
                    //GESTIO INSCRIPCIONS
                    op_ins = UtilitatsMenu.imprimirMenu("MENÚ PER GESTIONAR INSCRIPCIONS", MENU_INSCRIPCIONS);
                    
                    switch (op_ins) {
                        case 1:
                            //Inscriure concursant
                            concursants = llistaConcursants.metodeEscriureLlista();
                            puntuacions = new int[concursants.size()][2];
                            break;
                        case 2:
                            //Modificar concursant
                            llistaConcursants.metodeModificarLlista(concursants);
                            break;
                        case 3:
                            //Mostrar llista
                            llistaConcursants.metodeMostrarLlista(concursants, "LLISTA DE CONCURSANTS");
                            break;
                        case 4:
                            opcio = 0;
                    }
                    break;
                case 2:
                    //GESTIO QUALIFICACIONS
                    op_qual = UtilitatsMenu.imprimirMenu("MENÚ PER GESTIONAR QUALIFICACIONS", MENU_QUALIFICACIONS);
                    
                    switch (op_qual) {
                        case 1:
                            //Iniciar concurs
                            puntuacions = qualificacions.iniciarConcurs(puntuacions);
                            
                            break;
                        case 2:
                            //Puntuar una ronda
                            qualificacions.puntuarRonda(concursants, puntuacions, zonaEliminats);
                            break;
                        case 3:
                            //Llista qualificacions ronda
                            qualificacions.llistarQualificacionsRonda(concursants, puntuacions, zonaEliminats);
                            break;
                        case 4:
                            //Finalitzar ronda
                            zonaEliminats = qualificacions.finalitzarRonda(puntuacions, zonaEliminats);
                            break;
                        case 5:
                            //Llista qualificacions Twitter
                            qualificacions.llistarQualificacionsTwitter(concursants, puntuacions, zonaEliminats);
                            break;
                        case 6:
                            opcio = 0;
                    }
                break;
            }
        } while ( opcio != MENU_PRINCIPAL.length );
    }
}