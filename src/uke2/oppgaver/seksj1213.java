package uke2.oppgaver;

import java.util.Arrays;

public class seksj1213 {
    public static void main(String[] args) {
        // 1.2.13
        // 1)
        int[] a = Tabell.randPerm(5);
        int[] b = Tabell.randPerm(5);
        int[] binærtreListe = nestMaksOpg(a);

        // 3)
        // a kopieres inn først i b
        System.arraycopy(a, 0, b, 0, a.length);

        // a kopieres inn bakerst i b
        System.arraycopy(a, 0, b, b.length - a.length, a.length);

        // a kopieres inn på midten av b
        System.arraycopy(a, 0, b, (b.length - a.length)/2,a.length);
    }

    // 1)
    public static int[] nestMaksOpg(int[] a)   // en turnering
    {
        int n = a.length;                // for å forenkle notasjonen

        if (n < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + n + ") < 2!");

        int[] b = new int[2*n];          // turneringstreet
        System.arraycopy(a,0,b,n,n);     // legger a bakerst i b

        for (int k = 2*n-2; k > 1; k -= 2)   // lager turneringstreet
            b[k/2] = Math.max(b[k],b[k+1]);

        System.out.println(Arrays.toString(b)); // printer ut b

        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2*n - 1, k = 2; k < m; k *= 2)
        {
            int tempverdi = b[k+1];  // ok hvis maksverdi er b[k]
            if (maksverdi != b[k]) { tempverdi = b[k]; k++; }
            if (tempverdi > nestmaksverdi) nestmaksverdi = tempverdi;
        }

        return new int[] {maksverdi,nestmaksverdi}; // størst og nest størst

    } // nestMaks

    // 2) (fra fasit)
    public static void kopier(int[] a, int i, int[] b, int j, int ant) {
        for (int n = i + ant; i < n; ) {
            b[j++] = a[i++];
        }
    }
}
