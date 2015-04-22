package EAC5;

import EAC5.concursants.*;
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
        LlistaConcursants llistaConcursants = new LlistaConcursants();
        DadesConcursants dadesConcursants = new DadesConcursants();
        ArrayList<ArrayList<String>> concursants = null;
        GestioQualificacions qualificacions = new GestioQualificacions();
        GestioConcursants gestioConcursants = new GestioConcursants();
        int[][] puntuacions = new int[15][2];
        int zonaEliminats = 0;

        concursants = provarInscripcioConcursants();
        concursants = llistaConcursants.ordenarLlista(concursants);
        puntuacions = new int[concursants.size()][2];

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
                            concursants = llistaConcursants.escriureLlista();
                            concursants = llistaConcursants.ordenarLlista(concursants);
                            puntuacions = new int[concursants.size()][2];
                            break;
                        case 2:
                            //Modificar concursant
                            boolean demanarDades = true;
                            String dni;
                            int pos = -1;
                            do {
                                dni = dadesConcursants.escriureDni();
                                if (dni.trim().length() == 0) {
                                    System.out.println("Modificació cancel·lada.");
                                    demanarDades = false;
                                } else {
                                    pos = gestioConcursants.trobarDNI(concursants, dni);
                                }
                            } while (pos == -1 && demanarDades);

                            if (pos != -1) {

                                String titol = "MENÚ PER MODIFICAR DADES DE CONCURSANTS";
                                titol += "\n";
                                titol += dni;
                                String nom = gestioConcursants.obtenirNom(concursants, pos);
                                String cognoms = gestioConcursants.obtenirCognoms(concursants, pos);
                                String telefon = gestioConcursants.obtenirTelefon(concursants, pos);
                                String[] menuModificacio = {nom, cognoms, telefon, "< TORNAR"};
                                int op_mod = UtilitatsMenu.imprimirMenu(titol, menuModificacio);
                                switch (op_mod) {
                                    case 1:
                                        concursants = gestioConcursants.modificarNom(concursants, pos);
                                        break;
                                    case 2:
                                        concursants = gestioConcursants.modificarCognoms(concursants, pos);
                                        break;
                                    case 3:
                                        concursants = gestioConcursants.modificarTelefon(concursants, pos);
                                        break;
                                }
                            }
                            break;
                        case 3:
                            //Mostrar llista
                            llistaConcursants.mostrarLlista(concursants, "LLISTA DE CONCURSANTS");
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
                            zonaEliminats = concursants.size();
                            break;
                        case 2:
                            //Puntuar una ronda
                            puntuacions = qualificacions.puntuarRonda(concursants, puntuacions, zonaEliminats);
                            puntuacions = qualificacions.actualitzarIndex(puntuacions);
                            break;
                        case 3:
                            //Llista qualificacions ronda
                            qualificacions.llistarQualificacionsRonda(concursants, puntuacions, zonaEliminats);
                            break;
                        case 4:
                            //Finalitzar ronda
                            zonaEliminats = qualificacions.finalitzarRonda(puntuacions, zonaEliminats);
                            System.out.println("ZonaEliminats: " + zonaEliminats);
                            break;
                        case 5:
                            //Llista qualificacions Twitter
                            qualificacions.llistarQualificacionsTwitter(concursants, puntuacions, zonaEliminats);
                            break;
                        case 6:
                            opcio = 0;
                    }
                case 3:
                    break;
            }
        } while (opcio != 3);
    }

    public ArrayList<ArrayList<String>> provarInscripcioConcursants() {
        ArrayList<ArrayList<String>> concursants = new ArrayList<>();
        String[][] dadesConcursants = new String[][]{
            {"34326006P", "Pep", "Rivera", "612 345 678"},
            {"49104186Z", "Marta", "Ramos", "937 555 444"},
            {"34326006R", "Paula", "Puyol", "910 111 222"},
            {"18039237S", "Antoni", "García Fernández", "981 000 999"},
            {"43213803T", "María", "Pérez Martínez", "666 666 666"},
            {"54248434X", "José Antonio", "Rodríguez Faro", "655 222 333"},
            {"21668843Z", "María Jesús", "López Ferández", "677 333 444"},
            {"51139573Q", "Pepe", "Martínez", "688 444 555"},
            {"54037105P", "Anna", "Messi", "699 555 666"},
            {"20105383W", "Pere", "Roca", "600 666 777"}
        };

        for (int i = 0; i < 10; i++) {
            //Creem una nova fila per a cada jugador.
            concursants.add(new ArrayList<>());

            //Creem les columnes cridant als mètodes de la classeDades;
            concursants.get(i).add(dadesConcursants[i][0]);
            concursants.get(i).add(dadesConcursants[i][1]);
            concursants.get(i).add(dadesConcursants[i][2]);
            concursants.get(i).add(dadesConcursants[i][3]);
        }

        return concursants;
    }
}