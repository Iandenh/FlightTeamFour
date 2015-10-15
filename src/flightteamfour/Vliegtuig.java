
package flightteamfour;

import java.util.Scanner;


public class Vliegtuig extends FlightTeamFour{
    
   
    public double maxPassagiers;
    public double maxVracht;
    public double fuelCapacity;
    
    
    Scanner in = new Scanner(System.in);
    
   Vliegtuig(){
       
   }
   
    Vliegtuig(double a, double b, double c){
        
       
        a = maxPassagiers; //number of people (MAX)
        b = maxVracht;     //KG vracht (Max)
        c = fuelCapacity;  //Liters 
    }
    
    
    public static void tanken(){
        
        
    }
    
    public static void vliegen(){
        
        
    }
    public void vliegtuigKopen(){
        
        System.out.println("               Hallo speler!");
        System.out.println("Hier is het mogelijk om een vliegtuig aan te schaffen.");
        System.out.println("Jou geld bedraagt: " + geld + "\n");
        
        System.out.println("Wat voor soort vliegtuig wilt u kopen?\n");
        System.out.println("------------------------------------------");
        System.out.println("1.)\t Passagiersvliegtuig");
        System.out.println("2.)\t Vrachtvliegtuig");
        System.out.println("3.)\t Terug naar het menu\n");
        
        System.out.print("Option: ");
        
        boolean running = true;
        while(running){
        
        if(in.hasNextInt() && in.nextInt() == 1){
            
            System.out.println("Je kan kiezen uit de volgende Passagiersvliegtuigen: ");
            System.out.println("1.) 7.000$    Jet5000     \t #De Jet5000 kan maar lieft 400 passagiers meenemen en heeft een 1000 Liter tank");
            System.out.println("2.) $15.000   SuperJet300 \t #De SuperJet300 kan maar liefst 500 passagiers meenemen en heeft een turbo motor.");
            System.out.println("3.) $20.000   Airbus5000  \t #De Airbus5000 heeft maar liefst ruimte voor 850 personen!\n");
            System.out.print("Option: ");
            
        }if(in.hasNextInt() && in.nextInt() == 1 && geld >= 7000){
                
     //if(geld >= 7000){
             
                System.out.println("Je hebt de Jet5000 gekocht");
                Vliegtuig Jet5000 = new Vliegtuig(400, 400, 1000);
                geld = geld - 7000;
                
        }else if(in.hasNextInt() && in.nextInt() == 1 && geld < 7000){
                    
                    System.out.println("Oops! Not enough money");
                
                }
                
            }if(in.hasNextInt() && in.nextInt() == 2){
            
            System.out.println("Je kan kiezen uit de volgende Vrachtvliegtuigen: ");
            System.out.println("1.) $7.000    FlySuper300 \t #De FlySuper300 kan maar lieft 2.000kg vracht meenemen en heeft een mooi uiterlijk.");
            System.out.println("2.) $15.000   SuperJet300 \t #De SuperJet300 kan maar liefst 5.000kg vracht meenemen en heeft een extra laadruimte voor 500kg.");
            System.out.println("3.) $20.000   Airbus5000 \t #De Airbus5000 heeft maar liefst ruimte voor 15.000kg vracht!");
            
        }else{
            
            System.out.println("invalid option");
        }
        
      }
    }

    

