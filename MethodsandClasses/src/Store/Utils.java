package Store;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

abstract class Utils {
    static void loadStringsToArray(String sourceFile, ArrayList<String> arrList) throws IOException {
        Path path = Paths.get(sourceFile);
        arrList.clear();

        // The stream file will also be closed here
        try (Stream<String> lines = Files.lines(path)) {
            Object[] arr = lines.toArray();

            for(Object t: arr) {
                arrList.add(t.toString());
            }
        }
    }
}
