package flightteamfour;

import java.util.Scanner;

/**
 *
 * @author Tony & Ian
 */
public class FlightTeamFour {

    private static Scanner in = new Scanner(System.in);

    public int ronde = 1; // Aantal rondes - max 8.
    public int geld = 0; // Geld wat de speler per ronde krijgt.

   
    
    public static void start() {
        
        
        Vliegveld Amsterdam = new Vliegveld(Math.random() * 1000 + 35, Math.random() * 300);
        Vliegveld Parijs    = new Vliegveld(Math.random() * 1000 + 35, Math.random() * 300);
        Vliegveld Berlijn   = new Vliegveld(Math.random() * 1000 + 35, Math.random() * 300);
        Vliegveld LosAngeles= new Vliegveld(Math.random() * 1000 + 35, Math.random() * 300);
        Vliegveld NewYork   = new Vliegveld(Math.random() * 1000 + 35, Math.random() * 300);
        Vliegveld Londen    = new Vliegveld(Math.random() * 1000 + 35, Math.random() * 300);
        Vliegveld Dubai     = new Vliegveld(Math.random() * 3000 + 35, Math.random() * 300);
        
        Vliegtuig Boeing737 = new Vliegtuig(300, 1000, 500);
        Vliegtuig Boeing747 = new Vliegtuig(450, 1200, 700);
        Vliegtuig Boeing777 = new Vliegtuig(600, 1800, 1000);
        Vliegtuig Airbus380 = new Vliegtuig(700, 3000, 2000);
        Vliegtuig ITyet     = new Vliegtuig(1000, 5000, 4000);
        
        
        
        
       
        
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
