import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Train_appTest {


    // Helper method (same logic as UC8)
    private List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC", 50)
        );

        List<Bogie> result = filterBogies(list, 60);

        assertEquals(1, result.size());
        assertEquals(80, result.get(0).capacity);
    }

    @Test
    public void testFilter_CapacityEqualToThreshold() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 60)
        );

        List<Bogie> result = filterBogies(list, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_CapacityLessThanThreshold() {
        List<Bogie> list = List.of(
                new Bogie("First Class", 40)
        );

        List<Bogie> result = filterBogies(list, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_MultipleBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 80),
                new Bogie("AC", 50)
        );

        List<Bogie> result = filterBogies(list, 60);

        assertEquals(2, result.size());
    }

    @Test
    public void testFilter_NoBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("AC", 40),
                new Bogie("First Class", 50)
        );

        List<Bogie> result = filterBogies(list, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_AllBogiesMatching() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("Sleeper", 90)
        );

        List<Bogie> result = filterBogies(list, 60);

        assertEquals(2, result.size());
    }

    @Test
    public void testFilter_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        List<Bogie> result = filterBogies(list, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 80));
        list.add(new Bogie("AC", 50));

        List<Bogie> result = filterBogies(list, 60);

        assertEquals(2, list.size()); // original unchanged
        assertEquals(1, result.size());
    }

}