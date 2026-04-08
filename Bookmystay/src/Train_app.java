import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Train_app {

    public static void main(String[] args) {
        Bogie b1 = new Bogie("Cylindrical");
        Bogie b2 = new Bogie("Rectangular");

        // Safe assignment
        b1.assignCargo("Petroleum");

        // Unsafe assignment
        b2.assignCargo("Petroleum");

        // Program continues
        System.out.println("Program continues...");
    }
}