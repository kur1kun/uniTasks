public class Sorter {
    public static int[] bubbleSort(int[] a){
        if(a == null || a.length <= 1)
            return a;
        for(int i = a.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(a[j] > a[j+1]){
                    swap(a, j, j+1);
                }
            }
        }
        return a;
    }

    public static int[] selectionSort(int[] a){
        if(a == null || a.length <= 1)
            return a;
        for(int i = 0; i < a.length; i++){
            int min = a[i];
            int iOfMin = i;
            for(int j = i+1; j < a.length; j++){
                if(min > a[j]){
                    min = a[j];
                    iOfMin = j;
                }
            }
            swap(a, i, iOfMin);
        }
        return a;
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
