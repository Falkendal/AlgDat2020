package uke5.oppgaver;

import java.util.Arrays;

public class opg151 {
    public static void main(String[] args) {
        // Oppgave 1
        int n = 2;
        int res = a(n);
        System.out.println(res);

        // Oppgave 3
        int t = 4324;
        int tverrsum = tverrsum(t);
        System.out.println(tverrsum);

        // Oppgave 4
        int sr = 65432352;
        System.out.println(sifferrot(sr));

        // Oppgave 7
        int ks = 4;
        System.out.println(kvadratsum(ks));
    }

    // Oppgave 1
    static int a(int n) {
        int x = 0, y = 1, z = 1;

        for (int i = 0; i < n; i++)
        {
            z = 2*y + 3*x; x = y; y = z;
        }
        return z;
    }

    // Oppgave 3
    public static int tverrsum(int n)
    {
        int sum = 0;

        while (n > 0)
        {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    // Oppgave 4
    public static int sifferrot(int n) {
        while (n >= 10) {
            n = tverrsum(n);
        }

        return n;
    }

    // Oppgave 7
    public static int kvadratsum(int n)
    {
        if (n == 1) return 1;
        else return kvadratsum(n-1) + n*n; // Formel for kvardratsum: n*(n + 1)*(2*n + 1)/6
    }
}
