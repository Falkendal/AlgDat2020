package felles;

import felles.hjelpeklasser.Liste;
import felles.hjelpeklasser.TabellListe;

public class kjøreKlasse {
    public static void main(String[] args) {
        // 3.2.2 Oppgave 2
        /*String[] s = {"Sohil",null,"Per","Thanh","Ann","Kari","Jon",null};
        Liste<String> liste = new TabellListe<>(s);

        System.out.println(liste.hent(4));
        System.out.println(liste.indeksTil("Kari"));
        System.out.println(liste.inneholder("Kari"));*/

        // 3.2.2 Oppgave 3
        //System.out.println(liste.toString());

        // 3.2.4 Oppgave 2
        String[] s = {"Jens","Per","Kari","Ole","Berit","Jens","Anne","Nils","Siv"};

        Liste<String> liste = new TabellListe<>();

        for (String navn : s) liste.leggInn(0,navn);  // legger inn først

        System.out.println("Vi henter " + liste.hent(5) + ".");

        System.out.println("Nils er på plass " + liste.indeksTil("Nils") + "!");

        liste.oppdater(2,"Anna");  // bytter ut Anne med Anna på plass 2

        System.out.println(liste.fjern(0) + " er slettet!");

        System.out.println("Listeinnhold: " + liste);

        liste.fjernHvis(x -> x.equals("Jens"));  // fjerner alle forekomster av Jens

        liste.forEach(x -> System.out.print(x + " "));
    }
}
