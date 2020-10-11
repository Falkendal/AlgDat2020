package uke4;

public class GenericsTest {
    public static void main(String[] args) {
        Integer[] a = {1,8,9,345,7,423};
        Character[] b = {'A', 'C', 'K', 'L', 'Z', 'Y', 'M'};
        String[] c = {"ASF", "Kari", "poteter", "lammelår", "eple", "Petter"};
        Person[] d = {new Person("Petter", "Pettersen"), new Person("Kari", "Pettersen"), new Person("Nils", "Abrahamsen"), new Person("Tor", "Toresen")};

        // Ikke generiske
        System.out.println("Maks av int-array:");
        System.out.println(maks(a));

        System.out.println("Maks av char-array:");
        System.out.println(maks(b));

        // Generiske
        System.out.println("Generic Maks av int-array:");
        System.out.println(maks_generic(a));

        System.out.println("Generic Maks av char-array:");
        System.out.println(maks_generic(b));

        System.out.println("Generic Maks av string-array:");
        System.out.println(maks_generic(c));

        System.out.println("Generic Maks av Person-array:");
        System.out.println(maks_generic(d));
    }

    public static class Person implements Comparable<Person> {
        String first_name;
        String last_name;

        Person(String first_name, String last_name) {
            this.first_name = first_name;
            this.last_name = last_name;
        }

        public int compareTo(Person other) {
            /*
            if (this.last_name < other.last_name) {
                return -1;
            } else if(this.last_name == other.last_name) {
                return 0;
            } else {
                return 1;
            }
            */
            int last_compare = this.last_name.compareTo(other.last_name);
            if(last_compare == 0) {
                return this.first_name.compareTo(other.first_name);
            } else {
                return last_compare;
            }
        }
    }

    static
    <T extends Comparable<? super T>>
    int maks_generic(T[] values) {
        T currentMax = values[0];
        int current_index = 0;

        for(int i = 1; i < values.length; ++i) {
            //if(values[i] > currentMax) {
            if(values[i].compareTo(currentMax) > 0) { // Må bruke funksjonen compareTo når man bruker generiske funksjoner
                currentMax = values[i];
                current_index = i;
            }
        }

        return current_index;
    }

    // To funksjoner som er like, bare at den ene tar inn int og den andre char
    static int maks(Integer[] values) {
        int currentMax = values[0];
        int current_index = 0;

        for(int i = 1; i < values.length; ++i) {
            if(values[i] > currentMax) {
                currentMax = values[i];
                current_index = i;
            }
        }

        return current_index;
    }

    static int maks(Character[] values) {
        char currentMax = values[0];
        int current_index = 0;

        for(int i = 1; i < values.length; ++i) {
            if(values[i] > currentMax) {
                currentMax = values[i];
                current_index = i;
            }
        }

        return current_index;
    }
}
