package oblig2.no.oslomet.cs.algdat;

public class kjøreOblig2 {
    public static void main(String[] args) {
        // Oppgave 1
        /*Liste<String> liste = new DobbeltLenketListe<>();
        System.out.println(liste.antall() + " " + liste.tom());*/
        /*String[] s = { "Ole" , null , "Per" , "Kari ", null };
        Liste<String> liste = new DobbeltLenketListe<>(s);
        System.out.println(liste.antall() + " " + liste.tom());*/

        // Oppgave 2a
        /*String[] s1 = {}, s2 = { "A" }, s3 = {null, "A" ,null, "B" ,null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);
        System. out .println(l1.toString() + " " + l2.toString()
                + " " + l3.toString() + " " + l1.omvendtString() + " "
                + l2.omvendtString() + " " + l3.omvendtString());*/

        // Oppgave 2b
        /*DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();
        System. out .println(liste.toString() + " " + liste.omvendtString());
        for ( int i = 1; i <= 3; i++)
        {
            liste.leggInn(i);
            System. out .println(liste.toString() + " " + liste.omvendtString());
        }*/

        // Oppgave 3b
        Character[] c = { 'A' , 'B' , 'C' , 'D' , 'E' , 'F' , 'G' , 'H' , 'I' , 'J'};
        DobbeltLenketListe<Character> liste = new DobbeltLenketListe<>(c);
        Integer[] i = { 1 , 2 , 3 , 4 , 7 , 9 , 11 , 14 , 16 , 18};
        DobbeltLenketListe<Integer> liste1 = new DobbeltLenketListe<>(i);

        System.out.println(liste1.subliste(3,8)); // [D, E, F, G, H]
        System.out.println(liste1.subliste(5,5)); // []
        System.out.println(liste1.subliste(8,liste.antall())); // [I, J]

    }
}
