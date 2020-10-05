package uke2.oppgaver;

import java.util.*;

public class Tabell {

    // Konstruktør
    private Tabell() {}

    // Main
    public static void main(String ... args)      // hovedprogram
    {
        // Initial
        //System.out.println("Initial fra kompendiet:");
        //int[] x = Tabell.randPerm(20);              // en tilfeldig tabell
        //for (int k : x) System.out.print(k + " ");  // skriver ut a

        //int m = Tabell.maks(x);   // finner posisjonen til største verdi

        //System.out.println("\nStørste verdi ligger på plass " + m);

        // 1.2.2: Oppgave 3
        //char[] c = {'A', 'B', 'C', 'D', 'E'};
        //bytt(c, 0, 1);

        // 1.2.2: Oppgave 4
        //System.out.print("\nOppgave 4: ");
        //skriv(x);
        //System.out.println();

        // 1.2.2: Oppgave 5
        //System.out.print("\nOppgave 5: ");
        //skrivln(x);
        //System.out.println();


        // 1.2.3: Oppgave 3
        //int[] testeOpg3 = null;         // Meldinger:
        // maks(testeOpg3, 6, 0);        // "fra(6) > til(0) - illegalt intervall!"
        // maks(testeOpg3, -1, 6);      //  "fra(-1) er negativ!"
        // maks(testeOpg3, 0, 10);     //   "til(10) > tablengde(6)"
        //maks(testeOpg3, 0, 5);      //    "Listen er tom!"

        // 1.2.4: Oppgave 1
        System.out.print("\nOppgave 1: ");
        int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
        int[] b = Tabell.nestMaks2(a);  // metoden returnerer en tabell

        int m = b[0], nm = b[1];       // m for maks, nm for nestmaks

        Tabell.skrivln(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);
    }

    // 1.2.4: Oppgave 4
    public static void sortering(int[] a) {
        
    }

    // 1.2.4: Oppgave 3
    public static int[] nestMaks3(int[] a) {
        if (a.length < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + a.length + ") < 2!");

        int maks = maks(a);  // m er posisjonen til tabellens største verdi

        bytt(a, a.length-1, maks); // bytter om slik at den største kommer bakerst

        int nest_maks = maks(a, 0, a.length-1); // finner nest_maks

        if(nest_maks == maks)
            nest_maks = a.length-1; // den nest største lå opprinnelig forrest

        bytt(a, a.length-1, maks); // bytter tilbake

        return new int[] {maks,nest_maks};
    }

    // 1.2.4: Oppgave 2
    public static int[] nestMaks2(int[] a) {
        if (a.length < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + a.length + ") < 2!");

        int maks = maks(a);  // m er posisjonen til tabellens største verdi

        bytt(a, 0, maks); // bytter om slik at den største kommer forrest

        int nest_maks = maks(a, 1, a.length);

        if(nest_maks == maks)
            nest_maks = 0; // den nest største lå opprinnelig forrest

        bytt(a, 0, maks); // bytter tilbake

        return new int[] {maks,nest_maks};
    }

    // Programkode 1.2.4 a)
    public static int[] nestMaks(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi

        int nm;           // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                            // den største ligger først
        {
            nm = maks(a, 1, n);                  // leter i a[1:n>
        }
        else if (m == n - 1)                   // den største ligger bakerst
        {
            nm = maks(a, 0, n - 1);              // leter i a[0:n-1>
        }
        else
        {
            int mv = maks(a, 0, m);              // leter i a[0:m>
            int mh = maks(a, m + 1, n);          // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
        }

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaks

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
