package flightteamfour;

import java.util.Scanner;

/**
 *
 * @author Tony & Ian
 */
public class FlightTeamFour {

    private static Scanner in = new Scanner(System.in);

    public double score = 0; // Score wat de speler kan behalen.
    public int ronde = 1; // Aantal rondes - max 8.
    public double geld = 0; // Geld wat de speler per ronde krijgt.

    public static void nieuweRonde() {

    }

    public static void vluchtInplanenn() {

    }

    public static void menu() {

        System.out.println("\t       |           Menu:             |");
        System.out.println("\t       |-----------------------------|");
        System.out.println("\t       | 1.) Speluitleg              |");
        System.out.println("\t       | 2.) Start                   |");
        System.out.println("\t       | 3.) Score                   |");
        System.out.println("\t       | 4.) Highscore               |");
        System.out.println("\t       | 5.) Exit                    |");
        System.out.println("\t       |                         v1.0|");
        System.out.println("\t       -------------------------------");
        System.out.print("option: ");

    }

    public static void spelUitleg() {

        System.out.println("\t# Het is een spel gebaseerd op rondes. \n "
                + "\t# Elke ronde staan er op verschillende vliegvelden mensen of vracht te wachten met een bestemming.\n "
                + "\t# Afhankelijk van de beschikbare vliegtuigen op dat vliegveld en hun capaciteit kan er een vlucht gepland worden naar een nieuwe bestemming.\n "
                + "\t# Elk vliegtuig mag maximaal 1 vlucht maken per ronde.\n "
                + "\t# Ook zijn er vrachtvliegtuigen, en kan er vracht vervoerd worden.\n "
                + "\t# Het is niet mogelijk om en passagiers en vracht in hetzelfde vliegtuig te vervoeren. \n\n");

        System.out.println("\t# Elke nieuwe ronde zal jouw score bijgehouden worden. Door dit op te vragen klik je op menu optie 3.");
        System.out.println("\t# Elke rond begin je met geld, de bedoeling is om uiteindelijk zoveel mogelijk winst te maken.");
        System.out.println("\t# Aan het eind van de ronde word op basis van jou winst de score bijgehouden, hoe meer winst hoe meer score punten het opleverd./n");
        System.out.print("Klik 6 om terug te keren naar het menu: ");

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

        

        boolean running = true;

        //Begin scherm
        System.out.println("\t#    Welkom bij het FlightFourTeam spel!\t#| ");
        System.out.println("\t  -----------------------------------------");
        System.out.println("\t# Jouw doel om zoveel mogelijk winst te maken\t# \n");

        //Menu ALLEEN SPELUITLEG WERKT NU.
        menu();
        display:
        while (running) {
            if (in.hasNextInt()) {

                int selection = in.nextInt();
                        
                switch (selection) {

                    case 1:
                        spelUitleg();
                        break;
                    case 2:
                        // Start game
                        break;
                    case 3:
                        //Score
                        break;
                    case 4:
                        //highscore
                        break;
                    case 5:
                        running = false;
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
