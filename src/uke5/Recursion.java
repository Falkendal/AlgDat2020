package uke5;

public class Recursion {
    public static void main(String[] args) {
        int value = 15;
        int return_value = recursiveFuntion(value);
        System.out.println("Main: "+return_value);


        int five_factorial = factorial(5);
        System.out.println("5! = " + five_factorial);

        System.out.println("8! = " + factorial(8));

        System.out.println("52! = " + factorial(52));
    }

    /**
     * This function calculates n! (n factorial) using a recursive function call
     * @param n - Value to compute the factorial of
     * @return n! - n factorial
     */
    static int factorial(int n) {
        if(n == 1) {
            return 1;
        } else {
            // 10! = 10*9!, 9! = 9*8! ... 1! = 1
            return n*factorial(n-1);
        }
    }

    static int recursiveFuntion(int value) {
        System.out.println("Rekursiv funksjon: " + value);

        if(value <= 5) {
            return -9;
        } else {
            return recursiveFuntion(value-1);
        }
    }
}
