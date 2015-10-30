package flightteamfour;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tony & Ian
 */
public class FlightTeamFour {

    public static Scanner in = new Scanner(System.in);

    public static int ronde = 1; // Aantal rondes.
    public static double geld = 100000; // Geld wat de speler per ronde krijgt.

    public static ArrayList<Vliegtuig> vliegtuigen = new ArrayList<Vliegtuig>();
    public static ArrayList<Vliegveld> vliegvelden = new ArrayList<Vliegveld>();
    public static ArrayList<PassiersGroep> passiers = new ArrayList<PassiersGroep>();
    
    public static int roundeInkomsten = 0;
    public static int roundeUitgaven = 0;

    public static void start() {

        //Voorbereidingen
        vliegvelden.clear();
        vliegvelden.add(new Vliegveld("AMS", 52.308333, 4.760833));   //Amsterdam
        vliegvelden.add(new Vliegveld("LAX", 33.9425, -118.408056));  //Los angeles
        vliegvelden.add(new Vliegveld("PAR", 49.013611, 2.557778));   //Parijs
        vliegvelden.add(new Vliegveld("SXF", 52.38, 13.5225));        // Berlijn
        vliegvelden.add(new Vliegveld("JFK", 40.639722, -73.778889)); //new York
        vliegvelden.add(new Vliegveld("LHR", 51.4775, -0.461389));    //Londen

        randomPassiers();

        vliegtuigen.add(new PassiersVliegtuig("Boeing737", 300, 1000, 500));
        vliegtuigen.add(new PassiersVliegtuig("Boeing747", 450, 1200, 700));
        vliegtuigen.add(new PassiersVliegtuig("Boeing777", 600, 1800, 1000));
        vliegtuigen.add(new PassiersVliegtuig("Airbus380", 700, 3000, 2000));
        vliegtuigen.add(new VrachtVliegtuig("ITyet", 1000, 5000, 4000));
        vliegtuigen.add(new VrachtVliegtuig("An-225", 2000, 10000, 6000));
        vliegtuigen.add(new VrachtVliegtuig("Hercules", 2000, 10000, 6000));
        vliegtuigen.add(new VrachtVliegtuig("FTF200", 2000, 10000, 6000));

        for (Vliegtuig vliegtuig : vliegtuigen) {
            vliegtuig.setVliegveld(vliegvelden.get((int) (Math.random() * vliegvelden.size()))); //Neerzetten op random vliegveld om te beginnen
        }

        boolean running = true;
        while (running) {
            System.out.println("\t       | Menu:                        |");
            System.out.println("\t       | Ronde --> " + "[" + ronde + "]                |");
            System.out.println("\t       |------------------------------|");
            System.out.println("\t       | 1.).......Vliegtuig kopen    |");
            System.out.println("\t       | 2.).......Vluchten inplannen |");
            System.out.println("\t       | 3.).......Vluchten uitvoeren |");
            System.out.println("\t       | 4.).......Bankzaken          |");
            System.out.println("\t       | 5.).......Terug              |");
            System.out.println("\t       |                              |");
            System.out.println("\t       |------------------------------|");
            System.out.print("option: ");
            if (in.hasNextInt()) {

                int selection = in.nextInt();

                switch (selection) {

                    case 1:
                        //Vliegtuigkopen
                        vliegtuigKopen();
                        break;
                    case 2:
                        //Vluchtinplannen
                        vluchtInplanen();
                        break;
                    case 3:
                        //Vluchuitvoeren
                        ArrayList<Vlucht> vluchten = new ArrayList<>();
                        for (Vliegtuig vliegtuig : vliegtuigen) {
                            vliegtuig.tanken();
                            if(vliegtuig.getVlucht() != null){
                              
                                vluchten.add(vliegtuig.getVlucht()); 
                            }
                            vliegtuig.vliegen();
                        } 
                        if(vluchten.isEmpty()){
                            System.out.println("");
                            System.out.println("\t Je hebt nog geen vluchten ingepland...");
                            System.out.println("");
                            break;
                        }
                        System.out.println("\t\t+--------------------------+");
                        System.out.println("\t\t|         Samenvatting     | ");
                        System.out.println("\t\t+--------------------------+\n");
                        if((roundeInkomsten - roundeUitgaven) > 0){//winst
                            System.out.println("\tDeze ronde hebt je " + (roundeInkomsten - roundeUitgaven)
                            + " euro winst gemaakt\n");
                        } else {
                            System.out.println("\tDeze ronde hebt je " + (roundeInkomsten - roundeUitgaven)
                            + " verlies gemaakt\n");
                        }
                        System.out.println("Gevlogen vluchten: \n");
                        for (Vlucht vlucht : vluchten) {
                            System.out.println(vlucht.getBestemming().getName() + " naar " + vlucht.getVertrek().getName());
                            if(vlucht.getKilo() != 0){
                                System.out.println("Met deze vlucht ging " + vlucht.getKilo() + " kilo vracht mee.");
                            } else {
                                System.out.println("Met deze vlucht gingen " + vlucht.getAantal() + " passagiers mee.");
                            }
                            System.out.println("-------------------------------------");
                        } 
                        //ronde reset
                        roundeInkomsten = 0;
                        roundeUitgaven = 0;
                        ronde++;
                        randomPassiers();
                        break;
                    case 4:
                        // bankzaken
                        System.out.println("----------------------------");
                        System.out.printf("Je geld bedraagt: %.2f", geld);
                        System.out.println("");
                        System.out.println("----------------------------");
                        break;
                    case 5:
                        running = false; // Sluit het spel af
                        return;
                    default:
                        System.out.println("Enter een geldige optie");
                        in.nextLine();
                        break;

                }
            } else {
                System.out.println("Enter een geldige optie");
                
            }
            in.nextLine();

        }
    }

