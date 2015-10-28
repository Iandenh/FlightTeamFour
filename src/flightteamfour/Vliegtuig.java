package flightteamfour;

import java.util.Scanner;

public class Vliegtuig {

    protected int maxPassagiers;
    protected double maxVracht;
    protected double fuelCapacity;
    protected String name;
    protected Vliegveld vliegveld;
    protected Vlucht vlucht;

    public Vlucht getVlucht() {
        return vlucht;
    }

    public void setVlucht(Vlucht vlucht) {
        this.vlucht = vlucht;
    }

    private static Scanner in = new Scanner(System.in);

    public Vliegveld getVliegveld() {
        return vliegveld;
    }

    public void setVliegveld(Vliegveld vliegveld) {
        this.vliegveld = vliegveld;
    }

    Vliegtuig(String name, int maxPassagiers, double maxVracht, double fuelCapacity) {
        this.name = name;
        this.maxPassagiers = maxPassagiers; //number of people (MAX)
        this.maxVracht = maxVracht;     //KG vracht (Max)
        this.fuelCapacity = fuelCapacity;  //Liters 
    }

    public String getName() {
        return name;
    }

    public void tanken() {
        if (vlucht != null) {
            FlightTeamFour.geld -= vlucht.getKosten();
        }
    }

    public void vliegen() {
        if (vlucht != null) {
            vliegveld = vlucht.getBestemming();
            FlightTeamFour.geld += vlucht.getInkomsten();
            vlucht = null;

        }
    }

    
}
