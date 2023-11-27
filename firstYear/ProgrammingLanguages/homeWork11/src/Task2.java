import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ім'я вихідного файлу: ");
        String sourceFileName = scanner.nextLine().trim();

        Path sourcePath = Paths.get(sourceFileName);
        if (!sourcePath.toFile().exists()) {
            System.err.println("Помилка: Файл " + sourceFileName + " не знайдено.");
            return;
        }

        System.out.print("Введіть ім'я файлу-копії (з розширенням .bak): ");
        String destinationFileName = scanner.nextLine().trim();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(sourcePath.toFile()));
            StringBuilder fileContent = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                fileContent.append(line).append(System.lineSeparator());
            }

            bufferedReader.close();

            Path destinationPath = Paths.get(destinationFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destinationPath.toFile()));
            bufferedWriter.write(fileContent.toString());
            bufferedWriter.close();

            System.out.println("Копіювання завершено. Файл збережено як " + destinationFileName);
        } catch (IOException e) {
            System.err.println("Помилка при роботі з файлами: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}