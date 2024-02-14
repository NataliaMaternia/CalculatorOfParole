import java.time.LocalDate;
import java.time.Period;

public class Calculator {

    LocalDate firstDayInPrison;

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
        Period timeInPrison = Period.between(localDate(), firstDayInPrison);
        return timeInPrison;
    }



}
