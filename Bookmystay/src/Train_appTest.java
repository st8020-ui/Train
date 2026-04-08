import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Train_appTest {


    @Test
    public void testException_ValidCapacityCreation() throws InvalidCapacityException {
        Bogie b = new Bogie("Sleeper", 72);
        assertNotNull(b);
    }

    @Test
    public void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Sleeper", -10);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    public void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("AC Chair", 0);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("First Class", 0);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        Bogie b = new Bogie("Sleeper", 72);

        assertEquals("Sleeper", b.getType());
        assertEquals(72, b.getCapacity());
    }

    @Test
    public void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        Bogie b1 = new Bogie("Sleeper", 72);
        Bogie b2 = new Bogie("AC Chair", 60);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}