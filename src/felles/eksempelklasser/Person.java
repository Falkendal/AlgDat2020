package felles.eksempelklasser;

import felles.Tabell;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Person implements Comparable<Person>
{
    private final String fornavn;         // personens fornavn
    private final String etternavn;       // personens etternavn

    public Person(String fornavn, String etternavn)   // konstruktør
    {
        if(fornavn == null || etternavn == null) {
            if(fornavn == null) {
                throw new NullPointerException("Fornavn som er gitt er NULL, vennligst sjekk at koden er riktig og prøv igjen.");
            } else {
                throw new NullPointerException("Etternavn er gitt er NULL, vennligst sjekk at koden er riktig og prøv igjen.");
            }
        }
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String fornavn() { return fornavn; }       // aksessor
    public String etternavn() { return etternavn; }   // aksessor

    public int compareTo(Person p)    // pga. Comparable<Person>
    {
        int cmp = etternavn.compareTo(p.etternavn);     // etternavn
        if (cmp != 0) return cmp;             // er etternavnene ulike?
        return fornavn.compareTo(p.fornavn);  // sammenligner fornavn
    }

    public boolean equals(Object o)      // vår versjon av equals
    {
        // 2e
        if (o == this) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        final Person p = (Person)o;           // typekonvertering
        return etternavn.equals(p.etternavn) && fornavn.equals(p.fornavn);

        /* Gammel kode før endring
            if (o == this) return true;
            if (!(o instanceof Person)) return false;
            return compareTo((Person)o) == 0;
         */
    }

    public boolean equals(Person p) {
        if (p == this) return true;           // er det samme objekt?
        if (p == null) return false;          // null-argument
        return etternavn.equals(p.etternavn) && fornavn.equals(p.fornavn);
    }

    public int hashCode() { return Objects.hash(etternavn, fornavn); }

    public String toString() { return String.join(" ", fornavn, etternavn); }

    public static void main(String[] args) {
        // 1.4.4 Oppgave 2a
        Person[] p = new Person[8];                   // en persontabell

        p[0] = new Person("Kari","Svendsen");         // Kari Svendsen
        p[1] = new Person("Boris","Zukanovic");       // Boris Zukanovic
        p[2] = new Person("Ali","Kahn");              // Ali Kahn
        p[3] = new Person("Azra","Zukanovic");        // Azra Zukanovic
        p[4] = new Person("Kari","Pettersen");        // Kari Pettersen
        p[5] = new Person("Roy","Roysen");
        p[6] = new Person("Frans","Kristensen");
        p[7] = new Person("Guri","Gurke");

        int m = Tabell.maks(p);                       // posisjonen til den største
        System.out.println(p[m] + " er størst");      // skriver ut den største

        // Arrays.sort(p); // oppgave 2c
        Tabell.innsettingssortering(p);               // generisk sortering
        System.out.println(Arrays.toString(p));       // skriver ut sortert

        // 1.4.4 Oppgave 2h
        //System.out.println(p[0].toString());

        // 1.4.4 Oppgave 2i
        Stream s = Arrays.stream(p);
        Optional<Person> resultat = s.max(Comparator.naturalOrder());
        resultat.ifPresent(System.out::println);

        // 1.4.4 Oppgave 2j -> Gjør 2i til en kodelinje:
        Arrays.stream(p).max(Comparator.naturalOrder()).ifPresent(System.out::println);
    }


} // class Person
