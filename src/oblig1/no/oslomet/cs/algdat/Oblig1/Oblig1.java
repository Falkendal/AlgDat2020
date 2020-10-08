package oblig1.no.oslomet.cs.algdat.Oblig1;
import java.util.*;
////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;

public class Oblig1 {

    public static void main(String[] args) {
        int[] a = {5, 3, 7, 4, 3, 5, 7, 8, 6, 7};
        int opg3 = antallUlikeUsortert(a);
        System.out.println(opg3);
    }

    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if(a == null)
            throw new NullPointerException("Tabellen er null. Sjekk om tabellen er initialisert riktig!");

        if(a.length == 0) {
            throw new NoSuchElementException("Tabellen er tom! Sjekk om du har lagt til verdier.");
        }

        for(int i = 0; i < a.length-1; ++i) {
            if(a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        int antallOmbyttinger = 0;

        for(int i = 0; i < a.length-1; ++i) {
            if(a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                antallOmbyttinger++;
            }
        }

        return antallOmbyttinger;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int antallUlike = 0;

        // Hvis tabellen er tom returnerer den 0
        if(a.length == 0) {
            return antallUlike;
        }

        // Sjekker om tabellen er sortert i stigende rekkefølge
        for(int s = 0; s < a.length-1; ++s) {
            if(a[s] > a[s+1]) {
                throw new IllegalStateException("Tabellen er ikke sortert i stigende rekkefølge.");
            }
        }

        // Looper gjennom verdiene og sjekker hvor mange like det er
        for(int i = 0; i < a.length-1; ++i)
            if(a[i] != a[i+1])
                antallUlike++;

        antallUlike++;
        return antallUlike;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        // {5, 3, 7, 4, 3, 5, 7, 8, 6, 7}
        int antall = a.length;
        int antallLike = 0;

        // Hvis tabellen er tom returnerer den 0
        if(a.length == 0) {
            return 0;
        }

        for(int i = 0; i < a.length; ++i) {
            int j;
            for(j = 0; j < i; ++j) {
                if(a[i] == a[j]) {
                    antallLike++;
                    break;
                }
            }
        }
        int antallUlike = antall - antallLike;

        return antallUlike;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        
    }

    /*
    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {

    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {

    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {

    }

    /// 7b)
    public static String flett(String... s) {

    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {

    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {

    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {

    }

    public static boolean inneholdt(String a, String b) {

    }
    */

}  // Oblig1
