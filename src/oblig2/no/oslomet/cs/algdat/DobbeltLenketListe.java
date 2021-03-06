package oblig2.no.oslomet.cs.algdat;


////////////////// class DobbeltLenketListe //////////////////////////////

import oblig2.no.oslomet.cs.algdat.Liste;

import javax.management.NotificationEmitter;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public static void fratilKontroll(int antall, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new IndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > antall)                          // til er utenfor tabellen
            throw new IndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + antall + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    private Node<T> finnNode(int indeks) {
        Objects.requireNonNull(indeks, "indeks kan ikke være null!");

        if(indeks < antall/2) {
            Node<T> p = hode;
            for(int i = 0; i < indeks; i++) {
                p = p.neste;
            }
            return p;
        } else {
            Node<T> p = hale;
            for(int i = antall; i > indeks; i--) {
                p = p.forrige;
            }

            return p;
        }
    }

    public DobbeltLenketListe() {
        hode = hale = null;
        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
        this();

        Objects.requireNonNull(a, "Tabellen kan ikke være null!");
        if(a == null) throw new NullPointerException("Tabellen a er null!");

        int i = 0;
        for(; i < a.length && a[i] == null; i++);

        if(i < a.length) {
            Node<T> p = hode = new Node<>(a[i], null, null);
            antall = 1;

            for(i++; i < a.length; i++) {
                if(a[i] != null) {
                    p = p.neste = new Node<>(a[i], p, null);
                    antall++;
                }
            }
            hale = p;
        }
    }

    public Liste<T> subliste(int fra, int til) {
        fratilKontroll(antall, fra, til);

        DobbeltLenketListe<T> liste = new DobbeltLenketListe<>();

        Node<T> p = finnNode(fra);
        liste.leggInn(p.verdi);

        p = p.neste;
        for(int i = fra; i < til; i++) {
            liste.leggInn(p.verdi);
            p = p.neste;
        }

        return liste;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "tilltater ikke nullverdier");

        if(antall == 0) {
            hode = hale = new Node<>(verdi, null, null);
        } else {
            hale = hale.neste = new Node<>(verdi, hale, null);
        }

        antall++;
        endringer++;
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "Ikke tillat med null-verdier");
        indeksKontroll(indeks, true);

        if(indeks == 0) {
            hode = new Node<>(verdi, null, hode.neste);
            if(antall == 0) hale = hode;
        } else if(indeks == antall) {
            hale.neste = new Node<>(verdi, hale, null);
            hale = hale.neste;
        } else {
            Node<T> p = hode;
            for(int i = 1; i < indeks; i++) {
                p = p.neste;
            }
            p.neste = new Node<>(verdi, p, p.neste.neste);
        }

        endringer++;
        antall++;
    }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);

        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        if(verdi == null) return -1;

        Node<T> p = hode;

        for(int i = 0; i < antall; i++) {
            if(p.verdi.equals(verdi)) {
                return i;
            }
            p = p.neste;
        }
        return -1;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        Objects.requireNonNull(nyverdi, "Ikke tillatt med null-verdier!");

        indeksKontroll(indeks, false);

        Node<T> p = finnNode(indeks); // p er noden som skal endres
        T gammelverdi = p.verdi; // gammel verdi er den verdien p har nå

        p.verdi = nyverdi; // p.verdi er nå lik den nye verdien

        endringer++;

        return gammelverdi;
    }

    @Override
    public boolean fjern(T verdi) {
        if(verdi == null) return false;

        Node<T> q = hode, p = null;

        while(q != null) {
            if(q.verdi.equals(verdi)) break;
            p = q; q = q.neste;
        }

        if(q == null) return false;
        else if (q == hode) hode = hode.neste;
        else p.neste = q.neste; p.forrige = q.forrige;

        if(q == hale) hale = p;

        q.verdi = null;
        q.neste = null;
        q.forrige = null;

        antall--;
        endringer++;
        return true;
    }

    @Override
    public T fjern(int indeks) {
        indeksKontroll(indeks, false);
        T temp;

        if (indeks == 0) {
            temp = hode.verdi;
            if(antall > 1) {
                hode = hode.neste;
                hode.forrige = null;
            } else {
                hale = null;
                hode.neste = null;
            }
        } else if (indeks == antall-1) {
            temp = hale.verdi;
            Node<T> tempHale = hale;
            hale = hale.forrige;
            tempHale.forrige = null;
            hale.neste = null;
        } else {
            Node<T> p = finnNode(indeks);
            temp = p.verdi;
            p.forrige.neste = p.neste;
            p.neste.forrige = p.forrige;
        }

        antall--;
        endringer++;
        return temp;
    }

    @Override
    public void nullstill() {
        Node<T> p = hode;
        for(int i = 0; i < antall; i++) {
            p = null;
            p.forrige = null;
            p = p.neste;
        }
        hode = hode.neste = hale = hale.neste = null;
        antall = 0;
        endringer++;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("[");

        if(!tom()) {
            Node<T> p = hode;
            s.append(p.verdi);

            p = p.neste;

            while(p != null) {
                s.append(',').append(' ').append(p.verdi);
                p = p.neste;
            }
        }

        s.append(']');

        return s.toString();
    }

    public String omvendtString() {
        StringBuilder s = new StringBuilder();

        s.append("[");

        if(!tom()) {
            Node<T> p = hale;
            s.append(p.verdi);

            p = p.forrige;

           while(p != null) {
               s.append(",").append(" ").append(p.verdi);
               p = p.forrige;
           }
        }

        s.append("]");

        return s.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator(){
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext(){
            return denne != null;
        }

        @Override
        public T next(){
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


