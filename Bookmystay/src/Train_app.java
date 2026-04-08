import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Train_app {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create bogie list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        // Display original list
        System.out.println("\nAll Bogies:");
        bogies.forEach(System.out::println);

        List<Bogie> filteredBogies = getBogies(bogies,60);

        // Display filtered list
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);
    }

    public static List<Bogie> getBogies(List<Bogie> bogies,int value) {
        // Filter bogies with capacity > 60
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > value)
                .collect(Collectors.toList());
        return filteredBogies;
    }
}