package flightteamfour;

import java.util.Scanner;

public class Vliegtuig extends FlightTeamFour {

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

    public static void vliegtuigKopen() {

        //Vliegtuig kopen optie
        System.out.println("               Hallo speler!");
        System.out.println("Hier is het mogelijk om een vliegtuig aan te schaffen.");
        System.out.println("Jou geld bedraagt: " + FlightTeamFour.geld + "\n");

        System.out.println("Wat voor soort vliegtuig wilt u kopen?\n");
        System.out.println("------------------------------------------");
        System.out.println("p.)\t Passagiersvliegtuig");
        System.out.println("v.)\t Vrachtvliegtuig");
        System.out.println("e.)\t Terug naar het menu\n");

        System.out.print("Optie: ");

        boolean running = true;
        while (running) {

            if (in.hasNext() && in.next().equals("p")) {

                System.out.println("Je kan kiezen uit de volgende Passagiersvliegtuigen: ");
                System.out.println("1.) 7.000$    Jet5000     \t #De Jet5000 kan maar lieft 400 passagiers meenemen en heeft een 1000 Liter tank");
                System.out.println("2.) $15.000   SuperJet300 \t #De SuperJet300 kan maar liefst 500 passagiers meenemen en heeft een turbo motor.");
                System.out.println("3.) $20.000   Airbus5000  \t #De Airbus5000 heeft maar liefst ruimte voor 850 personen!\n");
                System.out.print("Optie: ");
            }
            if (in.hasNextInt()) {
                int input = in.nextInt();
                if (input == 1 && geld >= 7000) {

                    System.out.println("Je hebt de Jet5000 gekocht");
                    System.out.println("Druk op e om terug te keren naar het menu");
                    vliegtuigen.add(new PassiersVliegtuig("Jet5000", 400, 400, 1000));
                    geld = geld - 7000;
                    running = false;

                } else if (input == 1 && geld < 7000) {

                    System.out.println("Oeps! Niet genoeg geld");

                }
                else if (input == 2 && geld >= 15000) {

                    System.out.println("Je hebt de SuperJet300 gekocht");
                    System.out.println("Druk op e om terug te keren naar het menu");
                    vliegtuigen.add(new PassiersVliegtuig("SuperJet300", 850, 400, 1000));
                    geld = geld - 15000;
                    running = false;
                } else if (input == 2 && geld < 15000) {

                    System.out.println("Oops! Niet genoeg geld");
                }

                else if (input == 3 && geld >= 20000) {

                    System.out.println("Je hebt de Airbus5000 gekocht");
                    System.out.println("Druk op e om terug te keren naar het menu");
                    vliegtuigen.add(new PassiersVliegtuig("Airbus5000", 400, 400, 1000));
                    geld = geld - 20000;
                    running = false;

                } else if (input == 3 && geld < 20000) {

                    System.out.println("Oops! Niet genoeg geld");

                } else {

                    System.out.println("ongeldige optie");
                }
            }
            if (in.hasNext() && in.next().equals("v")) {

                System.out.println("Je kan kiezen uit de volgende Vrachtvliegtuigen: ");
                System.out.println("1.) $7.000    FlySuper300 \t #De FlySuper300 kan maar lieft 2.000kg vracht meenemen en heeft een mooi uiterlijk.");
                System.out.println("2.) $15.000   SuperJetV \t #De SuperJet300 kan maar liefst 5.000kg vracht meenemen en heeft een extra laadruimte voor 500kg.");
                System.out.println("3.) $20.000   AirbusIT \t #De Airbus5000 heeft maar liefst ruimte voor 15.000kg vracht!");

            }
            if (in.hasNextInt()) {
                int input2 = in.nextInt();
                if (input2 == 1 && geld >= 7000) {

                    System.out.println("Je hebt de FlySuper300 gekocht");
                    System.out.println("Druk op e om terug te keren naar het menu");
                    vliegtuigen.add(new VrachtVliegtuig("FlySuper300", 400, 400, 1000));
                    geld = geld - 7000;
                    running = false;

                } else if (input2 == 1 && geld < 7000) {

                    System.out.println("Oeps! Niet genoeg geld");

                }
                else if (input2 == 2 && geld >= 15000) {

                    System.out.println("Je hebt de SuperJetV gekocht");
                    System.out.println("Druk op e om terug te keren naar het menu");
                    vliegtuigen.add(new VrachtVliegtuig("SuperJetV", 850, 400, 1000));
                    geld = geld - 15000;
                    running = false;
                } else if (input2 == 2 && geld < 15000) {

                    System.out.println("Oops! Niet genoeg geld");
                }

                else if (input2 == 3 && geld >= 20000) {

                    System.out.println("Je hebt de AirbusIT gekocht");
                    System.out.println("Druk op e om terug te keren naar het menu");
                    vliegtuigen.add(new VrachtVliegtuig("AirbusIT", 400, 400, 1000));
                    geld = geld - 20000;
                    running = false;

                } else if (input2 == 3 && geld < 20000) {

                    System.out.println("Oops! Niet genoeg geld");

                } else {

                    System.out.println("ongeldige optie");
                }
            }
        }
    }
}
