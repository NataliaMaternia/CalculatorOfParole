import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Calculator calculator = new Calculator();
        System.out.println(calculator.localDate());

        Scanner scanner = new Scanner(System.in);


        System.out.println("Program oblicza datę warunkowego przedterminowego zwolnienia. " +
                "Wpisz karę orzeczoną przez Sąd. Przykład: Jeżeli Sąd orzekł karę " +
                "2 lat i 6 miesięcy pozbawienia wolności. " +
                "W polu \"lata\" wpisz 2, w polu \"mięsięsiące\" wpisz 6 ");

        calculator.imprisonment(scanner);

        System.out.println("Wpisz datę rozpoczęcia odbywania kary pozbawienia wolności. " +
                "Przykład: gdy datą rozpoczęcia kary jest 23 luty 2022r., w pole \"rok\" wpisz 2022, " +
                "w pole \"miesiąc\" wpisz 2, a w pole \"dzień\" wpisz 23");
        calculator.firstDayInPrison(scanner);
        System.out.println("Sąd orzekł karę: " + calculator.summary);
        System.out.println("W dniu " + calculator.firstDayInPrison +
                " rozpoczęto wykonywanie kary pozbawienia wolności");
        System.out.println("Do tej pory wykonano " + formatPeriodToString(calculator.timeInPrison())
                + " kary pozbawienia wolności");
        System.out.println("Zgodnie z art. 78. § 1. Skazanego można warunkowo zwolnić po odbyciu co najmniej\n" +
                "połowy kary, a jeżeli wymierzono karę pozbawienia wolności na czas nie krótszy niż\n" +
                "25 lat – po odbyciu co najmniej 15 lat kary.");

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