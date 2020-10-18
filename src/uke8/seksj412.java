package uke8;

import felles.Tabell;

import java.util.StringJoiner;

public class seksj412 {
    public static void main(String[] args) {

    }
/*
    // Opg 1
    static void nullstill() {
        for (int i = 0; i < antall; i++) a[i] = null;
        antall = 0;
    }

    // opg 2 - med stringjoiner
    public String toString() {
        StringJoiner s = new StringJoiner(", ", "[", "]");
        for (int i = antall - 1; i >= 0; i--)
            s.add(a[i] == null ? "null" : a[i].toString());
        return s.toString();
    }

    public String toString2()  // bruker StringBuilder
    {
        if (tom()) return "[]";

        StringBuilder s = new StringBuilder();
        s.append('[');
        s.append(a[antall-1]); // legger øverste verdi i stacken i stringen

        // legger inn øverste verdi i stacken i stringen
        for (int i = antall - 2; i >= 0; i--)
            s.append(',').append(' ').append(a[i]);

        s.append(']');

        return s.toString();
    }

    // Opg 3
    public static <T> void snu(Stakk<T> A) {
        Stakk<T> B = new TabellStack<T>(antall);
        Stakk<T> C = new TabellStack<T>(antall);

        while(!A.tom()) B.leggInn(A.taut());
        while(!B.tom()) C.leggInn(B.taUt());
        while(!C.tom()) A.leggInn(C.taUt());
    }

    // Opg 4
    public static <T> void kopier(Stakk<T> A, Stakk<T> B) {
        Stakk<T> C = new TabellStakk<>();

        while(!A.tom()) C.leggInn(A.taUt());
        while(!C.tom()) {
            T t = C.taUt(); // henter øverste objektet i C
            B.leggInn(t); // legger inn temp i B
            A.leggInn(t); // legger inn temp i A
            // A og B inneholder nå de samme verdiene (den samme stacken)
        }
    }

    // Opg 5
    public static <T> void snu(Stakk<T> A) {
        Stakk<T> B = new TabellStack<T>(antall);
        int n = A.antall() - 1;

        while(n > 0) {
            T temp = A.taUt();
            for(int j = 0; j < n; j++) B.leggInn(A.taUt());
            while(!B.tom()) A.leggInn(B.taUt());
            A.leggInn(temp);
            n--;
        }
    }

    // opg 6
    public static <T> void kopier(Stakk<T> A, Stakk<T> B)
    {
        int n = A.antall();

        while (n > 0)
        {
            for (int j = 0; j < n; j++) B.leggInn(A.taUt());
            T temp = B.kikk();
            for (int j = 0; j < n; j++) A.leggInn(B.taUt());
            B.leggInn(temp);
            n--;
        }
    }

    // Opg 7
    // sorterer slik at den minste kommer øverst på stakken
    public static <T> void sorter(Stakk<T> A, Comparator<? super T> c) {
        Stakk<T> B = new TabellStakk<T>();
        T temp; int n = 0;

        while (!A.tom())
        {
            temp = A.taUt();
            n = 0;
            while (!B.tom() && c.compare(temp,B.kikk()) < 0)
            {
                n++; A.leggInn(B.taUt());
            }
            B.leggInn(temp);
            for (int i = 0; i < n; i++) B.leggInn(A.taUt());
        }

        while (!B.tom()) A.leggInn(B.taUt());
    }*/
}
