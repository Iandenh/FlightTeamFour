
package flightteamfour;


public class Vlucht {
    final private double literprijs = 1.12;
    private int aantal;
    private double kosten;
    private double inkomsten;
    private Vliegveld vertrek;
    private Vliegveld bestemming;

    public Vlucht(Vliegveld vertrek, Vliegveld bestemming) {
        this.vertrek = vertrek;
        this.bestemming = bestemming;
        kosten = kilometers()*literprijs;
        System.out.println("Kosten: " + kilometers());
        
    }
    
    public double kilometers(){
        double lat1 = bestemming.getXpositie();
        double lng1 = bestemming.getYpositie();
        
        double lat2 = vertrek.getXpositie();
        double lng2 = vertrek.getYpositie();
        
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
               Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);

        return dist/1000;//kilometers
    }
    
}
