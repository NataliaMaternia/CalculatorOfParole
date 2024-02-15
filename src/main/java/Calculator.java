import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Calculator {

    LocalDate firstDayInPrison;
    Period imprisonment;
    String summary;
    public Calculator() {
    }

    public LocalDate localDate() {
        LocalDate localDate = LocalDate.now();
        return localDate;
    }


    public Period timeInPrison() {
        if (localDate().isBefore(firstDayInPrison)) {
            throw new IllegalArgumentException("Data rozpoczęcia kary pozbawienia wolności" +
                    "nie może być późniejsza niż dziesiejsza data");
        }
        Period timeInPrison = Period.between(firstDayInPrison, localDate());
        return timeInPrison;
    }

    public void imprisonment(Scanner scanner) {
        System.out.println("Wpisz lata");
        int yearOfImprisonment = scanner.nextInt();
        System.out.println("Wpisz miesiące");
        int monthsOfImprisonment = scanner.nextInt();
        final int dayOfImprisonment = 0;
        imprisonment = Period.of(yearOfImprisonment,monthsOfImprisonment,dayOfImprisonment);
        summary = yearOfImprisonment + " lat " + monthsOfImprisonment +
                " miesięcy pozbawienia wolności";
    }

    public void firstDayInPrison(Scanner scanner) {
        System.out.println("Wpisz rok");
        int imprisonmentStartYear = scanner.nextInt();
        System.out.println("Wpisz miesiac");
        int imprisonmentStarMonth = scanner.nextInt();
        System.out.println("Wpisz dzień");
        int imprisonmentStartDay = scanner.nextInt();
        firstDayInPrison = LocalDate.of(imprisonmentStartYear, imprisonmentStarMonth, imprisonmentStartDay);
    }





}
