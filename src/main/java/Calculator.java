import javax.xml.datatype.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Calculator {

    LocalDate firstDayInPrison;
    Period imprisonment;
    String summary;
    int yearOfImprisonment;
    int monthsOfImprisonment;
    int dayOfImprisonment;
    boolean lifeImprisonment;
    boolean ifLifeImprisonment;
    boolean recidivismP;
    boolean recidivismW;
    boolean recidivismU;

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

    public boolean lifeImprisonment(Scanner scanner) {
        System.out.println("Czy została orzeczona kara dożywotniego pozbawienia wolności? " +
                "Wpisz 'tak' lub 'nie'");
        ifLifeImprisonment = scanner.next().contains("tak");
        return ifLifeImprisonment;
    }

    public void imprisonment(Scanner scanner) {
        if (!ifLifeImprisonment) {
            System.out.println("Wpisz karę orzeczoną przez Sąd. Przykład: Jeżeli Sąd orzekł karę" +
                    " 2 lat i 6 miesięcy pozbawienia wolności. " +
                    "W polu \"lata\" wpisz 2, w polu \"mięsiące\" wpisz 6");
            System.out.println("Wpisz lata");
            yearOfImprisonment = scanner.nextInt();
            System.out.println("Wpisz miesiące");
            monthsOfImprisonment = scanner.nextInt();
            dayOfImprisonment = 0;
            imprisonment = Period.of(yearOfImprisonment, monthsOfImprisonment, dayOfImprisonment);
            summary = yearOfImprisonment + " lat " + monthsOfImprisonment +
                    " miesięcy pozbawienia wolności";
        }
    }

    public boolean recidivismP(Scanner scanner) {
        System.out.println("Czy skazanie nastapiło w warunkach recydywy podstawowej? " +
                "- art. 64§1 kodeksu karnego. Wpisz 'tak' lub 'nie' ");
        recidivismP = scanner.next().contains("tak");
        return recidivismP;
    }
    public boolean recidivismW(Scanner scanner) {
        if (!recidivismP) {
            System.out.println("Czy skazanie nastapiło w warunkach recydywy wielokrotnej? " +
                    "- art.64§2 kodeksu karnego lub na podstawie art. 64a kodeksu karnego? " +
                    "Wpisz 'tak' lub 'nie' ");
            recidivismW = scanner.next().contains("tak");
        }
        return recidivismW;
    }
    public boolean recidivismU(Scanner scanner) {
        if (!recidivismP && !recidivismW) {
            System.out.println("Czy wobec skazanego, wydano prawomocne postanowienie\n" +
                    "stwierdzające, że bezprawnie utrudniał wykonanie kary pozbawienia wolności");
            recidivismU = scanner.next().contains("tak");
        }
        return recidivismU;
    }

    public void firstDayInPrison(Scanner scanner) {
        System.out.println("Wpisz datę rozpoczęcia odbywania kary pozbawienia wolności. " +
                "Przykład: gdy datą rozpoczęcia kary jest 23 luty 2022r., w pole \"rok\" wpisz 2022, " +
                "w pole \"miesiąc\" wpisz 2, a w pole \"dzień\" wpisz 23");
        System.out.println("Wpisz rok");
        int imprisonmentStartYear = scanner.nextInt();
        System.out.println("Wpisz miesiac");
        int imprisonmentStarMonth = scanner.nextInt();
        System.out.println("Wpisz dzień");
        int imprisonmentStartDay = scanner.nextInt();
        firstDayInPrison = LocalDate.of(imprisonmentStartYear, imprisonmentStarMonth, imprisonmentStartDay);
    }

    public LocalDate calculateParole() {
        if (ifLifeImprisonment) {
            LocalDate lifeImprisonmentTrue = firstDayInPrison.plusYears(30);
            return lifeImprisonmentTrue;
        } else if (yearOfImprisonment < 25) {
            int yearsOfImprisonmentInMonths = yearOfImprisonment * 12;
            int totalMonths = yearsOfImprisonmentInMonths + monthsOfImprisonment;
            int calculatedMonthsOfParole = totalMonths / 2;
            int calculatedDaysOfParole = totalMonths % 2;
            Period periodOfParole = Period.of(0, calculatedMonthsOfParole, calculatedDaysOfParole);
            return firstDayInPrison.plus(periodOfParole.normalized());
        } else if (yearOfImprisonment >= 25) {
            LocalDate imprisonmentMoreThan25years = firstDayInPrison.plusYears(15);
            return imprisonmentMoreThan25years;
        }
        return null;
    }
}