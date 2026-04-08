import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Train_appTest {


    private List<Bogie> getBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40)
        );
    }

    @Test
    public void testLoopFilteringLogic() {
        List<Bogie> bogies = getBogies();

        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }

        assertEquals(1, result.size());
    }

    @Test
    public void testStreamFilteringLogic() {
        List<Bogie> bogies = getBogies();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();

        assertEquals(1, result.size());
    }

    @Test
    public void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = getBogies();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    public void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        long end = System.nanoTime();

        assertTrue(end - start >= 0);
    }

    @Test
    public void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 60));
        }

        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertFalse(result.isEmpty());
    }
}