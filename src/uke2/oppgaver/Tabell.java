package uke2.oppgaver;

import java.util.*;

public class Tabell {

    // Konstruktør
    private Tabell() {}

    // Main
    public static void main(String ... args)      // hovedprogram
    {
        // Initial
        System.out.println("Initial fra kompendiet:");
        int[] x = Tabell.randPerm(20);              // en tilfeldig tabell
        for (int k : x) System.out.print(k + " ");  // skriver ut a

        int m = Tabell.maks(x);   // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);

        // 1.2.2: Oppgave 3
        char[] c = {'A', 'B', 'C', 'D', 'E'};
        bytt(c, 0, 1);

        // 1.2.2: Oppgave 4
        System.out.print("\nOppgave 4: ");
        skriv(x);
        System.out.println();

        // 1.2.2: Oppgave 5
        System.out.print("\nOppgave 5: ");
        skrivln(x);
        System.out.println();


        // 1.2.3: Oppgave 3
        //int[] testeOpg3 = null;         // Meldinger:
        // maks(testeOpg3, 6, 0);        // "fra(6) > til(0) - illegalt intervall!"
        // maks(testeOpg3, -1, 6);      //  "fra(-1) er negativ!"
        // maks(testeOpg3, 0, 10);     //   "til(10) > tablengde(6)"
        //maks(testeOpg3, 0, 5);      //    "Listen er tom!"
    }
    // Programkode 1.2.3 d)
    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }

    // Programkode 1.2.3 a)
    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    // 1.2.2: Oppgave 5
    // Lag to skrivln-metoder. De skal ha samme signatur og fungere på samme måte som de to skriv-metodene i Oppgave 4 , men utskriften skal avsluttes med et linjeskift.
    public static void skrivln(int[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);

        // Løsningsforslag
        skriv(a,fra,til);
        System.out.println();

        // Min løsning
        /*
        System.out.println("\nMin løsning:");
        for(int i = fra; i < til; ++i) {
            if(i == (til - 1)) {
                System.out.println(a[i]);
            } else {
                System.out.print(a[i] + " ");
            }
        }
        */
    }

    public static void skrivln(int[] a) {
        skrivln(a, 0, a.length);
    }

    // 1.2.2: Oppgave 4
    // Den skal skrive ut tallene i intervallet a[fra:til> til konsollet - alle på én linje og et mellomrom mellom hvert tall. Ikke mellomrom og ikke linjeskift etter siste verdi.
    public static void skriv(int[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);
        // Løsningsforslag
        System.out.println("\nLøsningsforslag:");
        if ((til - fra) > 0) {
            System.out.print(a[fra]);
        }

        for (int i = fra + 1; i < til; i++) {
            System.out.print(" " + a[i]);
        }

        // Min løsning
        /*
        System.out.println("\nMin løsning:");
        for(int i = fra; i < til; ++i) {
            if(i == (til - 1)) {
                System.out.print(a[i]);
            } else {
                System.out.print(a[i] + " ");
            }
        }
        *
         */
    }

    // Den skal skrive ut hele tabellen - alle på én linje, en blank mellom hvert tall. Ikke mellomrom og ikke linjeskift etter siste verdi.
    public static void skriv(int[] a) {
        skriv(a, 0, a.length);
    }

    // 1.2.2: Opg.3 - "Den skal bytte om innholdet i posisjon i og j  i char-tabellen c"
    public static void bytt(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //  Programkode 1.1.8 d) -> Bytter heltall
    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //  Programkode 1.1.8 e)
    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    //   Programkode 1.1.8 f)
    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    //   Programkode 1.2.1 b)
    public static int maks(int[] a, int fra, int til)
    {
        if(a == null) {
            throw new NullPointerException("Listen er tom!");
        }
        fratilKontroll(a.length, fra, til);

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    //    Programkode 1.2.1 c)
    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }

    // "Min-metodene" fra oppgave 1 121
    public static int min(int[] a, int fra, int til)
    {
        fratilKontroll(a.length, fra, til);

        int m = fra;              // indeks til minste verdi i a[fra:til>
        int minverdi = a[fra];   // minste verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] < minverdi)
            {
                m = i;                // indeks til minste verdi oppdateres
                minverdi = a[m];     // minste verdi oppdateres
            }
        }

        return m;  // posisjonen til minste verdi i a[fra:til>
    }

    public static int min(int[] a)  // bruker hele tabellen
    {
        return min(a,0,a.length);     // kaller metoden over
    }
}
