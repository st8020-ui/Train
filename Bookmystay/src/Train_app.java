import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Train_app {

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("AC Chair", 60));

        // Grouping by type
        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        // Display result
        groupedBogies.forEach((type, list) -> {
            System.out.println(type + " -> " + list);
        });
    }
}