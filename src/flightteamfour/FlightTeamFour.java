package flightteamfour;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tony & Ian
 */
public class FlightTeamFour {

    public static Scanner in = new Scanner(System.in);

    public int ronde = 1; // Aantal rondes - max 8.
    public static int geld = 900000; // Geld wat de speler per ronde krijgt.

    public static ArrayList<Vliegtuig> vliegtuigen = new ArrayList<Vliegtuig>();
    public static ArrayList<Vliegveld> vliegvelden = new ArrayList<Vliegveld>();
    public static ArrayList<PassiersGroep> passiers = new ArrayList<PassiersGroep>();

    public static void start() {

        //Voorbereidingen
        vliegvelden.add(new Vliegveld("AMS", Math.random() * 300, 52.308333, 4.760833));//Amsterdam
        vliegvelden.add(new Vliegveld("LAX", Math.random() * 300, 33.9425, -118.408056));//Los angeles
        vliegvelden.add(new Vliegveld("PAR", Math.random() * 300, 49.013611, 2.557778));// parijs
        vliegvelden.add(new Vliegveld("SXF", Math.random() * 300, 52.38, 13.5225));// Berlijn
        vliegvelden.add(new Vliegveld("JFK", Math.random() * 300, 40.639722, -73.778889));//new York
        vliegvelden.add(new Vliegveld("LHR", Math.random() * 300, 51.4775, -0.461389)); //Londen

        randomPassiers();

        vliegtuigen.add(new PassiersVliegtuig("Boeing737", 300, 1000, 500));
        vliegtuigen.add(new PassiersVliegtuig("Boeing747", 450, 1200, 700));
        vliegtuigen.add(new PassiersVliegtuig("Boeing777", 600, 1800, 1000));
        vliegtuigen.add(new PassiersVliegtuig("Airbus380", 700, 3000, 2000));
        vliegtuigen.add(new VrachtVliegtuig("ITyet", 1000, 5000, 4000));

        for (Vliegtuig vliegtuig : vliegtuigen) {
            System.out.print(vliegtuig.getName());
            vliegtuig.setVliegveld(vliegvelden.get((int) (Math.random() * vliegvelden.size())));//Neerzetten op random vliegveld om te beginnen
            System.out.println(" staat op " + vliegtuig.getVliegveld().getName());
        }

        System.out.println("\t       |           Menu:             |");
        System.out.println("\t       |-----------------------------|");
        System.out.println("\t       | 1.) Vliegtuig kopen         |");
        System.out.println("\t       | 2.) Vluchten inplannen      |");
        System.out.println("\t       | 3. Exit                     |");
        System.out.println("\t       |                         v1.0|");
        System.out.println("\t       -------------------------------");
        System.out.print("option: ");

        boolean running = true;
        while (running) {
            if (in.hasNextInt()) {

                int selection = in.nextInt();

                switch (selection) {

                    case 1:
                        Vliegtuig.vliegtuigKopen();     // Speluitleg
                        break;
                    case 2:
                        // Start game
                        vluchtInplanen();
                        break;
                    case 3:
                        running = false; // Sluit het spel af
                        break;
                    default:
                        System.out.println("Please enter a valid selection");
                        break;

                }
            }

            in.nextLine();
        }
    }

