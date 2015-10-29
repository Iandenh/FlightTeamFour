package flightteamfour;

import static flightteamfour.FlightTeamFour.vliegvelden;
import java.util.ArrayList;

public class Vliegveld {

    private final double xpositie;
    private final double ypositie;
    private final String name;
    private ArrayList<PassiersGroep> passiersGroepen = new ArrayList<PassiersGroep>();
    private ArrayList<Vracht> VrachtGroepen = new ArrayList<Vracht>();

    public ArrayList<PassiersGroep> getPassiersGroep() {
        return passiersGroepen;
    }

    public String getName() {
        return name;
    }

    Vliegveld(String name, double xpositie, double ypositie) {
        this.name = name;
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
        passiersGroepen.clear();
        VrachtGroepen.clear();
        for (Vliegveld vliegveld : vliegvelden) {
            if (vliegveld != this) {
                getal = (int) (Math.random() * 300);
                passiersGroepen.add(new PassiersGroep(getal, vliegveld));

            }
            if (vliegveld != this) {
                getal = (int) (Math.random() * 300);
                VrachtGroepen.add(new Vracht(getal, vliegveld));
            }
        }

    }

    public ArrayList<Vracht> getVrachtGroepen() {
        return VrachtGroepen;
    }
}
