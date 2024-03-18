import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Pattern;

public class Markov {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Print a ruleset number:");
//        System.out.println(" 1 - divide3Quotient");
//        System.out.println(" 2 - transferIn10");

        int choice = sc.nextInt();
        sc.nextLine();
        String sourceFileName = "";
        switch (choice){
            case 1:{
                sourceFileName = "rules/divide3Quotient.txt";
                break;
            }
            case 2:{
                sourceFileName = "rules/transferIn10.txt";
                break;
            }
        }
        String[][] rules = readRules(sourceFileName);

//        System.out.println("Print your line:");
        String test = sc.nextLine().trim();
        boolean flag = false;

        while(!flag){
            for (String[] row : rules) {
                if(test.contains(row[0])){
                    if(row[1].endsWith(".")){
                        row[1] = row[1].substring(0, row[1].length() - 1);
                        flag = true;
                    }
                    test = test.replaceFirst(Pattern.quote(row[0]),row[1]);
                    //System.out.println(test);
                    break;
                }
            }
        }
        System.out.println(test);
    }

    private static String[][] readRules(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
        String[][] result = new String[lines.size()][2];
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(" -> ");
            if (parts.length == 2) {
                result[i][0] = parts[0];
                result[i][1] = parts[1];
            } else {
                result[i][0] = parts[0];
                result[i][1] = "";
            }
        }
        return result;
    }
}