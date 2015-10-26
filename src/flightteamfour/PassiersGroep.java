
package flightteamfour;


public class PassiersGroep {
    
    private int passagiers;

    public int getPassagiers() {
        return passagiers;
    }
    public Vliegveld bestemming;

    public PassiersGroep(int passagiers, Vliegveld bestemming) {
        this.passagiers = passagiers;
        this.bestemming = bestemming;
    }

    public Vliegveld getBestemming() {
        return bestemming;
    }
    
    
}
