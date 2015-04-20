package EAC5.concursants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import EAC5.utilitats.*;

/**
 *
 * @author joan
 */
public class LlistaConcursants {

    /**
     *
     * @return matriuJugadors
     */
    public ArrayList<ArrayList<String>> escriureLlista() {

        int numJugadors = 15;
        String mesJudadors = "s";

        //INSTÀNCIES (objectes de les diferents classe)
        Scanner S = new Scanner(System.in);
        DadesConcursants objPart = new DadesConcursants();
        ArrayList<ArrayList<String>> llistaJugadors = new ArrayList<>();

        for (int i = 0; i < numJugadors && !mesJudadors.equals("NO"); i++) {

            //Creem una nova fila per a cada jugador.
            llistaJugadors.add(new ArrayList<>());

            //Creem les columnes cridant als mètodes de la classeDades;
            llistaJugadors.get(i).add(objPart.escriureDni());
            llistaJugadors.get(i).add(objPart.escriureNom());
            llistaJugadors.get(i).add(objPart.escriureCognoms());
            llistaJugadors.get(i).add(objPart.escriureTelefon());

            System.out.print("\nVols escriure més jugadors? (Si/No): ");
            mesJudadors = S.nextLine();
            mesJudadors = mesJudadors.toUpperCase();//mètode per no fer diferència entre majúscules o minúscules
        }

        return llistaJugadors;
    }

    /**
     *
     * @param llistaJugadors
     */
    public void siDniEstaRepetit(ArrayList<ArrayList<String>> llistaJugadors) {
        boolean trobat = false;
        String dniCanviat;
        int posicio;

        Scanner S = new Scanner(System.in);

        for (int i = 1; i < llistaJugadors.size(); i++) {
            for (int j = 1; j < llistaJugadors.size() && i >= j && !trobat; j++) {

                if (llistaJugadors.get(i).get(0).equals(llistaJugadors.get(i - j).get(0))) {
                    System.out.println("\n\t¡¡¡¡ATENCIÓ!!!! A LA LLISTA HI HA ALMENYS UN DNI REPETIT.");
                    System.out.println("\n\tA la posicio " + (i + 1) + " i a la " + ((i - j) + 1));
                    trobat = true;

                    mostrarLlista(llistaJugadors, "LLISTA");

                    System.out.print("\nEscriu la posició del Dni repetit que vols canviar: ");
                    posicio = S.nextInt();

                    if (posicio == (i + 1)) {
                        DadesConcursants objecte = new DadesConcursants();
                        dniCanviat = objecte.escriureDni();
                        llistaJugadors.get(i).set(0, dniCanviat);

                    } else {
                        DadesConcursants objecte = new DadesConcursants();
                        dniCanviat = objecte.escriureDni();
                        llistaJugadors.get(i - j).set(0, dniCanviat);
                    }

                    siDniEstaRepetit(llistaJugadors);
                }
            }
        }
    }

    /**
     *
     * @param llistaJugadors
     * @return
     */
    public ArrayList<ArrayList<String>> modificarLlista(ArrayList<ArrayList<String>> llistaJugadors) {

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

                for (int i = 0; i < llistaJugadors.size() && !dadaTrobada; i++) {
                    for (int j = 0; j < llistaJugadors.get(i).size() && !dadaTrobada; j++) {

                        if (llistaJugadors.get(i).get(j).equals(dadaAModificar)) {

                            if (j == 0) {
                                System.out.print("Canvia el dni. ");
                                DadesConcursants objecte = new DadesConcursants();
                                dadaNova = objecte.escriureDni();
                                llistaJugadors.get(i).set(j, dadaNova);
                                dadaTrobada = true;
                                System.out.println("\n\tDni canviat");

                            } else if (j == 1) {
                                System.out.print("La dada està a la llista. ");
                                System.out.print("Escriu la nova dada: ");
                                dadaNova = S.nextLine();

                                llistaJugadors.get(i).set(j, dadaNova);
                                dadaTrobada = true;
                                System.out.println("\n\tNom canviat");

                            } else if (j == 2) {
                                System.out.print("La dada està a la llista. ");
                                System.out.print("Escriu la nova dada: ");
                                dadaNova = S.nextLine();

                                llistaJugadors.get(i).set(j, dadaNova);
                                dadaTrobada = true;
                                System.out.println("\n\tCognoms canviats");

                            } else {
                                System.out.print("La dada està a la llista. ");
                                System.out.print("Escriu la nova dada: ");
                                dadaNova = S.nextLine();

                                llistaJugadors.get(i).set(j, dadaNova);
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

        return llistaJugadors;
    }

    /**
     *
     * @param llistaJugadors
     * @return
     */
    public ArrayList<ArrayList<String>> ordenarLlista(ArrayList<ArrayList<String>> llistaJugadors) {

        Collections.sort(llistaJugadors, (ArrayList<String> o1, ArrayList<String> o2) -> o1.get(0).compareTo(o2.get(0)));

        return llistaJugadors;
    }

    /**
     *
     * @param llistaJugadors
     * @param missatge
     */
    public void mostrarLlista(ArrayList<ArrayList<String>> llistaJugadors, String missatge) {
        UtilitatsString objecteUtil = new UtilitatsString();
        
        System.out.println();
        System.out.println(missatge + "\n" + objecteUtil.repetirChar("-", 21));

        for (int i = 0; i < llistaJugadors.size(); i++) {
            for (int j = 0; j < llistaJugadors.get(i).size(); j++) {

                System.out.print(llistaJugadors.get(i).get(j) + "        ");
            }
            System.out.println();
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
