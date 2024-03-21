import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = Integer.parseInt(scanner.nextLine().trim()); // Кількість тестів

        for (int i = 0; i < M; i++) {
            if (i > 0) {
                System.out.println(); // Пустий рядок між відповідями тестів
            }
            scanner.nextLine(); // Пропускаємо пустий рядок між тестами
            String[] firstLine = scanner.nextLine().trim().split(" ");
            int n = Integer.parseInt(firstLine[0]); // Довжина рядків
            int m = Integer.parseInt(firstLine[1]); // Кількість рядків

            List<DNASequence> sequences = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                String sequence = scanner.nextLine().trim();
                sequences.add(new DNASequence(sequence));
            }

            sequences.sort((a, b) -> a.getInversions() - b.getInversions());

            for (DNASequence dna : sequences) {
                System.out.println(dna.getSequence());
            }
        }
        scanner.close();
    }
}
