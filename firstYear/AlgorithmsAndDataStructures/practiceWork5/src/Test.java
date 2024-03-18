public class Test {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 2};
        Sorter.bubbleSort(a);
        for(int i : a){
            System.out.print(i + " ");
        }
    }
}
