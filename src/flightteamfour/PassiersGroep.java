
package flightteamfour;


public class PassiersGroep {
    
    public int passagiers;
    public Vliegveld bestemming;

    public PassiersGroep(int passagiers, Vliegveld bestemming) {
        this.passagiers = passagiers;
        this.bestemming = bestemming;
    }

    public Vliegveld getBestemming() {
        return bestemming;
    }
    
    
}
