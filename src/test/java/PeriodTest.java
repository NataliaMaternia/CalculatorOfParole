import org.junit.jupiter.api.Test;

import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class PeriodTest {
    @Test
    public void testPeriodFromMonths() {
       Period period = Period.of(0, 20, 0);
        System.out.println(period.normalized());
    }

    @Test
    public void testPeriodFromDays() {
        Period period = Period.of(0, 13, 400);
        System.out.println(period.normalized());
    }
}