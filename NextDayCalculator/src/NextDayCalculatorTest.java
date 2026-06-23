import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextDayCalculatorTest {

    @Test
    @DisplayName("Ngày thường: 1/1/2018 -> 2/1/2018")
    public void testNextDayNormal() {
        assertEquals("2/1/2018", NextDayCalculator.getNextDay(1, 1, 2018));
    }

    @Test
    @DisplayName("Cuối tháng 31 ngày: 31/1/2018 -> 1/2/2018")
    public void testNextDayEndOfMonth31() {
        assertEquals("1/2/2018", NextDayCalculator.getNextDay(31, 1, 2018));
    }

    @Test
    @DisplayName("Cuối tháng 30 ngày: 30/4/2018 -> 1/5/2018")
    public void testNextDayEndOfMonth30() {
        assertEquals("1/5/2018", NextDayCalculator.getNextDay(30, 4, 2018));
    }

    @Test
    @DisplayName("Tháng 2 năm thường: 28/2/2018 -> 1/3/2018")
    public void testNextDayFebNormalYear() {
        assertEquals("1/3/2018", NextDayCalculator.getNextDay(28, 2, 2018));
    }

    @Test
    @DisplayName("Tháng 2 năm nhuận: 29/2/2020 -> 1/3/2020")
    public void testNextDayFebLeapYear() {
        assertEquals("1/3/2020", NextDayCalculator.getNextDay(29, 2, 2020));
    }

    @Test
    @DisplayName("Ngày cuối năm: 31/12/2018 -> 1/1/2019")
    public void testNextDayEndOfYear() {
        assertEquals("1/1/2019", NextDayCalculator.getNextDay(31, 12, 2018));
    }
}