    public static void vluchtInplanen() {

        boolean running = true;
        while (running) {
            System.out.println("\t       |       Vlucht inplannen:     |");

            System.out.println("\t       |-----------------------------|");
            for (int i = 0; i < vliegtuigen.size(); i++) {
                Vliegtuig vliegtuig = vliegtuigen.get(i);
                if (vliegtuig.getVlucht() == null) {
                    System.out.println("\t        " + (i + 1) + ".) " + vliegtuig.getName() + " staat op " + vliegtuig.getVliegveld().getName() + " ");
                }

            }
            System.out.println("\t        e.) Terug     ");
            System.out.print("optie: ");

            if (in.hasNextInt()) {
                int keuze = in.nextInt() - 1;
                if (keuze < vliegtuigen.size()) {
                    Vliegtuig vliegtuig = vliegtuigen.get(keuze);

                    if (vliegtuig instanceof PassiersVliegtuig) { //PassiersVliegtuig
                        ArrayList<PassiersGroep> passiersGroepen = vliegtuig.getVliegveld().getPassiersGroep();

                        System.out.println("\t       |       Kies bestemming:     |");
                        for (int i = 0; i < passiersGroepen.size(); i++) {
                            PassiersGroep passiersGroep = passiersGroepen.get(i);
                            System.out.println((i + 1) + ".) " + vliegtuig.getVliegveld().getName() + " naar " + passiersGroep.bestemming.getName() + " gaan " + passiersGroep.getPassagiers() + " passagiers");
                        }
                        if (in.hasNextInt()) {
                            int vluchtKeuzen = in.nextInt();
                            if (vluchtKeuzen <= passiersGroepen.size()) {
                                PassiersGroep passiersGroep = passiersGroepen.get(vluchtKeuzen - 1);
                                vliegtuig.setVlucht(new Vlucht(vliegtuig.getVliegveld(), passiersGroep.getBestemming(), passiersGroep.getPassagiers()));
                                System.out.println("Vlucht van: " + vliegtuig.getVliegveld().getName() + " naar "
                                        + passiersGroep.getBestemming().getName() + "met "
                                        + passiersGroep.getPassagiers() + " passagiers"
                                        + "is ingepland\n"
                                );
                                passiersGroepen.remove(vluchtKeuzen - 1);
                            }

                        }
                    } else {//vracht

                        ArrayList<Vracht> Vrachtgroepen = vliegtuig.getVliegveld().getVrachtGroepen();

                        System.out.println("\t       |       Kies bestemming:     |");
                        for (int i = 0; i < (Vrachtgroepen.size()); i++) {
                            Vracht Vrachtgroep = Vrachtgroepen.get(i);
                            System.out.println((i + 1) + ".) " + vliegtuig.getVliegveld().getName() + " naar " + Vrachtgroep.bestemming.getName() + " gaan " + Vrachtgroep.getAantalVracht() + " kilo's");
                        }
                        if (in.hasNextInt()) {
                            int vluchtKeuzen = in.nextInt();
                            if (vluchtKeuzen <= Vrachtgroepen.size()) {
                                Vracht Vrachtgroep = Vrachtgroepen.get(vluchtKeuzen - 1);
                                vliegtuig.setVlucht(new Vlucht(vliegtuig.getVliegveld(), Vrachtgroep.getBestemming(), Vrachtgroep.getAantalVracht()));
                                System.out.println("Vlucht van: " + vliegtuig.getVliegveld().getName() + " naar "
                                        + Vrachtgroep.getBestemming().getName() + " met "
                                        + Vrachtgroep.getAantalVracht() + " kilo's"
                                        + " is ingepland!\n"
                                );
                                Vrachtgroepen.remove(vluchtKeuzen - 1);
                            }
                        }

                    }

                }
            } else {
                if (in.next().equals("e")) {
                    running = false;
                } else {

                    System.out.println("Enter een geldige optie");

                }
            }

        }

    }

