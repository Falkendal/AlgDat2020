package uke5;

public class recursiveBinarySearch {
    public static void main(String[] args) {
        int[] values = {1,2,4,8, 17, 19, 22};

        for(int i = 0; i < 25; ++i)
            System.out.println("tallet "+ i + " gir indeks " + binarySearch(i, values, 0, values.length-1));
    }

    // Search in the interval [left, right] -> lukkede intervaller. (Er som regel det når man bruker høyre/venstre)
    static int binarySearch(int searchValue, int[] values, int left, int right) {
        int middle = (left + right) / 2;

        if(right - left == 0) {
            if(values[middle] == searchValue) {
                return middle; // returnerer indeksen til der vi fant elementet
            }
            return -middle; // returnerer minus, fordi da viser vi at vi ikke fant elementet. Men vi viser faktisk poisjonen det burde være på
        }

        if(values[middle] <= searchValue) {
            if(values[middle] == searchValue) {
                return middle; // returnerer indeksen til der vi fant elementet
            }
            return binarySearch(searchValue, values, middle+1, right);
        } else {
            return binarySearch(searchValue, values, left, middle-1);
        }
    }
}
