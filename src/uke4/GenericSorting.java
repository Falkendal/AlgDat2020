package uke4;

import java.util.Arrays;

public class GenericSorting {

    public static class Person implements Comparable<Person> { //
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

        public String toString() {
            return first_name + " " + last_name;
        }
    }

    public static void main(String[] args) {
        // Alle disse implementerer comparable-interfacet:
        Integer[] a = {1, 8, 9, 345, 7, 423};
        Character[] b = {'A', 'C', 'K', 'L', 'Z', 'Y', 'M'};
        String[] c = {"ASF", "Kari", "poteter", "lammelår", "eple", "Petter"};
        Person[] d = {new Person("Petter", "Pettersen"), new Person("Kari", "Pettersen"), new Person("Nils", "Abrahamsen"), new Person("Tor", "Toresen")};

        //
        int person_max_index = maks(d, 0, d.length);
        System.out.println("Siste person, leksikografisk, er " + d[person_max_index].toString()); // bruker toString()-hjelpemetoden i klassen Person.

        System.out.println("Sorterer personer:");
        System.out.println("Før: " + Arrays.toString(d));
        sort(d);
        System.out.println("Etter: " + Arrays.toString(d));
    }

    static
    <T extends Comparable<? super T>>
    void sort(T[] values) {
        // Looper over alle uutenom siste element
        for(int i = 0; i < values.length-1; ++i) {
            // Finn største element i intervallet [i, a.length)
            int maks_index = maks(values, i, values.length);

            // bytt største element til posisjon i
            T temp = values[i];
            values[i] = values[maks_index];
            values[maks_index] = temp;

            // fortsett
        }
    }

    // Finner indeks til maks
    static
    <T extends Comparable<? super T>> // "vi lover at denne T-typen som kommer inn,at den må være noe som implementerer comparable-interfacet"
    int maks(T[] values, int begin, int end) {
        T currentMax = values[begin];
        int current_index = begin;

        for(int i = begin+1; i < end; ++i) {
            //if(values[i] > currentMax) {
            if(values[i].compareTo(currentMax) > 0) { // Må bruke funksjonen compareTo når man bruker generiske funksjoner
                currentMax = values[i];
                current_index = i;
            }
        }

        return current_index;
    }
}
