import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        String filePath = "SomeText.txt";
        String oldString = "Its iridescent tentacles shimmered with hues unseen by the human eye, reflecting the dreams of celestial beings.";
        String newString = "-- /// Connection lost /// ---";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            StringBuilder fileContent = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                fileContent.append(line).append(System.lineSeparator());
            }

            bufferedReader.close();

            String updatedContent = fileContent.toString().replace(oldString, newString);

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write(updatedContent);
            bufferedWriter.close();

            System.out.println("Заміна завершена.");
        } catch (IOException e) {
            System.err.println("Помилка при роботі з файлом: " + e.getMessage());
        }
    }
}