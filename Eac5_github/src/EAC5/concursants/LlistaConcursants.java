package EAC5.concursants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import EAC5.utilitats.*;
import static EAC5.utilitats.GestioQualificacions.COGNOMS;
import static EAC5.utilitats.GestioQualificacions.DNI;
import static EAC5.utilitats.GestioQualificacions.NOM;
import static EAC5.utilitats.GestioQualificacions.TELEFON;

public class LlistaConcursants {

    /**
     * El mètode escriureLlista permet escriure les dades dels concursants i les 
     * guarda en una llista.
     * @return Una llista de dades
     */
    public ArrayList<ArrayList<String>> escriureLlista() {

        int numJugadors = 15;
        String mesJudadors = "s";

        //INSTÀNCIES (objectes de les diferents classe)
        Scanner S = new Scanner(System.in);
        DadesConcursants objPart = new DadesConcursants();
        ArrayList<ArrayList<String>> concursants = new ArrayList<>();

        for (int i = 0; i < numJugadors && !mesJudadors.equals("NO"); i++) {

            //Creem una nova fila per a cada jugador.
            concursants.add(new ArrayList<>());

            //Creem les columnes cridant als mètodes de la classeDades;
            concursants.get(i).add(objPart.escriureDni());
            concursants.get(i).add(objPart.escriureNom());
            concursants.get(i).add(objPart.escriureCognoms());
            concursants.get(i).add(objPart.escriureTelefon());

            System.out.print("\nVols inscriure més jugadors? (Si/No): ");
            mesJudadors = S.nextLine();
            mesJudadors = mesJudadors.toUpperCase();//mètode per no fer diferència entre majúscules o minúscules
        }

        return concursants;
    }

    /**
     * El mètode siDniEstaRepetit permet saber si hi ha un DNI repetir a la llista
     * i si és així modificar-lo
     * @param concursants La llista que rep
     */
    public void siDniEstaRepetit(ArrayList<ArrayList<String>> concursants) {
        boolean trobat = false;
        String dniCanviat;
        int posicio;

        Scanner S = new Scanner(System.in);

        for (int i = 1; i < concursants.size(); i++) {
            for (int j = 1; j < concursants.size() && i >= j && !trobat; j++) {

                if (concursants.get(i).get(0).equals(concursants.get(i - j).get(0))) {
                    System.out.println("\n\t¡¡¡¡ATENCIÓ!!!! A LA LLISTA HI HA ALMENYS UN DNI REPETIT.");
                    System.out.println("\n\tA la posicio " + (i + 1) + " i a la " + ((i - j) + 1));
                    trobat = true;

                    mostrarLlista(concursants, "LLISTA");

                    System.out.print("\nEscriu la posició del Dni repetit que vols canviar: ");
                    posicio = S.nextInt();

                    if (posicio == (i + 1)) {
                        DadesConcursants objecte = new DadesConcursants();
                        dniCanviat = objecte.escriureDni();
                        concursants.get(i).set(0, dniCanviat);

                    } else {
                        DadesConcursants objecte = new DadesConcursants();
                        dniCanviat = objecte.escriureDni();
                        concursants.get(i - j).set(0, dniCanviat);
                    }

                    siDniEstaRepetit(concursants);
                }
            }
        }
    }

