import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Train_appTest {


    private boolean isSafe(List<Bogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.getType().equals("Cylindrical") ||
                                b.getCargo().equals("Petroleum")
                );
    }

    @Test
    public void testSafety_AllBogiesValid() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Open", "Coal")
        );

        assertTrue(isSafe(bogies));
    }

    @Test
    public void testSafety_CylindricalWithInvalidCargo() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Coal")
        );

        assertFalse(isSafe(bogies));
    }

    @Test
    public void testSafety_NonCylindricalBogiesAllowed() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Open", "Coal"),
                new Bogie("Box", "Grain")
        );

        assertTrue(isSafe(bogies));
    }

    @Test
    public void testSafety_MixedBogiesWithViolation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Cylindrical", "Coal") // invalid
        );

        assertFalse(isSafe(bogies));
    }

    @Test
    public void testSafety_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        assertTrue(isSafe(bogies));
    }
}