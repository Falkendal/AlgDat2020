package uke5;

import javax.naming.PartialResultException;
import java.util.Arrays;

public class RecursivePermution {
    public static void main(String[] args) {
        System.out.println("Recursive permutation!");

        int values[] = {1,2,3}; // kan legge til flere elementer
        recursivePermutation(values, 0);
    }

    // Rekursiv funksjon - huskeliste
    // 1. En rekursiv funksjon må kalle seg selv
    // 2. Den må forenkle argumentene - må ta inn argument(er)
    // 3. Ende i et basis tilfelle
    static void recursivePermutation(int[] values, int k) {
        if(k == values.length-1) {
            System.out.println(Arrays.toString(values));
        }
        // [1],2,3 => 1,3,2
        // 2,[1],3 => 2,3,1
        // 3,2,[1] => 3,1,2
        for(int i = k; i < values.length; ++i) {
            swap(values, i, k);
            recursivePermutation(values, k+1);
            swap(values, k, i);
        }
        //recursivePermutation(values);
    }

    public static void swap(int[] values, int m, int n) {
        // eks. m = 2, n = 3
        // tmp = values[2];
        int temp = values[m];
        // values[2] = values[3];
        values[m] = values[n];
        // values[3] = temp;
        values[n] = temp;
    }
}
