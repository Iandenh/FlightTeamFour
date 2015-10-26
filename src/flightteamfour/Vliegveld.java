package flightteamfour;

import static flightteamfour.FlightTeamFour.vliegvelden;
import java.util.ArrayList;

public class Vliegveld {

    private double aantalPassagiers;
    private double aantalVracht;
    private final double xpositie;
    private final double ypositie;
    private final String name;
    private ArrayList<PassiersGroep> passiersGroep = new ArrayList<PassiersGroep>();

    public double getAantalPassagiers() {
        return aantalPassagiers;
    }

    public ArrayList<PassiersGroep> getPassiersGroep() {
        return passiersGroep;
    }

    public double getAantalVracht() {
        return aantalVracht;
    }

    public String getName() {
        return name;
    }

    Vliegveld(String name, double aantalVracht, double xpositie, double ypositie) {
        this.name = name;
        this.aantalVracht = aantalVracht;
        this.xpositie = xpositie;
        this.ypositie = ypositie;
    }

    public double getXpositie() {
        return xpositie;
    }

    public double getYpositie() {
        return ypositie;
    }

    public void random() {
        int getal;
        for (Vliegveld vliegveld : vliegvelden) {
            if (vliegveld != this) {
                getal = (int) (Math.random() * 300);
                if (getal > 100) {
                    passiersGroep.add(new PassiersGroep(getal, vliegveld));
                    
                }

            }
        }
        for (PassiersGroep passiersGroep : passiersGroep) {
            System.out.println(this.getName() + " naar " + passiersGroep.bestemming.getName() + " gaan " + passiersGroep.getPassagiers() + " passagiers");
        }

    }
}