    /**
     * El mètode modificarLlista permet modificar les dades de la llista
     * @param concursants Una llista
     * @return Una llista ja modificada
     */
    public ArrayList<ArrayList<String>> modificarLlista(ArrayList<ArrayList<String>> concursants) {

        String dadaAModificar;
        String dadaNova = null;
        String canviarDada = null;
        String seguirCanviant = null;
        boolean dadaTrobada = false;

        Scanner S = new Scanner(System.in);

        System.out.print("\nVols canviar alguna dada dels jugadors? (Si/No): ");
        canviarDada = S.nextLine();
        canviarDada = canviarDada.toUpperCase();//mètode per no fer diferència entre majúscules o minúscules

        if (!canviarDada.equals("NO")) {

            do {

                System.out.print("\nQuina dada vols modificar? ");
                dadaAModificar = S.nextLine();
                dadaTrobada = false;

                for (int i = 0; i < concursants.size() && !dadaTrobada; i++) {
                    for (int j = 0; j < concursants.get(i).size() && !dadaTrobada; j++) {

                        if (concursants.get(i).get(j).equals(dadaAModificar)) {

                            if (j == 0) {
                                System.out.print("Canvia el dni. ");
                                DadesConcursants objecte = new DadesConcursants();
                                dadaNova = objecte.escriureDni();
                                concursants.get(i).set(j, dadaNova);
                                dadaTrobada = true;
                                System.out.println("\n\tDni canviat");

                            } else if (j == 1) {
                                System.out.print("La dada està a la llista. ");
                                System.out.print("Escriu la nova dada: ");
                                dadaNova = S.nextLine();

                                concursants.get(i).set(j, dadaNova);
                                dadaTrobada = true;
                                System.out.println("\n\tNom canviat");

                            } else if (j == 2) {
                                System.out.print("La dada està a la llista. ");
                                System.out.print("Escriu la nova dada: ");
                                dadaNova = S.nextLine();

                                concursants.get(i).set(j, dadaNova);
                                dadaTrobada = true;
                                System.out.println("\n\tCognoms canviats");

                            } else {
                                System.out.print("La dada està a la llista. ");
                                System.out.print("Escriu la nova dada: ");
                                dadaNova = S.nextLine();

                                concursants.get(i).set(j, dadaNova);
                                dadaTrobada = true;
                                System.out.println("\n\tTelèfon canviat");
                            }

                        } else {
                            dadaTrobada = false;
                        }
                    }
                }

                if (!dadaTrobada) {
                    System.out.println("\n\tLa dada que vols canviar no està a la llista");
                }

                System.out.print("\nVols canviar alguna dada més? (Si/No): ");
                seguirCanviant = S.nextLine();
                seguirCanviant = seguirCanviant.toUpperCase();//mètode per no fer diferència entre majúscules o minúscules    

            } while (!seguirCanviant.equals("NO"));

        } else {
            System.out.println("\n\tLa llista de jugadors s'ha guardat");
        }

        return concursants;
    }

    /**
     * El mètode ordenarLlista permet ordenar la llista segons els DNI  i la 
     * ordena de manera ascendent
     * @param concursants Una llista per ordenar
     * @return Un llista ordenada
     */
    public ArrayList<ArrayList<String>> ordenarLlista(ArrayList<ArrayList<String>> concursants) {

        Collections.sort(concursants, (ArrayList<String> o1, ArrayList<String> o2) -> o1.get(0).compareTo(o2.get(0)));

        return concursants;
    }

    /**
     * El mètode mostrarLlista permet mostrar la llista dels concurants d'una 
     * forma tabulada.
     * @param concursants Una llista
     * @param missatge És el títol que portarà la llista.
     */
    public void mostrarLlista(ArrayList<ArrayList<String>> concursants, String missatge) {
        UtilitatsString objecteUtil = new UtilitatsString();

        System.out.println();
        System.out.println(missatge + "\n" + objecteUtil.repetirChar("-", 21));

        for (int i = 0; i < concursants.size(); i++) {
            String dni = UtilitatsString.formatCadena(concursants.get(i).get(DNI), 15, ' ', 1);
            String nom = UtilitatsString.formatCadena(concursants.get(i).get(NOM), 15, ' ', 1);
            String cognoms = UtilitatsString.formatCadena(concursants.get(i).get(COGNOMS), 25, ' ', 1); 
            String telefon = UtilitatsString.formatCadena(concursants.get(i).get(TELEFON), 15, ' ', 1); 
            
            System.out.println(dni + nom + cognoms + telefon);
        }
    }
    
    public void mostrarLlistaTwitter(ArrayList<ArrayList<String>> concursants, String missatge) {
        Collections.sort(concursants, (ArrayList<String> o1, ArrayList<String> o2) -> o1.get(2).compareTo(o2.get(2)));
        UtilitatsString objecteUtil = new UtilitatsString();

        System.out.println();
        System.out.println(missatge + "\n" + objecteUtil.repetirChar("-", 38));

        for (int i = 0; i < concursants.size(); i++) {
            String nom = UtilitatsString.formatCadena(concursants.get(i).get(NOM), 15, ' ', 1);
            String cognoms = UtilitatsString.formatCadena(concursants.get(i).get(COGNOMS), 23, ' ', 1);
            
            System.out.println(nom + cognoms);
        }
    }

    /**
     *
     * @param llistaJugadors
     * @return
     */
    public ArrayList<ArrayList<String>> guardarLlista(ArrayList<ArrayList<String>> llistaJugadors) {
        return llistaJugadors;
    }

}
