package BoteServer.utilities;

import org.springframework.stereotype.Component;

/**
 * Den 5.3.2024
 */

@Component
public class Methoden {


    /**
     * Tomcat laufzeit anzeigen, nur Tagen Stunden und Minuten
     *
     */
    private long startZeit = System.currentTimeMillis(); //Nur zum Testen: System.currentTimeMillis() * 6;
    public String zeitstempel(){

        long endeZeit =  System.currentTimeMillis();
        long diffMillis = Math.abs(startZeit - endeZeit);

        int timeInSekunden = ((int)diffMillis) / 1000;
        //int sekunden = timeInSekunden % 60;
        int timeInMinuten = timeInSekunden / 60;
        int minuten = timeInMinuten % 60;
        int timeInStunden = timeInMinuten / 60;
        int stunden = timeInStunden % 24;
        int timeInTagen = timeInStunden / 24;
        int tagen = timeInTagen % 24;

        String minutenZeigen = minuten > 0 ? minuten
                + (minuten > 1 ? " Minuten " : " Minute ") : "";
        String stundenZeigen = stunden > 0 ? stunden
                + (stunden > 1 ? " Stunden " : " Stunde ") : "";
        String tagenZeigen = tagen > 0 ? tagen
                + (tagen > 1 ? " Tagen " : " Tag ") : "";

        String textZeigen = minuten > 0 ? "Tomcat Server läuft seit" : "From Bote";
        String komplektZeigen =  textZeigen + " " + tagenZeigen +" " + stundenZeigen + " " + minutenZeigen;

        return  komplektZeigen;
    }

}
