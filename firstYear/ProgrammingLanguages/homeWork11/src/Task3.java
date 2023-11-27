import java.io.*;

public class Task3 {
    public static void main(String[] args) {
        String sourceFilePath = "SomeText.txt";

        // Введіть шляхи до нових файлів
        String oddLinesFilePath = "task3.1.txt";
        String evenLinesFilePath = "task3.2.txt";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFilePath));
            BufferedWriter oddLinesWriter = new BufferedWriter(new FileWriter(oddLinesFilePath));
            BufferedWriter evenLinesWriter = new BufferedWriter(new FileWriter(evenLinesFilePath));

            String line;
            int lineNumber = 0;

            while ((line = bufferedReader.readLine()) != null) {
                lineNumber++;

                if (lineNumber % 2 == 0) {
                    evenLinesWriter.write(line);
                    evenLinesWriter.newLine();
                } else {
                    oddLinesWriter.write(line);
                    oddLinesWriter.newLine();
                }
            }

            bufferedReader.close();
            oddLinesWriter.close();
            evenLinesWriter.close();

            System.out.println("Розділення завершено.");

        } catch (IOException e) {
            System.err.println("Помилка при роботі з файлами: " + e.getMessage());
        }
    }
}
