package uke4.oppgaver;

import felles.Tabell;

public class opg141 {
    public static void main(String[] args) {
        // 1.4.1
        // Oppgave 1, 2 og 3.
        int[] intliste = {5,2,7,3,9,1,8,4,6};
        double[] doubleliste = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] stringliste = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        char[] charliste = "JASMIN".toCharArray();
        Integer[] integerliste = {5,2,7,3,9,1,8,4,6};

        // Oppgave 4
        // Hvis a er mindre enn b, vil a.compareTo(b) returnere -1, hvis de er like, vil metodekallet returnere 0 og hvis a er større enn b, blir det 1.

        // Oppgave 5
        /*
        - Metoden compareTo i class String virker slik: Hvis strengen s er forskjellig fra strengen t, s ikke utgjør første del av t og t ikke utgjør første del av s, så finnes det en første posisjon der s og t har forskjellige tegn.
        La f.eks. s = "Jasmin" og t = "Jason". Første posisjon der disse er forskjellige, er posisjon 3 siden tegnet m er forskjellig fra tegnet o. (Obs. første posisjon i en streng er 0).
        Metoden compareTo returnerer da differansen mellom ascii-verdiene til disse to tegnene. I dette tilfellet vil s.compareTo(t) returnere 'm' - 'o' = -2.

        - Hvis s og t er gitt slik som i oppgaveteksten, dvs. s = "A" og t = "B", vil s.compareTo(t) returnere verdien 'A' - 'B' = -1.

        - Problemet med Æ, Ø og Å er at de er plassert i feil innbyrdes rekkefølge i både UTF-8, Unicode og ISO-8859-1. Se Avsnitt 1.4.9.

        - Vi får et spesialtilfelle hvis s utgjør første del av t eller t første del av s. F.eks. s = "Karianne" og t = "Kari". Da vil s.compareTo(t) returnere differansen mellom de to strengenes lengder. I dette tilfellet blir det 8 - 4 = 4.
        Legg også merke til at s eller t eller begge, kan være tomme. Hvis f.eks. s = "" og t = "Petter", utgjør egentlig s første del av t. Dermed vil s.compareTo(t) returnere verdien 0 - 6 = -6.

         - Til slutt får vi at s.compareTo(t) vil returnere 0 hvis s og t har nøyaktig samme innhold.
         */
        String a = "Æ", b = "Å";
        System.out.println(a.compareTo(b));

        // Oppgave 6
        System.out.println(Boolean.compare(false, true));

        // Kaller på funksjonene som ligger i klassen Tabell
        // Finner posisjonen til den største verdien i lista
       /* int ints = Tabell.maks(intliste);
        int doubles = Tabell.maks(doubleliste);
        int strings = Tabell.maks(stringliste);
        int chars = Tabell.maks(charliste);
        int Integers = maks(integerliste);
        System.out.println(intliste[ints] + "  " + doubleliste[doubles] + "  " + stringliste[strings] + " " +  charliste[chars] + " " + integerliste[Integers]);
        */
    }

    public static int maks(Integer[] a)    // legges i class Tabell
    {
        int m = 0;                          // indeks til største verdi
        Integer maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    }
}
