
package flightteamfour;


public class PassierGroep {
    
    public int passagiers;
    public Vliegveld bestemming;

    public PassierGroep(int passagiers, Vliegveld bestemming) {
        this.passagiers = passagiers;
        this.bestemming = bestemming;
    }

    public Vliegveld getBestemming() {
        return bestemming;
    }
    
    
}
