public class Sorter {
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

    private static int setGap(int gap) {
        gap = gap * 10 / 13;
        if(gap < 1)
            return 1;
        return gap;
    }

    private static <T> void swap(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
