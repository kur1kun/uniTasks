import java.util.Arrays;
import java.util.Random;

public class DataGenerator {
    private static final Random random = new Random();

    public static int[] generateRandomArray(int size) {
        return random.ints(size, Integer.MIN_VALUE, Integer.MAX_VALUE).toArray();
    }

    public static int[] generateSortedArray(int size) {
        int[] array = generateRandomArray(size);
        Arrays.sort(array);
        return array;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] array = generateSortedArray(size);
        for (int i = 0; i < size / 2; i++) {
            int temp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = temp;
        }
        return array;
    }

    public static int[] generateUniformArray(int size, int value) {
        int[] array = new int[size];
        Arrays.fill(array, value);
        return array;
    }
}
