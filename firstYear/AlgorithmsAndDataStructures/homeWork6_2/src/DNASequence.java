import java.util.Arrays;

public class DNASequence {
    private String sequence;
    private int inversions;

    public DNASequence(String sequence) {
        this.sequence = sequence;
        this.inversions = countInversions(sequence.toCharArray(), 0, sequence.length() - 1, new char[sequence.length()]);
    }

    public String getSequence() {
        return sequence;
    }

    public int getInversions() {
        return inversions;
    }

    private int countInversions(char[] array, int left, int right, char[] temp) {
        int inversions = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            inversions += countInversions(array, left, mid, temp);
            inversions += countInversions(array, mid + 1, right, temp);
            inversions += mergeAndCount(array, left, mid, right, temp);
        }
        return inversions;
    }

    private int mergeAndCount(char[] array, int left, int mid, int right, char[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }
        int i = left, j = mid + 1, k = left, swaps = 0;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                array[k] = temp[i++];
            } else {
                array[k] = temp[j++];
                swaps += (mid + 1 - i);
            }
            k++;
        }
        while (i <= mid) {
            array[k++] = temp[i++];
        }
        return swaps;
    }
}
