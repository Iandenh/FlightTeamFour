
package flightteamfour;


public class Vracht {

    public int getAantalVracht() {
        return aantalVracht;
    }

    public Vliegveld getBestemming() {
        return bestemming;
    }
    
    public int aantalVracht;
    public Vliegveld bestemming;

    public Vracht(int aantalVracht, Vliegveld bestemming) {
        
        this.aantalVracht = aantalVracht;
        this.bestemming = bestemming;
    }
    
    
  
    
}
