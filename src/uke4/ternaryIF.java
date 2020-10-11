package uke4;

public class ternaryIF {
    public static void main(String[] args) {
        for(int i = 0; i< 10; ++i) {
            int a = i;
            int b = myTernaryIfTest(a);
            System.out.println(b);
        }

        int a = 17;
        int b = (a < 5) ? 13 : 17;

    }

    public static int myTernaryIfTest(int value) {
        /*
        // dette returnerer det samme som return under
        if(value < 5)
            return 0;
        else
            return 98;
        */

        // if (value < 5) THEN return 0 ELSE 98
        return (value < 5) ? 0 : 98;
    }
}
