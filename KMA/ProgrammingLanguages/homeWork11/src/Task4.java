import java.io.*;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sourceFilePath = "SomeText.txt";
        String encryptedFilePath = "EncryptedText.txt";

        System.out.print("Введіть кількість символів зсуву: ");
        int shift = scanner.nextInt();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFilePath));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(encryptedFilePath));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // Здійснюємо зсув символів (шифрування) для кожного символу у рядку
                char[] encryptedChars = new char[line.length()];
                for (int i = 0; i < line.length(); i++) {
                    char originalChar = line.charAt(i);
                    char encryptedChar = (char) (originalChar + shift);
                    encryptedChars[i] = encryptedChar;
                }

                // Записуємо зашифрований рядок у файл
                bufferedWriter.write(encryptedChars);
                bufferedWriter.newLine();
            }

            // Закриваємо потоки
            bufferedReader.close();
            bufferedWriter.close();

            System.out.println("Шифрування завершено. Зашифрований текст збережено в " + encryptedFilePath);

        } catch (IOException e) {
            System.err.println("Помилка при роботі з файлами: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}