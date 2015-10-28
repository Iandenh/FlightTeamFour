package flightteamfour;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tony & Ian
 */
public class FlightTeamFour {

    public static Scanner in = new Scanner(System.in);

    public static int ronde = 1; // Aantal rondes - max 8.
    public static double geld = 900000; // Geld wat de speler per ronde krijgt.

    public static ArrayList<Vliegtuig> vliegtuigen = new ArrayList<Vliegtuig>();
    public static ArrayList<Vliegveld> vliegvelden = new ArrayList<Vliegveld>();
    public static ArrayList<PassiersGroep> passiers = new ArrayList<PassiersGroep>();

    public static void start() {

        //Voorbereidingen
        
        vliegvelden.add(new Vliegveld("AMS", Math.random() * 300, 52.308333, 4.760833));   //Amsterdam
        vliegvelden.add(new Vliegveld("LAX", Math.random() * 300, 33.9425, -118.408056));  //Los angeles
        vliegvelden.add(new Vliegveld("PAR", Math.random() * 300, 49.013611, 2.557778));   //Parijs
        vliegvelden.add(new Vliegveld("SXF", Math.random() * 300, 52.38, 13.5225));        // Berlijn
        vliegvelden.add(new Vliegveld("JFK", Math.random() * 300, 40.639722, -73.778889)); //new York
        vliegvelden.add(new Vliegveld("LHR", Math.random() * 300, 51.4775, -0.461389));    //Londen

        randomPassiers();

        vliegtuigen.add(new PassiersVliegtuig("Boeing737", 300, 1000, 500));
        vliegtuigen.add(new PassiersVliegtuig("Boeing747", 450, 1200, 700));
        vliegtuigen.add(new PassiersVliegtuig("Boeing777", 600, 1800, 1000));
        vliegtuigen.add(new PassiersVliegtuig("Airbus380", 700, 3000, 2000));
        vliegtuigen.add(new VrachtVliegtuig  ("ITyet", 1000, 5000, 4000));
        vliegtuigen.add(new VrachtVliegtuig  ("An-225", 2000, 10000, 6000));
        vliegtuigen.add(new VrachtVliegtuig  ("Hercules", 2000, 10000, 6000));
        vliegtuigen.add(new VrachtVliegtuig  ("FTF200", 2000, 10000, 6000));

        for (Vliegtuig vliegtuig : vliegtuigen) {
            vliegtuig.setVliegveld(vliegvelden.get((int) (Math.random() * vliegvelden.size()))); //Neerzetten op random vliegveld om te beginnen
        }

        boolean running = true;
        while (running) {
            System.out.println("\t       | Menu:                        |");
            System.out.println("\t       | Ronde --> " + "[" +ronde+"]                |");
            System.out.println("\t       |------------------------------|");
            System.out.println("\t       | 1.).......Vliegtuig kopen    |");
            System.out.println("\t       | 2.).......Vluchten inplannen |");
            System.out.println("\t       | 3.).......Vluchten uitvoeren |");
            System.out.println("\t       | 4.).......Bankzaken          |");
            System.out.println("\t       | 5.).......Terug              |");
            System.out.println("\t       |                              |");
            System.out.println("\t       |------------------------------|");
            System.out.print("option: ");
            if (in.hasNextInt()) {

                int selection = in.nextInt();

                switch (selection) {

                    case 1:
                        //Vliegtuigkopen
                        Vliegtuig.vliegtuigKopen();     
                        break;
                    case 2:
                        //Vluchtinplannen
                        vluchtInplanen();
                        break;
                    case 3:
                        //Vluchuitvoeren
                        for (Vliegtuig vliegtuig : vliegtuigen) {
                            vliegtuig.tanken();
                            vliegtuig.vliegen();
                        }
                        ronde++;
                        break;
                    case 4:
                        // bankzaken
                        System.out.println("----------------------------");
                        System.out.println("Je geld bedraagt: " + geld   );
                        System.out.println("----------------------------");
                        break;
                    case 5:
                        running = false; // Sluit het spel af
                        break;
                    default:
                        System.out.println("Enter een geldige optie");
                        in.nextLine();
                        break;

                }
            } else {
                System.out.println("Enter een geldige optie");
                in.nextLine();
            }

        }
    }