    public static void vluchtInplanen() {

        System.out.println("\t       |       Vlucht inplannen:     |");

        System.out.println("\t       |-----------------------------|");
        for (int i = 0; i < vliegtuigen.size(); i++) {
            Vliegtuig vliegtuig = vliegtuigen.get(i);
            if (vliegtuig.getVlucht() == null) {
                System.out.println("\t       | " + (i + 1) + ".) " + vliegtuig.getName() + " staat op " + vliegtuig.getVliegveld().getName() + " |");
            }

        }
        System.out.print("option: ");

        boolean running = true;
        while (running) {

            if (in.hasNextInt()) {
                int keuze = in.nextInt() - 1;
                if (keuze < vliegvelden.size()) {
                    Vliegtuig vliegtuig = vliegtuigen.get(keuze);
                    ArrayList<PassiersGroep> passiersGroepen = vliegtuig.getVliegveld().getPassiersGroep();

                    System.out.println("\t       |       Kies bestemming:     |");
                    for (int i = 0; i < passiersGroepen.size(); i++) {
                        PassiersGroep passiersGroep = passiersGroepen.get(i);
                        System.out.println((i + 1) + ".) " + vliegtuig.getVliegveld().getName() + " naar " + passiersGroep.bestemming.getName() + " gaan " + passiersGroep.passagiers + " passagiers");                   
                    }
                    if (in.hasNextInt()) {
                            int vluchtKeuzen = in.nextInt();
                            if (vluchtKeuzen < passiersGroepen.size()) {
                                PassiersGroep passiersGroep = passiersGroepen.get(vluchtKeuzen - 1);
                                vliegtuig.setVlucht(new Vlucht(vliegtuig.getVliegveld(), passiersGroep.getBestemming()));
                                running = false;
                            }
                        }
                }
            } else {
                System.out.println("Please enter a valid selection");

                in.nextLine();
            }

        }

    }

    public static void menu() {

        System.out.println("\t       |           Menu:             |");
        System.out.println("\t       |-----------------------------|");
        System.out.println("\t       | 1.) Speluitleg              |");
        System.out.println("\t       | 2.) Start                   |");
        System.out.println("\t       | 3. Exit                     |");
        System.out.println("\t       |                         v1.0|");
        System.out.println("\t       -------------------------------");
        System.out.print("option: ");

    }

    public static void spelUitleg() {   //SpelUitleg Methode 

        System.out.println("\t# Het is een spel gebaseerd op rondes. \n "
                + "\t# Elke ronde staan er op verschillende vliegvelden mensen of vracht te wachten met een bestemming.\n "
                + "\t# Afhankelijk van de beschikbare vliegtuigen op dat vliegveld en hun capaciteit kan er een vlucht gepland worden naar een nieuwe bestemming.\n "
                + "\t# Elk vliegtuig mag maximaal 1 vlucht maken per ronde.\n "
                + "\t# Ook zijn er vrachtvliegtuigen, en kan er vracht vervoerd worden.\n "
                + "\t# Het is niet mogelijk om en passagiers en vracht in hetzelfde vliegtuig te vervoeren. \n\n");

        System.out.println("\t# Elke rond begin je met geld, de bedoeling is om uiteindelijk zoveel mogelijk winst te maken.");
        System.out.println("\t# Door jou winst is het ook mogelijk om een nieuw vliegtuig te kopen.\n");

        System.out.print("Klik 6 om terug te keren naar het menu: \n");

        boolean running = true;
        while (running) {

            if (in.hasNextInt() && in.nextInt() == 6) {
                running = false;
                menu();
                return;
            } else {
                System.out.println("Please enter a valid selection");

                in.nextLine();
            }

        }
    }

    public static void main(String[] args) {

        Vliegtuig vliegobj = new Vliegtuig();

        boolean running = true;

        //Begin scherm
        System.out.println("\t#    Welkom bij het FlightFourTeam spel!\t#| ");
        System.out.println("\t  -----------------------------------------");
        System.out.println("\t# Jouw doel om zoveel mogelijk winst te maken\t# \n");

        //Start Menu
        menu();
        display:
        while (running) {
            if (in.hasNextInt()) {

                int selection = in.nextInt();

                switch (selection) {

                    case 1:
                        spelUitleg();     // Speluitleg
                        break;
                    case 2:
                        // Start game
                        start();
                        break;
                    case 3:
                        running = false; // Sluit het spel af
                        break;
                    default:
                        System.out.println("Please enter a valid selection");
                        break;

                }
            }

            in.nextLine();
        }

    }

    private static void randomPassiers() {
        for (Vliegveld vliegveld : vliegvelden) {
            vliegveld.random();
        }
    }
}
