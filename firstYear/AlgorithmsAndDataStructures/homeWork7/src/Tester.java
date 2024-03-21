import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Tester {
    private static final int[] SIZES = {1024, 2048, 4096, 8192, 16384, 32768};

    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sorting_results.txt"))) {
            for (int size : SIZES) {
                writer.write("Array size: " + size + "\n");

                int[] randomArray = DataGenerator.generateRandomArray(size);
                int[] sortedArray = DataGenerator.generateSortedArray(size);
                int[] reverseSortedArray = DataGenerator.generateReverseSortedArray(size);
                int[] uniformArray = DataGenerator.generateUniformArray(size, 0);

                // Проведення експериментів з різними стратегіями та масивами
                // Наприклад:
                // performExperiment(writer, new MergeSort(), "MergeSort", randomArray);

                writer.write("\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void performExperiment(BufferedWriter writer, SortStrategy strategy, String strategyName, int[] array) throws IOException {
        SortContext context = new SortContext(strategy);

        Stopwatch stopwatch = new Stopwatch();
        context.executeStrategy(array.clone()); // Клонуємо масив, щоб не змінювати оригінальний
        double timeElapsed = stopwatch.elapsedTime();

        writer.write(String.format("%s took %.3f microseconds\n", strategyName, timeElapsed));
    }
}
