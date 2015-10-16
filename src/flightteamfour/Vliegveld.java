
package flightteamfour;


public class Vliegveld {
    
    private double aantalPassagiers;
    private double aantalVracht;
    private String name;

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
    }  
    
}

