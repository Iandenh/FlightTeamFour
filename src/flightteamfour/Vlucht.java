package flightteamfour;

public class Vlucht {

    final private double literprijs = 1.12;
    private int aantal;
    private double kilo = 0;
    private double kosten;

    public int getAantal() {
        return aantal;
    }

    public double getKilo() {
        return kilo;
    }
    private double inkomsten;

    public Vliegveld getVertrek() {
        return vertrek;
    }
    private Vliegveld vertrek;
    private Vliegveld bestemming;

    public Vliegveld getBestemming() {
        return bestemming;
    }

    public Vlucht(Vliegveld vertrek, Vliegveld bestemming, int aantal) {
        this.vertrek = vertrek;
        this.bestemming = bestemming;
        this.aantal = aantal;
        kosten = kilometers() * literprijs;
        inkomsten = (kilometers() * 0.10 + 10) * aantal;//passiers
    }
    
    public Vlucht(Vliegveld vertrek, Vliegveld bestemming, double aantal) {
        this.vertrek = vertrek;
        this.bestemming = bestemming;
        this.kilo = aantal;
        kosten = kilometers() * literprijs;
        inkomsten = kilo * 10 + kilometers();//vracht
    }

    public double getKosten() {
        return kosten;
    }

    public double getInkomsten() {
        return inkomsten;
    }

    public double kilometers() {
        double lat1 = bestemming.getXpositie();
        double lng1 = bestemming.getYpositie();

        double lat2 = vertrek.getXpositie();
        double lng2 = vertrek.getYpositie();

        // @see: google.nl
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        float dist = (float) (earthRadius * c);

        return dist / 1000;//kilometers
    }

}
