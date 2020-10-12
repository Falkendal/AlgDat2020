package felles.eksempelklasser;
/*  Hva er enumtyper?
    En enumtype er en referansetype og fungerer omtrent som andre referansetyper (klasser og grensesnitt). Det som ramses opp i typedefinisjonen kalles enumkonstanter.
    De bør normalt ha store bokstaver eller minst ha stor forbokstav. Det er mulig å la navnet starte med _ (understrek), $ (dollar) eller £ (pund), men det brukes svært sjelden.
    En enumtype er en subtype til Object og har dermed alle Object-metodene. En av dem er toString() som er overskrevet (eng: overridden) i Studium.
    Hvis ikke, ville toString() og name() gi samme resultat, dvs. navnet på enumkonstanten. Det er ikke mulig å opprette instanser av en enumtype ved hjelp av new.
    Trengs det flere, må de settes opp sammen med de andre i «oppramsingen». En enumtype er alltid Comparable (og har dermed metoden compareTo). Ordningen er den rekkefølgen de har i «oppramsingen».
    Metoden ordinal() forteller hvilket nummer i rekkefølgen en enumkonstant har. Den første har ordinalverdi lik 0, den neste 1, osv.
 */

public enum Studium  // legges under package eksempelklasser
{
    Data ("Ingeniørfag - data"),         // enumkonstanten Data
    IT ("Informasjonsteknologi"),        // enumkonstanten IT
    Anvendt ("Anvendt datateknologi"),   // enumkonstanten Anvendt
    Elektro ("Ingeniørfag - elektronikk og informasjonsteknologi"),
    Enkeltemne ("Enkeltemnestudent");   // enumkonstanten Enkeltemne

    private final String fulltnavn;      // instansvariabel
    private Studium(String fulltnavn) { this.fulltnavn = fulltnavn; }

    public String toString() { return fulltnavn; }

    public static void main(String[] args) {
        for (Studium s : Studium.values())
        {
            System.out.println(s.toString() + " (" + s.name() + ")");
        }
    }
}
