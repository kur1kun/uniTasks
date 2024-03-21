public class MergeSortWithInsertion implements SortStrategy {
    private static final int INSERTION_SORT_THRESHOLD = 10;

    @Override
    public void sort(int[] array) {
        if (array.length < INSERTION_SORT_THRESHOLD) {
            insertionSort(array);
        } else {
            // Реалізація сортування злиттям аналогічно класу MergeSort
        }
    }

    private void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Метод merge аналогічний класу MergeSort
}
