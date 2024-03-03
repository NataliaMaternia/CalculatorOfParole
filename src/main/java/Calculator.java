import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Calculator {

    LocalDate firstDayInPrison;
    Period imprisonment;
    String imprisonmentTimeSummary;
    int yearOfImprisonment;
    int monthsOfImprisonment;
    int dayOfImprisonment;
    boolean ifLifeImprisonment;
    boolean recidivismBasic;
    boolean recidivismMultiple;
    boolean recidivismHinder;

    public Calculator() {
    }

    public LocalDate localDate() {
        LocalDate localDate = LocalDate.now();
        return localDate;
    }

    public Period calculateTimeInPrison() {
        if (localDate().isBefore(firstDayInPrison)) {
            throw new IllegalArgumentException("Data rozpoczęcia kary pozbawienia wolności" +
                    "nie może być późniejsza niż dziesiejsza data");
        }
        Period timeInPrison = Period.between(firstDayInPrison, localDate());
        return timeInPrison;
    }

    public boolean loadIfLifeImprisonment(Scanner scanner) {
        System.out.println("Czy została orzeczona kara dożywotniego pozbawienia wolności? " +
                "Wpisz 'tak' lub 'nie'");
        ifLifeImprisonment = scanner.next().contains("tak");
        return ifLifeImprisonment;
    }

    public void loadImprisonmentJudgment(Scanner scanner) {
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
            imprisonmentTimeSummary = yearOfImprisonment + " lat " + monthsOfImprisonment +
                    " miesięcy pozbawienia wolności";
        }
    }

    public boolean loadRecidivismBasic(Scanner scanner) {
        System.out.println("Czy skazanie nastapiło w warunkach recydywy podstawowej? " +
                "- art. 64§1 kodeksu karnego. Wpisz 'tak' lub 'nie' ");
        recidivismBasic = scanner.next().contains("tak");
        return recidivismBasic;
    }
    public boolean loadRecidivismMultiple(Scanner scanner) {
        if (!recidivismBasic) {
            System.out.println("Czy skazanie nastapiło w warunkach recydywy wielokrotnej? " +
                    "- art.64§2 kodeksu karnego lub na podstawie art. 64a kodeksu karnego? " +
                    "Wpisz 'tak' lub 'nie' ");
            recidivismMultiple = scanner.next().contains("tak");
        }
        return recidivismMultiple;
    }
    public boolean loadRecidivismHinder(Scanner scanner) {
        if (!recidivismBasic && !recidivismMultiple) {
            System.out.println("Czy wobec skazanego, wydano prawomocne postanowienie\n" +
                    "stwierdzające, że bezprawnie utrudniał wykonanie kary pozbawienia wolności");
            recidivismHinder = scanner.next().contains("tak");
        }
        return recidivismHinder;
    }

    public void loadFirstDayInPrison(Scanner scanner) {
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
        int yearsOfImprisonmentInMonths = yearOfImprisonment * 12;
        int totalMonths = yearsOfImprisonmentInMonths + monthsOfImprisonment;
        if (ifLifeImprisonment) {
            LocalDate lifeImprisonmentTrue = firstDayInPrison.plusYears(30);
            return lifeImprisonmentTrue;
        } else if (yearOfImprisonment < 25) {
            int calculatedMonthsOfParole = totalMonths / 2;
            int calculatedDaysOfParole = totalMonths % 2;
            Period periodOfParole = Period.of(0, calculatedMonthsOfParole, calculatedDaysOfParole);
            return firstDayInPrison.plus(periodOfParole.normalized());
        } else if (yearOfImprisonment >= 25) {
            LocalDate imprisonmentMoreThan25years = firstDayInPrison.plusYears(15);
            return imprisonmentMoreThan25years;
        } else if (recidivismBasic) {
            int calculatedMonthsOfParole = (totalMonths * 2) / 3;
            int calculatedDaysOfParole = totalMonths % 2;
            Period periodOfParole = Period.of(0, calculatedMonthsOfParole, calculatedDaysOfParole);
            return firstDayInPrison.plus(periodOfParole.normalized());
        } else if (recidivismMultiple || recidivismHinder) {
            int calculatedMonthsOfParole = (totalMonths * 3) / 4;
            int calculatedDaysOfParole = totalMonths % 2;
            Period periodOfParole = Period.of(0, calculatedMonthsOfParole, calculatedDaysOfParole);
            return firstDayInPrison.plus(periodOfParole.normalized());
        }
        return null;
    }
}