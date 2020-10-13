package felles;

import felles.eksempelklasser.*;

import java.awt.*;
import java.util.*;

public class Tabell {

    // Konstruktør
    private Tabell() {}

    // Main
    public static void main(String ... args)      // hovedprogram
    {
        // 1.4.7 Oppgave 2
        /*Double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        innsettingssortering(d, Komparator.naturligOrden());
        System.out.println(Arrays.toString(d));

        innsettingssortering(d, Komparator.omvendtOrden());
        System.out.println(Arrays.toString(d));*/

        // 1.4.7 Oppgave 3
        /*Boolean[] b = {false, true, true, false, false, true, false, true};
        innsettingssortering(b, Komparator.naturligOrden());
        System.out.println(Arrays.toString(b));*/

        // 1.4.7 Oppgave 4
        /*Person[] p = new Person[5];                       // en persontabell
        p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

        Tabell.innsettingssortering(p, Komparator.orden(Person::etternavn));
        System.out.println(Arrays.toString(p));*/

        // 1.4.7 Oppgave 5
        //String[] s = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        //Tabell.innsettingssortering(s, (x,y) -> y.length() - x.length());
        //System.out.println(Arrays.toString(s));
        //eller
        //Tabell.innsettingssortering(s, Komparator.orden(x -> -x.length()));

        // 1.4.8 Oppgave 2
        /*String[] s = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        innsettingssortering(s, Komparator.naturligOrden());
        //innsettingssortering(s, Komparator.orden(x -> x));
        System.out.println(Arrays.toString(s));
        /*
        Lambda-uttrykket x -> x representerer det som i matematikk kalles identitetsfunksjonen, dvs. funksjonen f som er slik at f(x) = x.
        Det betyr at det ordnes mhp. x og det er samme som naturlig ordning siden x er en instans av en sammenlignbar type.
        Dermed er Komparator.orden(x -> x) og Komparator.naturligOrden() det samme.
         */

        // 1.4.8 Oppgave 4
       /*String[] s = {"21","18","8","13","20","6","16","25","3","10"};
        innsettingssortering(s, Komparator.orden(String::length).deretter(x -> x)); // kunne også istedetfor "x -> x" vært Komparator.naturligOrden()
        System.out.println(Arrays.toString(s));*/

        // 1.4.9 Oppgave 1
        /*String[] s = {"Sohil","Per","Thanh","Ann","Kari","Jon"};       // String-tabell
        Comparator<String> c =  Comparator.comparing(String::length);  // etter lengde
        Tabell.innsettingssortering(s, c.thenComparing(x -> x));       // vanlig orden
        System.out.println(Arrays.toString(s));*/

        // 1.4.9 Oppgave 3a, 3b
        int[] x = {3,5,6,2,6,1,4,7,7,4};         // x-koordinater
        int[] y = {3,6,3,5,5,2,1,4,2,4};         // y-koordinater

        Point[] punkt = new Point[x.length];     // en punkttabell
        for (int i = 0; i < punkt.length; i++) punkt[i] = new Point(x[i],y[i]);

        for (Point p : punkt) System.out.print("(" + p.x + "," + p.y + ") ");
        System.out.println();                    // linjeskift

        Tabell.innsettingssortering(punkt,
                Comparator.comparingDouble(Point::getX).thenComparingDouble(Point::getY));

        for (Point p : punkt) System.out.print("(" + p.x + "," + p.y + ") ");

    }

    private static <T> void flett(T[] a, T[] b, int fra, int m, int til, Comparator<? super T> c)
    {
        int n = m - fra;   // antall elementer i a[fra:m>
        System.arraycopy(a,fra,b,0,n); // kopierer a[fra:m> over i b[0:n>

        int i = 0, j = m, k = fra;     // løkkevariabler og indekser

        while (i < n && j < til)  // fletter b[0:n> og a[m:til>, legger
            a[k++] = c.compare(b[i],a[j]) <= 0 ? b[i++] : a[j++];  // resultatet i a[fra:til>

        while (i < n) a[k++] = b[i++];  // tar med resten av b[0:n>
    }

    public static <T>
    void flettesortering(T[] a, T[] b, int fra, int til, Comparator<? super T> c)
    {
        if (til - fra <= 1) return;     // a[fra:til> har maks ett element

        int m = (fra + til)/2;          // midt mellom fra og til

        flettesortering(a,b,fra,m,c);   // sorterer a[fra:m>
        flettesortering(a,b,m,til,c);   // sorterer a[m:til>

        flett(a,b,fra,m,til,c);         // fletter a[fra:m> og a[m:til>
    }

    public static <T> void flettesortering(T[] a, Comparator<? super T> c)
    {
        T[] b = Arrays.copyOf(a, a.length/2);
        flettesortering(a,b,0,a.length,c);  // kaller metoden over
    }

    public static <T> int parter(T[] a, int v, int h, T skilleverdi, Comparator<? super T> c)
    {
        while (v <= h && c.compare(a[v],skilleverdi) < 0) v++;
        while (v <= h && c.compare(skilleverdi,a[h]) <= 0) h--;

        while (true)
        {
            if (v < h) Tabell.bytt(a,v++,h--); else return v;
            while (c.compare(a[v],skilleverdi) < 0) v++;
            while (c.compare(skilleverdi,a[h]) <= 0) h--;
        }
    }

