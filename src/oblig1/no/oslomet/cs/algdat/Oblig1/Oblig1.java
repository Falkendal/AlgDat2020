package oblig1.no.oslomet.cs.algdat.Oblig1;
import java.util.*;
////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;

public class Oblig1 {

    public static void main(String[] args) {
        /*
        int [] a = {6,10,9,4,1,3,8,5,2,7};
        delsortering(a);
        System.out.println(Arrays.toString(a));
        */
        /*
        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        rotasjon(a);
        System.out.println(Arrays.toString(a));
        */
        String a = flett ( "ABC" , "DEFGH" );
        String b = flett ( "IJKLMN" , "OPQ" );
        String c = flett ( "" , "AB" );
        System. out .println(a + " " + b + " " + c);
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

        int venstre = 0, høyre = a.length-1;

        // Sorterer array i stigende rekkefølge
        for(int i = 1; i < a.length; ++i) {
            int j;
            for(j = 0; j < i; ++j) {
                if(a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        // Sorterer oddetall på venstre side og partall høyre
        // Disse blir ikke sortert
        while(venstre <= høyre) {
            while(a[venstre]%2 != 0 && venstre < høyre) {
                venstre++;
            }

            while(a[høyre]%2 == 0 && venstre < høyre) {
                høyre--;
            }

            if(venstre >= høyre) {
                break;
            }

            int temp = a[venstre];
            a[venstre] = a[høyre];
            a[høyre] = temp;
        }
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if (a.length <= 1) {
            return;
        }

        char temp = a[a.length-1];

        for(int i = a.length-1; i > 0; --i) {
            a[i] = a[i-1];
        }

        a[0] = temp;
    }

    /*
    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {

    }
    */

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        int maksLengde = Math.max(s.length(), t.length());
        System.out.println(maksLengde);

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        char[] flettet = new char[sArray.length + tArray.length];

        int flettetIndeks = 0;

        for (int i = 0; i < maksLengde; i++) {
            if (i < sArray.length) {
                flettet[flettetIndeks++] = sArray[i];
            }
            if (i < tArray.length) {
                flettet[flettetIndeks++] = tArray[i];
            }
        }

        return new String(flettet);
    }

    /// 7b)
    public static String flett(String... s) {
        return "hei";
    }

    /*
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
