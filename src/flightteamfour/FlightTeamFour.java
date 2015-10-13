package flightteamfour;


import java.util.Scanner;

/**
 *
 * @author Tony & Ian
 */

public class FlightTeamFour {
    
    
    
    public double score = 0; // Score wat de speler kan behalen.
    public int ronde = 1; // Aantal rondes - max 8.
    public double geld = 0; // Geld wat de speler per ronde krijgt.
    
    public static void nieuweRonde(){
        
        
    }
    
    public static void vluchtInplanenn(){
        
        
    }
    
    public static void menu(){
        
        System.out.println("|           Menu:             |");
        System.out.println("|-----------------------------|");
        System.out.println("| 1.) Speluitleg              |");
        System.out.println("| 2.) Start                   |");
        System.out.println("| 3.) Score                   |");
        System.out.println("| 4.) Exit                    |");
        System.out.println("|                         v1.0|");
        System.out.println("-------------------------------");
        System.out.print("option: ");
    }
    
    public static void spelUitleg(){
        
         System.out.println("\t# Het is een spel gebaseerd op rondes. \n "
         + "\t# Elke ronde staan er op verschillende vliegvelden mensen of vracht te wachten met een bestemming.\n "
         + "\t# Afhankelijk van de beschikbare vliegtuigen op dat vliegveld en hun capaciteit kan er een vlucht gepland worden naar een nieuwe bestemming.\n "
         + "\t# Elk vliegtuig mag maximaal 1 vlucht maken per ronde.\n "
         + "\t# Ook zijn er vrachtvliegtuigen, en kan er vracht vervoerd worden.\n "
         + "\t# Het is niet mogelijk om en passagiers en vracht in hetzelfde vliegtuig te vervoeren. \n\n");
            
        System.out.println("\t# Elke nieuwe ronde zal jouw score bijgehouden worden. Door dit op te vragen klik je op menu optie 3.");
        System.out.println("\t# Elke rond begin je met geld, de bedoeling is om uiteindelijk zoveel mogelijk winst te maken.");
        System.out.println("\t# Aan het eind van de ronde word op basis van jou winst de score bijgehouden, hoe meer winst hoe meer score punten het opleverd.");
        System.out.println("Klik 6 om terug te keren naar het menu");
        
        
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in); // Input van de speler
        
        boolean running = true;
        
        System.out.println("\t#    Welkom bij het FlightFourTeam spel!\t# \n");
        System.out.println("\t# Jouw doel om zoveel mogelijk winst te maken\t# \n");
        
        
       menu();
        
        while(running){
        
        
            
        if(in.next().equals("1")){
           spelUitleg();
        if(in.next().equals("6")){
            menu();
        }if(!in.next().equals("6")){
            System.out.println("Wrong input, please try again.");
            
                }
            }
        }
            
            
        running = false;
            
        while(running){
            
        }
    }
}


            
        
    
    

