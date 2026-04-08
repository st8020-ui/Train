import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Train_app {

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Cylindrical", "Petroleum"));
        bogies.add(new Bogie("Open", "Coal"));
        bogies.add(new Bogie("Box", "Grain"));

        // Safety validation
        boolean isSafe = bogies.stream()
                .allMatch(b ->
                        !b.getType().equals("Cylindrical") ||
                                b.getCargo().equals("Petroleum")
                );

        if (isSafe) {
            System.out.println("Train is SAFE");
        } else {
            System.out.println("Train is UNSAFE");
        }
    }
}