package flightteamfour;

public class Vracht {

    public double aantalVracht;
    public Vliegveld bestemming;

    public double getAantalVracht() {
        return aantalVracht;
    }

    public Vliegveld getBestemming() {
        return bestemming;
    }

    public Vracht(double aantalVracht, Vliegveld bestemming) {

        this.aantalVracht = aantalVracht;
        this.bestemming = bestemming;
    }

}
