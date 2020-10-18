package uke8;

public class seksj421 {
    /*
    // A
    public static <T> T hent(Kø<T> kø, int indeks)
    {
        if (indeks < 0 || indeks >= kø.antall())
            throw new IndexOutOfBoundsException("Ulovlig indeks!");

        for (int i = 0; i < indeks; i++) kø.leggInn(kø.taUt());

        T verdi = kø.kikk();

        int n = kø.antall();
        for (int i = indeks; i < n; i++) kø.leggInn(kø.taUt());

        return verdi;
    }

    // B
    public static <T> boolean leggInn(Kø<T> kø, int indeks, T verdi)
    {
        if (indeks < 0 || indeks > kø.antall())  // indeks = kø.antall() er lovlig!
            throw new IndexOutOfBoundsException("Ulovlig indeks!");

        for (int i = 0; i < indeks; i++) kø.leggInn(kø.taUt());

        kø.leggInn(verdi);

        int n = kø.antall();
        for (int i = indeks + 1; i < n; i++) kø.leggInn(kø.taUt());

        return true;
    }

    // C
    public static <T> void bytt(Kø<T> kø, int indeks1, int indeks2)
    {
        if (indeks2 < indeks1) // bytter om hvis dette er sant
        {
            int indeks = indeks1;
            indeks1 = indeks2;
            indeks2 = indeks;
        }

        // nå er indeks1 <= indeks2

        if (indeks1 < 0 || indeks2 >= kø.antall())
            throw new IndexOutOfBoundsException("Ulovlig indeks!");

        if (indeks1 == indeks2) return;  // ingen bytting

        int n = kø.antall();

        for (int i = 0; i < indeks1; i++)
        {
            kø.leggInn(kø.taUt());  // finner indeks1
        }

        T verdi = kø.taUt();      // tar ut den som var på indeks1

        for (int i = indeks1 + 1; i < indeks2; i++)
        {
            kø.leggInn(kø.taUt());  // finner indeks2
        }

        kø.leggInn(verdi);        // legger inn bakerst
        verdi = kø.taUt();        // tar ut den som var på indeks2

        for (int i = indeks2 - indeks1 + 1; i < n; i++)
        {
            kø.leggInn(kø.taUt());  // finner indeks1 på nytt
        }

        kø.leggInn(verdi);        // legger inn bakerst

        for (int i = indeks1 + 1; i < n; i++)
        {
            kø.leggInn(kø.taUt());  // flytter køen slik den var
        }
    }*/
}
