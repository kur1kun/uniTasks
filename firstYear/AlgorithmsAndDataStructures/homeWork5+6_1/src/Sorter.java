import java.util.Arrays;

public class Sorter {
//public:
    public static <T extends Comparable<T>> void bubbleSort(T[] a) {
        for(int i = a.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(a[j].compareTo(a[j+1]) > 0){
                    swap(a, j, j+1);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        for(int i = 0; i < a.length; i++){
            int indexMin = i;
            for(int j = i+1; j < a.length; j++){
                if(a[indexMin].compareTo(a[j]) > 0){
                    indexMin = j;
                }
            }
            swap(a, i, indexMin);
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        for(int i = 1; i < a.length; i++){
            for (int j = i; j >= 1 && a[j-1].compareTo(a[j]) > 0; j--){
                swap(a, j-1, j);
            }
        }
    }

    public static <T extends Comparable<T>> void combSort(T[] a) {
        int gap = a.length;
        boolean swapped;

        do {
            swapped = false;
            gap = setGap(gap);

            for(int i = 0; i < (a.length - gap); i++) {
                if(a[i].compareTo(a[i+gap]) > 0){
                    swapped = true;
                    swap(a, i, i+gap);
                }
            }
        } while(gap > 1 || swapped);
    }

    public static <T extends Comparable<T>> void shellSort(T[] a) {
        for(int gap = a.length/2; gap > 0; gap /= 2){
            for(int i = gap; i < a.length; i++){
                for (int j = i; j >= gap && a[j - gap].compareTo(a[j]) > 0; j--){
                    swap(a, j - gap, j);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] a, int from, int to) {
        if (from < to) {
            int middle = from + (to - from) / 2;
            mergeSort(a, from, middle);
            mergeSort(a, middle + 1, to);
            merge(a, from, middle, to);
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] a, int from, int to) {
        if (from < to) {
            int pivot = partition(a, from, to);
            quickSort(a, from, pivot - 1);
            quickSort(a, pivot + 1, to);
        }
    }

//private:
    private static <T> void swap(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static int setGap(int gap) {
        gap = gap * 10 / 13;
        if(gap < 1)
            return 1;
        return gap;
    }

    private static <T extends Comparable<T>> void merge(T[] a, int from, int middle, int to) {
        T[] temp = Arrays.copyOf(a, a.length);

        int i = from, j = middle + 1, k = from;
        while (i <= middle && j <= to) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                a[k] = temp[i];
                i++;
            } else {
                a[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            a[k] = temp[i];
            i++;
            k++;
        }
    }

    private static <T extends Comparable<T>> int partition (T[] a, int from, int to) {
        int middle = from + (to - from) / 2;
        int pivot = medianOfThree(a, from, middle, to);

        swap(a, pivot, to);
        int i = from;

        for (int j = from; j < to; j++) {
            if (a[j].compareTo(a[to]) < 0) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, to);
        return i;
    }

    private static <T extends Comparable<T>> int medianOfThree(T[] a, int low, int mid, int high) {
        if ((a[low].compareTo(a[mid]) <= 0 && a[high].compareTo(a[low]) >= 0) || (a[high].compareTo(a[low]) <= 0 && a[low].compareTo(a[mid]) <= 0)) {
            return low;
        } else if ((a[mid].compareTo(a[low]) <= 0 && a[high].compareTo(a[mid]) >= 0) || (a[high].compareTo(a[mid]) <= 0 && a[mid].compareTo(a[low]) <= 0)) {
            return mid;
        } else {
            return high;
        }
    }
}
