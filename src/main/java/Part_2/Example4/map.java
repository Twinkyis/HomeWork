package Part_2.Example4;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;

public class map {
    HashMap<String, Integer> carNum = new HashMap<>();
    HashMap<String, Integer> carsPeed = new HashMap<>();
    PrintStream printStream;

    {
        try {
            printStream = new PrintStream(String.valueOf(carNum));
            printStream = new PrintStream(String.valueOf(carsPeed));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
