package felles;

import felles.eksempelklasser.Komparator;
import felles.eksempelklasser.Person;
import felles.eksempelklasser.Student;
import felles.eksempelklasser.Studium;

import java.util.*;

public class Tabell {

    // Konstruktør
    private Tabell() {}

    // Main
    public static void main(String ... args)      // hovedprogram
    {
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
        /*
        System.out.print("\nOppgave 1: ");
        int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
        int[] b = Tabell.nestMaks2(a);  // metoden returnerer en tabell

        int m = b[0], nm = b[1];       // m for maks, nm for nestmaks

        Tabell.skrivln(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);*/

        // 1.4.2 Oppgave 1
        /*
        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        int k = Tabell.maks(s);        // hvilken maks-metode? Den som har String[] som parameter, fordi om det allerede finnes en metode/funksjon med samme datatype og signatur, vil den velges.
        System.out.println(s[k]);      // Utskrift:  Thanh
        */
        // 1.4.2 Oppgave 2
        /*
        String[] s = {"Per","Kari","Ole","Anne","Ali","Eva"};
        Tabell.innsettingssortering(s);
        System.out.println(Arrays.toString(s));  // [Ali, Anne, Eva, Kari, Ole, Per]
        */

        // 1.4.3 Oppgave 2
        /*
        String s = Integer.toUnsignedString(-1);
        String t = Integer.toUnsignedString(Integer.MIN_VALUE);
        System.out.println(s + " " + t);  // 4294967295 2147483648

        int k1 = -1 / 10;                        // kvotient k1 = -(1/10) = 0
        int k2 = Integer.divideUnsigned(-1,10);  // kvotient
        System.out.println(k1 + " " + k2);       // 0 429496729

        int d1 = Integer.compare(-1, 1);
        int d2 = Integer.compareUnsigned(-1, 1);
        System.out.println(d1 + " " + d2);       // -1 1
        */

        // 1.4.3 Oppgave 6
        /*
        Integer[] a = Tabell.randPermInteger(20);
        System.out.println(Arrays.toString(a));
        // En mulig utskrift: [7, 1, 8, 2, 10, 3, 4, 6, 5, 9]

        Tabell.innsettingssortering(a);
        System.out.println(Arrays.toString(a));
        // Utskrift: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        */

        // 1.4.3 Oppgave 7
        /*
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};

        Double[] e = new Double[d.length];

        for(int i = 0; i < e.length; ++i) {
            e[i] = d[i];
        }

        System.out.println(Arrays.toString(e));
        */

        // 1.4.3 Oppgave 8
        /*
        f(1,1);

        // kan bestemme hvilken av metodene som brukes ved å gjøre slik:
        f(1, (Integer)1);  // nå brukes f(int a, Integer b)
        f((Integer)1,1);   // f(Integer a, int b)
        */

        // 1.4.6 Oppgave 1
        Person[] p = new Person[5];                       // en persontabell
        p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

        /* NR 1
        class FornavnKomparator implements Komparator<Person>
        {
            public int compare(Person p1, Person p2)        // to personer
            {
                return p1.fornavn().compareTo(p2.fornavn());  // sammenligner fornavn
            }
        }

        Komparator<Person> c = new FornavnKomparator();   // en instans av klassen
        Tabell.innsettingssortering(p, c);                // se Programkode 1.4.6 b)

        System.out.println(Arrays.toString(p));           // Utskrift av tabellen p
        // utskrift: [Ali Kahn, Azra Zukanovic, Boris Zukanovic, Kari Svendsen, Kari Pettersen]*/

        // NR 2 => mer forkortet enn NR 1
        /*
        Komparator<Person> c = (p1,p2) -> p1.fornavn().compareTo(p2.fornavn());
        Tabell.innsettingssortering(p, c);                // se Programkode 1.4.6 b)
        System.out.println(Arrays.toString(p));*/

        // NR 3 => mer forkortet enn NR 2
        /*
        Tabell.innsettingssortering(p, (p1,p2) -> p1.fornavn().compareTo(p2.fornavn()));
        System.out.println(Arrays.toString(p));*/

        // 1.4.6 Oppgave 2
        /*
        Student[] s = new Student[9];                             // en studenttabell
        s[0] = new Student("Kari","Svendsen", Studium.Data);      // Kari Svendsen
        s[1] = new Student("Boris","Zukanovic", Studium.IT);      // Boris Zukanovic
        s[2] = new Student("Ali","Kahn", Studium.Anvendt);        // Ali Kahn
        s[3] = new Student("Azra","Zukanovic", Studium.IT);       // Azra Zukanovic
        s[4] = new Student("Kari","Pettersen", Studium.Data);     // Kari Pettersen
        // utvider...
        s[5] = new Student("Fred", "Fredriksen", Studium.Elektro);
        s[6] = new Student("Nils", "Roger", Studium.Elektro);
        s[7] = new Student("Knut", "Knutiii", Studium.Enkeltemne);
        s[8] = new Student("Loke", "Opheim", Studium.Enkeltemne);

        Tabell.innsettingssortering(s, (s1,s2) ->
        {
            int cmp = s1.studium().compareTo(s2.studium());
            return cmp != 0 ? cmp : s1.compareTo(s2);
        });    // Programkode 1.4.6 b)

        System.out.println(Arrays.toString(s));
        */

        // 1.4.6 Oppgave 3
        // Sorterer studenter etter studium, fornavn og etternavn
        /*Tabell.innsettingssortering(s, (s1,s2) ->
        {
           int k = s1.studium().compareTo(s2.studium());
           if(k != 0) return k;
           k = s1.fornavn().compareTo(s2.fornavn());
           if(k != 0) return k;
           return s1.etternavn().compareTo(s2.etternavn());
        });*/

        // 1.4.6 Oppgave 5
        /*
        String[] s = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        Tabell.innsettingssortering(s, (s1,s2) -> {
            int k = s1.length() - s2.length();
            return k != 0 ? k : s1.compareTo(s2);
        });

        System.out.println(Arrays.toString(s));
        */

        // 1.4.6 Oppgave 7
        /*
        String[] s = {"21","18","8","13","20","6","16","25","3","10"};
        Komparator<Student> c = (s1,s2) ->
        {
            int cmp = s1.studium().name().compareTo(s2.studium().name());
            return cmp != 0 ? cmp : s1.compareTo(s2);
        };

        Tabell.innsettingssortering(s, c);    // Programkode 1.4.6 b)
        System.out.println(Arrays.toString(s));
        */
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

    public static <T> void innsettingssortering(T[] a, Komparator<? super T> c)
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

    public static void bytt(Object[] a, int i, int j) {
        Object temp = a[i];
        a[j] = a[i];
        a[i] = a[j];
    }

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
