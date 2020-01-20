import com.baranowski.bartosz.CsvService;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CsvServiceTest {

    @Test
    public void cutLeadingLinesShouldReturnJustDates() {
        CsvService csvService = new CsvService();
        final List<String> file = csvService.prepareCsvForParser("sample.csv", 20, 3);
        System.out.println(file);
    }
}
