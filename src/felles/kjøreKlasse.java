package felles;

import felles.hjelpeklasser.EnkeltLenketListe;
import felles.hjelpeklasser.Kø;
import felles.hjelpeklasser.Liste;
import felles.hjelpeklasser.TabellListe;

import java.util.Arrays;
import java.util.Iterator;

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
        /*String[] s = {"Jens","Per","Kari","Ole","Berit","Jens","Anne","Nils","Siv"};

        Liste<String> liste = new TabellListe<>();

        for (String navn : s) liste.leggInn(0,navn);  // legger inn først

        System.out.println("Vi henter " + liste.hent(5) + ".");

        System.out.println("Nils er på plass " + liste.indeksTil("Nils") + "!");

        liste.oppdater(2,"Anna");  // bytter ut Anne med Anna på plass 2

        System.out.println(liste.fjern(0) + " er slettet!");

        System.out.println("Listeinnhold: " + liste);

        liste.fjernHvis(x -> x.equals("Jens"));  // fjerner alle forekomster av Jens

        liste.forEach(x -> System.out.print(x + " "));*/

        // 3.3.2 Oppgave 4
        /*EnkeltLenketListe<Integer> liste = new EnkeltLenketListe<>(); // lager en instans av klassen med Integer som typeparameter
        // legger inn verdier i liste
        liste.leggInn(32);   // indeks: 0
        liste.leggInn(56);   // indeks: 1
        liste.leggInn(4);    // indeks: 2
        liste.leggInn(12);   // indeks: 3
        liste.leggInn(87);   // indeks: 4
        liste.leggInn(7);    // indeks: 5
        liste.leggInn(45);   // indeks: 6

        liste.leggInn(2, 99); // legger til en node på posisjon 2 med verdi 99 ->
        // Dermed vil alle noder etter indeks 2, få en nåværende indeks + 1.

        liste.leggInn(6, 15); // legger til en node på posisjon 6 (siste element i listen).
        System.out.println("Antall noder i liste: " + liste.antall());
        System.out.println("Liste ser nå slik ut: " + liste.toString());
        //liste.nullstill();
    */
        // 3.3.4 Oppgave 1
        /*Liste<Integer> liste = new EnkeltLenketListe<>();
        for (int i = 1; i <= 10; i++) liste.leggInn(i);

        Iterator<Integer> iterator = liste.iterator();
        /*liste.fjern(0);   // fjerner verdi med indeks 0
        System.out.println(iterator.next());*/

        // 3.3.4 Oppgave 2
        /*Liste<Integer> liste = new EnkeltLenketListe<>();
        for (int i = 1; i <= 10; i++) liste.leggInn(i);
        System.out.println(liste);*/

        // fjerner partallene
        //liste.fjernHvis(x -> x % 2 == 0);

        // skriver ut
        //liste.forEach(x -> System.out.print(x + " "));

        // 4.2.4 Opg 1
        Kø<Integer> kø = new EnkeltLenketListe<>();

        for (int i = 1; i <= 10; i++) kø.leggInn(i);

        while (!kø.tom())
        {
            System.out.print(kø.taUt() + " ");
        }
    }
}
