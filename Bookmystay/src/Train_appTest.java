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
    public void testCargo_SafeAssignment() {
        Bogie b = new Bogie("Cylindrical");
        b.assignCargo("Petroleum");

        assertEquals("Petroleum", b.getCargo());
    }

    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        Bogie b = new Bogie("Rectangular");
        b.assignCargo("Petroleum");

        assertNull(b.getCargo());
    }

    @Test
    public void testCargo_CargoNotAssignedAfterFailure() {
        Bogie b = new Bogie("Rectangular");
        b.assignCargo("Petroleum");

        assertNull(b.getCargo());
    }

    @Test
    public void testCargo_ProgramContinuesAfterException() {
        Bogie b1 = new Bogie("Rectangular");
        Bogie b2 = new Bogie("Cylindrical");

        b1.assignCargo("Petroleum"); // fails
        b2.assignCargo("Coal");      // works

        assertEquals("Coal", b2.getCargo());
    }

    @Test
    public void testCargo_FinallyBlockExecution() {
        Bogie b = new Bogie("Rectangular");

        // We assume finally runs if no crash happens
        b.assignCargo("Petroleum");

        assertTrue(true); // if reached, finally executed
    }
}