package felles.eksempelklasser;

import felles.Tabell;

public class Student extends Person   // Student blir subklasse til Person
{
    private final Studium studium;      // studentens studium

    public Student(String fornavn, String etternavn, Studium studium)
    {
        super(fornavn, etternavn);
        this.studium = studium;
    }

    public String toString() { return super.toString() + " " + studium.name();}

    public Studium studium() { return studium; }

    public static void main(String[] args) {
        Student[] s = new Student[9];  // en Studenttabell

        s[0] = new Student("Kari", "Svendsen", Studium.Data);    // Kari Svendsen
        s[1] = new Student("Boris", "Zukanovic", Studium.IT);    // Boris Zukanovic
        s[2] = new Student("Ali", "Kahn", Studium.Anvendt);      // Ali Kahn
        s[3] = new Student("Azra", "Zukanovic", Studium.IT);     // Azra Zukanovic
        s[4] = new Student("Kari", "Pettersen", Studium.Data);   // Kari Pettersen
        s[5] = new Student("Fred", "Fredriksen", Studium.Elektro);
        s[6] = new Student("Nils", "Roger", Studium.Elektro);
        s[7] = new Student("Knut", "Knutiii", Studium.Enkeltemne);
        s[8] = new Student("Loke", "Opheim", Studium.Enkeltemne);

        Tabell.innsettingssortering(s);                     // Programkode 1.4.2 e)
        for (Student t : s) System.out.println(t);
    }
}  // class Student
