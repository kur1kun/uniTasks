import java.util.Scanner;

public class MergeSortRobots {

    public static void mergeSort(int[][] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[][] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[][] L = new int[n1][3];
        int[][] R = new int[n2][3];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[middle + 1 + j];

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (L[i][0] < R[j][0] || (L[i][0] == R[j][0] && L[i][2] < R[j][2])) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] robots = new int[N][3];

        for (int i = 0; i < N; i++) {
            robots[i][0] = scanner.nextInt();
            robots[i][1] = scanner.nextInt();
            robots[i][2] = i;
        }

        mergeSort(robots, 0, robots.length - 1);

        for (int i = 0; i < N; i++) {
            System.out.println(robots[i][0] + " " + robots[i][1]);
        }
    }
}