    public static <T> int parter(T[] a, T skilleverdi, Comparator<? super T> c)
    {
        return parter(a,0,a.length-1,skilleverdi,c);  // kaller metoden over
    }

    public static <T>
    int sParter(T[] a, int v, int h, int k, Comparator<? super T> c)
    {
        if (v < 0 || h >= a.length || k < v || k > h) throw new
                IllegalArgumentException("Ulovlig parameterverdi");

        bytt(a,k,h);   // bytter - skilleverdien a[k] legges bakerst
        int p = parter(a,v,h-1,a[h],c);  // partisjonerer a[v:h-1]
        bytt(a,p,h);   // bytter for å få skilleverdien på rett plass

        return p;    // returnerer posisjonen til skilleverdien
    }

    public static <T>
    int sParter(T[] a, int k, Comparator<? super T> c)   // bruker hele tabellen
    {
        return sParter(a,0,a.length-1,k,c); // v = 0 og h = a.lenght-1
    }

    private static <T>
    void kvikksortering(T[] a, int v, int h, Comparator<? super T> c)
    {
        if (v >= h) return;  // hvis v = h er a[v:h] allerede sortert

        int p = sParter(a,v,h,(v + h)/2,c);
        kvikksortering(a,v,p-1,c);
        kvikksortering(a,p+1,h,c);
    }

    public static <T>
    void kvikksortering(T[] a, Comparator<? super T> c) // sorterer hele tabellen
    {
        kvikksortering(a,0,a.length-1,c);
    }

    public static <T> int binærsøk(T[] a, int fra, int til, T verdi, Comparator<? super T> c)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;    // v og h er intervallets endepunkter

        while (v <= h)  // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;     // heltallsdivisjon - finner midten
            T midtverdi = a[m];  // hjelpevariabel for  midtverdien

            int cmp = c.compare(verdi, midtverdi);

            if (cmp > 0) v = m + 1;        // verdi i a[m+1:h]
            else if (cmp < 0) h = m - 1;   // verdi i a[v:m-1]
            else return m;                 // funnet
        }

        return -(v + 1);   // ikke funnet, v er relativt innsettingspunkt
    }

    public static <T> int binærsøk(T[] a, T verdi, Comparator<? super T> c)
    {
        return binærsøk(a,0,a.length,verdi,c);  // bruker metoden over
    }

    public static <T> void bytt(T[] a, int i, int j)
    {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T> int min(T[] a, int fra, int til, Comparator<? super T> c)
    {
        if (fra < 0 || til > a.length || fra >= til)
            throw new IllegalArgumentException("Illegalt intervall!");

        int m = fra;           // indeks til minste verdi i a[fra:til>
        T minverdi = a[fra];   // minste verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) if (c.compare(a[i], minverdi) < 0)
        {
            m = i;               // indeks til minste verdi oppdateres
            minverdi = a[m];     // minste verdi oppdateres
        }

        return m;  // posisjonen til minste verdi i a[fra:til>
    }

    public static <T> int min(T[] a, Comparator<? super T> c)  // bruker hele tabellen
    {
        return min(a,0,a.length,c);     // kaller metoden over
    }

    public static <T> void utvalgssortering(T[] a, Comparator<? super T> c)
    {
        for (int i = 0; i < a.length - 1; i++)
            bytt(a, i, min(a, i, a.length, c));  // to hjelpemetoder
    }

    public static <T> int maks(T[] a, Komparator<? super T> c) {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++)
            if (c.compare(a[i],maksverdi) > 0) {
                maksverdi = a[i];  // største verdi oppdateres
                m = i;             // indeks til største verdi oppdaters
            }
        return m;  // returnerer posisjonen til største verdi
    }

    // 1.4.3 Oppgave 8
    // public static void f(int a, Integer b) { }
    // public static void f(Integer a, int b) { }

    public static <T> void innsettingssortering(T[] a, Comparator<? super T> c)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi,a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    public static Integer[] randPermInteger(int n)
    {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }
    /*
    public static void bytt(Object[] a, int i, int j) {
        Object temp = a[i];
        a[j] = a[i];
        a[i] = a[j];
    }*/

    public static void skrivln(Object[] a) {
        skrivln(a, 0, a.length);
    }

    public static void skrivln(Object[] a, int fra, int til) {
        skriv(a, fra, til);
        System.out.println();
    }

    public static void skriv(Object[] a) {
        skriv(a, 0, a.length);
    }

    public static void skriv(Object[] a, int fra, int til) {
        System.out.print(a[0]);
        for(int i = fra; i < til; ++i) {
            System.out.print(" " + a[i]);
        }
    }

    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    public static <T extends Comparable<? super T>> int maks(T[] a)
    {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    } // maks

    public static int maks(char[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        char maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

    public static int maks(double[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }
    /*
    public static int maks(String[] a)    // legges i class Tabell
    {
        int m = 0;                          // indeks til største verdi
        String maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    }*/

    // 1.2.4: Oppgave 4
    public static void sortering(int[] a) {
        // Løsningsforslag
        for(int i = a.length; i > 1; i--) {
            int m = maks(a, 0, i);
            bytt(a, i-1, m);
        }
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
