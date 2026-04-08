import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Train_app {

    public static void main(String[] args) {
        try {
            Bogie b1 = new Bogie("Sleeper", 72);   // valid
            Bogie b2 = new Bogie("AC Chair", -10); // invalid

            System.out.println("Bogies created successfully");

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}