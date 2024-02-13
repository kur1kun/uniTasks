import java.io.*;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filePath = "EncryptedText.txt";

        // Введіть кількість символів зсуву для розшифрування
        System.out.print("Введіть кількість символів зсуву для розшифрування: ");
        int shift = scanner.nextInt();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            StringBuilder decryptedContent = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // Розшифровуємо кожен символ у рядку
                char[] decryptedChars = new char[line.length()];
                for (int i = 0; i < line.length(); i++) {
                    char encryptedChar = line.charAt(i);
                    char decryptedChar = (char) (encryptedChar - shift);
                    decryptedChars[i] = decryptedChar;
                }

                // Додаємо розшифрований рядок до результуючого контенту
                decryptedContent.append(decryptedChars);
                decryptedContent.append(System.lineSeparator());
            }

            // Закриваємо потік
            bufferedReader.close();

            // Записуємо розшифрований контент назад у той самий файл
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write(decryptedContent.toString());
            bufferedWriter.close();

            System.out.println("Розшифрування завершено. Результат записано у той самий файл.");

        } catch (IOException e) {
            System.err.println("Помилка при роботі з файлами: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}