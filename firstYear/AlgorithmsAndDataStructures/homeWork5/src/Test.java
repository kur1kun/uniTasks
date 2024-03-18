import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        Product<String, Double, Integer, String, Integer>[] products = new Product[]{
                new Product<>("Milk", 1.99, 10, "Dairy", 4),
                new Product<>("Bread", 0.99, 15, "Bakery", 5),
                new Product<>("Cheese", 2.99, 5, "Dairy", 4)
        };

        System.out.println("Original array:");
        printArray(products);

        // Бульбашкове сортування
        Sorter.bubbleSort(products);
        System.out.println("\nArray after Bubble Sort:");
        printArray(products);

        // Сортування вибором
        products = new Product[]{
                new Product<>("Milk", 1.99, 10, "Dairy", 4),
                new Product<>("Bread", 0.99, 15, "Bakery", 5),
                new Product<>("Cheese", 2.99, 5, "Dairy", 4)
        };

        Sorter.selectionSort(products);
        System.out.println("\nArray after Selection Sort:");
        printArray(products);

        // Сортування вставкою
        products = new Product[]{
                new Product<>("Milk", 1.99, 10, "Dairy", 4),
                new Product<>("Bread", 0.99, 15, "Bakery", 5),
                new Product<>("Cheese", 2.99, 5, "Dairy", 4)
        };

        Sorter.insertionSort(products);
        System.out.println("\nArray after Insertion Sort:");
        printArray(products);

        // Сортування гребінцем
        products = new Product[]{
                new Product<>("Milk", 1.99, 10, "Dairy", 4),
                new Product<>("Bread", 0.99, 15, "Bakery", 5),
                new Product<>("Cheese", 2.99, 5, "Dairy", 4)
        };

        Sorter.combSort(products);
        System.out.println("\nArray after Comb Sort:");
        printArray(products);

        // Сортування Шела
        products = new Product[]{
                new Product<>("Milk", 1.99, 10, "Dairy", 4),
                new Product<>("Bread", 0.99, 15, "Bakery", 5),
                new Product<>("Cheese", 2.99, 5, "Dairy", 4)
        };

        Sorter.shellSort(products);
        System.out.println("\nArray after Shell Sort:");
        printArray(products);
    }

    // Метод для друку масиву
    private static <T> void printArray(T[] array) {
        Arrays.stream(array).forEach(System.out::println);
    }
}
