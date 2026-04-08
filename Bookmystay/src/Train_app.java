import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Train_app {

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        // Create sample data (large dataset)
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 60));
            bogies.add(new Bogie("First Class", 40));
        }

        // 🔹 Loop-based filtering
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // 🔹 Stream-based filtering
        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // Output
        System.out.println("Loop Time: " + loopTime);
        System.out.println("Stream Time: " + streamTime);
        System.out.println("Results Match: " + (loopResult.size() == streamResult.size()));
    }
}