import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Calculator calculator = new Calculator();
        System.out.println(calculator.localDate());

        System.out.println("Program oblicza datę warunkowego przedterminowego zwolnienia. ");

        Scanner scanner = new Scanner(System.in);
        calculator.lifeImprisonment(scanner);
        calculator.imprisonment(scanner);
        System.out.println("Wpisz datę rozpoczęcia odbywania kary pozbawienia wolności. " +
                "Przykład: gdy datą rozpoczęcia kary jest 23 luty 2022r., w pole \"rok\" wpisz 2022, " +
                "w pole \"miesiąc\" wpisz 2, a w pole \"dzień\" wpisz 23");
        calculator.firstDayInPrison(scanner);
        System.out.println("Sąd orzekł karę: " + calculator.imprisonment);
        System.out.println("W dniu " + calculator.firstDayInPrison +
                " rozpoczęto wykonywanie kary pozbawienia wolności");
        System.out.println("Do tej pory wykonano " + formatPeriodToString(calculator.timeInPrison())
                + " kary pozbawienia wolności");
        System.out.println("Zgodnie z art. 78. § 1. Skazanego można warunkowo zwolnić po odbyciu co najmniej\n" +
                "połowy kary, a jeżeli wymierzono karę pozbawienia wolności na czas nie krótszy niż\n" +
                "25 lat – po odbyciu co najmniej 15 lat kary.");
        System.out.println("Skazany może ubiegać się o przedterminowe warunkowe zwolnienie z dniem "
                + calculator.calculateParole());

        System.out.println("Pamiętaj, że zastosowanie przez Sąd warunkowego przdterminowego zwolnienia nie jest " +
                "obligatoryjne. Sąd sąd może zwolnić z odbycia reszty kary, gdy spełnione zostają " +
                "przesłanki określone w art. xxxx");

// data od kiedy siedzi plus period.normalized
      //System.out.println("Sąd może zastosować warunkowe przedterminowe zwolnienie z dniem ");


        scanner.close();
    }

    public static String formatPeriodToString(Period period) {
        String format = period.getYears() + " lat " + period.getMonths()
                + " miesięcy " + period.getDays() + " dni";
        return format;
    }
}