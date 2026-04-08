import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Train_appTest {


    private List<Bogie> getSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 40));
        return bogies;
    }

    @Test
    public void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = getSampleBogies();

        Map<String, List<Bogie>> result =
                bogies.stream().collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(result.containsKey("Sleeper"));
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = getSampleBogies();

        Map<String, List<Bogie>> result =
                bogies.stream().collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    public void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = getSampleBogies();

        Map<String, List<Bogie>> result =
                bogies.stream().collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(3, result.keySet().size());
    }

    @Test
    public void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> result =
                bogies.stream().collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(result.isEmpty());
    }

    @Test
    public void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 72)
        );

        Map<String, List<Bogie>> result =
                bogies.stream().collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(1, result.size());
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    public void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = getSampleBogies();

        Map<String, List<Bogie>> result =
                bogies.stream().collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    public void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = getSampleBogies();

        Map<String, List<Bogie>> result =
                bogies.stream().collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = getSampleBogies();
        int originalSize = bogies.size();

        bogies.stream().collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(originalSize, bogies.size());
    }
}