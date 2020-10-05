package uke2.oppgaver;
// Oppgave 1.2.1 - Oppgave 1
public class seksj121 {

    public static void main(String[] args) {
        // Oppgave 1
        System.out.println("Oppgave 1");
        int[] a = {34,67,3,76,2,22,15,90};

        int minste_indeks = min(a);

        System.out.println("Minste: " + minste_indeks);

        // Oppgave 5 - For-each løkke
        System.out.println("\nOppgave 5");
        for(int k : a) {
            System.out.print(k + " ");
        }
    }

    public static int min(int[] a)  // bruker hele tabellen
    {
        return min(a,0,a.length);     // kaller metoden over
    }

    public static int min(int[] a, int fra, int til)
    {
        if (fra < 0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

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
}
