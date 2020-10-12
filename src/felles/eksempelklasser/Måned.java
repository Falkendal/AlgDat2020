package felles.eksempelklasser;

public enum Måned {
    JAN ("Januar"),
    FEB ("Februar"),
    MAR ("Mars"),
    APR ("April"),
    MAI ("Mai"),
    JUN ("Juni"),
    JUL ("Juli"),
    AUG ("August"),
    SEP ("September"),
    OKT ("Oktober"),
    NOV ("November"),
    DES ("Desember");

    private int mndnr;
    private Måned(int mndnr) {this.mndnr = mndnr; }

    private String fulltnavn;
    private Måned(String fulltnavn) { this.fulltnavn = fulltnavn; }

    public static int toString(int mnd) { return mnd; }

    public String toString(String fulltnavn) { return fulltnavn; }

    public static Måned[] vår() {
        return new Måned[] {APR, MAI};
    }

    public static Måned[] sommer() {
        return new Måned[] {JUN, JUL, AUG};
    }

    public static Måned[] høst() {
        return new Måned[] {SEP, OKT};
    }

    public static Måned[] vinter() {
        return new Måned[] {NOV, DES, JAN, FEB, MAR};
    }

    public static void main(String[] args) {
        for(Måned m : Måned.values()) {
            System.out.println(m.toString() + " (" + m.name() + ") ");
        }
    }
}
