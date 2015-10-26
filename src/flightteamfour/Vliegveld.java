
package flightteamfour;

import static flightteamfour.FlightTeamFour.vliegvelden;
import java.util.ArrayList;


public class Vliegveld {
    
    private double aantalPassagiers;
    private double aantalVracht;
    private String name;
    private ArrayList<PassierGroep> passiersGroep = new ArrayList<PassierGroep>();

    public double getAantalPassagiers() {
        return aantalPassagiers;
    }

    public double getAantalVracht() {
        return aantalVracht;
    }

    public String getName() {
        return name;
    }
    
  
    
    
    Vliegveld(String name, double aantalPassagiers, double aantalVracht){
        this.name = name;
        this.aantalPassagiers = aantalPassagiers;
        this.aantalVracht = aantalVracht;
        random();
    }  
    
    public void random(){
        for(Vliegveld vliegveld: vliegvelden){
            //if(vliegveld != this){
                passiersGroep.add(new PassierGroep(100, vliegveld));
                System.out.println("Van " + this.getName() +" Bestemming: " + passiersGroep.get(passiersGroep.size()-1).getBestemming().getName());
            //}
        }
    }
}