    public static void menu() {
        System.out.println("\t     |-------------------------------------|");
        System.out.println("\t     |               Mainmenu:             |");
        System.out.println("\t     |-------------------------------------|");
        System.out.println("\t     |-------------------------------------|");
        System.out.println("\t     | 1.)..........Speluitleg             |");
        System.out.println("\t     | 2.)..........Start                  |");
        System.out.println("\t     | 3.)..........Exit                   |");
        System.out.println("\t     |                         v1.0        |");
        System.out.println("\t     |        Created by Ian & Tony        |");
        System.out.println("\t     |-------------------------------------|");
        System.out.print("optie: ");

    }

    public static void spelUitleg() {   //SpelUitleg Methode 

        System.out.println("\t# Het is een spel gebaseerd op rondes. \n "
                + "\t# Elke ronde staan er op verschillende vliegvelden mensen of vracht te wachten met een bestemming.\n "
                + "\t# Afhankelijk van de beschikbare vliegtuigen op dat vliegveld en hun capaciteit kan er een vlucht gepland worden naar een nieuwe bestemming.\n "
                + "\t# Elk vliegtuig mag maximaal 1 vlucht maken per ronde.\n "
                + "\t# Ook zijn er vrachtvliegtuigen, en kan er vracht vervoerd worden.\n "
                + "\t# Het is niet mogelijk om en passagiers en vracht in hetzelfde vliegtuig te vervoeren. \n\n");

        System.out.println("\t# Elke rond begin je met geld, de bedoeling is om uiteindelijk zoveel mogelijk winst te maken.");
        System.out.println("\t# Door jou winst is het ook mogelijk om een nieuw vliegtuig te kopen.\n");

        System.out.print("Klik `e` om terug te keren naar het menu: \n");

        boolean running = true;
        while (running) {

            if (in.hasNext() && in.next().equals("e")) {
                running = false;
                menu();
                return;
            } else {
                System.out.println("Enter een geldige optie");

                in.nextLine();
            }

        }
    }

