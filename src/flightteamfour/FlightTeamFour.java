package flightteamfour;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tony & Ian
 */
public class FlightTeamFour {

    private static Scanner in = new Scanner(System.in);

    public int ronde = 1; // Aantal rondes - max 8.
    public int geld = 0; // Geld wat de speler per ronde krijgt.

    public static ArrayList<Vliegtuig> vliegtuigen = new ArrayList<Vliegtuig>();
    public static ArrayList<Vliegveld> vliegvelden = new ArrayList<Vliegveld>();
    public static void start() {
        
        
        vliegvelden.add( new Vliegveld("AMS", Math.random() * 1000 + 35, Math.random() * 300));//Amsterdam
        vliegvelden.add( new Vliegveld("LAX", Math.random() * 1000 + 35, Math.random() * 300));//Los angeles
        vliegvelden.add( new Vliegveld("PAR", Math.random() * 1000 + 35, Math.random() * 300));// parijs
        vliegvelden.add( new Vliegveld("RTM", Math.random() * 1000 + 35, Math.random() * 300));// Rotterdam
        vliegvelden.add( new Vliegveld("SXF", Math.random() * 1000 + 35, Math.random() * 300));// Berlijn
        vliegvelden.add( new Vliegveld("JFK", Math.random() * 1000 + 35, Math.random() * 300));//new York
        vliegvelden.add( new Vliegveld("LCY", Math.random() * 3000 + 35, Math.random() * 300)); //Londen
        
        vliegtuigen.add(new Vliegtuig("Boeing737",300, 1000, 500));
        vliegtuigen.add(new Vliegtuig("Boeing747", 450, 1200, 700));
        vliegtuigen.add(new Vliegtuig("Boeing777", 600, 1800, 1000));
        vliegtuigen.add(new Vliegtuig("Airbus380", 700, 3000, 2000));
        vliegtuigen.add(new Vliegtuig("ITyet", 1000, 5000, 4000));
        
        for(Vliegtuig vliegtuig: vliegtuigen){
            System.out.println(vliegtuig.getName());
            vliegtuig.setVliegveld(vliegvelden.get((int) (Math.random()*vliegvelden.size())));//Neerzetten op random vliegveld om te beginnen
            System.out.println(vliegtuig.getVliegveld().getName());
        }
        
    }

    public static void vluchtInplanenn() {

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
            while(running){
            
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

}
