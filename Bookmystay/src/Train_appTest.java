import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Train_appTest {


    private boolean validateTrainId(String trainId) {
        return Pattern.matches("TRN-\\d{4}", trainId);
    }

    private boolean validateCargoCode(String cargoCode) {
        return Pattern.matches("PET-[A-Z]{2}", cargoCode);
    }

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(validateTrainId("TRN-1234"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat() {
        assertFalse(validateTrainId("TRAIN12"));
        assertFalse(validateTrainId("TRN12A"));
        assertFalse(validateTrainId("1234-TRN"));
    }

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(validateCargoCode("PET-AB"));
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(validateCargoCode("PET-ab"));
        assertFalse(validateCargoCode("PET123"));
        assertFalse(validateCargoCode("AB-PET"));
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(validateTrainId("TRN-123"));
        assertFalse(validateTrainId("TRN-12345"));
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(validateCargoCode("PET-Ab"));
        assertFalse(validateCargoCode("PET-aB"));
    }

    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(validateTrainId(""));
        assertFalse(validateCargoCode(""));
    }

    @Test
    public void testRegex_ExactPatternMatch() {
        assertFalse(validateTrainId("TRN-1234X"));
        assertFalse(validateCargoCode("PET-ABC"));
    }
}