    public static void main(String[] args) {

        boolean running = true;

        //Begin scherm
        System.out.println("\t#    Welkom bij het FlightFourTeam spel!\t# ");
        System.out.println("\t  -----------------------------------------");
        System.out.println("\t# Jouw doel om zoveel mogelijk winst te maken\t# \n");

        //Start Menu
        while (running) {

            menu();
            if (in.hasNextInt()) {

                int selection = in.nextInt();

                switch (selection) {

                    case 1:
                        spelUitleg();     // Speluitleg
                        break;
                    case 2:
                        start();         // Start game
                        break;
                    case 3:
                        System.out.println("Byebye");
                        running = false; // Sluit het spel af
                        break;
                    default:
                        System.out.println("Enter een geldige optie");
                        break;

                }
            }

            in.nextLine();
        }

    }

    public static void vliegtuigKopen() {

        //Vliegtuig kopen 
        
        System.out.println("               Hallo speler!");
        System.out.println("Hier is het mogelijk om een vliegtuig aan te schaffen.\n");
        System.out.printf("Jou geld bedraagt: € %.2f ", FlightTeamFour.geld);
        System.out.println("");
        
        System.out.println("Wat voor soort vliegtuig wilt u kopen?\n");
        System.out.println("------------------------------------------");
        System.out.println("p.)\t Passagiersvliegtuig");
        System.out.println("v.)\t Vrachtvliegtuig");
        System.out.println("e.)\t Terug naar het menu\n");

        System.out.print("Optie: ");

        boolean running = true;
        while (running) {
            if (in.hasNext()) {
                String menuKeuze = in.next();
                if (menuKeuze.equals("p")) {

                    System.out.println("Je kan kiezen uit de volgende Passagiersvliegtuigen: ");
                    System.out.println("1.) €40.000    Jet5000     \t #De Jet5000 kan maar lieft 400 passagiers meenemen en heeft een 1000 Liter tank");
                    System.out.println("2.) €50.000   SuperJet300 \t #De SuperJet300 kan maar liefst 500 passagiers meenemen en heeft een turbo motor.");
                    System.out.println("3.) €60.000   Airbus5000  \t #De Airbus5000 heeft maar liefst ruimte voor 850 personen!\n");
                    System.out.println("e.) terug naar het menu");
                    System.out.print("Optie: ");

                    if (in.hasNextInt()) {
                        int input = in.nextInt();
                        if (input == 1 && geld >= 40000) {

                            Vliegtuig tmpVliegtuig = new PassiersVliegtuig("Jet5000", 400, 400, 1000);
                            tmpVliegtuig.setVliegveld(vliegvelden.get(kiesAirport()));
                            vliegtuigen.add(tmpVliegtuig);
                            tmpVliegtuig = null;

                            System.out.println("Je hebt de Jet5000 gekocht");
                            System.out.println("Druk op e om terug te keren naar het menu");
                            geld = geld - 40000;
                            running = false;

                        } else if (input == 1 && geld < 40000) {

                            System.out.println("Oeps! Niet genoeg geld");

                        } else if (input == 2 && geld >= 50000) {

                            Vliegtuig tmpVliegtuig = new PassiersVliegtuig("SuperJet300", 850, 400, 1000);
                            tmpVliegtuig.setVliegveld(vliegvelden.get(kiesAirport()));
                            vliegtuigen.add(tmpVliegtuig);
                            tmpVliegtuig = null;

                            System.out.println("Je hebt de SuperJet300 gekocht");
                            System.out.println("Druk op e om terug te keren naar het menu");
                            geld = geld - 50000;
                            running = false;
                        } else if (input == 2 && geld < 50000) {

                            System.out.println("Oops! Niet genoeg geld");
                        } else if (input == 3 && geld >= 60000) {

                            Vliegtuig tmpVliegtuig = new PassiersVliegtuig("Airbus5000", 400, 400, 1000);
                            tmpVliegtuig.setVliegveld(vliegvelden.get(kiesAirport()));
                            vliegtuigen.add(tmpVliegtuig);
                            tmpVliegtuig = null;

                            System.out.println("Je hebt de Airbus5000 gekocht");
                            System.out.println("Druk op e om terug te keren naar het menu");
                            geld = geld - 60000;
                            running = false;

                        } else if (input == 3 && geld < 60000) {

                            System.out.println("Oops! Niet genoeg geld");

                        } else {

                            System.out.println("ongeldige optie");
                        }
                    }
                }

                else if (menuKeuze.equals("v")) {

                    System.out.println("Je kan kiezen uit de volgende Vrachtvliegtuigen: ");
                    System.out.println("1.) €40.000    FlySuper300 \t #De FlySuper300 kan maar lieft 2.000kg vracht meenemen en heeft een mooi uiterlijk.");
                    System.out.println("2.) €50.000   SuperJetV \t #De SuperJet300 kan maar liefst 5.000kg vracht meenemen en heeft een extra laadruimte voor 500kg.");
                    System.out.println("3.) €60.000   AirbusIT \t #De Airbus5000 heeft maar liefst ruimte voor 15.000kg vracht!");
                    System.out.println("e.) terug naar het menu");

                    if (in.hasNextInt()) {
                        int input2 = in.nextInt();
                        if (input2 == 1 && geld >= 40000) {

                            Vliegtuig tmpVliegtuig = new VrachtVliegtuig("FlySuper300", 400, 400, 1000);
                            tmpVliegtuig.setVliegveld(vliegvelden.get(kiesAirport()));
                            vliegtuigen.add(tmpVliegtuig);
                            tmpVliegtuig = null;
                            
                            System.out.println("Je hebt de FlySuper300 gekocht");
                            System.out.println("Druk op e om terug te keren naar het menu");
                            geld = geld - 40000;
                            running = false;

                        } else if (input2 == 1 && geld < 40000) {

                            System.out.println("Oeps! Niet genoeg geld");

                        } else if (input2 == 2 && geld >= 50000) {

                            Vliegtuig tmpVliegtuig = new VrachtVliegtuig("SuperJetV", 850, 400, 1000);
                            tmpVliegtuig.setVliegveld(vliegvelden.get(kiesAirport()));
                            vliegtuigen.add(tmpVliegtuig);
                            tmpVliegtuig = null;
                            
                            System.out.println("Je hebt de SuperJetV gekocht");
                            System.out.println("Druk op e om terug te keren naar het menu");
                            geld = geld - 50000;
                            running = false;
                        } else if (input2 == 2 && geld < 50000) {

                            System.out.println("Oops! Niet genoeg geld");
                        } else if (input2 == 3 && geld >= 60000) {

                            Vliegtuig tmpVliegtuig = new VrachtVliegtuig("AirbusIT", 400, 400, 1000);
                            tmpVliegtuig.setVliegveld(vliegvelden.get(kiesAirport()));
                            vliegtuigen.add(tmpVliegtuig);
                            tmpVliegtuig = null;
                            
                            System.out.println("Je hebt de AirbusIT gekocht");
                            System.out.println("Druk op e om terug te keren naar het menu");
                            geld = geld - 60000;
                            running = false;

                        } else if (input2 == 3 && geld < 60000) {

                            System.out.println("Oops! Niet genoeg geld");

                        } else {

                            System.out.println("ongeldige optie");
                        }
                    }
                } else if(menuKeuze.equals("e")) {
                    running = false;
                }
            }
        }
    }

    private static int kiesAirport() {

        //Kies vliegveld
        
        while (true) {

            System.out.println("\t       |       Waar wil je het vliegtuig neerzetten?     |");

            
            for (int i = 0; i < vliegvelden.size(); i++) {
                Vliegveld vliegveld = vliegvelden.get(i);

                System.out.println("\t        " + (i + 1) + ".) " + vliegveld.getName());

            }
            if (in.hasNextInt()) {
                int vliegveldKeuze = in.nextInt();
                if (vliegveldKeuze <= vliegvelden.size() && vliegveldKeuze > 0) {
                    return (vliegveldKeuze - 1);
                }
            } else {
                System.out.println("ongeldige optie");
                in.nextLine();
            }
        }
    }

    private static void randomPassiers() {
        for (Vliegveld vliegveld : vliegvelden) {
            vliegveld.random();
        }
    }
}