    public static void vluchtInplanen() {

        boolean running = true;
        while (running) {
            System.out.println("\t       |       Vlucht inplannen:     |");

            System.out.println("\t       |-----------------------------|");
            for (int i = 0; i < vliegtuigen.size(); i++) {
                Vliegtuig vliegtuig = vliegtuigen.get(i);
                if (vliegtuig.getVlucht() == null) {
                    System.out.println("\t        " + (i + 1) + ".) " + vliegtuig.getName() + " staat op " + vliegtuig.getVliegveld().getName() + " ");
                }

            }
            System.out.println("\t        e.) Terug     ");
            System.out.print("optie: ");

            if (in.hasNextInt()) {
                int keuze = in.nextInt() - 1;
                if (keuze < vliegtuigen.size()) {
                    Vliegtuig vliegtuig = vliegtuigen.get(keuze);
                     
                    if (vliegtuig instanceof PassiersVliegtuig) { //PassiersVliegtuig
                       ArrayList<PassiersGroep> passiersGroepen = vliegtuig.getVliegveld().getPassiersGroep();

                        System.out.println("\t       |       Kies bestemming:     |");
                        for (int i = 0; i < passiersGroepen.size(); i++) {
                            PassiersGroep passiersGroep = passiersGroepen.get(i);
                            System.out.println((i + 1) + ".) " + vliegtuig.getVliegveld().getName() + " naar " + passiersGroep.bestemming.getName() + " gaan " + passiersGroep.getPassagiers() + " passagiers");
                        }
                        if (in.hasNextInt()) {
                            int vluchtKeuzen = in.nextInt();
                            if (vluchtKeuzen <= passiersGroepen.size()) {
                                PassiersGroep passiersGroep = passiersGroepen.get(vluchtKeuzen - 1);
                                vliegtuig.setVlucht(new Vlucht(vliegtuig.getVliegveld(), passiersGroep.getBestemming(), passiersGroep.getPassagiers()));
                                System.out.println("Vlucht van: "+ vliegtuig.getVliegveld().getName()+ " naar " + 
                                        passiersGroep.getBestemming().getName()+ "met "+ 
                                        passiersGroep.getPassagiers()+ " passagiers" +
                                        "is ingepland"
                                );
                            }
                            
                        }
                    } else {//vracht

                        ArrayList<Vracht> Vrachtgroepen = vliegtuig.getVliegveld().getVrachtGroepen();

                        System.out.println("\t       |       Kies bestemming:     |");
                        for (int i = 0; i < (Vrachtgroepen.size()); i++) {
                            Vracht Vrachtgroep = Vrachtgroepen.get(i);
                            System.out.println((i + 1) + ".) " + vliegtuig.getVliegveld().getName() + " naar " + Vrachtgroep.bestemming.getName() + " gaan " + Vrachtgroep.getAantalVracht() + " kilo's");
                        }
                        if (in.hasNextInt()) {
                            int vluchtKeuzen = in.nextInt();
                            if (vluchtKeuzen <= Vrachtgroepen.size()) {
                                Vracht Vrachtgroep = Vrachtgroepen.get(vluchtKeuzen - 1);
                                vliegtuig.setVlucht(new Vlucht(vliegtuig.getVliegveld(), Vrachtgroep.getBestemming(), Vrachtgroep.getAantalVracht()));
                                System.out.println("Vlucht van: "+ vliegtuig.getVliegveld().getName()+ " naar " + 
                                        Vrachtgroep.getBestemming().getName()+ "met "+ 
                                        Vrachtgroep.getAantalVracht() + " kilo's" +
                                        "is ingepland"
                                );
                            }
                        }

                    }

                }
            } else {
                if (in.nextLine().equals("e")) {
                    running = false;
                } else {

                    System.out.println("Enter een geldige optie");

                }
            }

        }

    }

    public static void menu() {

        System.out.println("\t     |               Mainmenu:             |");
        System.out.println("\t     |-------------------------------------|");
        System.out.println("\t     |-------------------------------------|");
        System.out.println("\t     | 1.)..........Speluitleg             |");
        System.out.println("\t     | 2.)..........Start                  |");
        System.out.println("\t     | 3.)..........Exit                   |");
        System.out.println("\t     |                         v1.0        |");
        System.out.println("\t     |        Created by Ian & Tony        |");
        System.out.println("\t     |-------------------------------------|");
        System.out.print("optie: ");
        
        

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
                System.out.println("Enter een geldige optie");

                in.nextLine();
            }

        }
    }

    public static void main(String[] args) {

        boolean running = true;

        //Begin scherm
        System.out.println("\t#    Welkom bij het FlightFourTeam spel!\t#| ");
        System.out.println("\t  -----------------------------------------");
        System.out.println("\t# Jouw doel om zoveel mogelijk winst te maken\t# \n");

        //Start Menu
        while (running) {

            menu();
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
                        System.out.println("Enter een geldige optie");
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
