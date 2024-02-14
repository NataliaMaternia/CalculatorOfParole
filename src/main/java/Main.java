import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        System.out.println(calculator.localDate());
        System.out.println(calculator.timeInPrison());


        System.out.println("Program oblicza datę warunkowego przedterminowego zwolnienia. " +
                "Wpisz karę orzeczoną przez Sąd. Przykład: Jeżeli Sąd orzekł karę " +
                "2 lat i 6 miesięcy pozbawienia wolności. " +
                "W polu \"lata\" wpisz 2, w polu \"mięsięcy\" wpisz 6 ");


        System.out.println("Wpisz datę rozpoczęcia odbywania kary pozbawienia wolności. " +
                "Przykład: gdy datą rozpoczęcia kary jest 23 luty 2022r., w pole \"rok\" wpisz 2022, " +
                "w pole \"miesiąc\" wpisz 2, a w pole \"dzień\" wpisz 23");
        Scanner parole = new Scanner(System.in);
        System.out.println("Wpisz rok");
        int year = parole.nextInt();
        System.out.println("Wpisz miesiac");
        int month = parole.nextInt();
        System.out.println("Wpisz dzień");
        int day = parole.nextInt();
        calculator.firstDayInPrison = LocalDate.of(year, month,day );
        parole.close();

        System.out.println(calculator.firstDayInPrison);

    }
}