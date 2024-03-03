import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Calculator calculator = new Calculator();
        System.out.println(calculator.localDate());

        System.out.println("Program oblicza datę warunkowego przedterminowego zwolnienia.");

        Scanner scanner = new Scanner(System.in);
        calculator.loadIfLifeImprisonment(scanner);
        calculator.loadImprisonmentJudgment(scanner);
        calculator.loadRecidivismBasic(scanner);
        calculator.loadRecidivismMultiple(scanner);
        calculator.loadRecidivismHinder(scanner);
        calculator.loadFirstDayInPrison(scanner);

        System.out.println("Sąd orzekł karę: " + calculator.imprisonmentTimeSummary);

        System.out.println("W dniu " + calculator.firstDayInPrison +
                " rozpoczęto wykonywanie kary pozbawienia wolności");

        System.out.println("Do tej pory wykonano " + formatPeriodToString(calculator.calculateTimeInPrison())
                + " kary pozbawienia wolności");

        System.out.println("Zgodnie z art. 78. § 1. Skazanego można warunkowo zwolnić po odbyciu co najmniej\n" +
                "połowy kary, a jeżeli wymierzono karę pozbawienia wolności na czas nie krótszy niż\n" +
                "25 lat – po odbyciu co najmniej 15 lat kary.");
        System.out.println("""
                 § 2. Skazanego określonego w art. 64 § 1 można warunkowo zwolnić po
                odbyciu dwóch trzecich kary, natomiast skazanego określonego w art. 64 § 2 lub
                art. 64a oraz skazanego, wobec którego wydano prawomocne postanowienie
                stwierdzające, że bezprawnie utrudniał wykonanie kary pozbawienia wolności, po
                odbyciu trzech czwartych kary.""");
        System.out.println("3. Skazanego na karę dożywotniego pozbawienia wolności można warunkowo\n" +
                "zwolnić po odbyciu 30 lat kary.");
        System.out.println();
        System.out.println("Mając na uwadze powyższe, skazany może ubiegać się o przedterminowe warunkowe zwolnienie z dniem "
                + calculator.calculateParole());

        System.out.println("Pamiętaj, że zastosowanie przez Sąd warunkowego przdterminowego zwolnienia nie jest " +
                "obligatoryjne. Sąd sąd może zwolnić z odbycia reszty kary, gdy spełnione zostają " +
                "przesłanki określone w art. xxxx");
        scanner.close();
    }

    public static String formatPeriodToString(Period period) {
        String format = period.getYears() + " lat " + period.getMonths()
                + " miesięcy " + period.getDays() + " dni";
        return format;
    }
}